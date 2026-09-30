/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.generics;

import de.audi.atip.utils.reactive.observables.Observables;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Tuple<A, B> {
    public final A a;
    public final B b;

    public Tuple(A a2, B b2) {
        this.a = a2;
        this.b = b2;
    }

    public static <A, B> Observables.Combinator<A, B, Tuple<A, B>> combine() {
        return new Observables.Combinator<A, B, Tuple<A, B>>(){

            @Override
            public Tuple<A, B> combine(A a2, B b2) {
                return new Tuple(a2, b2);
            }

            @Override
            public /* synthetic */ Object combine(Object object, Object object2) {
                return this.combine(object, object2);
            }
        };
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.a == null ? 0 : this.a.hashCode());
        n = 31 * n + (this.b == null ? 0 : this.b.hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Tuple tuple = (Tuple)object;
        if (this.a == null ? tuple.a != null : !this.a.equals(tuple.a)) {
            return false;
        }
        return !(this.b == null ? tuple.b != null : !this.b.equals(tuple.b));
    }
}

