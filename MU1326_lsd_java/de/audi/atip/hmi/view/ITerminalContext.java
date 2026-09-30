/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.IRootWindow;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.atip.hmi.view.IPopupManager;
import de.audi.atip.hmi.view.IScreenManager;
import de.audi.atip.hmi.view.Screen;
import java.io.PrintStream;

public interface ITerminalContext {
    public ITerminalContext getSubterminal(int var1);

    public IScreenManager getScreenManager();

    public IPopupManager getPopupManager();

    public IPartialPopupManager getPartialPopupManager();

    public IRootWindow getRootWindow();

    public HMIModel getModel(int var1);

    public Object getImageImpl(int var1, boolean var2, int var3, int var4);

    public void initialize(HMIService var1);

    public HMIService getHMIService();

    public boolean isCluster();

    public int getTerminalID();

    public IFrameworkAccess getFramework();

    public HMITerminal getHmiTerminal();

    public Screen getScreenFromCache(int var1);

    public void callbackPopupRemoved(int var1, int var2);

    public void callbackPopupHidden(int var1, int var2);

    public void callbackPopupVisible(int var1, int var2);

    public void callbackScreenHidden(int var1);

    public void callbackScreenVisible(int var1);

    public HMIApplication getHMIApplication(int var1);

    public void dump(PrintStream var1);
}

