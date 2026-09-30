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

public class ModelUpdateFullListCommand
extends NavCommand {
    private final IMatchspellerModelAccess modelAccess;
    private final ICommandListFactory commandListFactory;
    private final int maximumResults;
    private static final int NO_MAX = 0;

    public ModelUpdateFullListCommand(IMatchspellerModelAccess iMatchspellerModelAccess, ICommandListFactory iCommandListFactory, int n) {
        this.modelAccess = iMatchspellerModelAccess;
        this.commandListFactory = iCommandListFactory;
        this.maximumResults = n;
    }

    public ModelUpdateFullListCommand(IMatchspellerModelAccess iMatchspellerModelAccess, ICommandListFactory iCommandListFactory) {
        this(iMatchspellerModelAccess, iCommandListFactory, 0);
    }

    public void execute() {
        this.logger.log(1000000, "ModelUpdateFullListCommand#execute - maxResults: %1", (long)this.maximumResults);
        int n = 0;
        LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
        if (lIValueList != null && lIValueList.getList() != null && (n = lIValueList.getList().length) > 0) {
            n = lIValueList.getList()[n - 1].getListIndex() + 1;
        }
        if ((long)n >= this.dsiResponseContainer.getLispValueListCount() || this.maximumResults > 0 && n >= this.maximumResults) {
            this.logger.log(1000000, "ModelUpdateFullListCommand#execute - valueListSize: %1, rcCount: %2", (long)n, this.dsiResponseContainer.getLispValueListCount());
            this.getCommandList().commandFinishedWithPostCommand(new ModelUpdateResultListCommand(this.modelAccess));
        } else {
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new ModelUpdateResultListCommand(this.modelAccess));
            commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
            commandList.add(new ModelUpdateFullListCommand(this.modelAccess, this.commandListFactory, this.maximumResults));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        }
    }
}

