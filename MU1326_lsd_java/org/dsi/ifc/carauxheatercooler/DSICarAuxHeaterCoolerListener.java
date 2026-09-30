/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carauxheatercooler;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerErrorReason;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerMode;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerViewOptions;
import org.dsi.ifc.global.CarBCTemperature;

public interface DSICarAuxHeaterCoolerListener
extends DSIListener {
    public void updateAuxHeaterCoolerViewOptions(AuxHeaterCoolerViewOptions var1, int var2);

    public void updateAuxHeaterCoolerCurrentHeaterState(AuxHeaterCoolerErrorReason var1, int var2);

    public void updateAuxHeaterCoolerErrorReason(AuxHeaterCoolerErrorReason var1, int var2);

    public void updateAuxHeaterCoolerState(int var1, int var2);

    public void updateAuxHeaterCoolerOnOff(boolean var1, int var2);

    public void updateAuxHeaterCoolerRemainingTime(short var1, int var2);

    public void updateAuxHeaterCoolerRunningTime(short var1, int var2);

    public void updateAuxHeaterCoolerMode(int var1, int var2);

    public void updateAuxHeaterCoolerDefaultStartMode(int var1, int var2);

    public void updateAuxHeaterCoolerEngineHeater(boolean var1, int var2);

    public void updateAuxHeaterCoolerActiveTimer(int var1, int var2);

    public void updateAuxHeaterCoolerTimer1(AuxHeaterCoolerTimer var1, int var2);

    public void updateAuxHeaterCoolerTimer2(AuxHeaterCoolerTimer var1, int var2);

    public void updateAuxHeaterCoolerTimer3(AuxHeaterCoolerTimer var1, int var2);

    public void acknowledgeAuxHeaterSetFactoryDefault(boolean var1);

    public void updateAuxHeaterCoolerPopup(int var1, int var2);

    public void updateAuxHeaterCoolerMode2(AuxHeaterCoolerMode var1, int var2);

    public void updateAuxHeaterCoolerExtendedConditioning(AuxHeaterCoolerExtendedConditioning var1, AuxHeaterCoolerExtendedConditioning var2, int var3);

    public void updateAuxHeaterCoolerWindowHeating(boolean var1, boolean var2, int var3);

    public void updateAuxHeaterCoolerUnlockClimating(int var1, int var2);

    public void updateAuxHeaterCoolerTargetTemperature(CarBCTemperature var1, int var2);

    public void updateAuxHeaterCoolerAirQuality(boolean var1, boolean var2, int var3);
}

