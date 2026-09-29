/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.boardbook;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.boardbook.BoardbookHandler;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;

public class BoardbookHandlerEvo
extends BoardbookHandler {
    private ICarApplication app;

    public BoardbookHandlerEvo(LogChannel logChannel, HMIService hMIService, ICarApplication iCarApplication) {
        super(logChannel, iCarApplication.getFrameworkAccess());
        this.app = iCarApplication;
        iCarApplication.getMenuEntryRegistry().registerMenuEntry(1177094400, (short)23);
    }

    @Override
    public void indicateBoardbookAvailable(boolean bl) {
        this.logChannel.log(1078071040, "BoardbookHandlerEVO#indicateBoardbookAvailable %1", bl);
        if (bl) {
            this.app.getMenuEntryRegistry().updateMenuEntryVisibility(1177094400, 0);
        } else {
            this.app.getMenuEntryRegistry().updateMenuEntryVisibility(1177094400, 0);
        }
    }
}

