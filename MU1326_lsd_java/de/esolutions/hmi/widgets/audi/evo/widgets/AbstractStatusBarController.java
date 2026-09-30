/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.ModelStubController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.IGridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.StatusbarGridLayout;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerOpenCloseController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IStatusbarChild;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ProgressIconController;
import java.util.ArrayList;

public abstract class AbstractStatusBarController
extends AbstractWidgetController {
    public static final int STYLE_STANDARD = 0;
    public static final int STYLE_MAP = 1;
    public static final int STYLE_NONE = 2;
    public static final int STYLE_SDS_ONLY = 3;
    public static final int TYPE_CLOCK = 1;
    public static final int TYPE_HFP_SIGNAL_STRENGTH = 2;
    public static final int TYPE_NAD_SIGNAL_STRENGTH = 3;
    public static final int TYPE_PHONE_STATUS = 4;
    public static final int TYPE_DATA_RATE = 5;
    public static final int TYPE_CONNECTIVITY = 6;
    public static final int TYPE_SYSTEM_UPDATE = 7;
    public static final int TYPE_NEW_MESSAGE = 33;
    public static final int TYPE_CALL_FORWARDING_ACTIVE = 38;
    public static final int TYPE_MUTE = 39;
    public static final int TYPE_BLUETOOTH_STATUS = 8;
    public static final int TYPE_ADDRESSBOOK1_IMPORT = 9;
    public static final int TYPE_GOOGLE_STATUS = 10;
    public static final int TYPE_TRAFFIC_SOURCE = 11;
    public static final int TYPE_JUKEBOX_IMPORT = 12;
    public static final int TYPE_MEDIA_MIX_MODE = 13;
    public static final int TYPE_MEDIA_REPEAT = 14;
    public static final int TYPE_GRACENOTE = 15;
    public static final int TYPE_ROAMING = 16;
    public static final int TYPE_PROVIDER_NAME = 17;
    public static final int TYPE_PROVIDER_LOGO = 18;
    public static final int TYPE_GOOGLE_TRADEMARK = 19;
    public static final int TYPE_WIRELESS_CHARGING = 20;
    public static final int TYPE_TRAFFIC_ANNOUNCEMENT = 21;
    public static final int TYPE_SDS_LABEL_G24 = 22;
    public static final int TYPE_PROVIDER_LOGO_CONNECT = 23;
    public static final int TYPE_SMS_STORAGE_FULL = 24;
    public static final int TYPE_BLUETOOTH_MEDIA = 25;
    public static final int TYPE_ASIA_ETC = 26;
    public static final int TYPE_ASIA_VICS = 27;
    public static final int TYPE_ASIA_TPEG = 28;
    public static final int TYPE_ASIA_TTS = 29;
    public static final int TYPE_MODELSTUB_ESIM_USED = 30;
    public static final int TYPE_MODELSTUB_ESIM_STATE = 31;
    public static final int TYPE_DRAGON_LOGO = 32;
    public static final int TYPE_ADDRESSBOOK2_IMPORT = 34;
    public static final int TYPE_SELF_LEARNING_NAVIGATION = 35;
    public static final int TYPE_ADDRESSBOOK_IMPORT = 36;
    public static final int TYPE_BLUETOOTH_MEDIA_ON = 37;
    public static final int HMI_CONTEXT_CAR = 0;
    public static final int HMI_CONTEXT_TUNER = 1;
    public static final int HMI_CONTEXT_MEDIA = 2;
    public static final int HMI_CONTEXT_PHONE = 3;
    public static final int HMI_CONTEXT_NAVI = 4;
    public static final int HMI_CONTEXT_MAP = 5;
    public static final int HMI_CONTEXT_ONLINE = 6;
    public static final int HMI_CONTEXT_OFFICE = 7;
    public static final int HMI_CONTEXT_TONE = 8;
    public static final int HMI_CONTEXT_SETTINGS = 9;
    public static final int HMI_CONTEXT_NONE = -1;
    private static final int PROVIDER_NAME_THRESHOLD_VALUE = 50;
    private static final int DEFAULT_LEFT_GROUP_MIN_WIDTH = 195;
    protected int renderStyle = 0;
    protected int currentHMIContext = -1;
    protected static int iconGap;
    protected static int iconGapDataRate;
    protected static int iconGapClock;
    protected static int gapScreenBorder;
    protected static int yOffsetIcon;
    protected static int leftGroupMinWidth;
    protected static int rightGroupMinWidth;
    protected static int containerHeight;
    protected static int displayWidth;
    protected static int displayHeight;
    protected static int yOffsetLabel;
    protected static int yOffsetIconRoaming;
    protected static int yOffsetSystemUpdate;
    protected static int yOffsetIconDataStatus;
    protected float scaleFactor;
    private LabelController labelClock;
    private IconController iconMute;
    private IconController iconPhoneSignalStrength;
    private IconController iconCallForwardingActive;
    private IconController iconPhoneStatus;
    private IconController iconTransmission;
    private IconController iconDataStatus;
    private IconController iconDataSignalStrength;
    private ProgressIconController iconSystemUpdate;
    private IconController iconNewMessage;
    private IconController iconAsiaETC;
    private IconController iconBluetooth;
    private ProgressIconController iconGoogleProgress;
    private IconController iconGoogleTrademark;
    private IconController iconTrafficSource;
    private IconController iconMediaMix;
    private IconController iconMediaRepeat;
    private IconController iconGracenote;
    private IconController iconRoaming;
    private LabelController labelProvidername;
    private IconController iconProviderLogo;
    private IconController iconAddressbookImport;
    private IconController iconAddressbook1Import;
    private IconController iconAddressbook2Import;
    private ProgressIconController iconJukeboxImport;
    private IconController iconWirelessCharging;
    private IconController iconProviderLogoConnect;
    private IconController iconSMSStorageFull;
    private IconController iconBluetoothMedia;
    private IconController iconAsiaVICS;
    private IconController iconAsiaTPEG;
    private IconController iconAsiaTTS;
    private IconController iconDragonLogo;
    private IconController iconSelfLearningNavigation;
    private IconController iconBluetoothMediaOn;
    private boolean bluetoothVisible;
    private boolean adbImportVisible;
    private boolean adb1ImportVisible;
    private boolean adb2ImportVisible;
    private boolean googleProgressVisible;
    private boolean googleTrademarkVisible;
    private boolean trafficSourceVisible;
    private boolean mediaImportVisible;
    private boolean mediaMixVisible;
    private boolean mediaRepeatVisible;
    private boolean gracenoteVisible;
    private boolean roamingVisible;
    private boolean providerLogoVisible;
    private boolean providerNameVisible;
    private boolean wirelessChargingVisible;
    private boolean providerLogoConnectVisible;
    private boolean smsStorageFullVisible;
    private boolean bluetoothMediaVisible;
    private boolean asiaVICSVisible;
    private boolean asiaTPEGVisible;
    private boolean asiaTTSVisible;
    private boolean dragonLogoVisible;
    private boolean selfLearningNavigationVisible;
    private boolean bluetoothMediaOnVisible;
    private int bluetoothState;
    private int adbImportState;
    private int adb1ImportState;
    private int adb2ImportState;
    private int googleProgressState;
    private int googleTrademarkState;
    private int trafficSourceState;
    private int mediaImportState;
    private int mediaMixState;
    private int mediaRepeatState;
    private int gracenoteState;
    private int roamingState;
    private int providerLogoState;
    private int providerNameState;
    private int wirelessChargingState;
    private int providerLogoConnectState;
    private int smsStorageFullState;
    private int bluetoothMediaState;
    private int asiaVICSState;
    private int asiaTPEGState;
    private int asiaTTSState;
    private int dragonLogoState;
    private int selfLearningNavigationState;
    private int bluetoothMediaOnState;
    private String labelProvidernameText;
    private String labelClockText;
    protected int neededRightGroupSpace;
    protected int neededLeftGroupSpace;
    protected IRenderer renderer;
    protected LayoutContainerController rightGroupContainer;
    protected LayoutContainerController leftGroupContainer;
    private ModelStubController eSimUsedChoiceModelStub;
    private ModelStubController eSimStateChoiceModelStub;
    private static final int NAD_MODE_VOICE_DATA = 0;
    private static final int TELMODE_HFP = 0;
    private static final int ACTIVE_WITH_NEW_EVENT = 2;

    protected abstract LayoutContainerController getRightGroupContainer();

    protected abstract LayoutContainerController getLeftGroupContainer();

    protected abstract int getCurrentGapWidth();

    protected abstract int getMinGapWidth();

    protected abstract boolean isViewSizeChanging();

    protected void initializeWidget() {
        this.initLayoutValues();
        if (this.rightGroupContainer == null) {
            this.rightGroupContainer = this.getRightGroupContainer();
            if (this.rightGroupContainer != null) {
                this.createRightGroup();
            }
        }
        if (this.leftGroupContainer == null) {
            this.leftGroupContainer = this.getLeftGroupContainer();
            if (this.leftGroupContainer != null) {
                this.createLeftGroup();
            }
        }
        this.labelProvidernameText = "";
        this.labelClockText = "";
        this.updateContent();
        super.initializeWidget();
    }

    protected void initLayoutValues() {
        Layout layout = ((HMITerminalImpl)this.getTerminal()).getLayout();
        iconGap = layout.getIntegerConstant(44);
        iconGapDataRate = layout.getIntegerConstant(73);
        iconGapClock = layout.getIntegerConstant(78);
        gapScreenBorder = layout.getIntegerConstant(45);
        yOffsetIcon = layout.getIntegerConstant(46);
        leftGroupMinWidth = layout.getIntegerConstant(47);
        rightGroupMinWidth = layout.getIntegerConstant(48);
        containerHeight = layout.getIntegerConstant(49);
        this.scaleFactor = layout.getFloatConstant(14);
        displayWidth = layout.getDistance(1);
        displayHeight = layout.getDistance(2);
        yOffsetLabel = layout.getIntegerConstant(76);
        yOffsetIconRoaming = layout.getIntegerConstant(96);
        yOffsetSystemUpdate = layout.getIntegerConstant(79);
        yOffsetIconDataStatus = layout.getIntegerConstant(110);
    }

    public void createRightGroup() {
        WidgetConstants widgetConstants;
        int n = 0;
        n += this.iconBluetooth != null ? 1 : 0;
        n += this.iconGoogleProgress != null ? 1 : 0;
        n += this.iconGoogleTrademark != null ? 1 : 0;
        n += this.iconTrafficSource != null ? 1 : 0;
        n += this.iconMediaMix != null ? 1 : 0;
        n += this.iconMediaRepeat != null ? 1 : 0;
        n += this.iconGracenote != null ? 1 : 0;
        n += this.iconRoaming != null ? 1 : 0;
        n += this.labelProvidername != null ? 1 : 0;
        n += this.iconProviderLogo != null ? 1 : 0;
        n += this.iconAddressbookImport != null ? 1 : 0;
        n += this.iconAddressbook1Import != null ? 1 : 0;
        n += this.iconAddressbook2Import != null ? 1 : 0;
        n += this.iconJukeboxImport != null ? 1 : 0;
        n += this.iconWirelessCharging != null ? 1 : 0;
        n += this.iconProviderLogoConnect != null ? 1 : 0;
        n += this.iconSMSStorageFull != null ? 1 : 0;
        n += this.iconBluetoothMedia != null ? 1 : 0;
        n += this.iconAsiaVICS != null ? 1 : 0;
        n += this.iconAsiaTTS != null ? 1 : 0;
        n += this.iconAsiaTPEG != null ? 1 : 0;
        n += this.iconDragonLogo != null ? 1 : 0;
        n += this.iconSelfLearningNavigation != null ? 1 : 0;
        StatusbarGridLayout statusbarGridLayout = new StatusbarGridLayout((n += this.iconBluetoothMediaOn != null ? 1 : 0) + 1, 1);
        IGridLayoutHints[] iGridLayoutHintsArray = new GridLayoutHints[n];
        AbstractWidgetController[] abstractWidgetControllerArray = new AbstractWidgetController[n];
        int[] nArray = new int[n + 1 + 1];
        float[] fArray = new float[n + 1 + 1];
        float[] fArray2 = new float[n + 1 + 1];
        fArray[0] = 1.0f;
        nArray[0] = 0;
        nArray[1] = 0;
        int n2 = 0;
        this.updateIconVisibility(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.iconJukeboxImport);
        arrayList.add(this.iconMediaRepeat);
        arrayList.add(this.iconMediaMix);
        arrayList.add(this.labelProvidername);
        arrayList.add(this.iconRoaming);
        arrayList.add(this.iconAddressbookImport);
        arrayList.add(this.iconAddressbook1Import);
        arrayList.add(this.iconAddressbook2Import);
        arrayList.add(this.iconSMSStorageFull);
        arrayList.add(this.iconWirelessCharging);
        arrayList.add(this.iconBluetooth);
        arrayList.add(this.iconBluetoothMedia);
        arrayList.add(this.iconGracenote);
        arrayList.add(this.iconGoogleProgress);
        arrayList.add(this.iconGoogleTrademark);
        arrayList.add(this.iconTrafficSource);
        arrayList.add(this.iconProviderLogo);
        arrayList.add(this.iconProviderLogoConnect);
        arrayList.add(this.iconAsiaVICS);
        arrayList.add(this.iconAsiaTTS);
        arrayList.add(this.iconAsiaTPEG);
        arrayList.add(this.iconDragonLogo);
        arrayList.add(this.iconSelfLearningNavigation);
        arrayList.add(this.iconBluetoothMediaOn);
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            widgetConstants = null;
            if (arrayList.get(i2) instanceof LabelController) {
                widgetConstants = (LabelController)arrayList.get(i2);
            } else if (arrayList.get(i2) instanceof IconController) {
                widgetConstants = (IconController)arrayList.get(i2);
            } else if (arrayList.get(i2) instanceof ProgressIconController) {
                widgetConstants = (ProgressIconController)arrayList.get(i2);
            }
            if (widgetConstants == null) continue;
            iGridLayoutHintsArray[n2] = new GridLayoutHints(n2 + 1, 0);
            if (this.labelProvidername.equals(widgetConstants)) {
                iGridLayoutHintsArray[n2].setAfterEffects(0, yOffsetLabel, 0, 0);
                fArray2[n2 + 1] = 1.0f;
            } else if (this.iconRoaming.equals(widgetConstants)) {
                iGridLayoutHintsArray[n2].setAfterEffects(0, yOffsetIconRoaming, 0, 0);
            }
            iGridLayoutHintsArray[n2].alignmentVert = 9;
            abstractWidgetControllerArray[n2] = widgetConstants;
            nArray[n2 + 2] = iconGap;
            this.rightGroupContainer.add((AbstractWidget)widgetConstants);
            ++n2;
        }
        nArray[nArray.length - 1] = 0;
        AxisConstraints axisConstraints = (AxisConstraints)statusbarGridLayout.getColumnConstraints();
        axisConstraints.gaps = nArray;
        axisConstraints.grow = fArray;
        axisConstraints.shrink = fArray2;
        widgetConstants = (AxisConstraints)statusbarGridLayout.getRowConstraints();
        ((AxisConstraints)widgetConstants).alignment = new int[]{5};
        ((AxisConstraints)widgetConstants).grow = new float[]{1.0f};
        statusbarGridLayout.setWidgetConstraints(iGridLayoutHintsArray, abstractWidgetControllerArray);
        this.rightGroupContainer.setLayoutManager(statusbarGridLayout);
        this.add(this.rightGroupContainer);
    }

    public void createLeftGroup() {
        WidgetConstants widgetConstants;
        int n = 0;
        n += this.labelClock != null ? 1 : 0;
        n += this.iconMute != null ? 1 : 0;
        n += this.iconPhoneSignalStrength != null ? 1 : 0;
        n += this.iconPhoneStatus != null ? 1 : 0;
        n += this.iconTransmission != null ? 1 : 0;
        n += this.iconDataStatus != null ? 1 : 0;
        n += this.iconDataSignalStrength != null ? 1 : 0;
        n += this.iconCallForwardingActive != null ? 1 : 0;
        n += this.iconSystemUpdate != null ? 1 : 0;
        n += this.iconAsiaETC != null ? 1 : 0;
        GridLayout gridLayout = new GridLayout(n += this.iconNewMessage != null ? 1 : 0, 1);
        IGridLayoutHints[] iGridLayoutHintsArray = new GridLayoutHints[n];
        AbstractWidgetController[] abstractWidgetControllerArray = new AbstractWidgetController[n];
        int[] nArray = new int[n + 1];
        float[] fArray = new float[n + 1];
        nArray[0] = 0;
        int n2 = 0;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.labelClock);
        arrayList.add(this.iconMute);
        arrayList.add(this.iconPhoneSignalStrength);
        arrayList.add(this.iconPhoneStatus);
        arrayList.add(this.iconCallForwardingActive);
        arrayList.add(this.iconDataSignalStrength);
        arrayList.add(this.iconDataStatus);
        arrayList.add(this.iconTransmission);
        arrayList.add(this.iconSystemUpdate);
        arrayList.add(this.iconAsiaETC);
        arrayList.add(this.iconNewMessage);
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            widgetConstants = null;
            if (arrayList.get(i2) instanceof LabelController) {
                widgetConstants = (LabelController)arrayList.get(i2);
            } else if (arrayList.get(i2) instanceof IconController) {
                widgetConstants = (IconController)arrayList.get(i2);
            } else if (arrayList.get(i2) instanceof ProgressIconController) {
                widgetConstants = (ProgressIconController)arrayList.get(i2);
            }
            if (widgetConstants == null) continue;
            iGridLayoutHintsArray[n2] = new GridLayoutHints(n2, 0);
            if (this.labelClock.equals(arrayList.get(i2))) {
                iGridLayoutHintsArray[n2].setAfterEffects(0, yOffsetLabel, 0, 0);
            } else if (this.iconDataStatus.equals(widgetConstants)) {
                ((GridLayoutHints)iGridLayoutHintsArray[n2]).setAfterEffects(0, yOffsetIconDataStatus, 0, 0);
            }
            ((GridLayoutHints)iGridLayoutHintsArray[n2]).alignmentVert = 9;
            abstractWidgetControllerArray[n2] = widgetConstants;
            if (widgetConstants.equals(this.iconDataStatus)) {
                nArray[n2] = 0;
            } else if (widgetConstants.equals(this.iconPhoneStatus)) {
                nArray[n2] = 0;
            } else if (widgetConstants.equals(this.iconTransmission)) {
                nArray[n2] = iconGapDataRate;
            } else if (widgetConstants.equals(this.iconSystemUpdate)) {
                ((GridLayoutHints)iGridLayoutHintsArray[n2]).setAfterEffects(0, yOffsetSystemUpdate, 0, 0);
                nArray[n2] = iconGap;
            } else {
                nArray[n2] = widgetConstants.equals(this.labelClock) ? iconGapClock : iconGap;
            }
            this.leftGroupContainer.add((AbstractWidget)widgetConstants);
            ++n2;
        }
        nArray[nArray.length - 1] = 0;
        AxisConstraints axisConstraints = (AxisConstraints)gridLayout.getColumnConstraints();
        axisConstraints.gaps = nArray;
        axisConstraints.shrink = fArray;
        widgetConstants = (AxisConstraints)gridLayout.getRowConstraints();
        ((AxisConstraints)widgetConstants).grow = new float[]{1.0f};
        gridLayout.setWidgetConstraints(iGridLayoutHintsArray, abstractWidgetControllerArray);
        this.leftGroupContainer.setLayoutManager(gridLayout);
        this.add(this.leftGroupContainer);
        leftGroupMinWidth = (this.iconPhoneSignalStrength != null ? this.iconPhoneSignalStrength.getPreferredWidth() : 0) + iconGap * 3 + (this.iconDataSignalStrength != null ? this.iconDataSignalStrength.getPreferredWidth() : (this.iconCallForwardingActive != null ? this.iconCallForwardingActive.getPreferredWidth() : 0));
        if (this.iconPhoneSignalStrength == null || this.iconDataSignalStrength == null && this.iconCallForwardingActive == null) {
            leftGroupMinWidth = Math.min(leftGroupMinWidth, 195);
        }
    }

    public void setRenderStyle(int n) {
        if (this.renderStyle != n) {
            this.renderStyle = n;
            this.setCompositesDirty(true);
        }
    }

    public void setCurrentHMIContext(int n) {
        if (this.currentHMIContext != n) {
            this.currentHMIContext = n;
            this.updateContent();
        }
    }

    public void updateContent() {
        this.doLeftGroupPriorisation();
        this.doRightGroupPriorisation();
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        super.processModelUpdateEvent(modelUpdateEvent);
        this.doLeftGroupPriorisation();
        this.doRightGroupPriorisation();
    }

    public void add(AbstractWidget abstractWidget) {
        super.add(abstractWidget);
        if (abstractWidget instanceof ModelStubController) {
            if (((ModelStubController)abstractWidget).getModelID() == 2500316) {
                this.eSimUsedChoiceModelStub = (ModelStubController)abstractWidget;
            } else if (((ModelStubController)abstractWidget).getModelID() == 2500312) {
                this.eSimStateChoiceModelStub = (ModelStubController)abstractWidget;
            }
        }
    }

    public void add(AbstractWidget abstractWidget, int n) {
        switch (n) {
            case 1: {
                this.labelClock = (LabelController)abstractWidget;
                break;
            }
            case 39: {
                this.iconMute = (IconController)abstractWidget;
                break;
            }
            case 2: {
                this.iconPhoneSignalStrength = (IconController)abstractWidget;
                break;
            }
            case 4: {
                this.iconPhoneStatus = (IconController)abstractWidget;
                break;
            }
            case 5: {
                this.iconDataStatus = (IconController)abstractWidget;
                break;
            }
            case 6: {
                this.iconTransmission = (IconController)abstractWidget;
                break;
            }
            case 3: {
                this.iconDataSignalStrength = (IconController)abstractWidget;
                break;
            }
            case 7: {
                if (abstractWidget instanceof ProgressIconController) {
                    this.iconSystemUpdate = (ProgressIconController)abstractWidget;
                    break;
                }
                logMessagingStatusBar.log(10000, "AbstractStatusBarController#add Widget %1 of type: TYPE_SYSTEM_UPDATE is no instance of ProgressIconController! could not be added to status bar", (Object)abstractWidget.getClass().getName());
                break;
            }
            case 38: {
                this.iconCallForwardingActive = (IconController)abstractWidget;
                break;
            }
            case 8: {
                this.iconBluetooth = (IconController)abstractWidget;
                break;
            }
            case 25: {
                this.iconBluetoothMedia = (IconController)abstractWidget;
                break;
            }
            case 10: {
                if (abstractWidget instanceof ProgressIconController) {
                    this.iconGoogleProgress = (ProgressIconController)abstractWidget;
                    break;
                }
                logMessagingStatusBar.log(10000, "AbstractStatusBarController#add Widget %1 of type: TYPE_GOOGLE_STATUS is no instance of ProgressIconController! could not be added to status bar", (Object)abstractWidget.getClass().getName());
                break;
            }
            case 19: {
                this.iconGoogleTrademark = (IconController)abstractWidget;
                break;
            }
            case 11: {
                this.iconTrafficSource = (IconController)abstractWidget;
                break;
            }
            case 13: {
                this.iconMediaMix = (IconController)abstractWidget;
                break;
            }
            case 14: {
                this.iconMediaRepeat = (IconController)abstractWidget;
                break;
            }
            case 15: {
                this.iconGracenote = (IconController)abstractWidget;
                break;
            }
            case 16: {
                this.iconRoaming = (IconController)abstractWidget;
                break;
            }
            case 17: {
                this.labelProvidername = (LabelController)abstractWidget;
                break;
            }
            case 18: {
                this.iconProviderLogo = (IconController)abstractWidget;
                break;
            }
            case 36: {
                this.iconAddressbookImport = (IconController)abstractWidget;
                break;
            }
            case 9: {
                this.iconAddressbook1Import = (IconController)abstractWidget;
                break;
            }
            case 34: {
                this.iconAddressbook2Import = (IconController)abstractWidget;
                break;
            }
            case 12: {
                if (abstractWidget instanceof ProgressIconController) {
                    this.iconJukeboxImport = (ProgressIconController)abstractWidget;
                    break;
                }
                logMessagingStatusBar.log(10000, "AbstractStatusBarController#add Widget %1 of type: TYPE_JUKEBOX_IMPORT is no instance of ProgressIconController! could not be added to status bar", (Object)abstractWidget.getClass().getName());
                break;
            }
            case 20: {
                this.iconWirelessCharging = (IconController)abstractWidget;
                break;
            }
            case 23: {
                this.iconProviderLogoConnect = (IconController)abstractWidget;
                break;
            }
            case 24: {
                this.iconSMSStorageFull = (IconController)abstractWidget;
                break;
            }
            case 26: {
                this.iconAsiaETC = (IconController)abstractWidget;
                break;
            }
            case 27: {
                this.iconAsiaVICS = (IconController)abstractWidget;
                break;
            }
            case 28: {
                this.iconAsiaTPEG = (IconController)abstractWidget;
                break;
            }
            case 29: {
                this.iconAsiaTTS = (IconController)abstractWidget;
                break;
            }
            case 32: {
                this.iconDragonLogo = (IconController)abstractWidget;
                break;
            }
            case 33: {
                this.iconNewMessage = (IconController)abstractWidget;
                break;
            }
            case 35: {
                this.iconSelfLearningNavigation = (IconController)abstractWidget;
                break;
            }
            case 37: {
                this.iconBluetoothMediaOn = (IconController)abstractWidget;
                break;
            }
            default: {
                logMessagingStatusBar.log(100000, "AbstractStatusBarController#add unknown cell type %1", (long)n);
            }
        }
    }

    protected void setChildOnScreen(AbstractWidgetController abstractWidgetController, boolean bl) {
        if (abstractWidgetController != null) {
            abstractWidgetController.setOnScreen(bl);
            if (abstractWidgetController.getParent() != null) {
                ((LayoutContainerController)abstractWidgetController.getParent()).invalidateChildrenBounds();
            }
        }
    }

    protected void setChildVisible(AbstractWidgetController abstractWidgetController, boolean bl) {
        if (abstractWidgetController != null) {
            abstractWidgetController.setVisible(bl);
        }
    }

    protected boolean checkChildVisibilityViaValue(IStatusbarChild iStatusbarChild) {
        if (iStatusbarChild != null) {
            return iStatusbarChild.getModelValue() > 0;
        }
        return false;
    }

    protected boolean checkChildVisibilityViaValue(IStatusbarChild iStatusbarChild, int n) {
        if (iStatusbarChild != null) {
            return iStatusbarChild.getModelValue() == n;
        }
        return false;
    }

    protected boolean checkChildVisibilityViaStatus(IStatusbarChild iStatusbarChild) {
        if (iStatusbarChild != null) {
            return iStatusbarChild.getModelStatus() == 0 && ((AbstractWidgetController)((Object)iStatusbarChild)).getPreferredWidth() > 1;
        }
        return false;
    }

    public void setAllIconVisibility(boolean bl) {
        this.setIconVisibility(bl, bl, bl, bl, bl, bl, bl, bl, bl, bl, bl, bl, bl, bl, bl, bl, bl, bl, bl, bl, bl, bl, bl, bl);
    }

    public void updateIconVisibility(boolean bl) {
        this.bluetoothVisible = this.checkChildVisibilityViaValue(this.iconBluetooth);
        this.adbImportVisible = this.checkChildVisibilityViaStatus(this.iconAddressbookImport);
        this.adb1ImportVisible = this.checkChildVisibilityViaStatus(this.iconAddressbook1Import);
        this.adb2ImportVisible = this.checkChildVisibilityViaStatus(this.iconAddressbook2Import);
        this.trafficSourceVisible = this.checkChildVisibilityViaValue(this.iconTrafficSource);
        logMessagingStatusBar.log(1000000, "AbstractStatusBarController#updateIconVisibility Visibility of traffic Icon = %2 is : %1", this.trafficSourceVisible, (Object)this.iconTrafficSource);
        this.mediaImportVisible = this.checkChildVisibilityViaValue(this.iconJukeboxImport);
        this.mediaMixVisible = this.checkChildVisibilityViaValue(this.iconMediaMix);
        this.mediaRepeatVisible = this.checkChildVisibilityViaValue(this.iconMediaRepeat);
        this.gracenoteVisible = this.checkChildVisibilityViaValue(this.iconGracenote);
        this.roamingVisible = this.checkChildVisibilityViaValue(this.iconRoaming);
        this.providerLogoVisible = this.checkChildVisibilityViaStatus(this.iconProviderLogo);
        this.providerNameVisible = this.checkChildVisibilityViaValue(this.labelProvidername);
        this.wirelessChargingVisible = this.checkChildVisibilityViaValue(this.iconWirelessCharging);
        this.providerLogoConnectVisible = this.checkChildVisibilityViaStatus(this.iconProviderLogoConnect);
        this.smsStorageFullVisible = this.checkChildVisibilityViaValue(this.iconSMSStorageFull);
        this.bluetoothMediaVisible = this.checkChildVisibilityViaValue(this.iconBluetoothMedia);
        this.asiaVICSVisible = this.checkChildVisibilityViaValue(this.iconAsiaVICS);
        this.asiaTTSVisible = this.checkChildVisibilityViaValue(this.iconAsiaTTS);
        this.asiaTPEGVisible = this.checkChildVisibilityViaValue(this.iconAsiaTPEG);
        this.dragonLogoVisible = this.checkChildVisibilityViaValue(this.iconDragonLogo);
        this.selfLearningNavigationVisible = this.checkChildVisibilityViaValue(this.iconSelfLearningNavigation);
        this.bluetoothMediaOnVisible = this.checkChildVisibilityViaValue(this.iconBluetoothMediaOn);
        if (bl) {
            this.setIconVisibility(this.bluetoothVisible, this.adbImportVisible, this.adb1ImportVisible, this.adb2ImportVisible, this.googleProgressVisible, this.trafficSourceVisible, this.mediaImportVisible, this.mediaMixVisible, this.mediaRepeatVisible, this.gracenoteVisible, this.roamingVisible, this.providerLogoVisible, this.providerNameVisible, this.googleTrademarkVisible, this.wirelessChargingVisible, this.providerLogoConnectVisible, this.smsStorageFullVisible, this.bluetoothMediaVisible, this.asiaVICSVisible, this.asiaTTSVisible, this.asiaTPEGVisible, this.dragonLogoVisible, this.selfLearningNavigationVisible, this.bluetoothMediaOnVisible);
        }
    }

    public void setIconVisibility(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, boolean bl16, boolean bl17, boolean bl18, boolean bl19, boolean bl20, boolean bl21, boolean bl22, boolean bl23, boolean bl24) {
        EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController;
        boolean bl25 = false;
        if (this.labelProvidernameText != null && this.labelProvidername != null && !this.labelProvidernameText.equals(this.labelProvidername.getText())) {
            bl25 = true;
            this.labelProvidernameText = this.labelProvidername.getText();
        }
        if (bl25 || this.hasIconChanged(bl, this.iconBluetooth, this.bluetoothState) || this.hasIconChanged(bl2, this.iconAddressbookImport, this.adbImportState) || this.hasIconChanged(bl3, this.iconAddressbook1Import, this.adb1ImportState) || this.hasIconChanged(bl4, this.iconAddressbook2Import, this.adb2ImportState) || this.hasIconChanged(bl5, this.iconGoogleProgress, this.googleProgressState) || this.hasIconChanged(bl6, this.iconTrafficSource, this.trafficSourceState) || this.hasIconChanged(bl7, this.iconJukeboxImport, this.mediaImportState) || this.hasIconChanged(bl8, this.iconMediaMix, this.mediaMixState) || this.hasIconChanged(bl9, this.iconMediaRepeat, this.mediaRepeatState) || this.hasIconChanged(bl10, this.iconGracenote, this.gracenoteState) || this.hasIconChanged(bl11, this.iconRoaming, this.roamingState) || this.hasIconChanged(bl12, this.iconProviderLogo, this.providerLogoState) || this.hasIconChanged(bl13, this.labelProvidername, this.providerNameState) || this.hasIconChanged(bl14, this.iconGoogleTrademark, this.googleTrademarkState) || this.hasIconChanged(bl15, this.iconWirelessCharging, this.wirelessChargingState) || this.hasIconChanged(bl16, this.iconProviderLogoConnect, this.providerLogoConnectState) || this.hasIconChanged(bl17, this.iconSMSStorageFull, this.smsStorageFullState) || this.hasIconChanged(bl18, this.iconBluetoothMedia, this.bluetoothMediaState) || this.hasIconChanged(bl19, this.iconAsiaVICS, this.asiaVICSState) || this.hasIconChanged(bl20, this.iconAsiaTTS, this.asiaTTSState) || this.hasIconChanged(bl21, this.iconAsiaTPEG, this.asiaTPEGState) || this.hasIconChanged(bl22, this.iconDragonLogo, this.dragonLogoState) || this.hasIconChanged(bl23, this.iconSelfLearningNavigation, this.selfLearningNavigationState) || this.hasIconChanged(bl24, this.iconBluetoothMediaOn, this.bluetoothMediaOnState)) {
            logMessagingStatusBar.log(1000000, "AbstractStatusBarController#setIconVisibility notifyEntertainmentDrawerGapChanged");
            this.notifyEntertainmentDrawerGapChanged();
        }
        if ((entertainmentDrawerOpenCloseController = this.getEntertainmentDrawer()) != null && this.rightGroupContainer != null && this.leftGroupContainer != null) {
            int n = displayWidth / 2 + entertainmentDrawerOpenCloseController.getPreferredWidth() / 2;
            int n2 = displayWidth - n;
            this.rightGroupContainer.setBounds(n + iconGap, this.rightGroupContainer.getY(), n2 - iconGap * 2, this.rightGroupContainer.getHeight());
            this.leftGroupContainer.setBounds(iconGap * 2, this.leftGroupContainer.getY(), n2 + iconGap, this.leftGroupContainer.getHeight());
        }
        this.setChildOnScreen(this.iconBluetooth, bl);
        this.setChildOnScreen(this.iconAddressbookImport, bl2);
        this.setChildOnScreen(this.iconAddressbook1Import, bl3);
        this.setChildOnScreen(this.iconAddressbook2Import, bl4);
        this.setChildOnScreen(this.iconGoogleProgress, bl5);
        this.setChildOnScreen(this.iconTrafficSource, bl6);
        this.setChildOnScreen(this.iconJukeboxImport, bl7);
        this.setChildOnScreen(this.iconMediaMix, bl8);
        this.setChildOnScreen(this.iconMediaRepeat, bl9);
        this.setChildOnScreen(this.iconGracenote, bl10);
        this.setChildOnScreen(this.iconRoaming, bl11);
        this.setChildOnScreen(this.iconProviderLogo, bl12);
        this.setChildOnScreen(this.labelProvidername, bl13);
        this.setChildOnScreen(this.iconGoogleTrademark, bl14);
        this.setChildOnScreen(this.iconWirelessCharging, bl15);
        this.setChildOnScreen(this.iconProviderLogoConnect, bl16);
        this.setChildOnScreen(this.iconSMSStorageFull, bl17);
        this.setChildOnScreen(this.iconBluetoothMedia, bl18);
        this.setChildOnScreen(this.iconAsiaVICS, bl19);
        this.setChildOnScreen(this.iconAsiaTTS, bl20);
        this.setChildOnScreen(this.iconAsiaTPEG, bl21);
        this.setChildOnScreen(this.iconDragonLogo, bl22);
        this.setChildOnScreen(this.iconSelfLearningNavigation, bl23);
        this.setChildOnScreen(this.iconBluetoothMediaOn, bl24);
        if (this.rightGroupContainer != null) {
            this.rightGroupContainer.layout();
        }
        if (logMessagingStatusBar.isDebug()) {
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of bluetooth to: %1", bl);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of adressbook import to: %1", bl2);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of adressbook 1 import to: %1", bl3);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of adressbook 2 import to: %1", bl4);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of googleProcess to: %1", bl5);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of trafficSource to: %1", bl6);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of mediaMix to: %1", bl8);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of mediaRepeat to: %1", bl9);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of jukeBoxImport to: %1", bl7);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of gracenote to: %1", bl10);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of roaming to: %1", bl11);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of providerLogo to: %1", bl12);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of providerName to: %1", bl13);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of googleTrademark to: %1", bl14);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of wirelessCharging to: %1", bl15);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of providerLogoConnect to: %1", bl16);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of smsStorageFull to: %1", bl17);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of bluetoothMedia to: %1", bl18);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of VIC to: %1", bl19);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of TTS to: %1", bl20);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of TPEG to: %1", bl21);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of Dragon-Logo to: %1", bl22);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of Self Learning Navigation to: %1", bl23);
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setIconVisibility Set visibility of Bluetooth Media On to: %1", bl24);
        }
    }

    private boolean hasIconChanged(boolean bl, AbstractWidgetController abstractWidgetController, int n) {
        if (abstractWidgetController != null && n == 0) {
            return abstractWidgetController.isOnScreen() != bl || abstractWidgetController.isInvalid();
        }
        return false;
    }

    private boolean getVisibilityOnScreen(AbstractWidgetController abstractWidgetController, int n, boolean bl) {
        if (n != 0) {
            boolean bl2 = false;
            if (n == 1) {
                bl2 = abstractWidgetController.isVisible();
            } else if (n == 2) {
                bl2 = false;
            }
            return bl2;
        }
        return bl;
    }

    public boolean isSDSVisible() {
        return false;
    }

    private EntertainmentDrawerOpenCloseController getEntertainmentDrawer() {
        Object object;
        if (this.terminal != null && (object = this.terminal.getDrawerFocusManager().getEntertainmentDrawer()) instanceof EntertainmentDrawerController) {
            return ((EntertainmentDrawerController)object).getOpenCloseController();
        }
        return null;
    }

    public void doRightGroupPriorisation() {
        this.updateIconVisibility(false);
        this.neededRightGroupSpace = iconGap;
        switch (this.currentHMIContext) {
            case 9: {
                logMessagingStatusBar.log(10000000, "AbstractStatusBarController#doRightGroupPriorisation currentHMIContext is HMI_CONTEXT_SETTINGS");
                this.setAllIconVisibility(false);
                break;
            }
            case 8: {
                logMessagingStatusBar.log(10000000, "AbstractStatusBarController#doRightGroupPriorisation currentHMIContext is HMI_CONTEXT_TONE");
                this.setAllIconVisibility(false);
                break;
            }
            case 0: {
                logMessagingStatusBar.log(10000000, "AbstractStatusBarController#doRightGroupPriorisation currentHMIContext is HMI_CONTEXT_CAR");
                this.setAllIconVisibility(false);
                break;
            }
            case 1: {
                logMessagingStatusBar.log(10000000, "AbstractStatusBarController#doRightGroupPriorisation currentHMIContext is HMI_CONTEXT_TUNER");
                this.setAllIconVisibility(false);
                break;
            }
            case -1: {
                logMessagingStatusBar.log(10000000, "AbstractStatusBarController#doRightGroupPriorisation currentHMIContext is HMI_CONTEXT_NONE");
                this.setAllIconVisibility(false);
                break;
            }
            case 4: {
                logMessagingStatusBar.log(10000000, "AbstractStatusBarController#doRightGroupPriorisation currentHMIContext is HMI_CONTEXT_DESTINATION");
                if (!this.isViewSizeChanging() && !this.isSDSVisible()) {
                    this.adbImportVisible = this.getVisibilityOnScreen(this.iconAddressbookImport, this.adbImportState, this.adbImportVisible);
                    this.adb1ImportVisible = this.getVisibilityOnScreen(this.iconAddressbook1Import, this.adb1ImportState, this.adb1ImportVisible);
                    this.adb2ImportVisible = this.getVisibilityOnScreen(this.iconAddressbook2Import, this.adb2ImportState, this.adb2ImportVisible);
                    this.selfLearningNavigationVisible = this.getVisibilityOnScreen(this.iconSelfLearningNavigation, this.selfLearningNavigationState, this.selfLearningNavigationVisible);
                    this.providerLogoVisible = this.getVisibilityOnScreen(this.iconProviderLogo, this.providerLogoState, this.providerLogoVisible);
                    this.googleProgressVisible = this.getVisibilityOnScreen(this.iconGoogleProgress, this.googleProgressState, this.googleProgressVisible);
                    this.googleTrademarkVisible = this.getVisibilityOnScreen(this.iconGoogleTrademark, this.googleTrademarkState, this.googleTrademarkVisible);
                }
                if (this.adbImportVisible) {
                    this.addSpace(this.iconAddressbookImport);
                }
                if (this.adb1ImportVisible) {
                    this.addSpace(this.iconAddressbook1Import);
                }
                if (this.adb2ImportVisible) {
                    this.addSpace(this.iconAddressbook2Import);
                }
                if (this.selfLearningNavigationVisible) {
                    this.addSpace(this.iconSelfLearningNavigation);
                }
                if (this.providerLogoVisible) {
                    this.addSpace(this.iconProviderLogo);
                }
                if (this.googleProgressVisible) {
                    this.addSpace(this.iconGoogleProgress);
                }
                if (this.googleTrademarkVisible) {
                    this.addSpace(this.iconGoogleTrademark);
                }
                boolean[] blArray = new boolean[]{this.adbImportVisible, this.adb1ImportVisible, this.adb2ImportVisible, this.selfLearningNavigationVisible, this.providerLogoVisible, this.googleProgressVisible, this.googleTrademarkVisible};
                this.removeSpace(new AbstractWidgetController[]{this.iconAddressbookImport, this.iconAddressbook1Import, this.iconAddressbook2Import, this.iconSelfLearningNavigation, this.iconProviderLogo, this.iconGoogleProgress, this.iconGoogleTrademark}, blArray);
                this.adbImportVisible = blArray[0];
                this.adb1ImportVisible = blArray[1];
                this.adb2ImportVisible = blArray[2];
                this.selfLearningNavigationVisible = blArray[3];
                this.providerLogoVisible = blArray[4];
                this.googleProgressVisible = blArray[5];
                this.googleTrademarkVisible = blArray[6];
                this.setIconVisibility(false, this.adbImportVisible, this.adb1ImportVisible, this.adb2ImportVisible, this.googleProgressVisible, false, false, false, false, false, false, this.providerLogoVisible, false, this.googleTrademarkVisible, false, false, false, false, false, false, false, false, this.selfLearningNavigationVisible, false);
                break;
            }
            case 5: {
                logMessagingStatusBar.log(10000000, "AbstractStatusBarController#doRightGroupPriorisation currentHMIContext is HMI_CONTEXT_MAP");
                if (!this.isViewSizeChanging() && !this.isSDSVisible()) {
                    logMessagingStatusBar.log(1000000, "AbstractStatusBarController#doRightGroupPriorisation  Get the new visiblity of the icon = : %1 with state =%2 ", (Object)this.iconTrafficSource, (long)this.trafficSourceState);
                    this.trafficSourceVisible = this.getVisibilityOnScreen(this.iconTrafficSource, this.trafficSourceState, this.trafficSourceVisible);
                    logMessagingStatusBar.log(1000000, "AbstractStatusBarController#doRightGroupPriorisation  iconTrafficSource new visibility on screen : %1 ", this.trafficSourceVisible);
                    this.asiaVICSVisible = this.getVisibilityOnScreen(this.iconAsiaVICS, this.asiaVICSState, this.asiaVICSVisible);
                    this.asiaTTSVisible = this.getVisibilityOnScreen(this.iconAsiaTTS, this.asiaTTSState, this.asiaTTSVisible);
                    this.asiaTPEGVisible = this.getVisibilityOnScreen(this.iconAsiaTPEG, this.asiaTPEGState, this.asiaTPEGVisible);
                    this.selfLearningNavigationVisible = this.getVisibilityOnScreen(this.iconSelfLearningNavigation, this.selfLearningNavigationState, this.selfLearningNavigationVisible);
                    this.googleProgressVisible = this.getVisibilityOnScreen(this.iconGoogleProgress, this.googleProgressState, this.googleProgressVisible);
                    this.googleTrademarkVisible = this.getVisibilityOnScreen(this.iconGoogleTrademark, this.googleTrademarkState, this.googleTrademarkVisible);
                }
                if (this.trafficSourceVisible) {
                    this.addSpace(this.iconTrafficSource);
                }
                if (this.asiaVICSVisible) {
                    this.addSpace(this.iconAsiaVICS);
                }
                if (this.asiaTTSVisible) {
                    this.addSpace(this.iconAsiaTTS);
                }
                if (this.asiaTPEGVisible) {
                    this.addSpace(this.iconAsiaTPEG);
                }
                if (this.selfLearningNavigationVisible) {
                    this.addSpace(this.iconSelfLearningNavigation);
                }
                if (this.googleProgressVisible) {
                    this.addSpace(this.iconGoogleProgress);
                }
                if (this.googleTrademarkVisible) {
                    this.addSpace(this.iconGoogleTrademark);
                }
                int n = 7;
                boolean[] blArray = new boolean[n];
                AbstractWidgetController[] abstractWidgetControllerArray = new AbstractWidgetController[n];
                blArray[0] = this.trafficSourceVisible;
                abstractWidgetControllerArray[0] = this.iconTrafficSource;
                blArray[1] = this.asiaVICSVisible;
                abstractWidgetControllerArray[1] = this.iconAsiaVICS;
                blArray[2] = this.asiaTTSVisible;
                abstractWidgetControllerArray[2] = this.iconAsiaTTS;
                blArray[3] = this.asiaTPEGVisible;
                abstractWidgetControllerArray[3] = this.iconAsiaTPEG;
                blArray[4] = this.selfLearningNavigationVisible;
                abstractWidgetControllerArray[4] = this.iconSelfLearningNavigation;
                blArray[5] = this.googleProgressVisible;
                abstractWidgetControllerArray[5] = this.iconGoogleProgress;
                blArray[6] = this.googleTrademarkVisible;
                abstractWidgetControllerArray[6] = this.iconGoogleTrademark;
                this.removeSpace(abstractWidgetControllerArray, blArray);
                this.trafficSourceVisible = blArray[0];
                logMessagingStatusBar.log(1000000, "AbstractStatusBarController#doRightGroupPriorisation iconTrafficSource new visibility : %1", this.trafficSourceVisible);
                this.asiaVICSVisible = blArray[1];
                this.asiaTTSVisible = blArray[2];
                this.asiaTPEGVisible = blArray[3];
                this.selfLearningNavigationVisible = blArray[4];
                this.googleProgressVisible = blArray[5];
                this.googleTrademarkVisible = blArray[6];
                this.setIconVisibility(false, false, false, false, this.googleProgressVisible, this.trafficSourceVisible, false, false, false, false, false, false, false, this.googleTrademarkVisible, false, false, false, false, this.asiaVICSVisible, this.asiaTTSVisible, this.asiaTPEGVisible, false, this.selfLearningNavigationVisible, false);
                break;
            }
            case 2: {
                logMessagingStatusBar.log(10000000, "Statusbar#doPriorisation currentHMIContext is HMI_CONTEXT_MEDIA");
                if (!this.isViewSizeChanging() && !this.isSDSVisible()) {
                    this.bluetoothMediaVisible = this.getVisibilityOnScreen(this.iconBluetoothMedia, this.bluetoothMediaState, this.bluetoothMediaVisible);
                    this.bluetoothMediaOnVisible = this.getVisibilityOnScreen(this.iconBluetoothMediaOn, this.bluetoothMediaOnState, this.bluetoothMediaOnVisible);
                    this.mediaMixVisible = this.getVisibilityOnScreen(this.iconMediaMix, this.asiaTTSState, this.mediaMixVisible);
                    this.mediaRepeatVisible = this.getVisibilityOnScreen(this.iconMediaRepeat, this.asiaTPEGState, this.mediaRepeatVisible);
                    this.mediaImportVisible = this.getVisibilityOnScreen(this.iconJukeboxImport, this.mediaImportState, this.mediaImportVisible);
                    this.providerLogoConnectVisible = this.getVisibilityOnScreen(this.iconProviderLogoConnect, this.providerLogoConnectState, this.providerLogoConnectVisible);
                    this.gracenoteVisible = this.getVisibilityOnScreen(this.iconGracenote, this.gracenoteState, this.gracenoteVisible);
                }
                if (this.bluetoothMediaVisible) {
                    this.addSpace(this.iconBluetoothMedia);
                }
                if (this.bluetoothMediaOnVisible) {
                    this.addSpace(this.iconBluetoothMediaOn);
                }
                if (this.mediaMixVisible) {
                    this.addSpace(this.iconMediaMix);
                }
                if (this.mediaRepeatVisible) {
                    this.addSpace(this.iconMediaRepeat);
                }
                if (this.mediaImportVisible) {
                    this.addSpace(this.iconJukeboxImport);
                }
                if (this.providerLogoConnectVisible) {
                    this.addSpace(this.iconProviderLogoConnect);
                }
                if (this.gracenoteVisible) {
                    this.addSpace(this.iconGracenote);
                }
                if (this.gracenoteVisible || this.providerLogoConnectVisible) {
                    this.bluetoothMediaVisible = this.removeSpace(this.iconBluetoothMedia);
                    this.bluetoothMediaOnVisible = this.removeSpace(this.iconBluetoothMediaOn);
                    this.mediaMixVisible = this.removeSpace(this.iconMediaMix);
                    this.mediaRepeatVisible = this.removeSpace(this.iconMediaRepeat);
                    this.mediaImportVisible = this.removeSpace(this.iconJukeboxImport);
                    if (this.getWidth() < this.neededRightGroupSpace) {
                        this.providerLogoConnectVisible = this.removeSpace(this.iconProviderLogoConnect);
                    }
                    if (this.getWidth() < this.neededRightGroupSpace) {
                        this.gracenoteVisible = this.removeSpace(this.iconGracenote);
                    }
                } else {
                    boolean[] blArray = new boolean[]{this.mediaImportVisible, this.mediaRepeatVisible, this.mediaMixVisible, this.bluetoothMediaVisible, this.bluetoothMediaOnVisible};
                    this.removeSpace(new AbstractWidgetController[]{this.iconJukeboxImport, this.iconMediaRepeat, this.iconMediaMix, this.iconBluetoothMedia, this.iconBluetoothMediaOn}, blArray);
                    this.mediaImportVisible = blArray[0];
                    this.mediaRepeatVisible = blArray[1];
                    this.mediaMixVisible = blArray[2];
                    this.bluetoothMediaVisible = blArray[3];
                    this.bluetoothMediaOnVisible = blArray[4];
                }
                this.setIconVisibility(false, false, false, false, false, false, this.mediaImportVisible, this.mediaMixVisible, this.mediaRepeatVisible, this.gracenoteVisible, false, false, false, false, false, this.providerLogoConnectVisible, false, this.bluetoothMediaVisible, false, false, false, false, false, this.bluetoothMediaOnVisible);
                break;
            }
            case 7: {
                logMessagingStatusBar.log(10000000, "AbstractStatusBarController#doRightGroupPriorisation currentHMIContext is HMI_CONTEXT_ADRESSBOOK");
            }
            case 3: {
                logMessagingStatusBar.log(10000000, "AbstractStatusBarController#doRightGroupPriorisation currentHMIContext is HMI_CONTEXT_PHONE");
                if (!this.isViewSizeChanging() && !this.isSDSVisible()) {
                    this.bluetoothVisible = this.getVisibilityOnScreen(this.iconBluetooth, this.bluetoothState, this.bluetoothVisible);
                    this.wirelessChargingVisible = this.getVisibilityOnScreen(this.iconWirelessCharging, this.wirelessChargingState, this.wirelessChargingVisible);
                    this.roamingVisible = this.getVisibilityOnScreen(this.iconRoaming, this.roamingState, this.roamingVisible);
                    this.providerNameVisible = this.getVisibilityOnScreen(this.labelProvidername, this.providerNameState, this.providerNameVisible);
                    this.adbImportVisible = this.getVisibilityOnScreen(this.iconAddressbookImport, this.adbImportState, this.adbImportVisible);
                    this.adb1ImportVisible = this.getVisibilityOnScreen(this.iconAddressbook1Import, this.adb1ImportState, this.adb1ImportVisible);
                    this.adb2ImportVisible = this.getVisibilityOnScreen(this.iconAddressbook2Import, this.adb2ImportState, this.adb2ImportVisible);
                    this.smsStorageFullVisible = this.getVisibilityOnScreen(this.iconSMSStorageFull, this.smsStorageFullState, this.smsStorageFullVisible);
                    this.dragonLogoVisible = this.getVisibilityOnScreen(this.iconDragonLogo, this.dragonLogoState, this.dragonLogoVisible);
                }
                if (this.bluetoothVisible) {
                    this.addSpace(this.iconBluetooth);
                }
                if (this.wirelessChargingVisible) {
                    this.addSpace(this.iconWirelessCharging);
                }
                if (this.roamingVisible) {
                    this.addSpace(this.iconRoaming);
                }
                if (this.providerNameVisible) {
                    this.addSpace(this.labelProvidername);
                }
                if (this.adbImportVisible) {
                    this.addSpace(this.iconAddressbookImport);
                }
                if (this.adb1ImportVisible) {
                    this.addSpace(this.iconAddressbook1Import);
                }
                if (this.adb2ImportVisible) {
                    this.addSpace(this.iconAddressbook2Import);
                }
                if (this.smsStorageFullVisible) {
                    this.addSpace(this.iconSMSStorageFull);
                }
                if (this.dragonLogoVisible) {
                    this.addSpace(this.iconDragonLogo);
                }
                if (this.providerNameVisible) {
                    this.rightGroupContainer.manageLayout();
                }
                boolean[] blArray = new boolean[]{this.providerNameVisible, this.roamingVisible, this.adbImportVisible, this.adb1ImportVisible, this.adb2ImportVisible, this.smsStorageFullVisible, this.wirelessChargingVisible, this.bluetoothVisible, this.dragonLogoVisible};
                this.removeSpace(new AbstractWidgetController[]{this.labelProvidername, this.iconRoaming, this.iconAddressbookImport, this.iconAddressbook1Import, this.iconAddressbook2Import, this.iconSMSStorageFull, this.iconWirelessCharging, this.iconBluetooth, this.iconDragonLogo}, blArray);
                this.providerNameVisible = blArray[0];
                this.roamingVisible = blArray[1];
                this.adbImportVisible = blArray[2];
                this.adb1ImportVisible = blArray[3];
                this.adb2ImportVisible = blArray[4];
                this.smsStorageFullVisible = blArray[5];
                this.wirelessChargingVisible = blArray[6];
                this.bluetoothVisible = blArray[7];
                this.dragonLogoVisible = blArray[8];
                this.setIconVisibility(this.bluetoothVisible, this.adbImportVisible, this.adb1ImportVisible, this.adb2ImportVisible, false, false, false, false, false, false, this.roamingVisible, false, this.providerNameVisible, false, this.wirelessChargingVisible, false, this.smsStorageFullVisible, false, false, false, false, this.dragonLogoVisible, false, false);
                break;
            }
            case 6: {
                logMessagingStatusBar.log(10000000, "AbstractStatusBarController#doRightGroupPriorisation currentHMIContext is HMI_CONTEXT_CONNECT");
                if (!this.isViewSizeChanging() && !this.isSDSVisible()) {
                    this.providerLogoConnectVisible = this.getVisibilityOnScreen(this.iconProviderLogoConnect, this.providerLogoConnectState, this.providerLogoConnectVisible);
                    this.googleTrademarkVisible = this.getVisibilityOnScreen(this.iconGoogleTrademark, this.googleTrademarkState, this.googleTrademarkVisible);
                    this.googleProgressVisible = this.getVisibilityOnScreen(this.iconGoogleProgress, this.googleProgressState, this.googleProgressVisible);
                }
                if (this.providerLogoConnectVisible) {
                    this.addSpace(this.iconProviderLogoConnect);
                }
                if (this.googleTrademarkVisible) {
                    this.addSpace(this.iconGoogleTrademark);
                }
                if (this.googleProgressVisible) {
                    this.addSpace(this.iconGoogleProgress);
                }
                boolean[] blArray = new boolean[]{this.providerLogoConnectVisible, this.googleTrademarkVisible, this.googleProgressVisible};
                this.removeSpace(new AbstractWidgetController[]{this.iconProviderLogoConnect, this.iconGoogleTrademark, this.iconGoogleProgress}, blArray);
                this.providerLogoConnectVisible = blArray[0];
                this.googleTrademarkVisible = blArray[1];
                this.googleProgressVisible = blArray[2];
                this.setIconVisibility(false, false, false, false, this.googleProgressVisible, false, false, false, false, false, false, false, false, this.googleTrademarkVisible, false, this.providerLogoConnectVisible, false, false, false, false, false, false, false, false);
                break;
            }
            default: {
                logMessagingStatusBar.log(100000, "AbstractStatusBarController#doRightGroupPriorisation unknown hmiContext %1", (long)this.currentHMIContext);
            }
        }
    }

    public void doLeftGroupPriorisation() {
        this.neededLeftGroupSpace = iconGap;
        boolean bl = true;
        boolean bl2 = this.checkChildVisibilityViaValue(this.iconMute);
        boolean bl3 = this.checkChildVisibilityViaValue(this.iconPhoneStatus);
        boolean bl4 = this.checkChildVisibilityViaValue(this.iconPhoneSignalStrength);
        int n = hmiService.getChoiceModel(494).getValue();
        ChoiceModelApp choiceModelApp = hmiService.getChoiceModel(300370);
        int n2 = choiceModelApp != null ? choiceModelApp.getValue() : 0;
        int n3 = hmiService.getChoiceModel(3836).getValue();
        if (n == 0 && n2 != 0) {
            bl4 = false;
            if (n3 != 2) {
                bl3 = false;
            }
        }
        boolean bl5 = this.checkChildVisibilityViaValue(this.iconDataSignalStrength);
        boolean bl6 = bl5 = this.overwriteVisibilityByEsim(bl5);
        if (bl6 && bl5) {
            if (hmiService.getChoiceModel(4550).getValue() > 0) {
                bl5 = false;
            } else {
                bl6 = false;
            }
        }
        boolean bl7 = this.checkChildVisibilityViaValue(this.iconTransmission);
        bl7 = this.overwriteVisibilityByEsim(bl7);
        boolean bl8 = this.checkChildVisibilityViaValue(this.iconDataStatus);
        bl8 = this.overwriteVisibilityByEsim(bl8);
        boolean bl9 = this.checkChildVisibilityViaStatus(this.iconSystemUpdate);
        boolean bl10 = this.checkChildVisibilityViaValue(this.iconAsiaETC);
        boolean bl11 = this.checkChildVisibilityViaValue(this.iconNewMessage);
        if (this.iconMute != null && bl2) {
            this.neededLeftGroupSpace += this.iconMute.getPreferredWidth() + iconGap;
        }
        if (this.iconPhoneSignalStrength != null && bl4) {
            this.neededLeftGroupSpace += this.iconPhoneSignalStrength.getPreferredWidth() + iconGap;
        }
        if (this.iconDataSignalStrength != null && bl5) {
            this.neededLeftGroupSpace += this.iconDataSignalStrength.getPreferredWidth() + iconGap;
        }
        if (this.iconCallForwardingActive != null && bl6) {
            this.neededLeftGroupSpace += this.iconCallForwardingActive.getPreferredWidth() + iconGap;
        }
        if (bl) {
            this.neededLeftGroupSpace += this.labelClock.getPreferredWidth() + iconGap;
        }
        if (bl8) {
            this.neededLeftGroupSpace += this.iconDataStatus.getPreferredWidth();
        }
        if (bl3) {
            this.neededLeftGroupSpace += this.iconPhoneStatus.getPreferredWidth();
        }
        if (bl9) {
            this.neededLeftGroupSpace += this.iconSystemUpdate.getPreferredWidth() + iconGap;
        }
        if (!bl8) {
            bl7 = false;
        }
        if (bl10) {
            this.neededLeftGroupSpace += this.iconAsiaETC.getPreferredWidth() + iconGap;
        }
        if (bl11) {
            this.neededLeftGroupSpace += this.iconNewMessage.getPreferredWidth() + iconGap;
        }
        int n4 = (displayWidth - this.getMinGapWidth()) / 2;
        while (n4 < this.neededLeftGroupSpace) {
            if (bl9) {
                bl9 = false;
                this.neededLeftGroupSpace -= this.iconSystemUpdate.getPreferredWidth() + iconGap;
                continue;
            }
            if (bl2) {
                bl2 = false;
                this.neededLeftGroupSpace -= this.iconMute.getPreferredWidth() + iconGap;
                continue;
            }
            if (bl) {
                bl = false;
                this.neededLeftGroupSpace -= this.labelClock.getPreferredWidth() + iconGap;
                continue;
            }
            if (bl11) {
                bl11 = false;
                this.neededLeftGroupSpace -= this.iconNewMessage.getPreferredWidth() + iconGap;
                continue;
            }
            if (bl8) {
                bl8 = false;
                bl7 = false;
                this.neededLeftGroupSpace -= this.iconDataStatus.getPreferredWidth() + iconGap;
                continue;
            }
            if (bl3) {
                bl3 = false;
                this.neededLeftGroupSpace -= this.iconPhoneStatus.getPreferredWidth() + iconGap;
                continue;
            }
            if (bl5) {
                bl5 = false;
                this.neededLeftGroupSpace -= this.iconDataSignalStrength.getPreferredWidth() + iconGap;
                continue;
            }
            if (bl6) {
                bl6 = false;
                this.neededLeftGroupSpace -= this.iconCallForwardingActive.getPreferredWidth() + iconGap;
                continue;
            }
            if (bl4) {
                bl4 = false;
                this.neededLeftGroupSpace -= this.iconPhoneSignalStrength.getPreferredWidth() + iconGap;
                continue;
            }
            if (!bl10) break;
            bl10 = false;
            this.neededLeftGroupSpace -= this.iconAsiaETC.getPreferredWidth() + iconGap;
        }
        boolean bl12 = false;
        if (this.labelClockText != null && this.labelClock != null && !this.labelClockText.equals(this.labelClock.getText())) {
            bl12 = true;
            this.labelClockText = this.labelClock.getText();
        }
        if (bl12 || this.labelClock != null && this.labelClock.isVisible() != bl || this.iconMute != null && this.iconMute.isVisible() != bl2 || this.iconPhoneSignalStrength != null && this.iconPhoneSignalStrength.isVisible() != bl4 || this.iconCallForwardingActive != null && this.iconCallForwardingActive.isVisible() != bl6 || this.iconDataSignalStrength != null && this.iconDataSignalStrength.isVisible() != bl5 || this.iconTransmission != null && this.iconTransmission.isVisible() != bl7 || this.iconDataStatus != null && this.iconDataStatus.isVisible() != bl8 || this.iconPhoneStatus != null && this.iconPhoneStatus.isVisible() != bl3 || this.iconSystemUpdate != null && this.iconSystemUpdate.isVisible() != bl9 || this.iconAsiaETC != null && this.iconAsiaETC.isVisible() != bl10 || this.iconNewMessage != null && this.iconNewMessage.isVisible() != bl11) {
            this.notifyEntertainmentDrawerGapChanged();
        }
        this.setChildVisible(this.labelClock, bl);
        this.setChildVisible(this.iconMute, bl2);
        this.setChildVisible(this.iconPhoneSignalStrength, bl4);
        this.setChildVisible(this.iconCallForwardingActive, bl6);
        this.setChildVisible(this.iconDataSignalStrength, bl5);
        this.setChildVisible(this.iconTransmission, bl7);
        this.setChildVisible(this.iconDataStatus, bl8);
        this.setChildVisible(this.iconPhoneStatus, bl3);
        this.setChildVisible(this.iconSystemUpdate, bl9);
        this.setChildVisible(this.iconAsiaETC, bl10);
        this.setChildVisible(this.iconNewMessage, bl11);
    }

    private boolean overwriteVisibilityByEsim(boolean bl) {
        ChoiceModelGUI choiceModelGUI;
        ChoiceModelGUI choiceModelGUI2;
        logMessagingStatusBar.log(10000000, "AbstractStatusBarController#overwriteVisibilityByEsim(%1) - Called.", bl);
        if (this.eSimUsedChoiceModelStub == null || this.eSimStateChoiceModelStub == null) {
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#overwriteVisibilityByEsim() - No model stubs set, returning original value");
            return bl;
        }
        try {
            choiceModelGUI2 = (ChoiceModelGUI)this.eSimUsedChoiceModelStub.getModel();
            choiceModelGUI = (ChoiceModelGUI)this.eSimStateChoiceModelStub.getModel();
        }
        catch (ClassCastException classCastException) {
            logMessagingStatusBar.log(10000, "AbstractStatusBarController#overwriteVisibilityByEsim() - There are model stubs set, but they don't seem to be ChoiceModels.");
            return bl;
        }
        if (choiceModelGUI2 == null || choiceModelGUI == null) {
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#overwriteVisibilityByEsim() - No models from stubs retrieved returning orginal visibility");
            return bl;
        }
        if (choiceModelGUI2.getValue() == 1 && choiceModelGUI.getValue() == 3) {
            logMessagingStatusBar.log(10000000, "AbstractStatusBarController#overwriteVisibilityByEsim() - 'Used' = 1 and 'State' = 3, returning fix value: false");
            return false;
        }
        logMessagingStatusBar.log(10000000, "AbstractStatusBarController#overwriteVisibilityByEsim() - 'Used' != 1 and/or 'State' != 3, returning original value: %1", bl);
        return bl;
    }

    private void notifyEntertainmentDrawerGapChanged() {
        EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController = this.getEntertainmentDrawer();
        if (entertainmentDrawerOpenCloseController != null) {
            entertainmentDrawerOpenCloseController.onGapDataChanged(0);
        }
    }

    protected boolean addSpace(AbstractWidgetController abstractWidgetController) {
        if (abstractWidgetController != null) {
            this.neededRightGroupSpace += abstractWidgetController.getWidth() + iconGap;
        }
        return true;
    }

    protected boolean addSpace(LabelController labelController) {
        if (labelController != null) {
            this.neededRightGroupSpace += labelController.getPreferredWidth() + iconGap;
        }
        return true;
    }

    private boolean removeSpace(AbstractWidgetController abstractWidgetController) {
        if (abstractWidgetController != null) {
            this.neededRightGroupSpace -= abstractWidgetController.getWidth() + iconGap;
        }
        return false;
    }

    private void removeSpace(AbstractWidgetController[] abstractWidgetControllerArray, boolean[] blArray) {
        int n = 0;
        int n2 = (displayWidth - this.getMinGapWidth()) / 2;
        while (n2 < this.neededRightGroupSpace) {
            if (blArray[n]) {
                if (this.labelProvidername.equals(abstractWidgetControllerArray[n])) {
                    if (this.labelProvidername.getWidth() <= 50 && n2 > this.neededRightGroupSpace - this.labelProvidername.getPreferredWidth() + 50) {
                        blArray[n] = true;
                    } else if (this.labelProvidername.getWidth() <= 50) {
                        blArray[n] = false;
                        this.neededRightGroupSpace -= abstractWidgetControllerArray[n].getPreferredWidth() + iconGap;
                    } else if (this.neededRightGroupSpace - this.labelProvidername.getPreferredWidth() > n2) {
                        blArray[n] = false;
                        this.neededRightGroupSpace -= abstractWidgetControllerArray[n].getPreferredWidth() + iconGap;
                    }
                    logMessagingStatusBar.log(1000000, "AbstractStatusBarController#removeSpace visibility for the lablelprovidername=%2 is = %1", blArray[n], (Object)abstractWidgetControllerArray[n]);
                    logMessagingStatusBar.log(1000000, "AbstractStatusBarController#removeSpace neededRightGroupSpace=%1 ", (long)this.neededRightGroupSpace);
                } else {
                    if (!this.labelProvidername.isVisible() || !this.labelProvidername.isOnScreen()) {
                        blArray[n] = false;
                        this.neededRightGroupSpace -= abstractWidgetControllerArray[n].getWidth() + iconGap;
                    }
                    logMessagingStatusBar.log(1000000, "AbstractStatusBarController#removeSpace visibility for the icon %2 (labelProvidername is not same as icon)and is = %1 ", blArray[n], (Object)abstractWidgetControllerArray[n]);
                    logMessagingStatusBar.log(1000000, "AbstractStatusBarController#removeSpace neededRightGroupSpace=%1 ", (long)this.neededRightGroupSpace);
                }
            } else {
                logMessagingStatusBar.log(1000000, "AbstractStatusBarController#removeSpace visibility for the icon=%1 is = %2", blArray[n], (Object)abstractWidgetControllerArray[n]);
            }
            if (++n < abstractWidgetControllerArray.length) continue;
            break;
        }
    }

    public void setLocalPartOpacity(float f2) {
        logMessagingStatusBar.log(10000000, "AbstractStatusBarController#setLocalPartOpacity Set opacity to %1", (double)f2);
        if (this.labelProvidername != null) {
            this.labelProvidername.setOpacity(f2);
        }
        if (this.iconBluetooth != null) {
            this.iconBluetooth.setOpacity(f2);
        }
        if (this.iconAddressbookImport != null) {
            this.iconAddressbookImport.setOpacity(f2);
        }
        if (this.iconAddressbook1Import != null) {
            this.iconAddressbook1Import.setOpacity(f2);
        }
        if (this.iconAddressbook2Import != null) {
            this.iconAddressbook2Import.setOpacity(f2);
        }
        if (this.iconGoogleProgress != null) {
            this.iconGoogleProgress.setOpacity(f2);
        }
        if (this.iconTrafficSource != null) {
            this.iconTrafficSource.setOpacity(f2);
        }
        if (this.iconJukeboxImport != null) {
            this.iconJukeboxImport.setOpacity(f2);
        }
        if (this.iconMediaMix != null) {
            this.iconMediaMix.setOpacity(f2);
        }
        if (this.iconMediaRepeat != null) {
            this.iconMediaRepeat.setOpacity(f2);
        }
        if (this.iconGracenote != null) {
            this.iconGracenote.setOpacity(f2);
        }
        if (this.iconRoaming != null) {
            this.iconRoaming.setOpacity(f2);
        }
        if (this.iconProviderLogo != null) {
            this.iconProviderLogo.setOpacity(f2);
        }
        if (this.labelProvidername != null) {
            this.labelProvidername.setOpacity(f2);
        }
        if (this.iconGoogleTrademark != null) {
            this.iconGoogleTrademark.setOpacity(f2);
        }
        if (this.iconWirelessCharging != null) {
            this.iconWirelessCharging.setOpacity(f2);
        }
        if (this.iconProviderLogoConnect != null) {
            this.iconProviderLogoConnect.setOpacity(f2);
        }
        if (this.iconSMSStorageFull != null) {
            this.iconSMSStorageFull.setOpacity(f2);
        }
        if (this.iconBluetoothMedia != null) {
            this.iconBluetoothMedia.setOpacity(f2);
        }
        if (this.iconAsiaVICS != null) {
            this.iconAsiaVICS.setOpacity(f2);
        }
        if (this.iconAsiaTTS != null) {
            this.iconAsiaTTS.setOpacity(f2);
        }
        if (this.iconAsiaTPEG != null) {
            this.iconAsiaTPEG.setOpacity(f2);
        }
        if (this.iconDragonLogo != null) {
            this.iconDragonLogo.setOpacity(f2);
        }
        if (this.iconSelfLearningNavigation != null) {
            this.iconSelfLearningNavigation.setOpacity(f2);
        }
        if (this.iconBluetoothMediaOn != null) {
            this.iconBluetoothMediaOn.setOpacity(f2);
        }
    }

    public void setIconState(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18, int n19, int n20, int n21, int n22, int n23, int n24) {
        this.bluetoothState = n;
        this.adbImportState = n2;
        this.adb1ImportState = n3;
        this.adb2ImportState = n4;
        this.googleProgressState = n5;
        this.googleTrademarkState = n6;
        this.trafficSourceState = n7;
        this.mediaImportState = n8;
        this.mediaMixState = n9;
        this.mediaRepeatState = n10;
        this.gracenoteState = n11;
        this.roamingState = n12;
        this.providerLogoState = n13;
        this.providerNameState = n14;
        this.wirelessChargingState = n15;
        this.providerLogoConnectState = n16;
        this.smsStorageFullState = n17;
        this.bluetoothMediaState = n18;
        this.asiaVICSState = n19;
        this.asiaTTSState = n21;
        this.asiaTPEGState = n20;
        this.dragonLogoState = n22;
        this.selfLearningNavigationState = n23;
        this.bluetoothMediaOnState = n24;
    }

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }
}

