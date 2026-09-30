/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.bap.timer;

public interface Timer {
    public void retrigger(int var1);

    public void stop();

    public boolean isRunning();

    public void setUserInfo(int var1);
}

