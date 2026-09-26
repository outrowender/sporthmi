/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.sds.AbstractAddressInputSDSFormEvo;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AbstractAddressInputSDSFormEvo$5
extends NavCommand {
    private final /* synthetic */ AbstractAddressInputSDSFormEvo this$0;

    AbstractAddressInputSDSFormEvo$5(AbstractAddressInputSDSFormEvo abstractAddressInputSDSFormEvo) {
        this.this$0 = abstractAddressInputSDSFormEvo;
    }

    @Override
    public void execute() {
        NavLocation navLocation = (NavLocation)this.getCommandList().get("STRIPPED_LOCATION");
        AbstractAddressInputSDSFormEvo.access$300(this.this$0).log(-2137614336, "%1#setCenter() - strippedLocation = %2", (Object)this.CLASS_NAME, (Object)navLocation);
        this.getCommandList().commandFinishedWithPostSequence(AbstractAddressInputSDSFormEvo.access$400(this.this$0).getStartAddressInputCommandList(navLocation));
    }
}

