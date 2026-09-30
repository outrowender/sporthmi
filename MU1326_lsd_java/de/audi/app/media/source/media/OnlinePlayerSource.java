/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.app.media.source.MediaFlags;
import de.audi.app.media.source.MediaSlot;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.source.media.AbstractMediaSource;
import de.audi.app.media.source.media.OnlinePlayerSourceSlot;
import de.audi.app.media.source.state.SourceStateUpdate;
import de.audi.app.media.source.state.providers.WLANState;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.online.OnlineApplicationOtherContext;
import de.audi.atip.interapp.online.OnlineServiceProvider;
import java.util.Iterator;
import java.util.List;

public class OnlinePlayerSource
extends AbstractMediaSource {
    private static final String LOGCLASS = "OnlinePlayerSource";
    private static final int INVALID_SLOTINDEX = -1;
    private static final int DEFAULT_SLOT_INDEX = 0;
    private MediaSlot onlinePlayerSlot;
    private List onlineServiceList;
    private OnlineServiceProvider remoteHMIService;
    private String lastStartedAppContext;
    private WLANState wlanState;
    private int clampState = 0;
    private int lastServiceIndex;
    private boolean deviceAppStarted = false;
    private boolean deviceConnected = false;
    private boolean sdisConnected = false;
    private final boolean sdisEnabledByCoding;

    public OnlinePlayerSource(IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController) {
        super(iMediaTerminal, iMediaDSIPlayerController, 13, "ONLINEPLAYER");
        this.addUpdateType(8);
        this.addUpdateType(9);
        this.addUpdateType(4);
        this.addUpdateType(3);
        this.addUpdateType(11);
        this.addUpdateType(13);
        this.addUpdateType(14);
        this.addUpdateType(16);
        this.lastServiceIndex = -1;
        this.sdisEnabledByCoding = this.getTerminal().getFramework().isSDISEnabled();
    }

    public void activate(ISourceSlot iSourceSlot) {
        MediaSourceSlot mediaSourceSlot = (MediaSourceSlot)iSourceSlot;
        this.logger.main().log(1000000, "[%1.activate] [%2] slotIdx='%3'", (Object)LOGCLASS, (Object)this, (long)mediaSourceSlot.getIndex());
        if (this.getActiveState() == 2) {
            this.logger.main().log(1000000, "[%1.activate] [%2] Player already active.", (Object)LOGCLASS, (Object)this);
            this.startService(mediaSourceSlot.getMountPoint());
            this.lastServiceIndex = mediaSourceSlot.getIndex();
            return;
        }
        if (this.isActivateable(mediaSourceSlot)) {
            this.dsiPlayerController.activate(mediaSourceSlot.getDeviceID(), mediaSourceSlot.getMediaID());
            this.setActiveState(2);
            this.stopLastService();
            this.startService(mediaSourceSlot.getMountPoint());
            this.lastServiceIndex = mediaSourceSlot.getIndex();
        } else {
            this.logger.main().log(1000000, "[%1.activate] [%2] Device not activateable.", (Object)LOGCLASS, (Object)this);
            this.setActiveState(1);
        }
    }

    public void deactivate(boolean bl) {
        super.deactivate(bl);
        this.stopLastService();
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        super.deinit();
    }

    private void startService(String string) {
        Boolean bl = (Boolean)this.getTerminal().getSourceController().getActivationContext().getParameter("IS_STARTUP");
        this.logger.main().log(1000000, "[%1.startService] [%2] '%3' isStartup: %4", (Object)LOGCLASS, (Object)this, (Object)string, (Object)bl);
        this.remoteHMIService.startMediaApp(string, bl);
        this.lastStartedAppContext = string;
    }

    private void stopLastService() {
        if (this.lastStartedAppContext == null) {
            return;
        }
        this.logger.main().log(1000000, "[%1.stopLastService] [%2] '%3'", (Object)LOGCLASS, (Object)this, (Object)this.lastStartedAppContext);
        if (this.remoteHMIService != null) {
            this.remoteHMIService.stopMediaApp(this.lastStartedAppContext);
        }
        this.lastStartedAppContext = null;
    }

    public boolean pausePlaybackOnDeactivation() {
        return false;
    }

    public int getAudioConnection(ISourceSlot iSourceSlot) {
        return 0;
    }

    private boolean updateOnlineSlotList() {
        ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getSelectedSlot();
        if (this.onlinePlayerSlot == null) {
            this.logger.main().log(100000, "[%1.updateOnlineSlotList] No online player slot known!", (Object)LOGCLASS);
            return false;
        }
        this.slotInfoList.clear();
        if (this.remoteHMIService == null) {
            this.logger.main().log(1000000, "[%1.updateOnlineSlotList] No remote HMI service.", (Object)LOGCLASS);
            this.addErrorSlot(iSourceSlot, 27);
            return true;
        }
        if (this.onlinePlayerSlot.isEmpty()) {
            this.logger.main().log(1000000, "[%1.updateOnlineSlotList] Player is empty.", (Object)LOGCLASS);
            this.addErrorSlot(iSourceSlot, 27);
            return true;
        }
        if (this.onlinePlayerSlot.isLoading()) {
            this.logger.main().log(1000000, "[%1.updateOnlineSlotList] Player is loading.", (Object)LOGCLASS);
            this.slotInfoList.add(new MediaSourceSlot(this, 1, 0, 0, -1L, -1L, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, 0, -1, ""));
            return true;
        }
        if (this.clampState == 0 || this.clampState == 1) {
            this.logger.main().log(1000000, "[%1.updateOnlineSlotList] ignition off.", (Object)LOGCLASS);
            if (this.clampState == 1 && this.sdisEnabledByCoding) {
                this.logger.main().log(1000000, "[%1.updateOnlineSlotList] SDIS enabled. Do not change current state.", (Object)LOGCLASS);
            } else {
                this.addErrorSlot(iSourceSlot, 25);
                return true;
            }
        }
        if (this.wlanState == null || !this.wlanState.isEnabled()) {
            this.logger.main().log(1000000, "[%1.updateOnlineSlotList] wlan off.", (Object)LOGCLASS);
            this.addErrorSlot(iSourceSlot, 26);
            return true;
        }
        if (!this.deviceConnected && !this.isInTetheringMode()) {
            this.logger.main().log(1000000, "[%1.updateOnlineSlotList] No device connected (tethering: %2).", (Object)LOGCLASS, (Object)String.valueOf(this.isInTetheringMode()));
            this.addErrorSlot(iSourceSlot, 27);
            return true;
        }
        this.logger.main().log(10000000, "[%1.updateOnlineSlotList] Device connected (tethering: %2).", (Object)LOGCLASS, (Object)String.valueOf(this.isInTetheringMode()));
        this.deviceConnected = true;
        if (!this.deviceAppStarted) {
            this.logger.main().log(1000000, "[%1.updateOnlineSlotList] App not started.", (Object)LOGCLASS);
            this.addErrorSlot(iSourceSlot, 28);
            return true;
        }
        if (null == this.onlineServiceList) {
            this.logger.main().log(1000000, "[%1.updateOnlineSlotList] Service list is null!", (Object)LOGCLASS);
            this.addErrorSlot(iSourceSlot, 28);
            return true;
        }
        int n = 0;
        Iterator iterator = this.onlineServiceList.iterator();
        while (iterator.hasNext()) {
            OnlineApplicationOtherContext onlineApplicationOtherContext = (OnlineApplicationOtherContext)iterator.next();
            if (onlineApplicationOtherContext == null) {
                this.logger.main().log(1000000, "[%1.updateOnlineSlotList] service disappeared: %2 .", (Object)LOGCLASS, (long)n);
                this.slotInfoList.add(this.getDefaultEmptySlot(n));
            } else {
                this.slotInfoList.add(new OnlinePlayerSourceSlot(this, n, this.onlinePlayerSlot, onlineApplicationOtherContext.isEnabled() ? 0 : 15, onlineApplicationOtherContext.getAppName(), onlineApplicationOtherContext.getAppContext(), onlineApplicationOtherContext.getSourceListIconActive(), onlineApplicationOtherContext.getSourceListIconReflection(), onlineApplicationOtherContext.getSourceListIconInactive(), onlineApplicationOtherContext.getCaptionIcon(), onlineApplicationOtherContext.getLoadingIcon(), onlineApplicationOtherContext.getEntryPointId()));
            }
            ++n;
        }
        if (this.isEmpty()) {
            this.logger.main().log(1000000, "[%1.updateOnlineSlotList] No services available.", (Object)LOGCLASS);
            this.addErrorSlot(iSourceSlot, 28);
            this.logger.main().log(1000000, "[%1.updateOnlineSlotList slotInfoList is empty errorslot: %2]", (Object)LOGCLASS, this.slotInfoList.get(0));
            return true;
        }
        this.logger.main().log(1000000, "[%1.updateOnlineSlotList] referring from re-setting the onlineServiceList; the left drawer should still contain valid online media sources", (Object)LOGCLASS);
        if (this.lastServiceIndex == -1) {
            this.logger.main().log(1000000, "[%1.updateOnlineSlotList]  no lastmode defined set first service", (Object)LOGCLASS);
            this.lastServiceIndex = ((ISourceSlot)this.slotInfoList.get(0)).getIndex();
        }
        return true;
    }

    private boolean isDeviceConnected(boolean bl) {
        boolean bl2 = this.isInTetheringMode();
        this.logger.hmi().log(1000000, "[%1.isDeviceConnected] clients connected: %2; tethering: %3", (Object)LOGCLASS, (Object)String.valueOf(bl), (Object)String.valueOf(bl2));
        return bl || bl2;
    }

    private boolean isInTetheringMode() {
        ChoiceModelApp choiceModelApp = this.getChoiceModel(2500224);
        boolean bl = null != choiceModelApp && choiceModelApp.getValue() == 1;
        return bl;
    }

    public boolean processSourceStateUpdate(SourceStateUpdate sourceStateUpdate) {
        boolean bl;
        switch (sourceStateUpdate.getType()) {
            case 1: {
                this.logger.main().log(1000000, "[%1.processSourceStateUpdate] UPDATE_TYPE_SLOTS_LIST", (Object)LOGCLASS);
                List list = (List)sourceStateUpdate.getUpdate();
                this.onlinePlayerSlot = list.isEmpty() ? null : (MediaSlot)list.get(0);
                bl = this.updateOnlineSlotList();
                break;
            }
            case 8: {
                this.logger.main().log(1000000, "[%1.processSourceStateUpdate] UPDATE_TYPE_ONLINE_SERVICES", (Object)LOGCLASS);
                this.onlineServiceList = (List)sourceStateUpdate.getUpdate();
                bl = this.updateOnlineSlotList();
                break;
            }
            case 9: {
                this.logger.main().log(1000000, "[%1.processSourceStateUpdate] UPDATE_TYPE_ONLINE_INTERAPP_SERVICE", (Object)LOGCLASS);
                this.remoteHMIService = (OnlineServiceProvider)sourceStateUpdate.getUpdate();
                bl = this.updateOnlineSlotList();
                break;
            }
            case 3: {
                boolean bl2 = (Boolean)sourceStateUpdate.getUpdate();
                this.logger.main().log(1000000, "[%2.processSourceStateUpdate] UPDATE_TYPE_POWER_CLAMP_S (clampS='%1')", bl2, (Object)LOGCLASS);
                this.clampState = bl2 ? 2 : 1;
                bl = this.updateOnlineSlotList();
                break;
            }
            case 4: {
                this.wlanState = (WLANState)sourceStateUpdate.getUpdate();
                this.logger.main().log(1000000, "[%1.processSourceStateUpdate] UPDATE_TYPE_WLAN ('%2')", (Object)LOGCLASS, (Object)this.wlanState);
                bl = this.updateOnlineSlotList();
                break;
            }
            case 14: {
                boolean bl3 = (Boolean)sourceStateUpdate.getUpdate();
                boolean bl4 = this.isDeviceConnected(bl3);
                if (bl4 != this.deviceConnected) {
                    this.deviceConnected = bl4;
                    this.logger.main().log(1000000, "[%2.processSourceStateUpdate] UPDATE_TYPE_WLAN_DEVICE_CONNECTED ('%1')", this.deviceConnected, (Object)LOGCLASS);
                    bl = this.updateOnlineSlotList();
                    break;
                }
                bl = false;
                break;
            }
            case 13: {
                boolean bl5 = (Boolean)sourceStateUpdate.getUpdate();
                if (bl5 != this.deviceAppStarted) {
                    this.deviceAppStarted = bl5;
                    this.logger.main().log(1000000, "[%2.processSourceStateUpdate] UPDATE_TYPE_ONLINE_DEVICE_APP_STARTED ('%1')", this.deviceAppStarted, (Object)LOGCLASS);
                    bl = this.updateOnlineSlotList();
                    break;
                }
                bl = false;
                break;
            }
            case 11: {
                this.lastServiceIndex = (Integer)sourceStateUpdate.getUpdate();
                this.logger.main().log(1000000, "[%1.processSourceStateUpdate] UPDATE_TYPE_ONLINE_LASTMODE ('%2')", (Object)LOGCLASS, (long)this.lastServiceIndex);
                bl = false;
                break;
            }
            case 16: {
                boolean bl6 = (Boolean)sourceStateUpdate.getUpdate();
                if (bl6 != this.sdisConnected) {
                    this.sdisConnected = bl6;
                    this.logger.main().log(1000000, "[%2.processSourceStateUpdate] UPDATE_TYPE_SDIS_CONNECTED ('%1')", this.sdisConnected, (Object)LOGCLASS);
                    bl = this.updateOnlineSlotList();
                    break;
                }
                bl = false;
                break;
            }
            default: {
                bl = super.processSourceStateUpdate(sourceStateUpdate);
            }
        }
        return bl;
    }

    private void addErrorSlot(ISourceSlot iSourceSlot, int n) {
        if (n != 25 || this.slotInfoList.isEmpty()) {
            this.lastServiceIndex = 0;
        }
        if (null == iSourceSlot) {
            this.logger.main().log(1000000, "[%1.getSlotForErrorMessage] currentActiveSlot is null", (Object)LOGCLASS);
            this.slotInfoList.add(this.lastServiceIndex, new OnlinePlayerSourceSlot(this, this.lastServiceIndex, this.onlinePlayerSlot, n, "", "", "", "", "", "", "", 0));
        } else if (iSourceSlot.getSource() == this) {
            this.logger.main().log(1000000, "[%1.getSlotForErrorMessage] currentSource is OnlineSource", (Object)LOGCLASS);
            this.slotInfoList.add(this.lastServiceIndex, new MediaSourceSlot(this, 3, this.lastServiceIndex, iSourceSlot.getMediaType(), this.onlinePlayerSlot.getDeviceID(), this.onlinePlayerSlot.getMediaID(), iSourceSlot.getName(), iSourceSlot.getMountPoint(), MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, n, iSourceSlot.getDeviceIndex(), this.onlinePlayerSlot.getUniqueMediaId()));
        } else {
            this.logger.main().log(1000000, "[%1.getSlotForErrorMessage] currentSource is not OnlineSource", (Object)LOGCLASS);
            this.slotInfoList.add(this.lastServiceIndex, new OnlinePlayerSourceSlot(this, this.lastServiceIndex, this.onlinePlayerSlot, n, "", "", "", "", "", "", "", 0));
        }
    }

    public boolean isLastSelectedSlot(ISourceSlot iSourceSlot) {
        return this.lastServiceIndex == iSourceSlot.getIndex();
    }

    public ISourceSlot getActivatableSlot(ISourceSlot iSourceSlot) {
        this.logger.main().log(1000000, "[%1.getActivatableSlot] slot='%2' lastServiceIndex='%3'", (Object)LOGCLASS, (Object)iSourceSlot, (long)this.lastServiceIndex);
        ISourceSlot iSourceSlot2 = this.getTerminal().getSourceController().getSelectedSlot();
        if (iSourceSlot2.getSource() == this && !iSourceSlot2.isEmpty() && iSourceSlot2.getError() == 0 && this.getActiveState() == 2) {
            this.logger.main().log(1000000, "[%1.getActivatableSlot] online service is currently active use selectedSource", (Object)LOGCLASS);
            return iSourceSlot2;
        }
        return this.getSlot(this.lastServiceIndex);
    }

    public int getNumberOfSlots() {
        return this.getSlots().size();
    }
}

