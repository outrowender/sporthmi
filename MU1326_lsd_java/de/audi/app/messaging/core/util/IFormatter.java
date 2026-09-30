/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

public interface IFormatter {
    public static final IFormatter SIMPLE_FORMATTER = new IFormatter(){

        public String format(Object object) {
            return String.valueOf(object);
        }
    };

    public String format(Object var1);
}

