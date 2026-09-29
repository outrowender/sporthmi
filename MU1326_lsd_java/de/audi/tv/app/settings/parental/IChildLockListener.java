/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.parental;

public interface IChildLockListener {
    default public void onChildLockEnabled() {
    }

    default public void onChildLockDisabled() {
    }

    default public void parentalLevelSettingChanged(int n) {
    }
}

