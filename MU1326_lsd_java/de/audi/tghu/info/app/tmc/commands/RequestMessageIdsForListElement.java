/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.commands;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;

public class RequestMessageIdsForListElement
extends TMCCommand {
    private final long parentID;

    public RequestMessageIdsForListElement(AppTMC appTMC, LogChannel logChannel, long l) {
        super(appTMC, logChannel, "RequestMessageIdsForListElement#");
        this.parentID = l;
    }

    @Override
    public String toString() {
        return super.getClass().getName();
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[RequestMessageIdsForListElement#execute] Requesting children of parent with ID %1 ", this.parentID);
        this.tmcApp.getTMCHandler().getMessageIdsForListElement(this.parentID);
    }

    @Override
    public void getMessageIdsForListElementResult(long[] lArray) {
        this.logger.log(-2137614336, "[RequestMessageIdsForListElement#getMessageIdsForListElementResult] %1 ", (Object)lArray);
        this.tmcApp.getResponseContainer().setChildrenTrafficEvents(lArray);
        this.getCommandList().commandFinished();
    }
}

