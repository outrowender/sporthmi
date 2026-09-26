/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.disambiguation;

import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AddressDisambiguatorHMIListener$2
extends NavCommand {
    private final /* synthetic */ NavLocation val$navLocation;
    private final /* synthetic */ AddressDisambiguatorHMIListener this$0;

    AddressDisambiguatorHMIListener$2(AddressDisambiguatorHMIListener addressDisambiguatorHMIListener, String string, NavLocation navLocation) {
        this.this$0 = addressDisambiguatorHMIListener;
        this.val$navLocation = navLocation;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostSequence(this.navigation.getStartGuidanceDependantSequence().getStartSequence(this.val$navLocation));
        this.env.getChoiceModel(1042286080).setValue(0);
        this.getCommandList().commandFinished();
    }
}

