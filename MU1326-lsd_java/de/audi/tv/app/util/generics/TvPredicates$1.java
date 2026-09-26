/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.generics;

import de.audi.atip.utils.collections.Predicate;

final class TvPredicates$1
implements Predicate {
    TvPredicates$1() {
    }

    public boolean apply(Boolean bl) {
        return bl == false;
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((Boolean)object);
    }
}

