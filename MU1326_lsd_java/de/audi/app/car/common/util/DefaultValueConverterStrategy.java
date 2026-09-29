/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.util;

import de.audi.app.car.common.util.IValueConverterStrategy;

public class DefaultValueConverterStrategy
implements IValueConverterStrategy {
    @Override
    public Object getDSIValue(Object object) {
        return object;
    }

    @Override
    public Object getHMIValue(Object object) {
        return object;
    }
}

