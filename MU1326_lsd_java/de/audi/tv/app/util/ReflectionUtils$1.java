/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.tv.app.util.Predicates$Predicate;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

final class ReflectionUtils$1
implements Predicates$Predicate {
    ReflectionUtils$1() {
    }

    @Override
    public boolean apply(Object object) {
        boolean bl = Modifier.isPrivate(((Field)object).getModifiers());
        boolean bl2 = ((Field)object).getName().startsWith("this");
        return !bl2 && !bl;
    }
}

