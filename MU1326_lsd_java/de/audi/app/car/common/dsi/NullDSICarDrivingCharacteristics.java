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

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setSuspensionControlLiftMode(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setSuspensionControlCarJackMode(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setSuspensionControlTrailerMode(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setSuspensionControlLoadingMode(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setSuspensionControlActiveProfile(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setCharismaActiveProfile(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setCharismaActiveOperationMode(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setCharismaTrailerSetting(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setCharismaProgButton(CharismaProgButton charismaProgButton) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void requestCharismaProfileFunction(int n, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void requestCharismaList(CharismaListUpdateInfo charismaListUpdateInfo) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void showCharismaPopup(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void cancelCharismaPopup(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    public void setFpaSetFactoryDefault(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setCharismaSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void showTADPopup(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void cancelTADPopup(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setTADSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setTADMaxMinAngleReset(TADMaxMinAngleReset tADMaxMinAngleReset) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setHMIIsReady(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setSuspensionControlSnowChainMode(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setSpoilerSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setSpoilerPositionSelection(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setSpoilerActuation(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setSpoilerSystemOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setSuspensionControlActiveMode(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void seteABCEasyEntry(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void seteABCPitchControl(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void seteABCSpecialPosition(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void seteABCPreview(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setCharismaSound(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setSoundSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setSoundStyle(int n) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setSoundSystemOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }

    @Override
    public void setSoundOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarDrivingCharacteristics");
    }
}

