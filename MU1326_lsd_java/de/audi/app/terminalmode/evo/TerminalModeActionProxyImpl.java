/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.evo;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.actionproxy.IActionProxyDispatcher;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.ap.TerminalModeActionProxy;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class TerminalModeActionProxyImpl
implements TerminalModeActionProxy,
ITerminalModeComponent {
    private static final String LOGCLASS = "TerminalModeActionProxyImpl";
    private static final Hashtable EMPTY_HASHTABLE = new Hashtable(0);
    private final LogChannel logger;
    private final IServiceManager serviceManager;
    private final IActionProxyDispatcher actionProxyDispatcher;
    private ServiceRegistration apServiceRegistration;
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;

    public TerminalModeActionProxyImpl(IContext iContext) {
        this.logger = iContext.getActionProxyDispatcher().getLogChannel();
        this.serviceManager = iContext.getServiceManager();
        this.actionProxyDispatcher = iContext.getActionProxyDispatcher();
    }

    public void init() {
        this.logger.log(100000000, "[%1.init]", (Object)LOGCLASS);
        Hashtable hashtable = new Hashtable(3);
        hashtable.put("moduleID", new Integer(28));
        hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
        this.apServiceRegistration = this.serviceManager.registerService(class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = TerminalModeActionProxyImpl.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy, this, hashtable);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        if (this.apServiceRegistration != null) {
            this.apServiceRegistration.unregister();
        }
    }

    public void hmiActivatedTerminalMode(int n) {
        this.logger.log(1000000, "[%1.hmiActivatedTerminalMode]", (Object)LOGCLASS);
        this.actionProxyDispatcher.notifyActionProxyCall(1001, n, new Hashtable(0));
    }

    public void hmiDeactivatedTerminalMode(int n) {
        this.logger.log(1000000, "[%1.hmiDeactivatedTerminalMode]", (Object)LOGCLASS);
        this.actionProxyDispatcher.notifyActionProxyCall(1002, n, new Hashtable(0));
    }

    public void resetNewDeviceDetection(int n) {
        this.logger.log(1000000, "[%1.resetNewDeviceDetection]", (Object)LOGCLASS);
        this.actionProxyDispatcher.notifyActionProxyCall(1003, n, new Hashtable(0));
    }

    public void parkingActivatedTerminalMode(int n) {
        this.logger.log(1000000, "[%1.parkingActivatedTerminalMode]", (Object)LOGCLASS);
        this.actionProxyDispatcher.notifyActionProxyCall(1004, n, EMPTY_HASHTABLE);
    }

    public void parkingDeactivatedTerminalMode(int n) {
        this.logger.log(1000000, "[%1.parkingDeactivatedTerminalMode]", (Object)LOGCLASS);
        this.actionProxyDispatcher.notifyActionProxyCall(1005, n, EMPTY_HASHTABLE);
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

