/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class LiLastStateHistoryAddCommand
extends NavCommand {
    private boolean hasCitys;
    private NavLocation location;
    private String name;

    public LiLastStateHistoryAddCommand(NavLocation navLocation, boolean bl, String string) {
        this.location = navLocation;
        this.hasCitys = bl;
        this.name = string;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "LiLastStateHistoryAddCommand#execute() - calling liLastStateHistoryAdd(%1, %2, %3) ", (Object)LocationFormatter.formatLocationShort(this.location), (Object)Boolean.toString(this.hasCitys), (Object)this.name);
        this.getDSINavigation().liLastStateHistoryAdd(this.location, this.hasCitys, this.name);
    }

    @Override
    public void liHistoryResult(int n) {
        if (n == 0) {
            this.logger.log(-2137614336, "LiLastStateHistoryAddCommand#liHistoryResult()");
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "LiLastStateHistoryAddCommand#liHistoryResult() - commandAborted");
            this.getCommandList().commandAborted(n);
        }
    }
}

