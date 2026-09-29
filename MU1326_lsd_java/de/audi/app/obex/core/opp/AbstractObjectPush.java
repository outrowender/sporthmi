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

    @Override
    public void updateOPPIncomingObject(String string, String string2, int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.log.log(1078071040, "AbstractObjectPush#updateOPPIncomingObject(): name=%1, address=%2, type=%3", (Object)string2, (Object)string, (Object)String.valueOf(n));
        boolean bl = this.isTrustedDevice(string) && (n == 0 || n == 4);
        this.log.log(1078071040, "AbstractObjectPush#updateOPPIncomingObject(): accept=%1", bl);
        this.dsi.requestOPPAcceptObject(string, bl);
    }

    protected abstract boolean isTrustedDevice(String string) {
    }

    @Override
    public void updateVCardsReceived(String string, int n) {
    }

    @Override
    public void responseOPPAbortSending(int n) {
    }

    @Override
    public void responseOPPAcceptObject(int n) {
    }

    @Override
    public void responseOPPSendContacts(int n) {
    }

    @Override
    public void responseOPPSendMessages(int n) {
    }

    @Override
    public void responseOPPSendBinary(int n) {
    }
}

