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

    public String toString() {
        return this.getClass().getName();
    }

    public void execute() {
        this.logger.log(10000000, "[RequestMessageIdsForListElement#execute] Requesting children of parent with ID %1 ", this.parentID);
        this.tmcApp.getTMCHandler().getMessageIdsForListElement(this.parentID);
    }

    public void getMessageIdsForListElementResult(long[] lArray) {
        this.logger.log(10000000, "[RequestMessageIdsForListElement#getMessageIdsForListElementResult] %1 ", (Object)lArray);
        this.tmcApp.getResponseContainer().setChildrenTrafficEvents(lArray);
        this.getCommandList().commandFinished();
    }
}

