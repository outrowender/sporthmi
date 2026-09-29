/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util;

import org.apache.commons.jexl.util.AbstractExecutor;
import org.apache.commons.jexl.util.introspection.Introspector;
import org.apache.commons.logging.Log;

public class GetExecutor
extends AbstractExecutor {
    private final Object[] args = new Object[1];

    public GetExecutor(Log log, Introspector introspector, Class clazz, String string) {
        this.rlog = log;
        this.args[0] = string;
        this.method = introspector.getMethod(clazz, "get", this.args);
    }

    @Override
    public Object execute(Object object) {
        if (this.method == null) {
            return null;
        }
        return this.method.invoke(object, this.args);
    }
}

