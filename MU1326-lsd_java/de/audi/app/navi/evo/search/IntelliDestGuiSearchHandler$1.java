/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import org.dsi.ifc.global.NavLocation;

class IntelliDestGuiSearchHandler$1
implements NavLocationCallback {
    private final /* synthetic */ SearchResultListRow val$listRow;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ IntelliDestGuiSearchHandler this$0;

    IntelliDestGuiSearchHandler$1(IntelliDestGuiSearchHandler intelliDestGuiSearchHandler, SearchResultListRow searchResultListRow, int n) {
        this.this$0 = intelliDestGuiSearchHandler;
        this.val$listRow = searchResultListRow;
        this.val$terminal = n;
    }

    @Override
    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
        this.this$0.storeAddressToAdb(this.val$listRow, navLocation, iCommandList, this.val$terminal);
    }
}

