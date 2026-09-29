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

    @Override
    public void declareContexts(DisplayContext[] displayContextArray) {
        this.log();
    }

    @Override
    public void switchContext(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void setOpacity(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void fadeToOpacity(int n, int n2, int n3, int n4) {
        this.log();
    }

    @Override
    public void setPosition(int n, int n2, int n3, int n4) {
        this.log();
    }

    @Override
    public void getExtents(int n) {
        this.log();
    }

    @Override
    public void takeScreenshot(int n, String string) {
        this.log();
    }

    @Override
    public void lockDisplay(int n) {
        this.log();
    }

    @Override
    public void unlockDisplay(int n) {
        this.log();
    }

    @Override
    public void switchDisplayPower(int n, int n2) {
        this.log();
    }

    @Override
    public void getDisplayPower(int n) {
        this.log();
    }

    @Override
    public void setDisplayBrightness(int n, int n2) {
        this.log();
    }

    @Override
    public void getDisplayBrightness(int n) {
        this.log();
    }

    @Override
    public void setBrightness(int n, int n2) {
        this.log();
    }

    @Override
    public void getBrightness(int n) {
        this.log();
    }

    @Override
    public void setContrast(int n, int n2) {
        this.log();
    }

    @Override
    public void getContrast(int n) {
        this.log();
    }

    @Override
    public void setColor(int n, int n2) {
        this.log();
    }

    @Override
    public void getColor(int n) {
        this.log();
    }

    @Override
    public void setTint(int n, int n2) {
        this.log();
    }

    @Override
    public void getTint(int n) {
        this.log();
    }

    public void setFramedropMode(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void setCropping(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        this.log();
    }

    @Override
    public void getDisplayableInfo(int n, int n2) {
        this.log();
    }

    @Override
    public void setDimension(int n, int n2, int n3, int n4) {
        this.log();
    }

    @Override
    public void setScaleMode(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void takeScreenshotOnExternalStorage(int n, String string) {
        this.log();
    }

    @Override
    public void setDisplayType(int n, int n2) {
        this.log();
    }

    @Override
    public void getDisplayType(int n) {
        this.log();
    }

    @Override
    public void setUpdateRate(int n, int n2) {
        this.log();
    }

    @Override
    public void getUpdateRate(int n) {
        this.log();
    }

    @Override
    public void startComponent(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void stopComponent(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void createImageDisplayable(ResourceLocator resourceLocator, int n) {
    }

    @Override
    public void requestUpdateImageDisplayable(ResourceLocator resourceLocator, int n) {
    }

    @Override
    public void destroyImageDisplayable(int n) {
    }

    @Override
    public void initAnnotations(int n) {
    }

    @Override
    public void setAnnotationData(int n, int n2, String string) {
    }
}

