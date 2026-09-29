/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.command.poi.online.AbstractOnlineSearchCommand;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class OnlineSearchUsedPoiCommand
extends AbstractOnlineSearchCommand {
    private PoiOnlineSearchValuelistElement element;
    private int use;

    public OnlineSearchUsedPoiCommand(LogChannel logChannel, PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, int n) {
        super(logChannel);
        logChannel.log(1078071040, "PoiUsedCommand#PoiUsedCommand()");
        this.element = poiOnlineSearchValuelistElement;
        this.use = n;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "PoiUsedCommand#execute()");
        this.dsiOnlineSearch.usedPoi(this.element, this.use);
        this.getCommandList().commandFinished();
    }
}

