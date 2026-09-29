/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.dtmf;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.dtmf.TelEvoDTMFHandler;

class TelEvoDTMFHandler$SendDtmfButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ TelEvoDTMFHandler this$0;

    public TelEvoDTMFHandler$SendDtmfButtonListener(TelEvoDTMFHandler telEvoDTMFHandler, ITelApplication iTelApplication) {
        this.this$0 = telEvoDTMFHandler;
        super(iTelApplication, -1131019264);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        super.keyTyped(n, n2, n3);
        try {
            ITelEvoApplication iTelEvoApplication = (ITelEvoApplication)this.getApplication();
            iTelEvoApplication.getIntellicallHandler().dtmfEntrySelected();
        }
        catch (ClassCastException classCastException) {
            this.log.log(10000, "[TelEvoDTMFHandler#keyTyped]", (Throwable)classCastException);
        }
        this.getChoiceModel(-1147796480).setValue(1);
    }
}

