/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.callstacks;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.callstacks.AbstractCallStackHandler;
import de.audi.app.phone.core.msg.AbstractTelMessageListener;

class AbstractCallStackHandler$UnitsChangedListener
extends AbstractTelMessageListener {
    private final /* synthetic */ AbstractCallStackHandler this$0;

    public AbstractCallStackHandler$UnitsChangedListener(AbstractCallStackHandler abstractCallStackHandler, ITelApplication iTelApplication) {
        this.this$0 = abstractCallStackHandler;
        super(iTelApplication, "App.Phone.Main", 11);
    }

    @Override
    protected void messageReceived() {
        this.log.log(1078071040, "[AbstractCallStackHandler.UnitsChangedListener#messageRecieved] refreshing call stack list.");
        this.this$0.updateCallStackEntries();
    }
}

