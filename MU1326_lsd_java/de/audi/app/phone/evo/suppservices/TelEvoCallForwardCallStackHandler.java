/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.suppservices;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.callstacks.AbstractCallStackEntryRow;
import de.audi.app.phone.core.callstacks.AbstractCallStackHandler;
import de.audi.app.phone.core.suppservices.AbstractTelCallForwardingHandler;
import de.audi.app.phone.evo.callstacks.TelEvoCallStackRow;
import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.util.StringUtilities;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class TelEvoCallForwardCallStackHandler
extends AbstractCallStackHandler {
    private final AbstractTelCallForwardingHandler callForwardHandler;

    public TelEvoCallForwardCallStackHandler(ITelApplication iTelApplication, AbstractTelCallForwardingHandler abstractTelCallForwardingHandler) {
        super(iTelApplication, 10);
        this.callForwardHandler = abstractTelCallForwardingHandler;
    }

    protected ListModelApp getCombinedNumbersList() {
        return this.getListModel(300772);
    }

    protected BaseListRow getCallStackRow(CallStackEntry callStackEntry) {
        return new TelEvoCallStackRow(callStackEntry, this.log, this.telephoneState);
    }

    protected void callStackEntrySelected(int n, AbstractCallStackEntryRow abstractCallStackEntryRow, int n2, int n3) {
        if (abstractCallStackEntryRow == null) {
            this.log.log(10000, "[TelEvoCallForwardCallStackHandler#callStackEntrySelected] entry is null.");
            return;
        }
        this.log.log(1000000, "[TelEvoCallForwardCallStackHandler#callStackEntrySelected] entry=%1", (Object)abstractCallStackEntryRow.getCallStackEntry());
        this.activateCallForwarding(abstractCallStackEntryRow.getCallStackEntry().getClNumber(), n3);
    }

    protected void callStackEntryDialed(CallStackEntry callStackEntry) {
    }

    protected void updateCallStackEntries() {
    }

    private void activateCallForwarding(String string, int n) {
        if (!StringUtilities.isNullOrEmpty(string)) {
            this.log.log(1000000, "[TelEvoCallForwardCallStackHandler#activateCallForwarding] number %1", (Object)string);
            this.callForwardHandler.activateCallForwarding(string, n);
            this.getCombinedNumbersList().fireEvent(n);
        } else {
            this.log.log(1000000, "[TelEvoCallForwardCallStackHandler#activateCallForwarding] number is empty --> NOP!");
        }
    }
}

