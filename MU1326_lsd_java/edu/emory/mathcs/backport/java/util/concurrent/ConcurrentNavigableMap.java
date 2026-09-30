/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.NavigableMap;
import edu.emory.mathcs.backport.java.util.NavigableSet;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentMap;
import java.util.Set;
import java.util.SortedMap;

public interface ConcurrentNavigableMap
extends ConcurrentMap,
NavigableMap {
    public NavigableMap subMap(Object var1, boolean var2, Object var3, boolean var4);

    public NavigableMap headMap(Object var1, boolean var2);

    public NavigableMap tailMap(Object var1, boolean var2);

    public SortedMap subMap(Object var1, Object var2);

    public SortedMap headMap(Object var1);

    public SortedMap tailMap(Object var1);

    public NavigableMap descendingMap();

    public NavigableSet navigableKeySet();

    public Set keySet();

    public NavigableSet descendingKeySet();
}

