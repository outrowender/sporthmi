/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.lists.NormAreaSublist$Key;
import de.audi.tv.app.lists.NormAreaSublist$StorageDataContainer;
import de.audi.tv.app.lists.NormAreaSublist$TVEventListener;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.IntList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class NormAreaSublist {
    private static final int VERSION;
    private final Map map = new HashMap(100);
    private final NormAreaSublist$StorageDataContainer container;
    private final LogChannel lc;
    private final TVEnv env;
    private final DSITV dsi;
    public final ITVEventListener tvStatusListener = new NormAreaSublist$TVEventListener(this, null);

    public NormAreaSublist(TVEnv tVEnv, DSITV dSITV) {
        this.dsi = dSITV;
        this.lc = tVEnv.lcMain;
        this.env = tVEnv;
        this.container = new NormAreaSublist$StorageDataContainer(this, tVEnv.framework.getStorageMgr());
    }

    synchronized void init() {
        this.container.readAndDeserialize();
        this.dsi.setNormAreaSubList(this.getNormAreas());
    }

    synchronized void add(ServiceInfo serviceInfo) {
        this.add(serviceInfo, this.env.getChoiceModel(1772889856).getValue());
    }

    synchronized void add(ServiceInfo serviceInfo, int n) {
        this.map.put(new NormAreaSublist$Key(serviceInfo), new Integer(n));
        this.setNormAreaSubList();
    }

    synchronized void remove(ServiceInfo serviceInfo) {
        this.map.remove(new NormAreaSublist$Key(serviceInfo));
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
        NormAreaSublist$Key[] normAreaSublist$KeyArray;
        Buffer buffer = new Buffer(1000);
        NormAreaSublist normAreaSublist = this;
        synchronized (normAreaSublist) {
            normAreaSublist$KeyArray = (NormAreaSublist$Key[])this.map.keySet().toArray(new NormAreaSublist$Key[this.map.size()]);
            integerArray = (Integer[])this.map.entrySet().toArray(new Integer[this.map.size()]);
        }
        for (int i2 = 0; i2 < normAreaSublist$KeyArray.length; ++i2) {
            buffer.append("\n[").append(i2).append("] ").append(normAreaSublist$KeyArray[i2]).append(": ").append(integerArray[i2]);
        }
        return buffer.toString();
    }

    static /* synthetic */ LogChannel access$100(NormAreaSublist normAreaSublist) {
        return normAreaSublist.lc;
    }

    static /* synthetic */ Map access$200(NormAreaSublist normAreaSublist) {
        return normAreaSublist.map;
    }
}

