/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.suppservices;

import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.BitFieldInt;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.telephoneng.CFResponseData;

public abstract class AbstractTelCallForwardingStatusIconHandler
implements IGlobalTelephoneStateListener {
    protected LogChannel log;
    private BitFieldInt callForwardingStatusBitField = new BitFieldInt();
    private boolean nadActiveUnlockedRegistered;
    private boolean nadActiveUnlockedRegisteredOld;

    public AbstractTelCallForwardingStatusIconHandler(LogChannel logChannel) {
        this.log = logChannel;
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        CFResponseData[] cFResponseDataArray;
        boolean bl;
        this.nadActiveUnlockedRegisteredOld = this.nadActiveUnlockedRegistered;
        this.nadActiveUnlockedRegistered = PhoneUtils.isOnUnlockedRegistered(iGlobalTelephoneStateStruct.getNadInstanceState());
        boolean bl2 = this.nadActiveUnlockedRegistered && !this.nadActiveUnlockedRegisteredOld;
        boolean bl3 = bl = !this.nadActiveUnlockedRegistered && this.nadActiveUnlockedRegisteredOld;
        if (n == 0x1A000100 || n == 436208128) {
            this.log.log(-2137614336, "TelCallForwardingStatusIconHandler#updateGlobalTelephoneStateProperty() received call forwarding status");
            cFResponseDataArray = iGlobalTelephoneStateStruct.getNadInstanceState() != null ? (iGlobalTelephoneStateStruct.getNadInstanceState().getSuppServiceResponse() != null ? iGlobalTelephoneStateStruct.getNadInstanceState().getSuppServiceResponse().getTelCFResponseData() : null) : null;
            this.updateCallForwardingStatusIcon(cFResponseDataArray);
        }
        if (bl2) {
            this.log.log(1078071040, "TelCallForwardingStatusIconHandler#updateGlobalTelephoneStateProperty() nad is ready now");
            cFResponseDataArray = iGlobalTelephoneStateStruct.getNadInstanceState() != null ? (iGlobalTelephoneStateStruct.getNadInstanceState().getSuppServiceResponse() != null ? iGlobalTelephoneStateStruct.getNadInstanceState().getSuppServiceResponse().getTelCFResponseData() : null) : null;
            this.updateCallForwardingStatusIcon(cFResponseDataArray);
        } else if (bl) {
            this.log.log(1078071040, "TelCallForwardingStatusIconHandler#updateGlobalTelephoneStateProperty() nad is not ready anymore");
            this.callForwardingStatusBitField.clearAllBits();
            this.hideCallForwardingIcon();
        }
    }

    void updateCallForwardingStatusIcon(CFResponseData[] cFResponseDataArray) {
        this.storeCallForwardingStatus(cFResponseDataArray);
        this.log.log(-2137614336, "TelCallForwardingStatusIconHandler#updateCallForwardingStatusIcon: callForwardingStatusBitField: %1", (long)this.callForwardingStatusBitField.getAllBits());
        if (this.isCallForwardingActive()) {
            this.showCallForwardingIcon();
        } else {
            this.hideCallForwardingIcon();
        }
    }

    private void storeCallForwardingStatus(CFResponseData[] cFResponseDataArray) {
        if (cFResponseDataArray == null) {
            return;
        }
        if (cFResponseDataArray.length == 0) {
            this.callForwardingStatusBitField.clearAllBits();
        }
        for (int i2 = 0; i2 < cFResponseDataArray.length; ++i2) {
            this.storeCallForwardingStatus(cFResponseDataArray[i2]);
        }
    }

    private void storeCallForwardingStatus(CFResponseData cFResponseData) {
        if (cFResponseData == null) {
            return;
        }
        if (this.isConsideredActive(cFResponseData)) {
            this.callForwardingStatusBitField.setBit(cFResponseData.telCFCondition);
        } else {
            this.callForwardingStatusBitField.clearBit(cFResponseData.telCFCondition);
        }
    }

    private boolean isCallForwardingActive() {
        return this.callForwardingStatusBitField.isBitSet(0);
    }

    protected boolean isConsideredActive(CFResponseData cFResponseData) {
        return cFResponseData.telCFStatus == 1 && (cFResponseData.telClass & 1) > 0;
    }

    protected abstract void showCallForwardingIcon() {
    }

    protected abstract void hideCallForwardingIcon() {
    }
}

