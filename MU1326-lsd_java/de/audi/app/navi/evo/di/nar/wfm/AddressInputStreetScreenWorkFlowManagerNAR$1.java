/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.wfm;

import de.audi.app.navi.evo.di.nar.wfm.AddressInputStreetScreenWorkFlowManagerNAR;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputStreetScreenWorkFlowManagerNAR$1
extends NavCommand {
    private final /* synthetic */ String val$street;
    private final /* synthetic */ AddressInputStreetScreenWorkFlowManagerNAR this$0;

    AddressInputStreetScreenWorkFlowManagerNAR$1(AddressInputStreetScreenWorkFlowManagerNAR addressInputStreetScreenWorkFlowManagerNAR, String string, String string2) {
        this.this$0 = addressInputStreetScreenWorkFlowManagerNAR;
        this.val$street = string2;
        super(string);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#getSelectListElementCommandList#Set Street for CityHistory --> Element for history", (Object)this.val$street);
        this.getDSINavigation().liSetStreetForCityHistory(this.val$street);
        this.getCommandList().commandFinished();
    }
}

