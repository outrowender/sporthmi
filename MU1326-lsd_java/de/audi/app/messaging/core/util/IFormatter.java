/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

import de.audi.app.messaging.core.util.IFormatter$1;

public interface IFormatter {
    public static final IFormatter SIMPLE_FORMATTER = new IFormatter$1();

    default public String format(Object object) {
    }
}

