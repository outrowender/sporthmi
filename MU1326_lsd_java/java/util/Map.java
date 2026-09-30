/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Collection;
import java.util.Set;

public interface Map {
    public void clear();

    public boolean containsKey(Object var1);

    public boolean containsValue(Object var1);

    public Set entrySet();

    public boolean equals(Object var1);

    public Object get(Object var1);

    public int hashCode();

    public boolean isEmpty();

    public Set keySet();

    public Object put(Object var1, Object var2);

    public void putAll(Map var1);

    public Object remove(Object var1);

    public int size();

    public Collection values();

    public static interface Entry {
        public boolean equals(Object var1);

        public Object getKey();

        public Object getValue();

        public int hashCode();

        public Object setValue(Object var1);
    }
}

