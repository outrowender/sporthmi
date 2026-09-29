/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface CustDownloadActionProxy
extends ActionProxy {
    default public void readyForCustomerUpdate(int n) {
    }

    default public void resetSummaryUpdateCompleteStatus(int n) {
    }

    default public void abortSelection(int n) {
    }

    default public void abortProgressError(int n) {
    }

    default public void abortProgressInterrupt(int n) {
    }

    default public void leaveCustomerUpdate(int n) {
    }

    default public void leaveCustomerUpdatePopups(int n, int n2) {
    }

    default public void swdlCustomerUpdateEntered(int n) {
    }

    default public void swdlCustomerUpdateLeft(int n) {
    }

    default public void swdlEnterUota(int n) {
    }

    default public void swdlCustomerUpdateEnteredFromNavi(int n) {
    }
}

