/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer;

import de.audi.tghu.swdl.app.customer.AbstractDriverResetHandler;

class AbstractDriverResetHandler$1
implements Runnable {
    private final /* synthetic */ int val$terminalID;
    private final /* synthetic */ AbstractDriverResetHandler this$0;

    AbstractDriverResetHandler$1(AbstractDriverResetHandler abstractDriverResetHandler, int n) {
        this.this$0 = abstractDriverResetHandler;
        this.val$terminalID = n;
    }

    @Override
    public void run() {
        this.this$0.doResetDriver(this.val$terminalID);
    }
}

