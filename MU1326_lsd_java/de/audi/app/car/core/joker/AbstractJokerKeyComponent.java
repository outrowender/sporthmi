/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.joker;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.atip.hmi.intercommunication.JokerKeyMeaning;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.interapp.ExternalKeyListener;
import de.audi.atip.interapp.JokerKeyService;
import de.audi.atip.interapp.combi.bap.mfl.CombiBAPServiceMFL;
import de.audi.atip.interapp.combi.bap.mfl.CombiBAPServiceMFLListener;
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
    public static final short CODING_ID = 29;
    private static final String LOGCHANNEL_NAME = "App.Car.JokerKey";
    private static final SimpleIntIntMap MEANING2MODELID = new SimpleIntIntMap();
    private static final int MENUSTYLE_CHECKBOX = 0;
    private static final int MENUSTYLE_RADIOBUTTON = 1;
    int menuStyle = 1;
    private CarServiceTracker combiBAPServiceMFLTracker;
    private CarServiceProvider combiBAPServiceMFLListenerProvider;
    private CarServiceProvider jokerKeyServiceProvider;
    private CombiMFLHandler combiMFLHandler;
    private final CarServiceTracker externalKeyServiceTracker;
    private final ExternalKeyServiceTrackerListener externalKeyServiceTrackerListener;
    protected int joker1MeaningModelID = 395;
    private Map jokerKeyFunctions = new HashMap(5);
    private int restoredJokerKeyMeaningAfterStartup = -1;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFL;
    static /* synthetic */ Class class$de$audi$atip$interapp$ExternalKeyListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFLListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$JokerKeyService;

    public AbstractJokerKeyComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.combiMFLHandler = new CombiMFLHandler();
        this.restoreJokerKeyFunction();
        this.registerJokerKeyFunctions();
        this.registerJokerKeyFunction(0, -1);
        this.externalKeyServiceTrackerListener = new ExternalKeyServiceTrackerListener();
        this.externalKeyServiceTracker = new CarServiceTracker(this.externalKeyServiceTrackerListener, iCarApplication.getBundleContext(), this.getLogChannel());
    }

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
        this.getLogChannel().log(10000000, "[AbstractJokerKeyComponent#restoreJokerKeyFunction] restored meaning from persistence is: %1", (long)n);
        JokerKeyFunction jokerKeyFunction = this.getJokerKeyFunction(n);
        if (jokerKeyFunction != null && jokerKeyFunction.isVisible()) {
            jokerKeyFunction.updateJokerKeyConfiguration();
        } else {
            this.restoredJokerKeyMeaningAfterStartup = n;
            this.getChoiceModel(this.joker1MeaningModelID).setValue(0);
            this.getButtonModel(600977).setButtonListener(this);
        }
    }

    protected void registerJokerKeyFunction(int n, int n2) {
        JokerKeyFunction jokerKeyFunction = JokerKeyMeaning.isClusterFunction(n) ? new JokerKeyFunctionCluster(n, this.joker1MeaningModelID, MEANING2MODELID.get(n), n2) : new JokerKeyFunction(n, this.joker1MeaningModelID, MEANING2MODELID.get(n), n2);
        this.jokerKeyFunctions.put(new Integer(n), jokerKeyFunction);
    }

    protected abstract void registerJokerKeyFunctions();

    protected void initJokerKeyFunctionAvailability() {
        Iterator iterator = this.jokerKeyFunctions.values().iterator();
        while (iterator.hasNext()) {
            ((JokerKeyFunction)iterator.next()).setVisible(false);
        }
    }

    public String getName() {
        return "Joker Key";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[0];
    }

    public String getCurrentViewOptions() {
        return "component has no view options";
    }

    protected void initModels() {
        Iterator iterator = this.jokerKeyFunctions.values().iterator();
        while (iterator.hasNext()) {
            ((JokerKeyFunction)iterator.next()).initModel();
        }
        this.getButtonModel(600978).setButtonListener(this);
        if (this.menuStyle == 1) {
            this.getChoiceModel(this.joker1MeaningModelID).setChoiceListener(this);
        }
    }

    protected void deinitModels() {
        Iterator iterator = this.jokerKeyFunctions.values().iterator();
        while (iterator.hasNext()) {
            ((JokerKeyFunction)iterator.next()).deinitModel();
        }
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

    public void setFunctionAvailable(int n, boolean bl) {
        this.getLogChannel().log(10000000, "[AbstractJokerKeyComponent#setFunctionAvailable] meaning=%2, available=%1", bl, (long)n);
        JokerKeyFunction jokerKeyFunction = (JokerKeyFunction)this.jokerKeyFunctions.get(new Integer(n));
        if (jokerKeyFunction != null) {
            jokerKeyFunction.setVisible(bl);
            this.checkSelection();
        } else {
            this.getLogChannel().log(1000000, "[AbstractJokerKeyComponent#setFunctionAvailable] no function available for meaning=%1", (long)n);
        }
    }

    private JokerKeyFunction getJokerKeyFunction(int n) {
        return (JokerKeyFunction)this.jokerKeyFunctions.get(new Integer(n));
    }

    private int getCurrentJokerKeyMeaning() {
        return this.getChoiceModel(this.joker1MeaningModelID).getValue();
    }

    private void checkSelection() {
        this.checkRestoredJokerKeyFunction();
        this.checkCurrentJokerKeyFunction();
    }

    private void checkRestoredJokerKeyFunction() {
        JokerKeyFunction jokerKeyFunction;
        if (this.restoredJokerKeyMeaningAfterStartup > -1 && (jokerKeyFunction = this.getJokerKeyFunction(this.restoredJokerKeyMeaningAfterStartup)) != null && jokerKeyFunction.isVisible()) {
            this.getLogChannel().log(10000000, "[AbstractJokerKeyComponent#checkRestoredJokerKeyFunction] restore persisted joker key function: %1", (long)this.restoredJokerKeyMeaningAfterStartup);
            jokerKeyFunction.updateJokerKeyConfiguration();
        }
    }

    private void checkCurrentJokerKeyFunction() {
        JokerKeyFunction jokerKeyFunction = this.getJokerKeyFunction(this.getCurrentJokerKeyMeaning());
        if (jokerKeyFunction != null && !jokerKeyFunction.isVisible()) {
            jokerKeyFunction.deactivate();
            this.getChoiceModel(this.joker1MeaningModelID).setValue(0);
            this.getApplication().getFrameworkAccess().getMsgDistrib().sendMessage(79);
        }
    }

    public void processMsg(int n) {
        int n2;
        if (79 == n && (0 == (n2 = this.getChoiceModel(395).getValue()) || 50 == n2)) {
            this.getButtonModel(600977).setButtonListener(this);
        }
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
        if (n == 600977) {
            int n4 = this.getChoiceModel(395).getValue();
            if (0 == n4) {
                this.getLogChannel().log(10000000, "[AbstractJokerKeyComponent#keyReleased] No joker key function assigned");
                this.handleJokerKeyNotAssigned();
            }
            if (50 == n4) {
                this.getLogChannel().log(10000000, "[AbstractJokerKeyComponent#keyReleased] Invoke push to talk.");
                this.externalKeyServiceTrackerListener.sendKey(50);
            }
        }
    }

    public void keyPressed(int n, int n2, int n3) {
        this.getLogChannel().log(10000000, "[AbstractJokerKeyComponent#keyPressed] Key pressed %1", (long)n);
        if (n == 600978) {
            this.handleJokerKeyLongpress();
        }
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == this.joker1MeaningModelID) {
            String string = "[AbstractJokerKeyComponent.JokerKeyFunction#itemSelected]";
            this.logModelData(string, n, n2, true);
            JokerKeyFunction jokerKeyFunction = this.getJokerKeyFunction(n2);
            if (jokerKeyFunction != null) {
                jokerKeyFunction.updateJokerKeyConfiguration();
            } else {
                this.getLogChannel().log(10000, "[AbstractJokerKeyComponent#itemSelected] invalid item selected: %1", (long)n2);
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    protected abstract void handleJokerKeyNotAssigned();

    protected abstract void handleJokerKeyLongpress();

    protected int getTrafficAnnouncementAvailableConstant() {
        return 4358;
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
        MEANING2MODELID.add(1, 600979);
        MEANING2MODELID.add(2, 600980);
        MEANING2MODELID.add(3, 600984);
        MEANING2MODELID.add(4, 600986);
        MEANING2MODELID.add(5, 600985);
        MEANING2MODELID.add(10, 601076);
        MEANING2MODELID.add(7, 600989);
        MEANING2MODELID.add(40, 602104);
        MEANING2MODELID.add(8, 600988);
        MEANING2MODELID.add(9, 600987);
        MEANING2MODELID.add(14, 602085);
        MEANING2MODELID.add(11, 601312);
        MEANING2MODELID.add(12, 602090);
        MEANING2MODELID.add(30, 602086);
        MEANING2MODELID.add(13, 602105);
        MEANING2MODELID.add(50, 602084);
        MEANING2MODELID.add(60, 602087);
        MEANING2MODELID.add(70, 602088);
        MEANING2MODELID.add(71, 602093);
        MEANING2MODELID.add(80, 602091);
        MEANING2MODELID.add(81, 602092);
        MEANING2MODELID.add(82, 602089);
        MEANING2MODELID.add(15, 600981);
        MEANING2MODELID.add(16, 600982);
        MEANING2MODELID.add(19, 601167);
    }

    private class CombiMFLHandler
    implements CombiBAPServiceMFLListener,
    CarServiceTrackerListener {
        private CombiBAPServiceMFL combiBAPServiceMFL;
        private int availableJokerKeyClusterFunctions = 0;

        private CombiMFLHandler() {
        }

        public void setAvailableJokerKeyClusterFunctions(int n) {
            if (this.combiBAPServiceMFL != null) {
                this.combiBAPServiceMFL.updateAvailableJokerKeyClusterFunctions(n);
            }
            if (this.availableJokerKeyClusterFunctions != n) {
                this.availableJokerKeyClusterFunctions = n;
                this.updateClusterFunctionsVisibilities();
                AbstractJokerKeyComponent.this.checkSelection();
            } else {
                AbstractJokerKeyComponent.this.getLogChannel().log(10000000, "[AbtractJokerKeyComponent.CombiMFLHandler#setAvailableJokerKeyClusterFunctions] available functions not changed (%1)", (long)n);
            }
        }

        private void updateClusterFunctionsVisibilities() {
            Iterator iterator = AbstractJokerKeyComponent.this.jokerKeyFunctions.keySet().iterator();
            while (iterator.hasNext()) {
                int n = (Integer)iterator.next();
                if (!JokerKeyMeaning.isClusterFunction(n)) continue;
                AbstractJokerKeyComponent.this.setFunctionAvailable(n, this.isClusterFunctionAvailable(n));
            }
        }

        public void confirmCurrentJokerKeyFunctions(int n, int n2, int n3, int n4, int n5) {
            int n6;
            switch (n) {
                case 1: {
                    n6 = 15;
                    break;
                }
                case 2: {
                    n6 = 16;
                    break;
                }
                case 3: {
                    n6 = 17;
                    break;
                }
                case 4: {
                    n6 = 18;
                    break;
                }
                case 5: {
                    n6 = 19;
                    break;
                }
                case 6: {
                    n6 = 20;
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    AbstractJokerKeyComponent.this.getLogChannel().log(10000000, "[AbstractJokerKeyComponent.CombiMFLHandler#confirmCurrentJokerKeyFunctions] unknown joker key function selected: %1", (long)n);
                    return;
                }
            }
            AbstractJokerKeyComponent.this.getLogChannel().log(10000000, "[AbstractJokerKeyComponent.CombiMFLHandler#confirmCurrentJokerKeyFunctions] confirmation for jokerKeyFunction=%1 received", (long)n6);
            if (this.isClusterFunctionAvailable(n6)) {
                AbstractJokerKeyComponent.this.getJokerKeyFunction(n6).activate();
            } else {
                AbstractJokerKeyComponent.this.getLogChannel().log(10000, "[AbstractJokerKeyComponent.CombiMFLHandler#confirmCurrentJokerKeyFunctions] jokerKeyFunction=%1 not available", (long)n6);
            }
        }

        private boolean isClusterFunctionAvailable(int n) {
            int n2;
            switch (n) {
                case 15: {
                    n2 = 1;
                    break;
                }
                case 16: {
                    n2 = 2;
                    break;
                }
                case 17: {
                    n2 = 4;
                    break;
                }
                case 18: {
                    n2 = 8;
                    break;
                }
                case 19: {
                    n2 = 16;
                    break;
                }
                case 20: {
                    n2 = 32;
                    break;
                }
                default: {
                    return false;
                }
            }
            return (n2 & this.availableJokerKeyClusterFunctions) == n2;
        }

        private void updateClusterKeyConfiguration(int n) {
            if (this.combiBAPServiceMFL != null) {
                this.combiBAPServiceMFL.updateCurrentJokerKeyFunction(1, this.convertJokerKeyMeaning(n));
            }
        }

        private int convertJokerKeyMeaning(int n) {
            int n2;
            switch (n) {
                case 15: {
                    n2 = 1;
                    break;
                }
                case 16: {
                    n2 = 2;
                    break;
                }
                case 17: {
                    n2 = 3;
                    break;
                }
                case 18: {
                    n2 = 4;
                    break;
                }
                case 19: {
                    n2 = 5;
                    break;
                }
                case 20: {
                    n2 = 6;
                    break;
                }
                default: {
                    n2 = 0;
                }
            }
            return n2;
        }

        public void serviceAvailable(Object object) {
            this.combiBAPServiceMFL = (CombiBAPServiceMFL)object;
            if (this.combiBAPServiceMFL != null) {
                this.updateClusterKeyConfiguration(AbstractJokerKeyComponent.this.getCurrentJokerKeyMeaning());
                this.combiBAPServiceMFL.updateInstalledKeys(1);
            }
        }

        public void serviceRemoved() {
            this.combiBAPServiceMFL = null;
        }

        public String[] getTrackedServiceClazzName() {
            return new String[]{(class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFL == null ? (class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFL = AbstractJokerKeyComponent.class$("de.audi.atip.interapp.combi.bap.mfl.CombiBAPServiceMFL")) : class$de$audi$atip$interapp$combi$bap$mfl$CombiBAPServiceMFL).getName()};
        }
    }

    private class JokerKeyFunction
    implements ChoiceListener {
        int meaningModelID;
        int meaning;
        int selectionModelID;
        int menuEntryID;
        boolean visible = false;

        public JokerKeyFunction(int n, int n2, int n3, int n4) {
            this.meaning = n;
            this.meaningModelID = n2;
            this.selectionModelID = n3;
            this.menuEntryID = n4;
        }

        public void initModel() {
            if (AbstractJokerKeyComponent.this.menuStyle == 0 && this.selectionModelID != -1) {
                AbstractJokerKeyComponent.this.getChoiceModel(this.selectionModelID).setChoiceListener(this);
            }
        }

        public void deinitModel() {
            if (AbstractJokerKeyComponent.this.menuStyle == 0 && this.selectionModelID != -1) {
                AbstractJokerKeyComponent.this.getChoiceModel(this.selectionModelID).resetListener();
            }
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
            if (n2 == 1) {
                String string = "[AbstractJokerKeyComponent.JokerKeyFunction#itemSelected]";
                if (n == this.selectionModelID) {
                    AbstractJokerKeyComponent.this.logModelData(string, n, n2, true);
                    if (this.meaning != AbstractJokerKeyComponent.this.getCurrentJokerKeyMeaning()) {
                        this.updateJokerKeyConfiguration();
                    }
                } else {
                    AbstractJokerKeyComponent.this.logModelData(string, n, n2, false);
                }
            }
        }

        public void itemFocused(int n, int n2, int n3, int n4) {
        }

        protected void updateJokerKeyConfiguration() {
            AbstractJokerKeyComponent.this.getLogChannel().log(10000000, "[AbstractJokerKeyComponent.JokerKeyFunction#updateJokerKeyConfiguration] newJokerKeyFunction=%1", (long)this.meaning);
            this.activate();
            AbstractJokerKeyComponent.this.combiMFLHandler.updateClusterKeyConfiguration(this.meaning);
        }

        public void activate() {
            if (AbstractJokerKeyComponent.this.menuStyle == 0) {
                JokerKeyFunction jokerKeyFunction = AbstractJokerKeyComponent.this.getJokerKeyFunction(AbstractJokerKeyComponent.this.getCurrentJokerKeyMeaning());
                if (jokerKeyFunction != null) {
                    jokerKeyFunction.deactivate();
                }
                if (this.selectionModelID != -1) {
                    AbstractJokerKeyComponent.this.getChoiceModel(this.selectionModelID).setValue(1);
                }
            }
            AbstractJokerKeyComponent.this.restoredJokerKeyMeaningAfterStartup = -1;
            AbstractJokerKeyComponent.this.getChoiceModel(this.meaningModelID).setValue(this.meaning);
            AbstractJokerKeyComponent.this.getApplication().getFrameworkAccess().getStorageMgr().setInt(1006, 10, this.meaning);
            AbstractJokerKeyComponent.this.getApplication().getFrameworkAccess().getMsgDistrib().sendMessage(79);
        }

        public void deactivate() {
            if (AbstractJokerKeyComponent.this.menuStyle == 0 && this.selectionModelID != -1) {
                AbstractJokerKeyComponent.this.getChoiceModel(this.selectionModelID).setValue(0);
            }
        }

        public void setVisible(boolean bl) {
            this.visible = bl;
            AbstractJokerKeyComponent.this.getLogChannel().log(10000000, "[AbstractJokerKeyComponent.JokerKeyFunction#setVisible] menuEntryID=%2, visible=%1", bl, (long)this.menuEntryID);
            this.updateMenuEntryVisiblity();
        }

        public boolean isVisible() {
            return this.visible;
        }

        private void updateMenuEntryVisiblity() {
            AbstractJokerKeyComponent.this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(this.menuEntryID, this.visible ? 0 : 1);
        }
    }

    private class JokerKeyFunctionCluster
    extends JokerKeyFunction {
        public JokerKeyFunctionCluster(int n, int n2, int n3, int n4) {
            super(n, n2, n3, n4);
        }

        protected void updateJokerKeyConfiguration() {
            AbstractJokerKeyComponent.this.getLogChannel().log(10000000, "[JokerKeyFunctionCluster#updateJokerKeyConfiguration] cluster specific joker key function (%1) selected, waiting for confirmation", (long)this.meaning);
            AbstractJokerKeyComponent.this.combiMFLHandler.updateClusterKeyConfiguration(this.meaning);
        }
    }

    private class ExternalKeyServiceTrackerListener
    implements CarServiceTrackerListener {
        private volatile ExternalKeyListener externalKeyService;

        private ExternalKeyServiceTrackerListener() {
        }

        public void serviceAvailable(Object object) {
            AbstractJokerKeyComponent.this.getLogChannel().log(1000000, "[AbstractJokerKeyComponent#serviceAvailable] service received");
            try {
                this.externalKeyService = (ExternalKeyListener)object;
            }
            catch (ClassCastException classCastException) {
                AbstractJokerKeyComponent.this.getLogChannel().log(1000, "[AbstractJokerKeyComponent#serviceAvailable] ExternalKeyListener: cannot cast service");
            }
        }

        public void serviceRemoved() {
            this.externalKeyService = null;
            AbstractJokerKeyComponent.this.getLogChannel().log(10000000, "[AbstractJokerKeyComponent#serviceRemoved] Service has been removed");
        }

        public String[] getTrackedServiceClazzName() {
            return new String[]{(class$de$audi$atip$interapp$ExternalKeyListener == null ? (class$de$audi$atip$interapp$ExternalKeyListener = AbstractJokerKeyComponent.class$("de.audi.atip.interapp.ExternalKeyListener")) : class$de$audi$atip$interapp$ExternalKeyListener).getName()};
        }

        public synchronized boolean sendKey(int n) {
            if (null != this.externalKeyService) {
                this.externalKeyService.supplyExternalKey(100, n, 1, 1);
                this.externalKeyService.supplyExternalKey(100, n, 0, 1);
                return true;
            }
            return false;
        }
    }
}

