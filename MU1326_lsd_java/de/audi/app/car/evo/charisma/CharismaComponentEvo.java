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
import de.audi.app.car.core.charisma.CharismaIndivEntryBusinessConfig$BusinessEventProcessingConfig;
import de.audi.app.car.core.charisma.CharismaIndividualChoiceModelHandler;
import de.audi.app.car.core.charisma.CharismaIndividualEntryTransactionData$CharismaIndivOptionMapping;
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
    private static final int ADD_INFO_NO_POSITION_CHOICE_MODEL_HINT;
    private CarServiceTracker jokerKeyServiceTracker;
    private JokerKeyService jokerKeyService;
    private final Object mutex = new Object();
    private final Map individualAvailableModels = new HashMap();
    private boolean isIndividualOperational = false;
    private volatile boolean onlyTrustScreenConnected = false;
    private static final CharismaIndivEntryBusinessConfig INDIV_BUSINESS_EVENT_CONFIG;
    static /* synthetic */ Class class$de$audi$atip$interapp$JokerKeyService;

    public CharismaComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
        this.SCREEN_CHANGE_MENU_FOCUS_LOST = 0;
        this.SCREEN_CHANGE_MENU_FOCUS_GAINED = 1;
        this.SCREEN_CHANGE_MENU_EXITED = 2;
        this.SCREEN_CHANGE_MENU_ENTERED = 3;
        this.jokerKeyServiceTracker = new CarServiceTracker(this, iCarApplication.getBundleContext(), this.getLogChannel());
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(-215086848).setValue(1);
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

    @Override
    public void updateCharismaViewOptions(CharismaViewOptions charismaViewOptions, int n) {
        super.updateCharismaViewOptions(charismaViewOptions, n);
        ChoiceModelApp choiceModelApp = this.getChoiceModel(-215086848);
        if (choiceModelApp != null && choiceModelApp.getValue() == 1) {
            this.getLogChannel().log(-2137614336, "[CharismaComponentEvo#updateCharismaViewOptions] first CharismaViewOptions trigger leaving INIT-Screen: model='%1', value='%2'", (long)choiceModelApp.getID(), 0L);
            choiceModelApp.setValue(0);
        }
    }

    @Override
    public void init() {
        super.init();
        this.jokerKeyServiceTracker.startTracking();
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(-332986112, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(60, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(64, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(65, this);
    }

    @Override
    public void deinit() {
        this.getApplication().getScreenStateDispatcher().removeScreenStateListener(-332986112, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(60, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(64, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(65, this);
        this.jokerKeyServiceTracker.stopTracking();
        super.deinit();
    }

    @Override
    protected void initVisibility() {
        this.initIndividualMap();
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1260914944, (short)17);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1277692160, (short)17);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1311246592, (short)17);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1328023808, (short)17);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1344801024, (short)17);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1294469376, (short)17);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1361578240, (short)17);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1965689088, (short)17);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1244137728, (short)17);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(238, (short)17);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1244137728, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1965689088, 1);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1260914944);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1277692160);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1311246592);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1328023808);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1344801024);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1294469376);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1361578240);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1965689088);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(238);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1244137728);
    }

    @Override
    protected void updateMenuEntryVisibility(CharismaViewOptions charismaViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(this.getCurrentLiftProfileMenuEntryID(), this.getMenuEntryVisibilityState(new CarViewOption[]{charismaViewOptions.getActiveProfile(), charismaViewOptions.getProfileLift()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1277692160, this.getMenuEntryVisibilityState(new CarViewOption[]{charismaViewOptions.getActiveProfile(), charismaViewOptions.getProfileOffroadAllroad()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1311246592, this.getMenuEntryVisibilityState(new CarViewOption[]{charismaViewOptions.getActiveProfile(), charismaViewOptions.getProfileComfort()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1328023808, this.getMenuEntryVisibilityState(new CarViewOption[]{charismaViewOptions.getActiveProfile(), charismaViewOptions.getProfileAutoNormal()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1344801024, this.getMenuEntryVisibilityState(new CarViewOption[]{charismaViewOptions.getActiveProfile(), charismaViewOptions.getProfileDynamic()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1294469376, this.getMenuEntryVisibilityState(new CarViewOption[]{charismaViewOptions.getActiveProfile(), charismaViewOptions.getProfileEfficiency()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1361578240, this.getMenuEntryVisibilityState(new CarViewOption[]{charismaViewOptions.getActiveProfile(), charismaViewOptions.getProfileIndividual()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(238, this.getMenuEntryVisibilityState(new CarViewOption[]{charismaViewOptions.getActiveProfile(), charismaViewOptions.getProfileRaceSport()}));
        this.updateJokerKeyListEntryVisibility(charismaViewOptions);
        this.setProfileIndividualOperationalState(charismaViewOptions);
    }

    private int getCurrentLiftProfileMenuEntryID() {
        if (this.getLiftProfileName() == 9) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1260914944, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1965689088, 1);
            return 1244137728;
        }
        if (this.getLiftProfileName() == 7) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1260914944, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1244137728, 1);
            return 1965689088;
        }
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1965689088, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1244137728, 1);
        return 1260914944;
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

    @Override
    public int getID() {
        return 18;
    }

    @Override
    public int getPopUpID() {
        return -987297536;
    }

    @Override
    public int getStandbyPopupID() {
        return 6;
    }

    @Override
    protected boolean isWholeCharismaPopupContentDisabled() {
        return this.getChoiceModel(-282457856).getValue() != 0;
    }

    @Override
    public void serviceAvailable(Object object) {
        this.jokerKeyService = (JokerKeyService)object;
        this.updateJokerKeyListEntryVisibility(this.currViewOptions);
    }

    @Override
    public void serviceRemoved() {
        this.jokerKeyService = null;
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return new String[]{(class$de$audi$atip$interapp$JokerKeyService == null ? (class$de$audi$atip$interapp$JokerKeyService = CharismaComponentEvo.class$("de.audi.atip.interapp.JokerKeyService")) : class$de$audi$atip$interapp$JokerKeyService).getName()};
    }

    private void initIndividualMap() {
        this.individualAvailableModels.put(new Integer(1), this.getChoiceModel(-30799616));
        this.individualAvailableModels.put(new Integer(3), this.getChoiceModel(2820352));
        this.individualAvailableModels.put(new Integer(9), this.getChoiceModel(-215348992));
        this.individualAvailableModels.put(new Integer(13), this.getChoiceModel(-148240128));
        this.individualAvailableModels.put(new Integer(5), this.getChoiceModel(69929216));
        this.individualAvailableModels.put(new Integer(6), this.getChoiceModel(204146944));
        this.individualAvailableModels.put(new Integer(11), this.getChoiceModel(170592512));
        this.individualAvailableModels.put(new Integer(10), this.getChoiceModel(103483648));
        this.individualAvailableModels.put(new Integer(4), this.getChoiceModel(774637824));
        this.individualAvailableModels.put(new Integer(22), this.getChoiceModel(741083392));
        this.individualAvailableModels.put(new Integer(7), this.getChoiceModel(-64354048));
        this.individualAvailableModels.put(new Integer(29), this.getChoiceModel(-47380224));
        this.individualAvailableModels.put(new Integer(52), this.getChoiceModel(-2110912256));
        this.individualAvailableModels.put(new Integer(34), this.getChoiceModel(0x9300900));
        this.resetIndividualAvailableModels();
    }

    private void resetIndividualAvailableModels() {
        this.getChoiceModel(-30799616).setValue(1);
        this.getChoiceModel(2820352).setValue(1);
        this.getChoiceModel(-215348992).setValue(1);
        this.getChoiceModel(-148240128).setValue(1);
        this.getChoiceModel(69929216).setValue(1);
        this.getChoiceModel(204146944).setValue(1);
        this.getChoiceModel(170592512).setValue(1);
        this.getChoiceModel(103483648).setValue(1);
        this.getChoiceModel(-64354048).setValue(1);
        this.getChoiceModel(774637824).setValue(1);
        this.getChoiceModel(741083392).setValue(1);
        this.getChoiceModel(-47380224).setValue(1);
        this.getChoiceModel(-2110912256).setValue(1);
        this.getChoiceModel(0x9300900).setValue(1);
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

    @Override
    protected void initIndividualBusiness(CharismaIndividualChoiceModelHandler charismaIndividualChoiceModelHandler, CharismaIndividualEventBusiness charismaIndividualEventBusiness) {
        this.initIndividualBusiness(charismaIndividualChoiceModelHandler, charismaIndividualEventBusiness, this.getIndividualAvailableModel(charismaIndividualEventBusiness.getDsiFunctionID()));
    }

    @Override
    protected void initIndividualBusiness(CharismaIndividualChoiceModelHandler charismaIndividualChoiceModelHandler, CharismaIndividualEventBusiness charismaIndividualEventBusiness, ChoiceModelApp choiceModelApp) {
        if (choiceModelApp != null) {
            this.addAvailableModelToIndividualBusiness(charismaIndividualEventBusiness, choiceModelApp);
            this.addIndivEntry(charismaIndividualEventBusiness);
            charismaIndividualChoiceModelHandler.setBusiness(charismaIndividualEventBusiness, INDIV_BUSINESS_EVENT_CONFIG);
        }
    }

    @Override
    protected boolean isProfileIndividualOperational() {
        return this.isIndividualOperational;
    }

    private void setProfileIndividualOperationalState(CharismaViewOptions charismaViewOptions) {
        this.isIndividualOperational = charismaViewOptions != null && this.getMenuEntryVisibilityState(new CarViewOption[]{charismaViewOptions.getActiveProfile(), charismaViewOptions.getProfileIndividual(), charismaViewOptions.getCharismaList()}) != 1;
    }

    @Override
    protected AbstractCharismaAddInfoHandler getCharismaAddInfoHandler(ChoiceModelApp choiceModelApp) {
        if (this.isUnitG22()) {
            return super.getCharismaAddInfoHandler(choiceModelApp);
        }
        return new ScaleCharismaAddInfoHandler(this.getLogChannel(), choiceModelApp, this.getCharismaAddInfoConfig());
    }

    @Override
    protected CharismaAddInfoConfig[] getCharismaAddInfoConfig() {
        IStorageAccess iStorageAccess = this.getApplication().getFrameworkAccess().getStorageMgr();
        CharismaAddInfoConfig charismaAddInfoConfig = new CharismaAddInfoConfig(this.getLogChannel(), iStorageAccess, 0, this.getChoiceModel(103549184));
        CharismaAddInfoConfig charismaAddInfoConfig2 = new CharismaAddInfoConfig(this.getLogChannel(), iStorageAccess, 2, this.getChoiceModel(170658048));
        CharismaAddInfoConfig charismaAddInfoConfig3 = new CharismaAddInfoConfig(this.getLogChannel(), iStorageAccess, 1, this.getChoiceModel(137103616));
        CharismaAddInfoConfig charismaAddInfoConfig4 = new CharismaAddInfoConfig(this.getLogChannel(), iStorageAccess, 3, this.getChoiceModel(204212480));
        CharismaAddInfoConfig charismaAddInfoConfig5 = new CharismaAddInfoConfig(this.getLogChannel(), iStorageAccess, 4, this.getChoiceModel(-1439692544));
        CharismaAddInfoConfig charismaAddInfoConfig6 = new CharismaAddInfoConfig(this.getLogChannel(), iStorageAccess, 5, this.getChoiceModel(-1422915328));
        if (this.isUnitG22()) {
            return new CharismaAddInfoConfig[]{charismaAddInfoConfig, charismaAddInfoConfig2, charismaAddInfoConfig3, charismaAddInfoConfig4, charismaAddInfoConfig5, charismaAddInfoConfig6};
        }
        return new CharismaAddInfoConfig[]{charismaAddInfoConfig4, charismaAddInfoConfig5, charismaAddInfoConfig6};
    }

    @Override
    protected void updateCharismaProfileSelection(int n) {
        boolean bl = this.updateActivityStateOfPerformanceMode(n);
        if (bl) {
            this.onlyTrustScreenConnected = true;
        }
        if (!bl) {
            super.updateCharismaProfileSelection(n);
        }
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        this.getLogChannel().log(-2137614336, "[CharismaComponentEvo#actionProxyCallPerformed] methodID='%1'", (long)n);
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
                this.getLogChannel().log(-1601830656, "[CharismaComponentEvo#actionProxyCallPerformed] methodID '%1' not supported", (long)n);
            }
        }
    }

    private void changeCharismaMenuScreenState(Map map) {
        if (this.onlyTrustScreenConnected) {
            this.getLogChannel().log(-2137614336, "[CharismaComponentEvo#changeCharismaMenuScreenState] Wait for screen connected/faded out notifications to determine drive select menu state.");
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
            this.getLogChannel().log(1078071040, "[CharismaComponentEvo#notifyCharismaMenuScreenEntered] entered CharismaMenu Screen: DSI.showCharismaPopup(%1, %2)", 1L, 1L);
            this.showCharismaPopup(1, 1);
        }
    }

    private void notifyCharismaMenuScreenExited() {
        this.setDriveSelectScreenVisible(false, false);
        this.getLogChannel().log(1078071040, "[CharismaComponentEvo#notifyCharismaMenuScreenExited] exited CharismaMenu Screen: DSI.cancelCharismaPopup(%1, %2)", 1L, 1L);
        this.cancelCharismaPopup(1, 1);
    }

    @Override
    public void notifyScreenConnected(int n) {
        if (n == -332986112) {
            MenuModelApp menuModelApp;
            this.getLogChannel().log(-2137614336, "[CharismaComponentEvo#notifyScreenConnected] screenID='%1'", (long)n);
            if (this.onlyTrustScreenConnected) {
                this.notifyCharismaMenuScreenEntered();
                this.onlyTrustScreenConnected = false;
            }
            if ((menuModelApp = (MenuModelApp)this.charismaProfileMenuHandler.getHandledModel()) != null) {
                menuModelApp.trigger(ModelTrigger.JOIN_CURSOR);
            }
        }
    }

    @Override
    public void notifyScreenFadedOut(int n) {
        if (n == -332986112) {
            this.getLogChannel().log(-2137614336, "[CharismaComponentEvo#notifyScreenFadedOut] screenID='%1'", (long)n);
            if (this.onlyTrustScreenConnected) {
                this.notifyCharismaMenuScreenExited();
                this.onlyTrustScreenConnected = false;
            }
        }
    }

    @Override
    public void notifyScreenHidden(int n) {
    }

    @Override
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

    static {
        INDIV_BUSINESS_EVENT_CONFIG = new CharismaIndivEntryBusinessConfig(CharismaIndividualEntryTransactionData$CharismaIndivOptionMapping.DDB_TO_DSI_PROFILE_MAPPER, CharismaIndivEntryBusinessConfig$BusinessEventProcessingConfig.EVENT_PROCESS_CONFIG_ITEM_SELECTED_ONLY, true);
    }
}

