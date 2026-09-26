/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.mailbox;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.evo.mailbox.TelEvoMailboxHandler;

class TelEvoMailboxHandler$DialMailboxButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ TelEvoMailboxHandler this$0;

    public TelEvoMailboxHandler$DialMailboxButtonListener(TelEvoMailboxHandler telEvoMailboxHandler, ITelApplication iTelApplication) {
        this.this$0 = telEvoMailboxHandler;
        super(iTelApplication, 1989477376);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        TelEvoMailboxHandler.access$000(this.this$0, n3);
    }
}

