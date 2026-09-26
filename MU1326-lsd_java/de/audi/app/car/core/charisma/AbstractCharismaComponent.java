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
import de.audi.app.car.core.charisma.AbstractCharismaAddInfoHandler;
import de.audi.app.car.core.charisma.AbstractCharismaComponent$CharismaSDSServiceTrackerListener;
import de.audi.app.car.core.charisma.AbstractCharismaComponent$LocalMsgListener;
import de.audi.app.car.core.charisma.CharismaAddInfoConfig;
import de.audi.app.car.core.charisma.CharismaAddInfoConfigChoiceListenerBusiness;
import de.audi.app.car.core.charisma.CharismaIndividualChoiceModelHandler;
import de.audi.app.car.core.charisma.CharismaIndividualEventBusiness;
import de.audi.app.car.core.charisma.CharismaProfileMenuEventBusiness;
import de.audi.app.car.core.charisma.DefaultCharismaAddInfoHandler;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.DrawerEvent;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
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
    public static final short CODING_ID;
    protected static final String LOGCHANNEL_NAME;
    public static final int DISABLED;
    public static final int ENABLED;
    private final AbstractCharismaComponent$LocalMsgListener msgListener;
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
    public static final int PROFILE_NONE;
    public static final int PROFILE_OFFROAD;
    public static final int PROFILE_ALLROAD;
    public static final int PROFILE_EFFICIENCY;
    public static final int PROFILE_COMFORT;
    public static final int PROFILE_AUTO_NORMAL;
    public static final int PROFILE_DYNAMIC;
    public static final int PROFILE_INDIVIDUAL;
    public static final int PROFILE_LIFT;
    public static final int PROFILE_RACE;
    public static final int PROFILE_LIFT_OFFROAD;
    private static final int[] WIZARD_PROFILE_TO_DSI_CONSTANT;
    private static final int[] DSI_CONSTANT_TO_WIZARD_PROFILE;
    private static final String[] DSI_PROFILE_AS_STRING;
    protected static final int MAX_COUNT_FUNCTION_ID;
    private int charismaListIndivTransmittableElements = 51;
    private boolean isDriveSelectScreenVisible;
    protected volatile boolean isDriveSelectMenuVisible;
    private CharismaListUpdateInfo currListUpdateInfo;
    private CharismaProgButton currProgButton;
    private final ChoiceModelApp selectedProfileChoiceModel;
    private int liftProfileName = 0;
    private final CarServiceTracker sdsServiceTracker;
    private final AbstractCharismaComponent$CharismaSDSServiceTrackerListener sdsServiceTrackerListener;
    private volatile boolean dsiAvailable = false;
    private volatile boolean isAvailableSent = false;
    private final LogChannel logMSC;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;

    public AbstractCharismaComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Charisma");
        this.popupHandler = new CharismaPopupHandler(iCarApplication, this, this.getLogChannel(), 858392832);
        this.selectedProfileChoiceModel = this.getChoiceModel(539691264);
        this.msgListener = new AbstractCharismaComponent$LocalMsgListener(this, null);
        this.sdsServiceTrackerListener = new AbstractCharismaComponent$CharismaSDSServiceTrackerListener(this, null);
        this.sdsServiceTracker = new CarServiceTracker(this.sdsServiceTrackerListener, iCarApplication.getBundleContext(), this.getLogChannel());
        this.logMSC = iCarApplication.getFrameworkAccess().getLogChannel("App.Car.Charisma.MSC");
    }

    @Override
    public void init() {
        this.getApplication().getMessageDispatcher().addMessageListener(79, this.msgListener);
        super.init();
        this.sdsServiceTracker.startTracking();
    }

    @Override
    public void deinit() {
        this.sdsServiceTracker.stopTracking();
        super.deinit();
        this.getApplication().getMessageDispatcher().removeMessageListener(79, this.msgListener);
    }

    @Override
    protected void initModels() {
        this.getCharismaProfileSelectionModel().setChoiceListener(this);
        this.getCharismaProfileSelectionModel().setValue(2);
        this.getCharismaProfileSelectionModel().setStatus(0);
        this.initModelHandlerForIndividualEntries();
        this.popupHandler.init();
        this.addInfoHandler = this.getCharismaAddInfoHandler(this.getChoiceModel(220989696));
        this.charismaProfileMenuHandler = new DefaultMenuModelHandler(this.getMenuModel(1949042944), this.getLogChannel());
        this.popupHKTimer = new CharismaPopupHKTimerController(this.getChoiceModel(640420096), this.getLogChannel());
        this.popupHandler.setTimer(this.popupHKTimer);
    }

    protected AbstractCharismaAddInfoHandler getCharismaAddInfoHandler(ChoiceModelApp choiceModelApp) {
        return new DefaultCharismaAddInfoHandler(this.getLogChannel(), choiceModelApp, this.getCharismaAddInfoConfig());
    }

    protected CharismaAddInfoConfig[] getCharismaAddInfoConfig() {
        return new CharismaAddInfoConfig[0];
    }

    protected void setAddInfoHints(int n) {
        this.getChoiceModel(220989696).addHint(n);
    }

    protected void initModelHandlerForIndividualEntries() {
        this.indivEngineChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(-47576832), this.getLogChannel());
        this.indivGearEngineChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(-14022400), this.getLogChannel());
        this.indivACCChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(-232126208), this.getLogChannel());
        this.indivSuperPositionSteeringChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(187369728), this.getLogChannel());
        this.indivPowerSteeringChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(53152000), this.getLogChannel());
        this.indivSportDifferentialChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(120260864), this.getLogChannel());
        this.indivIntLightChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(19597568), this.getLogChannel());
        this.indivActiveSeatChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(-198571776), this.getLogChannel());
        this.indivSteeringLightChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(153815296), this.getLogChannel());
        this.indivSoundChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(86706432), this.getLogChannel());
        this.indivBeltPretensionerChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(-114685696), this.getLogChannel());
        this.indivAirSuspensionChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(-165017344), this.getLogChannel());
        this.indivDamperChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(-81131264), this.getLogChannel());
        this.indivQuattroChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(724306176), this.getLogChannel());
        this.indivRearAxleSteeringChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(-64157440), this.getLogChannel());
        this.indivActiveBodyControlChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(-2127689472), this.getLogChannel());
        this.indivEngineStartStopChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(-1305736960), this.getLogChannel());
        this.indivExhaustFlapChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(-1238628096), this.getLogChannel());
        this.indivSpoilerChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(-1171519232), this.getLogChannel());
        this.indivESoundChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(-1272182528), this.getLogChannel());
        this.indivFreeRollingChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(-1205073664), this.getLogChannel());
        this.indivExhaustSysSoundControlChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(-1356068608), this.getLogChannel());
        this.indivDriveModeChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(-1104410368), this.getLogChannel());
        this.indivChassisChoiceModelHandler = new CharismaIndividualChoiceModelHandler(this.getChoiceModel(137365760), this.getLogChannel());
    }

    @Override
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

    @Override
    protected void initBusiness() {
        this.popupHandler.initBusiness();
        this.addInfoHandler.setBusiness(new CharismaAddInfoConfigChoiceListenerBusiness(this.getLogChannel()));
        this.charismaProfileMenuHandler.setBusiness(new CharismaProfileMenuEventBusiness(this.getDSI(), this.charismaProfileMenuHandler, this.getChoiceModel(-248903424), this.popupHKTimer, this.getLogChannel()));
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
        this.initIndividualBusiness(this.indivBeltPretensionerChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 14, "CHARISMAFUNCTIONS_PRETENSIONER", this.getLogChannel(), this.getCharismaProfileSelectionModel()), this.getChoiceModel(-97908480));
        this.initIndividualBusiness(this.indivIntLightChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 12, "CHARISMAFUNCTIONS_INTERIORLIGHT", this.getLogChannel(), this.getCharismaProfileSelectionModel()), this.getChoiceModel(36374784));
        this.initIndividualBusiness(this.indivSoundChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 10, "CHARISMAFUNCTIONS_SOUNDACTUATOR", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivDamperChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 7, "CHARISMAFUNCTIONS_DAMPER", this.getLogChannel(), this.getCharismaProfileSelectionModel()));
        this.initIndividualBusiness(this.indivActiveSeatChoiceModelHandler, new CharismaIndividualEventBusiness(this.getDSI(), 15, "CHARISMAFUNCTIONS_SEATSIDEBOLSTERADJUSTMENT", this.getLogChannel(), this.getCharismaProfileSelectionModel()), this.getChoiceModel(-181794560));
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
        this.getLogChannel().log(-2137614336, "handleWizardActiveProfileSelection dsi.setCharismaActiveProfile(%1)", (Object)DSI_PROFILE_AS_STRING[n2]);
        this.getLogChannel().log(1078071040, "dsi.setCharismaActiveProfile(%1)", (long)n2);
        this.getDSI().setCharismaActiveProfile(n2);
    }

    protected void updateCharismaProfileSelection(int n) {
        this.getLogChannel().log(-2137614336, "[AbstractCharismaComponent#updateCharismaProfileSelection] wizardProfile='%1' , modelID='%2'", (long)n, (long)this.getCharismaProfileSelectionModel().getID());
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
            this.getLogChannel().log(1078071040, "[AbstractCharismaComponent#updateActivityStateOfPerformanceMode] PerformanceMode is %1.", (Object)(n2 == 8 ? "active" : "inactive"));
        }
        this.getChoiceModel(1580009728).setValue(n2);
        return n2 == 8;
    }

    protected void addIndivEntry(CharismaIndividualEventBusiness charismaIndividualEventBusiness) {
        this.indivEntries.put(new Integer(charismaIndividualEventBusiness.getDsiFunctionID()), charismaIndividualEventBusiness);
    }

    protected CharismaIndividualEventBusiness getIndivEntry(int n) {
        return (CharismaIndividualEventBusiness)this.indivEntries.get(new Integer(n));
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
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

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
        this.logModelData("itemFocused:", n, n2, false);
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{12}, new int[]{1, 13, 14, 18, 15})};
    }

    @Override
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

    @Override
    public synchronized boolean isDriveSelectScreenVisible() {
        return this.isDriveSelectScreenVisible;
    }

    protected synchronized void setDriveSelectScreenVisible(boolean bl, boolean bl2) {
        this.isDriveSelectScreenVisible = bl;
        this.isDriveSelectMenuVisible = bl2 ? false : bl;
        ((CharismaProfileMenuEventBusiness)this.charismaProfileMenuHandler.getBusiness()).updateActiveProfile(this.getCharismaProfileSelectionModel().getValue());
        if (bl2 != AbstractCharismaComponent$CharismaSDSServiceTrackerListener.access$1200(this.sdsServiceTrackerListener)) {
            this.sdsServiceTrackerListener.setSDSDisabled(bl2);
        }
    }

    protected int getLiftProfileName() {
        return this.liftProfileName;
    }

    protected void setLiftProfileName(int n) {
        this.liftProfileName = n;
    }

    @Override
    public void updateCharismaViewOptions(CharismaViewOptions charismaViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "updateCharismaViewOptions: charismaViewOptions=%1, valid=%2", (Object)(charismaViewOptions != null ? this.formatViewOptionsLog(charismaViewOptions.toString()) : "null"), (long)n);
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

    @Override
    public void updateSuspensionControlViewOptions(SuspensionControlViewOptions suspensionControlViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "updateSuspensionControlViewOptions: viewOptions=%1, valid=%2", (Object)(suspensionControlViewOptions != null ? this.formatViewOptionsLog(suspensionControlViewOptions.toString()) : "null"), (long)n);
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

    @Override
    public void updateCharismaActiveProfile(int n, int n2) {
        Buffer buffer = new Buffer(n).append(" (").append(DSI_PROFILE_AS_STRING[n]).append(')');
        if (n2 == 1) {
            int n3;
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[AbstractCharismaComponent#updateCharismaActiveProfile] profile=%1, valid=%2", (Object)buffer, (long)n2);
            }
            if ((n3 = this.mapDSIProfileToActiveWizardProfile(n)) == -1) {
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1078071040, "[AbstractCharismaComponent#updateCharismaActiveProfile(%1)], profileId not supported -> no selection possible.", (long)n);
                }
                return;
            }
            if (this.closeOptionDrawer(n3)) {
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1078071040, "[AbstractCharismaComponent#updateCharismaActiveProfile(%1)] close OptionDrawer", (long)n);
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
                this.getLogChannel().log(1078071040, "[AbstractCharismaComponent#mapDSIProfileToActiveWizardProfile(%1)], wizard_id = %2", (long)n, (long)DSI_CONSTANT_TO_WIZARD_PROFILE[n]);
            }
            n2 = DSI_CONSTANT_TO_WIZARD_PROFILE[n];
        }
        if (n2 == 7) {
            n2 = this.getLiftProfileName();
        }
        return n2;
    }

    private boolean closeOptionDrawer(int n) {
        return this.isDriveSelectScreenVisible() && this.getChoiceModel(-248903424).getValue() != n;
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

    @Override
    public void showCharismaPopup(int n, int n2) {
        this.logMSC.log(1078071040, "---> showCharismaContent(%1, %2)", (long)n, (long)n2);
        this.getDSI().showCharismaPopup(n, n2);
    }

    @Override
    public void cancelCharismaPopup(int n, int n2) {
        this.logMSC.log(1078071040, "---> cancelCharismaPopup(%1, %2)", (long)n, (long)n2);
        this.getDSI().cancelCharismaPopup(n, n2);
    }

    @Override
    public void updateCharismaContent(int n, int n2) {
        this.logMSC.log(1078071040, "<--- updateCharismaContent(%1, %2)", (long)n, (long)n2);
        if (n2 == 1) {
            this.popupHandler.updateCharismaContent(n);
        }
    }

    @Override
    public void acknowledgeCharismaPopup(int n) {
        this.logMSC.log(1078071040, "<--- acknowledgeCharismaPopup(%1)", (long)n);
        if (this.getPopUpID() != -1) {
            this.popupHandler.acknowledgePopup(n);
        }
    }

    @Override
    public void requestCharismaPopup(int n) {
        this.logMSC.log(1078071040, "<--- requestCharismaPopup(%1)", (long)n);
        if (this.getPopUpID() != -1 && (2 == n || 1 == n || 0 == n)) {
            if (this.isDriveSelectMenuVisible) {
                this.getLogChannel().log(1078071040, "[AbstractCharismaComponent#requestCharismaPopup] mirror request while bein in charisma menu screen: DSI.showCharismaPopup(%1, %2)", (long)n, 0L);
                this.showCharismaPopup(n, 0);
            } else if (!this.isWholeCharismaPopupContentDisabled()) {
                this.popupHandler.requestCharismaPopup(n, true);
            } else {
                this.getLogChannel().log(1078071040, "[AbstractCharismaComponent#requestCharismaPopup] whole CharismaPopup content is disabled --> reject request: DSI.showCharismaPopup(%1, %2)", 0L, 1L);
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

    @Override
    public void updateCharismaListUpdateInfo(CharismaListUpdateInfo charismaListUpdateInfo, int n) {
        if (n == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "updateCharismaListUpdateInfo %1, %2", (Object)charismaListUpdateInfo, (long)n);
            }
            if (this.isProfileIndividualOperational()) {
                CharismaListUpdateInfo charismaListUpdateInfo2 = this.currListUpdateInfo = charismaListUpdateInfo;
                if (this.currListUpdateInfo.getProfileID() == 255 && this.currListUpdateInfo.getArrayContent() == 1 && this.currListUpdateInfo.getRecordContent() == 1) {
                    charismaListUpdateInfo2.profileID = 7;
                    charismaListUpdateInfo2.startElement = 0;
                    charismaListUpdateInfo2.numOfElements = this.getCharismaListTransmittableElements();
                    if (this.getLogChannel().isInfo()) {
                        this.getLogChannel().log(1078071040, "updateCharismaListUpdateInfo - NOPROFILE_INIT received -> dsi.requestCharismaList %1", (Object)charismaListUpdateInfo);
                    }
                    this.getDSI().requestCharismaList(charismaListUpdateInfo2);
                } else if (this.currListUpdateInfo.getProfileID() == 7 && this.currListUpdateInfo.getArrayContent() == 2 && this.currListUpdateInfo.getRecordContent() == 2) {
                    if (this.getLogChannel().isInfo()) {
                        this.getLogChannel().log(1078071040, "updateCharismaListUpdateInfo single/more data dsi.requestCharismaList(%1)", (Object)charismaListUpdateInfo2);
                    }
                    this.getDSI().requestCharismaList(charismaListUpdateInfo2);
                } else if (this.currListUpdateInfo.getProfileID() == 7 && this.currListUpdateInfo.getArrayContent() == 1 && this.currListUpdateInfo.getRecordContent() == 2 && this.currListUpdateInfo.getStartElement() == 0) {
                    if (this.getLogChannel().isInfo()) {
                        this.getLogChannel().log(1078071040, "updateCharismaListUpdateInfo single/more data by ASG dsi.requestCharismaList(%1)", (Object)charismaListUpdateInfo2);
                    }
                    this.getDSI().requestCharismaList(charismaListUpdateInfo2);
                } else {
                    this.getLogChannel().log(1078071040, "updateCharismaListUpdateInfo %1 ignored, profileID/arrayC/recC mismatch", (Object)charismaListUpdateInfo);
                }
            } else {
                this.getLogChannel().log(-2137614336, "[AbstractCharismaComponent#updateCharismaListUpdateInfo] updateCharismaListUpdateInfo %1 ignored: profileIndividual is not operational", (Object)charismaListUpdateInfo);
            }
        }
    }

    @Override
    public void updateCharismaProgButton(CharismaProgButton charismaProgButton, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "updateCharismaProgButton: progButton=%1, valid=%2", (Object)(null != charismaProgButton ? charismaProgButton.toString() : "null"), (long)n);
        }
        if (n == 1) {
            boolean bl;
            this.currProgButton = charismaProgButton;
            boolean bl2 = bl = this.getChoiceModel(395).getValue() == 2;
            if (this.currProgButton.isButton1() != bl) {
                CharismaProgButton charismaProgButton2 = new CharismaProgButton(bl, false, false, false, false);
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1078071040, "updateCharismaProgButton: sync joker key setting, dsi.setCharismaProgButton( %1 )", (Object)charismaProgButton2);
                }
                this.getDSI().setCharismaProgButton(charismaProgButton2);
            }
        }
    }

    @Override
    public void responseCharismaListWithOptionMask(int n, int n2, int n3, CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
        if (this.getLogChannel().isInfo()) {
            Buffer buffer = new Buffer("responseCharismaListWithOptionMask profileID=").append(n);
            buffer.append(", arrayContent=").append(n2);
            buffer.append(", recordContent=").append(n3);
            buffer.append(", setupTable=").append(charismaSetupTableWithOptionMaskArray);
            this.getLogChannel().log(1078071040, buffer.toString());
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
            this.getLogChannel().log(-1601830656, "responseCharismaListWithOptionMask arrayContent/recordContent mismatch");
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

    @Override
    public void responseCharismaListWithoutOptionMask(int n, int n2, int n3, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        if (this.getLogChannel().isInfo()) {
            Buffer buffer = new Buffer("responseCharismaListWithoutOptionMask profileID=").append(n);
            buffer.append(", arrayContent=").append(n2);
            buffer.append(", recordContent=").append(n3);
            buffer.append(", setupTable=").append(charismaSetupTableWithoutOptionMaskArray);
            this.getLogChannel().log(1078071040, buffer.toString());
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

    @Override
    public void updateCharismaTrailerDetection(boolean bl, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractCharismaComponent#updateCharismaTrailerDetection] trailerDetection='%1', valid='%2'", bl, (long)n);
        }
        if (n == 1) {
            this.getChoiceModel(556468480).setValue(bl ? 1 : 0);
        }
    }

    protected abstract void updateMenuEntryVisibility(CharismaViewOptions charismaViewOptions) {
    }

    protected abstract void initIndividualBusiness(CharismaIndividualChoiceModelHandler charismaIndividualChoiceModelHandler, CharismaIndividualEventBusiness charismaIndividualEventBusiness) {
    }

    protected abstract void initIndividualBusiness(CharismaIndividualChoiceModelHandler charismaIndividualChoiceModelHandler, CharismaIndividualEventBusiness charismaIndividualEventBusiness, ChoiceModelApp choiceModelApp) {
    }

    protected abstract boolean isProfileIndividualOperational() {
    }

    @Override
    public String getName() {
        return "Charisma";
    }

    @Override
    protected void dsiAvailable(boolean bl) {
        this.dsiAvailable = bl;
    }

    protected void toggleESound() {
    }

    static /* synthetic */ void access$000(AbstractCharismaComponent abstractCharismaComponent, String string, int n, int n2, boolean bl) {
        abstractCharismaComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$100(AbstractCharismaComponent abstractCharismaComponent, String string, int n, int n2, boolean bl) {
        abstractCharismaComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ ChoiceModelApp access$200(AbstractCharismaComponent abstractCharismaComponent, int n) {
        return abstractCharismaComponent.getChoiceModel(n);
    }

    static /* synthetic */ void access$300(AbstractCharismaComponent abstractCharismaComponent, String string, int n, int n2, boolean bl) {
        abstractCharismaComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$400(AbstractCharismaComponent abstractCharismaComponent, String string, int n, int n2, boolean bl) {
        abstractCharismaComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ ChoiceModelApp access$500(AbstractCharismaComponent abstractCharismaComponent, int n) {
        return abstractCharismaComponent.getChoiceModel(n);
    }

    static /* synthetic */ CharismaProgButton access$600(AbstractCharismaComponent abstractCharismaComponent) {
        return abstractCharismaComponent.currProgButton;
    }

    static /* synthetic */ ButtonModelApp access$700(AbstractCharismaComponent abstractCharismaComponent, int n) {
        return abstractCharismaComponent.getButtonModel(n);
    }

    static /* synthetic */ int access$902(AbstractCharismaComponent abstractCharismaComponent, int n) {
        abstractCharismaComponent.lastCheckedJokerKeyMeaning = n;
        return abstractCharismaComponent.lastCheckedJokerKeyMeaning;
    }

    static /* synthetic */ int access$900(AbstractCharismaComponent abstractCharismaComponent) {
        return abstractCharismaComponent.lastCheckedJokerKeyMeaning;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        WIZARD_PROFILE_TO_DSI_CONSTANT = new int[]{9, 4, 5, 1, 2, 3, 7, 9, 6, 9};
        DSI_CONSTANT_TO_WIZARD_PROFILE = new int[]{-1, 3, 4, 5, 1, 2, 8, 6, -1, 7};
        DSI_PROFILE_AS_STRING = new String[]{"unknown0", "COMFORT", "AUTO_NORMAL", "DYNAMIC", "OFFROAD_ALLROAD", "EFFICIENCY", "SPORT_RACE", "INDIVIDUAL", "RANGE", "LIFT"};
    }
}

