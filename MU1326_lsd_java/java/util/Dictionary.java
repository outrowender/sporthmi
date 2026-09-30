/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Enumeration;

public abstract class Dictionary {
    public abstract Enumeration elements();

    public abstract Object get(Object var1);

    public abstract boolean isEmpty();

    public abstract Enumeration keys();

    public abstract Object put(Object var1, Object var2);

    public abstract Object remove(Object var1);

    public abstract int size();
}

