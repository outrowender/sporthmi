/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.display;

import de.audi.app.media.dsi.display.DSIDisplayManagerControllerImpl;
import de.audi.app.media.dsi.display.IMediaDisplayManagerListener;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.displaymanagement.DSIDisplayManagementListener;

public class DSIDisplayManagerListener
implements DSIDisplayManagementListener {
    private static final String LOGCLASS = "DSIDisplayManagerListener";
    private final LogChannel logger;
    private final DSIDisplayManagerControllerImpl controller;

    DSIDisplayManagerListener(DSIDisplayManagerControllerImpl dSIDisplayManagerControllerImpl, LogChannel logChannel) {
        this.controller = dSIDisplayManagerControllerImpl;
        this.logger = logChannel;
    }

    public void getBrightness(int n, int n2) {
        this.logger.log(1000000, "[%1.getBrightness] displayable='%2',brightness='%3'", (Object)LOGCLASS, (long)n, (long)n2);
        IMediaDisplayManagerListener iMediaDisplayManagerListener = this.controller.getDisplayManagerListener();
        if (iMediaDisplayManagerListener == null) {
            return;
        }
        iMediaDisplayManagerListener.updateBrigthness(n, n2);
    }

    public void getContrast(int n, int n2) {
        this.logger.log(1000000, "[%1.getContrast] displayable='%2',contrast='%3'", (Object)LOGCLASS, (long)n, (long)n2);
        IMediaDisplayManagerListener iMediaDisplayManagerListener = this.controller.getDisplayManagerListener();
        if (iMediaDisplayManagerListener == null) {
            return;
        }
        iMediaDisplayManagerListener.updateContrast(n, n2);
    }

    public void getColor(int n, int n2) {
        this.logger.log(1000000, "[%1.getColor] displayable='%2',color='%3'", (Object)LOGCLASS, (long)n, (long)n2);
        IMediaDisplayManagerListener iMediaDisplayManagerListener = this.controller.getDisplayManagerListener();
        if (iMediaDisplayManagerListener == null) {
            return;
        }
        iMediaDisplayManagerListener.updateColor(n, n2);
    }

    public void getTint(int n, int n2) {
        this.logger.log(1000000, "[%1.getTint] displayable='%2',tint='%3'", (Object)LOGCLASS, (long)n, (long)n2);
        IMediaDisplayManagerListener iMediaDisplayManagerListener = this.controller.getDisplayManagerListener();
        if (iMediaDisplayManagerListener == null) {
            return;
        }
        iMediaDisplayManagerListener.updateTint(n, n2);
    }

    public void asyncException(int n, String string, int n2) {
        this.logger.log(100000, "[%1.asyncException] '%2'.", (Object)LOGCLASS, (Object)string);
    }

    public void activeContext(int n, int n2, int n3) {
    }

    public void getExtents(int n, int n2, int n3) {
    }

    public void fadeStarted(int n, int n2) {
    }

    public void fadeComplete(int n, int n2) {
    }

    public void getDisplayPower(int n, int n2) {
    }

    public void getDisplayBrightness(int n, int n2) {
    }

    public void lockDisplayResult(int n) {
    }

    public void unlockDisplayResult(int n) {
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

