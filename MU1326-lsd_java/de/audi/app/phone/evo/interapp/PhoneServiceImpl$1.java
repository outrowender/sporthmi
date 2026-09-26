/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.interapp;

import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.interapp.PhoneServiceImpl;
import de.audi.atip.interapp.phone.ITelCallControl;
import de.audi.atip.interapp.phone.ITelCallInformation;
import de.audi.atip.interapp.phone.ITelCallSession;

class PhoneServiceImpl$1
implements ITelCallSession {
    private final /* synthetic */ ITelCallSession val$callSession;
    private final /* synthetic */ PhoneServiceImpl this$0;

    PhoneServiceImpl$1(PhoneServiceImpl phoneServiceImpl, ITelCallSession iTelCallSession) {
        this.this$0 = phoneServiceImpl;
        this.val$callSession = iTelCallSession;
    }

    @Override
    public void updateCallInformation(ITelCallInformation iTelCallInformation, int n) {
        this.val$callSession.updateCallInformation(iTelCallInformation, n);
    }

    @Override
    public void onClose() {
        ((ITelEvoApplication)PhoneServiceImpl.access$000(this.this$0)).getNewEntertainmentDrawerController().resetdialingNumberJumpToPhoneFlag();
        this.val$callSession.onClose();
    }

    @Override
    public void onActive(ITelCallControl iTelCallControl) {
        this.val$callSession.onActive(iTelCallControl);
    }

    @Override
    public String getTelephoneNumber() {
        return this.val$callSession.getTelephoneNumber();
    }

    @Override
    public int getCallType() {
        return this.val$callSession.getCallType();
    }
}

