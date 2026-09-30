/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.charisma;

import de.audi.app.car.common.ap.IActionProxyListener;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.screenstate.IScreenStateListener;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.car.core.charisma.AbstractCharismaAddInfoHandler;
import de.audi.app.car.core.charisma.AbstractCharismaComponent;
import de.audi.app.car.core.charisma.CharismaAddInfoConfig;
import de.audi.app.car.core.charisma.CharismaIndivEntryBusinessConfig;
import de.audi.app.car.core.charisma.CharismaIndividualChoiceModelHandler;
import de.audi.app.car.core.charisma.CharismaIndividualEntryTransactionData;
import de.audi.app.car.core.charisma.CharismaIndividualEventBusiness;
import de.audi.app.car.core.charisma.ScaleCharismaAddInfoHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.JokerKeyService;
import de.audi.atip.storage.IStorageAccess;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class CharismaComponentEvo
extends AbstractCharismaComponent
implements CarServiceTrackerListener,
IActionProxyListener,
IScreenStateListener {
    private final int SCREEN_CHANGE_MENU_FOCUS_LOST;
    private final int SCREEN_CHANGE_MENU_FOCUS_GAINED;
    private final int SCREEN_CHANGE_MENU_EXITED;
    private final int SCREEN_CHANGE_MENU_ENTERED;
    private static final int ADD_INFO_NO_POSITION_CHOICE_MODEL_HINT = 5;
    private CarServiceTracker jokerKeyServiceTracker;
    private JokerKeyService jokerKeyService;
    private final Object mutex = new Object();
    private final Map individualAvailableModels = new HashMap();
    private boolean isIndividualOperational = false;
    private volatile boolean onlyTrustScreenConnected = false;
    private static final CharismaIndivEntryBusinessConfig INDIV_BUSINESS_EVENT_CONFIG = new CharismaIndivEntryBusinessConfig(CharismaIndividualEntryTransactionData.CharismaIndivOptionMapping.DDB_TO_DSI_PROFILE_MAPPER, CharismaIndivEntryBusinessConfig.BusinessEventProcessingConfig.EVENT_PROCESS_CONFIG_ITEM_SELECTED_ONLY, true);
    static /* synthetic */ Class class$de$audi$atip$interapp$JokerKeyService;

    public CharismaComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
        this.SCREEN_CHANGE_MENU_FOCUS_LOST = 0;
        this.SCREEN_CHANGE_MENU_FOCUS_GAINED = 1;
        this.SCREEN_CHANGE_MENU_EXITED = 2;
        this.SCREEN_CHANGE_MENU_ENTERED = 3;
        this.jokerKeyServiceTracker = new CarServiceTracker(this, iCarApplication.getBundleContext(), this.getLogChannel());
    }

    protected void initModels() {
        this.getChoiceModel(601843).setValue(1);
        super.initModels();
        if (this.isPositionHidden()) {
            super.setAddInfoHints(5);
        }
    }

    private boolean isPositionHidden() {
        IFrameworkAccess iFrameworkAccess = this.getApplication().getFrameworkAccess();
        return this.isUnitG22() && (iFrameworkAccess.isCn() || iFrameworkAccess.isKorea());
    }

    private boolean isUnitG22() {
        IFrameworkAccess iFrameworkAccess = this.getApplication().getFrameworkAccess();
        return iFrameworkAccess.isEvoHigh() && iFrameworkAccess.getScreenRes() == 2;
    }

    public void updateCharismaViewOptions(CharismaViewOptions charismaViewOptions, int n) {
        super.updateCharismaViewOptions(charismaViewOptions, n);
        ChoiceModelApp choiceModelApp = this.getChoiceModel(601843);
        if (choiceModelApp != null && choiceModelApp.getValue() == 1) {
            this.getLogChannel().log(10000000, "[CharismaComponentEvo#updateCharismaViewOptions] first CharismaViewOptions trigger leaving INIT-Screen: model='%1', value='%2'", (long)choiceModelApp.getID(), 0L);
            choiceModelApp.setValue(0);
        }
    }

    public void init() {
        super.init();
        this.jokerKeyServiceTracker.startTracking();
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(600044, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(60, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(64, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(65, this);
    }

    public void deinit() {
        this.getApplication().getScreenStateDispatcher().removeScreenStateListener(600044, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(60, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(64, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(65, this);
        this.jokerKeyServiceTracker.stopTracking();
        super.deinit();
    }

    protected void initVisibility() {
        this.initIndividualMap();
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600139, (short)17);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600140, (short)17);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600142, (short)17);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600143, (short)17);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600144, (short)17);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600141, (short)17);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600145, (short)17);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600693, (short)17);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600138, (short)17);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(238, (short)17);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600138, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600693, 1);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600139);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600140);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600142);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600143);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600144);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600141);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600145);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600693);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(238);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600138);
    }

    protected void updateMenuEntryVisibility(CharismaViewOptions charismaViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(this.getCurrentLiftProfileMenuEntryID(), this.getMenuEntryVisibilityState(new CarViewOption[]{charismaViewOptions.getActiveProfile(), charismaViewOptions.getProfileLift()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600140, this.getMenuEntryVisibilityState(new CarViewOption[]{charismaViewOptions.getActiveProfile(), charismaViewOptions.getProfileOffroadAllroad()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600142, this.getMenuEntryVisibilityState(new CarViewOption[]{charismaViewOptions.getActiveProfile(), charismaViewOptions.getProfileComfort()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600143, this.getMenuEntryVisibilityState(new CarViewOption[]{charismaViewOptions.getActiveProfile(), charismaViewOptions.getProfileAutoNormal()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600144, this.getMenuEntryVisibilityState(new CarViewOption[]{charismaViewOptions.getActiveProfile(), charismaViewOptions.getProfileDynamic()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600141, this.getMenuEntryVisibilityState(new CarViewOption[]{charismaViewOptions.getActiveProfile(), charismaViewOptions.getProfileEfficiency()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600145, this.getMenuEntryVisibilityState(new CarViewOption[]{charismaViewOptions.getActiveProfile(), charismaViewOptions.getProfileIndividual()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(238, this.getMenuEntryVisibilityState(new CarViewOption[]{charismaViewOptions.getActiveProfile(), charismaViewOptions.getProfileRaceSport()}));
        this.updateJokerKeyListEntryVisibility(charismaViewOptions);
        this.setProfileIndividualOperationalState(charismaViewOptions);
    }

    private int getCurrentLiftProfileMenuEntryID() {
        if (this.getLiftProfileName() == 9) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600139, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600693, 1);
            return 600138;
        }
        if (this.getLiftProfileName() == 7) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600139, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600138, 1);
            return 600693;
        }
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600693, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600138, 1);
        return 600139;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateJokerKeyListEntryVisibility(CharismaViewOptions charismaViewOptions) {
        if (charismaViewOptions != null && charismaViewOptions.getActiveProfile() != null && charismaViewOptions.getProgButton() != null) {
            boolean bl = charismaViewOptions.getActiveProfile().getState() != 0 && charismaViewOptions.getProgButton().getState() != 0;
            Object object = this.mutex;
            synchronized (object) {
                if (this.jokerKeyService != null) {
                    this.jokerKeyService.setFunctionAvailable(2, bl);
                }
            }
        }
    }

    public int getID() {
        return 18;
    }

    public int getPopUpID() {
        return 600005;
    }

    public int getStandbyPopupID() {
        return 6;
    }

    protected boolean isWholeCharismaPopupContentDisabled() {
        return this.getChoiceModel(600815).getValue() != 0;
    }

    public void serviceAvailable(Object object) {
        this.jokerKeyService = (JokerKeyService)object;
        this.updateJokerKeyListEntryVisibility(this.currViewOptions);
    }

    public void serviceRemoved() {
        this.jokerKeyService = null;
    }

    public String[] getTrackedServiceClazzName() {
        return new String[]{(class$de$audi$atip$interapp$JokerKeyService == null ? (class$de$audi$atip$interapp$JokerKeyService = CharismaComponentEvo.class$("de.audi.atip.interapp.JokerKeyService")) : class$de$audi$atip$interapp$JokerKeyService).getName()};
    }

    private void initIndividualMap() {
        this.individualAvailableModels.put(new Integer(1), this.getChoiceModel(600830));
        this.individualAvailableModels.put(new Integer(3), this.getChoiceModel(600832));
        this.individualAvailableModels.put(new Integer(9), this.getChoiceModel(600819));
        this.individualAvailableModels.put(new Integer(13), this.getChoiceModel(600823));
        this.individualAvailableModels.put(new Integer(5), this.getChoiceModel(600836));
        this.individualAvailableModels.put(new Integer(6), this.getChoiceModel(600844));
        this.individualAvailableModels.put(new Integer(11), this.getChoiceModel(600842));
        this.individualAvailableModels.put(new Integer(10), this.getChoiceModel(600838));
        this.individualAvailableModels.put(new Integer(4), this.getChoiceModel(601134));
        this.individualAvailableModels.put(new Integer(22), this.getChoiceModel(601132));
        this.individualAvailableModels.put(new Integer(7), this.getChoiceModel(600828));
        this.individualAvailableModels.put(new Integer(29), this.getChoiceModel(601597));
        this.individualAvailableModels.put(new Integer(52), this.getChoiceModel(601730));
        this.individualAvailableModels.put(new Integer(34), this.getChoiceModel(602121));
        this.resetIndividualAvailableModels();
    }

    private void resetIndividualAvailableModels() {
        this.getChoiceModel(600830).setValue(1);
        this.getChoiceModel(600832).setValue(1);
        this.getChoiceModel(600819).setValue(1);
        this.getChoiceModel(600823).setValue(1);
        this.getChoiceModel(600836).setValue(1);
        this.getChoiceModel(600844).setValue(1);
        this.getChoiceModel(600842).setValue(1);
        this.getChoiceModel(600838).setValue(1);
        this.getChoiceModel(600828).setValue(1);
        this.getChoiceModel(601134).setValue(1);
        this.getChoiceModel(601132).setValue(1);
        this.getChoiceModel(601597).setValue(1);
        this.getChoiceModel(601730).setValue(1);
        this.getChoiceModel(602121).setValue(1);
    }

    protected void updateIndividualAvailability(int n) {
        ChoiceModelApp choiceModelApp = this.getIndividualAvailableModel(n);
        choiceModelApp.setValue(0);
    }

    private ChoiceModelApp getIndividualAvailableModel(int n) {
        try {
            return (ChoiceModelApp)this.individualAvailableModels.get(new Integer(n));
        }
        catch (ClassCastException classCastException) {
            this.getLogChannel().log(10000, "[CharismaComponentEvo#getIndividualAvailableModel('%1')] no AvailableModel for function ID", (long)n, (Throwable)classCastException);
            return null;
        }
    }

    private void addAvailableModelToIndividualBusiness(CharismaIndividualEventBusiness charismaIndividualEventBusiness, ChoiceModelApp choiceModelApp) {
        charismaIndividualEventBusiness.setAvailableModel(choiceModelApp);
    }

    protected void initIndividualBusiness(CharismaIndividualChoiceModelHandler charismaIndividualChoiceModelHandler, CharismaIndividualEventBusiness charismaIndividualEventBusiness) {
        this.initIndividualBusiness(charismaIndividualChoiceModelHandler, charismaIndividualEventBusiness, this.getIndividualAvailableModel(charismaIndividualEventBusiness.getDsiFunctionID()));
    }

    protected void initIndividualBusiness(CharismaIndividualChoiceModelHandler charismaIndividualChoiceModelHandler, CharismaIndividualEventBusiness charismaIndividualEventBusiness, ChoiceModelApp choiceModelApp) {
        if (choiceModelApp != null) {
            this.addAvailableModelToIndividualBusiness(charismaIndividualEventBusiness, choiceModelApp);
            this.addIndivEntry(charismaIndividualEventBusiness);
            charismaIndividualChoiceModelHandler.setBusiness(charismaIndividualEventBusiness, INDIV_BUSINESS_EVENT_CONFIG);
        }
    }

    protected boolean isProfileIndividualOperational() {
        return this.isIndividualOperational;
    }

    private void setProfileIndividualOperationalState(CharismaViewOptions charismaViewOptions) {
        this.isIndividualOperational = charismaViewOptions != null && this.getMenuEntryVisibilityState(new CarViewOption[]{charismaViewOptions.getActiveProfile(), charismaViewOptions.getProfileIndividual(), charismaViewOptions.getCharismaList()}) != 1;
    }

    protected AbstractCharismaAddInfoHandler getCharismaAddInfoHandler(ChoiceModelApp choiceModelApp) {
        if (this.isUnitG22()) {
            return super.getCharismaAddInfoHandler(choiceModelApp);
        }
        return new ScaleCharismaAddInfoHandler(this.getLogChannel(), choiceModelApp, this.getCharismaAddInfoConfig());
    }

    protected CharismaAddInfoConfig[] getCharismaAddInfoConfig() {
        IStorageAccess iStorageAccess = this.getApplication().getFrameworkAccess().getStorageMgr();
        CharismaAddInfoConfig charismaAddInfoConfig = new CharismaAddInfoConfig(this.getLogChannel(), iStorageAccess, 0, this.getChoiceModel(601094));
        CharismaAddInfoConfig charismaAddInfoConfig2 = new CharismaAddInfoConfig(this.getLogChannel(), iStorageAccess, 2, this.getChoiceModel(601098));
        CharismaAddInfoConfig charismaAddInfoConfig3 = new CharismaAddInfoConfig(this.getLogChannel(), iStorageAccess, 1, this.getChoiceModel(601096));
        CharismaAddInfoConfig charismaAddInfoConfig4 = new CharismaAddInfoConfig(this.getLogChannel(), iStorageAccess, 3, this.getChoiceModel(601100));
        CharismaAddInfoConfig charismaAddInfoConfig5 = new CharismaAddInfoConfig(this.getLogChannel(), iStorageAccess, 4, this.getChoiceModel(602282));
        CharismaAddInfoConfig charismaAddInfoConfig6 = new CharismaAddInfoConfig(this.getLogChannel(), iStorageAccess, 5, this.getChoiceModel(602283));
        if (this.isUnitG22()) {
            return new CharismaAddInfoConfig[]{charismaAddInfoConfig, charismaAddInfoConfig2, charismaAddInfoConfig3, charismaAddInfoConfig4, charismaAddInfoConfig5, charismaAddInfoConfig6};
        }
        return new CharismaAddInfoConfig[]{charismaAddInfoConfig4, charismaAddInfoConfig5, charismaAddInfoConfig6};
    }

    protected void updateCharismaProfileSelection(int n) {
        boolean bl = this.updateActivityStateOfPerformanceMode(n);
        if (bl) {
            this.onlyTrustScreenConnected = true;
        }
        if (!bl) {
            super.updateCharismaProfileSelection(n);
        }
    }

    public void actionProxyCallPerformed(int n, Map map) {
        this.getLogChannel().log(10000000, "[CharismaComponentEvo#actionProxyCallPerformed] methodID='%1'", (long)n);
        switch (n) {
            case 60: {
                this.setDriveSelectScreenVisible(true, true);
                break;
            }
            case 64: {
                this.setDriveSelectScreenVisible(false, false);
                break;
            }
            case 65: {
                this.changeCharismaMenuScreenState(map);
                break;
            }
            default: {
                this.getLogChannel().log(100000, "[CharismaComponentEvo#actionProxyCallPerformed] methodID '%1' not supported", (long)n);
            }
        }
    }

    private void changeCharismaMenuScreenState(Map map) {
        if (this.onlyTrustScreenConnected) {
            this.getLogChannel().log(10000000, "[CharismaComponentEvo#changeCharismaMenuScreenState] Wait for screen connected/faded out notifications to determine drive select menu state.");
            return;
        }
        Integer n = (Integer)map.get("STATE");
        if (n != null) {
            if (n == 3 || n == 1) {
                this.notifyCharismaMenuScreenEntered();
                return;
            }
            if (n == 2 || n == 0) {
                this.notifyCharismaMenuScreenExited();
                return;
            }
        }
        this.getLogChannel().log(10000, "[CharismaComponentEvo#changeCharismaMenuScreenState] ActionProxy delivered invalid STATE parameter!");
    }

    private void notifyCharismaMenuScreenEntered() {
        if (!this.isDriveSelectScreenVisible()) {
            this.setDriveSelectScreenVisible(true, false);
            this.getLogChannel().log(1000000, "[CharismaComponentEvo#notifyCharismaMenuScreenEntered] entered CharismaMenu Screen: DSI.showCharismaPopup(%1, %2)", 1L, 1L);
            this.showCharismaPopup(1, 1);
        }
    }

    private void notifyCharismaMenuScreenExited() {
        this.setDriveSelectScreenVisible(false, false);
        this.getLogChannel().log(1000000, "[CharismaComponentEvo#notifyCharismaMenuScreenExited] exited CharismaMenu Screen: DSI.cancelCharismaPopup(%1, %2)", 1L, 1L);
        this.cancelCharismaPopup(1, 1);
    }

    public void notifyScreenConnected(int n) {
        if (n == 600044) {
            MenuModelApp menuModelApp;
            this.getLogChannel().log(10000000, "[CharismaComponentEvo#notifyScreenConnected] screenID='%1'", (long)n);
            if (this.onlyTrustScreenConnected) {
                this.notifyCharismaMenuScreenEntered();
                this.onlyTrustScreenConnected = false;
            }
            if ((menuModelApp = (MenuModelApp)this.charismaProfileMenuHandler.getHandledModel()) != null) {
                menuModelApp.trigger(ModelTrigger.JOIN_CURSOR);
            }
        }
    }

    public void notifyScreenFadedOut(int n) {
        if (n == 600044) {
            this.getLogChannel().log(10000000, "[CharismaComponentEvo#notifyScreenFadedOut] screenID='%1'", (long)n);
            if (this.onlyTrustScreenConnected) {
                this.notifyCharismaMenuScreenExited();
                this.onlyTrustScreenConnected = false;
            }
        }
    }

    public void notifyScreenHidden(int n) {
    }

    public void notifyScreenVisible(int n) {
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

