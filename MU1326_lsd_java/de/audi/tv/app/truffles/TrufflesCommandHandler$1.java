/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.truffles;

import de.audi.tv.app.truffles.TrufflesCommandHandler;
import de.audi.tv.app.truffles.TrufflesCommandHandler$ITrufflesCommand;
import java.util.Comparator;

class TrufflesCommandHandler$1
implements Comparator {
    private final /* synthetic */ TrufflesCommandHandler this$0;

    TrufflesCommandHandler$1(TrufflesCommandHandler trufflesCommandHandler) {
        this.this$0 = trufflesCommandHandler;
    }

    @Override
    public int compare(Object object, Object object2) {
        return ((TrufflesCommandHandler$ITrufflesCommand)object).getPriority() - ((TrufflesCommandHandler$ITrufflesCommand)object2).getPriority();
    }
}

