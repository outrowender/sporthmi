/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequence;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import org.dsi.ifc.navigation.LIValueList;

class PoiSearchAreaCityScreenInputSequence$5
implements IAdditionalStateInfo {
    private final /* synthetic */ PoiSearchAreaCityScreenInputSequence this$0;

    PoiSearchAreaCityScreenInputSequence$5(PoiSearchAreaCityScreenInputSequence poiSearchAreaCityScreenInputSequence) {
        this.this$0 = poiSearchAreaCityScreenInputSequence;
    }

    @Override
    public void gatherInfo() {
    }

    @Override
    public void restoreBefore() {
    }

    @Override
    public void restoreAfter() {
        DSIResponseContainer dSIResponseContainer = this.this$0.env.getContainer();
        String string = dSIResponseContainer.getLispValidCharacters();
        String string2 = dSIResponseContainer.getLispCurrentInput();
        boolean bl = dSIResponseContainer.isLispIsFullMatch();
        boolean bl2 = dSIResponseContainer.isLispIsUndoAvailable();
        LIValueList lIValueList = dSIResponseContainer.getLispValueList();
        long l = dSIResponseContainer.getLispValueListCount();
        PoiSearchAreaCityScreenInputSequence.access$200(this.this$0).onUpdateResultList(lIValueList, l, string2, bl, -1, 0);
        PoiSearchAreaCityScreenInputSequence.access$200(this.this$0).onUpdateSpeller(string, string2, bl, bl2);
    }
}

