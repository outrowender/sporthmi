/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.dsi;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics;
import org.dsi.ifc.cardrivingcharacteristics.TADMaxMinAngleReset;

public class NullDSICarDrivingCharacteristics
implements DSICarDrivingCharacteristics {
    private final LogChannel logChan;

    public NullDSICarDrivingCharacteristics(LogChannel logChannel) {
        this.logChan = logChannel;
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void clearNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setSuspensionControlLiftMode(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setSuspensionControlCarJackMode(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setSuspensionControlTrailerMode(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setSuspensionControlLoadingMode(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setSuspensionControlActiveProfile(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setCharismaActiveProfile(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setCharismaActiveOperationMode(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setCharismaTrailerSetting(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setCharismaProgButton(CharismaProgButton charismaProgButton) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void requestCharismaProfileFunction(int n, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void requestCharismaList(CharismaListUpdateInfo charismaListUpdateInfo) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void showCharismaPopup(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void cancelCharismaPopup(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setFpaSetFactoryDefault(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setCharismaSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void showTADPopup(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void cancelTADPopup(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setTADSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setTADMaxMinAngleReset(TADMaxMinAngleReset tADMaxMinAngleReset) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setHMIIsReady(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setSuspensionControlSnowChainMode(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setSpoilerSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setSpoilerPositionSelection(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setSpoilerActuation(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setSpoilerSystemOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setSuspensionControlActiveMode(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void seteABCEasyEntry(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void seteABCPitchControl(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void seteABCSpecialPosition(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void seteABCPreview(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setCharismaSound(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setSoundSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setSoundStyle(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setSoundSystemOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setSoundOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }
}

