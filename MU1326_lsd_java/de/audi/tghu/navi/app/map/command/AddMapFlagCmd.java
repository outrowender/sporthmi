/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.command;

import de.audi.tghu.navi.app.map.command.MapCommand;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import org.dsi.ifc.map.MapFlag;

public class AddMapFlagCmd
extends MapCommand {
    private final MapFlag[] mapFlags;

    public AddMapFlagCmd(MapFlag[] mapFlagArray) {
        this.mapFlags = mapFlagArray;
    }

    @Override
    public void execute() {
        try {
            this.getMap().getMVRequest().configureFlags(0, this.mapFlags);
        }
        catch (Exception exception) {
            this.logger.log(-1601830656, "AddMapFlagCmd#execute() - %1", (Throwable)exception);
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void configureFlags(long[] lArray) {
        try {
            if (lArray == null || lArray.length != this.mapFlags.length) {
                this.logger.log(10000, "AddMapFlagCmd#configureFlags() - %1", (Object)MapUtils.toString(lArray));
            } else {
                for (int i2 = 0; i2 < this.mapFlags.length; ++i2) {
                    if (lArray[i2] != -1L) {
                        this.mapFlags[i2].handle = lArray[i2];
                        continue;
                    }
                    this.logger.log(10000, "MapFlagConfigure#configureFlags(): handle already set in map (handle is -1)");
                }
            }
        }
        catch (Exception exception) {
            this.logger.log(10000, "AddMapFlagCmd#configureFlags() - %1", (Throwable)exception);
        }
        this.getCommandList().commandFinished();
    }
}

