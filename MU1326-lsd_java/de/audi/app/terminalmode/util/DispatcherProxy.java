/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.util;

import de.audi.app.terminalmode.util.DispatcherProxy$1;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.lang.reflect.Proxy;

public final class DispatcherProxy {
    private DispatcherProxy() {
    }

    public static Object create(Class clazz, Object object, DispatcherBase dispatcherBase) {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), new Class[]{clazz}, new DispatcherProxy$1(dispatcherBase, object));
    }
}

