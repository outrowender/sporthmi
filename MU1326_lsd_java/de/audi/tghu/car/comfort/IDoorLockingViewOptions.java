/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.comfort;

import org.dsi.ifc.carcomfort.DoorLockingConfiguration;
import org.dsi.ifc.carcomfort.DoorLockingViewOptions;
import org.dsi.ifc.global.CarViewOption;

public interface IDoorLockingViewOptions {
    public static final CarViewOption defVO = new CarViewOption(1, 1);

    default public CarViewOption getMessage() {
    }

    default public CarViewOption getLockStatus() {
    }

    default public CarViewOption getWindowStatus() {
    }

    default public CarViewOption getUnlockingMode() {
    }

    default public CarViewOption getAutoLock() {
    }

    default public CarViewOption getClBootLock() {
    }

    default public CarViewOption getMirrorProtection() {
    }

    default public CarViewOption getLockingConfirmation() {
    }

    default public CarViewOption getComfortOpen() {
    }

    default public CarViewOption getComfortOpenFrontDoors() {
    }

    default public CarViewOption getComfortOpenRearDoors() {
    }

    default public CarViewOption getComfortOpenSunRoof() {
    }

    default public CarViewOption getComfortOpenRearBlind() {
    }

    default public CarViewOption getRainClosing() {
    }

    default public CarViewOption getRearBlind() {
    }

    default public CarViewOption getTheftWarning() {
    }

    default public CarViewOption getAutoUnlock() {
    }

    default public CarViewOption getDoorLockingSetFactoryDefault() {
    }

    default public DoorLockingConfiguration getConfiguration() {
    }

    default public String toString() {
    }

    default public void setLockStatus(CarViewOption carViewOption) {
    }

    default public void setWindowStatus(CarViewOption carViewOption) {
    }

    default public void setUnlockingMode(CarViewOption carViewOption) {
    }

    default public void setAutoLock(CarViewOption carViewOption) {
    }

    default public void setMirrorProtection(CarViewOption carViewOption) {
    }

    default public void setBootLock(CarViewOption carViewOption) {
    }

    default public void setLockingConfirmation(CarViewOption carViewOption) {
    }

    default public void setComfortOpenFrontDoors(CarViewOption carViewOption) {
    }

    default public void setComfortOpenRearDoors(CarViewOption carViewOption) {
    }

    default public void setComfortOpenSunRoof(CarViewOption carViewOption) {
    }

    default public void setComfortOpenRearBlind(CarViewOption carViewOption) {
    }

    default public void setRainClosing(CarViewOption carViewOption) {
    }

    default public void setRearBlind(CarViewOption carViewOption) {
    }

    default public void setTheftWarning(CarViewOption carViewOption) {
    }

    default public void setAutoUnlock(CarViewOption carViewOption) {
    }

    default public void setDoorLockingSetFactoryDefault(CarViewOption carViewOption) {
    }

    default public void setBootOpen(CarViewOption carViewOption) {
    }

    default public void setMessage(CarViewOption carViewOption) {
    }

    default public void setAutoBootOpen(CarViewOption carViewOption) {
    }

    default public void setConfiguration(DoorLockingConfiguration doorLockingConfiguration) {
    }

    default public void copy(DoorLockingViewOptions doorLockingViewOptions) {
    }
}

