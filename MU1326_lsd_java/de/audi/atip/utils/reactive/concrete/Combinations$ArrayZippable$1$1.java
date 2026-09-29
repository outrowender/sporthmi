/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.reactive.concrete.Combinations
 */
package de.audi.atip.utils.reactive.concrete;

import de.audi.atip.utils.reactive.concrete.Combinations;
import de.audi.atip.utils.reactive.concrete.Combinations$ArrayZippable;
import de.audi.atip.utils.reactive.concrete.Combinations$ArrayZippable$1;
import de.audi.atip.utils.reactive.observables.Sink;
import java.util.Arrays;

class Combinations$ArrayZippable$1$1
implements Sink {
    private final /* synthetic */ Sink val$sink;
    private final /* synthetic */ int val$fi;
    private final /* synthetic */ Combinations$ArrayZippable$1 this$1;

    Combinations$ArrayZippable$1$1(Combinations$ArrayZippable$1 combinations$ArrayZippable$1, Sink sink, int n) {
        this.this$1 = combinations$ArrayZippable$1;
        this.val$sink = sink;
        this.val$fi = n;
    }

    @Override
    public void closed() {
        this.val$sink.closed();
    }

    @Override
    public void accept(Object object) {
        Combinations$ArrayZippable.access$1600((Combinations$ArrayZippable)Combinations$ArrayZippable$1.access$1500((Combinations$ArrayZippable$1)this.this$1))[this.val$fi] = object;
        if (Combinations$ArrayZippable.access$1700(Combinations$ArrayZippable$1.access$1500(this.this$1))) {
            this.val$sink.accept(Combinations$ArrayZippable$1.access$1800(this.this$1).combine(Combinations$ArrayZippable.access$1600(Combinations$ArrayZippable$1.access$1500(this.this$1))));
            Arrays.fill(Combinations$ArrayZippable.access$1600(Combinations$ArrayZippable$1.access$1500(this.this$1)), Combinations.access$000());
        }
    }
}

