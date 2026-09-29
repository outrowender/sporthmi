/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.screen.AbstractTelDefaultScreenStateListener;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler$1;

class TelIntellicallHandler$IntellicallFullScreenListener
extends AbstractTelDefaultScreenStateListener {
    private final /* synthetic */ TelIntellicallHandler this$0;

    private TelIntellicallHandler$IntellicallFullScreenListener(TelIntellicallHandler telIntellicallHandler, ITelApplication iTelApplication) {
        this.this$0 = telIntellicallHandler;
        super(iTelApplication, "App.Phone.Main", 227804160);
    }

    @Override
    public void notifyScreenFadedOut(int n) {
        this.log.log(1078071040, "[TelIntellicallHandler.IntellicallReducedScreenListener#notifyScreenFadedOut] INTELLICALL_MAIN faded out.");
        TelIntellicallHandler.access$700(this.this$0);
    }

    /* synthetic */ TelIntellicallHandler$IntellicallFullScreenListener(TelIntellicallHandler telIntellicallHandler, ITelApplication iTelApplication, TelIntellicallHandler$1 telIntellicallHandler$1) {
        this(telIntellicallHandler, iTelApplication);
    }
}

