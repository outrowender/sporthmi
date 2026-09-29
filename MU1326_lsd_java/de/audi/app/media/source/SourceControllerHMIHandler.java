/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.utils.IntMap;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.content.media.utils.NoMapElementException;
import de.audi.app.media.source.ActiveSourceState;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;

public class SourceControllerHMIHandler
extends AbstractMediaTerminalComponent {
    private static final String LOGCLASS;
    static final int HMI_STATE_EMPTY;
    static final int HMI_STATE_NO_PLAYABLE_FILES;
    static final int HMI_STATE_UNREADABLE;
    static final int HMI_STATE_IMPORT_RUNNING;
    static final int HMI_STATE_WRONG_REGION_CODE_CHANGES_LEFT;
    static final int HMI_STATE_WRONG_REGION_CODE_NO_CHANGES_LEFT;
    static final int HMI_STATE_CHILDLOCK;
    static final int HMI_STATE_DELETION_RUNNING;
    static final int HMI_STATE_NOT_SUPPORTED;
    static final int HMI_STATE_OVERCURRENT;
    static final int HMI_STATE_BLUETOOTH_DEACTIVATED;
    static final int HMI_STATE_BLUETOOTH_DEACTIVATED_CLAMPS_OFF;
    static final int HMI_STATE_AUDIOPLAYER_DEACTIVATED;
    static final int HMI_STATE_BLUETOOTH_RECONNECT;
    static final int HMI_STATE_BT_AUDIOPLAYER_NOT_CONNECTED;
    static final int HMI_STATE_CHARGING;
    static final int HMI_STATE_DEVICE_NOT_AVAILABLE;
    static final int HMI_STATE_TEMPERATURE_HIGH;
    static final int HMI_STATE_TEMPERATURE_LOW;
    static final int HMI_STATE_WLAN_DEACTIVATED;
    static final int HMI_STATE_WLAN_DEACTIVATED_CLAMP_S_OFF;
    static final int HMI_STATE_ONLINE_DEACTIVATED_CLAMP_S_OFF;
    static final int HMI_STATE_ONLINE_DEACTIVATED_WLAN_OFF;
    static final int HMI_STATE_ONLINE_DEACTIVATED_WLAN_NO_CONN;
    static final int HMI_STATE_ONLINE_NO_APP;
    static final int HMI_STATE_NOT_SUPPORTED_FIRMWARE;
    static final int HMI_STATE_JUKEBOX_IS_EMPTY;
    static final int HMI_STATE_CORRUPTED_PARTITION;
    static final int HMI_STATE_WLAN_NO_DEVICE_CONNECTED;
    static final int HMI_STATE_WLAN_NO_APP;
    private static final IntMap HMIERRORCODEMAP;
    public static final int ACTIVE_SOURCE_STATE_LOADING;
    public static final int ACTIVE_SOURCE_STATE_ERROR;
    public static final int ACTIVE_SOURCE_STATE_READY;
    private final ModelGroup activeSourceStateGroup = new ModelGroup();
    private final ModelGroup activeMediaGroup = new ModelGroup();
    private final ModelGroup activeSourceGroup = new ModelGroup();

    public SourceControllerHMIHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void init() {
        this.logger.hmi().log(1078071040, "[%1.init]", (Object)"SourceControllerHMIHandler");
        this.getChoiceModel(1376715520).setValue(-1);
        this.getChoiceModel(3820).setValue(-1);
        this.getResourceLocatorModel(1477378816).setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI);
        this.getResourceLocatorModel(1074791168).setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI);
        this.getChoiceModel(1359938304).setValue(0);
        this.activeMediaGroup.add(this.getModel(1359938304));
        this.activeMediaGroup.add(this.getModel(1343161088));
        this.getChoiceModel(1494156032).setStatus(0);
        this.activeSourceStateGroup.add(this.getModel(1494156032));
        this.activeSourceStateGroup.add(this.getModel(1309737728));
        this.activeSourceGroup.add(this.getModel(1376715520));
        this.activeSourceGroup.add(this.getModel(3820));
        this.activeSourceGroup.add(this.getModel(1477378816));
        this.activeSourceGroup.add(this.getModel(1074791168));
    }

    public void deinit() {
        this.logger.hmi().log(1078071040, "[%1.deinit]", (Object)"SourceControllerHMIHandler");
        this.activeSourceStateGroup.removeAll();
        this.activeMediaGroup.removeAll();
        this.activeSourceGroup.removeAll();
    }

    protected void setActiveMedia(ISourceSlot iSourceSlot) {
        this.logger.hmi().log(1078071040, "[%1.setActiveMedia] '%2'", (Object)"SourceControllerHMIHandler", (Object)iSourceSlot);
        this.getLabelModel(1343161088).setText(iSourceSlot.getName() != null ? iSourceSlot.getName() : "");
        int n = MediaUtils.getHMIMediaType(iSourceSlot.getMediaType());
        this.getChoiceModel(1359938304).setValue(n);
        this.activeMediaGroup.flush();
    }

    protected void setActiveSlotSyncState(ISourceSlot iSourceSlot) {
        int n = 0;
        if (iSourceSlot.getFlags().isFilesystemSyncComplete()) {
            n |= 1;
        }
        if (iSourceSlot.getFlags().isMetaDataSyncComplete()) {
            n |= 2;
        }
        if (iSourceSlot.getFlags().isExtMetaDataSyncComplete()) {
            n |= 4;
        }
        if (iSourceSlot.getFlags().isSyncComplete()) {
            n |= 8;
        }
        this.getChoiceModel(1510933248).setValue(n);
    }

    protected void setActiveSourceState(ActiveSourceState activeSourceState) {
        switch (activeSourceState.getState()) {
            case 2: 
            case 3: {
                this.setActiveSourceState(0, 0);
                return;
            }
            case 1: {
                this.setActiveSourceState(2, 0);
                return;
            }
        }
        this.setActiveSourceState(1, SourceControllerHMIHandler.getHMIErrorCode(activeSourceState.getState()));
    }

    public static int getHMIErrorCode(int n) {
        try {
            return HMIERRORCODEMAP.get(n);
        }
        catch (NoMapElementException noMapElementException) {
            return 12;
        }
    }

    private void setActiveSourceState(int n, int n2) {
        ChoiceModelApp choiceModelApp = this.getChoiceModel(1494156032);
        ChoiceModelApp choiceModelApp2 = (ChoiceModelApp)this.getSystemModel(141);
        ChoiceModelApp choiceModelApp3 = this.getChoiceModel(1309737728);
        ChoiceModelApp choiceModelApp4 = this.getChoiceModel(4106);
        switch (n) {
            case 1: {
                this.logger.hmi().log(1078071040, "[%1.setActiveSourceState] ERROR (hmicode='%2')", (Object)"SourceControllerHMIHandler", (long)n2);
                choiceModelApp.setStatus(n2);
                choiceModelApp.setValue(-1);
                choiceModelApp2.setStatus(n2);
                choiceModelApp2.setValue(-1);
                choiceModelApp3.setValue(n2);
                choiceModelApp4.setStatus(1);
                choiceModelApp4.setValue(0);
                break;
            }
            case 0: {
                this.logger.hmi().log(1078071040, "[%1.setActiveSourceState] LOADING", (Object)"SourceControllerHMIHandler");
                choiceModelApp.setStatus(0);
                choiceModelApp.setValue(0);
                choiceModelApp2.setStatus(0);
                choiceModelApp2.setValue(0);
                choiceModelApp3.setValue(0);
                choiceModelApp4.setStatus(1);
                choiceModelApp4.setValue(2);
                break;
            }
            default: {
                this.logger.hmi().log(1078071040, "[%1.setActiveSourceState] READY", (Object)"SourceControllerHMIHandler");
                choiceModelApp.setStatus(1);
                choiceModelApp.setValue(1);
                choiceModelApp2.setStatus(1);
                choiceModelApp2.setValue(1);
                choiceModelApp3.setValue(0);
                choiceModelApp4.setStatus(1);
                choiceModelApp4.setValue(1);
            }
        }
        this.activeSourceStateGroup.flush();
    }

    protected void setActiveSourceSlot(ISourceSlot iSourceSlot) {
        this.logger.hmi().log(1078071040, "[%1.setActiveSourceSlot] '%2'", (Object)"SourceControllerHMIHandler", (Object)iSourceSlot);
        this.getChoiceModel(1376715520).setValue(iSourceSlot.getSource().getType());
        this.getChoiceModel(3820).setValue(iSourceSlot.getSource().getType());
        this.getResourceLocatorModel(1477378816).setResourceLocator(MediaUtils.getHMISourceIcon(iSourceSlot), iSourceSlot.getLoadingIcon());
        this.getChoiceModel(168887040).setValue(MediaUtils.getHMISourceIcon(iSourceSlot));
        this.getResourceLocatorModel(1611531008).setResourceLocator(MediaUtils.getHMISourceIcon(iSourceSlot), iSourceSlot.getCaptionIcon());
        this.getResourceLocatorModel(1074791168).setResourceLocator(MediaUtils.getHMISourceIcon(iSourceSlot), iSourceSlot.getActiveSourceListClosedIcon());
        this.activeSourceGroup.flush();
    }

    protected void setActiveMediaCapabilities(MediaCapabilities mediaCapabilities) {
        if (mediaCapabilities == null) {
            this.getChoiceModel(1393492736).setValue(0);
            this.getChoiceModel(1410269952).setValue(0);
            this.getChoiceModel(655360768).setValue(0);
            this.getChoiceModel(638583552).setValue(0);
            this.getChoiceModel(1427047168).setValue(0);
            this.getChoiceModel(1443824384).setValue(0);
            this.getChoiceModel(638583552).setValue(0);
            this.getChoiceModel(1963983616).setValue(0);
            this.getChoiceModel(-904920320).setValue(0);
            return;
        }
        this.getChoiceModel(1393492736).setValue(mediaCapabilities.isPlayerCoverart() ? 1 : 0);
        this.getChoiceModel(1410269952).setValue(mediaCapabilities.isRawBrowsing() || mediaCapabilities.isContentBrowsing() ? 1 : 0);
        this.getChoiceModel(1427047168).setValue(mediaCapabilities.isSearch() ? 1 : 0);
        this.getChoiceModel(638583552).setValue(mediaCapabilities.isContentBrowsing() ? 1 : 0);
        this.getChoiceModel(655360768).setValue(mediaCapabilities.isRawBrowsing() ? 1 : 0);
        this.getChoiceModel(1443824384).setValue(mediaCapabilities.isVideo() ? 1 : 0);
        this.getChoiceModel(1963983616).setValue(mediaCapabilities.isImportData() ? 1 : 0);
        this.getChoiceModel(-904920320).setValue(mediaCapabilities.isBrowserCoverart() ? 1 : 0);
    }

    public void setOnlineSourceInstalled(boolean bl) {
        this.logger.main().log(1078071040, "[%1.setOnlineSourceInstalled] '%2'", (Object)"SourceControllerHMIHandler", (Object)bl);
        this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(4081).setValue(bl ? 1 : 0);
    }

    static {
        HMIERRORCODEMAP = new IntMap(35);
        HMIERRORCODEMAP.put(9, 14);
        HMIERRORCODEMAP.put(10, 15);
        HMIERRORCODEMAP.put(18, 16);
        HMIERRORCODEMAP.put(16, 13);
        HMIERRORCODEMAP.put(17, 18);
        HMIERRORCODEMAP.put(19, 20);
        HMIERRORCODEMAP.put(8, 11);
        HMIERRORCODEMAP.put(24, 60);
        HMIERRORCODEMAP.put(11, 21);
        HMIERRORCODEMAP.put(12, 22);
        HMIERRORCODEMAP.put(14, 23);
        HMIERRORCODEMAP.put(13, 24);
        HMIERRORCODEMAP.put(15, 25);
        HMIERRORCODEMAP.put(25, 30);
        HMIERRORCODEMAP.put(6, 31);
        HMIERRORCODEMAP.put(7, 32);
        HMIERRORCODEMAP.put(5, 12);
        HMIERRORCODEMAP.put(20, 19);
        HMIERRORCODEMAP.put(21, 50);
        HMIERRORCODEMAP.put(26, 61);
        HMIERRORCODEMAP.put(4, 10);
        HMIERRORCODEMAP.put(22, 41);
        HMIERRORCODEMAP.put(23, 42);
        HMIERRORCODEMAP.put(27, 26);
        HMIERRORCODEMAP.put(28, 43);
        HMIERRORCODEMAP.put(29, 44);
        HMIERRORCODEMAP.put(30, 45);
        HMIERRORCODEMAP.put(31, 46);
        HMIERRORCODEMAP.put(32, 62);
        HMIERRORCODEMAP.put(33, 63);
    }
}

