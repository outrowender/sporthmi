/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface SWDLActionProxy
extends ActionProxy {
    public void swdlDeviceSelectEntered(int var1);

    public void swdlDeviceSelectLeft(int var1);

    public void swdlSelectOneRelease(int var1);

    public void swdlAbortReadingReleases(int var1);

    public void swdlEntered(int var1);

    public void swdlExit(int var1);

    public void swdlInterruptDownload(int var1);

    public void swdlStartWaitLostDevices(int var1);

    public void swdlStopWaitLostDevices(int var1);

    public void swdlLeaveSummaryChanged(int var1);

    public void swdlProgressEntered(int var1);

    public void swdlProgressExit(int var1);

    public void swdlSummaryEntered(int var1);

    public void swdlSummaryExit(int var1);

    public void swdlTriggerEntered(int var1);

    public void swdlTriggerExit(int var1);

    public void swdlLeavePopupByHKReturn(int var1);

    public void swdlModuleSelectEntered(int var1);

    public void swdlModuleSelectLeft(int var1);

    public void swdlAppBlSelectLeft(int var1);

    public void swdlLoggingEntered(int var1);

    public void swdlProgressDetailEntered(int var1);

    public void swdlProgressDetailExit(int var1);

    public void swdlAbortReadingMetainfo(int var1);
}

