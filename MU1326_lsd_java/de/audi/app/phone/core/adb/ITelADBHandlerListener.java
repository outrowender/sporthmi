/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import org.dsi.ifc.organizer.ProfileInfo;

public interface ITelADBHandlerListener {
    public void updateActiveProfile(ProfileInfo var1);

    public void profileDeleted(int var1);

    public void updateSortOrder(int var1, int var2);

    public void setAdbReady(boolean var1);

    public void handleInvalidData(int var1, boolean var2);

    public void onEntrySelected(ADBSearch var1, ADBSearchListRow var2, int var3, int var4);

    public void onDetailsSelected(ADBEntryDetailsListRow var1, int var2, int var3);
}

