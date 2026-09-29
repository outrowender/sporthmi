/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import org.dsi.ifc.organizer.ProfileInfo;

public interface ITelADBHandlerListener {
    default public void updateActiveProfile(ProfileInfo profileInfo) {
    }

    default public void profileDeleted(int n) {
    }

    default public void updateSortOrder(int n, int n2) {
    }

    default public void setAdbReady(boolean bl) {
    }

    default public void handleInvalidData(int n, boolean bl) {
    }

    default public void onEntrySelected(ADBSearch aDBSearch, ADBSearchListRow aDBSearchListRow, int n, int n2) {
    }

    default public void onDetailsSelected(ADBEntryDetailsListRow aDBEntryDetailsListRow, int n, int n2) {
    }
}

