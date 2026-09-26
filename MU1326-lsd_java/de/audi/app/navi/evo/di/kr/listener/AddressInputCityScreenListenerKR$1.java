/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.listener;

import de.audi.app.navi.evo.di.kr.listener.AddressInputCityScreenListenerKR;
import de.audi.app.navi.evo.di.kr.listener.AddressInputCityScreenListenerKR$1$1;
import de.audi.app.navi.evo.di.kr.listener.AddressInputCityScreenListenerKR$1$2;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputCityScreenListenerKR$1
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ AddressInputCityScreenListenerKR this$0;

    AddressInputCityScreenListenerKR$1(AddressInputCityScreenListenerKR addressInputCityScreenListenerKR, int n, int n2) {
        this.this$0 = addressInputCityScreenListenerKR;
        this.val$model = n;
        this.val$terminal = n2;
    }

    @Override
    public void execute() {
        CommandList commandList = AddressInputCityScreenListenerKR.access$000(this.this$0).createCommandList();
        if (this.env.getChoiceModel(-1641806336).getValue() == 1) {
            commandList.add(new AddressInputCityScreenListenerKR$1$1(this, "Delay fire model event"));
            commandList.add(AddressInputCityScreenListenerKR.access$400(this.this$0).handleAddressInputEvent(AddressInputCityScreenListenerKR.access$300(this.this$0).createCommandList(), 1872560128));
        } else if (this.env.getChoiceModel(-1641806336).getValue() == 0) {
            commandList.add(new AddressInputCityScreenListenerKR$1$2(this, "Delay fire model event"));
        }
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }

    static /* synthetic */ int access$100(AddressInputCityScreenListenerKR$1 addressInputCityScreenListenerKR$1) {
        return addressInputCityScreenListenerKR$1.val$model;
    }

    static /* synthetic */ int access$200(AddressInputCityScreenListenerKR$1 addressInputCityScreenListenerKR$1) {
        return addressInputCityScreenListenerKR$1.val$terminal;
    }
}

