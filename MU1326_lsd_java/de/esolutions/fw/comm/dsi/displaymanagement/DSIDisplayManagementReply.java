/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.displaymanagement;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIDisplayManagementReply {
    public static final String IPL_COMM_UUID = "f20ac96e-5798-5645-b002-79c3f154460f";
    public static final String IPL_COMM_INTERFACE_KEY = "0a94880b-c8d5-54ef-b374-ab6963ae14d6";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.27";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.27";

    public void getExtents(int var1, int var2, int var3) throws MethodException;

    public void activeContext(int var1, int var2, int var3) throws MethodException;

    public void fadeStarted(int var1, int var2) throws MethodException;

    public void fadeComplete(int var1, int var2) throws MethodException;

    public void getDisplayPower(int var1, int var2) throws MethodException;

    public void getDisplayBrightness(int var1, int var2) throws MethodException;

    public void getBrightness(int var1, int var2) throws MethodException;

    public void getContrast(int var1, int var2) throws MethodException;

    public void getColor(int var1, int var2) throws MethodException;

    public void getTint(int var1, int var2) throws MethodException;

    public void lockDisplayResult(int var1) throws MethodException;

    public void unlockDisplayResult(int var1) throws MethodException;

    public void setCroppingResult(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) throws MethodException;

    public void getDisplayableInfo(int var1, int var2, int var3) throws MethodException;

    public void takeScreenshotOnExternalStorageResult(int var1, int var2, String var3) throws MethodException;

    public void setDisplayTypeResult(int var1, int var2) throws MethodException;

    public void getDisplayTypeResult(int var1, int var2) throws MethodException;

    public void setUpdateRateResult(int var1, int var2) throws MethodException;

    public void getUpdateRateResult(int var1, int var2) throws MethodException;

    public void startComponentResult(int var1, int var2, int var3, int var4) throws MethodException;

    public void stopComponentResult(int var1, int var2, int var3, int var4) throws MethodException;

    public void setAnnotationDataResponse(int var1, int var2) throws MethodException;

    public void initAnnotationsResponse(int var1, int var2) throws MethodException;

    public void destroyImageDisplayableResponse(int var1, int var2) throws MethodException;

    public void requestUpdateImageDisplayableResponse(int var1, int var2) throws MethodException;

    public void createImageDisplayableResponse(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

