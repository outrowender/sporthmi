/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.interapp;

import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.terminalmode.interapp.OnlinePOICallHandler;

class OnlinePOICallHandler$1
implements IDiagnosisCommandProvider {
    private final /* synthetic */ OnlinePOICallHandler this$0;

    OnlinePOICallHandler$1(OnlinePOICallHandler onlinePOICallHandler) {
        this.this$0 = onlinePOICallHandler;
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"onlinePoiCallActive(active)"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        if (Boolean.valueOf(stringArray[0]).booleanValue()) {
            this.this$0.updatePOICall(true);
        } else {
            this.this$0.updatePOICall(false);
        }
    }
}

