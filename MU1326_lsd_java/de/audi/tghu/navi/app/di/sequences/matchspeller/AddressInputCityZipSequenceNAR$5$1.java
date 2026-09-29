/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.AddStreetAndCityToHistoryCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequenceNAR$5;

class AddressInputCityZipSequenceNAR$5$1
extends NavCommand {
    private final /* synthetic */ AddressInputCityZipSequenceNAR$5 this$1;

    AddressInputCityZipSequenceNAR$5$1(AddressInputCityZipSequenceNAR$5 addressInputCityZipSequenceNAR$5, String string) {
        this.this$1 = addressInputCityZipSequenceNAR$5;
        super(string);
    }

    @Override
    public void execute() {
        boolean bl = AddressInputCityZipSequenceNAR$5.access$000((AddressInputCityZipSequenceNAR$5)this.this$1).spellerStack.containsContextID(65);
        if (bl) {
            this.getCommandList().commandFinishedWithPostCommand(new AddStreetAndCityToHistoryCommand(this.dsiResponseContainer.getLiCurrentLD(), AddressInputCityZipSequenceNAR$5.access$000((AddressInputCityZipSequenceNAR$5)this.this$1).cityHistory, AddressInputCityZipSequenceNAR$5.access$000((AddressInputCityZipSequenceNAR$5)this.this$1).commandListFactory, bl));
        } else {
            this.getCommandList().commandFinishedWithPostSequence(AddressInputCityZipSequenceNAR$5.access$000((AddressInputCityZipSequenceNAR$5)this.this$1).cityHistory.addLastCityCommandList(this.dsiResponseContainer.getLiCurrentLD(), bl));
        }
    }
}

