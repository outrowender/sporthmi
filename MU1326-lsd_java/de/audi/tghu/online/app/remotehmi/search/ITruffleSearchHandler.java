/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.search;

import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.tghu.online.app.remotehmi.search.ISearchListener;

public interface ITruffleSearchHandler {
    default public void performQuery(String string, IGridList iGridList, ISearchListener iSearchListener) {
    }

    default public boolean cancelQuery() {
    }
}

