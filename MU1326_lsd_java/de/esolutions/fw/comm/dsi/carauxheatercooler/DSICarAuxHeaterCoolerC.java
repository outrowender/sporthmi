/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carauxheatercooler;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;

public interface DSICarAuxHeaterCoolerC {
    public void setAuxHeaterCoolerOnOff(boolean var1) throws MethodException;

    public void setAuxHeaterCoolerRunningTime(short var1) throws MethodException;

    public void setAuxHeaterCoolerMode(int var1) throws MethodException;

    public void setAuxHeaterCoolerDefaultStartMode(int var1) throws MethodException;

    public void setAuxHeaterCoolerEngineHeater(boolean var1) throws MethodException;

    public void setAuxHeaterCoolerActiveTimer(int var1) throws MethodException;

    public void setAuxHeaterCoolerTimer1(AuxHeaterCoolerTimer var1) throws MethodException;

    public void setAuxHeaterCoolerTimer2(AuxHeaterCoolerTimer var1) throws MethodException;

    public void setAuxHeaterCoolerTimer3(AuxHeaterCoolerTimer var1) throws MethodException;

    public void setAuxHeaterCoolerPopup(int var1) throws MethodException;

    public void setAuxHeaterSetFactoryDefault() throws MethodException;

    public void setAuxHeaterCoolerExtendedConditioning(AuxHeaterCoolerExtendedConditioning var1) throws MethodException;

    public void setAuxHeaterCoolerWindowHeating(boolean var1) throws MethodException;

    public void setAuxHeaterCoolerUnlockClimating(int var1) throws MethodException;

    public void setAuxHeaterCoolerTargetTemperature(float var1) throws MethodException;

    public void setAuxHeaterCoolerAirQuality(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

