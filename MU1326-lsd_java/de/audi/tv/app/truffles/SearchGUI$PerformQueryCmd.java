/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.truffles;

import de.audi.tv.app.truffles.SearchGUI;
import de.audi.tv.app.truffles.TrufflesCommandHandler$ITrufflesCommand;

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
        SearchGUI.access$300(this.this$0).increment();
        SearchGUI.access$400(this.this$0).setIgnoreSearchIsActive(true);
        SearchGUI.access$501(this.this$0, this.text);
    }

    @Override
    public int getPriority() {
        return 1;
    }
}

