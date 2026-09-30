/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Comparator;
import java.util.Map;

public interface SortedMap
extends Map {
    public Comparator comparator();

    public Object firstKey();

    public SortedMap headMap(Object var1);

    public Object lastKey();

    public SortedMap subMap(Object var1, Object var2);

    public SortedMap tailMap(Object var1);
}

