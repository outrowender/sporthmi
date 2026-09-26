/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.search.organizer;

import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.IndexInformation;

public interface ADBOrganizerSearch
extends ADBSearch {
    default public EvoListRow[] createSearchListRows(DataSet[] dataSetArray) {
    }

    default public void spellerResult(int n, DataSet[] dataSetArray, int n2, String string, String string2) {
    }

    default public int getCurrentSpellerHandle() {
    }

    default public void validateSpellerCharsResult(String string) {
    }

    default public void setValidHanziChars(String string, int n) {
    }

    default public HMIModelApp getListSyncModel() {
    }

    default public MatchspellerModelApp getSpellerModel() {
    }

    default public void refresh() {
    }

    default public void refreshByEntryId(long l) {
    }

    default public void refreshFromStart() {
    }

    default public void refreshByPosition() {
    }

    default public void setRowOpenState(EvoListRow evoListRow, boolean bl, BaseListModelApp baseListModelApp) {
    }

    default public void updateAlphabeticalIndex(IndexInformation[] indexInformationArray) {
    }
}

