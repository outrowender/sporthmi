/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormNAR;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

class AddressInputSDSFormNAR$1
extends NavCommand {
    private final /* synthetic */ AddressInputSDSFormNAR this$0;

    AddressInputSDSFormNAR$1(AddressInputSDSFormNAR addressInputSDSFormNAR) {
        this.this$0 = addressInputSDSFormNAR;
    }

    @Override
    public void execute() {
        NavLocation navLocation = (NavLocation)this.getCommandList().get("STRIPPED_LOCATION");
        AddressInputSDSFormNAR.access$000(this.this$0).log(-2137614336, "AddressInputSDSFormNAR#startDestinationInput() - strippedLocation = %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.getCommandList().commandFinishedWithPostSequence(AddressInputSDSFormNAR.access$100(this.this$0).getStartAddressInputCommandList(navLocation, 30016));
    }
}

