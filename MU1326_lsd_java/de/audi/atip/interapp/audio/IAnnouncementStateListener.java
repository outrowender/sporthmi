/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio;

public interface IAnnouncementStateListener {
    public static final int PHONE = 0;
    public static final int NAVI = 1;
    public static final int TUNER = 2;

    public void updateAnnouncementState(int var1, int var2);
}

