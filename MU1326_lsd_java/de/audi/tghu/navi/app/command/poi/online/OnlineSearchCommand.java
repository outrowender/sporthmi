/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.command.poi.online.AbstractOnlineSearchCommand;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.poi.online.OnlineSearchContext;

public class OnlineSearchCommand
extends AbstractOnlineSearchCommand {
    private int longitude;
    private int latitude;
    private String searchString;
    private LogChannel logger;

    public OnlineSearchCommand(LogChannel logChannel, String string, int n, int n2, boolean bl, IOnlineSearchForm iOnlineSearchForm, OnlineSearchContext onlineSearchContext) {
        super(logChannel, iOnlineSearchForm, onlineSearchContext);
        logChannel.log(1078071040, "OnlineSearchCommand#OnlineSearchCommand()");
        this.logger = logChannel;
        this.longitude = n;
        this.latitude = n2;
        this.searchString = string;
        this.spellingSuggestion = bl;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "OnlineSearchCommand#execute searchString %1 longitude %2 latitude %3", (Object)this.searchString, (long)this.longitude, (long)this.latitude);
        this.dsiOnlineSearch.poiStartSelection(this.searchString, this.longitude, this.latitude, 500, 10);
    }
}

