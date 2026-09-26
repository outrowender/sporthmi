/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.generics;

import de.audi.atip.utils.collections.Predicate;

final class TvPredicates$2
implements Predicate {
    TvPredicates$2() {
    }

    public boolean apply(Boolean bl) {
        return bl;
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((Boolean)object);
    }
}

