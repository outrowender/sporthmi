/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.AbstractTel1EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.MissedCallIndicator;

public class BAPPropertyTelMissedCallIndication
extends AbstractTel1EnqueuedBAPPropertyHandler {
    public BAPPropertyTelMissedCallIndication(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    @Override
    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && (n == 704643328 || n == 654311680);
    }

    @Override
    protected void updateAsync() {
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiService();
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        if (combiBAPServicePhone != null) {
            if (iGlobalTelephoneStateStruct != null) {
                CallStackEntry[] callStackEntryArray = iGlobalTelephoneStateStruct.getMissedNumbers();
                MissedCallIndicator missedCallIndicator = iGlobalTelephoneStateStruct.getMissedCallIndicator();
                int n = callStackEntryArray != null ? callStackEntryArray.length : 0;
                int n2 = missedCallIndicator != null ? missedCallIndicator.getMissedCallCount() : 0;
                this.log.log(1078071040, "[BAPPropertyTelMissedCallIndication#update] missedCalls=%1, missedNumbers=%2", (long)n2, (long)n);
                combiBAPServicePhone.updateMissedCallIndication(n2, n);
            } else {
                this.log.log(-1601830656, "[BAPPropertyTelMissedCallIndication#update] state is null --> NOP!");
            }
        } else {
            this.log.log(-1601830656, "[BAPPropertyTelMissedCallIndication#update] CombiBAPServicePhone is null --> NOP!");
        }
    }
}

