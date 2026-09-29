/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.command.poi.online.AbstractOnlineSearchCommand;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;

public class OnlineSearchCancelCommand
extends AbstractOnlineSearchCommand {
    public OnlineSearchCancelCommand(LogChannel logChannel) {
        super(logChannel);
        logChannel.log(1078071040, "OnlineSearchCancelCommand#ctor()");
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "OnlineSearchCancelCommand#execute: Cancelling current search.");
        this.dsiOnlineSearch.poiStopSelection();
        this.getCommandList().commandFinished();
    }

    @Override
    public void poiResult(int n, int n2, int n3) {
    }

    @Override
    public void poiSpellingSuggestion(int n, String string, String[] stringArray) {
    }

    @Override
    public void poiValueList(int n, int n2, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n3, int n4) {
    }
}

