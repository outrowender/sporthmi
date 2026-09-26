/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import org.dsi.ifc.navigation.LIValueList;

class AbstractAddressInputMatchSpellerSequence$2
implements IAdditionalStateInfo {
    private final /* synthetic */ AbstractAddressInputMatchSpellerSequence this$0;

    AbstractAddressInputMatchSpellerSequence$2(AbstractAddressInputMatchSpellerSequence abstractAddressInputMatchSpellerSequence) {
        this.this$0 = abstractAddressInputMatchSpellerSequence;
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
        this.this$0.modelAccess.onStart(dSIResponseContainer.getLiCurrentLD());
        int n = 0;
        if (lIValueList.getList() != null && lIValueList.getList().length > 0) {
            n = lIValueList.getList()[0].listIndex;
        }
        this.this$0.modelAccess.onUpdateResultList(lIValueList, l, string2, bl, -1, n);
        this.this$0.modelAccess.onUpdateSpeller(string, string2, bl, bl2);
    }
}

