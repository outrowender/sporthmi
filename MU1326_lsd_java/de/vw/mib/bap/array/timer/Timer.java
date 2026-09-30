/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.timer;

public interface Timer {
    public void retrigger(Object var1);

    public void stop();

    public boolean isRunning();

    public void setUserInfo(Object var1);

    public Object getUserInfo();
}

