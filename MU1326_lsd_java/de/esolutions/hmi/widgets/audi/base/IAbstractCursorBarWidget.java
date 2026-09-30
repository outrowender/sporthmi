/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

public interface IAbstractCursorBarWidget {
    public static final int WAIT_TYPE_PRESS = 0;
    public static final int WAIT_TYPE_SCROLL_UP = 1;
    public static final int WAIT_TYPE_SCROLL_DOWN = 2;

    public void startWaitAnimation(int var1);
}

