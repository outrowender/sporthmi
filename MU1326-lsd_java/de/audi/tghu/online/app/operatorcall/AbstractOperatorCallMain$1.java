/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall;

import de.audi.atip.interapp.online.IOperatorCallSDSServiceListener;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;

class AbstractOperatorCallMain$1
implements IOperatorCallSDSServiceListener {
    private final /* synthetic */ AbstractOperatorCallMain this$0;

    AbstractOperatorCallMain$1(AbstractOperatorCallMain abstractOperatorCallMain) {
        this.this$0 = abstractOperatorCallMain;
    }

    @Override
    public void startCallcenterCallBySDSResult(int n) {
        this.this$0.logChannel.log(1078071040, "AbstractOperatorCallMain#testSDS#startCallcenterCallBySDSResult: result = %1", (long)n);
    }
}

