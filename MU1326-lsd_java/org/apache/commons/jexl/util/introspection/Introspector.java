/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util.introspection;

import java.lang.reflect.Method;
import org.apache.commons.jexl.util.introspection.IntrospectorBase;
import org.apache.commons.jexl.util.introspection.MethodMap$AmbiguousException;
import org.apache.commons.logging.Log;

public class Introspector
extends IntrospectorBase {
    public static final String CACHEDUMP_MSG;
    private final Log rlog;

    public Introspector(Log log) {
        this.rlog = log;
    }

    @Override
    public Method getMethod(Class clazz, String string, Object[] objectArray) {
        try {
            return super.getMethod(clazz, string, objectArray);
        }
        catch (MethodMap$AmbiguousException methodMap$AmbiguousException) {
            StringBuffer stringBuffer = new StringBuffer("Introspection Error : Ambiguous method invocation ").append(string).append("( ");
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                if (i2 > 0) {
                    stringBuffer.append(", ");
                }
                stringBuffer.append(objectArray[i2].getClass().getName());
            }
            stringBuffer.append(") for class ").append(clazz.getName());
            this.rlog.error(stringBuffer.toString());
            return null;
        }
    }

    @Override
    protected void clearCache() {
        super.clearCache();
        this.rlog.info("Introspector : detected classloader change. Dumping cache.");
    }
}

