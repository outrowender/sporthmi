/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import de.audi.atip.hmi.view.IScreenData;
import java.io.PrintStream;

public interface IPopupManager {
    public void showPopup(int var1);

    public void removePopup(int var1);

    public void setPopupKeyConsuptionStrategy(IPopupKeyConsuptionStrategy var1);

    public boolean removeCurrentPopup();

    public int getCurrentPopupID();

    public int getCurrentPopupPriority();

    public void enablePopups();

    public void disablePopups(int var1);

    public boolean isPopupVisible();

    public boolean popupAvailable();

    public void showPopupScreen(IScreenData var1);

    public void removePopupScreen(int var1, boolean var2, boolean var3);

    public void showPartialPopupsForPopup(int var1, int var2, int[] var3);

    public void removePartialPopupsFromPopup(int var1, int var2, int[] var3);

    public void replacePopupScreen(int var1, IScreenData var2);

    public void dump(PrintStream var1, String var2);

    public IScreenData getCurrentPopup();

    public IPartialPopupManager getPPManager();

    public boolean isLogicalPopup(IScreenData var1);

    public void callBackPopupHidden(IScreenData var1);

    public void callbackPopupRemoved(int var1, int var2);

    public boolean isInPopupList(int var1);

    public void processPopupQuit(int var1);
}

