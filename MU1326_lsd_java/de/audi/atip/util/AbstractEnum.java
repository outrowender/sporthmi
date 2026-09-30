/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractEnum
implements Comparable,
Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final int ordinal;
    static /* synthetic */ Class class$de$audi$atip$util$AbstractEnum;

    protected AbstractEnum(String string, int n) {
        if (n < 0) {
            throw new RuntimeException(new StringBuffer().append("Ordinal for name ").append(string).append(" is below zero!").toString());
        }
        this.ordinal = n;
        this.name = string;
    }

    public final String name() {
        return this.name;
    }

    public final int ordinal() {
        return this.ordinal;
    }

    public String toString() {
        return this.name;
    }

    public static List values(Class clazz) {
        if (clazz == null || clazz == (class$de$audi$atip$util$AbstractEnum == null ? (class$de$audi$atip$util$AbstractEnum = AbstractEnum.class$("de.audi.atip.util.AbstractEnum")) : class$de$audi$atip$util$AbstractEnum) || !(class$de$audi$atip$util$AbstractEnum == null ? (class$de$audi$atip$util$AbstractEnum = AbstractEnum.class$("de.audi.atip.util.AbstractEnum")) : class$de$audi$atip$util$AbstractEnum).isAssignableFrom(clazz)) {
            throw new IllegalArgumentException(new StringBuffer().append("Given class ").append(clazz).append(" is no subclass of AbstractEnum!").toString());
        }
        Field[] fieldArray = clazz.getDeclaredFields();
        if (fieldArray == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(fieldArray.length);
        for (int i2 = 0; i2 < fieldArray.length; ++i2) {
            Field field = fieldArray[i2];
            if (field.getType() != clazz) continue;
            try {
                field.setAccessible(true);
                arrayList.add(field.get(null));
                continue;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new RuntimeException(illegalArgumentException);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new RuntimeException(illegalAccessException);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static AbstractEnum valueOf(Class clazz, String string) {
        List list = AbstractEnum.values(clazz);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            AbstractEnum abstractEnum = (AbstractEnum)iterator.next();
            if (!string.equals(abstractEnum.name())) continue;
            return abstractEnum;
        }
        return null;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean equals(Object object) {
        return super.equals(object);
    }

    public final int compareTo(Object object) {
        Class clazz;
        Class clazz2 = this.getClass();
        if (clazz2 != (clazz = object.getClass())) {
            throw new IllegalArgumentException(new StringBuffer().append("Given object is of type ").append(clazz).append(" but expected is type ").append(clazz2).append("!").toString());
        }
        return this.ordinal - ((AbstractEnum)object).ordinal;
    }

    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public Object readResolve() throws ObjectStreamException {
        return AbstractEnum.valueOf(this.getClass(), this.name);
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

