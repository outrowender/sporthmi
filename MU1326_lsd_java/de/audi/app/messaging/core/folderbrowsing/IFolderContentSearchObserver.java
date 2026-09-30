/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.atip.search.util.SearchResultListRow;

public interface IFolderContentSearchObserver {
    public void searchResultSelected(SearchResultListRow var1);

    public static class DefaultFolderContentSearchObserver
    implements IFolderContentSearchObserver {
        public void searchResultSelected(SearchResultListRow searchResultListRow) {
        }
    }
}

