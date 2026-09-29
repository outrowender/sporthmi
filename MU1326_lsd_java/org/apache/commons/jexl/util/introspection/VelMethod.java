/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util.introspection;

public interface VelMethod {
    default public Object invoke(Object object, Object[] objectArray) {
    }

    default public boolean isCacheable() {
    }

    default public String getMethodName() {
    }

    default public Class getReturnType() {
    }
}

