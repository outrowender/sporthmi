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
        iCarApplication.getMenuEntryRegistry().registerMenuEntry(600390, (short)23);
    }

    public void indicateBoardbookAvailable(boolean bl) {
        this.logChannel.log(1000000, "BoardbookHandlerEVO#indicateBoardbookAvailable %1", bl);
        if (bl) {
            this.app.getMenuEntryRegistry().updateMenuEntryVisibility(600390, 0);
        } else {
            this.app.getMenuEntryRegistry().updateMenuEntryVisibility(600390, 0);
        }
    }
}

