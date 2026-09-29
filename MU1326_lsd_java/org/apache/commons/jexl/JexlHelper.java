/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.context.HashMapContext;

public class JexlHelper {
    protected static JexlHelper helper = new JexlHelper();

    protected static JexlHelper getInstance() {
        return helper;
    }

    public static JexlContext createContext() {
        return JexlHelper.getInstance().newContext();
    }

    protected JexlContext newContext() {
        return new HashMapContext();
    }
}

