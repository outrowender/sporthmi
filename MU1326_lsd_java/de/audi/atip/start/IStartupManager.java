/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.start;

import de.audi.atip.log.LogChannel;
import de.audi.atip.start.ILastmodeHandler;
import java.util.List;

public interface IStartupManager {
    public boolean isRebootToDownload();

    public void setNavEnabled(boolean var1);

    public boolean isNavEnabled();

    public void triggerNavAvailable();

    public void triggerMapAvailable();

    public void triggerTTSAvailable();

    public void triggerNewScreenVisible();

    public boolean waitForTTSAvailable();

    public boolean waitForFirstScreen();

    public boolean waitForKombiSync();

    public void setRVCActive(boolean var1);

    public void logStartupEvent(String var1);

    public void logStartupEvent(LogChannel var1, int var2, String var3);

    public void logStartupEvent(LogChannel var1, int var2, String var3, Throwable var4);

    public void processHKsDuringStartup(boolean var1);

    public void setMMIKombiLastmode(int var1);

    public void requestAppStart(int var1);

    public void requestAppStartByHMIKey(int var1);

    public void requestStartBundle(String var1);

    public void startSwDiag();

    public boolean isStartupCompleted();

    public boolean isSMRunning();

    public void setFallBackScreenShown(boolean var1);

    public void initDSI();

    public void initSystem();

    public void initHMI();

    public void initModelBanks();

    public void showFirstScreen();

    public void postStartup();

    public ILastmodeHandler getLastmodeHandler();

    public void addInitialEvents(List var1);

    public void resourcesReady(int var1);
}

