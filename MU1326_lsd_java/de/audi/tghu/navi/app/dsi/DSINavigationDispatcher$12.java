/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.LIValueList;

class DSINavigationDispatcher$12
extends CommandResponse {
    private final /* synthetic */ LIValueList val$list;
    private final /* synthetic */ long val$lispValueListCount;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$12(DSINavigationDispatcher dSINavigationDispatcher, LIValueList lIValueList, long l) {
        this.this$0 = dSINavigationDispatcher;
        this.val$list = lIValueList;
        this.val$lispValueListCount = l;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).liValueList(this.val$list, this.val$lispValueListCount);
    }
}

