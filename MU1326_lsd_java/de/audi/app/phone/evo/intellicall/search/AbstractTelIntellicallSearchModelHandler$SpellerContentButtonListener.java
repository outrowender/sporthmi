/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall.search;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.evo.intellicall.search.AbstractTelIntellicallSearchModelHandler;

class AbstractTelIntellicallSearchModelHandler$SpellerContentButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ AbstractTelIntellicallSearchModelHandler this$0;

    public AbstractTelIntellicallSearchModelHandler$SpellerContentButtonListener(AbstractTelIntellicallSearchModelHandler abstractTelIntellicallSearchModelHandler, ITelApplication iTelApplication, int n) {
        this.this$0 = abstractTelIntellicallSearchModelHandler;
        super(iTelApplication, "App.Phone.Search", n);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.this$0.spellerContentButtonSelected(n3);
    }
}

