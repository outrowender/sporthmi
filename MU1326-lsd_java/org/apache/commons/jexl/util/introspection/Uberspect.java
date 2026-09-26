/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util.introspection;

import java.util.Iterator;
import org.apache.commons.jexl.util.introspection.Info;
import org.apache.commons.jexl.util.introspection.VelMethod;
import org.apache.commons.jexl.util.introspection.VelPropertyGet;
import org.apache.commons.jexl.util.introspection.VelPropertySet;

public interface Uberspect {
    default public void init() {
    }

    default public Iterator getIterator(Object object, Info info) {
    }

    default public VelMethod getMethod(Object object, String string, Object[] objectArray, Info info) {
    }

    default public VelPropertyGet getPropertyGet(Object object, String string, Info info) {
    }

    default public VelPropertySet getPropertySet(Object object, String string, Object object2, Info info) {
    }
}

