/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequence;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import org.dsi.ifc.navigation.LIValueList;

class AddressInputCityZipSequence$1
implements IAdditionalStateInfo {
    private final /* synthetic */ AddressInputCityZipSequence this$0;

    AddressInputCityZipSequence$1(AddressInputCityZipSequence addressInputCityZipSequence) {
        this.this$0 = addressInputCityZipSequence;
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
        this.this$0.modelAccess.onUpdateResultList(lIValueList, l, string2, bl, -1, 0);
        this.this$0.modelAccess.onUpdateSpeller(string, string2, bl, bl2);
    }
}

