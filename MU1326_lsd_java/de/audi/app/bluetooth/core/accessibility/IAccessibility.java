/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.accessibility;

public interface IAccessibility {
    public static final int ACCESSIBILITY_VISIBLE = 0;
    public static final int ACCESSIBILITY_INVISIBLE = 1;
    public static final int ACCESSIBILITY_BT_OFF = 2;
    public static final int ACCESSIBILITY_BT_ON = 3;

    public void activateBluetooth();

    public void setAccessibleMode(int var1);
}

