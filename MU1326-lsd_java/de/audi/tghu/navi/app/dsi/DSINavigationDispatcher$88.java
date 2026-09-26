/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.TryMatchLocationResultData;

class DSINavigationDispatcher$88
extends CommandResponse {
    private final /* synthetic */ TryMatchLocationResultData[] val$result;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$88(DSINavigationDispatcher dSINavigationDispatcher, TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$result = tryMatchLocationResultDataArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).liTryMatchLocationResult(this.val$result);
    }
}

