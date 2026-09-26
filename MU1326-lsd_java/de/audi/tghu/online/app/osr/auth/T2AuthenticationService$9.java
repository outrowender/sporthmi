/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;

class T2AuthenticationService$9
extends AbstractOSRCommand {
    private final /* synthetic */ T2AuthenticationService this$0;

    T2AuthenticationService$9(T2AuthenticationService t2AuthenticationService) {
        this.this$0 = t2AuthenticationService;
    }

    @Override
    public void execute() {
        int n = ((CommandList)this.getCommandList()).getStatus();
        this.this$0.log.log(10000, "%1#login CommandList execute ErrorCommand. reason: %2", (Object)"T2AuthenticationService", (long)n);
        if (n != 1) {
            int n2 = 10;
            this.this$0.modelManager.updateAuthStatus(n2);
            T2AuthenticationService.access$400(this.this$0, T2AuthenticationService.access$500(this.this$0, n2));
        }
        this.getCommandList().commandAborted("login Command List was aborted");
        this.getCommandList().commandFinished();
    }
}

