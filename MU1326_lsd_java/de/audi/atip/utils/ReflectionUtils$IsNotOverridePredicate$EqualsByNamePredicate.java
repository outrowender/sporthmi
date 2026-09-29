/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils;

import de.audi.atip.utils.ReflectionUtils$IsNotOverridePredicate;
import de.audi.atip.utils.collections.Predicate;
import java.lang.reflect.Method;

class ReflectionUtils$IsNotOverridePredicate$EqualsByNamePredicate
implements Predicate {
    private Method oneMethod;
    private final /* synthetic */ ReflectionUtils$IsNotOverridePredicate this$0;

    public ReflectionUtils$IsNotOverridePredicate$EqualsByNamePredicate(ReflectionUtils$IsNotOverridePredicate reflectionUtils$IsNotOverridePredicate, Method method) {
        this.this$0 = reflectionUtils$IsNotOverridePredicate;
        this.oneMethod = method;
    }

    public boolean apply(Method method) {
        return method.getName().equals(this.oneMethod.getName());
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((Method)object);
    }
}

