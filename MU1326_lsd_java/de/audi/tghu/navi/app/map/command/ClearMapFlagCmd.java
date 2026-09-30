/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.command;

import de.audi.tghu.navi.app.map.command.MapCommand;
import org.dsi.ifc.map.MapFlag;

public class ClearMapFlagCmd
extends MapCommand {
    private final MapFlag[] mapflags;

    public ClearMapFlagCmd(MapFlag[] mapFlagArray) {
        this.mapflags = mapFlagArray;
    }

    public ClearMapFlagCmd() {
        this.mapflags = null;
    }

    public void execute() {
        try {
            if (this.mapflags == null || this.mapflags.length == 0) {
                this.getMap().getMVRequest().configureFlags(1, new MapFlag[0]);
            } else {
                this.getMap().getMVRequest().configureFlags(2, this.mapflags);
            }
        }
        catch (Exception exception) {
            this.logger.log(100000, "ClearMapFlagCmd#execute() - %1", (Throwable)exception);
            this.getCommandList().commandFinished();
        }
    }

    public void configureFlags(long[] lArray) {
        this.getCommandList().commandFinished();
    }
}

