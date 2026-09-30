/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.grammar;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.grammar.DynamicSlotContent;
import de.audi.app.sdsmanager.grammar.IDynamicLists;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class DynamicLists
implements IDynamicLists {
    private static final String[] VALUES_LINES1_6 = new String[]{"1", "2", "3", "4", "5", "6"};
    private static final String[] VALUES_SD_CARDS = new String[]{"1", "2"};
    private final LogChannel lc = Logger.getGrammarLog();
    private Map lookupMap = new HashMap();

    public DynamicLists() {
        this.addToLookup(2, new DynamicSlotContent("values for list lines 1-6", VALUES_LINES1_6, 0));
        this.addToLookup(3, new DynamicSlotContent("values for SD cards", VALUES_SD_CARDS, 0));
    }

    public final synchronized void addToLookup(int n, DynamicSlotContent dynamicSlotContent) {
        this.lc.log(10000000, "DynamicLists#addToLookup: mappingKey=%1", (long)n);
        int n2 = SDSManagerBaseActivator.getMapping().getHMISlotGrammar(n);
        if (n2 == -1) {
            this.lc.log(100000, "DynamicLists#addToLookup: No key found for mappingKey #%1!", (long)n);
            return;
        }
        this.lc.log(10000000, "DynamicLists#addToLookup: Adding values for key #%2 (%1)!", (Object)(dynamicSlotContent != null ? dynamicSlotContent.getDescription() : "UNK"), (long)n2);
        this.lookupMap.put(new Integer(n2), dynamicSlotContent);
    }

    public synchronized void removeFromLookup(int n) {
        this.lc.log(10000000, "DynamicLists#removeFromLookup: mappingKey=%1", (long)n);
        int n2 = SDSManagerBaseActivator.getMapping().getHMISlotGrammar(n);
        if (n2 == -1) {
            this.lc.log(100000, "DynamicLists#removeFromLookup: No key found for mappingKey #%1!", (long)n);
            return;
        }
        DynamicSlotContent dynamicSlotContent = (DynamicSlotContent)this.lookupMap.remove(new Integer(n2));
        this.lc.log(10000000, "DynamicLists#removeFromLookup: Removed key #%2 (%1)!", (Object)(dynamicSlotContent != null ? dynamicSlotContent.getDescription() : "UNK"), (long)n2);
    }

    public synchronized String[] getDynListStrings(int n) {
        this.lc.log(10000000, "DynamicLists#getDynListStrings: key=%1", (long)n);
        Integer n2 = new Integer(n);
        if (!this.lookupMap.containsKey(n2)) {
            this.lc.log(100000, "DynamicLists#getDynListStrings: Slot key %1 not found!", (long)n);
            return null;
        }
        DynamicSlotContent dynamicSlotContent = (DynamicSlotContent)this.lookupMap.get(n2);
        if (dynamicSlotContent == null) {
            this.lc.log(100000, "DynamicLists#getDynListStrings: No ID entries for key #%1!", (long)n);
            return null;
        }
        SDSListEntry[] sDSListEntryArray = dynamicSlotContent.getEntries();
        if (sDSListEntryArray == null) {
            this.lc.log(100000, "DynamicLists#getDynListStrings: Empty ID entries for key #%1!", (long)n);
            return null;
        }
        int n3 = sDSListEntryArray.length;
        String[] stringArray = new String[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            stringArray[i2] = sDSListEntryArray[i2].getName();
        }
        return stringArray;
    }

    public synchronized boolean contains(int n) {
        this.lc.log(10000000, "DynamicLists#contains: key=%1", (long)n);
        return this.lookupMap.containsKey(new Integer(n));
    }

    public synchronized long[] getDynListIDs(int n) {
        this.lc.log(10000000, "DynamicLists#getDynListIDs: key=%1", (long)n);
        Integer n2 = new Integer(n);
        if (!this.lookupMap.containsKey(n2)) {
            this.lc.log(100000, "DynamicLists#getDynListIDs: Slot key %1 not found!", (long)n);
            return null;
        }
        DynamicSlotContent dynamicSlotContent = (DynamicSlotContent)this.lookupMap.get(n2);
        if (dynamicSlotContent == null) {
            this.lc.log(100000, "DynamicLists#getDynListIDs: No ID entries for key #%1!", (long)n);
            return null;
        }
        SDSListEntry[] sDSListEntryArray = dynamicSlotContent.getEntries();
        if (sDSListEntryArray == null) {
            this.lc.log(100000, "DynamicLists#getDynListIDs: Empty ID entries for key #%1!", (long)n);
            return null;
        }
        int n3 = sDSListEntryArray.length;
        long[] lArray = new long[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            lArray[i2] = sDSListEntryArray[i2].getId();
        }
        return lArray;
    }

    public synchronized boolean isSlotContentNew(int n) {
        this.lc.log(10000000, "DynamicLists#isSlotContNew: key=%1", (long)n);
        Integer n2 = new Integer(n);
        if (!this.lookupMap.containsKey(n2)) {
            this.lc.log(100000, "DynamicLists#isSlotContNew: Slot key %1 not found!", (long)n);
            return false;
        }
        DynamicSlotContent dynamicSlotContent = (DynamicSlotContent)this.lookupMap.get(n2);
        if (dynamicSlotContent == null) {
            this.lc.log(100000, "DynamicLists#isSlotContNew: No value for key %1!", (long)n);
            return false;
        }
        if (dynamicSlotContent.getEntries() == null) {
            this.lc.log(100000, "DynamicLists#isSlotContNew: No ID entries for key %1!", (long)n);
        }
        return dynamicSlotContent.getStatus() != 2;
    }

    public synchronized void setSlotContentStatus(int n, byte by) {
        this.lc.log(10000000, "DynamicLists#setSlotContentStatus: key=%1, status=%2", (long)n, (long)by);
        Integer n2 = new Integer(n);
        if (!this.lookupMap.containsKey(n2)) {
            this.lc.log(100000, "DynamicLists#setSlotContentStatus: Slot key %1 not found!", (long)n);
            return;
        }
        DynamicSlotContent dynamicSlotContent = (DynamicSlotContent)this.lookupMap.get(n2);
        if (dynamicSlotContent == null || dynamicSlotContent.getEntries() == null) {
            this.lc.log(100000, "DynamicLists#setSlotContentStatus: No ID entries for key #%1!", (long)n);
            return;
        }
        dynamicSlotContent.setStatus(by);
    }

    public synchronized void markAllSlotsAsLoaded(boolean bl) {
        this.lc.log(10000000, "DynamicLists#markAllSlotsAsLoaded: loadSuccess=%1", bl);
        int[] nArray = SDSManagerBaseActivator.getMapping().getHMISlotGrammarArray();
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            Integer n2 = new Integer(nArray[i2]);
            DynamicSlotContent dynamicSlotContent = (DynamicSlotContent)this.lookupMap.get(n2);
            if (dynamicSlotContent == null || dynamicSlotContent.getStatus() != 1) continue;
            dynamicSlotContent.setStatus(bl ? (byte)2 : 0);
            this.lc.log(10000000, "DynamicLists#markAllSlotsAsLoaded: Changed status of slot %1 from NEW_AND_TO_BE_LOADED to %2!", (Object)n2, (Object)(bl ? "OLD" : "NEW"));
        }
    }

    public synchronized SortedSet resetLoadedSlotRuleIDs() {
        this.lc.log(10000000, "DynamicLists#resetLoadedSlotRuleIDs: called");
        HashMap hashMap = new HashMap();
        int[] nArray = SDSManagerBaseActivator.getMapping().getHMISlotGrammarArray();
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            Integer n2 = new Integer(nArray[i2]);
            DynamicSlotContent dynamicSlotContent = (DynamicSlotContent)this.lookupMap.get(n2);
            if (dynamicSlotContent == null || dynamicSlotContent.getStatus() != 2) continue;
            dynamicSlotContent.setStatus((byte)0);
            hashMap.put(n2, dynamicSlotContent);
            this.lc.log(10000000, "DynamicLists#resetLoadedSlotRuleIDs: Added values for key #%1!", (Object)n2);
        }
        return new TreeSet(hashMap.keySet());
    }

    public String toString() {
        Iterator iterator = this.lookupMap.keySet().iterator();
        Buffer buffer = new Buffer("DynamicLists:\n");
        while (iterator.hasNext()) {
            Integer n = (Integer)iterator.next();
            DynamicSlotContent dynamicSlotContent = (DynamicSlotContent)this.lookupMap.get(n);
            String string = dynamicSlotContent != null ? dynamicSlotContent.getDescription().toUpperCase() : "UNK";
            buffer.append("grammarID: ").append(n).append(" (").append(string).append("), content:\n").append(dynamicSlotContent).append('\n');
        }
        return buffer.toString();
    }
}

