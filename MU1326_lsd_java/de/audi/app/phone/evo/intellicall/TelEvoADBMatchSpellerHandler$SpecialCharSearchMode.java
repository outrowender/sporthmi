/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.evo.intellicall.ISpellerMode;
import de.audi.app.phone.evo.intellicall.TelEvoADBMatchSpellerHandler;
import de.audi.atip.interapp.phone.TelIntellicallIGIUtil;

public class TelEvoADBMatchSpellerHandler$SpecialCharSearchMode
implements ISpellerMode {
    private final /* synthetic */ TelEvoADBMatchSpellerHandler this$0;

    public TelEvoADBMatchSpellerHandler$SpecialCharSearchMode(TelEvoADBMatchSpellerHandler telEvoADBMatchSpellerHandler) {
        this.this$0 = telEvoADBMatchSpellerHandler;
    }

    @Override
    public void spellerModeChanged() {
        this.this$0.enableCusorPositioningOnListUpdates(false);
        TelEvoADBMatchSpellerHandler.access$800(this.this$0).log(-2137614336, "TelEvoADBMatchSpellerHandler.SpecialCharSearchMode#spellerModeChanged(): called");
        this.this$0.getMatchList().removeAll();
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        TelEvoADBMatchSpellerHandler.access$900(this.this$0).log(-2137614336, "TelEvoADBMatchSpellerHandler.SpecialCharSearchMode#textChanged(): text %1, latestChar %2", (Object)string, (long)c2);
        TelEvoADBMatchSpellerHandler.access$200(this.this$0).spellerTextChanged(string);
        this.this$0.getSpellerModel().setText(string);
        this.this$0.getSpellerModel().setValidChars(TelIntellicallIGIUtil.VALID_PHONE_NUMBER_SYMBOLS);
        this.this$0.getSpellerModel().setStatus(1);
    }

    @Override
    public String getValidChars(String string) {
        return TelIntellicallIGIUtil.VALID_PHONE_NUMBER_SYMBOLS;
    }
}

