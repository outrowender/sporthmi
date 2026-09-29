/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.commands;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListManager;
import de.audi.tghu.info.app.tmc.commands.RequestWindowCommand;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;

public class RequestWindowWithFilterCommand
extends TMCCommand {
    private int windowId = 0;
    private int windowSize;
    private int[] possibleIds;
    private int openedListAnchorId;
    private int requestId = -1;
    private final TMCAbstractListManager listManager;
    private int filter;

    public RequestWindowWithFilterCommand(int n, int n2, int[] nArray, int n3, int n4, AppTMC appTMC, LogChannel logChannel, TMCAbstractListManager tMCAbstractListManager) {
        super(appTMC, logChannel, "RequestWindowWithFilterCommand#");
        this.filter = n;
        this.listManager = tMCAbstractListManager;
        this.windowSize = n2;
        this.possibleIds = nArray;
        this.openedListAnchorId = n3;
        this.requestId = n4;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[RequestWindowWithFilterCommand#execute] Requesting windowId: %1. filter: %2", (long)this.windowId, (long)this.filter);
        this.tmcApp.getTMCHandler().setMessageFilter(this.windowId, this.filter);
    }

    @Override
    public void setMessageFilterResult(int n, int n2) {
        this.logger.log(-2137614336, "[RequestWindowCommand#setMessageFilterResult] Called, window: %1, messageFilter: %2", (long)n, (long)n2);
        this.commandList.commandFinishedWithPostCommand(new RequestWindowCommand(this.windowSize, this.possibleIds, this.openedListAnchorId, this.requestId, this.tmcApp, this.logger, this.listManager));
    }

    @Override
    public String toString() {
        return super.getClass().getName();
    }
}

