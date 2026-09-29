/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.nbest;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.common.ISDSMapping;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.NBestUtils;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.HashMap;
import org.dsi.ifc.speechrec.GraphemicGroup;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.NBestListEntry;
import org.dsi.ifc.speechrec.NBestSlot;

public class NBestListPreprocessing {
    private LogChannel lc = Logger.getNBestLog();
    private byte nBestRuleType = 1;
    private final NBestList originalNBestList;
    private GraphemicGroup[] originalGraphGroups;
    private NBestList processedNBestList;
    private int[] ggIndexMapping = new int[0];
    private int[] entryIndexMapping = new int[0];

    public NBestListPreprocessing(NBestList nBestList) {
        this.originalNBestList = nBestList;
        this.processedNBestList = nBestList;
    }

    public NBestList preprocessNBestList(IFrameworkAccess iFrameworkAccess) {
        this.originalGraphGroups = this.originalNBestList.getGraphemicGroups() == null ? new GraphemicGroup[]{} : this.originalNBestList.getGraphemicGroups();
        NBestListEntry[] nBestListEntryArray = this.preprocessNBestListEntries();
        this.ggIndexMapping = NBestListPreprocessing.createIndexMapping(this.originalGraphGroups.length);
        GraphemicGroup[] graphemicGroupArray = this.preprocessGraphemicGroups();
        this.lc.log(-2137614336, "NBestUtils#preprocessEntries: ggIndexMapping=%1!", (Object)SDSUtils.toString(this.ggIndexMapping));
        this.decrementGraphmicGroupIndexes(nBestListEntryArray);
        NBestUtils.sortSlots(nBestListEntryArray, this.lc);
        nBestListEntryArray = this.removeInvalidEntries(nBestListEntryArray, iFrameworkAccess);
        this.processedNBestList = new NBestList(graphemicGroupArray, nBestListEntryArray, this.originalNBestList.getNBestListID());
        return this.processedNBestList;
    }

    private NBestListEntry[] preprocessNBestListEntries() {
        NBestListEntry[] nBestListEntryArray = this.originalNBestList.getEntries();
        if (nBestListEntryArray == null || nBestListEntryArray.length < 2) {
            return nBestListEntryArray;
        }
        this.entryIndexMapping = new int[nBestListEntryArray.length];
        int n = nBestListEntryArray.length;
        HashMap hashMap = new HashMap(n);
        for (int i2 = 0; i2 < n; ++i2) {
            NBestListEntry nBestListEntry = nBestListEntryArray[i2];
            int n2 = NBestUtils.containsFirstSlot(NBestUtils.getFirstSlot(nBestListEntry), hashMap, this.lc);
            if (n2 == -1) {
                int n3;
                this.entryIndexMapping[i2] = n3 = hashMap.size();
                hashMap.put(new Integer(n3), nBestListEntry);
                continue;
            }
            this.lc.log(-2137614336, "NBestUtils#preprocessEntries: Skipping curNBestListEntry #%2 %1!", (Object)nBestListEntry, (long)i2);
            this.entryIndexMapping[i2] = n2;
            this.decrementGraphemicGroupSize(nBestListEntry.graphemicGroupIndex);
        }
        return (NBestListEntry[])hashMap.values().toArray(new NBestListEntry[hashMap.size()]);
    }

    private NBestListEntry[] removeInvalidEntries(NBestListEntry[] nBestListEntryArray, IFrameworkAccess iFrameworkAccess) {
        if (SDSUtils.isEmpty(nBestListEntryArray)) {
            return nBestListEntryArray;
        }
        this.lc.log(-2137614336, "NBestUtils#removeInvalidEntries");
        int n = nBestListEntryArray.length;
        ArrayList arrayList = new ArrayList(n);
        ISDSMapping iSDSMapping = SDSManagerBaseActivator.getMapping();
        for (int i2 = 0; i2 < n; ++i2) {
            Object[] objectArray;
            NBestListEntry nBestListEntry = nBestListEntryArray[i2];
            int n2 = nBestListEntry.getGrammarId();
            if (iSDSMapping.isOneshotGrammar(n2) && iFrameworkAccess != null && iFrameworkAccess.isAsia()) {
                NBestSlot nBestSlot;
                int n3;
                objectArray = iSDSMapping.getSlotOrder(n2);
                Object object = objectArray[objectArray.length - 1];
                NBestSlot[] nBestSlotArray = nBestListEntry.getSlots();
                if (nBestSlotArray != null && (n3 = nBestSlotArray.length) > 0 && (nBestSlot = nBestSlotArray[n3 - 1]) != null && nBestSlot.getId() == object && SDSUtils.isEmpty(nBestSlot.getObjectStringId())) continue;
            }
            if (iSDSMapping.isSUIGrammar(n2)) {
                objectArray = nBestListEntry.getSlots();
                if (SDSUtils.isEmpty(objectArray) || objectArray[0] == null) continue;
                arrayList.add(nBestListEntry);
                continue;
            }
            arrayList.add(nBestListEntry);
        }
        return (NBestListEntry[])arrayList.toArray(new NBestListEntry[arrayList.size()]);
    }

    private GraphemicGroup[] preprocessGraphemicGroups() {
        int n = this.originalGraphGroups.length;
        ArrayList arrayList = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            GraphemicGroup graphemicGroup = this.originalGraphGroups[i2];
            if (graphemicGroup == null) {
                this.lc.log(-1601830656, "NBestUtils#preprocessGraphemicGroups: Empty curGraphGroupEntry #%1!", (long)i2);
                continue;
            }
            int n2 = graphemicGroup.getGraphemicGroupSize();
            this.lc.log(-2137614336, "NBestUtils#preprocessGraphemicGroups: curGraphGroupSize[%1]=%2!", (long)i2, (long)n2);
            if (n2 > 1) {
                arrayList.add(graphemicGroup);
                continue;
            }
            this.lc.log(-2137614336, "NBestUtils#preprocessGraphemicGroups: Decrementing subsequent indexMapping starting from %2 and skipping curGraphGroupEntry #%3 %1!", (Object)graphemicGroup, (long)(i2 + 1), (long)i2);
            this.ggIndexMapping[i2] = -1;
            for (int i3 = i2 + 1; i3 < n; ++i3) {
                int n3 = this.ggIndexMapping[i3];
                int n4 = i3;
                this.ggIndexMapping[n4] = this.ggIndexMapping[n4] - (n3 > -1 ? 1 : 0);
                this.lc.log(-2137614336, "NBestUtils#preprocessGraphemicGroups: curIndexMapping=%1, indexMapping[%2]=%3!", (long)n3, (long)i3, (long)this.ggIndexMapping[i3]);
            }
        }
        return (GraphemicGroup[])arrayList.toArray(new GraphemicGroup[arrayList.size()]);
    }

    private static int[] createIndexMapping(int n) {
        int[] nArray = new int[n];
        for (int i2 = 0; i2 < n; ++i2) {
            nArray[i2] = i2;
        }
        return nArray;
    }

    private void decrementGraphmicGroupIndexes(NBestListEntry[] nBestListEntryArray) {
        if (SDSUtils.isEmpty(nBestListEntryArray)) {
            return;
        }
        int n = nBestListEntryArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            NBestListEntry nBestListEntry = nBestListEntryArray[i2];
            if (nBestListEntry == null) continue;
            int n2 = nBestListEntry.getGraphemicGroupIndex();
            this.lc.log(-2137614336, "NBestUtils#decrementGraphmicGroupIndexes: curGGIndex=%1, indexMapping.length=%2!", (long)n2, (long)this.ggIndexMapping.length);
            if (n2 <= -1 || n2 >= this.ggIndexMapping.length) continue;
            this.lc.log(-2137614336, "NBestUtils#decrementGraphmicGroupIndexes: curGGIndex[%1]=%2, setting graphemicGroupIndex to %3!", (long)i2, (long)n2, (long)this.ggIndexMapping[n2]);
            nBestListEntry.graphemicGroupIndex = this.ggIndexMapping[n2];
        }
    }

    private void decrementGraphemicGroupSize(int n) {
        this.lc.log(-2137614336, "NBestUtils#decrementGraphemicGroupSize: ggIndex=%1!", (long)n);
        if (SDSUtils.isEmpty(this.originalGraphGroups)) {
            return;
        }
        int n2 = this.originalGraphGroups.length;
        if (n < 0) {
            this.lc.log(-2137614336, "NBestUtils#decrementGraphemicGroupSize: No GG member, ggIndex=%1 => NOP!", (long)n);
            return;
        }
        if (n >= n2) {
            this.lc.log(-1601830656, "NBestUtils#decrementGraphemicGroupSize: Invalid ggIndex=%1 >= len=%2 => NOP!", (long)n, (long)n2);
            return;
        }
        GraphemicGroup graphemicGroup = this.originalGraphGroups[n];
        this.lc.log(-2137614336, "NBestUtils#decrementGraphemicGroupSize: Decrementing size %1 of graphemic group #%2!", (long)graphemicGroup.graphemicGroupSize, (long)n);
        --graphemicGroup.graphemicGroupSize;
    }

    public int[] getGgIndexMapping() {
        return this.ggIndexMapping;
    }

    public NBestList getnBestList() {
        return this.processedNBestList;
    }

    public int[] getEntryIndexMapping() {
        return this.entryIndexMapping;
    }

    public byte getnBestRuleType() {
        return this.nBestRuleType;
    }

    public void setnBestRuleType(byte by) {
        this.nBestRuleType = by;
    }
}

