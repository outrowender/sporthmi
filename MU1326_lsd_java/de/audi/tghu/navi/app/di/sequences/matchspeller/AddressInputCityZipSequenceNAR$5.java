/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequenceNAR;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequenceNAR$5$1;

class AddressInputCityZipSequenceNAR$5
extends NavCommand {
    private final /* synthetic */ AddressInputCityZipSequenceNAR this$0;

    AddressInputCityZipSequenceNAR$5(AddressInputCityZipSequenceNAR addressInputCityZipSequenceNAR, String string) {
        this.this$0 = addressInputCityZipSequenceNAR;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.getLiCurrentLD().isPositionValid()) {
            CommandList commandList = this.this$0.commandListFactory.createCommandList();
            commandList.add(new AddressInputCityZipSequenceNAR$5$1(this, new StringBuffer().append(this.CLASS_NAME).append("#getSelectListElementCommandList add stiped location to history").toString()));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else {
            this.getCommandList().commandFinished();
        }
    }

    static /* synthetic */ AddressInputCityZipSequenceNAR access$000(AddressInputCityZipSequenceNAR$5 addressInputCityZipSequenceNAR$5) {
        return addressInputCityZipSequenceNAR$5.this$0;
    }
}

