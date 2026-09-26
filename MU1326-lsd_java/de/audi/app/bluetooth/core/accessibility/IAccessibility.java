/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.accessibility;

public interface IAccessibility {
    public static final int ACCESSIBILITY_VISIBLE;
    public static final int ACCESSIBILITY_INVISIBLE;
    public static final int ACCESSIBILITY_BT_OFF;
    public static final int ACCESSIBILITY_BT_ON;

    default public void activateBluetooth() {
    }

    default public void setAccessibleMode(int n) {
    }
}

