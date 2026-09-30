/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.generics;

import de.audi.atip.utils.reactive.observables.Observables;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Triple<A, B, C> {
    public final A a;
    public final B b;
    public final C c;

    public Triple(A a2, B b2, C c2) {
        this.a = a2;
        this.b = b2;
        this.c = c2;
    }

    public static <A, B, C> Observables.Combinator3<A, B, C, Triple<A, B, C>> combine() {
        return new Observables.Combinator3<A, B, C, Triple<A, B, C>>(){

            @Override
            public Triple<A, B, C> combine(A a2, B b2, C c2) {
                return new Triple(a2, b2, c2);
            }

            @Override
            public /* synthetic */ Object combine(Object object, Object object2, Object object3) {
                return this.combine(object, object2, object3);
            }
        };
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.a == null ? 0 : this.a.hashCode());
        n = 31 * n + (this.b == null ? 0 : this.b.hashCode());
        n = 31 * n + (this.c == null ? 0 : this.c.hashCode());
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
        Triple triple = (Triple)object;
        if (this.a == null ? triple.a != null : !this.a.equals(triple.a)) {
            return false;
        }
        if (this.b == null ? triple.b != null : !this.b.equals(triple.b)) {
            return false;
        }
        return !(this.c == null ? triple.c != null : !this.c.equals(triple.c));
    }
}

