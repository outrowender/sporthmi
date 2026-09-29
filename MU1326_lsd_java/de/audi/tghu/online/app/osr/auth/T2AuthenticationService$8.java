/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import de.audi.tghu.online.app.osr.command.auth.SetAutoLoginCommand$SetAutoLoginCommandResponseListener;
import org.dsi.ifc.online.OSRUser;

class T2AuthenticationService$8
implements SetAutoLoginCommand$SetAutoLoginCommandResponseListener {
    private final /* synthetic */ T2AuthenticationService this$0;

    T2AuthenticationService$8(T2AuthenticationService t2AuthenticationService) {
        this.this$0 = t2AuthenticationService;
    }

    @Override
    public void setAutoLoginResponse(OSRUser oSRUser, int[] nArray) {
    }
}

