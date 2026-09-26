/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequence;
import org.dsi.ifc.navigation.LIValueListElement;

class AddressInputCityZipSequence$2
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ int val$stellerStackID;
    private final /* synthetic */ AddressInputCityZipSequence this$0;

    AddressInputCityZipSequence$2(AddressInputCityZipSequence addressInputCityZipSequence, String string, int n, int n2) {
        this.this$0 = addressInputCityZipSequence;
        this.val$model = n;
        this.val$stellerStackID = n2;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.getLispValueListCount() == 1L) {
            LIValueListElement lIValueListElement = this.dsiResponseContainer.getLispValueList().getList()[0];
            CommandList commandList = this.this$0.getSelectListElementCommandList(lIValueListElement);
            this.this$0.sendLocationToOnline(this.env, this.val$model, 0, this.val$stellerStackID, commandList);
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.inputManager.handleAddressInputEvent(commandList, this.this$0.inputManager.getAutoSelectLeftElementEventId()));
            return;
        }
        this.this$0.spellerStack.pop();
        this.getCommandList().commandFinished();
    }
}

