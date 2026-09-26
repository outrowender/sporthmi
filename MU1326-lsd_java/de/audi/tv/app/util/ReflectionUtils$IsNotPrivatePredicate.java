/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.tv.app.util.Predicates$Predicate;
import de.audi.tv.app.util.ReflectionUtils$1;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class ReflectionUtils$IsNotPrivatePredicate
implements Predicates$Predicate {
    private ReflectionUtils$IsNotPrivatePredicate() {
    }

    @Override
    public boolean apply(Object object) {
        return !Modifier.isPrivate(((Method)object).getModifiers());
    }

    /* synthetic */ ReflectionUtils$IsNotPrivatePredicate(ReflectionUtils$1 reflectionUtils$1) {
        this();
    }
}

