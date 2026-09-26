/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.disambiguation;

import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener;
import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener$1;
import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener$DisambPopUpButtonListener$1;
import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener$DisambPopUpButtonListener$2;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.global.NavLocation;

class AddressDisambiguatorHMIListener$DisambPopUpButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ AddressDisambiguatorHMIListener this$0;

    private AddressDisambiguatorHMIListener$DisambPopUpButtonListener(AddressDisambiguatorHMIListener addressDisambiguatorHMIListener) {
        this.this$0 = addressDisambiguatorHMIListener;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        AddressDisambiguatorHMIListener.access$500(this.this$0).log(-2137614336, "AddressDisambiguatorHMIListener#keyPressed modelID=%1", (long)n);
        if (n != -1239415296) {
            if (n == -1222638080 || n == -937425408) {
                NavLocation navLocation = AddressDisambiguatorHMIListener.access$200(this.this$0).getTryMatchLocationResultData();
                CommandList commandList = AddressDisambiguatorHMIListener.access$200((AddressDisambiguatorHMIListener)this.this$0).commandListFactory.createCommandList();
                commandList.add(new AddressDisambiguatorHMIListener$DisambPopUpButtonListener$1(this, "DisambPopUpButtonListener#keyPressed IgnoreHNRCommand", navLocation));
                commandList.execute("DisambPopUpButtonListener#keyPressed IgnoreHNRCommandList");
            } else if (n == -920648192) {
                NavLocation navLocation = AddressDisambiguatorHMIListener.access$700(this.this$0).getContainer().getSelectedLocation();
                CommandList commandList = AddressDisambiguatorHMIListener.access$200((AddressDisambiguatorHMIListener)this.this$0).commandListFactory.createCommandList();
                commandList.add(new AddressDisambiguatorHMIListener$DisambPopUpButtonListener$2(this, "DisambPopUpButtonListener#keyPressed NavigateToNearestHNRCommand", navLocation));
                commandList.execute("DisambPopUpButtonListener#keyPressed NavigateToNearestHNRCommandList");
            } else {
                AddressDisambiguatorHMIListener.access$500(this.this$0).log(-1601830656, "AddressDisambiguatorHMIListener#keyPressed modelID=%1 not found in listener", (long)n);
            }
        }
        AddressDisambiguatorHMIListener.access$700(this.this$0).getButtonModel(n).fireEvent(n3);
    }

    /* synthetic */ AddressDisambiguatorHMIListener$DisambPopUpButtonListener(AddressDisambiguatorHMIListener addressDisambiguatorHMIListener, AddressDisambiguatorHMIListener$1 addressDisambiguatorHMIListener$1) {
        this(addressDisambiguatorHMIListener);
    }

    static /* synthetic */ AddressDisambiguatorHMIListener access$600(AddressDisambiguatorHMIListener$DisambPopUpButtonListener addressDisambiguatorHMIListener$DisambPopUpButtonListener) {
        return addressDisambiguatorHMIListener$DisambPopUpButtonListener.this$0;
    }
}

