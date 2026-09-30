/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util.introspection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
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
import org.apache.commons.jexl.util.introspection.UberspectLoggable;
import org.apache.commons.jexl.util.introspection.VelMethod;
import org.apache.commons.jexl.util.introspection.VelPropertyGet;
import org.apache.commons.jexl.util.introspection.VelPropertySet;
import org.apache.commons.logging.Log;

public class UberspectImpl
implements Uberspect,
UberspectLoggable {
    private static final int PROPERTY_START_INDEX = 3;
    private Log rlog;
    private static Introspector introspector;
    static /* synthetic */ Class class$java$util$Map;

    public void init() throws Exception {
    }

    public void setRuntimeLogger(Log log) {
        this.rlog = log;
        introspector = new Introspector(this.rlog);
    }

    public Iterator getIterator(Object object, Info info) throws Exception {
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

    public VelMethod getMethod(Object object, String string, Object[] objectArray, Info info) throws Exception {
        if (object == null) {
            return null;
        }
        Method method = introspector.getMethod(object.getClass(), string, objectArray);
        if (method == null && object instanceof Class) {
            method = introspector.getMethod((Class)object, string, objectArray);
        }
        return method == null ? null : new VelMethodImpl(method);
    }

    public VelPropertyGet getPropertyGet(Object object, String string, Info info) throws Exception {
        Class clazz = object.getClass();
        AbstractExecutor abstractExecutor = new PropertyExecutor(this.rlog, introspector, clazz, string);
        if (!abstractExecutor.isAlive()) {
            abstractExecutor = new BooleanPropertyExecutor(this.rlog, introspector, clazz, string);
        }
        if (!abstractExecutor.isAlive()) {
            abstractExecutor = new GetExecutor(this.rlog, introspector, clazz, string);
        }
        return abstractExecutor == null ? null : new VelGetterImpl(abstractExecutor);
    }

    public VelPropertySet getPropertySet(Object object, String string, Object object2, Info info) throws Exception {
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
                return new VelSetterImpl(velMethod, string);
            }
        }
        return velMethod == null ? null : new VelSetterImpl(velMethod);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    public class VelGetterImpl
    implements VelPropertyGet {
        protected AbstractExecutor ae = null;

        public VelGetterImpl(AbstractExecutor abstractExecutor) {
            this.ae = abstractExecutor;
        }

        public Object invoke(Object object) throws Exception {
            return this.ae.execute(object);
        }

        public boolean isCacheable() {
            return true;
        }

        public String getMethodName() {
            return this.ae.getMethod().getName();
        }
    }

    public class VelMethodImpl
    implements VelMethod {
        protected Method method = null;

        public VelMethodImpl(Method method) {
            this.method = method;
        }

        public Object invoke(Object object, Object[] objectArray) throws Exception {
            try {
                return this.method.invoke(object, objectArray);
            }
            catch (InvocationTargetException invocationTargetException) {
                Throwable throwable = invocationTargetException.getTargetException();
                if (throwable instanceof Exception) {
                    throw (Exception)throwable;
                }
                if (throwable instanceof Error) {
                    throw (Error)throwable;
                }
                throw invocationTargetException;
            }
        }

        public boolean isCacheable() {
            return true;
        }

        public String getMethodName() {
            return this.method.getName();
        }

        public Class getReturnType() {
            return this.method.getReturnType();
        }
    }

    public class VelSetterImpl
    implements VelPropertySet {
        protected VelMethod vm = null;
        protected String putKey = null;

        public VelSetterImpl(VelMethod velMethod) {
            this.vm = velMethod;
        }

        public VelSetterImpl(VelMethod velMethod, String string) {
            this.vm = velMethod;
            this.putKey = string;
        }

        public Object invoke(Object object, Object object2) throws Exception {
            ArrayList arrayList = new ArrayList();
            if (this.putKey == null) {
                arrayList.add(object2);
            } else {
                arrayList.add(this.putKey);
                arrayList.add(object2);
            }
            return this.vm.invoke(object, arrayList.toArray());
        }

        public boolean isCacheable() {
            return true;
        }

        public String getMethodName() {
            return this.vm.getMethodName();
        }
    }
}

