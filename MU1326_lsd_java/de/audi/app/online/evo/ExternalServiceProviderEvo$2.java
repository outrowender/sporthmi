/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.ExternalServiceProviderEvo;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.ui.mib2.Commands$MiniAppStatusPayload;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;
import de.audi.tghu.online.app.remotehmi.EntryPoint;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class ExternalServiceProviderEvo$2
extends AbstractCommandHandler {
    private final /* synthetic */ RemoteHMIService val$remoteHmiService;
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ ExternalServiceProviderEvo this$0;

    ExternalServiceProviderEvo$2(ExternalServiceProviderEvo externalServiceProviderEvo, String string, RemoteHMIService remoteHMIService, LogChannel logChannel) {
        this.this$0 = externalServiceProviderEvo;
        this.val$remoteHmiService = remoteHMIService;
        this.val$logChannel = logChannel;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        Commands$MiniAppStatusPayload commands$MiniAppStatusPayload = (Commands$MiniAppStatusPayload)object;
        String string = commands$MiniAppStatusPayload.getContextName();
        String string2 = commands$MiniAppStatusPayload.hostingContext;
        ContextManagerComponent contextManagerComponent = this.val$remoteHmiService.getContextManagerComponent();
        this.val$logChannel.log(1078071040, "ExternalServiceProviderEvo#indicateCommand: Commands.STATE_APP_START_ERROR received for app '%1'.", (Object)string);
        if (string2.equals("media") && !contextManagerComponent.isCurrentEntrypointMedia()) {
            ExternalServiceProviderEvo.access$002(this.this$0, 1);
            ExternalServiceProviderEvo.access$102(this.this$0, string);
            return;
        }
        EntryPoint entryPoint = contextManagerComponent.getCurrentEntryPoint();
        String string3 = entryPoint.getNameOfContextToBeStarted();
        if (string3 != null && string3.equals(string)) {
            contextManagerComponent.setWaitForApplicationValue(2);
            entryPoint.setNameOfContextToBeStarted(null);
        }
    }
}

