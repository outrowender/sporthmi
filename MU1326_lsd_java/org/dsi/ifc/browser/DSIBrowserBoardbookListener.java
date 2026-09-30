/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.browser.SearchHit;

public interface DSIBrowserBoardbookListener
extends DSIListener {
    public void indicateSearchResults(String var1, int var2, SearchHit[] var3, int var4);

    public void updateBoardbookStatus(int var1, int var2);
}

