/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.eni;

import de.audi.app.bap.eni.AppConnectorENI;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG$NoResponseFromFSGHandler;

class AppConnectorENI$1
implements BAPFunctionArrayASG$NoResponseFromFSGHandler {
    private final /* synthetic */ AppConnectorENI this$0;

    AppConnectorENI$1(AppConnectorENI appConnectorENI) {
        this.this$0 = appConnectorENI;
    }

    @Override
    public void noResponseFromFSG() {
        AppConnectorENI.access$000(this.this$0).log(-1601830656, "[AppConnectorENI#noResponseFromFSG] Clearing destination list.");
        AppConnectorENI.access$100(this.this$0).getBapArrayDataENI().getDestinationList().clear();
    }
}

