/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils;

import de.audi.atip.utils.collections.Predicate;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

final class ReflectionUtils$1
implements Predicate {
    ReflectionUtils$1() {
    }

    public boolean apply(Field field) {
        boolean bl = Modifier.isPrivate(field.getModifiers());
        boolean bl2 = field.getName().startsWith("this");
        return !bl2 && !bl;
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((Field)object);
    }
}

