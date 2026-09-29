/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.obex.authentication;

import de.audi.app.obex.core.IObexApplication;
import de.audi.app.obex.core.authentication.AbstractAuthentication;

public class Authentication
extends AbstractAuthentication {
    public Authentication(IObexApplication iObexApplication) {
        super(iObexApplication);
    }

    @Override
    protected void showPopup() {
        this.log.log(1078071040, "Authentication#showPopup(): Showing OBEX authentication popup");
        this.application.getFramework().getHMIService().showPopup(-1524292096);
    }
}

