/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface CustDownloadActionProxy
extends ActionProxy {
    public void readyForCustomerUpdate(int var1);

    public void resetSummaryUpdateCompleteStatus(int var1);

    public void abortSelection(int var1);

    public void abortProgressError(int var1);

    public void abortProgressInterrupt(int var1);

    public void leaveCustomerUpdate(int var1);

    public void leaveCustomerUpdatePopups(int var1, int var2);

    public void swdlCustomerUpdateEntered(int var1);

    public void swdlCustomerUpdateLeft(int var1);

    public void swdlEnterUota(int var1);

    public void swdlCustomerUpdateEnteredFromNavi(int var1);
}

