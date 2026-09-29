/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence;
import org.dsi.ifc.navigation.LIValueListElement;

class AbstractAddressInputMatchSpellerSequence$3
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ int val$stellerStackID;
    private final /* synthetic */ AbstractAddressInputMatchSpellerSequence this$0;

    AbstractAddressInputMatchSpellerSequence$3(AbstractAddressInputMatchSpellerSequence abstractAddressInputMatchSpellerSequence, String string, int n, int n2) {
        this.this$0 = abstractAddressInputMatchSpellerSequence;
        this.val$model = n;
        this.val$stellerStackID = n2;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.getLispValueListCount() == 1L) {
            this.this$0.logChannel.log(-2137614336, "%1#setSpellerStatusWaiting for model=%2", (Object)this.CLASS_NAME, (long)this.val$model);
            SpellerModelApp spellerModelApp = this.env.getSpellerModel(this.val$model);
            spellerModelApp.setControlButtonStates(0, 0);
            LIValueListElement lIValueListElement = this.dsiResponseContainer.getLispValueList().getList()[0];
            CommandList commandList = this.this$0.getSelectListElementCommandList(lIValueListElement);
            this.this$0.sendLocationToOnline(this.env, this.val$model, 0, this.val$stellerStackID, commandList);
            this.getCommandList().commandFinishedWithPostSequence(commandList);
            return;
        }
        this.this$0.spellerStack.pop();
        this.getCommandList().commandFinished();
    }
}

