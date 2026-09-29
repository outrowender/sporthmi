/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.tv.app.util.Predicates$Predicate;
import de.audi.tv.app.util.ReflectionUtils$1;
import java.lang.reflect.Method;

class ReflectionUtils$IsNotEnclosingAccessPredicate
implements Predicates$Predicate {
    private ReflectionUtils$IsNotEnclosingAccessPredicate() {
    }

    @Override
    public boolean apply(Object object) {
        return !((Method)object).getName().startsWith("access");
    }

    /* synthetic */ ReflectionUtils$IsNotEnclosingAccessPredicate(ReflectionUtils$1 reflectionUtils$1) {
        this();
    }
}

