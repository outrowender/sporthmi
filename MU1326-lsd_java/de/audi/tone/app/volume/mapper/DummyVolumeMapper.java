/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.mapper;

import de.audi.tone.app.volume.mapper.IVolumeMapper;

public class DummyVolumeMapper
implements IVolumeMapper {
    @Override
    public int mapModel2Volume(int n, int n2) {
        return n2;
    }

    @Override
    public int mapModel2Volume(int n) {
        return n;
    }

    @Override
    public int mapVolume2Model(int n) {
        return n;
    }

    @Override
    public int mapModelVolumeRangeMin(int n) {
        return n;
    }

    @Override
    public int mapModelVolumeRangeMax(int n) {
        return n;
    }
}

