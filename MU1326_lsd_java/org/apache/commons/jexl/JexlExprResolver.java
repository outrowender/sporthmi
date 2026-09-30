/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl;

import org.apache.commons.jexl.JexlContext;

public interface JexlExprResolver {
    public static final Object NO_VALUE = new Object();

    public Object evaluate(JexlContext var1, String var2);
}

