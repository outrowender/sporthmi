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
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;

public class ModelUpdateChildCategoryListCommand
extends NavCommand {
    private final IPoiScreenUpdateResultList modelAccess;
    private final ICommandListFactory commandListFactory;

    public ModelUpdateChildCategoryListCommand(IPoiScreenUpdateResultList iPoiScreenUpdateResultList, ICommandListFactory iCommandListFactory) {
        this.modelAccess = iPoiScreenUpdateResultList;
        this.commandListFactory = iCommandListFactory;
    }

    public void execute() {
        int n = 0;
        LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
        this.logger.log(10000000, "ModelUpdateChildCategoryListCommand#execute - valueList=%1", (Object)lIValueList);
        if (Util.isListValid(lIValueList) && lIValueList.getList().length > 0) {
            n = lIValueList.getList().length;
            if ((long)(lIValueList.getList()[n - 1].getListIndex() + 1) >= this.dsiResponseContainer.getLispValueListCount()) {
                if (this.logger.isDebug2()) {
                    this.logger.log(100000000, "ModelUpdateChildCategoryListCommand#execute - valueListSize: %1, rcCount: %2, lastIndex = %3", (long)n, this.dsiResponseContainer.getLispValueListCount(), (long)lIValueList.getList()[n - 1].getListIndex());
                }
                this.getCommandList().commandFinishedWithPostCommand(new NewModelUpdateResultListCommand(this.modelAccess));
            } else {
                if (this.logger.isDebug2()) {
                    this.logger.log(100000000, "ModelUpdateChildCategoryListCommand#execute - valueListSize: %1, rcCount: %2, lastIndex = %3", (long)n, this.dsiResponseContainer.getLispValueListCount(), (long)lIValueList.getList()[n - 1].getListIndex());
                }
                CommandList commandList = this.commandListFactory.createCommandList();
                commandList.add(new NewModelUpdateResultListCommand(this.modelAccess));
                commandList.add(new LISPRequestValueListByListIndexCommand(lIValueList.getList()[n - 1].getListIndex(), true));
                commandList.add(new ModelUpdateChildCategoryListCommand(this.modelAccess, this.commandListFactory));
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        } else {
            this.logger.log(10000000, "ModelUpdateChildCategoryListCommand#execute - received empty LIValueList from DSI.");
            this.getCommandList().commandAborted("received empty LIValueList from DSI");
        }
    }
}

