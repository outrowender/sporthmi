/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.disambiguation;

import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener;
import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener$DisambPopUpButtonListener;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AddressDisambiguatorHMIListener$DisambPopUpButtonListener$2
extends NavCommand {
    private final /* synthetic */ NavLocation val$location;
    private final /* synthetic */ AddressDisambiguatorHMIListener$DisambPopUpButtonListener this$1;

    AddressDisambiguatorHMIListener$DisambPopUpButtonListener$2(AddressDisambiguatorHMIListener$DisambPopUpButtonListener addressDisambiguatorHMIListener$DisambPopUpButtonListener, String string, NavLocation navLocation) {
        this.this$1 = addressDisambiguatorHMIListener$DisambPopUpButtonListener;
        this.val$location = navLocation;
        super(string);
    }

    @Override
    public void execute() {
        AddressDisambiguatorHMIListener.access$400(AddressDisambiguatorHMIListener$DisambPopUpButtonListener.access$600(this.this$1), this.val$location, this.getCommandList());
        this.finishCommandIfNecessary();
    }

    private void finishCommandIfNecessary() {
        if (this.getCommandList().getActiveCommand() == this) {
            this.getCommandList().commandFinished();
        }
    }
}

