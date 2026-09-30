/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.search;

import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.tghu.online.app.remotehmi.search.ISearchListener;

public interface ITruffleSearchHandler {
    public void performQuery(String var1, IGridList var2, ISearchListener var3);

    public boolean cancelQuery();
}

