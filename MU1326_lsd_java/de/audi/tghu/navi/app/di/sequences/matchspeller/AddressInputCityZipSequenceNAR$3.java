/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequenceNAR;

class AddressInputCityZipSequenceNAR$3
extends NavCommand {
    private final /* synthetic */ AddressInputCityZipSequenceNAR this$0;

    AddressInputCityZipSequenceNAR$3(AddressInputCityZipSequenceNAR addressInputCityZipSequenceNAR, String string) {
        this.this$0 = addressInputCityZipSequenceNAR;
        super(string);
    }

    @Override
    public void execute() {
        this.getDSINavigation().liSetStreetForCityHistory(this.dsiResponseContainer.getLiCurrentLD().street);
    }

    @Override
    public void liHistoryResult(int n) {
        if (n == 0) {
            this.logger.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#updateLiCityHistory#liHistoryResult() - result OK").toString());
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#updateLiCityHistory#liHistoryResult() - commandAborted").toString());
            this.getCommandList().commandAborted(n);
        }
    }
}

