/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util.introspection;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.jexl.util.AbstractExecutor;
import org.apache.commons.jexl.util.ArrayIterator;
import org.apache.commons.jexl.util.BooleanPropertyExecutor;
import org.apache.commons.jexl.util.EnumerationIterator;
import org.apache.commons.jexl.util.GetExecutor;
import org.apache.commons.jexl.util.PropertyExecutor;
import org.apache.commons.jexl.util.introspection.Info;
import org.apache.commons.jexl.util.introspection.Introspector;
import org.apache.commons.jexl.util.introspection.Uberspect;
import org.apache.commons.jexl.util.introspection.UberspectImpl$VelGetterImpl;
import org.apache.commons.jexl.util.introspection.UberspectImpl$VelMethodImpl;
import org.apache.commons.jexl.util.introspection.UberspectImpl$VelSetterImpl;
import org.apache.commons.jexl.util.introspection.UberspectLoggable;
import org.apache.commons.jexl.util.introspection.VelMethod;
import org.apache.commons.jexl.util.introspection.VelPropertyGet;
import org.apache.commons.jexl.util.introspection.VelPropertySet;
import org.apache.commons.logging.Log;

public class UberspectImpl
implements Uberspect,
UberspectLoggable {
    private static final int PROPERTY_START_INDEX;
    private Log rlog;
    private static Introspector introspector;
    static /* synthetic */ Class class$java$util$Map;

    @Override
    public void init() {
    }

    @Override
    public void setRuntimeLogger(Log log) {
        this.rlog = log;
        introspector = new Introspector(this.rlog);
    }

    @Override
    public Iterator getIterator(Object object, Info info) {
        if (object.getClass().isArray()) {
            return new ArrayIterator(object);
        }
        if (object instanceof Collection) {
            return ((Collection)object).iterator();
        }
        if (object instanceof Map) {
            return ((Map)object).values().iterator();
        }
        if (object instanceof Iterator) {
            this.rlog.warn(new StringBuffer().append("Warning! The iterative  is an Iterator in the #foreach() loop at [").append(info.getLine()).append(",").append(info.getColumn()).append("]").append(" in template ").append(info.getTemplateName()).append(". Because it's not resetable,").append(" if used in more than once, this may lead to").append(" unexpected results.").toString());
            return (Iterator)object;
        }
        if (object instanceof Enumeration) {
            this.rlog.warn(new StringBuffer().append("Warning! The iterative  is an Enumeration in the #foreach() loop at [").append(info.getLine()).append(",").append(info.getColumn()).append("]").append(" in template ").append(info.getTemplateName()).append(". Because it's not resetable,").append(" if used in more than once, this may lead to").append(" unexpected results.").toString());
            return new EnumerationIterator((Enumeration)object);
        }
        this.rlog.warn(new StringBuffer().append("Could not determine type of iterator in #foreach loop  at [").append(info.getLine()).append(",").append(info.getColumn()).append("]").append(" in template ").append(info.getTemplateName()).toString());
        return null;
    }

    @Override
    public VelMethod getMethod(Object object, String string, Object[] objectArray, Info info) {
        if (object == null) {
            return null;
        }
        Method method = introspector.getMethod(object.getClass(), string, objectArray);
        if (method == null && object instanceof Class) {
            method = introspector.getMethod((Class)object, string, objectArray);
        }
        return method == null ? null : new UberspectImpl$VelMethodImpl(this, method);
    }

    @Override
    public VelPropertyGet getPropertyGet(Object object, String string, Info info) {
        Class clazz = object.getClass();
        AbstractExecutor abstractExecutor = new PropertyExecutor(this.rlog, introspector, clazz, string);
        if (!abstractExecutor.isAlive()) {
            abstractExecutor = new BooleanPropertyExecutor(this.rlog, introspector, clazz, string);
        }
        if (!abstractExecutor.isAlive()) {
            abstractExecutor = new GetExecutor(this.rlog, introspector, clazz, string);
        }
        return abstractExecutor == null ? null : new UberspectImpl$VelGetterImpl(this, abstractExecutor);
    }

    @Override
    public VelPropertySet getPropertySet(Object object, String string, Object object2, Info info) {
        VelMethod velMethod;
        block8: {
            Class clazz = object.getClass();
            velMethod = null;
            try {
                Object[] objectArray = new Object[]{object2};
                try {
                    velMethod = this.getMethod(object, new StringBuffer().append("set").append(string).toString(), objectArray, info);
                    if (velMethod == null) {
                        throw new NoSuchMethodException();
                    }
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    StringBuffer stringBuffer = new StringBuffer("set");
                    stringBuffer.append(string);
                    if (Character.isLowerCase(stringBuffer.charAt(3))) {
                        stringBuffer.setCharAt(3, Character.toUpperCase(stringBuffer.charAt(3)));
                    } else {
                        stringBuffer.setCharAt(3, Character.toLowerCase(stringBuffer.charAt(3)));
                    }
                    velMethod = this.getMethod(object, stringBuffer.toString(), objectArray, info);
                    if (velMethod == null) {
                        throw new NoSuchMethodException();
                    }
                }
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Object[] objectArray;
                if (!(class$java$util$Map == null ? (class$java$util$Map = UberspectImpl.class$("java.util.Map")) : class$java$util$Map).isAssignableFrom(clazz) || (velMethod = this.getMethod(object, "put", objectArray = new Object[]{new Object(), new Object()}, info)) == null) break block8;
                return new UberspectImpl$VelSetterImpl(this, velMethod, string);
            }
        }
        return velMethod == null ? null : new UberspectImpl$VelSetterImpl(this, velMethod);
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

