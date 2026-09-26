/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.listeners;

import de.audi.app.navi.evo.di.AddressInputUtilEvo;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputChomeScreenListenerJP;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputChomeScreenListenerJP$1$1;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToPOIOnlineSearchSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputChomeScreenListenerJP$1
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ int val$activeSpellerContextId;
    private final /* synthetic */ AddressInputChomeScreenListenerJP this$0;

    AddressInputChomeScreenListenerJP$1(AddressInputChomeScreenListenerJP addressInputChomeScreenListenerJP, String string, int n, int n2, int n3) {
        this.this$0 = addressInputChomeScreenListenerJP;
        this.val$model = n;
        this.val$terminal = n2;
        this.val$activeSpellerContextId = n3;
        super(string);
    }

    @Override
    public void execute() {
        if (AddressInputChomeScreenListenerJP.access$000(this.this$0).getValue() == 1) {
            AddressInputChomeScreenListenerJP.access$100(this.this$0, this.val$model, this.val$terminal, this.getCommandList());
            this.getCommandList().commandFinishedWithPostSequence(AddressInputChomeScreenListenerJP.access$300(this.this$0).handleAddressInputEvent(AddressInputChomeScreenListenerJP.access$200(this.this$0).createCommandList(), 20804));
        } else {
            CommandList commandList = AddressInputChomeScreenListenerJP.access$400(this.this$0).createCommandList();
            if (AddressInputUtilEvo.isOnlinePOIContext(this.env) && this.val$activeSpellerContextId == 96) {
                this.logger.log(-2137614336, "%1#itemSelected - in online POI new area set, finish new area setting.", (Object)this.CLASS_NAME);
                commandList.add(new ReturnNavLocationToPOIOnlineSearchSequence(AddressInputChomeScreenListenerJP.access$500(this.this$0)).getStartCommandList());
                AddressInputChomeScreenListenerJP.access$100(this.this$0, this.val$model, this.val$terminal, commandList);
            } else if (AddressInputUtilEvo.isNormalPOIContext(this.env)) {
                this.logger.log(-2137614336, "%1#itemSelected - in normal POI new area set, finish new area setting.", (Object)this.CLASS_NAME);
                AddressInputChomeScreenListenerJP.access$100(this.this$0, this.val$model, this.val$terminal, commandList);
                commandList.add(new AddressInputChomeScreenListenerJP$1$1(this));
            } else {
                this.logger.log(-2137614336, "%1#itemSelected - in address input context.", (Object)this.CLASS_NAME);
                AddressInputChomeScreenListenerJP.access$100(this.this$0, this.val$model, this.val$terminal, commandList);
            }
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        }
    }

    static /* synthetic */ AddressInputChomeScreenListenerJP access$600(AddressInputChomeScreenListenerJP$1 addressInputChomeScreenListenerJP$1) {
        return addressInputChomeScreenListenerJP$1.this$0;
    }
}

