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

    protected void showPopup() {
        this.log.log(1000000, "Authentication#showPopup(): Showing OBEX authentication popup");
        this.application.getFramework().getHMIService().showPopup(2500005);
    }
}

