/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.keypanel;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIKeyPanelReply {
    public static final String IPL_COMM_UUID = "5ff7918a-abb4-545e-9661-bdbeef142ed1";
    public static final String IPL_COMM_INTERFACE_KEY = "633a3b39-3b09-57ba-bc39-eebaf5ef6848";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.33";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.33";

    public void updateKey2(int var1, int var2, int var3, int var4, int var5) throws MethodException;

    public void updateEncoder2(int var1, int var2, int var3, int var4, int var5) throws MethodException;

    public void updateDisplayTurnMechStatus(int var1, int var2) throws MethodException;

    public void updateRecognizerLanguage2(int var1, String var2, int var3, int var4) throws MethodException;

    public void updateRecognizerMode(int var1, int var2, int var3) throws MethodException;

    public void updateCharacterEvent2(int var1, String[] var2, int[] var3, int var4) throws MethodException;

    public void updateGesture2(int var1, int var2, int var3, boolean var4, int var5, int var6, int var7, int var8, int var9, int var10) throws MethodException;

    public void genericSettingResponse(int var1, int var2, int var3) throws MethodException;

    public void updateProximity(int var1, int var2, int var3) throws MethodException;

    public void updateAdvancedProximity(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) throws MethodException;

    public void lastKey(int var1, int var2, int var3) throws MethodException;

    public void updateKeyboardType(int var1, int var2) throws MethodException;

    public void updateTouchSensitiveArea(int var1, int var2, int var3, int var4, int var5, int var6) throws MethodException;

    public void getVersionInfo(int var1, int var2, String var3) throws MethodException;

    public void updateInputPanelReady(int var1, int var2, int var3) throws MethodException;

    public void getProperty(int var1, int var2, int var3, int var4, byte[] var5) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

