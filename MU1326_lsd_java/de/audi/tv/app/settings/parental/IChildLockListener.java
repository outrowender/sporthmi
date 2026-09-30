/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.parental;

public interface IChildLockListener {
    public void onChildLockEnabled();

    public void onChildLockDisabled();

    public void parentalLevelSettingChanged(int var1);
}

