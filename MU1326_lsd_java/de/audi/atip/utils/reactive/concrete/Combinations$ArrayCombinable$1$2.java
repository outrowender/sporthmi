/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.GList
 */
package de.audi.atip.utils.reactive.concrete;

import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.reactive.concrete.Combinations$ArrayCombinable$1;
import de.audi.atip.utils.reactive.concrete.Combinations$ArrayCombinable$1$2$1;
import de.audi.atip.utils.reactive.observables.BackChannel;

class Combinations$ArrayCombinable$1$2
implements BackChannel {
    private final /* synthetic */ GList val$subscriptions;
    private final /* synthetic */ Combinations$ArrayCombinable$1 this$1;

    Combinations$ArrayCombinable$1$2(Combinations$ArrayCombinable$1 combinations$ArrayCombinable$1, GList gList) {
        this.this$1 = combinations$ArrayCombinable$1;
        this.val$subscriptions = gList;
    }

    @Override
    public void disconnect() {
        this.val$subscriptions.fluent().forEach((Consumer)new Combinations$ArrayCombinable$1$2$1(this));
    }
}

