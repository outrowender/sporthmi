/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.callcontrol;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.evo.callcontrol.TelEvoMFLKeyHandler;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

class TelEvoMFLKeyHandler$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ TelEvoMFLKeyHandler this$0;

    TelEvoMFLKeyHandler$1(TelEvoMFLKeyHandler telEvoMFLKeyHandler) {
        this.this$0 = telEvoMFLKeyHandler;
    }

    @Override
    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
        if (n == 0) {
            TelEvoMFLKeyHandler.access$000(this.this$0);
        }
    }
}

