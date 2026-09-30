/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.keypanel;

import org.dsi.ifc.base.DSIListener;

public interface DSIKeyPanelListener
extends DSIListener {
    public void updateKey2(int var1, int var2, int var3, int var4, int var5);

    public void updateEncoder2(int var1, int var2, int var3, int var4, int var5);

    public void updateDisplayTurnMechStatus(int var1, int var2);

    public void updateRecognizerLanguage2(int var1, String var2, int var3, int var4);

    public void updateRecognizerMode(int var1, int var2, int var3);

    public void updateCharacterEvent2(int var1, String[] var2, int[] var3, int var4);

    public void updateGesture2(int var1, int var2, int var3, boolean var4, int var5, int var6, int var7, int var8, int var9, int var10);

    public void genericSettingResponse(int var1, int var2, int var3);

    public void updateProximity(int var1, int var2, int var3);

    public void updateAdvancedProximity(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10);

    public void lastKey(int var1, int var2, int var3);

    public void updateKeyboardType(int var1, int var2);

    public void updateTouchSensitiveArea(int var1, int var2, int var3, int var4, int var5, int var6);

    public void getVersionInfo(int var1, int var2, String var3);

    public void updateInputPanelReady(int var1, int var2, int var3);

    public void getProperty(int var1, int var2, int var3, int var4, byte[] var5);
}

