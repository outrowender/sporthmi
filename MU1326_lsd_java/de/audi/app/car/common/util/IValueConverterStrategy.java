/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.util;

public interface IValueConverterStrategy {
    default public Object getDSIValue(Object object) {
    }

    default public Object getHMIValue(Object object) {
    }
}

