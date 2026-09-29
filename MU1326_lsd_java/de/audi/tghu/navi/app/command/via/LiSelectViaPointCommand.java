/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.via;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

public class LiSelectViaPointCommand
extends NavCommand {
    private int viaPointId;

    public LiSelectViaPointCommand(int n) {
        this.viaPointId = n;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "LiSelectViaPointCommand#execute() - calling liSelectViaPoint() ");
        this.getDSINavigation().liSelectViaPoint(this.viaPointId);
    }

    @Override
    public void liSelectViaPointResult(NavLocation navLocation, int n) {
        this.logger.log(-2137614336, "LiSelectViaPointCommand#liSelectViaPointResult()");
        if (n == 0) {
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "LiSelectViaPointCommand#liSelectViaPointResult() - got error code %1 !", (long)n);
            this.getCommandList().commandAborted(n);
        }
    }
}

