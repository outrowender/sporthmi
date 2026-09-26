/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.listeners;

import de.audi.app.navi.evo.di.AddressInputUtilEvo;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputCityScreenListenerJP;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputCityScreenListenerJP$1$1;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputCityScreenListenerJP$1$2;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToRemoteHmiFromCurrentLDSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputCityScreenListenerJP$1
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ int val$activeSpellerContextId;
    private final /* synthetic */ AddressInputCityScreenListenerJP this$0;

    AddressInputCityScreenListenerJP$1(AddressInputCityScreenListenerJP addressInputCityScreenListenerJP, int n, int n2, int n3) {
        this.this$0 = addressInputCityScreenListenerJP;
        this.val$model = n;
        this.val$terminal = n2;
        this.val$activeSpellerContextId = n3;
    }

    @Override
    public void execute() {
        CommandList commandList = AddressInputCityScreenListenerJP.access$000(this.this$0).createCommandList();
        if (this.env.getChoiceModel(-1641806336).getValue() == 1) {
            commandList.add(new AddressInputCityScreenListenerJP$1$1(this, "Delay fire model event"));
            commandList.add(AddressInputCityScreenListenerJP.access$400(this.this$0).handleAddressInputEvent(AddressInputCityScreenListenerJP.access$300(this.this$0).createCommandList(), 20703));
        } else if (this.env.getChoiceModel(-1641806336).getValue() == 0) {
            if (AddressInputUtilEvo.isRemoteHMIPOIContext(this.env) && this.val$activeSpellerContextId == 92) {
                commandList.add(new ReturnNavLocationToRemoteHmiFromCurrentLDSequence(AddressInputCityScreenListenerJP.access$500(this.this$0)).getStartCommandList());
            }
            commandList.add(new AddressInputCityScreenListenerJP$1$2(this, "Delay fire model event"));
        }
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }

    static /* synthetic */ int access$100(AddressInputCityScreenListenerJP$1 addressInputCityScreenListenerJP$1) {
        return addressInputCityScreenListenerJP$1.val$model;
    }

    static /* synthetic */ int access$200(AddressInputCityScreenListenerJP$1 addressInputCityScreenListenerJP$1) {
        return addressInputCityScreenListenerJP$1.val$terminal;
    }
}

