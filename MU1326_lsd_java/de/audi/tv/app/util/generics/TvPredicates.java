/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.generics;

import de.audi.atip.utils.collections.Predicate;

public class TvPredicates {
    public static final Predicate<Boolean> IS_FALSE = new Predicate<Boolean>(){

        @Override
        public boolean apply(Boolean bl) {
            return bl == false;
        }

        @Override
        public /* synthetic */ boolean apply(Object object) {
            return this.apply((Boolean)object);
        }
    };
    public static final Predicate<Boolean> IS_TRUE = new Predicate<Boolean>(){

        @Override
        public boolean apply(Boolean bl) {
            return bl;
        }

        @Override
        public /* synthetic */ boolean apply(Object object) {
            return this.apply((Boolean)object);
        }
    };
}

