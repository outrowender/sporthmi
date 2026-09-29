/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultSpellerListener;
import de.audi.app.phone.core.search.cmd.AbstractTelSearchModelHandler;
import de.audi.app.phone.core.util.TelLoggingUtils;

class AbstractTelSearchModelHandler$SearchSpellerListener
extends TelDefaultSpellerListener {
    private final /* synthetic */ AbstractTelSearchModelHandler this$0;

    public AbstractTelSearchModelHandler$SearchSpellerListener(AbstractTelSearchModelHandler abstractTelSearchModelHandler, ITelApplication iTelApplication) {
        this.this$0 = abstractTelSearchModelHandler;
        super(iTelApplication, "App.Phone.Search", abstractTelSearchModelHandler.getSearchSpellerModel().getID());
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.log.log(1078071040, "[AbstractTelSearchModelHandler.SearchSpellerListener#textChanged] %1", (Object)TelLoggingUtils.textChanged(n, string, c2, n2));
        this.this$0.searchSpellerTextChanged(string, c2);
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
        this.log.log(1078071040, "[AbstractTelSearchModelHandler.SearchSpellerListener#focusedCharacter] %1", (Object)TelLoggingUtils.focusedCharacter(n, c2, n2));
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[AbstractTelSearchModelHandler.SearchSpellerListener#keyTyped] %1", (Object)TelLoggingUtils.keyTyped(n, n2, n3));
        this.this$0.spellerSelected(this.this$0.getSearchSpellerModel().getText(), n3);
    }
}

