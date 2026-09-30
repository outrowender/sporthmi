/*
 * Decompiled with CFR 0.152.
 */
package de.eso.a.b;

import de.eso.a.b.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class h
extends HashMap
implements i {
    private static final long a = 1943563828307035349L;

    public Collection a(Object object) {
        return (Collection)this.get(object);
    }

    public Object put(Object object, Object object2) {
        boolean bl;
        Collection collection = this.a(object);
        if (collection == null) {
            collection = this.a(null);
            super.put(object, collection);
        }
        return (bl = collection.add(object2)) ? object2 : null;
    }

    public boolean containsValue(Object object) {
        Set set = super.entrySet();
        if (set == null) {
            return false;
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Collection collection = (Collection)entry.getValue();
            if (!collection.contains(object)) continue;
            return true;
        }
        return false;
    }

    public boolean a(Object object, Object object2) {
        Collection collection = this.a(object);
        if (collection == null) {
            return false;
        }
        return collection.contains(object2);
    }

    public Object b(Object object, Object object2) {
        Collection collection = this.a(object);
        if (collection == null) {
            return null;
        }
        boolean bl = collection.remove(object2);
        if (!bl) {
            return null;
        }
        if (collection.isEmpty()) {
            this.remove(object);
        }
        return object2;
    }

    public void clear() {
        Set set = super.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Collection collection = (Collection)entry.getValue();
            collection.clear();
        }
        super.clear();
    }

    protected Collection a(Collection collection) {
        if (collection == null) {
            return new ArrayList();
        }
        return new ArrayList(collection);
    }
}

