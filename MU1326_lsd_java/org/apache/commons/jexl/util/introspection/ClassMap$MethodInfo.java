/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util.introspection;

import java.lang.reflect.Method;

final class ClassMap$MethodInfo {
    Method method = null;
    String name;
    Class[] parameterTypes;
    boolean upcast;

    ClassMap$MethodInfo(Method method) {
        this.name = method.getName();
        this.parameterTypes = method.getParameterTypes();
        this.upcast = false;
    }

    void tryUpcasting(Class clazz) {
        this.method = clazz.getMethod(this.name, this.parameterTypes);
        this.name = null;
        this.parameterTypes = null;
        this.upcast = true;
    }
}

