/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.utils.statemachine.InnerClassInflator$Expandable;
import de.audi.atip.utils.statemachine.InnerClassInflator$HierarchyBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class InnerClassInflator {
    private final InnerClassInflator$HierarchyBuilder builder;
    private final Object enclosingObject;

    public InnerClassInflator(InnerClassInflator$HierarchyBuilder hierarchyBuilder, Object object) {
        this.builder = hierarchyBuilder;
        this.enclosingObject = object;
    }

    public void inflate() {
        Iterator iterator = InnerClassInflator.getInnerStates(this.enclosingObject.getClass()).iterator();
        while (iterator.hasNext()) {
            Class clazz = (Class)iterator.next();
            Object object = InnerClassInflator.instantiateInnerClass(this.enclosingObject, clazz);
            this.builder.add(object);
            InnerClassInflator$Expandable innerClassInflator$Expandable = new InnerClassInflator$Expandable(this, object);
            innerClassInflator$Expandable.expand();
        }
    }

    private static Object instantiateInnerClass(Object object, Class clazz) {
        return clazz.getDeclaredConstructor(new Class[]{object.getClass()}).newInstance(new Object[]{object});
    }

    private static Collection getInnerStates(Class clazz) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(clazz.getDeclaredClasses()));
        return arrayList;
    }

    static /* synthetic */ Collection access$000(Class clazz) {
        return InnerClassInflator.getInnerStates(clazz);
    }

    static /* synthetic */ Object access$100(Object object, Class clazz) {
        return InnerClassInflator.instantiateInnerClass(object, clazz);
    }

    static /* synthetic */ InnerClassInflator$HierarchyBuilder access$200(InnerClassInflator innerClassInflator) {
        return innerClassInflator.builder;
    }
}

