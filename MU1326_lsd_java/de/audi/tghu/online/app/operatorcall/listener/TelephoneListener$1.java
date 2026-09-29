/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.listener;

import de.audi.atip.interapp.phone.ITelCallInformation;
import de.audi.tghu.online.app.operatorcall.listener.TelephoneListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CallInformationExt;

class TelephoneListener$1
implements ITelCallInformation {
    private final /* synthetic */ TelephoneListener this$0;

    TelephoneListener$1(TelephoneListener telephoneListener) {
        this.this$0 = telephoneListener;
    }

    @Override
    public boolean isOutgoingCall() {
        return false;
    }

    @Override
    public boolean isConferenceMember() {
        return false;
    }

    @Override
    public ResourceLocator getTelRemPictureId() {
        return null;
    }

    @Override
    public int getTelRemNumberType() {
        return 0;
    }

    @Override
    public String getTelRemNumber() {
        return null;
    }

    @Override
    public String getTelRemName() {
        return null;
    }

    @Override
    public long getTelRemEntryId() {
        return 0L;
    }

    @Override
    public short getTelNumType() {
        return 0;
    }

    @Override
    public int getTelMpty() {
        return 0;
    }

    @Override
    public int getTelCallType() {
        return 0;
    }

    @Override
    public int getTelCallState() {
        return 1;
    }

    @Override
    public int getTelCallStartingTime() {
        return 0;
    }

    @Override
    public short getTelCallID() {
        return 0;
    }

    @Override
    public int getTelCallCarrier() {
        return 0;
    }

    @Override
    public int getPreviousCallState() {
        return 0;
    }

    @Override
    public CallInformationExt getExtendedCallInformation() {
        return null;
    }

    @Override
    public int getDisconnectReason() {
        return 0;
    }

    @Override
    public int getCallDuration() {
        return 0;
    }

    @Override
    public boolean callWasActive() {
        return false;
    }
}

