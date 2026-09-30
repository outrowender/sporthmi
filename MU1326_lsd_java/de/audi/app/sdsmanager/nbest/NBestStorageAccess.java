/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.nbest;

import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.PicklistHelper;
import de.audi.app.sdsmanager.nbest.PicklistHistoryElement;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.NBestListEntry;

public interface NBestStorageAccess {
    public static final int LINE_NUMBER_NONE = -1;

    public PicklistHistoryElement retrieveLatestNBestListHistory(boolean var1);

    public void stepBackPicklistHistory();

    public void resetPicklistsWithHistory();

    public void storeCurrentPicklistInHistory();

    public void addGGRefinementToNBestListHistory();

    public void addGGSpellingRefinementToNBestListHistory(NBestListEntry[] var1);

    public void resetNBestListHistory();

    public int getSpellingGraphGroupID();

    public int getLatestPicklistID();

    public void setLastRecogLine(boolean var1, int var2);

    public int getLastRecogLine();

    public boolean storeNBestList(NBestList var1);

    public NBestListEntry getTopEntry();

    public void filterPicklistDuplicates();

    public String getRecognitionText(int var1);

    public void prepareGGRefinementPicklist(int var1, int var2);

    public PicklistHelper getPicklistHelper();

    public IPicklistSlot getSlotForPicklistElement(int var1, int var2, byte var3, boolean var4);

    public long getSlotObjID(int var1, int var2);

    public IPicklist getMatchingPicklist(byte var1);

    public String[][] getPreparedPicklistTexts(byte var1);

    public long[][] getPreparedPicklistObjIDs(byte var1);

    public int[] getPreparedPicklistGraphGroupSizes(byte var1);

    public int getPicklistSize(byte var1);

    public byte getRecogResultGraphGroupType();

    public boolean isSlotRecognition();
}

