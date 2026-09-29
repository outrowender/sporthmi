/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface SWDLActionProxy
extends ActionProxy {
    default public void swdlDeviceSelectEntered(int n) {
    }

    default public void swdlDeviceSelectLeft(int n) {
    }

    default public void swdlSelectOneRelease(int n) {
    }

    default public void swdlAbortReadingReleases(int n) {
    }

    default public void swdlEntered(int n) {
    }

    default public void swdlExit(int n) {
    }

    default public void swdlInterruptDownload(int n) {
    }

    default public void swdlStartWaitLostDevices(int n) {
    }

    default public void swdlStopWaitLostDevices(int n) {
    }

    default public void swdlLeaveSummaryChanged(int n) {
    }

    default public void swdlProgressEntered(int n) {
    }

    default public void swdlProgressExit(int n) {
    }

    default public void swdlSummaryEntered(int n) {
    }

    default public void swdlSummaryExit(int n) {
    }

    default public void swdlTriggerEntered(int n) {
    }

    default public void swdlTriggerExit(int n) {
    }

    default public void swdlLeavePopupByHKReturn(int n) {
    }

    default public void swdlModuleSelectEntered(int n) {
    }

    default public void swdlModuleSelectLeft(int n) {
    }

    default public void swdlAppBlSelectLeft(int n) {
    }

    default public void swdlLoggingEntered(int n) {
    }

    default public void swdlProgressDetailEntered(int n) {
    }

    default public void swdlProgressDetailExit(int n) {
    }

    default public void swdlAbortReadingMetainfo(int n) {
    }
}

