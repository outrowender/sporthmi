/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler$1;

class TelIntellicallHandler$TelFurtherCallOptionButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ TelIntellicallHandler this$0;

    private TelIntellicallHandler$TelFurtherCallOptionButtonListener(TelIntellicallHandler telIntellicallHandler, ITelApplication iTelApplication) {
        this.this$0 = telIntellicallHandler;
        super(iTelApplication, 1083638784);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelIntellicallHandler.TelFurtherCallOptionButtonListener#keyTyped] %1", (Object)TelLoggingUtils.keyTyped(n, n2, n3));
        this.this$0.clearTrueffelSearch();
        this.getMenuModel(-929692672).setFocusedItem(200, null, -1L);
        this.getButtonModel(n).fireEvent(n3);
    }

    /* synthetic */ TelIntellicallHandler$TelFurtherCallOptionButtonListener(TelIntellicallHandler telIntellicallHandler, ITelApplication iTelApplication, TelIntellicallHandler$1 telIntellicallHandler$1) {
        this(telIntellicallHandler, iTelApplication);
    }
}

