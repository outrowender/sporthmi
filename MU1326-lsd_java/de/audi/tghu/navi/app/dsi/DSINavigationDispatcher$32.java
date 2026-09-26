/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$32
extends CommandResponse {
    private final /* synthetic */ int val$trStartTraceRecordingResultCode;
    private final /* synthetic */ long val$timestamp;
    private final /* synthetic */ int val$errorCode;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$32(DSINavigationDispatcher dSINavigationDispatcher, int n, long l, int n2) {
        this.this$0 = dSINavigationDispatcher;
        this.val$trStartTraceRecordingResultCode = n;
        this.val$timestamp = l;
        this.val$errorCode = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).trStartTraceRecordingResult(this.val$trStartTraceRecordingResultCode, this.val$timestamp, this.val$errorCode);
    }
}

