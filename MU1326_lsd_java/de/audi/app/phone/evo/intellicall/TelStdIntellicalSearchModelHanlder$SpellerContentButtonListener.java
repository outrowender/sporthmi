/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.evo.intellicall.TelStdIntellicalSearchModelHanlder;

class TelStdIntellicalSearchModelHanlder$SpellerContentButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ TelStdIntellicalSearchModelHanlder this$0;

    public TelStdIntellicalSearchModelHanlder$SpellerContentButtonListener(TelStdIntellicalSearchModelHanlder telStdIntellicalSearchModelHanlder, ITelApplication iTelApplication, int n) {
        this.this$0 = telStdIntellicalSearchModelHanlder;
        super(iTelApplication, "App.Phone.Search", n);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        TelStdIntellicalSearchModelHanlder.access$000(this.this$0, n3);
        this.this$0.clearSearchSpeller();
    }
}

