/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.syscall;

public interface ISystemCallParameter {
    public static final int TYPE_BOOL;
    public static final int TYPE_INT;
    public static final int TYPE_STRING;
    public static final boolean DEFAULT_BOOL;
    public static final int DEFAULT_INT;
    public static final String DEFAULT_STRING;

    default public int getType() {
    }

    default public Object getValue() {
    }

    default public boolean getBoolean() {
    }

    default public int getInteger() {
    }

    default public String getString() {
    }
}

