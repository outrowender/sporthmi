/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.concrete;

import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.concrete.Combinations$ArrayZippable$1;
import de.audi.atip.utils.reactive.concrete.Combinations$ArrayZippable$1$2$1;
import de.audi.atip.utils.reactive.observables.BackChannel;

class Combinations$ArrayZippable$1$2
implements BackChannel {
    private final /* synthetic */ Combinations$ArrayZippable$1 this$1;

    Combinations$ArrayZippable$1$2(Combinations$ArrayZippable$1 combinations$ArrayZippable$1) {
        this.this$1 = combinations$ArrayZippable$1;
    }

    @Override
    public void disconnect() {
        Combinations$ArrayZippable$1.access$1900(this.this$1).fluent().forEach((Consumer)new Combinations$ArrayZippable$1$2$1(this));
    }
}

