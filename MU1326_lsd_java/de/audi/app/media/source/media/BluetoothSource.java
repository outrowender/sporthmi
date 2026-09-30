/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.app.media.source.MediaFlags;
import de.audi.app.media.source.MediaSlot;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.source.media.AbstractMediaSource;
import de.audi.app.media.source.state.SourceStateUpdate;
import de.audi.app.media.source.state.providers.BluetoothState;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.interapp.IBluetoothService;
import java.util.ArrayList;
import java.util.List;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class BluetoothSource
extends AbstractMediaSource
implements ButtonListener {
    private static final String LOGCLASS = "BluetoothSource";
    private final int AUDIO_CONNECTION;
    private final IServiceTracker bluetoothServiceTracker;
    private volatile IBluetoothService btService;
    private int clampSState = 0;
    private volatile BluetoothState btState = null;
    private MediaSourceSlot originalBTSourceSlot = null;
    static /* synthetic */ Class class$de$audi$atip$interapp$IBluetoothService;

    public BluetoothSource(IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController) {
        super(iMediaTerminal, iMediaDSIPlayerController, 11, "BLUETOOTH");
        switch (this.getTerminal().getTerminalID()) {
            case 3: 
            case 4: {
                this.AUDIO_CONNECTION = 0;
                break;
            }
            default: {
                this.AUDIO_CONNECTION = 21;
            }
        }
        this.originalBTSourceSlot = (MediaSourceSlot)this.getDefaultSlot();
        this.bluetoothServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$IBluetoothService == null ? (class$de$audi$atip$interapp$IBluetoothService = BluetoothSource.class$("de.audi.atip.interapp.IBluetoothService")) : class$de$audi$atip$interapp$IBluetoothService, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                BluetoothSource.this.logger.main().log(1000000, "[%1.removedService] Bluetooth service removed.", (Object)BluetoothSource.LOGCLASS);
                BluetoothSource.this.getTerminal().getServiceManager().releaseService(serviceReference);
                BluetoothSource.this.btService = null;
                BluetoothSource.this.btState = null;
            }

            public Object addingService(ServiceReference serviceReference) {
                IBluetoothService iBluetoothService = (IBluetoothService)BluetoothSource.this.getTerminal().getServiceManager().getService(serviceReference);
                BluetoothSource.this.logger.main().log(1000000, "[%1.addingService] '%2'.", (Object)BluetoothSource.LOGCLASS, (Object)iBluetoothService);
                BluetoothSource.this.btService = iBluetoothService;
                return iBluetoothService;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }
        });
        this.addUpdateType(5);
        this.addUpdateType(7);
        this.addUpdateType(6);
        this.addUpdateType(3);
    }

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.getButtonModel(200541).setButtonListener(this);
        this.getButtonModel(200539).setButtonListener(this);
        this.getButtonModel(200540).setButtonListener(this);
        this.bluetoothServiceTracker.open();
    }

    public void deinit() {
        super.deinit();
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.bluetoothServiceTracker.close();
    }

    private ISourceSlot getDefaultSlot() {
        return new MediaSourceSlot(this, 1, 0, 0, -1L, -1L, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, 0, -1, "");
    }

    public int getAudioConnection(ISourceSlot iSourceSlot) {
        return this.AUDIO_CONNECTION;
    }

    public boolean activateBluetooth() {
        this.logger.main().log(1000000, "[%1.activateBluetooth]", (Object)LOGCLASS);
        IBluetoothService iBluetoothService = this.btService;
        if (iBluetoothService == null) {
            this.logger.main().log(100000, "[%1.activateBluetooth] BT Service not available.", (Object)LOGCLASS);
            return false;
        }
        iBluetoothService.activateBluetooth();
        return true;
    }

    private boolean searchForAudioPlayers() {
        this.logger.main().log(1000000, "[%1.searchForAudioPlayers] Search BT media player.", (Object)LOGCLASS);
        IBluetoothService iBluetoothService = this.btService;
        if (iBluetoothService == null) {
            this.logger.main().log(100000, "[%1.searchForAudioPlayers] BT Service not available.", (Object)LOGCLASS);
            return false;
        }
        return true;
    }

    public boolean activateAudioPlayer() {
        this.logger.main().log(1000000, "[%1.activateAudioPlayer] Activate bluetooth audio player.", (Object)LOGCLASS);
        IBluetoothService iBluetoothService = this.btService;
        if (iBluetoothService == null) {
            this.logger.main().log(100000, "[%1.activateAudioPlayer] BT Service not available.", (Object)LOGCLASS);
            return false;
        }
        iBluetoothService.activateBluetoothAudio();
        return true;
    }

    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200541: {
                this.logger.hmi().log(1000000, "[%1.keyTyped] BT_SEARCH button typed.", (Object)LOGCLASS);
                this.searchForAudioPlayers();
                this.logger.hmi().log(1000000, "[%1.keyTyped] Trigger event of BT search button.", (Object)LOGCLASS);
                this.getModel(200541).fireEvent(n3);
                break;
            }
            case 200539: {
                this.logger.hmi().log(1000000, "[%1.keyTyped] BT_ACTIVATE button typed.", (Object)LOGCLASS);
                if (!this.activateBluetooth() || !this.activateAudioPlayer()) break;
                this.logger.hmi().log(1000000, "[%1.keyTyped] Trigger event of BT activate button.", (Object)LOGCLASS);
                this.getModel(200539).setStatus(0);
                this.getModel(200539).fireEvent(n3);
                break;
            }
            case 200540: {
                this.logger.hmi().log(1000000, "[%1.keyTyped] BT_AUDIOPLAYER_ACTIVATE button typed.", (Object)LOGCLASS);
                if (!this.activateAudioPlayer()) break;
                this.logger.hmi().log(1000000, "[%1.keyTyped] Trigger event of BT activate button.", (Object)LOGCLASS);
                this.getModel(200540).setStatus(0);
                this.getModel(200540).fireEvent(n3);
                break;
            }
            default: {
                this.logger.hmi().log(100000, "[%1.keyTyped] Received unexpected key-typed event for model '%2'", (Object)LOGCLASS, (long)n);
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public boolean processSourceStateUpdate(SourceStateUpdate sourceStateUpdate) {
        switch (sourceStateUpdate.getType()) {
            case 5: {
                this.btState = (BluetoothState)sourceStateUpdate.getUpdate();
                this.logger.main().log(1000000, "[%1.processSourceStateUpdate] UPDATE_TYPE_BT_STATE ('%2')", (Object)LOGCLASS, (Object)this.btState);
                this.getModel(200539).setStatus(this.btState.getState() == 0 ? 1 : 0);
                this.getModel(200540).setStatus(this.btState.getState() == 1 ? 1 : 0);
                return this.updateBTSlotState();
            }
            case 6: {
                this.logger.main().log(1000000, "[%1.processSourceStateUpdate] UPDATE_TYPE_BT_ACTION_FINISHED", (Object)LOGCLASS);
                this.getTerminal().getAudioManager().btDemute();
                return false;
            }
            case 7: {
                this.logger.main().log(1000000, "[%1.processSourceStateUpdate] UPDATE_TYPE_BT_ACTION_STARTED", (Object)LOGCLASS);
                if (this.isActive()) {
                    this.getTerminal().getAudioManager().btMute();
                }
                return false;
            }
            case 3: {
                this.clampSState = (Boolean)sourceStateUpdate.getUpdate() != false ? 2 : 1;
                this.logger.main().log(1000000, "[%1.processSourceStateUpdate] UPDATE_TYPE_POWER_CLAMP_S (clampS='%2')", (Object)LOGCLASS, (long)this.clampSState);
                return this.updateBTSlotState();
            }
            case 1: {
                this.logger.main().log(10000000, "[%1.processSourceStateUpdate] UPDATE_TYPE_SLOTS_LIST", (Object)LOGCLASS);
                List list = (List)sourceStateUpdate.getUpdate();
                this.originalBTSourceSlot = list.isEmpty() ? (MediaSourceSlot)this.getDefaultSlot() : new MediaSourceSlot(this, (MediaSlot)list.get(0));
                return this.updateBTSlotState();
            }
        }
        return super.processSourceStateUpdate(sourceStateUpdate);
    }

    private boolean updateBTSlotState() {
        if (this.btState == null) {
            this.logger.main().log(1000000, "[%1.updateBTSlotState] No BT state.", (Object)LOGCLASS);
            return false;
        }
        ArrayList arrayList = new ArrayList(1);
        if (this.clampSState == 0 || this.clampSState == 1) {
            this.logger.main().log(1000000, "[%1.updateBTSlotState] CLAMP OFF", (Object)LOGCLASS);
            arrayList.add(new MediaSourceSlot(this, 3, 0, 0, -1L, -1L, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, 13, -1, ""));
            this.slotInfoList = arrayList;
            return true;
        }
        this.logger.main().log(1000000, "[%1.updateBTSlotState] '%2'", (Object)LOGCLASS, (Object)this.btState);
        switch (this.btState.getState()) {
            case 0: {
                arrayList.add(new MediaSourceSlot(this, 3, 0, 0, -1L, -1L, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, 12, -1, ""));
                break;
            }
            case 1: {
                arrayList.add(new MediaSourceSlot(this, 3, 0, 0, -1L, -1L, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, 10, -1, ""));
                break;
            }
            case 3: {
                arrayList.add(new MediaSourceSlot(this, 3, 0, 0, -1L, -1L, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, 14, -1, ""));
                break;
            }
            case 2: {
                arrayList.add(new MediaSourceSlot(this, 3, 0, 0, -1L, -1L, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, 11, -1, ""));
                break;
            }
            case 4: {
                if (this.originalBTSourceSlot.isEmpty()) {
                    this.logger.main().log(10000000, "[%1.updateBTSlotState] EMPTY -> RECONNECTING", (Object)LOGCLASS);
                    arrayList.add(new MediaSourceSlot(this, 3, 0, 0, -1L, -1L, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, 14, -1, ""));
                    break;
                }
                arrayList.add(this.originalBTSourceSlot);
                break;
            }
        }
        this.slotInfoList = arrayList;
        return true;
    }

    public boolean disabledAudioPlayer() {
        this.logger.main().log(1000000, "[%1.disabledAudioPlayer]", (Object)LOGCLASS);
        IBluetoothService iBluetoothService = this.btService;
        if (iBluetoothService == null) {
            this.logger.main().log(100000, "[%1.disabledAudioPlayer] BT Service not available.", (Object)LOGCLASS);
            return false;
        }
        iBluetoothService.deactivateBluetoothAudio();
        return true;
    }

    public boolean disconnectAudioPlayer() {
        this.logger.main().log(1000000, "[%1.disconnectAudioPlayer]", (Object)LOGCLASS);
        IBluetoothService iBluetoothService = this.btService;
        if (iBluetoothService == null) {
            this.logger.main().log(100000, "[%1.disconnectAudioPlayer] BT Service not available.", (Object)LOGCLASS);
            return false;
        }
        iBluetoothService.disconnectService(this.originalBTSourceSlot.getUniqueMediaId(), 65536);
        return true;
    }

    public void deactivate(boolean bl) {
        if (this.getTerminal().getAudioManager().isBtMuted()) {
            this.getTerminal().getAudioManager().btDemute();
        }
        super.deactivate(bl);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

