/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateResultListCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.ValueListStatus;

public class ModelUpdateFullListWithWaitCommand
extends NavCommand {
    private final IMatchspellerModelAccess modelAccess;
    private final ICommandListFactory commandListFactory;
    private final int minimumResultsToGoOn;
    private final int requestID;
    private final int startIndex;
    private static final int NO_MAX;

    public ModelUpdateFullListWithWaitCommand(IMatchspellerModelAccess iMatchspellerModelAccess, ICommandListFactory iCommandListFactory, int n) {
        this(iMatchspellerModelAccess, iCommandListFactory, -2, -2, n);
    }

    public ModelUpdateFullListWithWaitCommand(IMatchspellerModelAccess iMatchspellerModelAccess, ICommandListFactory iCommandListFactory) {
        this(iMatchspellerModelAccess, iCommandListFactory, -2, -2, 0);
    }

    public ModelUpdateFullListWithWaitCommand(IMatchspellerModelAccess iMatchspellerModelAccess, ICommandListFactory iCommandListFactory, int n, int n2) {
        this(iMatchspellerModelAccess, iCommandListFactory, n, n2, 0);
    }

    public ModelUpdateFullListWithWaitCommand(IMatchspellerModelAccess iMatchspellerModelAccess, ICommandListFactory iCommandListFactory, int n, int n2, int n3) {
        this.modelAccess = iMatchspellerModelAccess;
        this.commandListFactory = iCommandListFactory;
        this.minimumResultsToGoOn = n3;
        this.requestID = n;
        this.startIndex = n2;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "ModelUpdateFullListWithWaitCommand#execute - maxResults: %1", (long)this.minimumResultsToGoOn);
        int n = 0;
        LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
        if (lIValueList == null || lIValueList.getList() == null) {
            this.getCommandList().commandAborted("ModelUpdateFullListWithWaitCommand#execute - valueList or valueList.getList() is null");
            return;
        }
        n = lIValueList.getList().length;
        ValueListStatus valueListStatus = this.dsiResponseContainer.getPoiSubstringSearchStatus();
        if (valueListStatus == null) {
            this.getCommandList().commandAborted("ModelUpdateFullListWithWaitCommand#execute - getPoiSubstringSearchStatus() is null");
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        this.logger.log(1078071040, "ModelUpdateFullListWithWaitCommand#execute - valueListSize = %1", (long)n);
        boolean bl = n < this.minimumResultsToGoOn;
        boolean bl2 = valueListStatus.getStatus() != 1;
        boolean bl3 = valueListStatus.getStatus() != 3;
        boolean bl4 = valueListStatus.getNumberOfAvailableItems() >= this.minimumResultsToGoOn;
        this.logger.log(1078071040, "ModelUpdateFullListWithWaitCommand#execute - isValueListTooSmall = %1, searchIsNotCanceled = %2, searchisNotFinished = %3", bl, bl2, bl3);
        if (bl && bl2 && bl3 || bl && !bl3 && bl4) {
            if (n == 0) {
                this.logger.log(1078071040, "ModelUpdateFullListWithWaitCommand#execute - valueListSize = %1", (long)n);
                commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
            } else {
                commandList.add(new LISPRequestValueListByListIndexCommand(lIValueList.getList()[n - 1].getListIndex(), true));
            }
            commandList.add(new ModelUpdateFullListWithWaitCommand(this.modelAccess, this.commandListFactory, this.requestID, this.startIndex, this.minimumResultsToGoOn));
        } else {
            if (this.logger.isDebug2()) {
                this.logger.log(14808325, "ModelUpdateFullListWithWaitCommand#execute - requestID = %1, startIndex = %2, minimumResults = %3", (long)this.requestID, (long)this.startIndex, (long)this.minimumResultsToGoOn);
            }
            if (this.requestID == -2 || this.startIndex == -2) {
                commandList.add(new ModelUpdateResultListCommand(this.modelAccess));
            } else {
                if (this.logger.isDebug2()) {
                    this.logger.log(14808325, "modelAccess: %1", (Object)this.modelAccess);
                }
                commandList.add(new ModelUpdateResultListCommand(this.modelAccess, this.requestID, this.startIndex));
            }
        }
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

