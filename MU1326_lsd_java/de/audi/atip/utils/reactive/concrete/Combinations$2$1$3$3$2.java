/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.concrete;

import de.audi.atip.utils.reactive.concrete.Combinations$2$1$3$3;
import de.audi.atip.utils.reactive.concrete.Combinations$UnsafeCombinator;
import de.audi.atip.utils.reactive.observables.Observables$Consumer4;
import java.util.Iterator;

class Combinations$2$1$3$3$2
implements Combinations$UnsafeCombinator {
    private final /* synthetic */ Observables$Consumer4 val$consumer;
    private final /* synthetic */ Combinations$2$1$3$3 this$3;

    Combinations$2$1$3$3$2(Combinations$2$1$3$3 combinations$2$1$3$3, Observables$Consumer4 observables$Consumer4) {
        this.this$3 = combinations$2$1$3$3;
        this.val$consumer = observables$Consumer4;
    }

    @Override
    public Void combine(Iterator iterator) {
        this.val$consumer.accept(iterator.next(), iterator.next(), iterator.next(), iterator.next());
        return null;
    }

    @Override
    public /* synthetic */ Object combine(Iterator iterator) {
        return this.combine(iterator);
    }
}

