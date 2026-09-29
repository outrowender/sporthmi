/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.li.aih;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.aih.AddressbookDestinationAIH;

class AddressbookDestinationAIH$1
extends NavCommand {
    private final /* synthetic */ AddressbookDestinationAIH this$0;

    AddressbookDestinationAIH$1(AddressbookDestinationAIH addressbookDestinationAIH, String string) {
        this.this$0 = addressbookDestinationAIH;
        super(string);
    }

    @Override
    public void execute() {
        byte[] byArray = (byte[])this.getCommandList().get("LOCATION_STREAM");
        AddressbookDestinationAIH.access$000(this.this$0).updateLocation(byArray);
        this.getCommandList().commandFinished();
    }
}

