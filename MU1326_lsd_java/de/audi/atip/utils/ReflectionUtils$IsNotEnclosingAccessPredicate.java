/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils;

import de.audi.atip.utils.ReflectionUtils$1;
import de.audi.atip.utils.collections.Predicate;
import java.lang.reflect.Method;

class ReflectionUtils$IsNotEnclosingAccessPredicate
implements Predicate {
    private ReflectionUtils$IsNotEnclosingAccessPredicate() {
    }

    public boolean apply(Method method) {
        return !method.getName().startsWith("access");
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((Method)object);
    }

    /* synthetic */ ReflectionUtils$IsNotEnclosingAccessPredicate(ReflectionUtils$1 reflectionUtils$1) {
        this();
    }
}

