/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.fwhmi.DSIDisplayListener$1;
import de.audi.tghu.fwhmi.DisplayManager;
import org.dsi.ifc.displaymanagement.DSIDisplayManagementListener;

final class DSIDisplayListener
implements DSIDisplayManagementListener {
    private DisplayManager manager;
    private LogChannel log;

    protected DSIDisplayListener(DisplayManager displayManager) {
        this.manager = displayManager;
        this.log = this.manager.getLogChannel();
    }

    @Override
    public void getExtents(int n, int n2, int n3) {
        this.log.log(-2137614336, "DSIDisplayListener#getExtents cid = %1, width = %2, height = %3", (long)n, (long)n2, (long)n3);
        RunnableEvent runnableEvent = new RunnableEvent(false, new DSIDisplayListener$1(this, n, n2, n3));
        this.manager.framework.getHMIService().getEventDispatcher().postEvent(runnableEvent);
    }

    @Override
    public void activeContext(int n, int n2, int n3) {
        this.log.log(-2137614336, "confirmed internal context for internal terminal: %1 is %2 with sessionID: %3", (long)n2, (long)n, (long)n3);
        this.manager.setActiveContext(n, n2, n3);
    }

    @Override
    public void fadeStarted(int n, int n2) {
    }

    @Override
    public void fadeComplete(int n, int n2) {
    }

    @Override
    public void getDisplayPower(int n, int n2) {
    }

    @Override
    public void getBrightness(int n, int n2) {
        this.log.log(-2137614336, "confirmed brightness for displayable: %1  is %2", (long)n, (long)n2);
    }

    @Override
    public void getContrast(int n, int n2) {
        this.log.log(-2137614336, "confirmed contrast for displayable: %1  is %2", (long)n, (long)n2);
    }

    @Override
    public void getColor(int n, int n2) {
        this.log.log(-2137614336, "confirmed color for displayable: %1  is %2", (long)n, (long)n2);
    }

    @Override
    public void getTint(int n, int n2) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "errorCode=%2, errorMsg=%, requestType=%3", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void getDisplayBrightness(int n, int n2) {
    }

    @Override
    public void lockDisplayResult(int n) {
        this.log.log(-2137614336, "lockDisplayResult received, resultCode: %1", (long)n);
        this.manager.lockDisplayResult(n);
    }

    @Override
    public void unlockDisplayResult(int n) {
        this.log.log(-2137614336, "unlockDisplayResult received, resultCode: %1", (long)n);
        this.manager.unlockDisplayResult(n);
    }

    @Override
    public void setCroppingResult(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
    }

    @Override
    public void getDisplayableInfo(int n, int n2, int n3) {
    }

    @Override
    public void takeScreenshotOnExternalStorageResult(int n, int n2, String string) {
    }

    @Override
    public void setDisplayTypeResult(int n, int n2) {
    }

    @Override
    public void getDisplayTypeResult(int n, int n2) {
    }

    @Override
    public void setUpdateRateResult(int n, int n2) {
    }

    @Override
    public void getUpdateRateResult(int n, int n2) {
    }

    @Override
    public void startComponentResult(int n, int n2, int n3, int n4) {
    }

    @Override
    public void stopComponentResult(int n, int n2, int n3, int n4) {
    }

    @Override
    public void setAnnotationDataResponse(int n, int n2) {
    }

    @Override
    public void initAnnotationsResponse(int n, int n2) {
    }

    @Override
    public void destroyImageDisplayableResponse(int n, int n2) {
    }

    @Override
    public void requestUpdateImageDisplayableResponse(int n, int n2) {
    }

    @Override
    public void createImageDisplayableResponse(int n, int n2) {
    }

    static /* synthetic */ DisplayManager access$000(DSIDisplayListener dSIDisplayListener) {
        return dSIDisplayListener.manager;
    }
}

