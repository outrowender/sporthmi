/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.EntryListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.messaging.ListEntry;

public interface IEntryListObserver {
    default public void indicateItemFocused(EntryListRow entryListRow) {
    }

    default public void indicateItemSelected(ListEntry listEntry, long l) {
    }

    default public void indicateItemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    default public void indicateListDataResponseOnFolderChange() {
    }

    default public void indicateOperationState(int n) {
    }

    default public void indicateItemToSelect(EvoListRow evoListRow) {
    }
}

