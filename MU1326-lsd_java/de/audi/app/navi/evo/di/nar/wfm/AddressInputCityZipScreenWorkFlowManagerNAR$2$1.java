/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.wfm;

import de.audi.app.navi.evo.di.nar.wfm.AddressInputCityZipScreenWorkFlowManagerNAR$2;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputCityZipScreenWorkFlowManagerNAR$2$1
extends NavCommand {
    private final /* synthetic */ AddressInputCityZipScreenWorkFlowManagerNAR$2 this$1;

    AddressInputCityZipScreenWorkFlowManagerNAR$2$1(AddressInputCityZipScreenWorkFlowManagerNAR$2 addressInputCityZipScreenWorkFlowManagerNAR$2, String string) {
        this.this$1 = addressInputCityZipScreenWorkFlowManagerNAR$2;
        super(string);
    }

    @Override
    public void execute() {
        if (!this.dsiResponseContainer.getLiCurrentLD().positionValid) {
            this.getCommandList().commandFinishedWithPostSequence(AddressInputCityZipScreenWorkFlowManagerNAR$2.access$100((AddressInputCityZipScreenWorkFlowManagerNAR$2)this.this$1).inputManager.getStreetRefinementScreenListener().getStartCommandList());
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

