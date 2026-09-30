/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviPOIOneshotAmbiguousCommand
extends AbstractSystemCallCommand {
    private final NaviSDSHandler sdsHandler;
    private final NBestStorageAccess nBestStorage;

    public NaviPOIOneshotAmbiguousCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviSDSHandler naviSDSHandler, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.sdsHandler = naviSDSHandler;
        this.nBestStorage = nBestStorageAccess;
    }

    public void execute() {
        byte by = this.sdsHandler.getPickListMode();
        int n = this.nBestStorage.getMatchingPicklist((byte)0).getSize();
        this.logger.log(10000000, "%1#execute: picklistMode=%2, lastRecogSize=%3", (Object)this.getName(), (long)n);
        if (by == 18) {
            boolean bl = n == 1;
            int n2 = this.nBestStorage.getLastRecogLine();
            this.logger.log(10000000, "%1#execute: SUI selection %2, lineNumber=%3!", (Object)this.getName(), (Object)(bl ? "unique" : "from line"), (long)n2);
            this.handleOneShotData(bl ? 0 : n2, bl);
        } else if (n == 1) {
            this.logger.log(10000000, "%1#execute: Unambiguous oneshot recognition!", (Object)this.getName());
            this.handleOneShotData(0, true);
        } else if (n > 1) {
            this.logger.log(10000000, "%1#execute: Ambiguous oneshot recognition!", (Object)this.getName());
            this.sendResult(3005);
        } else {
            this.logger.log(100000, "%1#execute: Unhandled lastRecogSize %2!", (Object)this.getName(), (long)n);
            this.sendResult(3001);
        }
    }

    private void handleOneShotData(int n, boolean bl) {
        this.logger.log(10000000, "%1#handleOneShotData: lineNumber=%3", (Object)this.getName(), (long)n);
        if (bl && !this.sdsHandler.setOneshotData(n)) {
            this.logger.log(10000000, "%1#handleOneShotData: Setting oneshot data failed, sending error!", (Object)this.getName());
            this.sendResult(40001);
            return;
        }
        NaviService.OneshotData oneshotData = this.sdsHandler.getOneshotData((byte)0);
        NaviService.OneshotData oneshotData2 = this.sdsHandler.getOneshotData((byte)1);
        this.logger.log(10000000, "%1#handleOneShotData: firstLevel=%2, secondLevel=%3!", (Object)this.getName(), (Object)oneshotData, (Object)oneshotData2);
        if (SDSUtils.isEmpty(oneshotData2)) {
            this.logger.log(10000000, "%1#handleOneShotData: Just POI recognized!", (Object)this.getName());
            this.sendResult(40008);
        } else {
            this.logger.log(10000000, "%1#handleOneShotData: Perfect oneshot!", (Object)this.getName());
            this.sendResult(3000);
        }
    }
}

