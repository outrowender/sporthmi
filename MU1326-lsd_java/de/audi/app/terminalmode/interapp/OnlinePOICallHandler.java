/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.interapp;

import de.audi.app.terminalmode.CommandListHelper;
import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.interapp.OnlinePOICallHandler$1;
import de.audi.app.terminalmode.interapp.OnlinePOICallHandler$2;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.atip.interapp.online.OnlinePOICall;
import de.audi.atip.log.LogChannel;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class OnlinePOICallHandler
implements ITerminalModeComponent,
OnlinePOICall {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final IServiceManager serviceManager;
    private final CommandListHelper commandListHelper;
    private final IStateHandler stateHandler;
    private final IContext context;
    private volatile ServiceRegistration registeredService;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$OnlinePOICall;

    public OnlinePOICallHandler(LogChannel logChannel, IServiceManager iServiceManager, CommandListHelper commandListHelper, IStateHandler iStateHandler, IContext iContext) {
        this.logger = logChannel;
        this.serviceManager = iServiceManager;
        this.commandListHelper = commandListHelper;
        this.stateHandler = iStateHandler;
        this.context = iContext;
        this.context.getDiagnosisManager().addCommandProvider(-1, new OnlinePOICallHandler$1(this));
    }

    @Override
    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"OnlinePOICallHandler");
        this.registeredService = this.serviceManager.registerService(class$de$audi$atip$interapp$online$OnlinePOICall == null ? (class$de$audi$atip$interapp$online$OnlinePOICall = OnlinePOICallHandler.class$("de.audi.atip.interapp.online.OnlinePOICall")) : class$de$audi$atip$interapp$online$OnlinePOICall, this, new Hashtable(0));
    }

    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"OnlinePOICallHandler");
        this.serviceManager.unregisterService(this.registeredService);
    }

    @Override
    public void updatePOICall(boolean bl) {
        this.logger.log(1078071040, "[%1.updatePOICall] poiCallActive=%2", (Object)"OnlinePOICallHandler", (Object)Boolean.toString(bl));
        this.commandListHelper.create().addSingle(new OnlinePOICallHandler$2(this, this.logger, new StringBuffer().append("OnlinePOICallHandler$").append(bl ? "Acquire" : "Release").append(" AudioPhone").toString(), this.context, bl)).execute("OnlinePOICallHandler.updatePOICall");
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IStateHandler access$000(OnlinePOICallHandler onlinePOICallHandler) {
        return onlinePOICallHandler.stateHandler;
    }

    static /* synthetic */ LogChannel access$100(OnlinePOICallHandler onlinePOICallHandler) {
        return onlinePOICallHandler.logger;
    }
}

