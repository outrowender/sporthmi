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
    default public void registerAppSystem(IAppSystem iAppSystem) {
    }

    default public IAppSystem getVariantAppSystem() {
    }

    default public Coding getDiagnosisCOD() {
    }

    default public Adaptation getAdaptationANP() {
    }

    default public LoadSpeedThreshold getSpeedThresholdUPDL() {
    }

    default public CarFuncAdap getCarFuncAdaptation() {
    }

    default public void storeSysConstsForSWDLReboot() {
    }

    default public boolean isRebootToSwdl() {
    }

    default public boolean isEngineeringDownloadActive() {
    }

    default public boolean isCustomerDownloadActive() {
    }

    default public void setEngineeringDownloadActive(boolean bl) {
    }

    default public void setCustomerDownloadActive(boolean bl) {
    }

    default public long getAdjustedTime() {
    }

    default public boolean isClockAdjusted() {
    }

    default public void adjustClock(Date date) {
    }

    default public MetricsModelApp getClock() {
    }

    default public void registerSpeedThresholdListener(SpeedThresholdListener speedThresholdListener, int n) {
    }

    default public void registerStandStillListener(IStandStillListener iStandStillListener) {
    }

    default public void unregisterStandStillListener(IStandStillListener iStandStillListener) {
    }

    default public void unregisterSpeedThresholdListener(SpeedThresholdListener speedThresholdListener) {
    }

    default public boolean isStandstill() {
    }
}

