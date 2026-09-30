/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

public interface IBalFadeTouchpadConfig {
    public String bftp_getConfigs();

    public String bftp_getKbType();

    public void bftp_setTouchSensitivity(float var1, float var2);

    public void bftp_setLockBreakDist(float var1, float var2, float var3);
}

