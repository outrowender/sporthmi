/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.reactive.concrete.Combinations$ArrayCombinable
 */
package de.audi.atip.utils.reactive.concrete;

import de.audi.atip.utils.reactive.concrete.Combinations;
import de.audi.atip.utils.reactive.concrete.Combinations$ArrayCombinable$1;
import de.audi.atip.utils.reactive.observables.Sink;

class Combinations$ArrayCombinable$1$1
implements Sink {
    private final /* synthetic */ Sink val$sink;
    private final /* synthetic */ int val$fi;
    private final /* synthetic */ Combinations$ArrayCombinable$1 this$1;

    Combinations$ArrayCombinable$1$1(Combinations$ArrayCombinable$1 combinations$ArrayCombinable$1, Sink sink, int n) {
        this.this$1 = combinations$ArrayCombinable$1;
        this.val$sink = sink;
        this.val$fi = n;
    }

    @Override
    public void closed() {
        this.val$sink.closed();
    }

    @Override
    public void accept(Object object) {
        Combinations.ArrayCombinable.access$300((Combinations.ArrayCombinable)Combinations$ArrayCombinable$1.access$200(this.this$1)).set(this.val$fi, object);
        if (((Boolean)Combinations.ArrayCombinable.access$400((Combinations.ArrayCombinable)Combinations$ArrayCombinable$1.access$200(this.this$1)).get(this.val$fi)).booleanValue() && (Combinations.ArrayCombinable.access$500((Combinations.ArrayCombinable)Combinations$ArrayCombinable$1.access$200(this.this$1)) || Combinations.ArrayCombinable.access$600((Combinations.ArrayCombinable)Combinations$ArrayCombinable$1.access$200(this.this$1)))) {
            this.val$sink.accept(Combinations$ArrayCombinable$1.access$700(this.this$1).combine(Combinations.ArrayCombinable.access$300((Combinations.ArrayCombinable)Combinations$ArrayCombinable$1.access$200(this.this$1)).iterator()));
        }
    }
}

