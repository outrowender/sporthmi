/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.log.LogChannel;
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

    public void getExtents(final int n, final int n2, final int n3) {
        this.log.log(10000000, "DSIDisplayListener#getExtents cid = %1, width = %2, height = %3", (long)n, (long)n2, (long)n3);
        RunnableEvent runnableEvent = new RunnableEvent(false, new Runnable(){

            public void run() {
                Integer n4 = new Integer(n);
                Object object = ((DSIDisplayListener)DSIDisplayListener.this).manager.displayableExtents.get(n4);
                if (object != null) {
                    int[] nArray = (int[])object;
                    nArray[0] = n2;
                    nArray[1] = n3;
                } else {
                    int[] nArray = new int[]{n2, n3};
                    ((DSIDisplayListener)DSIDisplayListener.this).manager.displayableExtents.put(n4, nArray);
                }
            }
        });
        this.manager.framework.getHMIService().getEventDispatcher().postEvent(runnableEvent);
    }

    public void activeContext(int n, int n2, int n3) {
        this.log.log(10000000, "confirmed internal context for internal terminal: %1 is %2 with sessionID: %3", (long)n2, (long)n, (long)n3);
        this.manager.setActiveContext(n, n2, n3);
    }

    public void fadeStarted(int n, int n2) {
    }

    public void fadeComplete(int n, int n2) {
    }

    public void getDisplayPower(int n, int n2) {
    }

    public void getBrightness(int n, int n2) {
        this.log.log(10000000, "confirmed brightness for displayable: %1  is %2", (long)n, (long)n2);
    }

    public void getContrast(int n, int n2) {
        this.log.log(10000000, "confirmed contrast for displayable: %1  is %2", (long)n, (long)n2);
    }

    public void getColor(int n, int n2) {
        this.log.log(10000000, "confirmed color for displayable: %1  is %2", (long)n, (long)n2);
    }

    public void getTint(int n, int n2) {
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "errorCode=%2, errorMsg=%, requestType=%3", (Object)string, (long)n, (long)n2);
    }

    public void getDisplayBrightness(int n, int n2) {
    }

    public void lockDisplayResult(int n) {
        this.log.log(10000000, "lockDisplayResult received, resultCode: %1", (long)n);
        this.manager.lockDisplayResult(n);
    }

    public void unlockDisplayResult(int n) {
        this.log.log(10000000, "unlockDisplayResult received, resultCode: %1", (long)n);
        this.manager.unlockDisplayResult(n);
    }

    public void setCroppingResult(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
    }

    public void getDisplayableInfo(int n, int n2, int n3) {
    }

    public void takeScreenshotOnExternalStorageResult(int n, int n2, String string) {
    }

    public void setDisplayTypeResult(int n, int n2) {
    }

    public void getDisplayTypeResult(int n, int n2) {
    }

    public void setUpdateRateResult(int n, int n2) {
    }

    public void getUpdateRateResult(int n, int n2) {
    }

    public void startComponentResult(int n, int n2, int n3, int n4) {
    }

    public void stopComponentResult(int n, int n2, int n3, int n4) {
    }

    public void setAnnotationDataResponse(int n, int n2) {
    }

    public void initAnnotationsResponse(int n, int n2) {
    }

    public void destroyImageDisplayableResponse(int n, int n2) {
    }

    public void requestUpdateImageDisplayableResponse(int n, int n2) {
    }

    public void createImageDisplayableResponse(int n, int n2) {
    }
}

