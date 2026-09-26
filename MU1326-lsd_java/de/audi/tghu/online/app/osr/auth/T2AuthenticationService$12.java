/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;

class T2AuthenticationService$12
extends AbstractOSRCommand {
    private final /* synthetic */ T2AuthenticationService this$0;

    T2AuthenticationService$12(T2AuthenticationService t2AuthenticationService) {
        this.this$0 = t2AuthenticationService;
    }

    @Override
    public void execute() {
        this.this$0.modelManager.setRegistrationModelsResult(10);
        this.getCommandList().commandFinished();
    }
}

