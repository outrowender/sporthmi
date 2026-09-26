/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

public class Preconditions {
    public static void checkArgument(boolean bl) {
        if (!bl) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean bl, Object object) {
        if (!bl) {
            throw new IllegalArgumentException(String.valueOf(object));
        }
    }

    public static Object checkNotNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("[Preconditions.checkNotNull] Got a null reference");
        }
        return object;
    }

    public static Object checkNotNull(Object object, Object object2) {
        if (object == null) {
            throw new IllegalArgumentException(String.valueOf(object2));
        }
        return object;
    }
}

