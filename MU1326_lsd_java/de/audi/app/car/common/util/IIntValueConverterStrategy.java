/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.util;

import de.audi.app.car.common.exception.ValueConverterStrategyException;

public interface IIntValueConverterStrategy {
    public int getDSIValue(int var1) throws ValueConverterStrategyException;

    public int getHMIValue(int var1) throws ValueConverterStrategyException;
}

