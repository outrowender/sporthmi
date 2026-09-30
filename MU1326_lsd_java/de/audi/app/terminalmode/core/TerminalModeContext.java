/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.core;

import de.audi.app.terminalmode.CommandListHelper;
import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.INightDayModeHandler;
import de.audi.app.terminalmode.ITerminalLogger;
import de.audi.app.terminalmode.ITerminalModeConfiguration;
import de.audi.app.terminalmode.NaviAppHandler;
import de.audi.app.terminalmode.PhoneAppHandler;
import de.audi.app.terminalmode.actionproxy.IActionProxyDispatcher;
import de.audi.app.terminalmode.actionproxy.IActionProxyListener;
import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.device.IDeviceManager;
import de.audi.app.terminalmode.diagnosis.IDiagnosisManager;
import de.audi.app.terminalmode.dsi.smartphoneintegration.ISmartphoneIntegrationDSIController;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.keyevents.TMKeyEventsHandler;
import de.audi.app.terminalmode.keyevents.TMVirtualButtonListener;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.app.terminalmode.smartphone.HardKeyDSIListener;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.injector.IInjector;
import de.audi.tghu.command.CommandListManager;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class TerminalModeContext
implements IContext {
    private final IFrameworkAccess framework;
    private final IHMIServiceApp hmiService;
    private final IActionProxyDispatcher actionProxyDispatcher;
    private final IInjector injector;
    private final ITerminalLogger logger;
    private final DispatcherBase dispatcher;
    private final ITerminalModeConfiguration configuration;
    private final IServiceManager serviceManager;
    private final CommandListManager commandListManager;
    private final TMKeyEventsHandler keyEventsHandler;
    private final TMVirtualButtonListener virtualButtonListener;
    private final CommandListHelper commandListHelper;
    private final IDiagnosisManager diagnosisManager;
    private final IEventBus eventBus;
    static /* synthetic */ Class class$de$audi$app$terminalmode$audio$IAudioManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$DeviceManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$smartphoneintegration$ISmartphoneIntegrationDSIController;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$HardKeyDSIListener;
    static /* synthetic */ Class class$de$audi$app$terminalmode$PhoneAppHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$NaviAppHandler;
    static /* synthetic */ Class class$de$audi$app$terminalmode$INightDayModeHandler;

    public TerminalModeContext(IFrameworkAccess iFrameworkAccess, IHMIServiceApp iHMIServiceApp, IInjector iInjector, ITerminalLogger iTerminalLogger, DispatcherBase dispatcherBase, ITerminalModeConfiguration iTerminalModeConfiguration, IServiceManager iServiceManager, IActionProxyDispatcher iActionProxyDispatcher, CommandListManager commandListManager, TMKeyEventsHandler tMKeyEventsHandler, TMVirtualButtonListener tMVirtualButtonListener, CommandListHelper commandListHelper, IDiagnosisManager iDiagnosisManager, IEventBus iEventBus) {
        this.framework = iFrameworkAccess;
        this.hmiService = iHMIServiceApp;
        this.injector = iInjector;
        this.logger = iTerminalLogger;
        this.dispatcher = dispatcherBase;
        this.configuration = iTerminalModeConfiguration;
        this.serviceManager = iServiceManager;
        this.actionProxyDispatcher = iActionProxyDispatcher;
        this.commandListManager = commandListManager;
        this.keyEventsHandler = tMKeyEventsHandler;
        this.virtualButtonListener = tMVirtualButtonListener;
        this.commandListHelper = commandListHelper;
        this.diagnosisManager = iDiagnosisManager;
        this.eventBus = iEventBus;
    }

    public int getTerminalId() {
        return 0;
    }

    public void addActionProxyListener(int n, IActionProxyListener iActionProxyListener) {
        this.actionProxyDispatcher.addActionProxyListener(n, 0, iActionProxyListener);
    }

    public void removeActionProxyListener(IActionProxyListener iActionProxyListener) {
        this.actionProxyDispatcher.removeActionProxyListener(0, iActionProxyListener);
    }

    public VirtualButtonModelApp getVirtualButtonModel(int n) {
        return Preconditions.checkNotNull(this.hmiService.getVirtualButtonModel(n));
    }

    public ChoiceModelApp getChoiceModel(int n) {
        return Preconditions.checkNotNull(this.hmiService.getChoiceModel(0, n));
    }

    public ButtonModelApp getButtonModel(int n) {
        return Preconditions.checkNotNull(this.hmiService.getButtonModel(n));
    }

    public LabelModelApp getLabelModel(int n) {
        return Preconditions.checkNotNull(this.hmiService.getLabelModel(n));
    }

    public RangeModelApp getRangeModel(int n) {
        return Preconditions.checkNotNull(this.hmiService.getRangeModel(n));
    }

    public void fireEventOnModel(int n) {
        this.framework.getHmiServiceApp().getModelApp(0, n).fireEvent(0);
    }

    public IAudioManager getAudioManager() {
        return (IAudioManager)this.injector.getInstance(class$de$audi$app$terminalmode$audio$IAudioManager == null ? (class$de$audi$app$terminalmode$audio$IAudioManager = TerminalModeContext.class$("de.audi.app.terminalmode.audio.IAudioManager")) : class$de$audi$app$terminalmode$audio$IAudioManager);
    }

    public IDSISmartphoneManager getSmartphoneDSIManager() {
        return (IDSISmartphoneManager)this.injector.getInstance(class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManager == null ? (class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManager = TerminalModeContext.class$("de.audi.app.terminalmode.smartphone.IDSISmartphoneManager")) : class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManager);
    }

    public IDeviceManager getDeviceManager() {
        return (IDeviceManager)this.injector.getInstance(class$de$audi$app$terminalmode$device$DeviceManager == null ? (class$de$audi$app$terminalmode$device$DeviceManager = TerminalModeContext.class$("de.audi.app.terminalmode.device.DeviceManager")) : class$de$audi$app$terminalmode$device$DeviceManager);
    }

    public TMKeyEventsHandler getKeyEventsHandler() {
        return this.keyEventsHandler;
    }

    public TMVirtualButtonListener getTMKeyEventController() {
        return this.virtualButtonListener;
    }

    public ISmartphoneIntegrationDSIController getSMIDSIController() {
        return (ISmartphoneIntegrationDSIController)this.injector.getInstance(class$de$audi$app$terminalmode$dsi$smartphoneintegration$ISmartphoneIntegrationDSIController == null ? (class$de$audi$app$terminalmode$dsi$smartphoneintegration$ISmartphoneIntegrationDSIController = TerminalModeContext.class$("de.audi.app.terminalmode.dsi.smartphoneintegration.ISmartphoneIntegrationDSIController")) : class$de$audi$app$terminalmode$dsi$smartphoneintegration$ISmartphoneIntegrationDSIController);
    }

    public HardKeyDSIListener getHardKeyDSIListener() {
        return (HardKeyDSIListener)this.injector.getInstance(class$de$audi$app$terminalmode$smartphone$HardKeyDSIListener == null ? (class$de$audi$app$terminalmode$smartphone$HardKeyDSIListener = TerminalModeContext.class$("de.audi.app.terminalmode.smartphone.HardKeyDSIListener")) : class$de$audi$app$terminalmode$smartphone$HardKeyDSIListener);
    }

    public ITerminalLogger getLogger() {
        return this.logger;
    }

    public IServiceManager getServiceManager() {
        return this.serviceManager;
    }

    public IFrameworkAccess getFramework() {
        return this.framework;
    }

    public DispatcherBase getDispatcher() {
        return this.dispatcher;
    }

    public ITerminalModeConfiguration getConfiguration() {
        return this.configuration;
    }

    public CommandListManager getCommandListManager() {
        return this.commandListManager;
    }

    public CommandListHelper getCommandListHelper() {
        return this.commandListHelper;
    }

    public IDiagnosisManager getDiagnosisManager() {
        return this.diagnosisManager;
    }

    public PhoneAppHandler getPhoneAppHandler() {
        return (PhoneAppHandler)this.injector.getInstance(class$de$audi$app$terminalmode$PhoneAppHandler == null ? (class$de$audi$app$terminalmode$PhoneAppHandler = TerminalModeContext.class$("de.audi.app.terminalmode.PhoneAppHandler")) : class$de$audi$app$terminalmode$PhoneAppHandler);
    }

    public NaviAppHandler getNaviAppHandler() {
        return (NaviAppHandler)this.injector.getInstance(class$de$audi$app$terminalmode$NaviAppHandler == null ? (class$de$audi$app$terminalmode$NaviAppHandler = TerminalModeContext.class$("de.audi.app.terminalmode.NaviAppHandler")) : class$de$audi$app$terminalmode$NaviAppHandler);
    }

    public INightDayModeHandler getNightDayModeHandler() {
        return (INightDayModeHandler)this.injector.getInstance(class$de$audi$app$terminalmode$INightDayModeHandler == null ? (class$de$audi$app$terminalmode$INightDayModeHandler = TerminalModeContext.class$("de.audi.app.terminalmode.INightDayModeHandler")) : class$de$audi$app$terminalmode$INightDayModeHandler);
    }

    public IEventBus getEventBus() {
        return this.eventBus;
    }

    public IActionProxyDispatcher getActionProxyDispatcher() {
        return this.actionProxyDispatcher;
    }

    public Object get(Class clazz) {
        return this.injector.getInstance(clazz);
    }

    public Object get(Object object, Class clazz) {
        return this.injector.getInstance(object, clazz);
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

