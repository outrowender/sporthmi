/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.app.media.source.MediaFlags;
import de.audi.app.media.source.MediaSlot;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.source.media.AbstractMediaSource;
import de.audi.app.media.source.media.BluetoothSource$1;
import de.audi.app.media.source.state.SourceStateUpdate;
import de.audi.app.media.source.state.providers.BluetoothState;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.interapp.IBluetoothService;
import java.util.ArrayList;
import java.util.List;

public class BluetoothSource
extends AbstractMediaSource
implements ButtonListener {
    private static final String LOGCLASS;
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
        this.bluetoothServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$IBluetoothService == null ? (class$de$audi$atip$interapp$IBluetoothService = BluetoothSource.class$("de.audi.atip.interapp.IBluetoothService")) : class$de$audi$atip$interapp$IBluetoothService, new BluetoothSource$1(this));
        this.addUpdateType(5);
        this.addUpdateType(7);
        this.addUpdateType(6);
        this.addUpdateType(3);
    }

    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"BluetoothSource");
        this.getButtonModel(1561264896).setButtonListener(this);
        this.getButtonModel(1527710464).setButtonListener(this);
        this.getButtonModel(1544487680).setButtonListener(this);
        this.bluetoothServiceTracker.open();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"BluetoothSource");
        this.bluetoothServiceTracker.close();
    }

    private ISourceSlot getDefaultSlot() {
        return new MediaSourceSlot(this, 1, 0, 0, -1L, -1L, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, 0, -1, "");
    }

    @Override
    public int getAudioConnection(ISourceSlot iSourceSlot) {
        return this.AUDIO_CONNECTION;
    }

    public boolean activateBluetooth() {
        this.logger.main().log(1078071040, "[%1.activateBluetooth]", (Object)"BluetoothSource");
        IBluetoothService iBluetoothService = this.btService;
        if (iBluetoothService == null) {
            this.logger.main().log(-1601830656, "[%1.activateBluetooth] BT Service not available.", (Object)"BluetoothSource");
            return false;
        }
        iBluetoothService.activateBluetooth();
        return true;
    }

    private boolean searchForAudioPlayers() {
        this.logger.main().log(1078071040, "[%1.searchForAudioPlayers] Search BT media player.", (Object)"BluetoothSource");
        IBluetoothService iBluetoothService = this.btService;
        if (iBluetoothService == null) {
            this.logger.main().log(-1601830656, "[%1.searchForAudioPlayers] BT Service not available.", (Object)"BluetoothSource");
            return false;
        }
        return true;
    }

    public boolean activateAudioPlayer() {
        this.logger.main().log(1078071040, "[%1.activateAudioPlayer] Activate bluetooth audio player.", (Object)"BluetoothSource");
        IBluetoothService iBluetoothService = this.btService;
        if (iBluetoothService == null) {
            this.logger.main().log(-1601830656, "[%1.activateAudioPlayer] BT Service not available.", (Object)"BluetoothSource");
            return false;
        }
        iBluetoothService.activateBluetoothAudio();
        return true;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200541: {
                this.logger.hmi().log(1078071040, "[%1.keyTyped] BT_SEARCH button typed.", (Object)"BluetoothSource");
                this.searchForAudioPlayers();
                this.logger.hmi().log(1078071040, "[%1.keyTyped] Trigger event of BT search button.", (Object)"BluetoothSource");
                this.getModel(1561264896).fireEvent(n3);
                break;
            }
            case 200539: {
                this.logger.hmi().log(1078071040, "[%1.keyTyped] BT_ACTIVATE button typed.", (Object)"BluetoothSource");
                if (!this.activateBluetooth() || !this.activateAudioPlayer()) break;
                this.logger.hmi().log(1078071040, "[%1.keyTyped] Trigger event of BT activate button.", (Object)"BluetoothSource");
                this.getModel(1527710464).setStatus(0);
                this.getModel(1527710464).fireEvent(n3);
                break;
            }
            case 200540: {
                this.logger.hmi().log(1078071040, "[%1.keyTyped] BT_AUDIOPLAYER_ACTIVATE button typed.", (Object)"BluetoothSource");
                if (!this.activateAudioPlayer()) break;
                this.logger.hmi().log(1078071040, "[%1.keyTyped] Trigger event of BT activate button.", (Object)"BluetoothSource");
                this.getModel(1544487680).setStatus(0);
                this.getModel(1544487680).fireEvent(n3);
                break;
            }
            default: {
                this.logger.hmi().log(-1601830656, "[%1.keyTyped] Received unexpected key-typed event for model '%2'", (Object)"BluetoothSource", (long)n);
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public boolean processSourceStateUpdate(SourceStateUpdate sourceStateUpdate) {
        switch (sourceStateUpdate.getType()) {
            case 5: {
                this.btState = (BluetoothState)sourceStateUpdate.getUpdate();
                this.logger.main().log(1078071040, "[%1.processSourceStateUpdate] UPDATE_TYPE_BT_STATE ('%2')", (Object)"BluetoothSource", (Object)this.btState);
                this.getModel(1527710464).setStatus(this.btState.getState() == 0 ? 1 : 0);
                this.getModel(1544487680).setStatus(this.btState.getState() == 1 ? 1 : 0);
                return this.updateBTSlotState();
            }
            case 6: {
                this.logger.main().log(1078071040, "[%1.processSourceStateUpdate] UPDATE_TYPE_BT_ACTION_FINISHED", (Object)"BluetoothSource");
                this.getTerminal().getAudioManager().btDemute();
                return false;
            }
            case 7: {
                this.logger.main().log(1078071040, "[%1.processSourceStateUpdate] UPDATE_TYPE_BT_ACTION_STARTED", (Object)"BluetoothSource");
                if (this.isActive()) {
                    this.getTerminal().getAudioManager().btMute();
                }
                return false;
            }
            case 3: {
                this.clampSState = (Boolean)sourceStateUpdate.getUpdate() != false ? 2 : 1;
                this.logger.main().log(1078071040, "[%1.processSourceStateUpdate] UPDATE_TYPE_POWER_CLAMP_S (clampS='%2')", (Object)"BluetoothSource", (long)this.clampSState);
                return this.updateBTSlotState();
            }
            case 1: {
                this.logger.main().log(-2137614336, "[%1.processSourceStateUpdate] UPDATE_TYPE_SLOTS_LIST", (Object)"BluetoothSource");
                List list = (List)sourceStateUpdate.getUpdate();
                this.originalBTSourceSlot = list.isEmpty() ? (MediaSourceSlot)this.getDefaultSlot() : new MediaSourceSlot(this, (MediaSlot)list.get(0));
                return this.updateBTSlotState();
            }
        }
        return super.processSourceStateUpdate(sourceStateUpdate);
    }

    private boolean updateBTSlotState() {
        if (this.btState == null) {
            this.logger.main().log(1078071040, "[%1.updateBTSlotState] No BT state.", (Object)"BluetoothSource");
            return false;
        }
        ArrayList arrayList = new ArrayList(1);
        if (this.clampSState == 0 || this.clampSState == 1) {
            this.logger.main().log(1078071040, "[%1.updateBTSlotState] CLAMP OFF", (Object)"BluetoothSource");
            arrayList.add(new MediaSourceSlot(this, 3, 0, 0, -1L, -1L, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, 13, -1, ""));
            this.slotInfoList = arrayList;
            return true;
        }
        this.logger.main().log(1078071040, "[%1.updateBTSlotState] '%2'", (Object)"BluetoothSource", (Object)this.btState);
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
                    this.logger.main().log(-2137614336, "[%1.updateBTSlotState] EMPTY -> RECONNECTING", (Object)"BluetoothSource");
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
        this.logger.main().log(1078071040, "[%1.disabledAudioPlayer]", (Object)"BluetoothSource");
        IBluetoothService iBluetoothService = this.btService;
        if (iBluetoothService == null) {
            this.logger.main().log(-1601830656, "[%1.disabledAudioPlayer] BT Service not available.", (Object)"BluetoothSource");
            return false;
        }
        iBluetoothService.deactivateBluetoothAudio();
        return true;
    }

    public boolean disconnectAudioPlayer() {
        this.logger.main().log(1078071040, "[%1.disconnectAudioPlayer]", (Object)"BluetoothSource");
        IBluetoothService iBluetoothService = this.btService;
        if (iBluetoothService == null) {
            this.logger.main().log(-1601830656, "[%1.disconnectAudioPlayer] BT Service not available.", (Object)"BluetoothSource");
            return false;
        }
        iBluetoothService.disconnectService(this.originalBTSourceSlot.getUniqueMediaId(), 256);
        return true;
    }

    @Override
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

    static /* synthetic */ IMediaLogger access$000(BluetoothSource bluetoothSource) {
        return bluetoothSource.logger;
    }

    static /* synthetic */ IBluetoothService access$102(BluetoothSource bluetoothSource, IBluetoothService iBluetoothService) {
        bluetoothSource.btService = iBluetoothService;
        return bluetoothSource.btService;
    }

    static /* synthetic */ BluetoothState access$202(BluetoothSource bluetoothSource, BluetoothState bluetoothState) {
        bluetoothSource.btState = bluetoothState;
        return bluetoothSource.btState;
    }

    static /* synthetic */ IMediaLogger access$300(BluetoothSource bluetoothSource) {
        return bluetoothSource.logger;
    }
}

