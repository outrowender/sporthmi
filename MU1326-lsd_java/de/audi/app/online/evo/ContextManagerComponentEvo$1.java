/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.ContextManagerComponentEvo;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.util.LogAppender;
import de.audi.remotehmi.util.LogAppender$Factory;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class ContextManagerComponentEvo$1
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ RemoteHMIService val$remoteHmiService;
    private final /* synthetic */ ContextManagerComponentEvo this$0;

    ContextManagerComponentEvo$1(ContextManagerComponentEvo contextManagerComponentEvo, String string, LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.this$0 = contextManagerComponentEvo;
        this.val$logChannel = logChannel;
        this.val$remoteHmiService = remoteHMIService;
        super(string);
    }

    @Override
    protected LogAppender getParamsForDebugging(Object object) {
        return LogAppender$Factory.fromString((String)object);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        String string;
        if (!(object instanceof String)) {
            this.val$logChannel.log(10000, "ContextManagerComponent#indicateCommand#INTERPRETER_RESUMPTION_FAILED: wrong payload provided");
            return;
        }
        if (ContextManagerComponentEvo.access$000(this.this$0) == null) {
            this.val$logChannel.log(10000, "ContextManagerComponent#indicateCommand#INTERPRETER_RESUMPTION_FAILED: current entry point is null");
            return;
        }
        if (ContextManagerComponentEvo.access$100(this.this$0).getEntryPointId() != 1) {
            this.val$logChannel.log(1078071040, "ContextManagerComponent#indicateCommand#INTERPRETER_RESUMPTION_FAILED: current entry point is not audiconnect");
            return;
        }
        String string2 = (String)object;
        RemoteHMIContext remoteHMIContext = ContextManagerComponentEvo.access$200(this.this$0).getCurrentContext();
        String string3 = string = remoteHMIContext == null ? "" : remoteHMIContext.getContextName();
        if (string2.equals(ContextManagerComponentEvo.access$300(this.this$0).getNameOfContextToBeStarted()) || string2.equals(string)) {
            this.val$logChannel.log(1078071040, "ContextManagerComponent#indicateCommand#INTERPRETER_RESUMPTION_FAILED: context '%1' couldn't be started on south side so restoring top wizard for Audiconnect", (Object)string2);
            ContextManagerComponentEvo.access$400(this.this$0).setCurrentContext(this.this$0.addContext("top_wizard", 1));
            ContextManagerComponentEvo.access$500(this.this$0).setNameOfContextToBeStarted("top_wizard");
            this.val$remoteHmiService.configureRemoteHMIContext();
        }
    }
}

