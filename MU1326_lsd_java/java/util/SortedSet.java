/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Comparator;
import java.util.Set;

public interface SortedSet
extends Set {
    public Comparator comparator();

    public Object first();

    public SortedSet headSet(Object var1);

    public Object last();

    public SortedSet subSet(Object var1, Object var2);

    public SortedSet tailSet(Object var1);
}

