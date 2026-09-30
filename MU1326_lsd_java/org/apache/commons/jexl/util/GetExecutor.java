/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.jexl.util.AbstractExecutor;
import org.apache.commons.jexl.util.introspection.Introspector;
import org.apache.commons.logging.Log;

public class GetExecutor
extends AbstractExecutor {
    private final Object[] args = new Object[1];

    public GetExecutor(Log log, Introspector introspector, Class clazz, String string) throws Exception {
        this.rlog = log;
        this.args[0] = string;
        this.method = introspector.getMethod(clazz, "get", this.args);
    }

    public Object execute(Object object) throws IllegalAccessException, InvocationTargetException {
        if (this.method == null) {
            return null;
        }
        return this.method.invoke(object, this.args);
    }
}

