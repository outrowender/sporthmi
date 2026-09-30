/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.util;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class Enum<T> {
    private final String name;
    private final int ordinal;

    protected Enum(int n, String string) {
        this.ordinal = n;
        this.name = string;
    }

    protected Enum(String string) {
        this.ordinal = -1;
        this.name = string;
    }

    public String name() {
        return this.name;
    }

    public int ordinal() {
        if (this.ordinal == -1) {
            throw new UnsupportedOperationException("You did not define an ordinal for your enum! Either don't use (better) it or use another constructor(not so safe)!");
        }
        return this.ordinal;
    }

    public String toString() {
        return this.name;
    }

    public boolean is(T t) {
        return this.equals(t);
    }

    public boolean is(T[] TArray) {
        boolean bl = false;
        for (int i2 = 0; i2 < TArray.length; ++i2) {
            bl |= this.equals(TArray[i2]);
        }
        return bl;
    }

    public boolean isNot(T t) {
        return !this.is(t);
    }

    public boolean isOneOf(T t, T t2) {
        return this.equals(t) || this.equals(t2);
    }

    public boolean isOneOf(T t, T t2, T t3) {
        return this.equals(t) || this.equals(t2) || this.equals(t3);
    }

    public boolean isOneOf(T t, T t2, T t3, T t4) {
        return this.equals(t) || this.equals(t2) || this.equals(t3) || this.equals(t4);
    }

    public boolean isOneOf(T t, T t2, T t3, T t4, T t5) {
        return this.equals(t) || this.equals(t2) || this.equals(t3) || this.equals(t4) || this.equals(t5);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.name == null ? 0 : this.name.hashCode());
        n = 31 * n + this.ordinal;
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
        Enum enum_ = (Enum)object;
        if (this.name == null ? enum_.name != null : !this.name.equals(enum_.name)) {
            return false;
        }
        return this.ordinal == enum_.ordinal;
    }
}

