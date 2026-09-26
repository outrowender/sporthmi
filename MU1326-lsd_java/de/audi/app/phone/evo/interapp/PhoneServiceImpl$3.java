/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.interapp;

import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.interapp.PhoneServiceImpl;
import de.audi.atip.phone.ITelServiceListener;

class PhoneServiceImpl$3
implements ITelServiceListener {
    private final /* synthetic */ ITelServiceListener val$listener;
    private final /* synthetic */ PhoneServiceImpl this$0;

    PhoneServiceImpl$3(PhoneServiceImpl phoneServiceImpl, ITelServiceListener iTelServiceListener) {
        this.this$0 = phoneServiceImpl;
        this.val$listener = iTelServiceListener;
    }

    @Override
    public void dialNumberResponse(int n) {
        if (n != 0) {
            ((ITelEvoApplication)PhoneServiceImpl.access$200(this.this$0)).getNewEntertainmentDrawerController().resetdialingNumberJumpToPhoneFlag();
        }
        if (this.val$listener != null) {
            this.val$listener.dialNumberResponse(n);
        }
    }
}

