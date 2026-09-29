/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.disambiguation;

import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener;
import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener$DisambMatchSpellerListener$1;
import de.audi.app.navi.evo.addressinput.housenumber.HousenumberInputMatchSpellerListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.housenumber.HousenumberMatchspellerInputSequence;
import de.audi.tghu.navi.app.rows.LiValueListRow;

public class AddressDisambiguatorHMIListener$DisambMatchSpellerListener
extends HousenumberInputMatchSpellerListener {
    private final /* synthetic */ AddressDisambiguatorHMIListener this$0;

    protected AddressDisambiguatorHMIListener$DisambMatchSpellerListener(AddressDisambiguatorHMIListener addressDisambiguatorHMIListener, HousenumberMatchspellerInputSequence housenumberMatchspellerInputSequence, NavigationEnv navigationEnv, int n, int n2, int n3, IPreviewMap iPreviewMap) {
        this.this$0 = addressDisambiguatorHMIListener;
        super(housenumberMatchspellerInputSequence, navigationEnv, n, n2, n3, iPreviewMap);
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        AddressDisambiguatorHMIListener.access$100(this.this$0);
        super.textChanged(n, string, c2, n2);
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        AddressDisambiguatorHMIListener.access$100(this.this$0);
        super.itemFocused(evoListRow, n, n2, n3, n4);
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        AddressDisambiguatorHMIListener.access$200((AddressDisambiguatorHMIListener)this.this$0).logger.log(1078071040, "AddressDisambiguatorHMIListener#DisambListListener#itemSelected modelID=%1, index=%2, col=%3", (long)n, (long)n2, (long)n3);
        AddressDisambiguatorHMIListener.access$100(this.this$0);
        if (!(evoListRow instanceof LiValueListRow)) {
            throw new IllegalArgumentException("AddressDisambiguatorHMIListener not a LiValueListRow object");
        }
        TiledListModelApp tiledListModelApp = AddressDisambiguatorHMIListener.access$200((AddressDisambiguatorHMIListener)this.this$0).tiledList;
        int n5 = AddressDisambiguatorHMIListener.access$200((AddressDisambiguatorHMIListener)this.this$0).terminal;
        AddressDisambiguatorHMIListener.access$200((AddressDisambiguatorHMIListener)this.this$0).extractor.executeCallbackWithNavLocation(evoListRow, 0, new AddressDisambiguatorHMIListener$DisambMatchSpellerListener$1(this));
        tiledListModelApp.fireEvent(n5);
    }

    static /* synthetic */ AddressDisambiguatorHMIListener access$300(AddressDisambiguatorHMIListener$DisambMatchSpellerListener addressDisambiguatorHMIListener$DisambMatchSpellerListener) {
        return addressDisambiguatorHMIListener$DisambMatchSpellerListener.this$0;
    }
}

