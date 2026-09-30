/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.mapper;

import de.audi.tone.app.volume.mapper.IVolumeMapper;

public class DummyVolumeMapper
implements IVolumeMapper {
    public int mapModel2Volume(int n, int n2) {
        return n2;
    }

    public int mapModel2Volume(int n) {
        return n;
    }

    public int mapVolume2Model(int n) {
        return n;
    }

    public int mapModelVolumeRangeMin(int n) {
        return n;
    }

    public int mapModelVolumeRangeMax(int n) {
        return n;
    }
}

