/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.evo.intellicall.ISpellerMode;
import de.audi.app.phone.evo.intellicall.TelEvoADBMatchSpellerHandler;

public class TelEvoADBMatchSpellerHandler$NoneSpellerMode
implements ISpellerMode {
    private final /* synthetic */ TelEvoADBMatchSpellerHandler this$0;

    public TelEvoADBMatchSpellerHandler$NoneSpellerMode(TelEvoADBMatchSpellerHandler telEvoADBMatchSpellerHandler) {
        this.this$0 = telEvoADBMatchSpellerHandler;
    }

    @Override
    public void spellerModeChanged() {
        this.this$0.enableCusorPositioningOnListUpdates(false);
        TelEvoADBMatchSpellerHandler.access$600(this.this$0).log(-2137614336, "TelEvoADBMatchSpellerHandler.NoneSpellerMode#spellerModeChanged(): called");
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        TelEvoADBMatchSpellerHandler.access$700(this.this$0).log(-2137614336, "TelEvoADBMatchSpellerHandler.NoneSpellerMode#textChanged(): text %1, latestChar %2", (Object)string, (long)c2);
        TelEvoADBMatchSpellerHandler.access$200(this.this$0).clearSearchSpeller();
    }

    @Override
    public String getValidChars(String string) {
        return null;
    }
}

