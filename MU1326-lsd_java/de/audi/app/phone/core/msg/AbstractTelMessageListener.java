/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.msg;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.atip.msg.MsgListener;

public abstract class AbstractTelMessageListener
extends AbstractPhoneComponent
implements MsgListener {
    private final int message;

    public AbstractTelMessageListener(ITelApplication iTelApplication, String string, int n) {
        super(iTelApplication, string);
        this.message = n;
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getMessageDispatcher().addMessageListener(this.message, this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getMessageDispatcher().removeMessageListener(this.message, this);
    }

    @Override
    public void processMsg(int n) {
        this.messageReceived();
    }

    protected abstract void messageReceived() {
    }
}

