/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.truffle;

import de.audi.app.car.common.ap.IActionProxyListener;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.power.IPowerEventListener;
import de.audi.app.car.evo.truffle.CarTruffleGUISearchHandler;
import de.audi.app.car.evo.truffle.CarTruffleSearch;
import de.audi.app.car.evo.truffle.CarTruffleSearchMenuEntryStateMapping;
import de.audi.app.car.evo.truffle.ICarTruffleSearchComponent;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import java.util.Map;

public class CarTruffleSearchComponentEvo
extends AbstractCarComponent
implements ICarTruffleSearchComponent,
IActionProxyListener,
SpellerListener,
IPowerEventListener {
    private static final String LOGCHANNEL_NAME;
    private CarTruffleGUISearchHandler searchHandler;
    private CarTruffleSearch search;
    private static final int RETURN_TARGET_HISTORY;
    private static final int RETURN_TARGET_CAR_ENTER_SCREEN;

    public CarTruffleSearchComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Truffle");
    }

    @Override
    public void init() {
        super.init();
        this.search = new CarTruffleSearch(this.getApplication(), this.getLogChannel(), 3);
        this.search.startDSI();
        this.searchHandler = new CarTruffleGUISearchHandler(this.getApplication(), this.getLogChannel(), this.search, this);
        this.search.setActiveGuiSearchHandler(this.searchHandler);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(61, this);
        this.getApplication().getPowerEventDispatcher().addPowerEventListener(this);
    }

    @Override
    public void deinit() {
        this.getApplication().getPowerEventDispatcher().removePowerEventListener(this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(61, this);
        this.getApplication().getMenuEntryRegistry().unregisterVisibilityChangeListener(this.search);
        this.search.stopDSI(this.getApplication().getBundleContext());
        this.searchHandler.release();
        super.deinit();
    }

    @Override
    protected void initModels() {
        this.getSpellerModel(1915488512).setSpellerListener(this);
    }

    @Override
    protected void deinitModels() {
        this.getSpellerModel(1915488512).resetListener();
    }

    @Override
    protected void initVisibility() {
        this.getChoiceModel(-1557198592).setValue(0);
    }

    @Override
    protected void deinitVisibility() {
    }

    @Override
    public void menuEntrySelected(long l) {
        int n = CarTruffleSearchMenuEntryStateMapping.getStateID((int)l);
        this.getLogChannel().log(1078071040, "[CarTruffleSearchComponentEvo#menuEntrySelected] entryID='%1', determined stateID='%2'", l, (long)n);
        this.getChoiceModel(-534050560).setValue(n);
        this.getChoiceModel(-534050560).setStatus(1);
        this.selectReturnTarget(false);
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        this.getLogChannel().log(1078071040, "[CarTruffleSearchComponentEvo#actionProxyCallPerformed]", (long)n);
        if (n == 61) {
            this.clearCarSearchResults();
        }
    }

    private void clearCarSearchResults() {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[CarTruffleSearchComponentEvo#clearCarSearchResults] clear SpellerModel and BaseListModel; reset truffle selection (HK_RETURN from CarScreens won't lead to 'CarSearchResults' screen): setValue of ChoiceModel  CAR_VIEWSTATE_CHOICE to -1");
        }
        this.getChoiceModel(-534050560).setValue(-1);
        this.getSpellerModel(-2060908288).clear();
        this.getBaseListModel(321652992).removeAll();
        this.selectReturnTarget(true);
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[0];
    }

    @Override
    public String getDSIListenerClassName() {
        return null;
    }

    @Override
    public String getDSIClassName() {
        return null;
    }

    @Override
    public boolean isUsingDSI() {
        return false;
    }

    @Override
    public String getCurrentViewOptions() {
        return "component has no view options";
    }

    @Override
    public int getID() {
        return 11;
    }

    @Override
    public String getName() {
        return "TruffleSearch";
    }

    private void selectReturnTarget(boolean bl) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[CarTruffleSearchComponentEvo#selectReturnTarget] target for HK_Return from 'CarSearchResults' is %1: setValue of ChoiceModel  TRUFFLE_SEARCH_BACK_JUMP_CHOICE(ID='%2') to %3", (Object)(bl ? "screen, from which search was started" : "car enter screen"), (long)0, bl ? 0L : 1L);
        }
        this.getChoiceModel(506202368).setValue(bl ? 0 : 1);
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
    public void textChanged(int n, String string, char c2, int n2) {
        if (n == 1915488512) {
            SpellerModelApp spellerModelApp = this.getSpellerModel(1915488512);
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[CarTruffleSearchComponentEvo#textChanged] trigger jump to CarSearchResults screen and clear SpellerModel: model='%1'", (long)spellerModelApp.getID());
            }
            this.clearCarSearchResults();
            this.getSpellerModel(-2060908288).setText(string);
            this.searchHandler.textChanged(-2060908288, string, c2, n2);
            spellerModelApp.fireEvent(n2);
            spellerModelApp.clear();
        }
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
        if (n == 1915488512) {
            this.logModelData("commandPressed", n, n2, true);
            if (n2 == 4711) {
                SpellerModelApp spellerModelApp = this.getSpellerModel(1915488512);
                SpellerModelApp spellerModelApp2 = this.getSpellerModel(-2060908288);
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1078071040, "[CarTruffleSearchComponentEvo#commandPressed] trigger jump to CarSearchResults screen and open speller in SEARCH_RESULTS screen: carScreenSpellerModelID='%1' , carSearchScreenSpellerModelID='%2'", (long)spellerModelApp.getID(), (long)spellerModelApp2.getID());
                }
                spellerModelApp2.setTouchEventForFollowUpScreen(spellerModelApp.getTouchEventForFollowUpScreen());
                spellerModelApp.setTouchEventForFollowUpScreen(null);
                this.clearCarSearchResults();
                spellerModelApp2.setSpellerInitiallyOpen(true);
                spellerModelApp.fireEvent(n3);
            }
        } else {
            this.logModelData("commandPressed", n, n2, false);
        }
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n) {
    }

    @Override
    public void notifyPowerListenerOnExitState(int n) {
    }

    @Override
    public void notifyPowerTriggerAction(int n) {
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.getLogChannel().log(1078071040, "[CarTruffleSearchComponent#updateClampState] clamp15=%1", bl2);
        this.getChoiceModel(-1557198592).setValue(bl2 ? 0 : 3);
    }
}

