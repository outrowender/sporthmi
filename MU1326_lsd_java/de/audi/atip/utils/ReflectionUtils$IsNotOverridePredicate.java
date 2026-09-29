/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils;

import de.audi.atip.utils.ReflectionUtils;
import de.audi.atip.utils.ReflectionUtils$IsNotOverridePredicate$EqualsByNamePredicate;
import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.collections.Predicates;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

class ReflectionUtils$IsNotOverridePredicate
implements Predicate {
    Collection superClassAndInterfcaeMethods;

    public ReflectionUtils$IsNotOverridePredicate(Class clazz) {
        Class clazz2 = clazz;
        this.addInterfaces(clazz2);
        while (!clazz2.equals(ReflectionUtils.class$java$lang$Object == null ? ReflectionUtils.class$("java.lang.Object") : ReflectionUtils.class$java$lang$Object)) {
            clazz2 = clazz.getSuperclass();
            this.addInterfaces(clazz2);
            this.addMethods(clazz2);
        }
    }

    private void addInterfaces(Class clazz) {
        Iterator iterator = Arrays.asList(clazz.getInterfaces()).iterator();
        while (iterator.hasNext()) {
            Class clazz2 = (Class)iterator.next();
            this.addMethods(clazz2);
        }
    }

    private boolean addMethods(Class clazz) {
        return this.superClassAndInterfcaeMethods.addAll(Arrays.asList(clazz.getDeclaredMethods()));
    }

    public boolean apply(Method method) {
        return Predicates.filter(this.superClassAndInterfcaeMethods, (Predicate)new ReflectionUtils$IsNotOverridePredicate$EqualsByNamePredicate(this, method)).isEmpty();
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((Method)object);
    }
}

