/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util;

import org.apache.commons.jexl.util.PropertyExecutor;
import org.apache.commons.jexl.util.introspection.Introspector;
import org.apache.commons.logging.Log;

public class BooleanPropertyExecutor
extends PropertyExecutor {
    public BooleanPropertyExecutor(Log log, Introspector introspector, Class clazz, String string) {
        super(log, introspector, clazz, string);
    }

    @Override
    protected void discover(Class clazz, String string) {
        try {
            Object[] objectArray = new Object[]{};
            StringBuffer stringBuffer = new StringBuffer("is");
            stringBuffer.append(string);
            char c2 = stringBuffer.charAt(2);
            if (Character.isLowerCase(c2)) {
                stringBuffer.setCharAt(2, Character.toUpperCase(c2));
            }
            this.methodUsed = stringBuffer.toString();
            this.method = this.introspector.getMethod(clazz, this.methodUsed, objectArray);
            if (this.method != null) {
                if (this.method.getReturnType() == Boolean.TYPE) {
                    return;
                }
                this.method = null;
            }
        }
        catch (Exception exception) {
            this.rlog.error(new StringBuffer().append("PROGRAMMER ERROR : BooleanPropertyExector() : ").append(exception).toString());
        }
    }
}

