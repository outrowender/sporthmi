/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DataSet;

public interface DSIAdbEditListener
extends DSIListener {
    public void updateNewEntryAvailable(boolean var1, int var2);

    public void updateNewPublicProfileEntryAvailable(boolean var1, int var2);

    public void updateNewTopDestinationEntryAvailable(boolean var1, int var2);

    public void updateNewPublicProfileTopDestEntryAvailable(boolean var1, int var2);

    public void insertEntryResult(int var1, AdbEntry var2);

    public void getEntriesResult(int var1, AdbEntry[] var2);

    public void getEntryDataSetsResult(int var1, DataSet[] var2);

    public void changeEntryResult(int var1, AdbEntry var2);

    public void copyEntryResult(int var1, AdbEntry var2);

    public void deleteEntriesResult(int var1);

    public void setSpeedDialResult(int var1);

    public void deleteSpeedDialResult(int var1);

    public void getEntryByReferenceIdResult(int var1, AdbEntry var2);

    public void updateNewOnlineDestinationEntryAvailable(boolean var1, int var2);
}

