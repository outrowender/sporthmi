/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandlerImpl;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.oneshot.NaviOneshotHandler;
import de.audi.atip.log.LogChannel;

public class NaviOneshotAmbiguousCommand
extends AbstractSystemCallCommand {
    private final NaviSDSHandlerImpl sdsHandler;
    private final NBestStorageAccess nBestStorage;

    public NaviOneshotAmbiguousCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviSDSHandlerImpl naviSDSHandlerImpl, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.sdsHandler = naviSDSHandlerImpl;
        this.nBestStorage = nBestStorageAccess;
    }

    @Override
    public void execute() {
        byte by = this.sdsHandler.getPickListMode();
        int n = this.nBestStorage.getMatchingPicklist((byte)0).getSize();
        this.logger.log(-2137614336, "%1#execute: picklistMode=%2, lastRecogSize=%3", (Object)this.getName(), (long)by, (long)n);
        if (by == 18) {
            boolean bl = n == 1;
            int n2 = this.nBestStorage.getLastRecogLine();
            this.logger.log(-2137614336, "%1#execute: SUI selection %2, lineNumber=%3!", (Object)this.getName(), (Object)(bl ? "unique" : "from line"), (long)n2);
            this.handleOneShotData(bl ? 0 : n2, true);
        } else if (n == 1) {
            this.logger.log(-2137614336, "%1#execute: Unambiguous oneshot recognition!", (Object)this.getName());
            this.handleOneShotData(0, true);
        } else if (n > 1) {
            this.logger.log(-2137614336, "%1#execute: Ambiguous oneshot recognition!", (Object)this.getName());
            this.sendResult(3005);
        } else {
            this.logger.log(-1601830656, "%1#execute: Unhandled lastRecogSize %2!", (Object)this.getName(), (long)n);
            this.sendResult(3001);
        }
    }

    private void handleOneShotData(int n, boolean bl) {
        this.logger.log(-2137614336, "%1#handleOneShotData: lineNumber=%3, setData=%2", (Object)this.getName(), (Object)bl, (long)n);
        NaviOneshotHandler naviOneshotHandler = this.sdsHandler.getOneshotHandler();
        if (bl) {
            IPicklist iPicklist = this.nBestStorage.getMatchingPicklist((byte)0);
            if (iPicklist == null || iPicklist.getSize() <= n) {
                this.logger.log(-1601830656, "OneshotHandler#setOneshotData: Empty picklist or picklist to small!");
                this.sendResult(3001);
                return;
            }
            IPicklistElement iPicklistElement = iPicklist.get(n);
            if (iPicklistElement == null) {
                this.logger.log(-1601830656, "OneshotHandler#setOneshotData: Empty picklistElement!");
                this.sendResult(3001);
                return;
            }
            naviOneshotHandler.setOneshotData(iPicklistElement.getSlots());
        }
        this.sendResult(naviOneshotHandler.determineCorrectOneshotEvent());
    }
}

