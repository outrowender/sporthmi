/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.reactive.concrete.Combinations$2$1$3
 */
package de.audi.atip.utils.reactive.concrete;

import de.audi.atip.utils.reactive.concrete.Combinations$2$1;
import de.audi.atip.utils.reactive.concrete.Combinations$UnsafeCombinator;
import de.audi.atip.utils.reactive.observables.Observables$Consumer3;
import java.util.Iterator;

class Combinations$2$1$3$2
implements Combinations$UnsafeCombinator {
    private final /* synthetic */ Observables$Consumer3 val$consumer;
    private final /* synthetic */ Combinations$2$1.3 this$2;

    Combinations$2$1$3$2(Combinations$2$1.3 var1_1, Observables$Consumer3 observables$Consumer3) {
        this.this$2 = var1_1;
        this.val$consumer = observables$Consumer3;
    }

    @Override
    public Void combine(Iterator iterator) {
        this.val$consumer.accept(iterator.next(), iterator.next(), iterator.next());
        return null;
    }

    @Override
    public /* synthetic */ Object combine(Iterator iterator) {
        return this.combine(iterator);
    }
}

