/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.sds.AbstractAddressInputSDSFormEvo;
import de.audi.tghu.navi.app.command.NavCommand;

class AbstractAddressInputSDSFormEvo$2
extends NavCommand {
    private final /* synthetic */ AbstractAddressInputSDSFormEvo this$0;

    AbstractAddressInputSDSFormEvo$2(AbstractAddressInputSDSFormEvo abstractAddressInputSDSFormEvo, String string) {
        this.this$0 = abstractAddressInputSDSFormEvo;
        super(string);
    }

    @Override
    public void execute() {
        AbstractAddressInputSDSFormEvo.access$200(this.this$0).resetSDSDestinationType();
        this.getCommandList().commandFinished();
    }
}

