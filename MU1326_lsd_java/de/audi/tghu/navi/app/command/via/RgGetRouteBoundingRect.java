/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.via;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavRectangle;

public class RgGetRouteBoundingRect
extends NavCommand {
    private boolean bCompleteTour = false;
    private int iDestinationIndex = -1;

    public RgGetRouteBoundingRect(boolean bl, int n) {
        super("RgGetRouteBoundingRect");
        this.bCompleteTour = bl;
        this.iDestinationIndex = n;
    }

    public void execute() {
        this.logger.log(10000000, "RgGetRouteBoundingRect#execute() - calling rgGetRouteBoundingRectangle( %1, %2 ) ", this.bCompleteTour, (long)this.iDestinationIndex);
        this.getDSINavigation().rgGetRouteBoundingRectangle(this.bCompleteTour, this.iDestinationIndex);
    }

    public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle) {
        this.getCommandList().commandFinished();
    }
}

