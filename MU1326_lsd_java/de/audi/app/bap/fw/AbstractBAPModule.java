/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.app.AbstractAppConnector;
import de.audi.app.bap.fw.AbstractBAPModuleServiceManager;
import de.audi.app.bap.fw.AbstractFunctionList;
import de.audi.app.bap.fw.IBAPFunctionFactory;
import de.audi.app.bap.fw.IBAPModuleInitializationManager;
import de.audi.app.bap.fw.arrays.IListManager;
import de.audi.app.bap.fw.functiontypes.IBAPFunction;
import de.audi.app.bap.fw.indication.IBAPIndicationListener;
import de.audi.app.bap.fw.request.DataTypeMapping;
import de.audi.app.bap.fw.request.IBAPRequestHandler;
import de.audi.app.bap.fw.request.IDataTypeMapping;
import de.audi.app.bap.test.BAPOSDDataProvider;
import de.audi.app.bap.utils.ErrorCodes;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.bap.utils.IBAPLogger;
import de.audi.app.bap.utils.IErrorCodes;
import de.audi.app.bap.utils.IFunctionIDs;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.interapp.bap.BAPService;
import de.audi.atip.interapp.bap.BAPServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.testsupport.OSDActivator;
import java.util.HashMap;
import java.util.Map;
import org.osgi.framework.BundleContext;

public abstract class AbstractBAPModule {
    protected final LogChannel logChannel;
    private final int lsgID;
    protected AbstractBAPApplication bapApplication;
    private final IBAPFunctionFactory bapFunctionFactory;
    protected IBAPModuleInitializationManager initializationManager;
    protected AbstractBAPModuleServiceManager serviceManager;
    private final Map appConnectors = new HashMap();
    protected IListManager listManager;
    private final OSDActivator osdActivator;
    static /* synthetic */ Class class$de$audi$atip$base$ComponentStateListener;

    public AbstractBAPModule(int n, AbstractBAPApplication abstractBAPApplication) {
        this(n, abstractBAPApplication, null);
    }

    public AbstractBAPModule(int n, AbstractBAPApplication abstractBAPApplication, IBAPFunctionFactory iBAPFunctionFactory) {
        this.lsgID = n;
        this.bapApplication = abstractBAPApplication;
        this.logChannel = abstractBAPApplication.getLogger().getLog(n);
        this.osdActivator = new OSDActivator(new BAPOSDDataProvider(this), true);
        LSGIDs.registerLSGID(n, this.getLSGDescription());
        FunctionIDs.registerFunctionIDs(n, this.getFunctionIDs());
        ErrorCodes.registerErrorCodes(n, this.getErrorIDs());
        DataTypeMapping.registerDataTypeMapping(n, this.getDataTypeMapping());
        this.bapFunctionFactory = iBAPFunctionFactory != null ? iBAPFunctionFactory : this.createBAPFunctionFactory();
        this.initModuleComponents();
        if (this.initializationManager == null) {
            this.logChannel.log(10000, "[AbstractBAPModule#AbstractBAPModule] module with LSD ID: %1 did not initialize itself correctly: initializationManager is null.", (long)this.lsgID);
        }
    }

    protected abstract IBAPFunctionFactory createBAPFunctionFactory();

    protected IBAPFunctionFactory getBapFunctionFactory() {
        return this.bapFunctionFactory;
    }

    protected abstract void initModuleComponents();

    protected abstract void initServiceManager(BundleContext var1);

    protected void setInitialValues() {
    }

    public IBAPLogger getLogger() {
        return this.bapApplication.getLogger();
    }

    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    public int getLSGID() {
        return this.lsgID;
    }

    protected abstract String getLSGDescription();

    protected abstract IFunctionIDs getFunctionIDs();

    protected abstract IErrorCodes getErrorIDs();

    public abstract int[] getErrorMapping();

    protected abstract IDataTypeMapping getDataTypeMapping();

    public IFrameworkAccess getFrameworkAccess() {
        return this.bapApplication.getFrameworkAccess();
    }

    public abstract AbstractFunctionList getFunctionList();

    public abstract IBAPIndicationListener getIndicationListener();

    public void setRequestHandler(IBAPRequestHandler iBAPRequestHandler) {
        if (this.bapApplication != null) {
            this.bapApplication.setRequestHandler(iBAPRequestHandler);
        }
    }

    public IBAPRequestHandler getRequestHandler() {
        return this.bapApplication == null ? null : this.bapApplication.getRequestHandler();
    }

    public void setInitializationManager(IBAPModuleInitializationManager iBAPModuleInitializationManager) {
        this.initializationManager = iBAPModuleInitializationManager;
    }

    public IBAPModuleInitializationManager getInitializationManager() {
        return this.initializationManager;
    }

    public IListManager getListManager() {
        return this.listManager;
    }

    public abstract IBAPFunction getBAPFunction(int var1);

    protected abstract void initDiagnosisConnector();

    protected void addAppConnector(String string, AbstractAppConnector abstractAppConnector) {
        this.appConnectors.put(string, abstractAppConnector);
    }

    public BAPService getAppService(String string) {
        return (BAPService)this.appConnectors.get(string);
    }

    public BAPServiceListener getAppServiceListener(String string) {
        return ((AbstractAppConnector)this.appConnectors.get(string)).getAppServiceListener();
    }

    public void setAppServiceListener(String string, BAPServiceListener bAPServiceListener) {
        ((AbstractAppConnector)this.appConnectors.get(string)).setAppServiceListener(bAPServiceListener);
    }

    public Map getAppConnectors() {
        return this.appConnectors;
    }

    public void activate(AbstractActivator abstractActivator) {
        this.initServiceManager(abstractActivator.getBundleContext());
        if (this.serviceManager == null) {
            this.logChannel.log(10000, "[AbstractBAPModule#activate] module with LSD ID: %1 did not initialize itself correctly: serviceManager is null.", (long)this.lsgID);
            return;
        }
        this.serviceManager.registerServices(abstractActivator);
        this.serviceManager.trackServices();
        abstractActivator.registerService((class$de$audi$atip$base$ComponentStateListener == null ? (class$de$audi$atip$base$ComponentStateListener = AbstractBAPModule.class$("de.audi.atip.base.ComponentStateListener")) : class$de$audi$atip$base$ComponentStateListener).getName(), (Object)this.initializationManager, null);
        this.osdActivator.start(abstractActivator.getBundleContext());
        if (this.listManager != null) {
            this.listManager.init(abstractActivator.getBundleContext());
        }
        this.logChannel.log(10000000, "[AbstractBAPModule#activate] module has been activated (lsgID=%1)", (Object)LSGIDs.getDescription(this.lsgID));
    }

    public abstract void resetBAPFunctions();

    public void deactivate() {
        this.serviceManager.closeTracker();
        this.osdActivator.stop(null);
        this.logChannel.log(10000000, "[AbstractBAPModule#activate] module has been deactivated (lsgID=%1)", (Object)LSGIDs.getDescription(this.lsgID));
    }

    public void destroy() {
        this.bapApplication = null;
        if (this.initializationManager != null) {
            this.initializationManager = null;
        }
        this.serviceManager = null;
    }

    public void notifyPowerStateChanged() {
        this.logChannel.log(10000000, "[AbstractBAPModule#notifyPowerStateChanged] called -> update operation state %1", (Object)LSGIDs.getDescription(this.lsgID));
        this.initializationManager.updateOperationState();
    }

    public void notifyPowerTriggerAction() {
        this.logChannel.log(10000000, "[AbstractBAPModule#notifyPowerTriggerAction] called -> update operation state %1", (Object)LSGIDs.getDescription(this.lsgID));
        this.initializationManager.updateOperationState();
    }

    protected abstract AbstractSwDiagnosis getDiagnosisGateway(boolean var1);

    public boolean isErrorHandled(int n) {
        return false;
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

