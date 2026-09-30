/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

public class Pair {
    public final Object first;
    public final Object second;

    public Pair(Object object, Object object2) {
        this.first = object;
        this.second = object2;
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
        Pair pair = (Pair)object;
        if (this.first == null ? pair.first != null : !this.first.equals(pair.first)) {
            return false;
        }
        return !(this.second == null ? pair.second != null : !this.second.equals(pair.second));
    }

    public String toString() {
        return "Pair [first=" + this.first + ", second=" + this.second + "]";
    }

    public static Pair create(Object object, Object object2) {
        return new Pair(object, object2);
    }
}

