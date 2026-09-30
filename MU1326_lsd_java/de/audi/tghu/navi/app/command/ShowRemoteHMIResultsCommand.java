/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;

public class ShowRemoteHMIResultsCommand
extends NavCommand {
    private OnlinePOIResultList resultList;

    public ShowRemoteHMIResultsCommand(OnlinePOIResultList onlinePOIResultList) {
        this.resultList = onlinePOIResultList;
    }

    public void execute() {
        this.logger.log(10000000, "ShowRemoteHMIResultsCommand#execute() - length: %1", (long)this.resultList.length());
        this.navigation.getMapInterface().setRemoteHMIResultFlags(this.resultList);
        this.navigation.getMapInterface().enterRemoteHMIResultMap();
        this.getCommandList().commandFinished();
    }
}

