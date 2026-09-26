/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.audio.IAudioManager
 *  de.audi.atip.utils.Preconditions
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

    @Override
    public int getTerminalId() {
        return 0;
    }

    @Override
    public void addActionProxyListener(int n, IActionProxyListener iActionProxyListener) {
        this.actionProxyDispatcher.addActionProxyListener(n, 0, iActionProxyListener);
    }

    @Override
    public void removeActionProxyListener(IActionProxyListener iActionProxyListener) {
        this.actionProxyDispatcher.removeActionProxyListener(0, iActionProxyListener);
    }

    @Override
    public VirtualButtonModelApp getVirtualButtonModel(int n) {
        return (VirtualButtonModelApp)Preconditions.checkNotNull((Object)this.hmiService.getVirtualButtonModel(n));
    }

    @Override
    public ChoiceModelApp getChoiceModel(int n) {
        return (ChoiceModelApp)Preconditions.checkNotNull((Object)this.hmiService.getChoiceModel(0, n));
    }

    @Override
    public ButtonModelApp getButtonModel(int n) {
        return (ButtonModelApp)Preconditions.checkNotNull((Object)this.hmiService.getButtonModel(n));
    }

    @Override
    public LabelModelApp getLabelModel(int n) {
        return (LabelModelApp)Preconditions.checkNotNull((Object)this.hmiService.getLabelModel(n));
    }

    @Override
    public RangeModelApp getRangeModel(int n) {
        return (RangeModelApp)Preconditions.checkNotNull((Object)this.hmiService.getRangeModel(n));
    }

    @Override
    public void fireEventOnModel(int n) {
        this.framework.getHmiServiceApp().getModelApp(0, n).fireEvent(0);
    }

    @Override
    public IAudioManager getAudioManager() {
        return (IAudioManager)this.injector.getInstance(class$de$audi$app$terminalmode$audio$IAudioManager == null ? (class$de$audi$app$terminalmode$audio$IAudioManager = TerminalModeContext.class$("de.audi.app.terminalmode.audio.IAudioManager")) : class$de$audi$app$terminalmode$audio$IAudioManager);
    }

    @Override
    public IDSISmartphoneManager getSmartphoneDSIManager() {
        return (IDSISmartphoneManager)this.injector.getInstance(class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManager == null ? (class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManager = TerminalModeContext.class$("de.audi.app.terminalmode.smartphone.IDSISmartphoneManager")) : class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManager);
    }

    @Override
    public IDeviceManager getDeviceManager() {
        return (IDeviceManager)this.injector.getInstance(class$de$audi$app$terminalmode$device$DeviceManager == null ? (class$de$audi$app$terminalmode$device$DeviceManager = TerminalModeContext.class$("de.audi.app.terminalmode.device.DeviceManager")) : class$de$audi$app$terminalmode$device$DeviceManager);
    }

    @Override
    public TMKeyEventsHandler getKeyEventsHandler() {
        return this.keyEventsHandler;
    }

    @Override
    public TMVirtualButtonListener getTMKeyEventController() {
        return this.virtualButtonListener;
    }

    @Override
    public ISmartphoneIntegrationDSIController getSMIDSIController() {
        return (ISmartphoneIntegrationDSIController)this.injector.getInstance(class$de$audi$app$terminalmode$dsi$smartphoneintegration$ISmartphoneIntegrationDSIController == null ? (class$de$audi$app$terminalmode$dsi$smartphoneintegration$ISmartphoneIntegrationDSIController = TerminalModeContext.class$("de.audi.app.terminalmode.dsi.smartphoneintegration.ISmartphoneIntegrationDSIController")) : class$de$audi$app$terminalmode$dsi$smartphoneintegration$ISmartphoneIntegrationDSIController);
    }

    @Override
    public HardKeyDSIListener getHardKeyDSIListener() {
        return (HardKeyDSIListener)this.injector.getInstance(class$de$audi$app$terminalmode$smartphone$HardKeyDSIListener == null ? (class$de$audi$app$terminalmode$smartphone$HardKeyDSIListener = TerminalModeContext.class$("de.audi.app.terminalmode.smartphone.HardKeyDSIListener")) : class$de$audi$app$terminalmode$smartphone$HardKeyDSIListener);
    }

    @Override
    public ITerminalLogger getLogger() {
        return this.logger;
    }

    @Override
    public IServiceManager getServiceManager() {
        return this.serviceManager;
    }

    @Override
    public IFrameworkAccess getFramework() {
        return this.framework;
    }

    @Override
    public DispatcherBase getDispatcher() {
        return this.dispatcher;
    }

    @Override
    public ITerminalModeConfiguration getConfiguration() {
        return this.configuration;
    }

    @Override
    public CommandListManager getCommandListManager() {
        return this.commandListManager;
    }

    @Override
    public CommandListHelper getCommandListHelper() {
        return this.commandListHelper;
    }

    @Override
    public IDiagnosisManager getDiagnosisManager() {
        return this.diagnosisManager;
    }

    @Override
    public PhoneAppHandler getPhoneAppHandler() {
        return (PhoneAppHandler)this.injector.getInstance(class$de$audi$app$terminalmode$PhoneAppHandler == null ? (class$de$audi$app$terminalmode$PhoneAppHandler = TerminalModeContext.class$("de.audi.app.terminalmode.PhoneAppHandler")) : class$de$audi$app$terminalmode$PhoneAppHandler);
    }

    @Override
    public NaviAppHandler getNaviAppHandler() {
        return (NaviAppHandler)this.injector.getInstance(class$de$audi$app$terminalmode$NaviAppHandler == null ? (class$de$audi$app$terminalmode$NaviAppHandler = TerminalModeContext.class$("de.audi.app.terminalmode.NaviAppHandler")) : class$de$audi$app$terminalmode$NaviAppHandler);
    }

    @Override
    public INightDayModeHandler getNightDayModeHandler() {
        return (INightDayModeHandler)this.injector.getInstance(class$de$audi$app$terminalmode$INightDayModeHandler == null ? (class$de$audi$app$terminalmode$INightDayModeHandler = TerminalModeContext.class$("de.audi.app.terminalmode.INightDayModeHandler")) : class$de$audi$app$terminalmode$INightDayModeHandler);
    }

    @Override
    public IEventBus getEventBus() {
        return this.eventBus;
    }

    @Override
    public IActionProxyDispatcher getActionProxyDispatcher() {
        return this.actionProxyDispatcher;
    }

    @Override
    public Object get(Class clazz) {
        return this.injector.getInstance(clazz);
    }

    @Override
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

