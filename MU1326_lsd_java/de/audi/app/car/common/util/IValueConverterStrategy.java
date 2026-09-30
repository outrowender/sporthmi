/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.util;

import de.audi.app.car.common.exception.ValueConverterStrategyException;

public interface IValueConverterStrategy {
    public Object getDSIValue(Object var1) throws ValueConverterStrategyException;

    public Object getHMIValue(Object var1) throws ValueConverterStrategyException;
}

