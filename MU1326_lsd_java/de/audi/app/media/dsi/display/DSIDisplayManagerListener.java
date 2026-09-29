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
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final DSIDisplayManagerControllerImpl controller;

    DSIDisplayManagerListener(DSIDisplayManagerControllerImpl dSIDisplayManagerControllerImpl, LogChannel logChannel) {
        this.controller = dSIDisplayManagerControllerImpl;
        this.logger = logChannel;
    }

    @Override
    public void getBrightness(int n, int n2) {
        this.logger.log(1078071040, "[%1.getBrightness] displayable='%2',brightness='%3'", (Object)"DSIDisplayManagerListener", (long)n, (long)n2);
        IMediaDisplayManagerListener iMediaDisplayManagerListener = this.controller.getDisplayManagerListener();
        if (iMediaDisplayManagerListener == null) {
            return;
        }
        iMediaDisplayManagerListener.updateBrigthness(n, n2);
    }

    @Override
    public void getContrast(int n, int n2) {
        this.logger.log(1078071040, "[%1.getContrast] displayable='%2',contrast='%3'", (Object)"DSIDisplayManagerListener", (long)n, (long)n2);
        IMediaDisplayManagerListener iMediaDisplayManagerListener = this.controller.getDisplayManagerListener();
        if (iMediaDisplayManagerListener == null) {
            return;
        }
        iMediaDisplayManagerListener.updateContrast(n, n2);
    }

    @Override
    public void getColor(int n, int n2) {
        this.logger.log(1078071040, "[%1.getColor] displayable='%2',color='%3'", (Object)"DSIDisplayManagerListener", (long)n, (long)n2);
        IMediaDisplayManagerListener iMediaDisplayManagerListener = this.controller.getDisplayManagerListener();
        if (iMediaDisplayManagerListener == null) {
            return;
        }
        iMediaDisplayManagerListener.updateColor(n, n2);
    }

    @Override
    public void getTint(int n, int n2) {
        this.logger.log(1078071040, "[%1.getTint] displayable='%2',tint='%3'", (Object)"DSIDisplayManagerListener", (long)n, (long)n2);
        IMediaDisplayManagerListener iMediaDisplayManagerListener = this.controller.getDisplayManagerListener();
        if (iMediaDisplayManagerListener == null) {
            return;
        }
        iMediaDisplayManagerListener.updateTint(n, n2);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logger.log(-1601830656, "[%1.asyncException] '%2'.", (Object)"DSIDisplayManagerListener", (Object)string);
    }

    @Override
    public void activeContext(int n, int n2, int n3) {
    }

    @Override
    public void getExtents(int n, int n2, int n3) {
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
    public void getDisplayBrightness(int n, int n2) {
    }

    @Override
    public void lockDisplayResult(int n) {
    }

    @Override
    public void unlockDisplayResult(int n) {
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
}

