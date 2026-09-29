/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.evo.intellicall.IntellicallCombinedCallStackHandler;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

class IntellicallCombinedCallStackHandler$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ CallStackEntry val$callStackEntry;
    private final /* synthetic */ IntellicallCombinedCallStackHandler this$0;

    IntellicallCombinedCallStackHandler$1(IntellicallCombinedCallStackHandler intellicallCombinedCallStackHandler, CallStackEntry callStackEntry) {
        this.this$0 = intellicallCombinedCallStackHandler;
        this.val$callStackEntry = callStackEntry;
    }

    @Override
    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
        if (n == 0) {
            this.this$0.callStackEntryDialed(this.val$callStackEntry);
        }
    }
}

