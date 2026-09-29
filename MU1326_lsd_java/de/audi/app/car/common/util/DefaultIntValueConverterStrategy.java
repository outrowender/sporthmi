/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.util;

import de.audi.app.car.common.util.IIntValueConverterStrategy;

public class DefaultIntValueConverterStrategy
implements IIntValueConverterStrategy {
    @Override
    public int getDSIValue(int n) {
        return n;
    }

    @Override
    public int getHMIValue(int n) {
        return n;
    }
}

