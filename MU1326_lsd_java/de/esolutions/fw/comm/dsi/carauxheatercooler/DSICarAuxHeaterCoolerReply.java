/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carauxheatercooler;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerErrorReason;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerMode;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerViewOptions;
import org.dsi.ifc.global.CarBCTemperature;

public interface DSICarAuxHeaterCoolerReply {
    public static final String IPL_COMM_UUID = "2c84d2cf-fe11-563b-afb2-bf49ce13acf7";
    public static final String IPL_COMM_INTERFACE_KEY = "1145f0e8-59ff-5294-8be0-cf7da5c0d921";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.11";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.11";

    public void updateAuxHeaterCoolerViewOptions(AuxHeaterCoolerViewOptions var1, int var2) throws MethodException;

    public void updateAuxHeaterCoolerCurrentHeaterState(AuxHeaterCoolerErrorReason var1, int var2) throws MethodException;

    public void updateAuxHeaterCoolerErrorReason(AuxHeaterCoolerErrorReason var1, int var2) throws MethodException;

    public void updateAuxHeaterCoolerState(int var1, int var2) throws MethodException;

    public void updateAuxHeaterCoolerOnOff(boolean var1, int var2) throws MethodException;

    public void updateAuxHeaterCoolerRemainingTime(short var1, int var2) throws MethodException;

    public void updateAuxHeaterCoolerRunningTime(short var1, int var2) throws MethodException;

    public void updateAuxHeaterCoolerMode(int var1, int var2) throws MethodException;

    public void updateAuxHeaterCoolerDefaultStartMode(int var1, int var2) throws MethodException;

    public void updateAuxHeaterCoolerEngineHeater(boolean var1, int var2) throws MethodException;

    public void updateAuxHeaterCoolerActiveTimer(int var1, int var2) throws MethodException;

    public void updateAuxHeaterCoolerTimer1(AuxHeaterCoolerTimer var1, int var2) throws MethodException;

    public void updateAuxHeaterCoolerTimer2(AuxHeaterCoolerTimer var1, int var2) throws MethodException;

    public void updateAuxHeaterCoolerTimer3(AuxHeaterCoolerTimer var1, int var2) throws MethodException;

    public void acknowledgeAuxHeaterSetFactoryDefault(boolean var1) throws MethodException;

    public void updateAuxHeaterCoolerPopup(int var1, int var2) throws MethodException;

    public void updateAuxHeaterCoolerMode2(AuxHeaterCoolerMode var1, int var2) throws MethodException;

    public void updateAuxHeaterCoolerExtendedConditioning(AuxHeaterCoolerExtendedConditioning var1, AuxHeaterCoolerExtendedConditioning var2, int var3) throws MethodException;

    public void updateAuxHeaterCoolerWindowHeating(boolean var1, boolean var2, int var3) throws MethodException;

    public void updateAuxHeaterCoolerUnlockClimating(int var1, int var2) throws MethodException;

    public void updateAuxHeaterCoolerTargetTemperature(CarBCTemperature var1, int var2) throws MethodException;

    public void updateAuxHeaterCoolerAirQuality(boolean var1, boolean var2, int var3) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

