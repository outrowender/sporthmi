/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler$1;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler$TogglePhonesOptionHandler$1;
import de.audi.atip.log.LogChannel;

class TelIntellicallHandler$TogglePhonesOptionHandler
extends TelDefaultButtonListener {
    private final /* synthetic */ TelIntellicallHandler this$0;

    private TelIntellicallHandler$TogglePhonesOptionHandler(TelIntellicallHandler telIntellicallHandler, ITelApplication iTelApplication) {
        this.this$0 = telIntellicallHandler;
        super(iTelApplication, -979958784);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelIntellicallHandler.TogglePhonesOptionHandler#keyTyped] Toggle phones key typed: reset Cursor, reset Truffle Search view");
        String string = TelIntellicallHandler.access$900(TelIntellicallHandler.access$800(this.this$0).getPrimaryDeviceState(), this.getApplication().getTextFactory());
        String string2 = TelIntellicallHandler.access$900(TelIntellicallHandler.access$800(this.this$0).getAssociatedDeviceState(), this.getApplication().getTextFactory());
        this.getApplication().getTelephoneDSIAccess().togglePhones(n3, true, new TelIntellicallHandler$TogglePhonesOptionHandler$1(this, string2, string));
        this.this$0.clearTrueffelSearch();
        this.getMenuModel(-929692672).setFocusedItem(200, null, -1L);
    }

    /* synthetic */ TelIntellicallHandler$TogglePhonesOptionHandler(TelIntellicallHandler telIntellicallHandler, ITelApplication iTelApplication, TelIntellicallHandler$1 telIntellicallHandler$1) {
        this(telIntellicallHandler, iTelApplication);
    }

    static /* synthetic */ LogChannel access$1000(TelIntellicallHandler$TogglePhonesOptionHandler telIntellicallHandler$TogglePhonesOptionHandler) {
        return telIntellicallHandler$TogglePhonesOptionHandler.log;
    }

    static /* synthetic */ ITelApplication access$1100(TelIntellicallHandler$TogglePhonesOptionHandler telIntellicallHandler$TogglePhonesOptionHandler) {
        return telIntellicallHandler$TogglePhonesOptionHandler.getApplication();
    }

    static /* synthetic */ ITelApplication access$1200(TelIntellicallHandler$TogglePhonesOptionHandler telIntellicallHandler$TogglePhonesOptionHandler) {
        return telIntellicallHandler$TogglePhonesOptionHandler.getApplication();
    }

    static /* synthetic */ ITelApplication access$1300(TelIntellicallHandler$TogglePhonesOptionHandler telIntellicallHandler$TogglePhonesOptionHandler) {
        return telIntellicallHandler$TogglePhonesOptionHandler.getApplication();
    }
}

