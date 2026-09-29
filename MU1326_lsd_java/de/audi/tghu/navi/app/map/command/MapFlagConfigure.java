/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.command;

import de.audi.tghu.navi.app.map.command.MapCommand;
import org.dsi.ifc.map.MapFlag;

public class MapFlagConfigure
extends MapCommand {
    private final int command;
    private final MapFlag[] mapFlags;

    public MapFlagConfigure(int n, MapFlag[] mapFlagArray) {
        this.command = n;
        this.mapFlags = mapFlagArray;
    }

    @Override
    public void execute() {
        this.getMap().getMVRequest().configureFlags(this.command, this.mapFlags);
    }

    @Override
    public void configureFlags(long[] lArray) {
        if (this.command == 0) {
            for (int i2 = 0; i2 < this.mapFlags.length; ++i2) {
                if (lArray[i2] != -1L) {
                    this.mapFlags[i2].handle = lArray[i2];
                    continue;
                }
                this.logger.log(10000, "MapFlagConfigure#configureFlags(): handle already set in map (handle is -1)");
            }
        }
        this.getCommandList().commandFinished();
    }
}

