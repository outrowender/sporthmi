/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.power;

public interface PowerEventListener {
    public void notifyPowerListenerOnEnterState(int var1, int var2);

    public void notifyPowerListenerOnExitState(int var1, int var2);

    public void notifyPowerTriggerAction(int var1, int var2);

    public void updateClampState(boolean var1, boolean var2, boolean var3, boolean var4);
}

