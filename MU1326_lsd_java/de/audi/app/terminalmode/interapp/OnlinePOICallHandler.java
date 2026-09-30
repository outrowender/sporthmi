/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.interapp;

import de.audi.app.terminalmode.CommandListHelper;
import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.atip.interapp.online.OnlinePOICall;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.reactive.properties.Property;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class OnlinePOICallHandler
implements ITerminalModeComponent,
OnlinePOICall {
    private static final String LOGCLASS = "OnlinePOICallHandler";
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
        this.context.getDiagnosisManager().addCommandProvider(-1, new IDiagnosisCommandProvider(){

            public String[] getDiagKeys() {
                return new String[]{"onlinePoiCallActive(active)"};
            }

            public void executeDiagCommand(String string, String[] stringArray) {
                if (Boolean.valueOf(stringArray[0]).booleanValue()) {
                    OnlinePOICallHandler.this.updatePOICall(true);
                } else {
                    OnlinePOICallHandler.this.updatePOICall(false);
                }
            }
        });
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.registeredService = this.serviceManager.registerService(class$de$audi$atip$interapp$online$OnlinePOICall == null ? (class$de$audi$atip$interapp$online$OnlinePOICall = OnlinePOICallHandler.class$("de.audi.atip.interapp.online.OnlinePOICall")) : class$de$audi$atip$interapp$online$OnlinePOICall, this, new Hashtable(0));
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.serviceManager.unregisterService(this.registeredService);
    }

    public void updatePOICall(final boolean bl) {
        this.logger.log(1000000, "[%1.updatePOICall] poiCallActive=%2", (Object)LOGCLASS, (Object)Boolean.toString(bl));
        this.commandListHelper.create().addSingle(new AbstractCommand(this.logger, new StringBuffer().append("OnlinePOICallHandler$").append(bl ? "Acquire" : "Release").append(" AudioPhone").toString(), this.context){

            public void execute() {
                TMState tMState = OnlinePOICallHandler.this.stateHandler.getCurrentState();
                Property<Boolean> property = this.context.getSmartphoneDSIManager().getSmartphoneProperties().getPropertyMUPhonecallActive();
                if (null == property) {
                    OnlinePOICallHandler.this.logger.log(100000, "[%1.execute] property is null", (Object)OnlinePOICallHandler.LOGCLASS);
                } else {
                    property.accept(new Boolean(bl));
                    tMState.setAccessRestricted(Resource.AUDIO_MEDIA, bl);
                    OnlinePOICallHandler.this.stateHandler.updateState(tMState);
                }
                this.getCommandList().commandFinished();
            }
        }).execute("OnlinePOICallHandler.updatePOICall");
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

