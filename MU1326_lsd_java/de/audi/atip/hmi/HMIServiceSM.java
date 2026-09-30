/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.hmi.view.IScreenData;

public interface HMIServiceSM {
    public void showScreen(int var1, int var2, IScreenData var3);

    public void showPopupScreen(int var1, IScreenData var2);

    public void removePopupScreen(int var1, int var2, int var3, boolean var4);

    public void replacePopupScreen(int var1, int var2, int var3, IScreenData var4);

    public void showPartialPopupsForPopup(int var1, int var2, int var3, int[] var4);

    public void showPartialPopups(int var1, int var2, int[] var3);

    public void removePartialPopupsFromPopup(int var1, int var2, int var3, int[] var4);

    public void removePartialPopups(int var1, int var2, int[] var3);

    public void fireSMEvent(int var1, int var2);

    public void fireSMEventDirectlyInEventDispatchThread(int var1, int var2);

    public void sMActionRequiresNoScreenChange(int var1);

    public int getFocusedTerminal();

    public int getCurrentPopupID(int var1);

    public void setActiveSubterminal(int var1, int var2);
}

