/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$14$1;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

class PhonenumberInputSequence$14
extends NavCommand {
    private final /* synthetic */ int val$index;
    private final /* synthetic */ PhonenumberInputSequence this$0;

    PhonenumberInputSequence$14(PhonenumberInputSequence phonenumberInputSequence, String string, int n) {
        this.this$0 = phonenumberInputSequence;
        this.val$index = n;
        super(string);
    }

    @Override
    public void execute() {
        CommandList commandList = PhonenumberInputSequence.access$500(this.this$0).createCommandList();
        LIValueList lIValueList = this.env.getContainer().getLispValueList();
        LIValueListElement lIValueListElement = null;
        try {
            lIValueListElement = lIValueList.getList()[this.val$index];
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            this.getCommandList().commandAborted("Invalid index provided for selecting the location!");
        }
        if (lIValueListElement != null && lIValueListElement.validDestination && lIValueListElement.latitude != 0 && lIValueListElement.longitude != 0) {
            commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
            SpellerContext spellerContext = SpellerContextManager.getSpellerContext(120);
            commandList.add(new LIGetStateCommand(PhonenumberInputSequence.access$100(this.this$0), spellerContext));
            commandList.add(new PhonenumberInputSequence$14$1(this, "Get selected destination, check it and if valid set as currentLd"));
        }
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

