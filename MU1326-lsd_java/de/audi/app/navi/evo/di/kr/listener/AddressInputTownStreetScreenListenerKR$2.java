/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.listener;

import de.audi.app.navi.evo.di.kr.listener.AddressInputTownStreetScreenListenerKR;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;

class AddressInputTownStreetScreenListenerKR$2
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ AddressInputTownStreetScreenListenerKR this$0;

    AddressInputTownStreetScreenListenerKR$2(AddressInputTownStreetScreenListenerKR addressInputTownStreetScreenListenerKR, int n, int n2) {
        this.this$0 = addressInputTownStreetScreenListenerKR;
        this.val$model = n;
        this.val$terminal = n2;
    }

    @Override
    public void execute() {
        CommandList commandList = AddressInputTownStreetScreenListenerKR.access$100(this.this$0).createCommandList();
        if (this.env.getChoiceModel(1042351616).getValue() == 1) {
            AddressInputTownStreetScreenListenerKR.access$200(this.this$0, this.val$model, this.val$terminal, commandList);
            commandList.add(AddressInputTownStreetScreenListenerKR.access$400(this.this$0).handleAddressInputEvent(AddressInputTownStreetScreenListenerKR.access$300(this.this$0).createCommandList(), -1684144128));
        } else if (this.env.getChoiceModel(1042351616).getValue() == 0) {
            AddressInputTownStreetScreenListenerKR.access$200(this.this$0, this.val$model, this.val$terminal, commandList);
            SpellerStack.getInstance().pop();
        }
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

