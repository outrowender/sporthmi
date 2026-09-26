/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.emergency;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.emergency.TelAutomaticEmergencyCallHandler;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

class TelAutomaticEmergencyCallHandler$3
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ TelAutomaticEmergencyCallHandler this$0;

    TelAutomaticEmergencyCallHandler$3(TelAutomaticEmergencyCallHandler telAutomaticEmergencyCallHandler) {
        this.this$0 = telAutomaticEmergencyCallHandler;
    }

    @Override
    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
        this.this$0.dialNumberResult(n);
    }
}

