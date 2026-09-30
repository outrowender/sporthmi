/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.commands;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListManager;
import de.audi.tghu.info.app.tmc.TMCHelper;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;
import org.dsi.ifc.tmc.TmcListElement;

public class RequestWindowCommand
extends TMCCommand {
    private int windowId = 0;
    private int offset = 21;
    private int windowSize;
    private int[] possibleIds;
    private int openedListAnchorId;
    private int requestId = -1;
    private final TMCAbstractListManager listManager;
    private BaseListModelApp listModelEmptyCopy;

    public RequestWindowCommand(int n, int[] nArray, int n2, int n3, AppTMC appTMC, LogChannel logChannel, TMCAbstractListManager tMCAbstractListManager) {
        super(appTMC, logChannel, "RequestWindowCommand");
        this.listManager = tMCAbstractListManager;
        this.windowSize = n + 1 + this.offset;
        this.possibleIds = nArray;
        this.openedListAnchorId = n2;
        this.requestId = n3;
    }

    public void execute() {
        this.logger.log(10000000, "[RequestWindowCommand#execute] Requesting window, windowId: %1, windowSize: %2, offset: %3 ", (long)this.windowId, (long)this.windowSize, (long)this.offset);
        this.logger.log(10000000, "[RequestWindowCommand#execute] Requesting window, %1, openedListAnchorId %2 ", (Object)TMCHelper.arrayToString("anchorId", this.possibleIds), (long)this.openedListAnchorId);
        this.listModelEmptyCopy = this.listManager.getEmptyListModelCopy();
        this.tmcApp.getTMCHandler().requestTMCWindow(this.windowSize, this.offset, this.possibleIds, this.openedListAnchorId, this.windowId, this.tmcApp.isNavigationOperable());
    }

    public void tmcWindowResult(int n, int n2, TmcListElement[] tmcListElementArray) {
        if (tmcListElementArray == null || tmcListElementArray.length == 0) {
            this.logger.log(100000, "[RequestWindowCommand#tmcWindowResult] messages is null or empty []: %1", (Object)tmcListElementArray);
            this.getCommandList().commandFinished();
            return;
        }
        this.logger.log(10000000, "[RequestWindowCommand#tmcWindowResult] Received, window: %2, usedAnchorId: %3, numberOfMessages: %1 ", (long)tmcListElementArray.length, (long)n, (long)n2);
        if (this.logger.isDebug2()) {
            for (int i2 = 0; i2 < tmcListElementArray.length; ++i2) {
                TmcListElement tmcListElement = tmcListElementArray[i2];
                this.logger.log(100000000, "RequestTmcWindowCommand#tmcWindowResult() received, tmcListElement(%1, uID=%2): [%3] %4", (Object)String.valueOf(i2), (Object)String.valueOf(tmcListElement.getUID()), (Object)String.valueOf(tmcListElement.positionInCompleteList), (Object)tmcListElement);
            }
        } else if (tmcListElementArray.length != 0) {
            this.logger.log(10000000, "RequestTmcWindowCommand#tmcWindowResult() received, {%1} elements from position {%2} to {%3}", (Object)String.valueOf(tmcListElementArray.length), (Object)String.valueOf(tmcListElementArray[0].positionInCompleteList), (Object)String.valueOf(tmcListElementArray[tmcListElementArray.length - 1].positionInCompleteList));
        }
        this.listModelEmptyCopy.setLength(this.listManager.getLengthOfCurrentList());
        this.commandList.commandFinishedWithPostSequence(this.listManager.tmcWindowResult(tmcListElementArray, n2, this.requestId, this.possibleIds[0], this.listModelEmptyCopy));
    }

    public void updateEventsTotal(int n, long l, long l2, int n2) {
        this.logger.log(10000000, "[RequestWindowCommand#updateEventsTotal] Called, windowId: %1, eventsTotal: %2, eventsVisible: %3", (long)n, l, l2);
        this.logger.log(10000000, "[RequestWindowCommand#updateEventsTotal] validFlag: %1 ", (long)n2);
        if (n2 == 1) {
            this.tmcApp.listManager.updateEventsTotal((int)l2);
        } else {
            this.logger.log(10000000, "[RequestWindowCommand#updateEventsTotal] Invalid value. ");
        }
    }

    public String toString() {
        return this.getClass().getName();
    }
}

