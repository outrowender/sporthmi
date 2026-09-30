/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util.osgi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSIBase;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;
import org.dsi.ifc.displaymanagement.DisplayContext;
import org.dsi.ifc.global.ResourceLocator;

public class NullDSIDisplayManagement
extends NullDSIBase
implements DSIDisplayManagement {
    public NullDSIDisplayManagement(LogChannel logChannel) {
        super(logChannel, "DSIDisplayManagement");
    }

    public void declareContexts(DisplayContext[] displayContextArray) {
        this.log();
    }

    public void switchContext(int n, int n2, int n3) {
        this.log();
    }

    public void setOpacity(int n, int n2, int n3) {
        this.log();
    }

    public void fadeToOpacity(int n, int n2, int n3, int n4) {
        this.log();
    }

    public void setPosition(int n, int n2, int n3, int n4) {
        this.log();
    }

    public void getExtents(int n) {
        this.log();
    }

    public void takeScreenshot(int n, String string) {
        this.log();
    }

    public void lockDisplay(int n) {
        this.log();
    }

    public void unlockDisplay(int n) {
        this.log();
    }

    public void switchDisplayPower(int n, int n2) {
        this.log();
    }

    public void getDisplayPower(int n) {
        this.log();
    }

    public void setDisplayBrightness(int n, int n2) {
        this.log();
    }

    public void getDisplayBrightness(int n) {
        this.log();
    }

    public void setBrightness(int n, int n2) {
        this.log();
    }

    public void getBrightness(int n) {
        this.log();
    }

    public void setContrast(int n, int n2) {
        this.log();
    }

    public void getContrast(int n) {
        this.log();
    }

    public void setColor(int n, int n2) {
        this.log();
    }

    public void getColor(int n) {
        this.log();
    }

    public void setTint(int n, int n2) {
        this.log();
    }

    public void getTint(int n) {
        this.log();
    }

    public void setFramedropMode(int n, int n2, int n3) {
        this.log();
    }

    public void setCropping(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        this.log();
    }

    public void getDisplayableInfo(int n, int n2) {
        this.log();
    }

    public void setDimension(int n, int n2, int n3, int n4) {
        this.log();
    }

    public void setScaleMode(int n, int n2, int n3) {
        this.log();
    }

    public void takeScreenshotOnExternalStorage(int n, String string) {
        this.log();
    }

    public void setDisplayType(int n, int n2) {
        this.log();
    }

    public void getDisplayType(int n) {
        this.log();
    }

    public void setUpdateRate(int n, int n2) {
        this.log();
    }

    public void getUpdateRate(int n) {
        this.log();
    }

    public void startComponent(int n, int n2, int n3) {
        this.log();
    }

    public void stopComponent(int n, int n2, int n3) {
        this.log();
    }

    public void createImageDisplayable(ResourceLocator resourceLocator, int n) {
    }

    public void requestUpdateImageDisplayable(ResourceLocator resourceLocator, int n) {
    }

    public void destroyImageDisplayable(int n) {
    }

    public void initAnnotations(int n) {
    }

    public void setAnnotationData(int n, int n2, String string) {
    }
}

