/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

class TelIntellicallHandler$5
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ ITelDSIResponseListener val$listener;
    private final /* synthetic */ TelIntellicallHandler this$0;

    TelIntellicallHandler$5(TelIntellicallHandler telIntellicallHandler, ITelDSIResponseListener iTelDSIResponseListener) {
        this.this$0 = telIntellicallHandler;
        this.val$listener = iTelDSIResponseListener;
    }

    @Override
    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
        TelIntellicallHandler.access$600(this.this$0, this.val$listener, n, n2, suppServiceResponseStruct, n3);
    }
}

