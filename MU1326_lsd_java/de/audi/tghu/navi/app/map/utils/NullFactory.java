/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.utils.NullFactoryException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class NullFactory
implements InvocationHandler {
    private LogChannel logger;
    private Object obj;
    private Class clazz;
    private String name = null;
    private boolean printTrace = false;
    private Map clzMap = new HashMap();

    public static Object create(Class clazz, LogChannel logChannel, String string) {
        return new NullFactory(clazz, logChannel, string, false).getProxy();
    }

    public static Object create(Class clazz, LogChannel logChannel, String string, boolean bl) {
        return new NullFactory(clazz, logChannel, string, bl).getProxy();
    }

    protected NullFactory(Class clazz, LogChannel logChannel, String string, boolean bl) {
        this.logger = logChannel;
        this.clazz = clazz;
        this.name = string;
        this.printTrace = bl;
        this.obj = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
    }

    private Object getProxy() {
        return this.obj;
    }

    private LogChannel getLogger() {
        return this.logger;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] objectArray) {
        if (this.printTrace) {
            new NullFactoryException().printStackTrace();
        }
        if (this.getLogger() != null) {
            this.getLogger().log(10000, "%1#%2() - unexpected call", (Object)this.clazz.getName(), (Object)method.getName());
        } else {
            System.out.println(new StringBuffer().append("ERROR: ").append(this.clazz.getName()).append("#").append(method.getName()).append(" unexpected call [").append(this.name).append("]").toString());
        }
        Class clazz = method.getReturnType();
        if (clazz.isPrimitive()) {
            if (clazz == Integer.TYPE) {
                return new Integer(0);
            }
            if (clazz == Long.TYPE) {
                return new Long(0L);
            }
            if (clazz == Float.TYPE) {
                return new Float(0.0f);
            }
            if (clazz == Boolean.TYPE) {
                return Boolean.FALSE;
            }
        } else {
            if (clazz.isInterface()) {
                if (!this.clzMap.containsKey(clazz)) {
                    this.clzMap.put(clazz, NullFactory.create(clazz, this.getLogger(), clazz.getName()));
                }
                return this.clzMap.get(clazz);
            }
            if (this.getLogger() != null) {
                this.getLogger().log(10000, "%1#%2() - can not fake %3", (Object)this.clazz.getName(), (Object)method.getName(), (Object)clazz.getName());
            } else {
                System.out.println(new StringBuffer().append("ERROR: ").append(this.clazz.getName()).append("#").append(method.getName()).append(" can not fake [").append(clazz.getName()).append("]").toString());
            }
        }
        return null;
    }
}

