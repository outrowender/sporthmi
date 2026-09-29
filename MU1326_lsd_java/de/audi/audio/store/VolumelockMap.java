/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.store;

import de.esolutions.fw.util.commons.IntList;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

public class VolumelockMap {
    public static final VolumelockMap INSTANCE = new VolumelockMap();
    private final SimpleIntObjectMap map = new SimpleIntObjectMap();
    private final IntList connectionList = new IntList(50);
    private final Object mutex = new Object();

    VolumelockMap() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean setStatus(int n, int n2, boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            int n3 = this.createKey(n, n2);
            if (bl) {
                this.map.add(n3, bl);
            } else {
                this.map.remove(n3);
            }
            if (!this.connectionList.contains(n)) {
                this.connectionList.add(n);
            }
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isActive(int n, int n2) {
        Object object = this.mutex;
        synchronized (object) {
            int n3 = this.createKey(n, n2);
            return this.getStatus(n3);
        }
    }

    private Boolean getStatus(int n) {
        Object object = this.map.get(n);
        return object == null ? Boolean.FALSE : (Boolean)object;
    }

    private int createKey(int n, int n2) {
        return n2 * 1000 + n;
    }
}

