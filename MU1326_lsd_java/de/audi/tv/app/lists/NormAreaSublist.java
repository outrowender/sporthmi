/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.dsi.DSITV;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.IntList;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class NormAreaSublist {
    private static final int VERSION = 1;
    private final Map map = new HashMap(100);
    private final StorageDataContainer container;
    private final LogChannel lc;
    private final TVEnv env;
    private final DSITV dsi;
    public final ITVEventListener tvStatusListener = new TVEventListener();

    public NormAreaSublist(TVEnv tVEnv, DSITV dSITV) {
        this.dsi = dSITV;
        this.lc = tVEnv.lcMain;
        this.env = tVEnv;
        this.container = new StorageDataContainer(tVEnv.framework.getStorageMgr());
    }

    synchronized void init() {
        this.container.readAndDeserialize();
        this.dsi.setNormAreaSubList(this.getNormAreas());
    }

    synchronized void add(ServiceInfo serviceInfo) {
        this.add(serviceInfo, this.env.getChoiceModel(2600041).getValue());
    }

    synchronized void add(ServiceInfo serviceInfo, int n) {
        this.map.put(new Key(serviceInfo), new Integer(n));
        this.setNormAreaSubList();
    }

    synchronized void remove(ServiceInfo serviceInfo) {
        this.map.remove(new Key(serviceInfo));
        this.setNormAreaSubList();
    }

    synchronized void clear() {
        this.map.clear();
        this.setNormAreaSubList();
    }

    private void setNormAreaSubList() {
        this.dsi.setNormAreaSubList(this.getNormAreas());
        this.container.serializeAndWrite();
    }

    private int[] getNormAreas() {
        HashSet hashSet = new HashSet(this.map.values());
        IntList intList = new IntList(hashSet.size());
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            intList.add((Integer)iterator.next());
        }
        return intList.toArray();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        Integer[] integerArray;
        Key[] keyArray;
        Buffer buffer = new Buffer(1000);
        NormAreaSublist normAreaSublist = this;
        synchronized (normAreaSublist) {
            keyArray = (Key[])this.map.keySet().toArray(new Key[this.map.size()]);
            integerArray = (Integer[])this.map.entrySet().toArray(new Integer[this.map.size()]);
        }
        for (int i2 = 0; i2 < keyArray.length; ++i2) {
            buffer.append("\n[").append(i2).append("] ").append(keyArray[i2]).append(": ").append(integerArray[i2]);
        }
        return buffer.toString();
    }

    private static class Key {
        final long namePID;
        final int servicePID;
        final int sType;

        Key(ServiceInfo serviceInfo) {
            this(serviceInfo.namePID, serviceInfo.servicePID, serviceInfo.sType);
        }

        Key(long l, int n, int n2) {
            this.namePID = l;
            this.servicePID = n;
            this.sType = n2;
        }

        public int hashCode() {
            int n = 1;
            n = 31 * n + (int)(this.namePID ^ this.namePID >>> 32);
            n = 31 * n + this.sType;
            n = 31 * n + this.servicePID;
            return n;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (!(object instanceof Key)) {
                return false;
            }
            Key key = (Key)object;
            if (this.namePID != key.namePID) {
                return false;
            }
            if (this.sType != key.sType) {
                return false;
            }
            return this.servicePID == key.servicePID;
        }

        public String toString() {
            return new Buffer().append(this.namePID).append(',').append(this.servicePID).append(',').append(this.sType).toString();
        }
    }

    private class TVEventListener
    extends TVEventDefaultListener {
        private TVEventListener() {
        }

        public void onTunerAvailable() {
            NormAreaSublist.this.init();
        }
    }

    private class StorageDataContainer
    extends AbstractStorageDataContainer {
        StorageDataContainer(IStorageAccess iStorageAccess) {
            super(iStorageAccess, 1, 1007, 49);
        }

        protected void handleCRC32Error() {
            NormAreaSublist.this.lc.log(10000, "[NormAreaStore.handleCRC32Error]");
        }

        protected void handleStorageReadError(Exception exception) {
            NormAreaSublist.this.lc.log(100000, "[NormAreaStore.handleStorageReadError] %1", (Object)exception.toString());
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            NormAreaSublist.this.lc.log(100000, "[NormAreaStore.convertContainer] persistedVersion:%1 containerVersion:%2", (long)n, (long)n2);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            NormAreaSublist normAreaSublist = NormAreaSublist.this;
            synchronized (normAreaSublist) {
                int n = NormAreaSublist.this.map.size();
                Key[] keyArray = (Key[])NormAreaSublist.this.map.keySet().toArray(new Key[n]);
                Integer[] integerArray = (Integer[])NormAreaSublist.this.map.values().toArray(new Integer[n]);
                dataOutputStream.writeInt(n);
                for (int i2 = 0; i2 < n; ++i2) {
                    dataOutputStream.writeLong(keyArray[i2].namePID);
                    dataOutputStream.writeInt(keyArray[i2].servicePID);
                    dataOutputStream.writeInt(keyArray[i2].sType);
                    dataOutputStream.writeInt(integerArray[i2]);
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            NormAreaSublist normAreaSublist = NormAreaSublist.this;
            synchronized (normAreaSublist) {
                NormAreaSublist.this.map.clear();
                int n = dataInputStream.readInt();
                for (int i2 = 0; i2 < n; ++i2) {
                    long l = dataInputStream.readLong();
                    int n2 = dataInputStream.readInt();
                    int n3 = dataInputStream.readInt();
                    int n4 = dataInputStream.readInt();
                    NormAreaSublist.this.map.put(new Key(l, n2, n3), new Integer(n4));
                }
            }
        }
    }
}

