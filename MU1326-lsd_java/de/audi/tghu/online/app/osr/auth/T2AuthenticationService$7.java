/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import de.audi.tghu.online.app.osr.command.auth.CheckPasswordCommand$CheckPasswordCommandResponseListener;
import org.dsi.ifc.online.OSRUser;

class T2AuthenticationService$7
implements CheckPasswordCommand$CheckPasswordCommandResponseListener {
    private final /* synthetic */ T2AuthenticationService this$0;

    T2AuthenticationService$7(T2AuthenticationService t2AuthenticationService) {
        this.this$0 = t2AuthenticationService;
    }

    @Override
    public void checkPasswordCommandResponse(OSRUser oSRUser, int n) {
        this.this$0.log.log(1078071040, "%1#checkPasswordCommandResponse response:%2", (Object)"T2AuthenticationService", (long)n);
        this.this$0.modelManager.updateAuthStatus(n);
        int n2 = T2AuthenticationService.access$500(this.this$0, n);
        if (n2 == 3 && this.this$0.modelManager.isCreateNewUser()) {
            n2 = 10;
        }
        T2AuthenticationService.access$400(this.this$0, n2);
        if (n != 0) {
            if (n == 1) {
                this.this$0.modelManager.getChoiceModel(-1407311104).setValue(1);
            }
            this.this$0.modelManager.clearSpellermodel(-82107648);
            this.this$0.modelManager.clearSpellermodel(52175616);
            this.this$0.modelManager.clearTextFieldModel(-920902912);
        }
    }
}

