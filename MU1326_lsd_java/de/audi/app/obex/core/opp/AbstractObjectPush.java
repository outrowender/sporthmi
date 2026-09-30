/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.obex.core.opp;

import de.audi.app.obex.core.AbstractObjectPushComponent;
import de.audi.app.obex.core.IObexApplication;

public abstract class AbstractObjectPush
extends AbstractObjectPushComponent {
    public AbstractObjectPush(IObexApplication iObexApplication) {
        super(iObexApplication);
    }

    public void updateOPPIncomingObject(String string, String string2, int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.log.log(1000000, "AbstractObjectPush#updateOPPIncomingObject(): name=%1, address=%2, type=%3", (Object)string2, (Object)string, (Object)String.valueOf(n));
        boolean bl = this.isTrustedDevice(string) && (n == 0 || n == 4);
        this.log.log(1000000, "AbstractObjectPush#updateOPPIncomingObject(): accept=%1", bl);
        this.dsi.requestOPPAcceptObject(string, bl);
    }

    protected abstract boolean isTrustedDevice(String var1);

    public void updateVCardsReceived(String string, int n) {
    }

    public void responseOPPAbortSending(int n) {
    }

    public void responseOPPAcceptObject(int n) {
    }

    public void responseOPPSendContacts(int n) {
    }

    public void responseOPPSendMessages(int n) {
    }

    public void responseOPPSendBinary(int n) {
    }
}

