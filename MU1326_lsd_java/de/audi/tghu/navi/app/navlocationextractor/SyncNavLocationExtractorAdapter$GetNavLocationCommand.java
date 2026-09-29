/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.SyncNavLocationExtractorAdapter;
import org.dsi.ifc.global.NavLocation;

class SyncNavLocationExtractorAdapter$GetNavLocationCommand
extends NavCommand {
    private NavLocation resultLocation;
    private Object waitingLock;
    private final /* synthetic */ SyncNavLocationExtractorAdapter this$0;

    public SyncNavLocationExtractorAdapter$GetNavLocationCommand(SyncNavLocationExtractorAdapter syncNavLocationExtractorAdapter, Object object) {
        this.this$0 = syncNavLocationExtractorAdapter;
        this.waitingLock = object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void execute() {
        Object object = this.waitingLock;
        synchronized (object) {
            this.resultLocation = (NavLocation)this.getCommandList().get("navLocation");
            this.waitingLock.notify();
        }
        this.getCommandList().commandFinished();
    }

    public NavLocation getResult() {
        return this.resultLocation;
    }
}

