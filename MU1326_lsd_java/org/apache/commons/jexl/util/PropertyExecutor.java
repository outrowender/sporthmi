/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.jexl.util.AbstractExecutor;
import org.apache.commons.jexl.util.introspection.Introspector;
import org.apache.commons.logging.Log;

public class PropertyExecutor
extends AbstractExecutor {
    private static final int PROPERTY_START_INDEX = 3;
    protected Introspector introspector = null;
    protected String methodUsed = null;

    public PropertyExecutor(Log log, Introspector introspector, Class clazz, String string) {
        this.rlog = log;
        this.introspector = introspector;
        this.discover(clazz, string);
    }

    protected void discover(Class clazz, String string) {
        try {
            Object[] objectArray = new Object[]{};
            StringBuffer stringBuffer = new StringBuffer("get");
            stringBuffer.append(string);
            this.methodUsed = stringBuffer.toString();
            this.method = this.introspector.getMethod(clazz, this.methodUsed, objectArray);
            if (this.method != null) {
                return;
            }
            stringBuffer = new StringBuffer("get");
            stringBuffer.append(string);
            char c2 = stringBuffer.charAt(3);
            if (Character.isLowerCase(c2)) {
                stringBuffer.setCharAt(3, Character.toUpperCase(c2));
            } else {
                stringBuffer.setCharAt(3, Character.toLowerCase(c2));
            }
            this.methodUsed = stringBuffer.toString();
            this.method = this.introspector.getMethod(clazz, this.methodUsed, objectArray);
            if (this.method != null) {
                return;
            }
        }
        catch (Exception exception) {
            this.rlog.error("PROGRAMMER ERROR : PropertyExector() : " + exception);
        }
    }

    public Object execute(Object object) throws IllegalAccessException, InvocationTargetException {
        if (this.method == null) {
            return null;
        }
        return this.method.invoke(object, null);
    }
}

