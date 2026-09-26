/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.concrete;

import de.audi.atip.utils.reactive.concrete.Combinations$2$1$3$3$3;
import de.audi.atip.utils.reactive.concrete.Combinations$UnsafeCombinator;
import de.audi.atip.utils.reactive.observables.Observables$Consumer5;
import java.util.Iterator;

class Combinations$2$1$3$3$3$2
implements Combinations$UnsafeCombinator {
    private final /* synthetic */ Observables$Consumer5 val$consumer;
    private final /* synthetic */ Combinations$2$1$3$3$3 this$4;

    Combinations$2$1$3$3$3$2(Combinations$2$1$3$3$3 combinations$2$1$3$3$3, Observables$Consumer5 consumer5) {
        this.this$4 = combinations$2$1$3$3$3;
        this.val$consumer = consumer5;
    }

    @Override
    public Void combine(Iterator iterator) {
        this.val$consumer.accept(iterator.next(), iterator.next(), iterator.next(), iterator.next(), iterator.next());
        return null;
    }

    @Override
    public /* synthetic */ Object combine(Iterator iterator) {
        return this.combine(iterator);
    }
}

