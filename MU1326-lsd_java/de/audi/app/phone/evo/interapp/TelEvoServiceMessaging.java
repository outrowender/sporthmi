/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.interapp;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.interapp.TelServiceMessaging;

public class TelEvoServiceMessaging
extends TelServiceMessaging {
    private static final int CONTEXT_SMS;
    private static final int CONTEXT_EMAIL;

    public TelEvoServiceMessaging(ITelApplication iTelApplication) {
        super(iTelApplication);
    }

    @Override
    public void notifyActiveContextMessaging(int n) {
        int n2 = n == 0 ? 4 : 6;
        this.getChoiceModel(-1399454720).setValue(n2);
    }
}

