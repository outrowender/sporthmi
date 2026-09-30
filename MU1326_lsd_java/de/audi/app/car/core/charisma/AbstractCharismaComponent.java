/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.charisma.CharismaPopupHKTimerController;
import de.audi.app.car.common.charisma.CharismaPopupHandler;
import de.audi.app.car.common.comp.AbstractBaseCharismaComponent;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.handler.DefaultMenuModelHandler;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.car.core.charisma.AbstractCharismaAddInfoHandler;
import de.audi.app.car.core.charisma.CharismaAddInfoConfig;
import de.audi.app.car.core.charisma.CharismaAddInfoConfigChoiceListenerBusiness;
import de.audi.app.car.core.charisma.CharismaIndividualChoiceModelHandler;
import de.audi.app.car.core.charisma.CharismaIndividualEventBusiness;
import de.audi.app.car.core.charisma.CharismaProfileMenuEventBusiness;
import de.audi.app.car.core.charisma.DefaultCharismaAddInfoHandler;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.DrawerEvent;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Iterator;
import org.dsi.ifc.cardrivingcharacteristics.CharismaConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;

public abstract class AbstractCharismaComponent
extends AbstractBaseCharismaComponent
implements ChoiceListener {
    public static final short CODING_ID = 17;
    protected static final String LOGCHANNEL_NAME = "App.Car.Charisma";
    public static final int DISABLED = 0;
    public static final int ENABLED = 1;
    private final LocalMsgListener msgListener;
    protected volatile CharismaViewOptions currViewOptions;
    protected volatile SuspensionControlViewOptions currSuspensionViewOptions;
    protected CharismaPopupHandler popupHandler;
    private CharismaPopupHKTimerController popupHKTimer;
    private AbstractCharismaAddInfoHandler addInfoHandler;
    private int lastCheckedJokerKeyMeaning = 0;
    private CharismaIndividualChoiceModelHandler indivEngineChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivGearEngineChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivSuperPositionSteeringChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivPowerSteeringChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivACCChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivSportDifferentialChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivIntLightChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivActiveSeatChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivSteeringLightChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivSoundChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivBeltPretensionerChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivAirSuspensionChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivDamperChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivQuattroChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivRearAxleSteeringChoiceModelHandler;
    protected CharismaIndividualChoiceModelHandler indivActiveBodyControlChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivEngineStartStopChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivExhaustFlapChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivSpoilerChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivESoundChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivFreeRollingChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivExhaustSysSoundControlChoiceModelHandler;
    private CharismaIndividualChoiceModelHandler indivChassisChoiceModelHandler;
    protected CharismaIndividualChoiceModelHandler indivDriveModeChoiceModelHandler;
    private HashMap indivEntries = new HashMap(21);
    protected DefaultMenuModelHandler charismaProfileMenuHandler;
    public static final int PROFILE_NONE = -1;
    public static final int PROFILE_OFFROAD = 0;
    public static final int PROFILE_ALLROAD = 1;
    public static final int PROFILE_EFFICIENCY = 2;
    public static final int PROFILE_COMFORT = 3;
    public static final int PROFILE_AUTO_NORMAL = 4;
    public static final int PROFILE_DYNAMIC = 5;
    public static final int PROFILE_INDIVIDUAL = 6;
    public static final int PROFILE_LIFT = 7;
    public static final int PROFILE_RACE = 8;
    public static final int PROFILE_LIFT_OFFROAD = 9;
    private static final int[] WIZARD_PROFILE_TO_DSI_CONSTANT = new int[]{9, 4, 5, 1, 2, 3, 7, 9, 6, 9};
    private static final int[] DSI_CONSTANT_TO_WIZARD_PROFILE = new int[]{-1, 3, 4, 5, 1, 2, 8, 6, -1, 7};
    private static final String[] DSI_PROFILE_AS_STRING = new String[]{"unknown0", "COMFORT", "AUTO_NORMAL", "DYNAMIC", "OFFROAD_ALLROAD", "EFFICIENCY", "SPORT_RACE", "INDIVIDUAL", "RANGE", "LIFT"};
    protected static final int MAX_COUNT_FUNCTION_ID = 51;
    private int charismaListIndivTransmittableElements = 51;
    private boolean isDriveSelectScreenVisible;
    protected volatile boolean isDriveSelectMenuVisible;
    private CharismaListUpdateInfo currListUpdateInfo;
    private CharismaProgButton currProgButton;
    private final ChoiceModelApp selectedProfileChoiceModel;
    private int liftProfileName = 0;
    private final CarServiceTracker sdsServiceTracker;
    private final CharismaSDSServiceTrackerListener sdsServiceTrackerListener;
    private volatile boolean dsiAvailable = false;
    private volatile boolean isAvailableSent = false;
    private final LogChannel logMSC;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;

    public AbstractCharismaComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.popupHandler = new CharismaPopupHandler(iCarApplication, this, this.getLogChannel(), 600627);
        this.selectedProfileChoiceModel = this.getChoiceModel(600864);
        this.msgListener = new LocalMsgListener();
        this.sdsServiceTrackerListener = new CharismaSDSServiceTrackerListener();
        this.sdsServiceTracker = new CarServiceTracker(this.sdsServiceTrackerListener, iCarApplication.getBundleContext(), this.getLogChannel());
        this.logMSC = iCarApplication.getFrameworkAccess().getLogChannel("App.Car.Charisma.MSC");
    }

    public void init() {
        this.getApplication().getMessageDispatcher().addMessageListener(79, this.msgListener);
        super.init();
        this.sdsServiceTracker.startTracking();
    }

    public void deinit() {
        this.sdsServiceTracker.stopTracking();
        super.deinit();
        this.getApplication().getMessageDispatcher().removeMessageListener(79, this.msgListener);
    }

    protected void initModels() {
        this.getCharismaProfileSelectionModel().setChoiceListener(this);
        this.getCharismaProfileSelectionModel().setValue(2);
        this.getCharismaProfileSelectionModel().setStatus(0);
        this.initModelHandlerForIndividualEntries();
        this.popupHandler.init();
        this.addInfoHandler = this.getCharismaAddInfoHandler(this.getChoiceModel(601101));
        this.charismaProfileMenuHandler = new DefaultMenuModelHandler(this.getMenuModel(601204), this.getLogChannel());
        this.popupHKTimer = new CharismaPopupHKTimerController(this.getChoiceModel(601126), this.getLogChannel());
        this.popupHandler.setTimer(this.popupHKTimer);
    }

    protected AbstractCharismaAddInfoHandler getCharismaAddInfoHandler(ChoiceModelApp choiceModelApp) {
        return new DefaultCharismaAddInfoHandler(this.getLogChannel(), choiceModelApp, this.getCharismaAddInfoConfig());
    }

    protected CharismaAddInfoConfig[] getCharismaAddInfoConfig() {
        return new CharismaAddInfoConfig[0];
    }

    protected void setAddInfoHints(int n) {
        this.getChoiceModel(601101).addHint(n);
    }

    protected void initModelHandlerForIndividualEntries() {
        this.indivEngineChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(600829), this.getLogChannel());
        this.indivGearEngineChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(600831), this.getLogChannel());
        this.indivACCChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(600818), this.getLogChannel());
        this.indivSuperPositionSteeringChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(600843), this.getLogChannel());
        this.indivPowerSteeringChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(600835), this.getLogChannel());
        this.indivSportDifferentialChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(600839), this.getLogChannel());
        this.indivIntLightChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(600833), this.getLogChannel());
        this.indivActiveSeatChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(600820), this.getLogChannel());
        this.indivSteeringLightChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(600841), this.getLogChannel());
        this.indivSoundChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(600837), this.getLogChannel());
        this.indivBeltPretensionerChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(600825), this.getLogChannel());
        this.indivAirSuspensionChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(600822), this.getLogChannel());
        this.indivDamperChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(600827), this.getLogChannel());
        this.indivQuattroChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(601131), this.getLogChannel());
        this.indivRearAxleSteeringChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(601596), this.getLogChannel());
        this.indivActiveBodyControlChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(601729), this.getLogChannel());
        this.indivEngineStartStopChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(601266), this.getLogChannel());
        this.indivExhaustFlapChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(601270), this.getLogChannel());
        this.indivSpoilerChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(601274), this.getLogChannel());
        this.indivESoundChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(601268), this.getLogChannel());
        this.indivFreeRollingChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(601272), this.getLogChannel());
        this.indivExhaustSysSoundControlChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(601263), this.getLogChannel());
        this.indivDriveModeChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(601278), this.getLogChannel());
        this.indivChassisChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(602120), this.getLogChannel());
    }

    protected void deinitModels() {
        this.getCharismaProfileSelectionModel().resetListener();
        this.deinitModelHandlerForIndividualEntries();
        this.popupHandler.deinit();
        this.addInfoHandler.deinitModel();
    }

    private void deinitModelHandlerForIndividualEntries() {
        this.indivEngineChoiceModelHandler.deinitModel();
        this.indivGearEngineChoiceModelHandler.deinitModel();
        this.indivACCChoiceModelHandler.deinitModel();
        this.indivSuperPositionSteeringChoiceModelHandler.deinitModel();
        this.indivPowerSteeringChoiceModelHandler.deinitModel();
        this.indivSportDifferentialChoiceModelHandler.deinitModel();
        this.indivIntLightChoiceModelHandler.deinitModel();
        this.indivActiveSeatChoiceModelHandler.deinitModel();
        this.indivSteeringLightChoiceModelHandler.deinitModel();
        this.indivSoundChoiceModelHandler.deinitModel();
        this.indivBeltPretensionerChoiceModelHandler.deinitModel();
        this.indivAirSuspensionChoiceModelHandler.deinitModel();
        this.indivDamperChoiceModelHandler.deinitModel();
        this.indivQuattroChoiceModelHandler.deinitModel();
        this.indivEngineStartStopChoiceModelHandler.deinitModel();
        this.indivExhaustFlapChoiceModelHandler.deinitModel();
        this.indivSpoilerChoiceModelHandler.deinitModel();
        this.indivESoundChoiceModelHandler.deinitModel();
        this.indivFreeRollingChoiceModelHandler.deinitModel();
        this.indivExhaustSysSoundControlChoiceModelHandler.deinitModel();
        this.indivDriveModeChoiceModelHandler.deinitModel();
        this.indivActiveBodyControlChoiceModelHandler.deinitModel();
        this.indivChassisChoiceModelHandler.deinitModel();
    }

    protected void initBusiness() {
        this.popupHandler.initBusiness();
        this.addInfoHandler.setBusiness(new CharismaAddInfoConfigChoiceListenerBusiness(this.getLogChannel()));
        this.charismaProfileMenuHandler.setBusiness(new CharismaProfileMenuEventBusiness(this.getDSI(), this.charismaProfileMenuHandler, this.getChoiceModel(600817), this.popupHKTimer, this.getLogChannel()));
        this.initBusinessIndividualEntries();
    }

    protected void initBusinessIndividualEntries() {
        this.initIndividualBusiness(this.indivEngineChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 1, "CHARISMAFUNCTIONS_ENGINEPOWER", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivGearEngineChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 3, "CHARISMAFUNCTIONS_GEARBOXDRIVINGPOSITION", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivACCChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 9, "CHARISMAFUNCTIONS_ADAPTIVECRUISECONTROL", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivAirSuspensionChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 13, "CHARISMAFUNCTIONS_AIRSUSPENSION", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivPowerSteeringChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 5, "CHARISMAFUNCTIONS_POWERSTEERINGASSIST", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivSuperPositionSteeringChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 6, "CHARISMAFUNCTIONS_SUPERPOSITIONSTEERING", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivSteeringLightChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 11, "CHARISMAFUNCTIONS_STEERABLEBEAM", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivBeltPretensionerChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 14, "CHARISMAFUNCTIONS_PRETENSIONER", this.getLogChannel(), this.getCharismaProfileSelectionModel()), this.getChoiceModel(600826));
        this.initIndividualBusiness(this.indivIntLightChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 12, "CHARISMAFUNCTIONS_INTERIORLIGHT", this.getLogChannel(), this.getCharismaProfileSelectionModel()), this.getChoiceModel(600834));
        this.initIndividualBusiness(this.indivSoundChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 10, "CHARISMAFUNCTIONS_SOUNDACTUATOR", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivDamperChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 7, "CHARISMAFUNCTIONS_DAMPER", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivActiveSeatChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 15, "CHARISMAFUNCTIONS_SEATSIDEBOLSTERADJUSTMENT", this.getLogChannel(), this.getCharismaProfileSelectionModel()), this.getChoiceModel(600821));
        this.initIndividualBusiness(this.indivQuattroChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 22, "CHARISMAFUNCTIONS_CENTREDIFFERENTIAL", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivSportDifferentialChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 4, "CHARISMAFUNCTIONS_REARAXLEDIFFERENTIAL", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivRearAxleSteeringChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 29, "CHARISMAFUNCTIONS_REARAXLESTEERINGSYSTEM", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivActiveBodyControlChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 52, "CHARISMAFUNCTIONS_EABC", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivExhaustFlapChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 35, "CHARISMAFUNCTIONS_EXHAUSTFLAP", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivEngineStartStopChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 2, "CHARISMAFUNCTIONS_ENGINESTARTSTOP", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivSpoilerChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 27, "CHARISMAFUNCTIONS_REARSPOILER", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivFreeRollingChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 18, "CHARISMAFUNCTIONS_FREEROLLING", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivESoundChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 51, "CHARISMAFUNCTIONS_ESOUND", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivExhaustSysSoundControlChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 20, "CHARISMAFUNCTIONS_ACTIVEEXHAUSTSYSTEMSOUNDCONTROL", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivChassisChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 34, "CHARISMAFUNCTIONS_CHASSIS", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
    }

    protected void itemSelectedActiveProfile(int n) {
        int n2 = WIZARD_PROFILE_TO_DSI_CONSTANT[n];
        this.getLogChannel().log(10000000, "handleWizardActiveProfileSelection dsi.setCharismaActiveProfile(%1)", (Object)DSI_PROFILE_AS_STRING[n2]);
        this.getLogChannel().log(1000000, "dsi.setCharismaActiveProfile(%1)", (long)n2);
        this.getDSI().setCharismaActiveProfile(n2);
    }

    protected void updateCharismaProfileSelection(int n) {
        this.getLogChannel().log(10000000, "[AbstractCharismaComponent#updateCharismaProfileSelection] wizardProfile='%1' , modelID='%2'", (long)n, (long)this.getCharismaProfileSelectionModel().getID());
        this.getCharismaProfileSelectionModel().setValue(n);
        ((CharismaProfileMenuEventBusiness)this.charismaProfileMenuHandler.getBusiness()).updateActiveProfile(this.getCharismaProfileSelectionModel().getValue());
    }

    protected boolean updateActivityStateOfPerformanceMode(int n) {
        int n2 = 0;
        if (n == 8) {
            n2 = 8;
            if (this.getPopUpID() != -1) {
                this.popupHandler.removePopup();
            }
        }
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractCharismaComponent#updateActivityStateOfPerformanceMode] PerformanceMode is %1.", (Object)(n2 == 8 ? "active" : "inactive"));
        }
        this.getChoiceModel(601438).setValue(n2);
        return n2 == 8;
    }

    protected void addIndivEntry(CharismaIndividualEventBusiness charismaIndividualEventBusiness) {
        this.indivEntries.put(new Integer(charismaIndividualEventBusiness.getDsiFunctionID()), charismaIndividualEventBusiness);
    }

    protected CharismaIndividualEventBusiness getIndivEntry(int n) {
        return (CharismaIndividualEventBusiness)this.indivEntries.get(new Integer(n));
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logModelData("itemSelected:", n, n2, true);
        switch (n) {
            case 600864: {
                this.itemSelectedActiveProfile(n2);
                if (this.getPopUpID() == -1) break;
                this.popupHandler.removePopup();
                break;
            }
            default: {
                this.logModelData("itemSelected:", n, n2, false);
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
        this.logModelData("itemFocused:", n, n2, false);
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{12}, new int[]{1, 13, 14, 18, 15})};
    }

    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    public CharismaViewOptions getViewOptions() {
        return this.currViewOptions;
    }

    protected ChoiceModelApp getCharismaProfileSelectionModel() {
        return this.selectedProfileChoiceModel;
    }

    public synchronized boolean isDriveSelectScreenVisible() {
        return this.isDriveSelectScreenVisible;
    }

    protected synchronized void setDriveSelectScreenVisible(boolean bl, boolean bl2) {
        this.isDriveSelectScreenVisible = bl;
        this.isDriveSelectMenuVisible = bl2 ? false : bl;
        ((CharismaProfileMenuEventBusiness)this.charismaProfileMenuHandler.getBusiness()).updateActiveProfile(this.getCharismaProfileSelectionModel().getValue());
        if (bl2 != this.sdsServiceTrackerListener.sdsDisabled) {
            this.sdsServiceTrackerListener.setSDSDisabled(bl2);
        }
    }

    protected int getLiftProfileName() {
        return this.liftProfileName;
    }

    protected void setLiftProfileName(int n) {
        this.liftProfileName = n;
    }

    public void updateCharismaViewOptions(CharismaViewOptions charismaViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateCharismaViewOptions: charismaViewOptions=%1, valid=%2", (Object)(charismaViewOptions != null ? this.formatViewOptionsLog(charismaViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && charismaViewOptions != null) {
            this.currViewOptions = charismaViewOptions;
            this.setCharismaListTransmittableElements(charismaViewOptions.getConfiguration());
            this.updateMenuEntryVisibility(this.currViewOptions, this.currSuspensionViewOptions);
            if (!this.isAvailableSent) {
                this.isAvailableSent = true;
                super.dsiAvailable(this.dsiAvailable);
            }
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateSuspensionControlViewOptions(SuspensionControlViewOptions suspensionControlViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateSuspensionControlViewOptions: viewOptions=%1, valid=%2", (Object)(suspensionControlViewOptions != null ? this.formatViewOptionsLog(suspensionControlViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && suspensionControlViewOptions != null) {
            this.currSuspensionViewOptions = suspensionControlViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions, this.currSuspensionViewOptions);
        }
    }

    protected int getCharismaListTransmittableElements() {
        return this.charismaListIndivTransmittableElements;
    }

    private void setCharismaListTransmittableElements(CharismaConfiguration charismaConfiguration) {
        if (charismaConfiguration != null && charismaConfiguration.getCharismaListTransmittableElements() != null) {
            this.charismaListIndivTransmittableElements = charismaConfiguration.getCharismaListTransmittableElements().getRa0();
        }
    }

    public void updateCharismaActiveProfile(int n, int n2) {
        Buffer buffer = new Buffer(n).append(" (").append(DSI_PROFILE_AS_STRING[n]).append(')');
        if (n2 == 1) {
            int n3;
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[AbstractCharismaComponent#updateCharismaActiveProfile] profile=%1, valid=%2", (Object)buffer, (long)n2);
            }
            if ((n3 = this.mapDSIProfileToActiveWizardProfile(n)) == -1) {
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1000000, "[AbstractCharismaComponent#updateCharismaActiveProfile(%1)], profileId not supported -> no selection possible.", (long)n);
                }
                return;
            }
            if (this.closeOptionDrawer(n3)) {
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1000000, "[AbstractCharismaComponent#updateCharismaActiveProfile(%1)] close OptionDrawer", (long)n);
                }
                HMIService hMIService = this.getApplication().getFrameworkAccess().getHMIService();
                DrawerEvent drawerEvent = new DrawerEvent(hMIService.getRootWindow(0), 2);
                hMIService.getEventDispatcher().postEvent(drawerEvent);
            }
            this.updateCharismaProfileSelection(n3);
        }
    }

    private int mapDSIProfileToActiveWizardProfile(int n) {
        int n2 = -1;
        if (n > 0 && n < DSI_CONSTANT_TO_WIZARD_PROFILE.length) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[AbstractCharismaComponent#mapDSIProfileToActiveWizardProfile(%1)], wizard_id = %2", (long)n, (long)DSI_CONSTANT_TO_WIZARD_PROFILE[n]);
            }
            n2 = DSI_CONSTANT_TO_WIZARD_PROFILE[n];
        }
        if (n2 == 7) {
            n2 = this.getLiftProfileName();
        }
        return n2;
    }

    private boolean closeOptionDrawer(int n) {
        return this.isDriveSelectScreenVisible() && this.getChoiceModel(600817).getValue() != n;
    }

    private void updateMenuEntryVisibility(CharismaViewOptions charismaViewOptions, SuspensionControlViewOptions suspensionControlViewOptions) {
        this.setLiftProfileName(this.determineLiftProfileName(suspensionControlViewOptions));
        if (charismaViewOptions != null) {
            this.updateMenuEntryVisibility(charismaViewOptions);
        }
    }

    private int determineLiftProfileName(SuspensionControlViewOptions suspensionControlViewOptions) {
        SuspensionControlConfiguration suspensionControlConfiguration;
        if (suspensionControlViewOptions != null && (suspensionControlConfiguration = suspensionControlViewOptions.getConfiguration()) != null && suspensionControlConfiguration.getDeviceType() == 0) {
            if (suspensionControlConfiguration.getModelType() == 2 || suspensionControlConfiguration.getModelType() == 3) {
                return 9;
            }
            if (suspensionControlConfiguration.getModelType() == 0) {
                return 7;
            }
        }
        return 0;
    }

    public void showCharismaPopup(int n, int n2) {
        this.logMSC.log(1000000, "---> showCharismaContent(%1, %2)", (long)n, (long)n2);
        this.getDSI().showCharismaPopup(n, n2);
    }

    public void cancelCharismaPopup(int n, int n2) {
        this.logMSC.log(1000000, "---> cancelCharismaPopup(%1, %2)", (long)n, (long)n2);
        this.getDSI().cancelCharismaPopup(n, n2);
    }

    public void updateCharismaContent(int n, int n2) {
        this.logMSC.log(1000000, "<--- updateCharismaContent(%1, %2)", (long)n, (long)n2);
        if (n2 == 1) {
            this.popupHandler.updateCharismaContent(n);
        }
    }

    public void acknowledgeCharismaPopup(int n) {
        this.logMSC.log(1000000, "<--- acknowledgeCharismaPopup(%1)", (long)n);
        if (this.getPopUpID() != -1) {
            this.popupHandler.acknowledgePopup(n);
        }
    }

    public void requestCharismaPopup(int n) {
        this.logMSC.log(1000000, "<--- requestCharismaPopup(%1)", (long)n);
        if (this.getPopUpID() != -1 && (2 == n || 1 == n || 0 == n)) {
            if (this.isDriveSelectMenuVisible) {
                this.getLogChannel().log(1000000, "[AbstractCharismaComponent#requestCharismaPopup] mirror request while bein in charisma menu screen: DSI.showCharismaPopup(%1, %2)", (long)n, 0L);
                this.showCharismaPopup(n, 0);
            } else if (!this.isWholeCharismaPopupContentDisabled()) {
                this.popupHandler.requestCharismaPopup(n, true);
            } else {
                this.getLogChannel().log(1000000, "[AbstractCharismaComponent#requestCharismaPopup] whole CharismaPopup content is disabled --> reject request: DSI.showCharismaPopup(%1, %2)", 0L, 1L);
                this.showCharismaPopup(0, 1);
            }
        }
        if (5 == n) {
            this.popupHandler.setCurrentProfile(n);
        }
    }

    protected boolean isWholeCharismaPopupContentDisabled() {
        return false;
    }

    public void updateCharismaListUpdateInfo(CharismaListUpdateInfo charismaListUpdateInfo, int n) {
        if (n == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "updateCharismaListUpdateInfo %1, %2", (Object)charismaListUpdateInfo, (long)n);
            }
            if (this.isProfileIndividualOperational()) {
                CharismaListUpdateInfo charismaListUpdateInfo2 = this.currListUpdateInfo = charismaListUpdateInfo;
                if (this.currListUpdateInfo.getProfileID() == 255 && this.currListUpdateInfo.getArrayContent() == 1 && this.currListUpdateInfo.getRecordContent() == 1) {
                    charismaListUpdateInfo2.profileID = 7;
                    charismaListUpdateInfo2.startElement = 0;
                    charismaListUpdateInfo2.numOfElements = this.getCharismaListTransmittableElements();
                    if (this.getLogChannel().isInfo()) {
                        this.getLogChannel().log(1000000, "updateCharismaListUpdateInfo - NOPROFILE_INIT received -> dsi.requestCharismaList %1", (Object)charismaListUpdateInfo);
                    }
                    this.getDSI().requestCharismaList(charismaListUpdateInfo2);
                } else if (this.currListUpdateInfo.getProfileID() == 7 && this.currListUpdateInfo.getArrayContent() == 2 && this.currListUpdateInfo.getRecordContent() == 2) {
                    if (this.getLogChannel().isInfo()) {
                        this.getLogChannel().log(1000000, "updateCharismaListUpdateInfo single/more data dsi.requestCharismaList(%1)", (Object)charismaListUpdateInfo2);
                    }
                    this.getDSI().requestCharismaList(charismaListUpdateInfo2);
                } else if (this.currListUpdateInfo.getProfileID() == 7 && this.currListUpdateInfo.getArrayContent() == 1 && this.currListUpdateInfo.getRecordContent() == 2 && this.currListUpdateInfo.getStartElement() == 0) {
                    if (this.getLogChannel().isInfo()) {
                        this.getLogChannel().log(1000000, "updateCharismaListUpdateInfo single/more data by ASG dsi.requestCharismaList(%1)", (Object)charismaListUpdateInfo2);
                    }
                    this.getDSI().requestCharismaList(charismaListUpdateInfo2);
                } else {
                    this.getLogChannel().log(1000000, "updateCharismaListUpdateInfo %1 ignored, profileID/arrayC/recC mismatch", (Object)charismaListUpdateInfo);
                }
            } else {
                this.getLogChannel().log(10000000, "[AbstractCharismaComponent#updateCharismaListUpdateInfo] updateCharismaListUpdateInfo %1 ignored: profileIndividual is not operational", (Object)charismaListUpdateInfo);
            }
        }
    }

    public void updateCharismaProgButton(CharismaProgButton charismaProgButton, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateCharismaProgButton: progButton=%1, valid=%2", (Object)(null != charismaProgButton ? charismaProgButton.toString() : "null"), (long)n);
        }
        if (n == 1) {
            boolean bl;
            this.currProgButton = charismaProgButton;
            boolean bl2 = bl = this.getChoiceModel(395).getValue() == 2;
            if (this.currProgButton.isButton1() != bl) {
                CharismaProgButton charismaProgButton2 = new CharismaProgButton(bl, false, false, false, false);
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1000000, "updateCharismaProgButton: sync joker key setting, dsi.setCharismaProgButton( %1 )", (Object)charismaProgButton2);
                }
                this.getDSI().setCharismaProgButton(charismaProgButton2);
            }
        }
    }

    public void responseCharismaListWithOptionMask(int n, int n2, int n3, CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
        if (this.getLogChannel().isInfo()) {
            Buffer buffer = new Buffer("responseCharismaListWithOptionMask profileID=").append(n);
            buffer.append(", arrayContent=").append(n2);
            buffer.append(", recordContent=").append(n3);
            buffer.append(", setupTable=").append(charismaSetupTableWithOptionMaskArray);
            this.getLogChannel().log(1000000, buffer.toString());
        }
        if (n == 7 && n2 == 1 && n3 == 1) {
            this.clearAllIndividualEntries();
            for (int i2 = 0; i2 < charismaSetupTableWithOptionMaskArray.length; ++i2) {
                try {
                    CharismaSetupTableWithOptionMask charismaSetupTableWithOptionMask = charismaSetupTableWithOptionMaskArray[i2];
                    CharismaIndividualEventBusiness charismaIndividualEventBusiness = (CharismaIndividualEventBusiness)this.indivEntries.get(new Integer(charismaSetupTableWithOptionMask.getFunctionID()));
                    if (charismaIndividualEventBusiness != null) {
                        charismaIndividualEventBusiness.processSetupTableEntryWithOptionMask(charismaSetupTableWithOptionMask);
                        continue;
                    }
                    this.getLogChannel().log(10000, "responseCharismaListWithOptionMask: function ID %1 does not exist in HMI inidvidual menu", (long)charismaSetupTableWithOptionMask.getFunctionID());
                    continue;
                }
                catch (RuntimeException runtimeException) {
                    runtimeException.printStackTrace();
                }
            }
            this.hideIndividualEntriesThatWereNotAddressedBySetupTable();
        } else {
            this.getLogChannel().log(100000, "responseCharismaListWithOptionMask arrayContent/recordContent mismatch");
        }
    }

    protected void hideIndividualEntriesThatWereNotAddressedBySetupTable() {
        Iterator iterator = this.indivEntries.values().iterator();
        while (iterator.hasNext()) {
            ((CharismaIndividualEventBusiness)iterator.next()).setInvisibleWhenNoInfoWasReceived();
        }
    }

    protected void clearAllIndividualEntries() {
        Iterator iterator = this.indivEntries.values().iterator();
        while (iterator.hasNext()) {
            ((CharismaIndividualEventBusiness)iterator.next()).clear();
        }
    }

    public void responseCharismaListWithoutOptionMask(int n, int n2, int n3, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        if (this.getLogChannel().isInfo()) {
            Buffer buffer = new Buffer("responseCharismaListWithoutOptionMask profileID=").append(n);
            buffer.append(", arrayContent=").append(n2);
            buffer.append(", recordContent=").append(n3);
            buffer.append(", setupTable=").append(charismaSetupTableWithoutOptionMaskArray);
            this.getLogChannel().log(1000000, buffer.toString());
        }
        if (n == 7 && (n2 == 1 || n2 == 2)) {
            for (int i2 = 0; i2 < charismaSetupTableWithoutOptionMaskArray.length; ++i2) {
                CharismaSetupTableWithoutOptionMask charismaSetupTableWithoutOptionMask = charismaSetupTableWithoutOptionMaskArray[i2];
                CharismaIndividualEventBusiness charismaIndividualEventBusiness = (CharismaIndividualEventBusiness)this.indivEntries.get(new Integer(charismaSetupTableWithoutOptionMask.getFunctionID()));
                if (charismaIndividualEventBusiness != null) {
                    charismaIndividualEventBusiness.processSetupTableEntryWithoutOptionMask(charismaSetupTableWithoutOptionMask);
                    continue;
                }
                this.getLogChannel().log(10000, "responseCharismaListWithoutOptionMask: function ID %1 does not exist in HMI inidvidual menu", (long)charismaSetupTableWithoutOptionMask.getFunctionID());
            }
        }
    }

    public void updateCharismaTrailerDetection(boolean bl, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractCharismaComponent#updateCharismaTrailerDetection] trailerDetection='%1', valid='%2'", bl, (long)n);
        }
        if (n == 1) {
            this.getChoiceModel(600865).setValue(bl ? 1 : 0);
        }
    }

    protected abstract void updateMenuEntryVisibility(CharismaViewOptions var1);

    protected abstract void initIndividualBusiness(CharismaIndividualChoiceModelHandler var1, CharismaIndividualEventBusiness var2);

    protected abstract void initIndividualBusiness(CharismaIndividualChoiceModelHandler var1, CharismaIndividualEventBusiness var2, ChoiceModelApp var3);

    protected abstract boolean isProfileIndividualOperational();

    public String getName() {
        return "Charisma";
    }

    protected void dsiAvailable(boolean bl) {
        this.dsiAvailable = bl;
    }

    protected void toggleESound() {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class LocalMsgListener
    implements MsgListener {
        private LocalMsgListener() {
        }

        public void processMsg(int n) {
            if (79 == n) {
                Object object;
                boolean bl;
                int n2 = AbstractCharismaComponent.this.getChoiceModel(395).getValue();
                boolean bl2 = bl = 2 == n2;
                if (AbstractCharismaComponent.this.currProgButton != null && AbstractCharismaComponent.this.currProgButton.isButton1() != bl && this.isRelevantJokerKeyMeaningChange(n2)) {
                    object = new CharismaProgButton(bl, false, false, false, false);
                    if (AbstractCharismaComponent.this.getLogChannel().isDebug()) {
                        AbstractCharismaComponent.this.getLogChannel().log(10000000, "processMsg: dsi.setCharismaProgButton( %1 )", object);
                    }
                    AbstractCharismaComponent.this.getDSI().setCharismaProgButton((CharismaProgButton)object);
                }
                if (81 == n2 && null != (object = AbstractCharismaComponent.this.getButtonModel(600977))) {
                    object.setButtonListener(new JokerKeyButtonListener());
                }
                AbstractCharismaComponent.this.lastCheckedJokerKeyMeaning = n2;
            }
        }

        private boolean isRelevantJokerKeyMeaningChange(int n) {
            return AbstractCharismaComponent.this.lastCheckedJokerKeyMeaning == 2 && n != 2 || AbstractCharismaComponent.this.lastCheckedJokerKeyMeaning != 2 && n == 2;
        }
    }

    private class JokerKeyButtonListener
    extends DefaultButtonListener {
        private JokerKeyButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            switch (n) {
                case 600977: {
                    AbstractCharismaComponent.this.logModelData("keyPressed", n, n2, true);
                    break;
                }
                default: {
                    AbstractCharismaComponent.this.logModelData("keyPressed", n, n2, false);
                }
            }
        }

        public void keyReleased(int n, int n2, int n3) {
            if (600977 == n) {
                int n4 = AbstractCharismaComponent.this.getChoiceModel(395).getValue();
                switch (n4) {
                    case 81: {
                        AbstractCharismaComponent.this.toggleESound();
                        break;
                    }
                    default: {
                        AbstractCharismaComponent.this.logModelData("keyReleased", n, n2, false);
                        break;
                    }
                }
            } else {
                AbstractCharismaComponent.this.logModelData("keyReleased", n, n2, false);
            }
        }
    }

    private class CharismaSDSServiceTrackerListener
    implements CarServiceTrackerListener {
        private volatile SDSService sdsService;
        private volatile boolean sdsDisabled = false;

        private CharismaSDSServiceTrackerListener() {
        }

        public void serviceAvailable(Object object) {
            AbstractCharismaComponent.this.getLogChannel().log(1000000, "[CharismaSDSServiceTrackerListener#serviceAvailable] SDS service received");
            try {
                this.sdsService = (SDSService)object;
                this.setSDSDisabled(this.sdsDisabled);
            }
            catch (ClassCastException classCastException) {
                AbstractCharismaComponent.this.getLogChannel().log(1000, "[CharismaSDSServiceTrackerListener#serviceAvailable] sdsServiceTracker: cannot cast service");
            }
        }

        public void serviceRemoved() {
            AbstractCharismaComponent.this.getLogChannel().log(10000000, "[CharismaSDSServiceTrackerListener#serviceRemoved] SDS Service has been removed");
            this.sdsService = null;
        }

        public String[] getTrackedServiceClazzName() {
            return new String[]{(class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = AbstractCharismaComponent.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName()};
        }

        public synchronized void setSDSDisabled(boolean bl) {
            this.sdsDisabled = bl;
            if (this.sdsService != null) {
                AbstractCharismaComponent.this.getLogChannel().log(10000000, "[CharismaSDSServiceTrackerListener#setSDSDisabled] call sdsService.disablePTT(%1)", bl);
                try {
                    this.sdsService.disablePTT(bl, false, (byte)8);
                }
                catch (Exception exception) {
                    AbstractCharismaComponent.this.getLogChannel().log(1000, "[CharismaSDSServiceTrackerListener#setSDSDisabled] Caught exception while calling sdsService.disablePTT(): disabler=SDSService.PTT_DISABLER_DRIVE_SELECT", (Throwable)exception);
                }
            } else {
                AbstractCharismaComponent.this.getLogChannel().log(100000, "[CharismaSDSServiceTrackerListener#setSDSDisabled] SDS service not available");
            }
        }
    }
}

