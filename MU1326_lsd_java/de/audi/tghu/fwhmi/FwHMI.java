/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.activator.FrameworkException;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.HMIBundle;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.HMIServiceSM;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.IFocusManager;
import de.audi.atip.hmi.IHMITerminalRegistry;
import de.audi.atip.hmi.ILegalDisclaimer;
import de.audi.atip.hmi.IRootWindow;
import de.audi.atip.hmi.cc.IComponentConditionManager;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.CombiInfoEvent;
import de.audi.atip.hmi.event.ComponentConditionEvent;
import de.audi.atip.hmi.event.EnablePartialPopupsEvent;
import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.atip.hmi.event.EventDispatcherAdmin;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.event.SDSEvent;
import de.audi.atip.hmi.event.StateMachineEvent;
import de.audi.atip.hmi.event.UnitChangedEvent;
import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.property.PropertyModelApp;
import de.audi.atip.hmi.modelaccess.BrowserModelApp;
import de.audi.atip.hmi.modelaccess.BufferedFolderListModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.DataModelApp;
import de.audi.atip.hmi.modelaccess.DynamicListModelApp;
import de.audi.atip.hmi.modelaccess.FastScrollingModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.IPSpellerModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.hmi.modelaccess.SlidingListModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.hmi.modelaccess.TextEditorModelApp;
import de.audi.atip.hmi.modelaccess.TextEditorModelDDApp;
import de.audi.atip.hmi.modelaccess.TextfieldModelApp;
import de.audi.atip.hmi.modelaccess.TooltipModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.hmi.view.IDisplayManager;
import de.audi.atip.hmi.view.IKeyBoardManager;
import de.audi.atip.hmi.view.IModelConnectService;
import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import de.audi.atip.hmi.view.IPopupManager;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.IScreenManager;
import de.audi.atip.hmi.view.ITerminalContext;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.tghu.fwhmi.FwHMI$1;
import de.audi.tghu.fwhmi.FwHMI$2;
import de.audi.tghu.fwhmi.FwHMI$3;
import de.audi.tghu.fwhmi.FwHMI$4;
import de.audi.tghu.fwhmi.FwHMI$HMIInfoProvider;
import de.audi.tghu.fwhmi.HMIEventDispatcher;
import de.audi.tghu.fwhmi.HMIRegistry;
import de.audi.tghu.fwhmi.HMITerminalRegistry;
import de.audi.tghu.fwhmi.LegalDisclaimer;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;

public class FwHMI
implements HMIService,
HMIServiceSM,
MsgListener {
    private final LogChannel logATIPEvent;
    protected final LogChannel logHMIService;
    private final IFrameworkAccess framework;
    private IDisplayManager dispMgr;
    protected HMIRegistry hmiRegistry;
    private final HMIEventDispatcher eventDispatcher;
    private IFocusManager focusManager = null;
    private IKeyBoardManager keyBoardmManager = null;
    private ILegalDisclaimer legalDisclaimer;
    private final int[] currentSubterminals;
    private final ITerminalContext[] terminalManagers = new ITerminalContext[8];
    private ATIPEventListener[] modelUpdateEventReceivers;
    private final Object unconnectedMonitor = new Object();
    private ATIPEventListener[] unitChangedEventReceivers;
    private SDSService sdsService;
    private boolean isFirstScreenDrawn = false;

    public FwHMI(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        AbstractModelBank.setHMIservice(this);
        this.logATIPEvent = this.getFramework().getLogChannel("Fw.ATIPEvent");
        this.logHMIService = this.getFramework().getLogChannel("Fw.HMIService.Main");
        this.eventDispatcher = new HMIEventDispatcher(this.getFramework());
        this.currentSubterminals = new int[8];
        for (int i2 = 0; i2 < 8; ++i2) {
            this.currentSubterminals[i2] = 0;
        }
    }

    public void init() {
        this.registerModelUpdateEventReceivers();
        this.logHMIService.log(-2137614336, "FwHMI#startLastMode() - create HMIRegistry...");
        this.createHMIRegistry();
        this.hmiRegistry.setSkin(System.getProperty("variant.skin", "EvoHigh"));
        ((HMITerminalRegistry)this.getTerminalRegistry()).setSkin(System.getProperty("variant.widgets", "EvoHigh"));
    }

    protected void createHMIRegistry() {
        if (null == this.hmiRegistry) {
            this.hmiRegistry = new HMIRegistry(this.getFramework().getBundleCxt(), this);
        }
    }

    public final IFrameworkAccess getFramework() {
        return this.framework;
    }

    public IHMITerminalRegistry getTerminalRegistry() {
        return this.getFramework().getHMITerminalRegistry();
    }

    @Override
    public EventDispatcher getEventDispatcher() {
        return this.eventDispatcher;
    }

    @Override
    public EventDispatcherAdmin getEventDispatcherAdmin() {
        return this.eventDispatcher;
    }

    @Override
    public IDisplayManager getDisplayManager() {
        if (this.dispMgr == null) {
            this.dispMgr = this.getFramework().getHMITerminalRegistry().getDisplayManager();
        }
        return this.dispMgr;
    }

    @Override
    public ILegalDisclaimer getLegalDisclaimer() {
        return this.legalDisclaimer;
    }

    @Override
    public IFocusManager getFocusManager() {
        return this.focusManager;
    }

    void setFocusManager(IFocusManager iFocusManager) {
        this.focusManager = iFocusManager;
    }

    public HMIRegistry getHMIRegistry() {
        return this.hmiRegistry;
    }

    void setKeyBoardManager(IKeyBoardManager iKeyBoardManager) {
        this.keyBoardmManager = iKeyBoardManager;
    }

    private int getDefaultTerminalId() {
        return this.getFramework().isFrontMU() ? 0 : -1;
    }

    protected ITerminalContext getTerminalManager(int n) {
        if (n < 0 || n > 8) {
            this.logHMIService.log(10000, "FwHMI#getTerminalManager: No terminalManager for terminal ID %1", (long)n);
            try {
                throw new RuntimeException("Create Callstack");
            }
            catch (Exception exception) {
                this.logHMIService.log(10000, "CallStack for invalid TerminalID", (Throwable)exception);
                return null;
            }
        }
        if (this.terminalManagers[0] == null) {
            this.initTerminalContexts();
        }
        return this.terminalManagers[n];
    }

    private void initTerminalContexts() {
        IHMITerminalRegistry iHMITerminalRegistry = this.getFramework().getHMITerminalRegistry();
        this.terminalManagers[0] = iHMITerminalRegistry.getTerminalContext(0);
        this.terminalManagers[7] = iHMITerminalRegistry.getTerminalContext(7);
        this.terminalManagers[6] = iHMITerminalRegistry.getTerminalContext(6);
        this.terminalManagers[1] = iHMITerminalRegistry.getTerminalContext(1);
        if (this.getFramework().isFrontMU()) {
            if (this.framework.isShowDDP2Combi()) {
                this.terminalManagers[1] = iHMITerminalRegistry.getTerminalContext(1);
            }
            if (this.getFramework().isDualView()) {
                this.terminalManagers[2] = iHMITerminalRegistry.getTerminalContext(2);
            }
        } else {
            this.terminalManagers[3] = iHMITerminalRegistry.getTerminalContext(3);
            this.terminalManagers[4] = iHMITerminalRegistry.getTerminalContext(4);
            this.terminalManagers[5] = iHMITerminalRegistry.getTerminalContext(5);
        }
        for (int i2 = 0; i2 < 8; ++i2) {
            if (this.terminalManagers[i2] == null) continue;
            this.terminalManagers[i2].initialize(this);
        }
    }

    @Override
    public HMITerminal getHMITerminal(int n) {
        return this.getTerminalRegistry().getTerminal(n);
    }

    @Override
    public int getFocusedTerminal() {
        IFocusManager iFocusManager = this.getFocusManager();
        if (iFocusManager != null) {
            return iFocusManager.getFocusedTerminal();
        }
        return -2;
    }

    @Override
    public IRootWindow getRootWindow(int n) {
        ITerminalContext iTerminalContext = this.getTerminalManager(n);
        return iTerminalContext == null ? null : iTerminalContext.getRootWindow();
    }

    @Override
    public IScreenManager getScreenManager(int n) {
        ITerminalContext iTerminalContext = this.getTerminalManager(n);
        return iTerminalContext == null ? null : iTerminalContext.getScreenManager();
    }

    @Override
    public IPopupManager getPopupManager(int n) {
        ITerminalContext iTerminalContext = this.getTerminalManager(n);
        return iTerminalContext == null ? null : iTerminalContext.getPopupManager();
    }

    public IPartialPopupManager getPartialPopupManager(int n) {
        ITerminalContext iTerminalContext = this.getTerminalManager(n);
        return iTerminalContext == null ? null : iTerminalContext.getPartialPopupManager();
    }

    @Override
    public IModelConnectService getModelConnectService(int n) {
        return this.getScreenManager(n).getModelConnectService();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void checkForPostConnecting(HMIApplication hMIApplication) {
        Object object = this.unconnectedMonitor;
        synchronized (object) {
            for (int i2 = 0; i2 < 8; ++i2) {
                for (int i3 = 0; i3 < 4; ++i3) {
                    IScreenManager iScreenManager = this.getScreenManager(i2, i3);
                    if (iScreenManager == null) continue;
                    iScreenManager.getModelConnectService().checkForPostConnecting(hMIApplication);
                }
            }
        }
    }

    private ITerminalContext getTerminalManager(int n, int n2) {
        if (n < 0 || n > 8) {
            this.logHMIService.log(10000, "No terminalManager for terminal ID %1", (long)n);
            return null;
        }
        if (n2 < 0 || n2 > 4) {
            this.logHMIService.log(10000, "No terminalManager for terminal=%1, subterminal=%2", (long)n, (long)n2);
            return null;
        }
        return this.getTerminalManager(n) == null ? null : this.getTerminalManager(n).getSubterminal(n2);
    }

    private IScreenManager getScreenManager(int n, int n2) {
        ITerminalContext iTerminalContext = this.getTerminalManager(n, n2);
        return iTerminalContext == null ? null : iTerminalContext.getScreenManager();
    }

    @Override
    public void setActiveSubterminal(int n, int n2) {
        this.logHMIService.log(-2137614336, "FwHMI.setActiveSubterminal(terminal=%1, subTerminal=%2) called", (long)n, (long)n2);
        this.currentSubterminals[n] = n2;
        if (n == 1 && this.getFramework().isSimulator() && this.framework.isShowDDP2Combi()) {
            CombiInfoEvent combiInfoEvent = new CombiInfoEvent(this.getRootWindow(1), 0);
            combiInfoEvent.setType(4);
            combiInfoEvent.setActiveApplication(n2);
            this.getFramework().getHMIService().getEventDispatcher().postEvent(combiInfoEvent);
        }
    }

    protected void postRunnable(Runnable runnable, boolean bl) {
        this.getEventDispatcher().postEvent(new RunnableEvent(bl, runnable));
    }

    @Override
    public ModelUpdateEvent getModelUpdateEvent(int n) {
        this.logATIPEvent.log(-2137614336, "FwHMI.getModelUpdateEvent()");
        ModelUpdateEvent modelUpdateEvent = new ModelUpdateEvent(this.modelUpdateEventReceivers, 10301);
        modelUpdateEvent.setTerminalID(n);
        return modelUpdateEvent;
    }

    @Override
    public void postModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.logATIPEvent.log(-2137614336, "FwHMI.postModelUpdateEvent(), ID=%1", (long)modelUpdateEvent.getID());
        this.getEventDispatcher().postEvent(modelUpdateEvent);
    }

    @Override
    public void postComponentConditionEvent(int[] nArray) {
        this.logATIPEvent.log(-2137614336, "FwHMI.postComponentConditionEvent(), changedCCIDs=%1", (Object)nArray);
        this.getEventDispatcher().postEvent(new ComponentConditionEvent(this.modelUpdateEventReceivers, nArray));
    }

    @Override
    public void fireSDSEvent(int n, int n2, int n3, int[] nArray) {
        this.logATIPEvent.log(-2137614336, "FwHMI.fireSDSEvent(responseType=%1, command=%2, value=%3)", (long)n, (long)n2, (long)n3);
        this.getEventDispatcher().postEvent(new SDSEvent(this.getRootWindow(0), 10701, n, n2, n3, nArray));
    }

    private void fireSMEventViaCurrentScreen(Screen screen, int n, int n2, AdditionalScreenData additionalScreenData) {
        if (screen != null) {
            int n3 = screen.getEventID(n);
            this.logATIPEvent.log(-2137614336, "FwHMI#fireSMEventViaCurrentScreen: eventID=%1", (long)n3);
            if (n3 > 0) {
                this.getEventDispatcher().postEvent(new StateMachineEvent(this.getRootWindow(n2), 10201, n2, n3, additionalScreenData));
            }
        } else {
            this.logATIPEvent.log(10000, "FwHMI#fireSMEventViaCurrentScreen: currentScreen is null, terminalID=%1, modelID=%2", (long)n2, (long)n);
        }
    }

    @Override
    public void fireSMEvent(int n, int n2) {
        this.logATIPEvent.log(-2137614336, "FwHMI.fireSMEvent(smID=%1, eventID=%2)", (long)n, (long)n2);
        if (n == -1) {
            if (this.getFramework().isFrontMU()) {
                this.getEventDispatcher().postEvent(new StateMachineEvent(this.getRootWindow(0), 10201, 0, n2));
                if (this.framework.isShowDDP2Combi()) {
                    this.getEventDispatcher().postEvent(new StateMachineEvent(this.getRootWindow(1), 10201, 1, n2));
                }
            } else {
                this.getEventDispatcher().postEvent(new StateMachineEvent(this.getRootWindow(3), 10201, 3, n2));
                this.getEventDispatcher().postEvent(new StateMachineEvent(this.getRootWindow(4), 10201, 4, n2));
            }
        } else {
            this.getEventDispatcher().postEvent(new StateMachineEvent(this.getRootWindow(n), 10201, n, n2));
        }
    }

    @Override
    public void fireSMEventDirectlyInEventDispatchThread(int n, int n2) {
        this.logATIPEvent.log(-2137614336, "FwHMI.fireSMEventDirectlyInEventDispatchThread(smID=%1, eventID=%2)", (long)n, (long)n2);
        if (n == -1) {
            if (this.getFramework().isFrontMU()) {
                this.getRootWindow(0).processEvent(new StateMachineEvent(this.getRootWindow(0), 10201, 0, n2));
                if (this.framework.isShowDDP2Combi()) {
                    this.getEventDispatcher().postEvent(new StateMachineEvent(this.getRootWindow(1), 10201, 1, n2));
                }
            } else {
                this.getRootWindow(3).processEvent(new StateMachineEvent(this.getRootWindow(3), 10201, 3, n2));
                this.getRootWindow(4).processEvent(new StateMachineEvent(this.getRootWindow(4), 10201, 4, n2));
            }
        } else {
            this.getRootWindow(n).processEvent(new StateMachineEvent(this.getRootWindow(n), 10201, n, n2));
        }
    }

    @Override
    public void fireSMEventFromModelId(int n, int n2) {
        this.fireSMEventFromModelId(n, n2, null);
    }

    @Override
    public void fireSMEventFromModelId(int n, int n2, AdditionalScreenData additionalScreenData) {
        this.logATIPEvent.log(-2137614336, "FwHMI#fireSMEventFromModelId: smID=%1, modelID=%2", (long)n, (long)n2);
        if (n == -1) {
            for (int i2 = 0; i2 < 8; ++i2) {
                Screen screen;
                IScreenManager iScreenManager = this.getScreenManager(i2);
                if (iScreenManager == null || iScreenManager.getCurrentConnectedScreen() == null || (screen = iScreenManager.getCurrentConnectedScreen()) == null) continue;
                this.fireSMEventViaCurrentScreen(screen, n2, i2, additionalScreenData);
            }
        } else if (n == 1 && this.getTerminalManager(1) == null) {
            this.logATIPEvent.log(-2137614336, "FwHMI#fireSMEventFromModelId no terminal for cluster started, must be BAP-protocol: smID=%1, modelID=%2", (long)n, (long)n2);
        } else {
            Screen screen = this.getCurrentScreen(n);
            this.fireSMEventViaCurrentScreen(screen, n2, n, additionalScreenData);
        }
    }

    @Override
    public void fireKeyEvent(int n, long l, int n2, int n3) {
        if (this.keyBoardmManager != null) {
            this.keyBoardmManager.fireKeyEvent(n, l, n2, n3);
        }
    }

    @Override
    public void fireKeyEventDirectlyInEventDispatchThread(int n, long l, int n2, int n3) {
        if (this.getEventDispatcher().isDispatchThread()) {
            if (this.keyBoardmManager != null) {
                this.keyBoardmManager.fireKeyEventDirectlyInEventDispatchThread(n, l, n2, n3);
            }
        } else {
            this.logATIPEvent.log(1000, " trying to call method outside of event dispatch thread in thread: %1", (Object)Thread.currentThread());
            throw new FrameworkException("Not allowed to call method fireKeyEventDirectlyInEventDispatchThread from outside event dispatch thread");
        }
    }

    @Override
    public void fireJoyStickEvent(int n, long l, int n2, int n3, int n4) {
        if (this.keyBoardmManager != null) {
            this.keyBoardmManager.fireJoyStickEvent(n, l, n2, n3, n4);
        }
    }

    @Override
    public void fireWheelButtonEvent(int n, long l, int n2, int n3, int n4, int n5) {
        if (this.keyBoardmManager != null) {
            this.keyBoardmManager.fireWheelButtonEvent(n, l, n2, n3, n4, n5);
        }
    }

    @Override
    public void fireTouchEvent(int n, long l, int n2, int n3, int n4, int n5, int n6) {
        if (this.keyBoardmManager != null) {
            this.keyBoardmManager.fireTouchEvent(n, l, n2, n3, n4, n5, n6);
        }
    }

    @Override
    public void fireTouchEvent(int n, long l, int n2, int n3, int n4, String string, int[] nArray, int n5) {
        if (this.keyBoardmManager != null) {
            this.keyBoardmManager.fireTouchEvent(n, l, n2, n3, n4, string, nArray, n5);
        }
    }

    @Override
    public void fireGestureEvent(int n, long l, int n2, int n3, int n4) {
        if (this.keyBoardmManager != null) {
            this.keyBoardmManager.fireGestureEvent(n, l, n2, n3, n4);
        }
    }

    @Override
    public void fireGestureEvent(int n, long l, int n2, int n3, int n4, int n5, int n6, int n7) {
        if (this.keyBoardmManager != null) {
            this.keyBoardmManager.fireGestureEvent(n, n4, n2, n3, n5, n6, l, n7);
        }
    }

    @Override
    public void fireGestureEvent(int n, long l, int n2, int n3, String[] stringArray, int[] nArray, int n4) {
        if (this.keyBoardmManager != null) {
            this.keyBoardmManager.fireGestureEvent(n, l, n2, n3, stringArray, nArray, n4);
        }
    }

    public void fireSMEventFromModelId(int n, int n2, int n3) {
        this.logATIPEvent.log(-2137614336, "FwHMI#fireSMEventFromModelId: smID=%1, subTerminalID=%2, modelID=%3", (long)n, (long)n2, (long)n3);
        if (n == -1) {
            for (int i2 = 0; i2 < 8; ++i2) {
                Screen screen;
                IScreenManager iScreenManager = this.getScreenManager(i2, n2);
                if (iScreenManager == null || iScreenManager.getCurrentConnectedScreen() == null || (screen = iScreenManager.getCurrentConnectedScreen()) == null) continue;
                this.fireSMEventViaCurrentScreen(screen, n3, i2, null);
            }
        } else if (n == 1 && this.getTerminalManager(1) == null) {
            this.logATIPEvent.log(-2137614336, "FwHMI#fireSMEventFromModelId no terminal for cluster started, must be BAP-protocol: smID=%1, subTerminalID=%2, modelID=%3", (long)n, (long)n2, (long)n3);
        } else {
            Screen screen = this.getCurrentScreen(n, n2);
            this.fireSMEventViaCurrentScreen(screen, n3, n, null);
        }
    }

    private void registerModelUpdateEventReceivers() {
        if (this.getFramework().isFrontMU()) {
            if (this.getFramework().isDualView()) {
                this.modelUpdateEventReceivers = new IRootWindow[3];
                this.modelUpdateEventReceivers[0] = this.getRootWindow(0);
                this.modelUpdateEventReceivers[1] = this.getRootWindow(1);
                this.modelUpdateEventReceivers[2] = this.getRootWindow(2);
            } else {
                this.modelUpdateEventReceivers = new IRootWindow[2];
                this.modelUpdateEventReceivers[0] = this.getRootWindow(0);
                this.modelUpdateEventReceivers[1] = this.getRootWindow(1);
            }
        } else {
            this.modelUpdateEventReceivers = new IRootWindow[3];
            this.modelUpdateEventReceivers[0] = this.getRootWindow(3);
            this.modelUpdateEventReceivers[1] = this.getRootWindow(4);
            this.modelUpdateEventReceivers[2] = this.getRootWindow(5);
        }
    }

    @Override
    public Object getImage(int n, int n2, int n3, int n4) {
        return this.getTerminalManager(n2).getImageImpl(n, true, n3, n4);
    }

    HMIApplication getHMIApplication(int n) {
        return this.getHMIRegistry().getHMIApplication(n);
    }

    @Override
    public HMIBundle getHMIBundle(int n) {
        return this.getHMIRegistry().getHMIBundle(n);
    }

    @Override
    public HMIModel getModel(int n) {
        return this.getModel(0, n);
    }

    @Override
    public HMIModelApp getModelApp(int n) {
        return this.getModel(n);
    }

    @Override
    public HMIModel getModel(int n, int n2) {
        return this.getHMIRegistry().getModel(n, n2);
    }

    @Override
    public HMIModelApp getModelApp(int n, int n2) {
        return this.getModel(n, n2);
    }

    @Override
    public ChoiceModelApp getChoiceModel(int n) {
        return (ChoiceModelApp)((Object)this.getModel(n));
    }

    @Override
    public ChoiceModelApp getChoiceModel(int n, int n2) {
        return (ChoiceModelApp)((Object)this.getModel(n, n2));
    }

    @Override
    public TextEditorModelApp getTextEditorModel(int n) {
        return (TextEditorModelApp)((Object)this.getModel(n));
    }

    @Override
    public TextEditorModelApp getTextEditorModel(int n, int n2) {
        return (TextEditorModelApp)((Object)this.getModel(n, n2));
    }

    @Override
    public TextEditorModelDDApp getTextEditorModelDD(int n) {
        return (TextEditorModelDDApp)((Object)this.getModel(n));
    }

    @Override
    public TextEditorModelDDApp getTextEditorModelDD(int n, int n2) {
        return (TextEditorModelDDApp)((Object)this.getModel(n, n2));
    }

    @Override
    public ButtonModelApp getButtonModel(int n) {
        return (ButtonModelApp)((Object)this.getModel(n));
    }

    @Override
    public ButtonModelApp getButtonModel(int n, int n2) {
        return (ButtonModelApp)((Object)this.getModel(n, n2));
    }

    @Override
    public OptionModelApp getOptionModel(int n) {
        return (OptionModelApp)((Object)this.getModel(n));
    }

    @Override
    public LabelModelApp getLabelModel(int n) {
        return (LabelModelApp)((Object)this.getModel(n));
    }

    @Override
    public LabelModelApp getLabelModel(int n, int n2) {
        return (LabelModelApp)((Object)this.getModel(n, n2));
    }

    @Override
    public ListModelApp getListModel(int n) {
        return (ListModelApp)((Object)this.getModel(n));
    }

    @Override
    public ListModelApp getListModel(int n, int n2) {
        return (ListModelApp)((Object)this.getModel(n, n2));
    }

    @Override
    public BaseListModelApp getBaseListModel(int n) {
        return (BaseListModelApp)((Object)this.getModel(n));
    }

    @Override
    public TiledListModelApp getTiledListModel(int n) {
        return (TiledListModelApp)((Object)this.getModel(n));
    }

    @Override
    public MetricsModelApp getMetricsModel(int n) {
        return (MetricsModelApp)((Object)this.getModel(n));
    }

    @Override
    public MetricsModelApp getMetricsModel(int n, int n2) {
        return (MetricsModelApp)((Object)this.getModel(n, n2));
    }

    @Override
    public RangeModelApp getRangeModel(int n) {
        return (RangeModelApp)((Object)this.getModel(n));
    }

    @Override
    public RangeModelApp getRangeModel(int n, int n2) {
        return (RangeModelApp)((Object)this.getModel(n, n2));
    }

    @Override
    public IPSpellerModelApp getIPSpellerModel(int n) {
        return (IPSpellerModelApp)((Object)this.getModel(n));
    }

    @Override
    public IPSpellerModelApp getIPSpellerModel(int n, int n2) {
        return (IPSpellerModelApp)((Object)this.getModel(n, n2));
    }

    @Override
    public SpellerModelApp getSpellerModel(int n) {
        return (SpellerModelApp)((Object)this.getModel(n));
    }

    @Override
    public SpellerModelApp getSpellerModel(int n, int n2) {
        return (SpellerModelApp)((Object)this.getModel(n, n2));
    }

    @Override
    public MatchspellerModelApp getMatchSpellerModel(int n) {
        return (MatchspellerModelApp)((Object)this.getModel(n));
    }

    @Override
    public SlidingListModelApp getSlidingListModel(int n) {
        return (SlidingListModelApp)((Object)this.getModel(n));
    }

    @Override
    public TooltipModelApp getTooltipModel(int n) {
        return (TooltipModelApp)((Object)this.getModel(n));
    }

    @Override
    public TooltipModelApp getTooltipModel(int n, int n2) {
        return (TooltipModelApp)((Object)this.getModel(n, n2));
    }

    @Override
    public TextfieldModelApp getTextfieldModel(int n) {
        return (TextfieldModelApp)((Object)this.getModel(n));
    }

    @Override
    public DynamicListModelApp getDynamicListModel(int n) {
        return (DynamicListModelApp)((Object)this.getModel(n));
    }

    @Override
    public DynamicListModelApp getDynamicListModel(int n, int n2) {
        return (DynamicListModelApp)((Object)this.getModel(n, n2));
    }

    @Override
    public ResourceLocatorModelApp getResourceLocatorModel(int n) {
        return (ResourceLocatorModelApp)((Object)this.getModel(n));
    }

    @Override
    public ResourceLocatorModelApp getResourceLocatorModel(int n, int n2) {
        return (ResourceLocatorModelApp)((Object)this.getModel(n, n2));
    }

    @Override
    public FastScrollingModelApp getFastScrollingModel(int n) {
        return (FastScrollingModelApp)((Object)this.getModel(n));
    }

    @Override
    public VirtualButtonModelApp getVirtualButtonModel(int n) {
        return (VirtualButtonModelApp)((Object)this.getModel(n));
    }

    @Override
    public BufferedFolderListModelApp getBufferedFolderListModel(int n) {
        return (BufferedFolderListModelApp)((Object)this.getModel(n));
    }

    @Override
    public BufferedFolderListModelApp getBufferedFolderListModel(int n, int n2) {
        return (BufferedFolderListModelApp)((Object)this.getModel(n, n2));
    }

    @Override
    public BrowserModelApp getBrowserModel(int n) {
        return (BrowserModelApp)((Object)this.getModel(n));
    }

    @Override
    public DataModelApp getDataModel(int n) {
        return (DataModelApp)((Object)this.getModel(n));
    }

    @Override
    public MenuModelApp getMenuModel(int n) {
        return (MenuModelApp)((Object)this.getModel(n));
    }

    @Override
    public PropertyModelApp getPropertyModel(int n) {
        return (PropertyModelApp)((Object)this.getModel(n));
    }

    @Override
    public PropertyModelApp getPropertyModel(int n, int n2) {
        return (PropertyModelApp)((Object)this.getModel(n2));
    }

    @Override
    public String getText(int n) {
        return this.getHMIRegistry().getText(n);
    }

    @Override
    public String getText(int n, int n2) {
        return this.getText(n);
    }

    @Override
    public Object getUncachedImage(int n, int n2, int n3, int n4) {
        return this.getTerminalManager(n2).getImageImpl(n, false, n3, n4);
    }

    @Override
    public void showScreen(int n, int n2, IScreenData iScreenData) {
        if (this.logHMIService.isDebug()) {
            this.logHMIService.log(-2137614336, "FwHMI.showScreen(terminal=%2, screen=%1)", (Object)iScreenData, (long)n);
        }
        this.getScreenManager(n, n2).showScreen(iScreenData);
        if (!this.isFirstScreenDrawn) {
            this.getFramework().getStartupMgr().triggerNewScreenVisible();
            this.isFirstScreenDrawn = true;
        }
    }

    private Screen getCurrentScreen(int n) {
        if (n == 1) {
            return this.getCurrentlyActiveCombiScreen();
        }
        return this.getScreenManager(n).getCurrentConnectedScreen();
    }

    private Screen getCurrentScreen(int n, int n2) {
        if (n == 1) {
            if (n2 == 0) {
                return this.getCurrentlyActiveCombiScreen();
            }
            IScreenManager iScreenManager = this.getScreenManager(n, n2);
            return iScreenManager != null ? iScreenManager.getCurrentConnectedScreen() : null;
        }
        return this.getScreenManager(n).getCurrentConnectedScreen();
    }

    @Override
    public void lockCurrentScreen(int n, boolean bl) {
        if (n != 6) {
            this.logHMIService.log(-2137614336, "FwHMI.lockCurrentScreen() called");
            this.getScreenManager(n).lockCurrentConnectedScreen(bl);
        } else {
            this.logHMIService.log(-2137614336, "FwHMI.lockCurrentScreen() called for Speech-Terminal. Ignoring.");
        }
    }

    public int getCurrentScreenID() {
        return this.getScreenManager(0).getCurrentScreenId();
    }

    public IScreenData getCurrentScreenData() {
        return this.getScreenManager(0).getCurrentScreenData();
    }

    public IScreenData getCurrentConnectedScreenData() {
        return this.getScreenManager(0).getCurrentConnectedScreenData();
    }

    @Override
    public void refreshTerminal(int n) {
        this.logHMIService.log(-2137614336, "FwHMI.refreshTerminal( terminal = %1 )", (long)n);
        for (int i2 = 0; i2 < 4; ++i2) {
            IScreenManager iScreenManager = this.getScreenManager(1, i2);
            if (iScreenManager == null) continue;
            iScreenManager.refresh();
        }
    }

    @Override
    public Screen getCurrentlyActiveCombiScreen() {
        if (this.currentSubterminals[1] != 0) {
            IScreenManager iScreenManager = this.getScreenManager(1, this.currentSubterminals[1]);
            if (iScreenManager != null) {
                return iScreenManager.getCurrentConnectedScreen();
            }
            this.logHMIService.log(10000, "ScreenManager is null!");
            return null;
        }
        return null;
    }

    @Override
    public Screen[] getCurrentlyActiveCombiScreens() {
        Screen[] screenArray = new Screen[4];
        for (int i2 = 0; i2 < 4; ++i2) {
            IScreenManager iScreenManager = this.getScreenManager(1, i2);
            if (iScreenManager == null) continue;
            screenArray[i2] = iScreenManager.getCurrentConnectedScreen();
        }
        return screenArray;
    }

    @Override
    public void showPopup(int n, int n2) {
        this.logHMIService.log(-2137614336, "FwHMI.showPopup(popupId = %1, terminalId = %2) called", (long)n, (long)n2);
        if (n2 == -1) {
            for (int i2 = 0; i2 < 8; ++i2) {
                this.showPopupImpl(n, i2);
            }
        } else {
            this.showPopupImpl(n, n2);
        }
    }

    private void showPopupImpl(int n, int n2) {
        if (this.getRootWindow(n2) != null && this.getPopupManager(n2) != null) {
            this.getPopupManager(n2).showPopup(n);
        }
    }

    @Override
    public void showPopup(int n) {
        this.showPopup(n, this.getDefaultTerminalId());
    }

    @Override
    public void removePopup(int n, int n2) {
        this.logHMIService.log(-2137614336, "FwHMI.removePopup(popupId=%1, terminalId=%2)", (long)n, (long)n2);
        if (n2 == -1) {
            for (int i2 = 0; i2 < 8; ++i2) {
                this.removePopupImpl(n, i2);
            }
        } else {
            this.removePopupImpl(n, n2);
        }
    }

    private void removePopupImpl(int n, int n2) {
        if (this.getPopupManager(n2) != null) {
            this.getPopupManager(n2).removePopup(n);
        }
    }

    @Override
    public void removePopup(int n) {
        this.removePopup(n, this.getDefaultTerminalId());
    }

    @Override
    public void setPopupKeyConsuptionStrategy(IPopupKeyConsuptionStrategy iPopupKeyConsuptionStrategy) {
        if (this.getPopupManager(this.getDefaultTerminalId()) != null) {
            this.getPopupManager(this.getDefaultTerminalId()).setPopupKeyConsuptionStrategy(iPopupKeyConsuptionStrategy);
        }
    }

    @Override
    public boolean removeCurrentPopup(int n) {
        if (this.getPopupManager(n) != null) {
            return this.getPopupManager(n).removeCurrentPopup();
        }
        return false;
    }

    @Override
    public void disablePopups(int n) {
        this.logHMIService.log(-2137614336, "FwHMI.disablePopups()");
        for (int i2 = 0; i2 < 8; ++i2) {
            if (this.getPopupManager(i2) == null) continue;
            this.getPopupManager(i2).disablePopups(n);
        }
    }

    @Override
    public void disablePopups() {
        this.disablePopups(-1);
    }

    @Override
    public void enablePopups() {
        this.logHMIService.log(-2137614336, "FwHMI.enablePopups()");
        for (int i2 = 0; i2 < 8; ++i2) {
            if (this.getPopupManager(i2) == null) continue;
            this.getPopupManager(i2).enablePopups();
        }
    }

    @Override
    public int getCurrentPopup() {
        return this.getCurrentPopup(this.getDefaultTerminalId());
    }

    @Override
    public int getCurrentPopup(int n) {
        IPopupManager iPopupManager = this.getPopupManager(n);
        if (iPopupManager == null) {
            return -1;
        }
        return iPopupManager.getCurrentPopupID();
    }

    @Override
    public int getCurrentPopupPriority(int n) {
        return this.getPopupManager(n).getCurrentPopupPriority();
    }

    @Override
    public void showPopupScreen(int n, IScreenData iScreenData) {
        this.logHMIService.log(-2137614336, "FwHMI.showPopupScreen(terminal = %1, screenId = %2, popupId = %3, ...) called", (long)n, (long)iScreenData.getId(), (long)iScreenData.getPopupId());
        this.logHMIService.log(-2137614336, "FwHMI.showPopupScreen(): popupPriority = %1", (long)iScreenData.getPopupPriority());
        this.getPopupManager(n).showPopupScreen(iScreenData);
    }

    @Override
    public void replacePopupScreen(int n, int n2, int n3, IScreenData iScreenData) {
        this.logHMIService.log(-2137614336, "FwHMI.replacePopupScreen(screen1 = %1, popup = %2, screen2 = %3) called", (long)n2, (long)n3, (long)iScreenData.getId());
        this.getPopupManager(n).replacePopupScreen(n2, iScreenData);
    }

    @Override
    public void removePopupScreen(int n, int n2, int n3, boolean bl) {
        this.logHMIService.log(-2137614336, "FwHMI.removePopupScreen(terminal=%1, screenId == %2, popupId == %3, ..) called", (long)n, (long)n2);
        this.getPopupManager(n).removePopupScreen(n2, bl, true);
    }

    private void doSetPartialPopupsEnabled(int n, boolean bl) {
        IPartialPopupManager iPartialPopupManager = this.getPartialPopupManager(n);
        if (iPartialPopupManager != null) {
            iPartialPopupManager.setPartialPopupsEnabled(bl);
        }
    }

    @Override
    public void setPartialPopupsEnabled(int n, boolean bl) {
        this.logHMIService.log(-2137614336, "FwHMI.setPartialPopupsEnabled(): enabled=%1, terminalID=%2", bl, (long)n);
        if (this.getEventDispatcher().isDispatchThread()) {
            if (n == -1) {
                if (this.getFramework().isFrontMU()) {
                    this.doSetPartialPopupsEnabled(0, bl);
                    this.doSetPartialPopupsEnabled(1, bl);
                } else {
                    this.doSetPartialPopupsEnabled(3, bl);
                    this.doSetPartialPopupsEnabled(4, bl);
                    this.doSetPartialPopupsEnabled(5, bl);
                }
            } else {
                this.doSetPartialPopupsEnabled(n, bl);
            }
        } else {
            this.getEventDispatcher().postEvent(new EnablePartialPopupsEvent((ATIPEventListener)this.getRootWindow(n), bl));
        }
    }

    @Override
    public boolean isPartialPopupVisibleInSlot(int n, int n2) {
        return this.getTerminalManager(n).getPartialPopupManager().hasVisiblePopupInSlot(n2);
    }

    @Override
    public void removeAllPartialPopupsForSlots(int n, int[] nArray) {
        this.logHMIService.log(-2137614336, "FwHMI.removeAllPartialPopupsForSlots for slots: %1 )", (Object)nArray);
        if (this.getEventDispatcher().isDispatchThread()) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.getPartialPopupManager(n).hideAllPopupsAndRepaintScreen(nArray[i2]);
            }
        } else {
            try {
                this.postRunnable(new FwHMI$1(this, nArray, n), true);
            }
            catch (Exception exception) {
                this.logHMIService.log(-1601830656, "FwHMI.removeAllPartialPopupsForSlots(): failed!", (Throwable)exception);
            }
        }
    }

    @Override
    public void removePartialPopup(int n, int n2) {
        this.logHMIService.log(-2137614336, "FwHMI.removePartialPopup(pp == %1)", (long)n2);
        if (this.getEventDispatcher().isDispatchThread()) {
            this.getPartialPopupManager(n).hidePopupAndRepaintScreen(n2);
        } else {
            try {
                this.postRunnable(new FwHMI$2(this, n, n2), true);
            }
            catch (Exception exception) {
                this.logHMIService.log(-1601830656, "FwHMI.removePartialPopup(): failed!", (Throwable)exception);
            }
        }
    }

    @Override
    public void showPartialPopup(int n, int n2) {
        this.logHMIService.log(-2137614336, "PopupManager.showPartialPopup(pp == %1) called", (long)n2);
        if (this.getEventDispatcher().isDispatchThread()) {
            this.getPartialPopupManager(n).showPopupAndRepaintScreen(n2);
        } else {
            try {
                this.postRunnable(new FwHMI$3(this, n, n2), true);
            }
            catch (Exception exception) {
                this.logHMIService.log(-1601830656, "PopupManager.showPartialPopup(): failed!", (Throwable)exception);
            }
        }
    }

    @Override
    public void replacePartialPopup(int n, int n2, int n3) {
        this.logHMIService.log(-2137614336, "PopupManager.replacePartialPopup(pp1 == %1, pp2 == %2) called", (long)n2, (long)n3);
        if (this.getEventDispatcher().isDispatchThread()) {
            this.getPartialPopupManager(n).showPopup(n3);
            this.getPartialPopupManager(n).hidePopupAndRepaintScreen(n2);
        } else {
            try {
                this.postRunnable(new FwHMI$4(this, n, n3, n2), true);
            }
            catch (Exception exception) {
                this.logHMIService.log(-1601830656, "PopupManager.replacePartialPopup(): failed!", (Throwable)exception);
            }
        }
    }

    @Override
    public void removePartialPopups(int n, int n2, int[] nArray) {
        this.logHMIService.log(-2137614336, "FwHMI.removePartialPopups(): screenId = %1", (long)n2);
        this.getScreenManager(n).removePartialPopups(n2, nArray);
    }

    @Override
    public void removePartialPopupsFromPopup(int n, int n2, int n3, int[] nArray) {
        this.logHMIService.log(-2137614336, "FwHMI.removePartialPopupsFromPopup(): screenId = %1, popupId = %2", (long)n2, (long)n3);
        this.getPopupManager(n).removePartialPopupsFromPopup(n2, n3, nArray);
    }

    @Override
    public void showPartialPopups(int n, int n2, int[] nArray) {
        this.logHMIService.log(-2137614336, "FwHMI.showPartialPopups(): screenId=%1", (long)n2);
        this.getScreenManager(n).showPartialPopups(n2, nArray);
    }

    @Override
    public void showPartialPopupsForPopup(int n, int n2, int n3, int[] nArray) {
        this.logHMIService.log(-2137614336, "FwHMI.showPartialPopupsForPopup(): screenId=%1, popupId=%2", (long)n2, (long)n3);
        this.getPopupManager(n).showPartialPopupsForPopup(n2, n3, nArray);
    }

    @Override
    public void takeScreenshot(int n, String string) {
        boolean bl = this.getTerminalManager(n).getHmiTerminal().getGUIManager().isPartialRenderingEnabled();
        boolean bl2 = this.getTerminalManager(n).getHmiTerminal().getGUIManager().isOffscreenPartialRenderingEnabled();
        if (string != null) {
            int n2;
            String string2;
            String string3 = string2 = bl ? "_prOn" : "_prOff";
            if (bl && !bl2) {
                string2 = new StringBuffer().append(string2).append("_no_offscreen_pr").toString();
            }
            string = (n2 = string.lastIndexOf(".")) > 0 ? new StringBuffer().append(string.substring(0, n2 - 1)).append(string2).append(string.substring(n2)).toString() : new StringBuffer().append(string).append(string2).toString();
        }
        this.dispMgr.takeScreenshot(n, string);
    }

    private void initializeLegalDisclaimer() {
        if (this.legalDisclaimer == null) {
            if (this.getFramework().isNar()) {
                this.logHMIService.log(-2137614336, "FwHMI#initializeLegalDisclaimer() - initializing legal disclaimer for NAR");
                this.legalDisclaimer = new LegalDisclaimer(this.getFramework(), this.logHMIService);
            } else {
                this.logHMIService.log(-2137614336, "FwHMI#initializeLegalDisclaimer() - legal disclaimer not initialized for region other than NAR");
            }
        } else {
            this.logHMIService.log(-2137614336, "FwHMI#initializeLegalDisclaimer() - legal disclaimer already active!");
        }
    }

    public DumpInfoProvider createHMIInfoProvider() {
        return new FwHMI$HMIInfoProvider(this, null);
    }

    @Override
    public void setUnsupportedDevelopmentBuild(boolean bl) {
        ((HMITerminalRegistry)this.getTerminalRegistry()).setUnsupportedDevelopmentBuild(true);
    }

    @Override
    public void setFallbackScreen(int n, Screen screen) {
        this.getScreenManager(n).setFallbackScreen(screen);
    }

    @Override
    public void showFallbackScreen(int n) {
        this.getFramework().getStartupMgr().setFallBackScreenShown(true);
        this.getScreenManager(n).showScreen(this.getScreenManager(n).getFallbackScreenData());
    }

    private ATIPEventListener[] getUnitChangedEventReceivers() {
        if (this.unitChangedEventReceivers == null) {
            this.unitChangedEventReceivers = this.getFramework().isFrontMU() ? (this.getFramework().isDualView() ? new IRootWindow[]{this.getRootWindow(0), this.getRootWindow(2)} : new IRootWindow[]{this.getRootWindow(0)}) : new IRootWindow[]{this.getRootWindow(3), this.getRootWindow(4), this.getRootWindow(5)};
        }
        return this.unitChangedEventReceivers;
    }

    @Override
    public void processMsg(int n) {
        if (11 == n) {
            this.getEventDispatcher().postEvent(new UnitChangedEvent(this.getUnitChangedEventReceivers()));
        } else if (101 == n) {
            this.initializeLegalDisclaimer();
        }
    }

    @Override
    public boolean isScreenChangeAnimationRunning(int n) {
        return this.terminalManagers[n].getScreenManager().isScreenChangeAnimationRunning(n);
    }

    @Override
    public IComponentConditionManager getComponentConditionManager() {
        return this.hmiRegistry.getConditionsObserver();
    }

    protected LogChannel getLogATIPEvent() {
        return this.logATIPEvent;
    }

    protected LogChannel getLogHMI() {
        return this.logHMIService;
    }

    @Override
    public void sMActionRequiresNoScreenChange(int n) {
    }

    @Override
    public void showVisualFeedback(long l, String string, int n) {
        this.logHMIService.log(1078071040, "FwHMI#fireVisualFeedbackEvent() - NOT IMPLEMENTED!");
    }

    public void setSDSService(SDSService sDSService) {
        this.sdsService = sDSService;
    }

    @Override
    public int getCurrentPopupID(int n) {
        if (this.getPopupManager(n) != null) {
            return this.getPopupManager(n).getCurrentPopupID();
        }
        return -1;
    }

    @Override
    public void fireTouchEvent(int n, long l, int n2, int n3, int n4, int n5, boolean bl, int n6, int n7, int n8, int n9) {
        if (this.keyBoardmManager != null) {
            this.keyBoardmManager.fireTouchEvent(n, l, n2, n3, n4, n5, bl, n6, n7, n8, n9);
        }
    }
}

