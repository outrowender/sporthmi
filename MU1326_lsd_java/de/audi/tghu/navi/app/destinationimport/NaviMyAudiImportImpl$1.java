/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.destinationimport;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiImportImpl;

class NaviMyAudiImportImpl$1
extends Command {
    private final /* synthetic */ NaviMyAudiImportImpl this$0;

    NaviMyAudiImportImpl$1(NaviMyAudiImportImpl naviMyAudiImportImpl, LogChannel logChannel) {
        this.this$0 = naviMyAudiImportImpl;
        super(logChannel);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "NaviMyAudiImportImpl#checkCurrentImportStatus execute myAudiResponse");
        if (NaviMyAudiImportImpl.access$000(this.this$0) == null) {
            this.logger.log(1078071040, "NaviMyAudiImportImpl#checkCurrentImportStatus execute myAudiResponse.Listener is null");
            return;
        }
        long[] lArray = this.this$0.convertyArrayListToArray(this.this$0.importedAdbEntries);
        long[] lArray2 = this.this$0.convertyArrayListToArray(this.this$0.notImportedAdbEntries);
        NaviMyAudiImportImpl.access$000(this.this$0).myAudiAdbImportResult(lArray, lArray2);
        this.getCommandList().commandFinished();
    }
}

