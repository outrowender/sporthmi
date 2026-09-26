/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.sds.AbstractAddressInputSDSFormJpKr;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AbstractAddressInputSDSFormJpKr$3
extends NavCommand {
    private final /* synthetic */ AbstractAddressInputSDSFormJpKr this$0;

    AbstractAddressInputSDSFormJpKr$3(AbstractAddressInputSDSFormJpKr abstractAddressInputSDSFormJpKr, String string) {
        this.this$0 = abstractAddressInputSDSFormJpKr;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        this.this$0.detailModelAccess.onUpdateLocation(navLocation);
        this.this$0.detailsScreen.enterDetailsScreen(navLocation);
        this.getCommandList().commandFinished();
    }
}

