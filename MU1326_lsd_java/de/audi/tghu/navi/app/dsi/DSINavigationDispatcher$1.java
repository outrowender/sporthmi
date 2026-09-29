/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$1
extends CommandResponse {
    private final /* synthetic */ int val$errorCode;
    private final /* synthetic */ String val$errorMsg;
    private final /* synthetic */ int val$requestType;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$1(DSINavigationDispatcher dSINavigationDispatcher, int n, String string, int n2) {
        this.this$0 = dSINavigationDispatcher;
        this.val$errorCode = n;
        this.val$errorMsg = string;
        this.val$requestType = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).asyncException(this.val$errorCode, this.val$errorMsg, this.val$requestType);
    }
}

