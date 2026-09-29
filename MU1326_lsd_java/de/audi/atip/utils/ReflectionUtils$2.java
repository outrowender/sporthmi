/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils;

import de.audi.atip.utils.collections.Predicate;
import java.lang.reflect.Field;

final class ReflectionUtils$2
implements Predicate {
    private final /* synthetic */ String val$name;

    ReflectionUtils$2(String string) {
        this.val$name = string;
    }

    public boolean apply(Field field) {
        return field.getName().equals(this.val$name);
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((Field)object);
    }
}

