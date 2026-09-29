/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.TryBestMatchResultData;

class DSINavigationDispatcher$87
extends CommandResponse {
    private final /* synthetic */ TryBestMatchResultData[] val$result;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$87(DSINavigationDispatcher dSINavigationDispatcher, TryBestMatchResultData[] tryBestMatchResultDataArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$result = tryBestMatchResultDataArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).liTryBestMatchResult(this.val$result);
    }
}

