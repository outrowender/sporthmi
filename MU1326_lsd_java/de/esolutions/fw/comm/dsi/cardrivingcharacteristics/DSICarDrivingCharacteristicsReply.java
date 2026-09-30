/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SoundViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerState;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlActuatorInfo;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAirProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlDRCProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlHeightInfo;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlOperationMessages;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControleABCPreview;
import org.dsi.ifc.cardrivingcharacteristics.TADVehicleInfo;
import org.dsi.ifc.cardrivingcharacteristics.TADViewOptions;

public interface DSICarDrivingCharacteristicsReply {
    public static final String IPL_COMM_UUID = "d04dc275-b36e-5ae6-935e-37ff4b68bfa3";
    public static final String IPL_COMM_INTERFACE_KEY = "8130d570-107f-5bbf-b44d-3d2d3cf5bed8";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.21";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.21";

    public void updateSuspensionControlViewOptions(SuspensionControlViewOptions var1, int var2) throws MethodException;

    public void updateSuspensionControlLiftMode(boolean var1, int var2) throws MethodException;

    public void updateSuspensionControlCarJackMode(boolean var1, int var2) throws MethodException;

    public void updateSuspensionControlTrailerMode(boolean var1, int var2) throws MethodException;

    public void updateSuspensionControlLoadingMode(boolean var1, int var2) throws MethodException;

    public void updateSuspensionControlActiveProfile(int var1, int var2) throws MethodException;

    public void updateSuspensionControlAccessibleAirProfiles(SuspensionControlAirProfiles var1, int var2) throws MethodException;

    public void updateSuspensionControlAccessibleDRCProfiles(SuspensionControlDRCProfiles var1, int var2) throws MethodException;

    public void updateSuspensionControlVehicleStatus(int var1, int var2) throws MethodException;

    public void updateSuspensionControlCurrentLevel(int var1, int var2) throws MethodException;

    public void updateSuspensionControlTargetLevel(int var1, int var2) throws MethodException;

    public void updateSuspensionControlHeightInfo(SuspensionControlHeightInfo var1, int var2) throws MethodException;

    public void updateSuspensionControlOperationMessages(SuspensionControlOperationMessages var1, int var2) throws MethodException;

    public void updateSuspensionControlSnowChainMode(boolean var1, int var2) throws MethodException;

    public void updateSuspensionControlVehicleStateControl(boolean var1, int var2) throws MethodException;

    public void updateSuspensionControlActiveMode(int var1, boolean var2, int var3) throws MethodException;

    public void updateeABCEasyEntry(boolean var1, int var2) throws MethodException;

    public void updateeABCPitchControl(boolean var1, int var2) throws MethodException;

    public void updateeABCSpecialPosition(boolean var1, int var2) throws MethodException;

    public void updateeABCPreview(int var1, int var2) throws MethodException;

    public void updateeABCPreviewState(SuspensionControleABCPreview var1, int var2) throws MethodException;

    public void updateSuspensionControlActuatorInfo(SuspensionControlActuatorInfo var1, int var2) throws MethodException;

    public void updateCharismaViewOptions(CharismaViewOptions var1, int var2) throws MethodException;

    public void updateCharismaActiveProfile(int var1, int var2) throws MethodException;

    public void updateCharismaActiveOperationMode(int var1, int var2) throws MethodException;

    public void updateCharismaListUpdateInfo(CharismaListUpdateInfo var1, int var2) throws MethodException;

    public void updateCharismaContent(int var1, int var2) throws MethodException;

    public void updateCharismaTrailerDetection(boolean var1, int var2) throws MethodException;

    public void updateCharismaTrailerSetting(boolean var1, int var2) throws MethodException;

    public void updateCharismaProgButton(CharismaProgButton var1, int var2) throws MethodException;

    public void responseCharismaListWithOptionMask(int var1, int var2, int var3, CharismaSetupTableWithOptionMask[] var4) throws MethodException;

    public void responseCharismaListWithoutOptionMask(int var1, int var2, int var3, CharismaSetupTableWithoutOptionMask[] var4) throws MethodException;

    public void requestCharismaPopup(int var1) throws MethodException;

    public void acknowledgeCharismaPopup(int var1) throws MethodException;

    public void acknowledgeCharismaSetFactoryDefault(boolean var1) throws MethodException;

    public void updateCharismaSound(boolean var1, int var2) throws MethodException;

    public void updateTADViewOptions(TADViewOptions var1, int var2) throws MethodException;

    public void updateTADContent(int var1, int var2) throws MethodException;

    public void requestTADPopup(int var1) throws MethodException;

    public void acknowledgeTADPopup(int var1) throws MethodException;

    public void acknowledgeTADSetFactoryDefault(boolean var1) throws MethodException;

    public void acknowledgeTADMaxMinAngleReset(boolean var1) throws MethodException;

    public void updateTADVehicleInfo(TADVehicleInfo var1, int var2) throws MethodException;

    public void updateTADCurrentRollAngle(float var1, int var2) throws MethodException;

    public void updateTADCurrentPitchAngle(float var1, int var2) throws MethodException;

    public void updateTADPosMaxRollAngle(float var1, int var2) throws MethodException;

    public void updateTADNegMaxRollAngle(float var1, int var2) throws MethodException;

    public void updateTADPosMaxPitchAngle(float var1, int var2) throws MethodException;

    public void updateTADNegMaxPitchAngle(float var1, int var2) throws MethodException;

    public void updateSpoilerViewOptions(SpoilerViewOptions var1, int var2) throws MethodException;

    public void updateSpoilerPositionSelection(int var1, int var2) throws MethodException;

    public void updateSpoilerState(SpoilerState var1, int var2) throws MethodException;

    public void updateSpoilerActuation(boolean var1, int var2) throws MethodException;

    public void updateSpoilerMessages(int var1, int var2) throws MethodException;

    public void updateSpoilerSystemOnOff(boolean var1, int var2) throws MethodException;

    public void acknowledgeSpoilerSetFactoryDefault(boolean var1) throws MethodException;

    public void updateSoundViewOptions(SoundViewOptions var1, int var2) throws MethodException;

    public void updateSoundStyle(int var1, int var2) throws MethodException;

    public void updateSoundSystemOnOff(boolean var1, int var2) throws MethodException;

    public void updateSoundOnOff(boolean var1, int var2) throws MethodException;

    public void acknowledgeSoundSetFactoryDefault(boolean var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

