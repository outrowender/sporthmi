/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.LastmodeHandler;
import de.audi.atip.startup.LastmodeHandler$1;
import de.esolutions.fw.util.commons.Buffer;

class LastmodeHandler$LastmodeAppReached
implements Runnable {
    private final int lmApp;
    private final int terminalID;
    private final /* synthetic */ LastmodeHandler this$0;

    private LastmodeHandler$LastmodeAppReached(LastmodeHandler lastmodeHandler, int n, int n2) {
        this.this$0 = lastmodeHandler;
        this.lmApp = n;
        this.terminalID = n2;
    }

    public final String toString() {
        return new Buffer(50).append("LastmodeAppReached: lastmode: ").append(this.lmApp).toString();
    }

    @Override
    public final void run() {
        if (this.this$0.activateLastmodeApp(this.lmApp, this.terminalID)) {
            LastmodeHandler.access$100(this.this$0).logStartupEvent(this.this$0.logChannel, 1078071040, new StringBuffer().append("LastmodeAppReached#run(").append(this.lmApp).append(", ").append(this.terminalID).append(") - Lastmode App is active!").toString());
            LastmodeHandler.access$100(this.this$0).switchToBackgroundPriority();
        }
    }

    /* synthetic */ LastmodeHandler$LastmodeAppReached(LastmodeHandler lastmodeHandler, int n, int n2, LastmodeHandler$1 lastmodeHandler$1) {
        this(lastmodeHandler, n, n2);
    }
}

