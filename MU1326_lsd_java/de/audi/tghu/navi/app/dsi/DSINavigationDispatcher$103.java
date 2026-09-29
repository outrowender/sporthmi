/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.Category;

class DSINavigationDispatcher$103
extends CommandResponse {
    private final /* synthetic */ int val$mapStyleType;
    private final /* synthetic */ Category[] val$categories;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$103(DSINavigationDispatcher dSINavigationDispatcher, int n, Category[] categoryArray, int n2) {
        this.this$0 = dSINavigationDispatcher;
        this.val$mapStyleType = n;
        this.val$categories = categoryArray;
        this.val$resultCode = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).ehGetAllCategoriesResult(this.val$mapStyleType, this.val$categories, this.val$resultCode);
    }
}

