/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.concrete;

import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.concrete.Combinations$ArrayZippable$1$2;
import de.audi.atip.utils.reactive.observables.Subscription;

class Combinations$ArrayZippable$1$2$1
implements Consumer {
    private final /* synthetic */ Combinations$ArrayZippable$1$2 this$2;

    Combinations$ArrayZippable$1$2$1(Combinations$ArrayZippable$1$2 combinations$ArrayZippable$1$2) {
        this.this$2 = combinations$ArrayZippable$1$2;
    }

    public void accept(Subscription subscription) {
        subscription.cancel();
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((Subscription)object);
    }
}

