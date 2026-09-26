/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import de.audi.tghu.online.app.osr.command.auth.PerformPortalRegistrationCommand$PerformPortalRegistrationCommandResponseListener;

class T2AuthenticationService$13
implements PerformPortalRegistrationCommand$PerformPortalRegistrationCommandResponseListener {
    private final /* synthetic */ T2AuthenticationService this$0;

    T2AuthenticationService$13(T2AuthenticationService t2AuthenticationService) {
        this.this$0 = t2AuthenticationService;
    }

    @Override
    public void performPortalRegistrationResponse(String string, int n) {
        this.this$0.modelManager.setRegistrationModelsResult(n);
    }
}

