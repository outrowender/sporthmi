/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.joker;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.core.joker.AbstractJokerKeyComponent$CombiMFLHandler;
import de.audi.app.car.core.joker.AbstractJokerKeyComponent$ExternalKeyServiceTrackerListener;
import de.audi.app.car.core.joker.AbstractJokerKeyComponent$JokerKeyFunction;
import de.audi.app.car.core.joker.AbstractJokerKeyComponent$JokerKeyFunctionCluster;
import de.audi.atip.hmi.intercommunication.JokerKeyMeaning;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.JokerKeyService;
import de.audi.atip.msg.MsgListener;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public abstract class AbstractJokerKeyComponent
extends AbstractCarComponent
implements JokerKeyService,
MsgListener,
ButtonListener,
ChoiceListener {
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    private static final SimpleIntIntMap MEANING2MODELID;
    private static final int MENUSTYLE_CHECKBOX;
    private static final int MENUSTYLE_RADIOBUTTON;
    int menuStyle = 1;
    private CarServiceTracker combiBAPServiceMFLTracker;
    private CarServiceProvider combiBAPServiceMFLListenerProvider;
    private CarServiceProvider jokerKeyServiceProvider;
    private AbstractJokerKeyComponent$CombiMFLHandler combiMFLHandler;
    private final CarServiceTracker externalKeyServiceTracker;
    private final AbstractJokerKeyComponent$ExternalKeyServiceTrackerListener externalKeyServiceTrackerListener;
    protected int joker1MeaningModelID = 395;
    private Map jokerKeyFunctions = new HashMap(5);
    private int restoredJokerKeyMeaningAfterStartup = -1;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFL;
    static /* synthetic */ Class class$de$audi$atip$interapp$ExternalKeyListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFLListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$JokerKeyService;

    public AbstractJokerKeyComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.JokerKey");
        this.combiMFLHandler = new AbstractJokerKeyComponent$CombiMFLHandler(this, null);
        this.restoreJokerKeyFunction();
        this.registerJokerKeyFunctions();
        this.registerJokerKeyFunction(0, -1);
        this.externalKeyServiceTrackerListener = new AbstractJokerKeyComponent$ExternalKeyServiceTrackerListener(this, null);
        this.externalKeyServiceTracker = new CarServiceTracker(this.externalKeyServiceTrackerListener, iCarApplication.getBundleContext(), this.getLogChannel());
    }

    @Override
    public void init() {
        super.init();
        this.combiBAPServiceMFLTracker = new CarServiceTracker(this.combiMFLHandler, this.getApplication().getBundleContext(), this.getLogChannel());
        this.combiBAPServiceMFLListenerProvider = new CarServiceProvider((class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFLListener == null ? (class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFLListener = AbstractJokerKeyComponent.class$("de.audi.atip.interapp.combi.bap.mfl.CombiBAPServiceMFLListener")) : class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFLListener).getName(), this.combiMFLHandler, new Hashtable(0), this.getApplication().getBundleContext(), this.getLogChannel());
        this.jokerKeyServiceProvider = new CarServiceProvider((class$de$audi$atip$interapp$JokerKeyService == null ? (class$de$audi$atip$interapp$JokerKeyService = AbstractJokerKeyComponent.class$("de.audi.atip.interapp.JokerKeyService")) : class$de$audi$atip$interapp$JokerKeyService).getName(), this, new Hashtable(0), this.getApplication().getBundleContext(), this.getLogChannel());
        this.initJokerKeyFunctionAvailability();
        this.combiBAPServiceMFLTracker.startTracking();
        this.combiBAPServiceMFLListenerProvider.startService();
        this.jokerKeyServiceProvider.startService();
        this.getApplication().getMessageDispatcher().addMessageListener(79, this);
        this.externalKeyServiceTracker.startTracking();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.externalKeyServiceTracker.stopTracking();
        this.jokerKeyServiceProvider.stopService();
        this.combiBAPServiceMFLListenerProvider.stopService();
        this.combiBAPServiceMFLTracker.stopTracking();
        this.getApplication().getMessageDispatcher().removeMessageListener(79, this);
    }

    protected final void restoreJokerKeyFunction() {
        int n = this.getApplication().getFrameworkAccess().getStorageMgr().getInt(1006, 10, -1);
        this.getLogChannel().log(-2137614336, "[AbstractJokerKeyComponent#restoreJokerKeyFunction] restored meaning from persistence is: %1", (long)n);
        AbstractJokerKeyComponent$JokerKeyFunction abstractJokerKeyComponent$JokerKeyFunction = this.getJokerKeyFunction(n);
        if (abstractJokerKeyComponent$JokerKeyFunction != null && abstractJokerKeyComponent$JokerKeyFunction.isVisible()) {
            abstractJokerKeyComponent$JokerKeyFunction.updateJokerKeyConfiguration();
        } else {
            this.restoredJokerKeyMeaningAfterStartup = n;
            this.getChoiceModel(this.joker1MeaningModelID).setValue(0);
            this.getButtonModel(-1859450624).setButtonListener(this);
        }
    }

    protected void registerJokerKeyFunction(int n, int n2) {
        AbstractJokerKeyComponent$JokerKeyFunction abstractJokerKeyComponent$JokerKeyFunction = JokerKeyMeaning.isClusterFunction(n) ? new AbstractJokerKeyComponent$JokerKeyFunctionCluster(this, n, this.joker1MeaningModelID, MEANING2MODELID.get(n), n2) : new AbstractJokerKeyComponent$JokerKeyFunction(this, n, this.joker1MeaningModelID, MEANING2MODELID.get(n), n2);
        this.jokerKeyFunctions.put(new Integer(n), abstractJokerKeyComponent$JokerKeyFunction);
    }

    protected abstract void registerJokerKeyFunctions() {
    }

    protected void initJokerKeyFunctionAvailability() {
        Iterator iterator = this.jokerKeyFunctions.values().iterator();
        while (iterator.hasNext()) {
            ((AbstractJokerKeyComponent$JokerKeyFunction)iterator.next()).setVisible(false);
        }
    }

    @Override
    public String getName() {
        return "Joker Key";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[0];
    }

    @Override
    public String getCurrentViewOptions() {
        return "component has no view options";
    }

    @Override
    protected void initModels() {
        Iterator iterator = this.jokerKeyFunctions.values().iterator();
        while (iterator.hasNext()) {
            ((AbstractJokerKeyComponent$JokerKeyFunction)iterator.next()).initModel();
        }
        this.getButtonModel(-1842673408).setButtonListener(this);
        if (this.menuStyle == 1) {
            this.getChoiceModel(this.joker1MeaningModelID).setChoiceListener(this);
        }
    }

    @Override
    protected void deinitModels() {
        Iterator iterator = this.jokerKeyFunctions.values().iterator();
        while (iterator.hasNext()) {
            ((AbstractJokerKeyComponent$JokerKeyFunction)iterator.next()).deinitModel();
        }
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
    public void setFunctionAvailable(int n, boolean bl) {
        this.getLogChannel().log(-2137614336, "[AbstractJokerKeyComponent#setFunctionAvailable] meaning=%2, available=%1", bl, (long)n);
        AbstractJokerKeyComponent$JokerKeyFunction abstractJokerKeyComponent$JokerKeyFunction = (AbstractJokerKeyComponent$JokerKeyFunction)this.jokerKeyFunctions.get(new Integer(n));
        if (abstractJokerKeyComponent$JokerKeyFunction != null) {
            abstractJokerKeyComponent$JokerKeyFunction.setVisible(bl);
            this.checkSelection();
        } else {
            this.getLogChannel().log(1078071040, "[AbstractJokerKeyComponent#setFunctionAvailable] no function available for meaning=%1", (long)n);
        }
    }

    private AbstractJokerKeyComponent$JokerKeyFunction getJokerKeyFunction(int n) {
        return (AbstractJokerKeyComponent$JokerKeyFunction)this.jokerKeyFunctions.get(new Integer(n));
    }

    private int getCurrentJokerKeyMeaning() {
        return this.getChoiceModel(this.joker1MeaningModelID).getValue();
    }

    private void checkSelection() {
        this.checkRestoredJokerKeyFunction();
        this.checkCurrentJokerKeyFunction();
    }

    private void checkRestoredJokerKeyFunction() {
        AbstractJokerKeyComponent$JokerKeyFunction abstractJokerKeyComponent$JokerKeyFunction;
        if (this.restoredJokerKeyMeaningAfterStartup > -1 && (abstractJokerKeyComponent$JokerKeyFunction = this.getJokerKeyFunction(this.restoredJokerKeyMeaningAfterStartup)) != null && abstractJokerKeyComponent$JokerKeyFunction.isVisible()) {
            this.getLogChannel().log(-2137614336, "[AbstractJokerKeyComponent#checkRestoredJokerKeyFunction] restore persisted joker key function: %1", (long)this.restoredJokerKeyMeaningAfterStartup);
            abstractJokerKeyComponent$JokerKeyFunction.updateJokerKeyConfiguration();
        }
    }

    private void checkCurrentJokerKeyFunction() {
        AbstractJokerKeyComponent$JokerKeyFunction abstractJokerKeyComponent$JokerKeyFunction = this.getJokerKeyFunction(this.getCurrentJokerKeyMeaning());
        if (abstractJokerKeyComponent$JokerKeyFunction != null && !abstractJokerKeyComponent$JokerKeyFunction.isVisible()) {
            abstractJokerKeyComponent$JokerKeyFunction.deactivate();
            this.getChoiceModel(this.joker1MeaningModelID).setValue(0);
            this.getApplication().getFrameworkAccess().getMsgDistrib().sendMessage(79);
        }
    }

    @Override
    public void processMsg(int n) {
        int n2;
        if (79 == n && (0 == (n2 = this.getChoiceModel(395).getValue()) || 50 == n2)) {
            this.getButtonModel(-1859450624).setButtonListener(this);
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        if (n == -1859450624) {
            int n4 = this.getChoiceModel(395).getValue();
            if (0 == n4) {
                this.getLogChannel().log(-2137614336, "[AbstractJokerKeyComponent#keyReleased] No joker key function assigned");
                this.handleJokerKeyNotAssigned();
            }
            if (50 == n4) {
                this.getLogChannel().log(-2137614336, "[AbstractJokerKeyComponent#keyReleased] Invoke push to talk.");
                this.externalKeyServiceTrackerListener.sendKey(50);
            }
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.getLogChannel().log(-2137614336, "[AbstractJokerKeyComponent#keyPressed] Key pressed %1", (long)n);
        if (n == -1842673408) {
            this.handleJokerKeyLongpress();
        }
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == this.joker1MeaningModelID) {
            String string = "[AbstractJokerKeyComponent.JokerKeyFunction#itemSelected]";
            this.logModelData(string, n, n2, true);
            AbstractJokerKeyComponent$JokerKeyFunction abstractJokerKeyComponent$JokerKeyFunction = this.getJokerKeyFunction(n2);
            if (abstractJokerKeyComponent$JokerKeyFunction != null) {
                abstractJokerKeyComponent$JokerKeyFunction.updateJokerKeyConfiguration();
            } else {
                this.getLogChannel().log(10000, "[AbstractJokerKeyComponent#itemSelected] invalid item selected: %1", (long)n2);
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    protected abstract void handleJokerKeyNotAssigned() {
    }

    protected abstract void handleJokerKeyLongpress() {
    }

    protected int getTrafficAnnouncementAvailableConstant() {
        return 4358;
    }

    static /* synthetic */ void access$000(AbstractJokerKeyComponent abstractJokerKeyComponent) {
        abstractJokerKeyComponent.checkSelection();
    }

    static /* synthetic */ Map access$100(AbstractJokerKeyComponent abstractJokerKeyComponent) {
        return abstractJokerKeyComponent.jokerKeyFunctions;
    }

    static /* synthetic */ AbstractJokerKeyComponent$JokerKeyFunction access$200(AbstractJokerKeyComponent abstractJokerKeyComponent, int n) {
        return abstractJokerKeyComponent.getJokerKeyFunction(n);
    }

    static /* synthetic */ int access$300(AbstractJokerKeyComponent abstractJokerKeyComponent) {
        return abstractJokerKeyComponent.getCurrentJokerKeyMeaning();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ChoiceModelApp access$400(AbstractJokerKeyComponent abstractJokerKeyComponent, int n) {
        return abstractJokerKeyComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$500(AbstractJokerKeyComponent abstractJokerKeyComponent, int n) {
        return abstractJokerKeyComponent.getChoiceModel(n);
    }

    static /* synthetic */ void access$600(AbstractJokerKeyComponent abstractJokerKeyComponent, String string, int n, int n2, boolean bl) {
        abstractJokerKeyComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$700(AbstractJokerKeyComponent abstractJokerKeyComponent, String string, int n, int n2, boolean bl) {
        abstractJokerKeyComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ AbstractJokerKeyComponent$CombiMFLHandler access$800(AbstractJokerKeyComponent abstractJokerKeyComponent) {
        return abstractJokerKeyComponent.combiMFLHandler;
    }

    static /* synthetic */ ChoiceModelApp access$1000(AbstractJokerKeyComponent abstractJokerKeyComponent, int n) {
        return abstractJokerKeyComponent.getChoiceModel(n);
    }

    static /* synthetic */ int access$1102(AbstractJokerKeyComponent abstractJokerKeyComponent, int n) {
        abstractJokerKeyComponent.restoredJokerKeyMeaningAfterStartup = n;
        return abstractJokerKeyComponent.restoredJokerKeyMeaningAfterStartup;
    }

    static /* synthetic */ ChoiceModelApp access$1200(AbstractJokerKeyComponent abstractJokerKeyComponent, int n) {
        return abstractJokerKeyComponent.getChoiceModel(n);
    }

    static /* synthetic */ ICarApplication access$1300(AbstractJokerKeyComponent abstractJokerKeyComponent) {
        return abstractJokerKeyComponent.getApplication();
    }

    static /* synthetic */ ICarApplication access$1400(AbstractJokerKeyComponent abstractJokerKeyComponent) {
        return abstractJokerKeyComponent.getApplication();
    }

    static /* synthetic */ ChoiceModelApp access$1500(AbstractJokerKeyComponent abstractJokerKeyComponent, int n) {
        return abstractJokerKeyComponent.getChoiceModel(n);
    }

    static /* synthetic */ ICarApplication access$1600(AbstractJokerKeyComponent abstractJokerKeyComponent) {
        return abstractJokerKeyComponent.getApplication();
    }

    static {
        MEANING2MODELID = new SimpleIntIntMap();
        MEANING2MODELID.add(1, -1825896192);
        MEANING2MODELID.add(2, -1809118976);
        MEANING2MODELID.add(3, -1742010112);
        MEANING2MODELID.add(4, -1708455680);
        MEANING2MODELID.add(5, -1725232896);
        MEANING2MODELID.add(10, -198506240);
        MEANING2MODELID.add(7, -1658124032);
        MEANING2MODELID.add(40, -131135232);
        MEANING2MODELID.add(8, -1674901248);
        MEANING2MODELID.add(9, -1691678464);
        MEANING2MODELID.add(14, -449902336);
        MEANING2MODELID.add(11, -533985024);
        MEANING2MODELID.add(12, -366016256);
        MEANING2MODELID.add(30, -433125120);
        MEANING2MODELID.add(13, -114358016);
        MEANING2MODELID.add(50, -466679552);
        MEANING2MODELID.add(60, -416347904);
        MEANING2MODELID.add(70, -399570688);
        MEANING2MODELID.add(71, -315684608);
        MEANING2MODELID.add(80, -349239040);
        MEANING2MODELID.add(81, -332461824);
        MEANING2MODELID.add(82, -382793472);
        MEANING2MODELID.add(15, -1792341760);
        MEANING2MODELID.add(16, -1775564544);
        MEANING2MODELID.add(19, 1328285952);
    }
}

