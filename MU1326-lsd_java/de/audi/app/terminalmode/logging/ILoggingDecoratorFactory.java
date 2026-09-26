/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

public interface ILoggingDecoratorFactory {
    default public Object wrap(Class clazz, Object object) {
    }

    default public Object wrap(String string, Object object) {
    }
}

