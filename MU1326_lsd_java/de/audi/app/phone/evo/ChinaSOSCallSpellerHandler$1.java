/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.evo.ChinaSOSCallSpellerHandler;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

class ChinaSOSCallSpellerHandler$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ ChinaSOSCallSpellerHandler this$0;

    ChinaSOSCallSpellerHandler$1(ChinaSOSCallSpellerHandler chinaSOSCallSpellerHandler) {
        this.this$0 = chinaSOSCallSpellerHandler;
    }

    @Override
    public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
        if (n2 != 0) {
            this.this$0.clearSpellerContent();
        }
    }
}

