/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import de.audi.app.bap.utils.NullObjectFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class NullObjectFactory$1
implements InvocationHandler {
    NullObjectFactory$1() {
    }

    @Override
    public Object invoke(Object object, Method method, Object[] objectArray) {
        return NullObjectFactory.access$000(method.getReturnType());
    }
}

