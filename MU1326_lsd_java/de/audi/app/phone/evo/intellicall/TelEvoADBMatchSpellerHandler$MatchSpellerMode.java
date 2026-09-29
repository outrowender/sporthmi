/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.evo.intellicall.ISpellerMode;
import de.audi.app.phone.evo.intellicall.TelEvoADBMatchSpellerHandler;
import de.audi.app.phone.evo.intellicall.TelEvoADBMatchSpellerHandler$1;

class TelEvoADBMatchSpellerHandler$MatchSpellerMode
implements ISpellerMode {
    private final /* synthetic */ TelEvoADBMatchSpellerHandler this$0;

    private TelEvoADBMatchSpellerHandler$MatchSpellerMode(TelEvoADBMatchSpellerHandler telEvoADBMatchSpellerHandler) {
        this.this$0 = telEvoADBMatchSpellerHandler;
    }

    @Override
    public void spellerModeChanged() {
        TelEvoADBMatchSpellerHandler.access$100(this.this$0).log(-2137614336, "TelEvoADBMatchSpellerHandler.MatchSpellerMode#spellerModeChanged(): called");
        TelEvoADBMatchSpellerHandler.access$200(this.this$0).showSearchResultList();
        TelEvoADBMatchSpellerHandler.access$300(this.this$0);
        this.this$0.enableCusorPositioningOnListUpdates(true);
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        TelEvoADBMatchSpellerHandler.access$400(this.this$0).log(-2137614336, "TelEvoADBMatchSpellerHandler.MatchSpellerMode#textChanged(): text %1, latestChar %2", (Object)string, (long)c2);
        TelEvoADBMatchSpellerHandler.access$501(this.this$0, n, string, c2, n2);
    }

    @Override
    public String getValidChars(String string) {
        return string;
    }

    /* synthetic */ TelEvoADBMatchSpellerHandler$MatchSpellerMode(TelEvoADBMatchSpellerHandler telEvoADBMatchSpellerHandler, TelEvoADBMatchSpellerHandler$1 telEvoADBMatchSpellerHandler$1) {
        this(telEvoADBMatchSpellerHandler);
    }
}

