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
    public void init() throws Exception;

    public Iterator getIterator(Object var1, Info var2) throws Exception;

    public VelMethod getMethod(Object var1, String var2, Object[] var3, Info var4) throws Exception;

    public VelPropertyGet getPropertyGet(Object var1, String var2, Info var3) throws Exception;

    public VelPropertySet getPropertySet(Object var1, String var2, Object var3, Info var4) throws Exception;
}

