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
    public static final int LINE_NUMBER_NONE;

    default public PicklistHistoryElement retrieveLatestNBestListHistory(boolean bl) {
    }

    default public void stepBackPicklistHistory() {
    }

    default public void resetPicklistsWithHistory() {
    }

    default public void storeCurrentPicklistInHistory() {
    }

    default public void addGGRefinementToNBestListHistory() {
    }

    default public void addGGSpellingRefinementToNBestListHistory(NBestListEntry[] nBestListEntryArray) {
    }

    default public void resetNBestListHistory() {
    }

    default public int getSpellingGraphGroupID() {
    }

    default public int getLatestPicklistID() {
    }

    default public void setLastRecogLine(boolean bl, int n) {
    }

    default public int getLastRecogLine() {
    }

    default public boolean storeNBestList(NBestList nBestList) {
    }

    default public NBestListEntry getTopEntry() {
    }

    default public void filterPicklistDuplicates() {
    }

    default public String getRecognitionText(int n) {
    }

    default public void prepareGGRefinementPicklist(int n, int n2) {
    }

    default public PicklistHelper getPicklistHelper() {
    }

    default public IPicklistSlot getSlotForPicklistElement(int n, int n2, byte by, boolean bl) {
    }

    default public long getSlotObjID(int n, int n2) {
    }

    default public IPicklist getMatchingPicklist(byte by) {
    }

    default public String[][] getPreparedPicklistTexts(byte by) {
    }

    default public long[][] getPreparedPicklistObjIDs(byte by) {
    }

    default public int[] getPreparedPicklistGraphGroupSizes(byte by) {
    }

    default public int getPicklistSize(byte by) {
    }

    default public byte getRecogResultGraphGroupType() {
    }

    default public boolean isSlotRecognition() {
    }
}

