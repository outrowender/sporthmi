/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core;

import de.audi.app.phone.core.NumberSpellerHandlerBase;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

class NumberSpellerHandlerBase$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ NumberSpellerHandlerBase this$0;

    NumberSpellerHandlerBase$1(NumberSpellerHandlerBase numberSpellerHandlerBase) {
        this.this$0 = numberSpellerHandlerBase;
    }

    @Override
    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
        if (n2 != 0) {
            this.this$0.clearSpellerContent();
        }
    }
}

