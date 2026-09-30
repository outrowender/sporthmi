/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.util;

import de.audi.app.car.common.exception.ValueConverterStrategyException;
import de.audi.app.car.common.util.IIntValueConverterStrategy;

public class DefaultIntValueConverterStrategy
implements IIntValueConverterStrategy {
    public int getDSIValue(int n) throws ValueConverterStrategyException {
        return n;
    }

    public int getHMIValue(int n) throws ValueConverterStrategyException {
        return n;
    }
}

