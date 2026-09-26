/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$156
extends CommandResponse {
    private final /* synthetic */ int val$offset;
    private final /* synthetic */ String val$validCharacters;
    private final /* synthetic */ int val$totalCount;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$156(DSINavigationDispatcher dSINavigationDispatcher, int n, String string, int n2) {
        this.this$0 = dSINavigationDispatcher;
        this.val$offset = n;
        this.val$validCharacters = string;
        this.val$totalCount = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).lispRequestNVCListResult(this.val$offset, this.val$validCharacters, this.val$totalCount);
    }
}

