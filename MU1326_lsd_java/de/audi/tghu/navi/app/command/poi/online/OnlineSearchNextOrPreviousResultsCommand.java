/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.command.poi.online.AbstractOnlineSearchCommand;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.poi.online.OnlineSearchContext;

public class OnlineSearchNextOrPreviousResultsCommand
extends AbstractOnlineSearchCommand {
    private int indexOfFirstItem;

    public OnlineSearchNextOrPreviousResultsCommand(LogChannel logChannel, int n, IOnlineSearchForm iOnlineSearchForm, OnlineSearchContext onlineSearchContext) {
        super(logChannel, iOnlineSearchForm, onlineSearchContext);
        this.indexOfFirstItem = n;
        logChannel.log(1000000, "OnlineSearchNextOrPreviousResultsCommand#OnlineSearchNextOrPreviousResultsCommand()");
    }

    public void execute() {
        this.logger.log(10000000, "OnlineSearchNextOrPreviousResultsCommand#execute() Requesting results from index : %1", (long)this.indexOfFirstItem);
        this.dsiOnlineSearch.poiRequestValueList(this.indexOfFirstItem, 10);
    }
}

