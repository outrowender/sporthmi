/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$139
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ String[] val$failedRegions;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$139(DSINavigationDispatcher dSINavigationDispatcher, int n, String[] stringArray, int n2) {
        this.this$0 = dSINavigationDispatcher;
        this.val$result = n;
        this.val$failedRegions = stringArray;
        this.val$validFlag = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateNavDbRegionsState(this.val$result, this.val$failedRegions, this.val$validFlag);
    }
}

