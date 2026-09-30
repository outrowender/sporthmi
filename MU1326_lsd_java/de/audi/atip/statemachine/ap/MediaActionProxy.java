/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface MediaActionProxy
extends ActionProxy {
    public void hmiActivated(int var1);

    public void hmiDeactivated(int var1);

    public void mediaToggleSource(int var1);

    public void mediaToggleSourceEntered(int var1);

    public void mediaStartBrowsing(int var1, int var2, boolean var3);

    public void mediaChangeToParentFolder(int var1);

    public void mediaManualSeekEnter(int var1);

    public void mediaManualSeekLeft(int var1);

    public void mediaBrowserTrufflesDisable(int var1);

    public void mediaBrowserRestoreSelectionPath(int var1);

    public void mediaPlayerNewSearch(int var1);

    public void mediaDataSetSelectedList(int var1, int var2);

    public void mediaBrowserFavoritesRestoreSelectionPath(int var1);

    public void medialoadingFinished(int var1);

    public void mediaBrowserTrufflesDisableAnimWait(int var1);

    public void setBrowserActive(int var1, int var2);

    public void mediaStartSearchBrowser(int var1, int var2);

    public void setOptionOpenInNextScreen(int var1, int var2);
}

