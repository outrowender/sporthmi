/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class InnerClassInflator {
    private final HierarchyBuilder builder;
    private final Object enclosingObject;

    public InnerClassInflator(HierarchyBuilder hierarchyBuilder, Object object) {
        this.builder = hierarchyBuilder;
        this.enclosingObject = object;
    }

    public void inflate() throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Iterator iterator = InnerClassInflator.getInnerStates(this.enclosingObject.getClass()).iterator();
        while (iterator.hasNext()) {
            Class clazz = (Class)iterator.next();
            Object object = InnerClassInflator.instantiateInnerClass(this.enclosingObject, clazz);
            this.builder.add(object);
            Expandable expandable = new Expandable(object);
            expandable.expand();
        }
    }

    private static Object instantiateInnerClass(Object object, Class clazz) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return clazz.getDeclaredConstructor(new Class[]{object.getClass()}).newInstance(new Object[]{object});
    }

    private static Collection getInnerStates(Class clazz) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(clazz.getDeclaredClasses()));
        return arrayList;
    }

    private class Expandable {
        private final Object object;

        Expandable(Object object) {
            this.object = object;
        }

        public void expand() throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            Iterator iterator = InnerClassInflator.getInnerStates(this.object.getClass()).iterator();
            while (iterator.hasNext()) {
                Class clazz = (Class)iterator.next();
                Object object = InnerClassInflator.instantiateInnerClass(this.object, clazz);
                InnerClassInflator.this.builder.add(object, this.object);
                Expandable expandable = new Expandable(object);
                expandable.expand();
            }
        }
    }

    public static interface HierarchyBuilder {
        public void add(Object var1);

        public void add(Object var1, Object var2);
    }
}

