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
import de.audi.app.media.source.state.providers.WLANState;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.interapp.WlanService;
import java.util.ArrayList;
import java.util.List;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class WLANSource
extends AbstractMediaSource
implements ButtonListener {
    private static final String LOGCLASS = "WLANSource";
    private final int AUDIO_CONNECTION;
    private final IServiceTracker wlanServiceTracker;
    private int clampSState = 0;
    private volatile WlanService wlanService;
    private MediaSourceSlot originalWLANSourceSlot = null;
    private volatile WLANState wlanState = null;
    private volatile boolean deviceConnected = false;
    private volatile boolean sdisConnected = false;
    private final boolean sdisEnabledByCoding;
    static /* synthetic */ Class class$de$audi$atip$interapp$WlanService;

    public WLANSource(IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController) {
        super(iMediaTerminal, iMediaDSIPlayerController, 12, "WLAN");
        switch (this.getTerminal().getTerminalID()) {
            case 3: 
            case 4: {
                this.AUDIO_CONNECTION = 0;
                break;
            }
            default: {
                this.AUDIO_CONNECTION = 20;
            }
        }
        this.wlanServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$WlanService == null ? (class$de$audi$atip$interapp$WlanService = WLANSource.class$("de.audi.atip.interapp.WlanService")) : class$de$audi$atip$interapp$WlanService, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                WLANSource.this.logger.main().log(1000000, "[%1.removedService] WLAN service removed.", (Object)WLANSource.LOGCLASS);
                WLANSource.this.getTerminal().getServiceManager().releaseService(serviceReference);
                WLANSource.this.wlanService = null;
                WLANSource.this.wlanState = null;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public Object addingService(ServiceReference serviceReference) {
                WlanService wlanService = (WlanService)WLANSource.this.getTerminal().getServiceManager().getService(serviceReference);
                WLANSource.this.logger.main().log(1000000, "[%1.addingService] WLAN service found.", (Object)WLANSource.LOGCLASS);
                WLANSource.this.wlanService = wlanService;
                return WLANSource.this.wlanService;
            }
        });
        this.originalWLANSourceSlot = (MediaSourceSlot)this.getDefaultSlot();
        this.addUpdateType(4);
        this.addUpdateType(3);
        this.addUpdateType(14);
        this.addUpdateType(16);
        this.sdisEnabledByCoding = this.getTerminal().getFramework().isSDISEnabled();
    }

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.getButtonModel(200578).setButtonListener(this);
        this.wlanServiceTracker.open();
    }

    public void deinit() {
        super.deinit();
        this.logger.main().log(1000000, "[%1.deinit] Deinit.", (Object)LOGCLASS);
        this.getButtonModel(200578).setButtonListener(null);
        this.wlanServiceTracker.close();
    }

    public int getAudioConnection(ISourceSlot iSourceSlot) {
        return this.AUDIO_CONNECTION;
    }

    private ISourceSlot getDefaultSlot() {
        return new MediaSourceSlot(this, 0, 0, 0, -1L, -1L, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, 0, -1, "");
    }

    private boolean updateWLANSlotState() {
        if (this.wlanState == null && !this.getTerminal().getConfiguration().isWLANStateSynchronizationDisabled()) {
            this.logger.main().log(1000000, "[%1.updateWLANSlotState] No WLAN state.", (Object)LOGCLASS);
            return false;
        }
        ArrayList arrayList = new ArrayList(1);
        if (this.clampSState == 0 || this.clampSState == 1) {
            this.logger.main().log(1000000, "[%1.updateWLANSlotState] CLAMP OFF", (Object)LOGCLASS);
            if (this.clampSState == 1 && this.sdisEnabledByCoding) {
                this.logger.main().log(1000000, "[%1.updateWLANSlotState] SDIS enabled. Do not change current state.", (Object)LOGCLASS);
                this.updateAdditionalWLANSlotState(arrayList);
            } else {
                arrayList.add(new MediaSourceSlot(this, 3, 0, 0, -1L, -1L, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, 20, -1, ""));
            }
        } else {
            this.updateAdditionalWLANSlotState(arrayList);
        }
        this.slotInfoList = arrayList;
        return true;
    }

    private void updateAdditionalWLANSlotState(List list) {
        if (this.wlanState != null && !this.wlanState.isEnabled()) {
            this.logger.main().log(1000000, "[%1.updateWLANSlotState] DEACTIVATED", (Object)LOGCLASS);
            list.add(new MediaSourceSlot(this, 3, 0, 0, -1L, -1L, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, 21, -1, ""));
        } else if (this.originalWLANSourceSlot.isEmpty()) {
            this.logger.main().log(1000000, "[%1.updateWLANSlotState] EMPTY (deviceConnected=%2)", (Object)LOGCLASS, (Object)Boolean.toString(this.deviceConnected));
            if (!this.deviceConnected) {
                list.add(new MediaSourceSlot(this, 3, 0, 0, -1L, -1L, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, 29, -1, ""));
            } else {
                list.add(new MediaSourceSlot(this, 3, 0, 0, -1L, -1L, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, 30, -1, ""));
            }
        } else {
            list.add(this.originalWLANSourceSlot);
        }
    }

    public void activateWLAN() {
        this.logger.main().log(1000000, "[%1.activateWLAN] Activate WLAN.", (Object)LOGCLASS);
        WlanService wlanService = this.wlanService;
        if (wlanService == null) {
            this.logger.main().log(100000, "[%1.activateWLAN] WLAN service not available.", (Object)LOGCLASS);
            return;
        }
        wlanService.switchWlanState(true);
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200578: {
                this.logger.hmi().log(1000000, "[%1.keyTyped] WLAN activate button typed.", (Object)LOGCLASS);
                this.activateWLAN();
                this.getModel(200578).fireEvent(0);
                break;
            }
            default: {
                this.logger.hmi().log(100000, "[%1.keyTyped] Received unexpected key-typed event for model '%2'.", (Object)LOGCLASS, (long)n);
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public boolean processSourceStateUpdate(SourceStateUpdate sourceStateUpdate) {
        switch (sourceStateUpdate.getType()) {
            case 4: {
                this.wlanState = (WLANState)sourceStateUpdate.getUpdate();
                this.logger.main().log(1000000, "[%1.processSourceStateUpdate] UPDATE_TYPE_WLAN ('%2')", (Object)LOGCLASS, (Object)this.wlanState);
                return this.updateWLANSlotState();
            }
            case 3: {
                boolean bl = (Boolean)sourceStateUpdate.getUpdate();
                this.logger.main().log(1000000, "[%2.processSourceStateUpdate] UPDATE_TYPE_POWER_CLAMP_S (clampS='%1')", bl, (Object)LOGCLASS);
                this.clampSState = bl ? 2 : 1;
                return this.updateWLANSlotState();
            }
            case 1: {
                this.logger.main().log(1000000, "[%1.processSourceStateUpdate] UPDATE_TYPE_SLOTS_LIST", (Object)LOGCLASS);
                List list = (List)sourceStateUpdate.getUpdate();
                this.originalWLANSourceSlot = list.isEmpty() ? (MediaSourceSlot)this.getDefaultSlot() : new MediaSourceSlot(this, (MediaSlot)list.get(0));
                return this.updateWLANSlotState();
            }
            case 14: {
                this.logger.main().log(1000000, "[%1.processSourceStateUpdate] UPDATE_TYPE_WLAN_DEVICE_CONNECTED", (Object)LOGCLASS);
                boolean bl = (Boolean)sourceStateUpdate.getUpdate();
                if (bl != this.deviceConnected) {
                    this.deviceConnected = bl;
                    this.logger.main().log(1000000, "[%2.processSourceStateUpdate] UPDATE_TYPE_WLAN_DEVICE_CONNECTED ('%1')", this.deviceConnected, (Object)LOGCLASS);
                    return this.updateWLANSlotState();
                }
                return false;
            }
            case 16: {
                this.logger.main().log(1000000, "[%1.processSourceStateUpdate] UPDATE_TYPE_SDIS_CONNECTED", (Object)LOGCLASS);
                boolean bl = (Boolean)sourceStateUpdate.getUpdate();
                if (bl != this.sdisConnected) {
                    this.sdisConnected = bl;
                    this.logger.main().log(1000000, "[%2.processSourceStateUpdate] UPDATE_TYPE_SDIS_CONNECTED ('%1')", this.sdisConnected, (Object)LOGCLASS);
                    return this.updateWLANSlotState();
                }
                return false;
            }
        }
        return super.processSourceStateUpdate(sourceStateUpdate);
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

