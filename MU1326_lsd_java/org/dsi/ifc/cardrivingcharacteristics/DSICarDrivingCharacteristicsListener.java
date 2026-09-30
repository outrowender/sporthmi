/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

import org.dsi.ifc.base.DSIListener;
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

public interface DSICarDrivingCharacteristicsListener
extends DSIListener {
    public void updateSuspensionControlViewOptions(SuspensionControlViewOptions var1, int var2);

    public void updateSuspensionControlLiftMode(boolean var1, int var2);

    public void updateSuspensionControlCarJackMode(boolean var1, int var2);

    public void updateSuspensionControlTrailerMode(boolean var1, int var2);

    public void updateSuspensionControlLoadingMode(boolean var1, int var2);

    public void updateSuspensionControlActiveProfile(int var1, int var2);

    public void updateSuspensionControlAccessibleAirProfiles(SuspensionControlAirProfiles var1, int var2);

    public void updateSuspensionControlAccessibleDRCProfiles(SuspensionControlDRCProfiles var1, int var2);

    public void updateSuspensionControlVehicleStatus(int var1, int var2);

    public void updateSuspensionControlCurrentLevel(int var1, int var2);

    public void updateSuspensionControlTargetLevel(int var1, int var2);

    public void updateSuspensionControlHeightInfo(SuspensionControlHeightInfo var1, int var2);

    public void updateSuspensionControlOperationMessages(SuspensionControlOperationMessages var1, int var2);

    public void updateSuspensionControlSnowChainMode(boolean var1, int var2);

    public void updateSuspensionControlVehicleStateControl(boolean var1, int var2);

    public void updateSuspensionControlActiveMode(int var1, boolean var2, int var3);

    public void updateeABCEasyEntry(boolean var1, int var2);

    public void updateeABCPitchControl(boolean var1, int var2);

    public void updateeABCSpecialPosition(boolean var1, int var2);

    public void updateeABCPreview(int var1, int var2);

    public void updateeABCPreviewState(SuspensionControleABCPreview var1, int var2);

    public void updateSuspensionControlActuatorInfo(SuspensionControlActuatorInfo var1, int var2);

    public void updateCharismaViewOptions(CharismaViewOptions var1, int var2);

    public void updateCharismaActiveProfile(int var1, int var2);

    public void updateCharismaActiveOperationMode(int var1, int var2);

    public void updateCharismaListUpdateInfo(CharismaListUpdateInfo var1, int var2);

    public void updateCharismaContent(int var1, int var2);

    public void updateCharismaTrailerDetection(boolean var1, int var2);

    public void updateCharismaTrailerSetting(boolean var1, int var2);

    public void updateCharismaProgButton(CharismaProgButton var1, int var2);

    public void responseCharismaListWithOptionMask(int var1, int var2, int var3, CharismaSetupTableWithOptionMask[] var4);

    public void responseCharismaListWithoutOptionMask(int var1, int var2, int var3, CharismaSetupTableWithoutOptionMask[] var4);

    public void requestCharismaPopup(int var1);

    public void acknowledgeCharismaPopup(int var1);

    public void acknowledgeCharismaSetFactoryDefault(boolean var1);

    public void updateCharismaSound(boolean var1, int var2);

    public void updateTADViewOptions(TADViewOptions var1, int var2);

    public void updateTADContent(int var1, int var2);

    public void requestTADPopup(int var1);

    public void acknowledgeTADPopup(int var1);

    public void acknowledgeTADSetFactoryDefault(boolean var1);

    public void acknowledgeTADMaxMinAngleReset(boolean var1);

    public void updateTADVehicleInfo(TADVehicleInfo var1, int var2);

    public void updateTADCurrentRollAngle(float var1, int var2);

    public void updateTADCurrentPitchAngle(float var1, int var2);

    public void updateTADPosMaxRollAngle(float var1, int var2);

    public void updateTADNegMaxRollAngle(float var1, int var2);

    public void updateTADPosMaxPitchAngle(float var1, int var2);

    public void updateTADNegMaxPitchAngle(float var1, int var2);

    public void updateSpoilerViewOptions(SpoilerViewOptions var1, int var2);

    public void updateSpoilerPositionSelection(int var1, int var2);

    public void updateSpoilerState(SpoilerState var1, int var2);

    public void updateSpoilerActuation(boolean var1, int var2);

    public void updateSpoilerMessages(int var1, int var2);

    public void updateSpoilerSystemOnOff(boolean var1, int var2);

    public void acknowledgeSpoilerSetFactoryDefault(boolean var1);

    public void updateSoundViewOptions(SoundViewOptions var1, int var2);

    public void updateSoundStyle(int var1, int var2);

    public void updateSoundSystemOnOff(boolean var1, int var2);

    public void updateSoundOnOff(boolean var1, int var2);

    public void acknowledgeSoundSetFactoryDefault(boolean var1);
}

