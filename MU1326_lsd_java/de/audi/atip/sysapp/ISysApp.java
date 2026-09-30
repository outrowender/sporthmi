/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp;

import de.audi.atip.base.IAppSystem;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.sysapp.IStandStillListener;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.atip.sysapp.carcoding.Adaptation;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import de.audi.atip.sysapp.carcoding.Coding;
import de.audi.atip.sysapp.carcoding.LoadSpeedThreshold;
import java.util.Date;

public interface ISysApp {
    public void registerAppSystem(IAppSystem var1);

    public IAppSystem getVariantAppSystem();

    public Coding getDiagnosisCOD();

    public Adaptation getAdaptationANP();

    public LoadSpeedThreshold getSpeedThresholdUPDL();

    public CarFuncAdap getCarFuncAdaptation();

    public void storeSysConstsForSWDLReboot();

    public boolean isRebootToSwdl();

    public boolean isEngineeringDownloadActive();

    public boolean isCustomerDownloadActive();

    public void setEngineeringDownloadActive(boolean var1);

    public void setCustomerDownloadActive(boolean var1);

    public long getAdjustedTime();

    public boolean isClockAdjusted();

    public void adjustClock(Date var1);

    public MetricsModelApp getClock();

    public void registerSpeedThresholdListener(SpeedThresholdListener var1, int var2);

    public void registerStandStillListener(IStandStillListener var1);

    public void unregisterStandStillListener(IStandStillListener var1);

    public void unregisterSpeedThresholdListener(SpeedThresholdListener var1);

    public boolean isStandstill();
}

