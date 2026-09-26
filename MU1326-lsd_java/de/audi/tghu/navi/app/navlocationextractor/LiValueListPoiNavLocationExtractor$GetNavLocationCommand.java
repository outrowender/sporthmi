/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.LiValueListPoiNavLocationExtractor;
import org.dsi.ifc.global.NavLocation;

class LiValueListPoiNavLocationExtractor$GetNavLocationCommand
extends NavCommand {
    private NavLocation resultLocation;
    private Object waitingLock;
    private final /* synthetic */ LiValueListPoiNavLocationExtractor this$0;

    public LiValueListPoiNavLocationExtractor$GetNavLocationCommand(LiValueListPoiNavLocationExtractor liValueListPoiNavLocationExtractor, Object object) {
        this.this$0 = liValueListPoiNavLocationExtractor;
        this.waitingLock = object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void execute() {
        Object object = this.waitingLock;
        synchronized (object) {
            this.resultLocation = this.dsiResponseContainer.getLiCurrentLD();
            this.waitingLock.notify();
        }
        this.getCommandList().commandFinished();
    }

    public NavLocation getResult() {
        return this.resultLocation;
    }
}

