/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.concrete;

import de.audi.atip.utils.reactive.concrete.Combinations$2$1;
import de.audi.atip.utils.reactive.concrete.Combinations$UnsafeCombinator;
import de.audi.atip.utils.reactive.observables.Observables$Consumer2;
import java.util.Iterator;

class Combinations$2$1$2
implements Combinations$UnsafeCombinator {
    private final /* synthetic */ Observables$Consumer2 val$consumer;
    private final /* synthetic */ Combinations$2$1 this$1;

    Combinations$2$1$2(Combinations$2$1 combinations$2$1, Observables$Consumer2 observables$Consumer2) {
        this.this$1 = combinations$2$1;
        this.val$consumer = observables$Consumer2;
    }

    @Override
    public Void combine(Iterator iterator) {
        this.val$consumer.accept(iterator.next(), iterator.next());
        return null;
    }

    @Override
    public /* synthetic */ Object combine(Iterator iterator) {
        return this.combine(iterator);
    }
}

