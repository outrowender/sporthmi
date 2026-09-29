/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.LIValueList;

class DSINavigationDispatcher$20
extends CommandResponse {
    private final /* synthetic */ LIValueList val$lispValueList;
    private final /* synthetic */ long val$lispValueListCount;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$20(DSINavigationDispatcher dSINavigationDispatcher, LIValueList lIValueList, long l) {
        this.this$0 = dSINavigationDispatcher;
        this.val$lispValueList = lIValueList;
        this.val$lispValueListCount = l;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).poiValueList(this.val$lispValueList, this.val$lispValueListCount);
    }
}

