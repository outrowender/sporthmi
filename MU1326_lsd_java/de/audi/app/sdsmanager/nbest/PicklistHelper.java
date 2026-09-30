/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.nbest;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestListPreprocessing;
import de.audi.app.sdsmanager.nbest.NBestUtils;
import de.audi.app.sdsmanager.nbest.Picklist;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Arrays;
import org.dsi.ifc.speechrec.GraphemicGroup;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.NBestListEntry;
import org.dsi.ifc.speechrec.NBestSlot;

public class PicklistHelper {
    private static final int PICKLIST_LENGTH = 5;
    private LogChannel lc = Logger.getNBestLog();
    private IPicklist flatPicklist = new Picklist();
    private IPicklist mixedPicklist = new Picklist();
    private IPicklist multislotPicklist = new Picklist();

    private int retrieveNoGGEntriesSize(NBestListEntry[] nBestListEntryArray, int n, int n2) {
        this.lc.log(10000000, "PicklistHelper#retrieveNoGGEntriesSize: nBestLength=%1, graphGroupNumber=%2", (long)n, (long)n2);
        int n3 = 0;
        for (int i2 = 0; i2 < n; ++i2) {
            NBestListEntry nBestListEntry = nBestListEntryArray[i2];
            if (nBestListEntry == null || nBestListEntry.getGraphemicGroupIndex() != -1 && n2 != 0) continue;
            ++n3;
        }
        return n3;
    }

    private int retrieveAssumedGGEntriesSize(GraphemicGroup[] graphemicGroupArray, int n) {
        this.lc.log(10000000, "PicklistHelper#retrieveAssumedGGEntriesSize: graphGroupLength=%1", (long)n);
        int n2 = 0;
        for (int i2 = 0; i2 < n; ++i2) {
            n2 += graphemicGroupArray[i2].getGraphemicGroupSize();
        }
        return n2;
    }

    public void createPicklists(NBestListPreprocessing nBestListPreprocessing) {
        NBestList nBestList = nBestListPreprocessing.getnBestList();
        int[] nArray = nBestListPreprocessing.getGgIndexMapping();
        byte by = nBestListPreprocessing.getnBestRuleType();
        NBestListEntry[] nBestListEntryArray = nBestList.getEntries();
        GraphemicGroup[] graphemicGroupArray = nBestList.getGraphemicGroups();
        int n = graphemicGroupArray.length;
        int n2 = nBestListEntryArray.length;
        this.lc.log(10000000, "PicklistHelper#createPicklists: ruleType=%1, graphGroupLength=%2, nBestLength=%3", (long)by, (long)n, (long)n2);
        int n3 = this.retrieveNoGGEntriesSize(nBestListEntryArray, n2, n);
        if (n == 1 && n3 == 0) {
            SDSModelAccess.setNBestGGContent(1);
        }
        int n4 = this.retrieveAssumedGGEntriesSize(graphemicGroupArray, n);
        this.lc.log(10000000, "PicklistHelper#createPicklists: noGGEntriesSize=%1, assumedGGEntriesSize=%2!", (long)n3, (long)n4);
        boolean bl = n4 + n3 != n2;
        boolean bl2 = !bl && (n2 <= 5 || n == 0 || graphemicGroupArray[0].getGraphemicGroupSize() == n2 || by == 2);
        this.lc.log(10000000, "PicklistHelper#createPicklists: isUnresolvedSpellingRecog=%1, isFlatList=%2!", bl, bl2);
        this.flatPicklist = this.prepareFlatList(nBestListEntryArray, nBestListPreprocessing.getEntryIndexMapping());
        this.mixedPicklist = bl2 ? this.flatPicklist : this.prepareMixedView(nBestListEntryArray, graphemicGroupArray, nArray, n, n3);
        this.multislotPicklist = by == 2 ? this.flatPicklist : this.multislotPicklist;
        this.lc.log(10000000, "PicklistHelper#createPicklists: Flat picklist:\n%1\nMixed picklist:\n%2\nMulti-slot picklist:\n%3", (Object)this.flatPicklist, (Object)this.mixedPicklist, (Object)this.multislotPicklist);
        this.handleSpokenGGTitle(nBestListEntryArray[0].getGraphemicGroupIndex(), n, n2);
    }

    private void handleSpokenGGTitle(int n, int n2, int n3) {
        this.lc.log(10000000, "PicklistHelper#handleSpokenGGTitle: selectedGGIndex=%1, graphGroupNumber=%2, nBestSize=%3", (long)n, (long)n2, (long)n3);
        if (n2 == 0 && n3 > 0 && n != -1) {
            this.flatPicklist.setLastRecogLine(false, n);
            this.mixedPicklist.setLastRecogLine(false, n);
        }
    }

    void filterPicklistDuplicates() {
        Object object;
        int n;
        int n2 = this.flatPicklist.getSize();
        ArrayList arrayList = new ArrayList(n2);
        boolean bl = false;
        for (n = 0; n < n2; ++n) {
            object = this.flatPicklist.get(n);
            if (!NBestUtils.containsFirstSlotID(NBestUtils.getFirstSlot((IPicklistElement)object), arrayList, this.lc)) {
                arrayList.add(object);
                continue;
            }
            bl = true;
            this.lc.log(10000000, "PicklistHelper#filterPicklistDuplicates: Skipping curElement #%2 %1!", object, (long)n);
        }
        if (!bl) {
            this.lc.log(10000000, "PicklistHelper#filterPicklistDuplicates: no duplicates found -> NOP");
            return;
        }
        n = arrayList.size();
        this.lc.log(10000000, "PicklistHelper#filterPicklistDuplicates: duplicates found, new nBest-Length=%1 -> set picklists and models", (long)n);
        this.mixedPicklist = this.flatPicklist = new Picklist((IPicklistElement[])arrayList.toArray(new IPicklistElement[n]));
        NBestUtils.setChoiceModel(n, this.lc);
        if (n > 1) {
            object = this.flatPicklist.getSlot(0, 0);
            IPicklistSlot iPicklistSlot = this.flatPicklist.getSlot(1, 0);
            if (object != null && iPicklistSlot != null) {
                String[] stringArray = new String[]{object.getText(), iPicklistSlot.getText()};
                SDSModelAccess.setDisambiguationLabel(stringArray);
            }
        }
    }

    private IPicklist prepareFlatList(NBestListEntry[] nBestListEntryArray, int[] nArray) {
        this.lc.log(10000000, "[PicklistHelper#prepareFlatList] called");
        int[] nArray2 = new int[nBestListEntryArray.length];
        Arrays.fill(nArray2, 0);
        return new Picklist(NBestUtils.makePicklistElements(nBestListEntryArray, nArray2, this.lc), nArray);
    }

    private IPicklist prepareMixedView(NBestListEntry[] nBestListEntryArray, GraphemicGroup[] graphemicGroupArray, int[] nArray, int n, int n2) {
        Object object;
        int n3;
        this.lc.log(10000000, "[PicklistHelper#prepareMixedView] noGGEntriesSize=%1", (long)n2);
        NBestListEntry[] nBestListEntryArray2 = new NBestListEntry[n + n2];
        int[] nArray2 = new int[n + n2];
        NBestListEntryExt[] nBestListEntryExtArray = new NBestListEntryExt[n];
        for (n3 = 0; n3 < n; ++n3) {
            NBestListEntryExt nBestListEntryExt = new NBestListEntryExt();
            GraphemicGroup graphemicGroup = graphemicGroupArray[n3];
            nBestListEntryExt.recognizedString = object = graphemicGroup.getGroupText();
            nBestListEntryExt.graphemicGroupIndex = n3;
            nBestListEntryExt.slots = graphemicGroup.getSlots();
            nBestListEntryExt.setUsed(false);
            nBestListEntryExt.setGGSize(graphemicGroup.getGraphemicGroupSize());
            nBestListEntryExtArray[n3] = nBestListEntryExt;
        }
        n3 = nBestListEntryArray.length;
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            Object object2;
            object = nBestListEntryArray[i2];
            if (object == null) {
                this.lc.log(10000000, "[PicklistHelper#prepareMixedView] curEntry is null!", (long)i2);
                continue;
            }
            int n5 = ((NBestListEntry)object).getGraphemicGroupIndex();
            int n6 = ((NBestListEntry)object).getGrammarId();
            int n7 = ((NBestListEntry)object).getConfidence();
            this.lc.log(10000000, "[PicklistHelper#prepareMixedView] curGrammarID=%1, curConfidence=%2, curIndex=%3!", (long)n6, (long)n7, (long)n4);
            if (n5 == -1) {
                object2 = ((NBestListEntry)object).getRecognizedString();
                NBestSlot[] nBestSlotArray = ((NBestListEntry)object).getSlots();
                nBestListEntryArray2[n4] = new NBestListEntry(n6, (String)object2, ((NBestListEntry)object).getRecognizedTag(), n7, ((NBestListEntry)object).getCommandHierarchie(), ((NBestListEntry)object).getGrammarType(), ((NBestListEntry)object).getGraphemicGroupIndex(), nBestSlotArray);
                nArray2[n4] = 0;
                this.lc.log(10000000, "[PicklistHelper#prepareMixedView] Adding entry #%3 with recString %1, slots %2 and ggSize 0!", object2, (Object)nBestSlotArray, (long)n4);
                ++n4;
                continue;
            }
            object2 = nBestListEntryExtArray[n5];
            if (((NBestListEntryExt)object2).isUsed()) continue;
            this.lc.log(10000000, "[PicklistHelper#prepareMixedView] Graphemic group %3 with grammarID and confidence from entry %1 to entry #%2!", (Object)new Integer(i2), (Object)new Integer(n4), (Object)((NBestListEntry)object2).getRecognizedString());
            ((NBestListEntryExt)object2).grammarId = n6;
            ((NBestListEntryExt)object2).confidence = n7;
            nBestListEntryArray2[n4] = object2;
            nArray2[n4] = ((NBestListEntryExt)object2).getGGSize();
            ((NBestListEntryExt)object2).setUsed(true);
            ++n4;
        }
        return new Picklist(NBestUtils.makePicklistElements(nBestListEntryArray2, nArray, nArray2, this.lc));
    }

    String[][] getPreparedPicklistTexts(int n) {
        Object[] objectArray = this.getMatchingPicklist(n).getElements();
        if (SDSUtils.isEmpty(objectArray) || objectArray[0] == null || objectArray[0].getSlots() == null) {
            return new String[0][0];
        }
        int n2 = objectArray[0].getSlots().length;
        int n3 = objectArray.length;
        String[][] stringArray = new String[n3][n2];
        for (int i2 = 0; i2 < n3; ++i2) {
            IPicklistSlot[] iPicklistSlotArray = objectArray[i2].getSlots();
            int n4 = iPicklistSlotArray.length;
            for (int i3 = 0; i3 < n4; ++i3) {
                IPicklistSlot iPicklistSlot = iPicklistSlotArray[i3];
                stringArray[i2][i3] = iPicklistSlot != null ? iPicklistSlot.getText() : "";
            }
        }
        return stringArray;
    }

    long[][] getPreparedPicklistObjIDs(int n) {
        Object[] objectArray = this.getMatchingPicklist(n).getElements();
        if (SDSUtils.isEmpty(objectArray) || objectArray[0] == null || objectArray[0].getSlots() == null) {
            return new long[0][0];
        }
        int n2 = Math.min(1, objectArray[0].getSlots().length);
        int n3 = objectArray.length;
        long[][] lArray = new long[n3][n2];
        for (int i2 = 0; i2 < n3; ++i2) {
            IPicklistSlot[] iPicklistSlotArray = objectArray[i2].getSlots();
            int n4 = iPicklistSlotArray.length;
            for (int i3 = 0; i3 < n4 && i3 < n2; ++i3) {
                IPicklistSlot iPicklistSlot = iPicklistSlotArray[i3];
                lArray[i2][i3] = iPicklistSlot != null ? iPicklistSlot.getObjID() : -1L;
            }
        }
        return lArray;
    }

    int[] getPreparedPicklistGraphGroupSizes(int n) {
        return this.getMatchingPicklist(n).getGraphGroupSizes();
    }

    int[] getPreparedPicklistGraphGroupIndexes(int n) {
        return this.getMatchingPicklist(n).getGraphGroupIndexes();
    }

    IPicklist getMatchingPicklist(int n) {
        switch (n) {
            case 0: {
                return this.flatPicklist;
            }
            case 1: {
                return this.mixedPicklist;
            }
            case 2: {
                return this.multislotPicklist;
            }
        }
        return new Picklist();
    }

    public void setMatchingPicklist(IPicklist iPicklist, int n) {
        switch (n) {
            case 0: {
                this.flatPicklist = iPicklist;
                return;
            }
            case 1: {
                this.mixedPicklist = iPicklist;
                return;
            }
            case 2: {
                this.multislotPicklist = iPicklist;
                return;
            }
        }
    }

    private class NBestListEntryExt
    extends NBestListEntry {
        private boolean used = false;
        private int ggSize = 0;

        private NBestListEntryExt() {
        }

        public boolean isUsed() {
            return this.used;
        }

        public void setUsed(boolean bl) {
            this.used = bl;
        }

        public int getGGSize() {
            return this.ggSize;
        }

        public void setGGSize(int n) {
            this.ggSize = n;
        }
    }
}

