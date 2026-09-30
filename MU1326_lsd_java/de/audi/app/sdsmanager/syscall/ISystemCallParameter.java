/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.syscall;

public interface ISystemCallParameter {
    public static final int TYPE_BOOL = 1;
    public static final int TYPE_INT = 2;
    public static final int TYPE_STRING = 3;
    public static final boolean DEFAULT_BOOL = false;
    public static final int DEFAULT_INT = -1;
    public static final String DEFAULT_STRING = "";

    public int getType();

    public Object getValue();

    public boolean getBoolean();

    public int getInteger();

    public String getString();
}

