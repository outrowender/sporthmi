/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.disambiguation;

import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener;
import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener$DisambMatchSpellerListener;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import org.dsi.ifc.global.NavLocation;

class AddressDisambiguatorHMIListener$DisambMatchSpellerListener$1
implements NavLocationCallback {
    private final /* synthetic */ AddressDisambiguatorHMIListener$DisambMatchSpellerListener this$1;

    AddressDisambiguatorHMIListener$DisambMatchSpellerListener$1(AddressDisambiguatorHMIListener$DisambMatchSpellerListener addressDisambiguatorHMIListener$DisambMatchSpellerListener) {
        this.this$1 = addressDisambiguatorHMIListener$DisambMatchSpellerListener;
    }

    @Override
    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
        AddressDisambiguatorHMIListener.access$400(AddressDisambiguatorHMIListener$DisambMatchSpellerListener.access$300(this.this$1), navLocation, iCommandList);
    }
}

