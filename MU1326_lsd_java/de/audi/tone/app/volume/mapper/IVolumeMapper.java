/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.mapper;

public interface IVolumeMapper {
    public int mapModel2Volume(int var1, int var2);

    public int mapModel2Volume(int var1);

    public int mapVolume2Model(int var1);

    public int mapModelVolumeRangeMin(int var1);

    public int mapModelVolumeRangeMax(int var1);
}

