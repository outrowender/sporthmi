/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.audi.atip.util;

import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.List;

public class MethodCall {
    private final Object obj;
    private final String method;
    private List argList = new ArrayList(10);
    static /* synthetic */ Class class$java$lang$Integer;
    static /* synthetic */ Class class$java$lang$Short;
    static /* synthetic */ Class class$java$lang$Long;
    static /* synthetic */ Class class$java$lang$Double;
    static /* synthetic */ Class class$java$lang$Byte;
    static /* synthetic */ Class class$java$lang$Boolean;

    public MethodCall(Object object, String string) {
        this.method = string;
        this.obj = object;
    }

    public void call(LogChannel logChannel) {
        try {
            this.obj.getClass().getMethod(this.method, this.getTypes()).invoke(this.obj, this.getValues());
        }
        catch (Exception exception) {
            logChannel.log(-1601830656, "Calling %1 failed!", (Object)this, (Throwable)exception);
        }
    }

    public void call() {
        this.obj.getClass().getMethod(this.method, this.getTypes()).invoke(this.obj, this.getValues());
    }

    public MethodCall arg(Object object) {
        this.argList.add(object);
        return this;
    }

    public MethodCall arg(int n) {
        this.argList.add(new Integer(n));
        return this;
    }

    public MethodCall arg(short s) {
        this.argList.add(new Short(s));
        return this;
    }

    public MethodCall arg(long l) {
        this.argList.add(new Long(l));
        return this;
    }

    public MethodCall arg(boolean bl) {
        this.argList.add(bl);
        return this;
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append(this.obj.getClass().getName()).append('.');
        buffer.append(this.method).append("( ");
        int n = this.argList.size();
        for (int i2 = 0; i2 < n; ++i2) {
            buffer.append(this.argList.get(i2)).append(", ");
        }
        return new StringBuffer().append(buffer.substring(0, buffer.length() - 2)).append(" )").toString();
    }

    private Class[] getTypes() {
        Object[] objectArray = this.getValues();
        Class[] classArray = new Class[objectArray.length];
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            classArray[i2] = this.getType(objectArray[i2]);
        }
        return classArray;
    }

    private Object[] getValues() {
        return this.argList.toArray();
    }

    private Class getType(Object object) {
        Class clazz = object.getClass();
        if (clazz == (class$java$lang$Integer == null ? (class$java$lang$Integer = MethodCall.class$("java.lang.Integer")) : class$java$lang$Integer)) {
            return Integer.TYPE;
        }
        if (clazz == (class$java$lang$Short == null ? (class$java$lang$Short = MethodCall.class$("java.lang.Short")) : class$java$lang$Short)) {
            return Short.TYPE;
        }
        if (clazz == (class$java$lang$Long == null ? (class$java$lang$Long = MethodCall.class$("java.lang.Long")) : class$java$lang$Long)) {
            return Long.TYPE;
        }
        if (clazz == (class$java$lang$Double == null ? (class$java$lang$Double = MethodCall.class$("java.lang.Double")) : class$java$lang$Double)) {
            return Double.TYPE;
        }
        if (clazz == (class$java$lang$Byte == null ? (class$java$lang$Byte = MethodCall.class$("java.lang.Byte")) : class$java$lang$Byte)) {
            return Byte.TYPE;
        }
        if (clazz == (class$java$lang$Boolean == null ? (class$java$lang$Boolean = MethodCall.class$("java.lang.Boolean")) : class$java$lang$Boolean)) {
            return Boolean.TYPE;
        }
        return clazz;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

