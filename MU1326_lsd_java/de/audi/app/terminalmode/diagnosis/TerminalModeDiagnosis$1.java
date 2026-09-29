/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.diagnosis;

import de.audi.app.terminalmode.diagnosis.TerminalModeDiagnosis;
import de.audi.app.terminalmode.osgi.AbstractServiceListTracker;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.atip.log.LogChannel;
import java.util.Dictionary;

class TerminalModeDiagnosis$1
extends AbstractServiceListTracker {
    private final /* synthetic */ TerminalModeDiagnosis this$0;

    TerminalModeDiagnosis$1(TerminalModeDiagnosis terminalModeDiagnosis, LogChannel logChannel, IServiceManager iServiceManager) {
        this.this$0 = terminalModeDiagnosis;
        super(logChannel, iServiceManager);
    }

    @Override
    protected void serviceRemoved(Object object) {
    }

    @Override
    protected void serviceAdded(Object object) {
    }

    @Override
    protected Class getTrackedServiceClass() {
        return TerminalModeDiagnosis.class$de$audi$atip$hmi$HMIModelBank == null ? (TerminalModeDiagnosis.class$de$audi$atip$hmi$HMIModelBank = TerminalModeDiagnosis.class$("de.audi.atip.hmi.HMIModelBank")) : TerminalModeDiagnosis.class$de$audi$atip$hmi$HMIModelBank;
    }

    @Override
    protected boolean checkServiceProperties(Dictionary dictionary) {
        return (Integer)dictionary.get("moduleID") == 43;
    }
}

