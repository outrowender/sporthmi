/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.store;

import de.audi.audio.store.ConnectionMap;
import de.esolutions.fw.util.commons.IntList;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

public final class ConnectionStore {
    public static final ConnectionStore INSTANCE = new ConnectionStore();
    private final SimpleIntIntMap terminalActiveConnMap = new SimpleIntIntMap(10);
    private final SimpleIntIntMap terminalActiveEntConnMap = new SimpleIntIntMap(10);
    private final ConnectionMap connStatusMap = new ConnectionMap(5);
    private final Object mutex = new Object();
    private final IntList autoFadeToListFrontDriver = new IntList(10);
    private final IntList autoFadeToListFrontPassenger = new IntList(10);
    private final IntList autoFadeToListRearLeft = new IntList(10);
    private final IntList autoFadeToListRearRight = new IntList(10);

    private ConnectionStore() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addAutoFadeToConnection(int n, int n2) {
        IntList intList = this.getAutoFadeToList(n2);
        Object object = this.mutex;
        synchronized (object) {
            if (!intList.contains(n)) {
                intList.add(n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeAutoFadeToConnection(int n, int n2) {
        IntList intList = this.getAutoFadeToList(n2);
        Object object = this.mutex;
        synchronized (object) {
            intList.removeElement(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isAutoFadeToConnection(int n, int n2) {
        IntList intList = this.getAutoFadeToList(n2);
        Object object = this.mutex;
        synchronized (object) {
            return intList.contains(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setStatus(int n, int n2, int n3) {
        Object object = this.mutex;
        synchronized (object) {
            this.connStatusMap.addStatus(n, n3, n2);
            if (n3 == 1) {
                this.connStatusMap.addStatus(n, 0, n2);
            } else if (n3 == 0) {
                this.connStatusMap.addStatus(n, 1, n2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getStatus(int n, int n2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.connStatusMap.getStatus(n, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clear() {
        Object object = this.mutex;
        synchronized (object) {
            this.connStatusMap.clear();
        }
        object = this.terminalActiveConnMap;
        synchronized (object) {
            this.terminalActiveConnMap.clear();
        }
        object = this.terminalActiveEntConnMap;
        synchronized (object) {
            this.terminalActiveEntConnMap.clear();
        }
    }

    public void setActiveConnection(int n, int n2) {
        this.addConnection(this.terminalActiveConnMap, n, n2);
    }

    public void setActiveEntertainmentConnection(int n, int n2) {
        this.addConnection(this.terminalActiveEntConnMap, n, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void addConnection(SimpleIntIntMap simpleIntIntMap, int n, int n2) {
        SimpleIntIntMap simpleIntIntMap2 = simpleIntIntMap;
        synchronized (simpleIntIntMap2) {
            simpleIntIntMap.add(n2, n);
            if (n2 == 1) {
                simpleIntIntMap.add(0, n);
            } else if (n2 == 0) {
                simpleIntIntMap.add(1, n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getActiveConnection(int n) {
        SimpleIntIntMap simpleIntIntMap = this.terminalActiveConnMap;
        synchronized (simpleIntIntMap) {
            int n2 = this.terminalActiveConnMap.get(n);
            if (n2 == -1) {
                n2 = 0;
            }
            return n2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getActiveEntertainmentConnection(int n) {
        SimpleIntIntMap simpleIntIntMap = this.terminalActiveEntConnMap;
        synchronized (simpleIntIntMap) {
            int n2 = this.terminalActiveEntConnMap.get(n);
            if (n2 == -1) {
                n2 = 0;
            }
            return n2;
        }
    }

    public boolean isActive(int n, int n2) {
        int n3 = this.getStatus(n, n2);
        switch (n3) {
            case 0: 
            case 1: 
            case 2: {
                return true;
            }
        }
        return false;
    }

    public boolean isInUse(int n, int n2) {
        return this.getStatus(n, n2) != 5;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int[] getActiveConnections(int n) {
        int[] nArray;
        Object object = this.mutex;
        synchronized (object) {
            nArray = this.connStatusMap.getConnections(n);
        }
        object = new IntList(nArray.length);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (!this.isActive(nArray[i2], n)) continue;
            ((IntList)object).add(nArray[i2]);
        }
        return ((IntList)object).toArray();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int[] getPausedConnections(int n) {
        int[] nArray;
        Object object = this.mutex;
        synchronized (object) {
            nArray = this.connStatusMap.getConnections(n);
        }
        object = new IntList(nArray.length);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n2 = this.getStatus(nArray[i2], n);
            if (n2 != 4) continue;
            ((IntList)object).add(nArray[i2]);
        }
        return ((IntList)object).toArray();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int[] getConnectionsInUse(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return this.connStatusMap.getConnections(n);
        }
    }

    private IntList getAutoFadeToList(int n) {
        switch (n) {
            case 0: 
            case 1: {
                return this.autoFadeToListFrontDriver;
            }
            case 2: {
                return this.autoFadeToListFrontPassenger;
            }
            case 3: {
                return this.autoFadeToListRearLeft;
            }
            case 4: {
                return this.autoFadeToListRearRight;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unknown audio terminal: ").append(n).toString());
    }
}

