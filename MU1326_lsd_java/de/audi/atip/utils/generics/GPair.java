/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class GPair<F, S> {
    protected F first;
    protected S second;

    protected GPair() {
    }

    public GPair(F f2, S s) {
        this.first = f2;
        this.second = s;
    }

    public F getFirst() {
        return this.first;
    }

    public S getSecond() {
        return this.second;
    }

    public int hashCode() {
        return (this.first == null ? 0 : this.first.hashCode()) ^ (this.second == null ? 0 : this.second.hashCode());
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
        GPair gPair = (GPair)object;
        if (this.first == null ? gPair.first != null : !this.first.equals(gPair.first)) {
            return false;
        }
        return !(this.second == null ? gPair.second != null : !this.second.equals(gPair.second));
    }

    public String toString() {
        return new StringBuffer().append("GPair [first=").append(this.first).append(", second=").append(this.second).append("]").toString();
    }

    public static <A, B> GPair<A, B> create(A a2, B b2) {
        return new GPair<A, B>(a2, b2);
    }
}

