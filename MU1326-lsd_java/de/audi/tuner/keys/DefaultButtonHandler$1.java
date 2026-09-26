/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.keys;

import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.keys.DefaultButtonHandler;

class DefaultButtonHandler$1
implements IPrevNext {
    private final /* synthetic */ DefaultButtonHandler this$0;

    DefaultButtonHandler$1(DefaultButtonHandler defaultButtonHandler) {
        this.this$0 = defaultButtonHandler;
    }

    @Override
    public void handlePrevNext(boolean bl) {
        throw new IllegalArgumentException("no handler registered");
    }
}

