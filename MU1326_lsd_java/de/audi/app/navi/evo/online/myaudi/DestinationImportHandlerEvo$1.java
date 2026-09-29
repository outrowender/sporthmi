/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online.myaudi;

import de.audi.app.navi.evo.online.myaudi.DestinationImportHandlerEvo;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiSaveToAdbCommand$IAdbImportListener;

class DestinationImportHandlerEvo$1
implements NaviMyAudiSaveToAdbCommand$IAdbImportListener {
    private final /* synthetic */ DestinationImportHandlerEvo this$0;

    DestinationImportHandlerEvo$1(DestinationImportHandlerEvo destinationImportHandlerEvo) {
        this.this$0 = destinationImportHandlerEvo;
    }

    @Override
    public void adbImportResult(long l, boolean bl, boolean bl2, boolean bl3) {
        this.this$0.checkCurrentImportStatus(l, bl, bl2, bl3);
    }
}

