/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateFullListWithWaitForSubstringCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;

class ModelUpdateFullListWithWaitForSubstringCommand$1
extends NavCommand {
    private final /* synthetic */ ModelUpdateFullListWithWaitForSubstringCommand this$0;

    ModelUpdateFullListWithWaitForSubstringCommand$1(ModelUpdateFullListWithWaitForSubstringCommand modelUpdateFullListWithWaitForSubstringCommand, String string) {
        this.this$0 = modelUpdateFullListWithWaitForSubstringCommand;
        super(string);
    }

    @Override
    public void execute() {
        LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
        int n = lIValueList.getList().length;
        if (n > 0) {
            this.logger.log(-2137614336, "%1#execute() - valueListSize = %2", (Object)this.CLASS_NAME, (long)n);
            int n2 = lIValueList.getList()[n - 1].getListIndex() + 1;
            this.getCommandList().commandFinishedWithPostCommand(new LISPRequestValueListByListIndexCommand(n2, true));
        } else {
            this.logger.log(10000, "%1#execute() - The valueList is Empty. Cant continue requesting items", (Object)this.CLASS_NAME);
            this.getCommandList().commandFinished();
        }
    }
}

