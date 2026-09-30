/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.logging.Log;

public abstract class AbstractExecutor {
    protected Log rlog = null;
    protected Method method = null;

    public abstract Object execute(Object var1) throws IllegalAccessException, InvocationTargetException;

    public boolean isAlive() {
        return this.method != null;
    }

    public Method getMethod() {
        return this.method;
    }
}

