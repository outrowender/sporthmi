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
    private static final String LOGCLASS = "SourceControllerHMIHandler";
    static final int HMI_STATE_EMPTY = 10;
    static final int HMI_STATE_NO_PLAYABLE_FILES = 11;
    static final int HMI_STATE_UNREADABLE = 12;
    static final int HMI_STATE_IMPORT_RUNNING = 13;
    static final int HMI_STATE_WRONG_REGION_CODE_CHANGES_LEFT = 14;
    static final int HMI_STATE_WRONG_REGION_CODE_NO_CHANGES_LEFT = 15;
    static final int HMI_STATE_CHILDLOCK = 16;
    static final int HMI_STATE_DELETION_RUNNING = 18;
    static final int HMI_STATE_NOT_SUPPORTED = 19;
    static final int HMI_STATE_OVERCURRENT = 20;
    static final int HMI_STATE_BLUETOOTH_DEACTIVATED = 21;
    static final int HMI_STATE_BLUETOOTH_DEACTIVATED_CLAMPS_OFF = 22;
    static final int HMI_STATE_AUDIOPLAYER_DEACTIVATED = 23;
    static final int HMI_STATE_BLUETOOTH_RECONNECT = 24;
    static final int HMI_STATE_BT_AUDIOPLAYER_NOT_CONNECTED = 25;
    static final int HMI_STATE_CHARGING = 26;
    static final int HMI_STATE_DEVICE_NOT_AVAILABLE = 30;
    static final int HMI_STATE_TEMPERATURE_HIGH = 31;
    static final int HMI_STATE_TEMPERATURE_LOW = 32;
    static final int HMI_STATE_WLAN_DEACTIVATED = 41;
    static final int HMI_STATE_WLAN_DEACTIVATED_CLAMP_S_OFF = 42;
    static final int HMI_STATE_ONLINE_DEACTIVATED_CLAMP_S_OFF = 43;
    static final int HMI_STATE_ONLINE_DEACTIVATED_WLAN_OFF = 44;
    static final int HMI_STATE_ONLINE_DEACTIVATED_WLAN_NO_CONN = 45;
    static final int HMI_STATE_ONLINE_NO_APP = 46;
    static final int HMI_STATE_NOT_SUPPORTED_FIRMWARE = 50;
    static final int HMI_STATE_JUKEBOX_IS_EMPTY = 60;
    static final int HMI_STATE_CORRUPTED_PARTITION = 61;
    static final int HMI_STATE_WLAN_NO_DEVICE_CONNECTED = 62;
    static final int HMI_STATE_WLAN_NO_APP = 63;
    private static final IntMap HMIERRORCODEMAP = new IntMap(35);
    public static final int ACTIVE_SOURCE_STATE_LOADING = 0;
    public static final int ACTIVE_SOURCE_STATE_ERROR = 1;
    public static final int ACTIVE_SOURCE_STATE_READY = 2;
    private final ModelGroup activeSourceStateGroup = new ModelGroup();
    private final ModelGroup activeMediaGroup = new ModelGroup();
    private final ModelGroup activeSourceGroup = new ModelGroup();

    public SourceControllerHMIHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void init() {
        this.logger.hmi().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.getChoiceModel(200530).setValue(-1);
        this.getChoiceModel(3820).setValue(-1);
        this.getResourceLocatorModel(200536).setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI);
        this.getResourceLocatorModel(200768).setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI);
        this.getChoiceModel(200529).setValue(0);
        this.activeMediaGroup.add(this.getModel(200529));
        this.activeMediaGroup.add(this.getModel(200528));
        this.getChoiceModel(200537).setStatus(0);
        this.activeSourceStateGroup.add(this.getModel(200537));
        this.activeSourceStateGroup.add(this.getModel(201038));
        this.activeSourceGroup.add(this.getModel(200530));
        this.activeSourceGroup.add(this.getModel(3820));
        this.activeSourceGroup.add(this.getModel(200536));
        this.activeSourceGroup.add(this.getModel(200768));
    }

    public void deinit() {
        this.logger.hmi().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.activeSourceStateGroup.removeAll();
        this.activeMediaGroup.removeAll();
        this.activeSourceGroup.removeAll();
    }

    protected void setActiveMedia(ISourceSlot iSourceSlot) {
        this.logger.hmi().log(1000000, "[%1.setActiveMedia] '%2'", (Object)LOGCLASS, (Object)iSourceSlot);
        this.getLabelModel(200528).setText(iSourceSlot.getName() != null ? iSourceSlot.getName() : "");
        int n = MediaUtils.getHMIMediaType(iSourceSlot.getMediaType());
        this.getChoiceModel(200529).setValue(n);
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
        this.getChoiceModel(200538).setValue(n);
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
        ChoiceModelApp choiceModelApp = this.getChoiceModel(200537);
        ChoiceModelApp choiceModelApp2 = (ChoiceModelApp)this.getSystemModel(141);
        ChoiceModelApp choiceModelApp3 = this.getChoiceModel(201038);
        ChoiceModelApp choiceModelApp4 = this.getChoiceModel(4106);
        switch (n) {
            case 1: {
                this.logger.hmi().log(1000000, "[%1.setActiveSourceState] ERROR (hmicode='%2')", (Object)LOGCLASS, (long)n2);
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
                this.logger.hmi().log(1000000, "[%1.setActiveSourceState] LOADING", (Object)LOGCLASS);
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
                this.logger.hmi().log(1000000, "[%1.setActiveSourceState] READY", (Object)LOGCLASS);
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
        this.logger.hmi().log(1000000, "[%1.setActiveSourceSlot] '%2'", (Object)LOGCLASS, (Object)iSourceSlot);
        this.getChoiceModel(200530).setValue(iSourceSlot.getSource().getType());
        this.getChoiceModel(3820).setValue(iSourceSlot.getSource().getType());
        this.getResourceLocatorModel(200536).setResourceLocator(MediaUtils.getHMISourceIcon(iSourceSlot), iSourceSlot.getLoadingIcon());
        this.getChoiceModel(200970).setValue(MediaUtils.getHMISourceIcon(iSourceSlot));
        this.getResourceLocatorModel(200288).setResourceLocator(MediaUtils.getHMISourceIcon(iSourceSlot), iSourceSlot.getCaptionIcon());
        this.getResourceLocatorModel(200768).setResourceLocator(MediaUtils.getHMISourceIcon(iSourceSlot), iSourceSlot.getActiveSourceListClosedIcon());
        this.activeSourceGroup.flush();
    }

    protected void setActiveMediaCapabilities(MediaCapabilities mediaCapabilities) {
        if (mediaCapabilities == null) {
            this.getChoiceModel(200531).setValue(0);
            this.getChoiceModel(200532).setValue(0);
            this.getChoiceModel(200743).setValue(0);
            this.getChoiceModel(200742).setValue(0);
            this.getChoiceModel(200533).setValue(0);
            this.getChoiceModel(200534).setValue(0);
            this.getChoiceModel(200742).setValue(0);
            this.getChoiceModel(200821).setValue(0);
            this.getChoiceModel(200906).setValue(0);
            return;
        }
        this.getChoiceModel(200531).setValue(mediaCapabilities.isPlayerCoverart() ? 1 : 0);
        this.getChoiceModel(200532).setValue(mediaCapabilities.isRawBrowsing() || mediaCapabilities.isContentBrowsing() ? 1 : 0);
        this.getChoiceModel(200533).setValue(mediaCapabilities.isSearch() ? 1 : 0);
        this.getChoiceModel(200742).setValue(mediaCapabilities.isContentBrowsing() ? 1 : 0);
        this.getChoiceModel(200743).setValue(mediaCapabilities.isRawBrowsing() ? 1 : 0);
        this.getChoiceModel(200534).setValue(mediaCapabilities.isVideo() ? 1 : 0);
        this.getChoiceModel(200821).setValue(mediaCapabilities.isImportData() ? 1 : 0);
        this.getChoiceModel(200906).setValue(mediaCapabilities.isBrowserCoverart() ? 1 : 0);
    }

    public void setOnlineSourceInstalled(boolean bl) {
        this.logger.main().log(1000000, "[%1.setOnlineSourceInstalled] '%2'", (Object)LOGCLASS, (Object)bl);
        this.getTerminal().getFramework().getHmiServiceApp().getChoiceModel(4081).setValue(bl ? 1 : 0);
    }

    static {
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

