/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.RetryWatchdog$ErrorMethod;

class BAPFunctionArrayASG$1
implements RetryWatchdog$ErrorMethod {
    private final /* synthetic */ BAPFunctionArrayASG this$0;

    BAPFunctionArrayASG$1(BAPFunctionArrayASG bAPFunctionArrayASG) {
        this.this$0 = bAPFunctionArrayASG;
    }

    @Override
    public void error() {
        BAPFunctionArrayASG.access$000(this.this$0);
    }
}

