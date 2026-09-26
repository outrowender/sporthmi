/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultListCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenUpdateResultList;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;

public class NewModelUpdateFullListCommand
extends NavCommand {
    private final IPoiScreenUpdateResultList modelAccess;
    private final ICommandListFactory commandListFactory;
    private final int maximumResults;
    private static final int NO_MAX;

    public NewModelUpdateFullListCommand(IPoiScreenUpdateResultList iPoiScreenUpdateResultList, ICommandListFactory iCommandListFactory, int n) {
        this.modelAccess = iPoiScreenUpdateResultList;
        this.commandListFactory = iCommandListFactory;
        this.maximumResults = n;
    }

    public NewModelUpdateFullListCommand(IPoiScreenUpdateResultList iPoiScreenUpdateResultList, ICommandListFactory iCommandListFactory) {
        this(iPoiScreenUpdateResultList, iCommandListFactory, 0);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "NewModelUpdateFullListCommand#execute - maxResults: %1", (long)this.maximumResults);
        int n = 0;
        LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
        if (lIValueList != null && lIValueList.getList() != null && (n = lIValueList.getList().length) > 0) {
            n = lIValueList.getList()[n - 1].getListIndex() + 1;
        }
        this.logger.log(-2137614336, "%1#execute - valueListSize=%2", (Object)this.CLASS_NAME, (long)n);
        if ((long)n >= this.dsiResponseContainer.getLispValueListCount() || this.maximumResults > 0 && n >= this.maximumResults) {
            this.logger.log(1078071040, "NewModelUpdateFullListCommand#execute - valueListSize: %1, rcCount: %2", (long)n, this.dsiResponseContainer.getLispValueListCount());
            this.getCommandList().commandFinishedWithPostCommand(new NewModelUpdateResultListCommand(this.modelAccess));
        } else {
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
            commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
            commandList.add(new NewModelUpdateFullListCommand(this.modelAccess, this.commandListFactory, this.maximumResults));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        }
    }
}

