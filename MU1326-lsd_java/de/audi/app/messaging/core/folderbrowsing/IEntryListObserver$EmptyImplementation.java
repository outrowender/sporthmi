/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.EntryListRow;
import de.audi.app.messaging.core.folderbrowsing.IEntryListObserver;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.messaging.ListEntry;

public class IEntryListObserver$EmptyImplementation
implements IEntryListObserver {
    @Override
    public void indicateItemFocused(EntryListRow entryListRow) {
    }

    @Override
    public void indicateItemSelected(ListEntry listEntry, long l) {
    }

    @Override
    public void indicateListDataResponseOnFolderChange() {
    }

    @Override
    public void indicateOperationState(int n) {
    }

    @Override
    public void indicateItemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void indicateItemToSelect(EvoListRow evoListRow) {
    }
}

