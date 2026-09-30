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
        logChannel.log(1000000, "OnlineSearchCancelCommand#ctor()");
    }

    public void execute() {
        this.logger.log(10000000, "OnlineSearchCancelCommand#execute: Cancelling current search.");
        this.dsiOnlineSearch.poiStopSelection();
        this.getCommandList().commandFinished();
    }

    public void poiResult(int n, int n2, int n3) {
    }

    public void poiSpellingSuggestion(int n, String string, String[] stringArray) {
    }

    public void poiValueList(int n, int n2, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n3, int n4) {
    }
}

