/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

public interface ILockingListener {
    public void isLockingActive(boolean var1, boolean var2);

    public boolean isInterestedOnTimerEvents();
}

