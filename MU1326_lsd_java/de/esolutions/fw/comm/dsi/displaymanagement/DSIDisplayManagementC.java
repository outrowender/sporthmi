/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.displaymanagement;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.displaymanagement.DisplayContext;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIDisplayManagementC {
    public void declareContexts(DisplayContext[] var1) throws MethodException;

    public void switchContext(int var1, int var2, int var3) throws MethodException;

    public void setOpacity(int var1, int var2, int var3) throws MethodException;

    public void fadeToOpacity(int var1, int var2, int var3, int var4) throws MethodException;

    public void setPosition(int var1, int var2, int var3, int var4) throws MethodException;

    public void getExtents(int var1) throws MethodException;

    public void takeScreenshot(int var1, String var2) throws MethodException;

    public void lockDisplay(int var1) throws MethodException;

    public void unlockDisplay(int var1) throws MethodException;

    public void switchDisplayPower(int var1, int var2) throws MethodException;

    public void getDisplayPower(int var1) throws MethodException;

    public void setDisplayBrightness(int var1, int var2) throws MethodException;

    public void getDisplayBrightness(int var1) throws MethodException;

    public void setBrightness(int var1, int var2) throws MethodException;

    public void getBrightness(int var1) throws MethodException;

    public void setContrast(int var1, int var2) throws MethodException;

    public void getContrast(int var1) throws MethodException;

    public void setColor(int var1, int var2) throws MethodException;

    public void getColor(int var1) throws MethodException;

    public void setTint(int var1, int var2) throws MethodException;

    public void getTint(int var1) throws MethodException;

    public void setCropping(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) throws MethodException;

    public void getDisplayableInfo(int var1, int var2) throws MethodException;

    public void setDimension(int var1, int var2, int var3, int var4) throws MethodException;

    public void setScaleMode(int var1, int var2, int var3) throws MethodException;

    public void takeScreenshotOnExternalStorage(int var1, String var2) throws MethodException;

    public void setDisplayType(int var1, int var2) throws MethodException;

    public void getDisplayType(int var1) throws MethodException;

    public void setUpdateRate(int var1, int var2) throws MethodException;

    public void getUpdateRate(int var1) throws MethodException;

    public void startComponent(int var1, int var2, int var3) throws MethodException;

    public void stopComponent(int var1, int var2, int var3) throws MethodException;

    public void createImageDisplayable(ResourceLocator var1, int var2) throws MethodException;

    public void requestUpdateImageDisplayable(ResourceLocator var1, int var2) throws MethodException;

    public void destroyImageDisplayable(int var1) throws MethodException;

    public void initAnnotations(int var1) throws MethodException;

    public void setAnnotationData(int var1, int var2, String var3) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

