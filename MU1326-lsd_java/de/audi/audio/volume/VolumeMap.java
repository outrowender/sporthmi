/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.volume;

import de.esolutions.fw.util.commons.SimpleIntIntMap;

public final class VolumeMap {
    public static final VolumeMap INSTANCE = new VolumeMap();
    private final SimpleIntIntMap frontMap = new SimpleIntIntMap(100);
    private final SimpleIntIntMap rearLeftMap = new SimpleIntIntMap(100);
    private final SimpleIntIntMap rearRightMap = new SimpleIntIntMap(100);
    private final Object mutex = new Object();

    private VolumeMap() {
        this.frontMap.add(8, 0);
        this.rearLeftMap.add(8, 0);
        this.rearRightMap.add(8, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setVolume(int n, int n2, int n3) {
        Object object = this.mutex;
        synchronized (object) {
            this.getMapByAT(n2).add(n, n3);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getVolume(int n, int n2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.getMapByAT(n).get(n2);
        }
    }

    private SimpleIntIntMap getMapByAT(int n) {
        switch (n) {
            case 3: {
                return this.rearLeftMap;
            }
            case 4: {
                return this.rearRightMap;
            }
        }
        return this.frontMap;
    }
}

