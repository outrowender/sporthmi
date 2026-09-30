/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.EntryListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.messaging.ListEntry;

public interface IEntryListObserver {
    public void indicateItemFocused(EntryListRow var1);

    public void indicateItemSelected(ListEntry var1, long var2);

    public void indicateItemSelected(EvoListRow var1, int var2, int var3, int var4, int var5);

    public void indicateListDataResponseOnFolderChange();

    public void indicateOperationState(int var1);

    public void indicateItemToSelect(EvoListRow var1);

    public static class EmptyImplementation
    implements IEntryListObserver {
        public void indicateItemFocused(EntryListRow entryListRow) {
        }

        public void indicateItemSelected(ListEntry listEntry, long l) {
        }

        public void indicateListDataResponseOnFolderChange() {
        }

        public void indicateOperationState(int n) {
        }

        public void indicateItemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        }

        public void indicateItemToSelect(EvoListRow evoListRow) {
        }
    }
}

