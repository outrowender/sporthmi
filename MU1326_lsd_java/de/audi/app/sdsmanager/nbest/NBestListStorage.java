/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.nbest;

import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestListPreprocessing;
import de.audi.app.sdsmanager.nbest.NBestPreFilter;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.nbest.NBestUtils;
import de.audi.app.sdsmanager.nbest.Picklist;
import de.audi.app.sdsmanager.nbest.PicklistElement;
import de.audi.app.sdsmanager.nbest.PicklistHelper;
import de.audi.app.sdsmanager.nbest.PicklistHistoryElement;
import de.audi.app.sdsmanager.testsupport.SDSStatisticsDataConverter;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Arrays;
import org.dsi.ifc.speechrec.GraphemicGroup;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.NBestListEntry;
import org.dsi.ifc.speechrec.NBestSlot;

public class NBestListStorage
implements NBestStorageAccess {
    private static final int DUMMY_PL_HISTORY_ID = -100;
    private LogChannel lc = Logger.getNBestLog();
    protected PicklistHelper picklistHelper = new PicklistHelper();
    protected NBestListEntry[] currentEntries = new NBestListEntry[0];
    protected GraphemicGroup[] currentGGEntries = new GraphemicGroup[0];
    private int spellingGraphGroupIndex = -1;
    private ArrayList plHistory = new ArrayList(5);
    private int nBestListID;
    private IFrameworkAccess framework;
    protected SDSAdapter sdsAdapter;

    public NBestListStorage(IFrameworkAccess iFrameworkAccess, SDSAdapter sDSAdapter) {
        this.framework = iFrameworkAccess;
        this.sdsAdapter = sDSAdapter;
        this.picklistHelper = new PicklistHelper();
    }

    public boolean storeNBestList(NBestList nBestList) {
        return this.handleNBestList(NBestPreFilter.filterLowConfidenceEntries(nBestList, this.sdsAdapter, this.lc));
    }

    protected boolean handleNBestList(NBestList nBestList) {
        NBestListPreprocessing nBestListPreprocessing = new NBestListPreprocessing(nBestList);
        NBestList nBestList2 = nBestListPreprocessing.preprocessNBestList(this.framework);
        this.currentEntries = nBestList2.getEntries();
        this.currentGGEntries = nBestList2.getGraphemicGroups();
        int n = this.currentEntries.length;
        this.lc.log(10000000, "NBestListStorage#storeNBestList: currentEntries [%2]=\n%1", (Object)SDSUtils.toString((Object[])this.currentEntries, true), (long)n);
        this.lc.log(10000000, "NBestListStorage#storeNBestList: currentGGEntries [%2] =\n%1", (Object)SDSUtils.toString((Object[])this.currentGGEntries, true), (long)this.currentGGEntries.length);
        this.lc.log(10000000, "NBestListStorage#storeNBestList: SLM currentEntries[%2] = %1", (Object)SDSStatisticsDataConverter.getSLMRulesLogging(this.currentEntries), (long)n);
        if (n == 0) {
            return false;
        }
        NBestListEntry nBestListEntry = this.currentEntries[0];
        NBestUtils.setChoiceModel(n, this.lc);
        NBestUtils.setLabelModel(nBestListEntry, this.lc);
        NBestUtils.setTagModel(nBestListEntry, this.lc);
        nBestListPreprocessing.setnBestRuleType(NBestUtils.setSlotModels(nBestListEntry, this.lc));
        SDSUtils.handleDisambiguationLabels(this.currentEntries);
        this.picklistHelper.createPicklists(nBestListPreprocessing);
        return true;
    }

    public NBestListEntry getTopEntry() {
        if (this.currentEntries == null) {
            return null;
        }
        return this.currentEntries[0];
    }

    public void storeCurrentPicklistInHistory() {
        this.lc.log(10000000, "NBestListStorage#storeCurrentPicklistInHistory: Adding picklist to history, historySize=%1!", (long)this.plHistory.size());
        this.plHistory.add(new PicklistHistoryElement(this.picklistHelper.getMatchingPicklist(0), this.picklistHelper.getMatchingPicklist(1), this.nBestListID, this.currentGGEntries));
    }

    public long getSlotObjID(int n, int n2) {
        return this.getMatchingSlot(this.getMatchingEntry(n2), n).getObjectId();
    }

    public IPicklist getMatchingPicklist(byte by) {
        return this.picklistHelper.getMatchingPicklist(by);
    }

    public String[][] getPreparedPicklistTexts(byte by) {
        return this.picklistHelper.getPreparedPicklistTexts(by);
    }

    public long[][] getPreparedPicklistObjIDs(byte by) {
        return this.picklistHelper.getPreparedPicklistObjIDs(by);
    }

    public int[] getPreparedPicklistGraphGroupSizes(byte by) {
        return this.picklistHelper.getPreparedPicklistGraphGroupSizes(by);
    }

    public int getPicklistSize(byte by) {
        return this.getMatchingPicklist(by).getSize();
    }

    public void stepBackPicklistHistory() {
        this.lc.log(10000000, "[NBestListStorage#stepBackPicklistHistory] called");
        if (this.retrieveLatestNBestListHistory(true) == null) {
            return;
        }
        this.resetPicklistsWithHistory();
    }

    public void resetPicklistsWithHistory() {
        if (this.plHistory.isEmpty()) {
            this.lc.log(10000000, "[NBestListStorage#resetPicklistsWithHistory] Current PL-History is empty -> do nothing");
            return;
        }
        PicklistHistoryElement picklistHistoryElement = this.retrieveLatestNBestListHistory(false);
        this.lc.log(10000000, "[NBestListStorage#resetPicklistsWithHistory] new history size=%1", (long)this.plHistory.size());
        if (picklistHistoryElement == null) {
            return;
        }
        this.lc.log(10000000, "[NBestListStorage#resetPicklistsWithHistory] resetting picklists");
        IPicklist iPicklist = picklistHistoryElement.getFlatPicklist();
        this.picklistHelper.setMatchingPicklist(iPicklist, 0);
        this.picklistHelper.setMatchingPicklist(picklistHistoryElement.getMixedPicklist(), 1);
        GraphemicGroup[] graphemicGroupArray = picklistHistoryElement.getGgInfo();
        this.currentGGEntries = graphemicGroupArray == null ? new GraphemicGroup[]{} : graphemicGroupArray;
        this.nBestListID = picklistHistoryElement.getNBestPicklistID();
        NBestUtils.setChoiceModel(iPicklist.getSize(), this.lc);
    }

    public int getLatestPicklistID() {
        PicklistHistoryElement picklistHistoryElement = this.retrieveLatestNBestListHistory(false);
        return picklistHistoryElement == null ? -100 : picklistHistoryElement.getNBestPicklistID();
    }

    public PicklistHistoryElement retrieveLatestNBestListHistory(boolean bl) {
        PicklistHistoryElement picklistHistoryElement;
        if (this.plHistory.isEmpty()) {
            this.lc.log(10000000, "[NBestListStorage#retrieveLatestNBestListHistory] nBestListHistory is empty!");
            return null;
        }
        int n = this.plHistory.size() - 1;
        if (bl) {
            this.printNBestListIDs();
            this.lc.log(10000000, "[NBestListStorage#retrieveLatestNBestListHistory] removing last queued element!");
            picklistHistoryElement = (PicklistHistoryElement)this.plHistory.remove(n);
        } else {
            this.printNBestListIDs();
            this.lc.log(10000000, "[NBestListStorage#retrieveLatestNBestListHistory] getting last queued element!");
            picklistHistoryElement = (PicklistHistoryElement)this.plHistory.get(n);
        }
        return picklistHistoryElement;
    }

    private NBestListEntry getMatchingEntry(int n) {
        int n2 = this.currentEntries.length;
        if (n >= n2) {
            this.lc.log(100000, "NBestListStorage#getMatchingEntry: Requesting %1 of %2 entries!", (long)n, (long)n2);
            return new NBestListEntry();
        }
        NBestListEntry nBestListEntry = this.currentEntries[n];
        if (nBestListEntry == null) {
            this.lc.log(100000, "getMatchingEntry: Entry #%1 is null!", (long)n);
            return new NBestListEntry();
        }
        return nBestListEntry;
    }

    public PicklistHelper getPicklistHelper() {
        return this.picklistHelper;
    }

    private NBestSlot getMatchingSlot(NBestListEntry nBestListEntry, int n) {
        if (nBestListEntry == null) {
            this.lc.log(100000, "NBestListStorage#getMatchingSlot: No entry given!");
            return new NBestSlot();
        }
        NBestSlot[] nBestSlotArray = nBestListEntry.getSlots();
        if (nBestSlotArray == null) {
            this.lc.log(100000, "NBestListStorage#getMatchingSlot: Slots are null!");
            return new NBestSlot();
        }
        int n2 = nBestSlotArray.length;
        if (n >= n2) {
            this.lc.log(100000, "NBestListStorage#getMatchingSlot: Requesting %1 of %2 entries!", (long)n, (long)n2);
            return new NBestSlot();
        }
        NBestSlot nBestSlot = nBestSlotArray[n];
        if (nBestSlot == null) {
            this.lc.log(100000, "NBestListStorage#getMatchingSlot: Entry #%1 is null!", (long)n);
            return new NBestSlot();
        }
        return nBestSlot;
    }

    public byte getRecogResultGraphGroupType() {
        this.lc.log(10000000, "[NBestListStorage#getRecogResultGraphGroupType] called");
        IPicklist iPicklist = this.getMatchingPicklist((byte)1);
        if (iPicklist == null || iPicklist.getSize() == 0) {
            this.lc.log(100000, "[NBestListStorage#getRecogResultGraphGroupType] Empty picklist!");
            return 0;
        }
        int n = this.getLastRecogLine();
        this.lc.log(10000000, "[NBestListStorage#getRecogResultGraphGroupType] lastRecogLine=%1!", (long)n);
        if (n == -1) {
            this.lc.log(100000, "[NBestListStorage#getRecogResultGraphGroupType] No last recognized line!");
            return 0;
        }
        if (iPicklist.isLineSelectedByNumber()) {
            int n2 = iPicklist.getSize();
            this.lc.log(10000000, "[NBestListStorage#getRecogResultGraphGroupType] picklistSize=%1!", (long)n2);
            if (n2 <= n) {
                this.lc.log(100000, "[NBestListStorage#getRecogResultGraphGroupType] picklistSize=%1 <= lastRecogLine=%2!", (long)n2, (long)n);
                return 0;
            }
            IPicklistElement iPicklistElement = iPicklist.get(n);
            if (iPicklistElement == null) {
                this.lc.log(100000, "[NBestListStorage#getRecogResultGraphGroupType] Empty picklistElement #%1!", (long)n);
                return 0;
            }
            int n3 = iPicklistElement.getGraphGroupIndex();
            int n4 = iPicklistElement.getGraphGroupSize();
            this.lc.log(10000000, "[NBestListStorage#getRecogResultGraphGroupType] ggIndex=%1, ggSize=%2!", (long)n3, (long)n4);
            if (n3 == -1 || n4 == 0) {
                this.lc.log(10000000, "[NBestListStorage#getRecogResultGraphGroupType] picklistElement #%1 is no GG element!", (long)n);
                return 0;
            }
            return this.getDirectlySelectedGraphemicGroupType(n3);
        }
        this.lc.log(10000000, "[NBestListStorage#getRecogResultGraphGroupType] GG spoken!");
        this.resetPicklistsWithHistory();
        return this.getDirectlySelectedGraphemicGroupType(n);
    }

    private byte getDirectlySelectedGraphemicGroupType(int n) {
        this.lc.log(10000000, "[NBestListStorage#getDirectlySelectedGraphemicGroupType] ggIndex=%1", (long)n);
        int n2 = this.getAmountOfGraphGroupEntries(n);
        this.lc.log(10000000, "[NBestListStorage#getDirectlySelectedGraphemicGroupType] fittingEntries=%1!", (long)n2);
        if (n2 > 1) {
            this.prepareGGRefinementPicklist(n, n2);
            return 1;
        }
        this.spellingGraphGroupIndex = n;
        return 2;
    }

    public void prepareGGRefinementPicklist(int n, int n2) {
        this.lc.log(10000000, "[NBestListStorage#prepareGGRefinementPicklist] graphgroupIndex=%1, numberOfFittingEntries=%2!", (long)n, (long)n2);
        IPicklistElement[] iPicklistElementArray = new PicklistElement[n2];
        IPicklist iPicklist = this.getMatchingPicklist((byte)0);
        int n3 = iPicklist.getSize();
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            IPicklistElement iPicklistElement = iPicklist.get(i2);
            if (iPicklistElement == null || iPicklistElement.getGraphGroupIndex() != n || iPicklistElement.getGraphGroupSize() > 0) continue;
            this.lc.log(10000000, "[NBestListStorage#prepareGGRefinementPicklist] graphemicGroupIndex[%2] = %1 => fitting entry!", (long)n, (long)i2);
            iPicklistElementArray[n4] = new PicklistElement(iPicklistElement.getRuleID(), iPicklistElement.getConfidence(), 0, iPicklistElement.getGraphGroupIndex(), iPicklistElement.getSlots());
            ++n4;
        }
        Picklist picklist = new Picklist(iPicklistElementArray);
        this.picklistHelper.setMatchingPicklist(picklist, 0);
        this.picklistHelper.setMatchingPicklist(picklist, 1);
    }

    private int getAmountOfGraphGroupEntries(int n) {
        this.lc.log(10000000, "NBestListStorage#getAmountOfGraphGroupEntries: ggIndex=%1", (long)n);
        IPicklist iPicklist = this.getMatchingPicklist((byte)0);
        int n2 = iPicklist.getSize();
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            IPicklistElement iPicklistElement = iPicklist.get(i2);
            if (iPicklistElement == null) {
                this.lc.log(100000, "NBestListStorage#getAmountOfGraphGroupEntries: Entry #%1 is null!", (long)i2);
                continue;
            }
            if (iPicklistElement.getGraphGroupIndex() != n) continue;
            ++n3;
        }
        return n3;
    }

    public void addGGRefinementToNBestListHistory() {
        this.lc.log(10000000, "[NBestListStorage#addGGRefinementToNBestListHistory] called");
        if (this.plHistory.isEmpty()) {
            this.lc.log(100000, "[NBestListStorage#addGGRefinementToNBestListHistory] nBestListHistory is empty!");
            return;
        }
        int n = this.getLatestPicklistID();
        this.lc.log(10000000, "[NBestListStorage#addGGRefinementToNBestListHistory] plHistID=%1!", (long)n);
        this.plHistory.add(new PicklistHistoryElement(this.picklistHelper.getMatchingPicklist(1), this.picklistHelper.getMatchingPicklist(1), n, null));
        this.printNBestListIDs();
        NBestUtils.setChoiceModel(this.currentGGEntries.length, this.lc);
    }

    public void addGGSpellingRefinementToNBestListHistory(NBestListEntry[] nBestListEntryArray) {
        this.lc.log(10000000, "[NBestListStorage#addGGSpellingRefinementToNBestListHistory] called");
        if (this.plHistory.isEmpty()) {
            this.lc.log(100000, "[NBestListStorage#addGGSpellingRefinementToNBestListHistory] nBestListHistory is empty!");
            return;
        }
        int[] nArray = new int[nBestListEntryArray.length];
        Arrays.fill(nArray, 0);
        Picklist picklist = new Picklist(NBestUtils.makePicklistElements(nBestListEntryArray, nArray, this.lc));
        int n = this.getLatestPicklistID();
        this.plHistory.add(new PicklistHistoryElement(picklist, picklist, n, null));
        this.printNBestListIDs();
    }

    public void resetNBestListHistory() {
        this.lc.log(10000000, "[NBestListStorage#resetNBestListHistory] called");
        this.plHistory.clear();
    }

    private void printNBestListIDs() {
        int n = this.plHistory.size();
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = ((PicklistHistoryElement)this.plHistory.get(i2)).getNBestPicklistID();
            this.lc.log(10000000, "[NBestListStorage#printNBestListIDs] plHistory[%1]=%2!", (long)i2, (long)n2);
        }
    }

    public int getSpellingGraphGroupID() {
        if (this.spellingGraphGroupIndex == -1) {
            return this.spellingGraphGroupIndex;
        }
        return this.spellingGraphGroupIndex;
    }

    public void setLastRecogLine(boolean bl, int n) {
        this.lc.log(10000000, "[NBestListStorage#setLastRecogLine] selectedByNumber=%1, lineNumber=%2", bl, (long)n);
        this.setLastRecogLine(this.getMatchingPicklist((byte)0), bl, n);
        this.setLastRecogLine(this.getMatchingPicklist((byte)1), bl, n);
    }

    private void setLastRecogLine(IPicklist iPicklist, boolean bl, int n) {
        if (iPicklist == null) {
            this.lc.log(100000, "[NBestListStorage#setLastRecogLine] Empty picklist!");
            return;
        }
        iPicklist.setLastRecogLine(bl, n);
    }

    public int getLastRecogLine() {
        IPicklist iPicklist = this.getMatchingPicklist((byte)0);
        if (iPicklist == null) {
            this.lc.log(100000, "[NBestListStorage#getLastRecogLine] Empty picklist!");
            return -1;
        }
        int n = iPicklist.getLastRecogLineNumber();
        this.lc.log(10000000, "[NBestListStorage#getLastRecogLine] lastRecogLine=%1!", (long)n);
        return n;
    }

    public boolean isSlotRecognition() {
        NBestSlot[] nBestSlotArray = this.getMatchingEntry(0).getSlots();
        return nBestSlotArray != null;
    }

    public String getRecognitionText(int n) {
        return this.getMatchingEntry(n).getRecognizedString();
    }

    public IPicklistSlot getSlotForPicklistElement(int n, int n2, byte by, boolean bl) {
        IPicklist iPicklist = null;
        if (bl) {
            iPicklist = this.getMatchingPicklist(by);
        } else {
            PicklistHistoryElement picklistHistoryElement = this.retrieveLatestNBestListHistory(false);
            if (picklistHistoryElement == null) {
                return null;
            }
            iPicklist = picklistHistoryElement.getPicklist(by);
        }
        if (iPicklist == null) {
            return null;
        }
        return iPicklist.getSlot(n2, n);
    }

    public void filterPicklistDuplicates() {
        this.picklistHelper.filterPicklistDuplicates();
    }
}

