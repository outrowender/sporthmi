/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.comfort;

import org.dsi.ifc.carcomfort.DoorLockingConfiguration;
import org.dsi.ifc.carcomfort.DoorLockingViewOptions;
import org.dsi.ifc.global.CarViewOption;

public interface IDoorLockingViewOptions {
    public static final CarViewOption defVO = new CarViewOption(1, 1);

    public CarViewOption getMessage();

    public CarViewOption getLockStatus();

    public CarViewOption getWindowStatus();

    public CarViewOption getUnlockingMode();

    public CarViewOption getAutoLock();

    public CarViewOption getClBootLock();

    public CarViewOption getMirrorProtection();

    public CarViewOption getLockingConfirmation();

    public CarViewOption getComfortOpen();

    public CarViewOption getComfortOpenFrontDoors();

    public CarViewOption getComfortOpenRearDoors();

    public CarViewOption getComfortOpenSunRoof();

    public CarViewOption getComfortOpenRearBlind();

    public CarViewOption getRainClosing();

    public CarViewOption getRearBlind();

    public CarViewOption getTheftWarning();

    public CarViewOption getAutoUnlock();

    public CarViewOption getDoorLockingSetFactoryDefault();

    public DoorLockingConfiguration getConfiguration();

    public String toString();

    public void setLockStatus(CarViewOption var1);

    public void setWindowStatus(CarViewOption var1);

    public void setUnlockingMode(CarViewOption var1);

    public void setAutoLock(CarViewOption var1);

    public void setMirrorProtection(CarViewOption var1);

    public void setBootLock(CarViewOption var1);

    public void setLockingConfirmation(CarViewOption var1);

    public void setComfortOpenFrontDoors(CarViewOption var1);

    public void setComfortOpenRearDoors(CarViewOption var1);

    public void setComfortOpenSunRoof(CarViewOption var1);

    public void setComfortOpenRearBlind(CarViewOption var1);

    public void setRainClosing(CarViewOption var1);

    public void setRearBlind(CarViewOption var1);

    public void setTheftWarning(CarViewOption var1);

    public void setAutoUnlock(CarViewOption var1);

    public void setDoorLockingSetFactoryDefault(CarViewOption var1);

    public void setBootOpen(CarViewOption var1);

    public void setMessage(CarViewOption var1);

    public void setAutoBootOpen(CarViewOption var1);

    public void setConfiguration(DoorLockingConfiguration var1);

    public void copy(DoorLockingViewOptions var1);
}

