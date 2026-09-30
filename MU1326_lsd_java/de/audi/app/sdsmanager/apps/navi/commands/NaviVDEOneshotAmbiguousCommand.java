/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandlerImpl;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviVDEOneshotAmbiguousCommand
extends AbstractSystemCallCommand {
    private final NaviSDSHandlerImpl sdsHandler;
    private final NBestStorageAccess nBestStorage;

    public NaviVDEOneshotAmbiguousCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviSDSHandlerImpl naviSDSHandlerImpl, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.sdsHandler = naviSDSHandlerImpl;
        this.nBestStorage = nBestStorageAccess;
    }

    public void execute() {
        byte by = this.sdsHandler.getPickListMode();
        int n = this.nBestStorage.getMatchingPicklist((byte)0).getSize();
        this.logger.log(10000000, "%1#execute: picklistMode=%2, lastRecogSize=%3", (Object)this.getName(), (long)by, (long)n);
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
        this.logger.log(10000000, "%1#handleOneShotData: lineNumber=%3, setData=%2", (Object)this.getName(), (Object)bl, (long)n);
        if (bl && !this.sdsHandler.setOneshotData(n)) {
            this.logger.log(10000000, "%1#handleOneShotData: Setting oneshot data failed, sending error!", (Object)this.getName());
            this.sendResult(3001);
            return;
        }
        NaviService.OneshotData oneshotData = this.sdsHandler.getOneshotData((byte)0);
        NaviService.OneshotData oneshotData2 = this.sdsHandler.getOneshotData((byte)1);
        NaviService.OneshotData oneshotData3 = this.sdsHandler.getOneshotData((byte)2);
        NaviService.OneshotData oneshotData4 = this.sdsHandler.getOneshotData((byte)3);
        this.logger.log(10000000, "%1#handleOneShotData: firstLevel=%2, secondLevel=%3!", (Object)this.getName(), (Object)oneshotData, (Object)oneshotData2);
        this.logger.log(10000000, "%1#handleOneShotData: thirdLevel=%2, fourthLevel=%3!", (Object)this.getName(), (Object)oneshotData3, (Object)oneshotData4);
        if (SDSUtils.isEmpty(oneshotData2)) {
            this.logger.log(10000000, "%1#handleOneShotData: Just first level recognized!", (Object)this.getName());
            this.sendResult(40003);
        } else if (SDSUtils.isEmpty(oneshotData3)) {
            this.logger.log(10000000, "%1#handleOneShotData: No third level filled!", (Object)this.getName());
            this.sendResult(40002);
        } else if (SDSUtils.isEmpty(oneshotData4)) {
            this.logger.log(10000000, "%1#handleOneShotData: No fourth level filled!", (Object)this.getName());
            this.sendResult(3000);
        } else {
            this.logger.log(10000000, "%1#handleOneShotData: Perfect oneshot!", (Object)this.getName());
            this.sendResult(3000);
        }
    }
}

