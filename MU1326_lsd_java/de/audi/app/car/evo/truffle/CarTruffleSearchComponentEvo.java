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
    private static final String LOGCHANNEL_NAME = "App.Car.Truffle";
    private CarTruffleGUISearchHandler searchHandler;
    private CarTruffleSearch search;
    private static final int RETURN_TARGET_HISTORY = 0;
    private static final int RETURN_TARGET_CAR_ENTER_SCREEN = 1;

    public CarTruffleSearchComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    public void init() {
        super.init();
        this.search = new CarTruffleSearch(this.getApplication(), this.getLogChannel(), 3);
        this.search.startDSI();
        this.searchHandler = new CarTruffleGUISearchHandler(this.getApplication(), this.getLogChannel(), this.search, this);
        this.search.setActiveGuiSearchHandler(this.searchHandler);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(61, this);
        this.getApplication().getPowerEventDispatcher().addPowerEventListener(this);
    }

    public void deinit() {
        this.getApplication().getPowerEventDispatcher().removePowerEventListener(this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(61, this);
        this.getApplication().getMenuEntryRegistry().unregisterVisibilityChangeListener(this.search);
        this.search.stopDSI(this.getApplication().getBundleContext());
        this.searchHandler.release();
        super.deinit();
    }

    protected void initModels() {
        this.getSpellerModel(601202).setSpellerListener(this);
    }

    protected void deinitModels() {
        this.getSpellerModel(601202).resetListener();
    }

    protected void initVisibility() {
        this.getChoiceModel(602019).setValue(0);
    }

    protected void deinitVisibility() {
    }

    public void menuEntrySelected(long l) {
        int n = CarTruffleSearchMenuEntryStateMapping.getStateID((int)l);
        this.getLogChannel().log(1000000, "[CarTruffleSearchComponentEvo#menuEntrySelected] entryID='%1', determined stateID='%2'", l, (long)n);
        this.getChoiceModel(601056).setValue(n);
        this.getChoiceModel(601056).setStatus(1);
        this.selectReturnTarget(false);
    }

    public void actionProxyCallPerformed(int n, Map map) {
        this.getLogChannel().log(1000000, "[CarTruffleSearchComponentEvo#actionProxyCallPerformed]", (long)n);
        if (n == 61) {
            this.clearCarSearchResults();
        }
    }

    private void clearCarSearchResults() {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[CarTruffleSearchComponentEvo#clearCarSearchResults] clear SpellerModel and BaseListModel; reset truffle selection (HK_RETURN from CarScreens won't lead to 'CarSearchResults' screen): setValue of ChoiceModel  CAR_VIEWSTATE_CHOICE to -1");
        }
        this.getChoiceModel(601056).setValue(-1);
        this.getSpellerModel(600453).clear();
        this.getBaseListModel(601107).removeAll();
        this.selectReturnTarget(true);
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[0];
    }

    public String getDSIListenerClassName() {
        return null;
    }

    public String getDSIClassName() {
        return null;
    }

    public boolean isUsingDSI() {
        return false;
    }

    public String getCurrentViewOptions() {
        return "component has no view options";
    }

    public int getID() {
        return 11;
    }

    public String getName() {
        return "TruffleSearch";
    }

    private void selectReturnTarget(boolean bl) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[CarTruffleSearchComponentEvo#selectReturnTarget] target for HK_Return from 'CarSearchResults' is %1: setValue of ChoiceModel  TRUFFLE_SEARCH_BACK_JUMP_CHOICE(ID='%2') to %3", (Object)(bl ? "screen, from which search was started" : "car enter screen"), 601118L, bl ? 0L : 1L);
        }
        this.getChoiceModel(601118).setValue(bl ? 0 : 1);
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void textChanged(int n, String string, char c2, int n2) {
        if (n == 601202) {
            SpellerModelApp spellerModelApp = this.getSpellerModel(601202);
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[CarTruffleSearchComponentEvo#textChanged] trigger jump to CarSearchResults screen and clear SpellerModel: model='%1'", (long)spellerModelApp.getID());
            }
            this.clearCarSearchResults();
            this.getSpellerModel(600453).setText(string);
            this.searchHandler.textChanged(600453, string, c2, n2);
            spellerModelApp.fireEvent(n2);
            spellerModelApp.clear();
        }
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void commandPressed(int n, int n2, int n3) {
        if (n == 601202) {
            this.logModelData("commandPressed", n, n2, true);
            if (n2 == 4711) {
                SpellerModelApp spellerModelApp = this.getSpellerModel(601202);
                SpellerModelApp spellerModelApp2 = this.getSpellerModel(600453);
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1000000, "[CarTruffleSearchComponentEvo#commandPressed] trigger jump to CarSearchResults screen and open speller in SEARCH_RESULTS screen: carScreenSpellerModelID='%1' , carSearchScreenSpellerModelID='%2'", (long)spellerModelApp.getID(), (long)spellerModelApp2.getID());
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

    public void notifyPowerListenerOnEnterState(int n) {
    }

    public void notifyPowerListenerOnExitState(int n) {
    }

    public void notifyPowerTriggerAction(int n) {
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.getLogChannel().log(1000000, "[CarTruffleSearchComponent#updateClampState] clamp15=%1", bl2);
        this.getChoiceModel(602019).setValue(bl2 ? 0 : 3);
    }
}

