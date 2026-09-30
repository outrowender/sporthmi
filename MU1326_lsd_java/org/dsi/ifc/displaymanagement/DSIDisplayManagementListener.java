/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.displaymanagement;

import org.dsi.ifc.base.DSIListener;

public interface DSIDisplayManagementListener
extends DSIListener {
    public void getExtents(int var1, int var2, int var3);

    public void activeContext(int var1, int var2, int var3);

    public void fadeStarted(int var1, int var2);

    public void fadeComplete(int var1, int var2);

    public void getDisplayPower(int var1, int var2);

    public void getDisplayBrightness(int var1, int var2);

    public void getBrightness(int var1, int var2);

    public void getContrast(int var1, int var2);

    public void getColor(int var1, int var2);

    public void getTint(int var1, int var2);

    public void lockDisplayResult(int var1);

    public void unlockDisplayResult(int var1);

    public void setCroppingResult(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11);

    public void getDisplayableInfo(int var1, int var2, int var3);

    public void takeScreenshotOnExternalStorageResult(int var1, int var2, String var3);

    public void setDisplayTypeResult(int var1, int var2);

    public void getDisplayTypeResult(int var1, int var2);

    public void setUpdateRateResult(int var1, int var2);

    public void getUpdateRateResult(int var1, int var2);

    public void startComponentResult(int var1, int var2, int var3, int var4);

    public void stopComponentResult(int var1, int var2, int var3, int var4);

    public void setAnnotationDataResponse(int var1, int var2);

    public void initAnnotationsResponse(int var1, int var2);

    public void destroyImageDisplayableResponse(int var1, int var2);

    public void requestUpdateImageDisplayableResponse(int var1, int var2);

    public void createImageDisplayableResponse(int var1, int var2);
}

