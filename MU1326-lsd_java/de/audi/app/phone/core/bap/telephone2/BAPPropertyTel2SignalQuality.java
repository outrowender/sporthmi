/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone2;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone2.AbstractTel2EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.bap.telephone2.TelBAPManagerTel2Utils;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class BAPPropertyTel2SignalQuality
extends AbstractTel2EnqueuedBAPPropertyHandler {
    private static final int SIGNAL_QUALITY_KOMBI_INVALID;
    private static final int SIGNAL_QUALITY_DSI_INVALID;
    private static final int SIGNAL_QUALITY_UNKNOWN;
    private volatile int dataSignalQuality = -1;

    public BAPPropertyTel2SignalQuality(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    @Override
    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null;
    }

    private void updateCombiWithDataSignalQuality(CombiBAPServicePhone2 combiBAPServicePhone2, int n, int n2, int n3, int n4, boolean bl) {
        if (this.log.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("nadMode=");
            buffer.append(n);
            buffer.append(", ");
            buffer.append("telMode=");
            buffer.append(n2);
            buffer.append(", ");
            buffer.append("signalQuality=");
            buffer.append(n3);
            buffer.append(", ");
            buffer.append("dataSignalQuality=");
            buffer.append(n4);
            this.log.log(1078071040, "[BAPPropertyTel2SignalQuality#updateCombiWithDataSignalQuality] %1", (Object)buffer);
        }
        if (TelBAPManagerTel2Utils.telModeSupportsData(n2) || !bl) {
            combiBAPServicePhone2.updateSignalQuality(n4);
            this.dataSignalQuality = n4;
        }
    }

    @Override
    protected void updateAsync() {
        CombiBAPServicePhone2 combiBAPServicePhone2 = this.getCombiService();
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        if (iGlobalTelephoneStateStruct != null) {
            int n;
            int n2 = iGlobalTelephoneStateStruct.getNadMode();
            int n3 = iGlobalTelephoneStateStruct.getNadInstanceState() != null ? iGlobalTelephoneStateStruct.getNadInstanceState().getTelMode() : 4;
            boolean bl = iGlobalTelephoneStateStruct.getNadInstanceState() != null ? iGlobalTelephoneStateStruct.getNadInstanceState().isPhoneReady() : false;
            int n4 = iGlobalTelephoneStateStruct.getNadInstanceState() != null ? iGlobalTelephoneStateStruct.getNadInstanceState().getSignalQuality() : 255;
            int n5 = n = n4 == 255 ? 0 : n4;
            if (combiBAPServicePhone2 != null) {
                if (this.dataSignalQuality == -1) {
                    this.updateCombiWithDataSignalQuality(combiBAPServicePhone2, n2, n3, n4, n, bl);
                } else if (this.dataSignalQuality != n) {
                    this.updateCombiWithDataSignalQuality(combiBAPServicePhone2, n2, n3, n4, n, bl);
                }
            } else {
                this.log.log(-1601830656, "[BAPPropertyTel2SignalQuality#update] CombiBAPServicePhone is null --> NOP!");
            }
        } else {
            this.log.log(10000, "BAPPropertyTel2SignalQuality#updateAsync state is null");
        }
    }
}

