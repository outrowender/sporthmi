/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils;

import de.audi.atip.utils.ReflectionUtils$1;
import de.audi.atip.utils.collections.Predicate;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class ReflectionUtils$IsNotPrivatePredicate
implements Predicate {
    private ReflectionUtils$IsNotPrivatePredicate() {
    }

    public boolean apply(Method method) {
        return !Modifier.isPrivate(method.getModifiers());
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((Method)object);
    }

    /* synthetic */ ReflectionUtils$IsNotPrivatePredicate(ReflectionUtils$1 reflectionUtils$1) {
        this();
    }
}

