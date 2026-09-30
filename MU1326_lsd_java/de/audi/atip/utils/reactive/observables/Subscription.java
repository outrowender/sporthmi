/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.observables;

import de.audi.atip.utils.generics.GList;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface Subscription {
    public static final Subscription STUB = new Subscription(){

        @Override
        public void cancel() {
        }

        @Override
        public Subscription addTo(GList<Subscription> gList) {
            return this;
        }
    };

    public void cancel();

    public Subscription addTo(GList<Subscription> var1);
}

