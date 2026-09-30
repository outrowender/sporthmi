/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconFreshAirConfiguration;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public interface DSICarAirConditionC {
    public void setAirconAirCirculationMan(boolean var1) throws MethodException;

    public void setAirconAirCirculationAuto(boolean var1) throws MethodException;

    public void setAirconMiddleExhaustion(int var1) throws MethodException;

    public void setAirconRearWindowHeater(boolean var1) throws MethodException;

    public void setAirconIndirectVentilation(boolean var1) throws MethodException;

    public void setAirconPopupTime(int var1) throws MethodException;

    public void setAirconHeater(boolean var1) throws MethodException;

    public void setAirconRearAuxHeater(boolean var1) throws MethodException;

    public void setAirconFrontWindowHeater(boolean var1) throws MethodException;

    public void setAirconDefrost(boolean var1) throws MethodException;

    public void setAirconMaxDefrost(boolean var1) throws MethodException;

    public void setAirconSolar(boolean var1) throws MethodException;

    public void setAirconAC(boolean var1) throws MethodException;

    public void setAirconMaxAC(boolean var1) throws MethodException;

    public void setAirconEcoAC(boolean var1) throws MethodException;

    public void setAirconRearControl(boolean var1) throws MethodException;

    public void setAirconRearControlFondPlus(boolean var1) throws MethodException;

    public void setAirconSteeringWheelHeater(AirconSteeringWheelHeater var1) throws MethodException;

    public void setAirconFrontWindowHeaterAuto(boolean var1) throws MethodException;

    public void setAirconBlowerCompensation(AirconBlowerCompensation var1) throws MethodException;

    public void setAirconSynchronisation(AirconSynchronisation var1) throws MethodException;

    public void setAirconSuppressVisualisation(boolean var1) throws MethodException;

    public void setAirconSystemOnOffRow(int var1, boolean var2) throws MethodException;

    public void setAirconAirCirculationSensitivity(int var1) throws MethodException;

    public void setAirconResidualHeat(boolean var1) throws MethodException;

    public void showAirconPopup(AirconContent var1) throws MethodException;

    public void cancelAirconPopup(AirconContent var1, int var2) throws MethodException;

    public void setAirconContent(AirconContent var1) throws MethodException;

    public void setAirconTempZone(int var1, AirconTemp var2) throws MethodException;

    public void setAirconAirVolume(int var1, AirconAirVolume var2) throws MethodException;

    public void setAirconAirDistribution(int var1, AirconAirDistribution var2) throws MethodException;

    public void setAirconFootwellTemp(int var1, int var2) throws MethodException;

    public void setAirconSeatHeater(int var1, int var2, int var3) throws MethodException;

    public void setAirconSeatVentilation(int var1, int var2, int var3) throws MethodException;

    public void setAirconHMIIsReady(boolean var1) throws MethodException;

    public void setAirconSeatHeaterDistribution(int var1, int var2) throws MethodException;

    public void setAirconSeatVentilationDistribution(int var1, int var2) throws MethodException;

    public void setAirconTempStep(int var1, int var2) throws MethodException;

    public void setAirconClimateStyle(int var1, int var2) throws MethodException;

    public void setAirconSetFactoryDefaultMaster() throws MethodException;

    public void setAirconSetFactoryDefaultRow(int var1) throws MethodException;

    public void setAirconNozzleControlRow1(int var1) throws MethodException;

    public void setAirconNozzleControlRow2(int var1) throws MethodException;

    public void setAirconNozzleControlRow3(int var1) throws MethodException;

    public void requestAirconNozzleListRow(int var1, CarArrayListUpdateInfo var2) throws MethodException;

    public void setAirconNozzleListRow(int var1, CarArrayListUpdateInfo var2, AirconNozzleListRecord[] var3) throws MethodException;

    public void setAirconSideWindowDefrost(boolean var1) throws MethodException;

    public void setAirconPureAir(AirconPureAirSetup var1) throws MethodException;

    public void setAirconFreshAirConfig(AirconFreshAirConfiguration var1) throws MethodException;

    public void setAirconAirQuality(int var1, int var2) throws MethodException;

    public void setAirconSeatNeckHeater(int var1, boolean var2, int var3) throws MethodException;

    public void setAirconSeatSurfaceHeater(int var1, boolean var2, boolean var3, int var4) throws MethodException;

    public void setAirconIndividualClimatisation(int var1, boolean var2) throws MethodException;

    public void setAirconIonisator(int var1, int var2) throws MethodException;

    public void setAirconBodyCloseMeasures(int var1, boolean var2, AirconBCMeasuresConfiguration var3) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

