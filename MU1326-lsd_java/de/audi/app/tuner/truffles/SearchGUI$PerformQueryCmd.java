/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.SearchGUI;
import de.audi.app.tuner.truffles.TrufflesCommandHandler$ITrufflesCommand;

class SearchGUI$PerformQueryCmd
implements TrufflesCommandHandler$ITrufflesCommand {
    private final String text;
    private final /* synthetic */ SearchGUI this$0;

    public SearchGUI$PerformQueryCmd(SearchGUI searchGUI, String string) {
        this.this$0 = searchGUI;
        this.text = string;
    }

    @Override
    public void execute() {
        SearchGUI.access$908(this.this$0);
        SearchGUI.access$1000(this.this$0).setIgnoreSearchIsActive(true);
        SearchGUI.access$1101(this.this$0, this.text);
    }

    @Override
    public int getPriority() {
        return 1;
    }
}

