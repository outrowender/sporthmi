/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.TADMaxMinAngleReset;

public interface DSICarDrivingCharacteristicsC {
    public void setSuspensionControlLiftMode(boolean var1) throws MethodException;

    public void setSuspensionControlCarJackMode(boolean var1) throws MethodException;

    public void setSuspensionControlTrailerMode(boolean var1) throws MethodException;

    public void setSuspensionControlLoadingMode(boolean var1) throws MethodException;

    public void setSuspensionControlActiveProfile(int var1) throws MethodException;

    public void setSuspensionControlSnowChainMode(boolean var1) throws MethodException;

    public void setSuspensionControlActiveMode(int var1) throws MethodException;

    public void seteABCEasyEntry(boolean var1) throws MethodException;

    public void seteABCPitchControl(boolean var1) throws MethodException;

    public void seteABCSpecialPosition(boolean var1) throws MethodException;

    public void seteABCPreview(int var1) throws MethodException;

    public void setCharismaActiveProfile(int var1) throws MethodException;

    public void setCharismaActiveOperationMode(int var1) throws MethodException;

    public void setCharismaTrailerSetting(boolean var1) throws MethodException;

    public void setCharismaProgButton(CharismaProgButton var1) throws MethodException;

    public void requestCharismaProfileFunction(int var1, CharismaSetupTableWithoutOptionMask[] var2) throws MethodException;

    public void requestCharismaList(CharismaListUpdateInfo var1) throws MethodException;

    public void showCharismaPopup(int var1, int var2) throws MethodException;

    public void cancelCharismaPopup(int var1, int var2) throws MethodException;

    public void setCharismaSetFactoryDefault() throws MethodException;

    public void setCharismaSound(boolean var1) throws MethodException;

    public void showTADPopup(int var1, int var2) throws MethodException;

    public void cancelTADPopup(int var1, int var2) throws MethodException;

    public void setTADSetFactoryDefault() throws MethodException;

    public void setTADMaxMinAngleReset(TADMaxMinAngleReset var1) throws MethodException;

    public void setHMIIsReady(boolean var1) throws MethodException;

    public void setSpoilerSetFactoryDefault() throws MethodException;

    public void setSpoilerPositionSelection(int var1) throws MethodException;

    public void setSpoilerActuation(boolean var1) throws MethodException;

    public void setSpoilerSystemOnOff(boolean var1) throws MethodException;

    public void setSoundSetFactoryDefault() throws MethodException;

    public void setSoundStyle(int var1) throws MethodException;

    public void setSoundSystemOnOff(boolean var1) throws MethodException;

    public void setSoundOnOff(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

