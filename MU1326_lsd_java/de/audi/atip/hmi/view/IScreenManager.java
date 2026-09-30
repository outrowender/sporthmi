/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.EventDispatcherAdmin;
import de.audi.atip.hmi.view.IModelConnectService;
import de.audi.atip.hmi.view.IScreenChangeManager;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.ITerminalContext;
import de.audi.atip.hmi.view.Screen;
import java.io.PrintStream;

public interface IScreenManager {
    public static final boolean IS_ANIMATED_SCREEN_CHANGE = true;
    public static final boolean ALWAYS_DISCONNECT_ON_SCREEN_CHANGE = true;

    public int getCurrentScreenId();

    public Screen getCurrentConnectedScreen();

    public void lockCurrentConnectedScreen(boolean var1);

    public void showScreen(IScreenData var1);

    public void setFallbackScreen(Screen var1);

    public IScreenData getFallbackScreenData();

    public boolean isScreenAvailable();

    public Screen getScreen(IScreenData var1);

    public void dump(PrintStream var1, String var2);

    public IModelConnectService getModelConnectService();

    public void refresh();

    public IScreenData getCurrentConnectedScreenData();

    public IScreenData getPreviousConnectedScreenData();

    public IScreenData getCurrentScreenData();

    public void showPartialPopups(int var1, int[] var2);

    public void removePartialPopups(int var1, int[] var2);

    public boolean isScreenChangeAnimationRunning(int var1);

    public IScreenChangeManager getScreenChangeUnit();

    public void setScreenChangeUnit(IScreenChangeManager var1);

    public ITerminalContext getTerminalContext();

    public boolean isCurrentConnectedScreen(int var1);

    public IScreenData getTargetScreenData();

    public void clearPendingScreenChange();

    public void setPendingScreenChange(IScreenData var1);

    public int getPendingScreenId();

    public Screen getPendingScreen();

    public IScreenData getPendingScreenData();

    public boolean isClusterAnScreenHidden(Screen var1);

    public void clearCurrentConnectedScreenData();

    public void setCurrentConnectedScreenData(IScreenData var1);

    public void setCurrentScreenData(IScreenData var1);

    public boolean isCurrentScreen(int var1);

    public boolean isScreenChangePending();

    public void logToInfotainmentRecorder(int var1);

    public int getCurrentConnectedScreenId();

    public boolean isCluster();

    public EventDispatcherAdmin getEventDispatcherAdmin();

    public IFrameworkAccess getFramework();

    public boolean removePartialPopupFromScreenData(int var1, int var2);
}

