/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.Brand;

class DSINavigationDispatcher$104
extends CommandResponse {
    private final /* synthetic */ int val$mapStyleType;
    private final /* synthetic */ int val$categoryUid;
    private final /* synthetic */ Brand[] val$brands;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$104(DSINavigationDispatcher dSINavigationDispatcher, int n, int n2, Brand[] brandArray, int n3) {
        this.this$0 = dSINavigationDispatcher;
        this.val$mapStyleType = n;
        this.val$categoryUid = n2;
        this.val$brands = brandArray;
        this.val$resultCode = n3;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).ehGetAllBrandsOfCategoryResult(this.val$mapStyleType, this.val$categoryUid, this.val$brands, this.val$resultCode);
    }
}

