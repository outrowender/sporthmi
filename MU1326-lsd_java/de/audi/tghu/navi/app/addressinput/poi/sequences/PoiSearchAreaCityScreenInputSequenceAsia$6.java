/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequenceAsia;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import org.dsi.ifc.navigation.LIValueList;

class PoiSearchAreaCityScreenInputSequenceAsia$6
implements IAdditionalStateInfo {
    private final /* synthetic */ PoiSearchAreaCityScreenInputSequenceAsia this$0;

    PoiSearchAreaCityScreenInputSequenceAsia$6(PoiSearchAreaCityScreenInputSequenceAsia poiSearchAreaCityScreenInputSequenceAsia) {
        this.this$0 = poiSearchAreaCityScreenInputSequenceAsia;
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
        PoiSearchAreaCityScreenInputSequenceAsia.access$200(this.this$0).onUpdateResultList(lIValueList, l, string2, bl, -1, 0);
        PoiSearchAreaCityScreenInputSequenceAsia.access$200(this.this$0).onUpdateSpeller(string, string2, bl, bl2);
    }
}

