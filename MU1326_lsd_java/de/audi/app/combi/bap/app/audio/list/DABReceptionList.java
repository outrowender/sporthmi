/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DABReceptionList {
    private final LogChannel logChannel;
    private final String className;
    private final List dabEnsembles = new ArrayList(10);
    private final Map dabEnsembleIDToPrimaryServicesMapping = new HashMap();
    private final Map dabPrimaryServiceIDToSecondaryServicesMapping = new HashMap();

    public DABReceptionList(LogChannel logChannel, String string) {
        this.logChannel = logChannel;
        this.className = string;
    }

    public synchronized void buildDABListStructure(CombiBAPReceptionListEntry[] combiBAPReceptionListEntryArray) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        ArrayList arrayList = new ArrayList(10);
        this.dabEnsembleIDToPrimaryServicesMapping.put(new Integer(n), arrayList);
        block5: for (int i2 = 0; i2 < combiBAPReceptionListEntryArray.length; ++i2) {
            CombiBAPReceptionListEntry combiBAPReceptionListEntry = combiBAPReceptionListEntryArray[i2];
            combiBAPReceptionListEntry.setAbsPos(i2 + 1);
            switch (combiBAPReceptionListEntry.getType()) {
                case 2: {
                    this.dabEnsembles.add(combiBAPReceptionListEntry);
                    n = combiBAPReceptionListEntry.getPosID();
                    n2 = i2 + 1;
                    continue block5;
                }
                case 3: {
                    List list;
                    if (n != 0) {
                        list = (List)this.dabEnsembleIDToPrimaryServicesMapping.get(new Integer(n));
                        if (list == null) {
                            list = new ArrayList(10);
                            this.dabEnsembleIDToPrimaryServicesMapping.put(new Integer(n), list);
                        }
                        combiBAPReceptionListEntry.setDABEnsembleID(n);
                        combiBAPReceptionListEntry.setDABEnsembleAbsPos(n2);
                        list.add(combiBAPReceptionListEntry);
                    }
                    arrayList.add(combiBAPReceptionListEntry);
                    n3 = combiBAPReceptionListEntry.getPosID();
                    continue block5;
                }
                case 4: {
                    List list = (List)this.dabPrimaryServiceIDToSecondaryServicesMapping.get(new Integer(n3));
                    if (list == null) {
                        list = new ArrayList(10);
                        this.dabPrimaryServiceIDToSecondaryServicesMapping.put(new Integer(n3), list);
                    }
                    combiBAPReceptionListEntry.setDABEnsembleID(n3);
                    combiBAPReceptionListEntry.setDABEnsembleAbsPos(n2);
                    list.add(combiBAPReceptionListEntry);
                    continue block5;
                }
                default: {
                    this.logChannel.log(10000, "[%1#buildDABListStructure] invalid element type for DAB list: %2", (Object)this.className, (long)combiBAPReceptionListEntry.getType());
                }
            }
        }
    }

    public synchronized List getDABFlatList(boolean bl, boolean bl2, boolean bl3) {
        List list;
        if (bl) {
            if (bl2) {
                ArrayList arrayList = new ArrayList(20);
                Iterator iterator = this.dabEnsembles.iterator();
                while (iterator.hasNext()) {
                    CombiBAPReceptionListEntry combiBAPReceptionListEntry = (CombiBAPReceptionListEntry)iterator.next();
                    arrayList.add(combiBAPReceptionListEntry);
                    arrayList.addAll(this.getDABServiceList(combiBAPReceptionListEntry.getPosID(), bl3));
                }
                list = arrayList;
            } else {
                list = new ArrayList(this.dabEnsembles);
            }
        } else if (bl2 || bl3) {
            list = this.getDABServiceList(0, bl3);
        } else {
            this.logChannel.log(100000, "[%1#getDABFlatList] include neither ensembles nor services -> return empty list", (Object)this.className);
            list = new ArrayList(1);
        }
        return list;
    }

    public synchronized List getDABServiceList(int n, boolean bl) {
        ArrayList arrayList;
        List list = (List)this.dabEnsembleIDToPrimaryServicesMapping.get(new Integer(n));
        if (list != null) {
            if (bl) {
                arrayList = new ArrayList(10);
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    CombiBAPReceptionListEntry combiBAPReceptionListEntry = (CombiBAPReceptionListEntry)iterator.next();
                    arrayList.add(combiBAPReceptionListEntry);
                    List list2 = (List)this.dabPrimaryServiceIDToSecondaryServicesMapping.get(new Integer(combiBAPReceptionListEntry.getPosID()));
                    if (list2 == null) continue;
                    arrayList.addAll(list2);
                }
            } else {
                arrayList = new ArrayList(list);
            }
        } else {
            this.logChannel.log(10000, "[%1#getDABServiceList] no ensemble with ID=%2 found", (Object)this.className, (long)n);
            arrayList = new ArrayList(1);
        }
        return arrayList;
    }

    public synchronized boolean isEmpty() {
        return this.dabEnsembles.isEmpty();
    }

    public synchronized void clear() {
        this.dabEnsembles.clear();
        this.dabEnsembleIDToPrimaryServicesMapping.clear();
        this.dabPrimaryServiceIDToSecondaryServicesMapping.clear();
    }
}

