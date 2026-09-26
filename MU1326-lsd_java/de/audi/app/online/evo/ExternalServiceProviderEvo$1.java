/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.ExternalServiceProviderEvo;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.ui.mib2.Commands$MiniAppStatusPayload;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;

class ExternalServiceProviderEvo$1
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ ExternalServiceProviderEvo this$0;

    ExternalServiceProviderEvo$1(ExternalServiceProviderEvo externalServiceProviderEvo, String string, LogChannel logChannel) {
        this.this$0 = externalServiceProviderEvo;
        this.val$logChannel = logChannel;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        Commands$MiniAppStatusPayload commands$MiniAppStatusPayload = (Commands$MiniAppStatusPayload)object;
        String string = commands$MiniAppStatusPayload.getContextName();
        String string2 = commands$MiniAppStatusPayload.hostingContext;
        this.val$logChannel.log(1078071040, "ExternalServiceProviderEvo#indicateCommand: Commands.STATE_APP_START_SUCCESS received for app '%1' with hostingContext '%2'", (Object)string, (Object)string2);
    }
}

