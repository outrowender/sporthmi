/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.dsi;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;
import org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler;

public class NullDSICarAuxheaterCooler
implements DSICarAuxHeaterCooler {
    private final LogChannel logChan;

    public NullDSICarAuxheaterCooler(LogChannel logChannel) {
        this.logChan = logChannel;
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void setNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void clearNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void setAuxHeaterCoolerOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void setAuxHeaterCoolerRunningTime(short s) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void setAuxHeaterCoolerMode(int n) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void setAuxHeaterCoolerDefaultStartMode(int n) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void setAuxHeaterCoolerEngineHeater(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void setAuxHeaterCoolerActiveTimer(int n) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void setAuxHeaterCoolerTimer1(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void setAuxHeaterCoolerTimer2(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void setAuxHeaterCoolerTimer3(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void setAuxHeaterSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void setAuxHeaterCoolerPopup(int n) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void setAuxHeaterCoolerExtendedConditioning(AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void setAuxHeaterCoolerWindowHeating(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void setAuxHeaterCoolerUnlockClimating(int n) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void setAuxHeaterCoolerTargetTemperature(float f2) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }

    public void setAuxHeaterCoolerAirQuality(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarAuxheaterCooler");
    }
}

