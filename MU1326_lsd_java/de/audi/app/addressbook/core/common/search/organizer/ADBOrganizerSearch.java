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
    public EvoListRow[] createSearchListRows(DataSet[] var1);

    public void spellerResult(int var1, DataSet[] var2, int var3, String var4, String var5);

    public int getCurrentSpellerHandle();

    public void validateSpellerCharsResult(String var1);

    public void setValidHanziChars(String var1, int var2);

    public HMIModelApp getListSyncModel();

    public MatchspellerModelApp getSpellerModel();

    public void refresh();

    public void refreshByEntryId(long var1);

    public void refreshFromStart();

    public void refreshByPosition();

    public void setRowOpenState(EvoListRow var1, boolean var2, BaseListModelApp var3);

    public void updateAlphabeticalIndex(IndexInformation[] var1);
}

