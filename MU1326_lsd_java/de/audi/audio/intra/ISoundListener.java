/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.intra;

public interface ISoundListener {
    public void updateActiveAmplifiers(int var1);

    public void updateVolumeRange(int var1, int var2);

    public void updateVolume(int var1, int var2, int var3);

    public void menuVolumeRange(int var1, int var2, int var3, int var4);
}

