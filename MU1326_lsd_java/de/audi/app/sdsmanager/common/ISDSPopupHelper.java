/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.common;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.SDSAudioHandler;
import de.audi.app.sdsmanager.common.Stoppable;
import de.audi.atip.mmicombi.IViewSizeManager;

public interface ISDSPopupHelper
extends Stoppable {
    public int getCurrentHMIPopup();

    public void removeAllSDSPopups();

    public void removeSmallCommandDisplay();

    public void removeAllBigCommandPopups();

    public void removeBigCommandDisplay();

    public void removeAllFurtherCommandPopups();

    public boolean isFurtherCommandDisplayActive();

    public void showFurtherCommandDisplay();

    public void removeFurtherCommandDisplay();

    public void toggleFurtherCommandDisplay();

    public void removeAllDisambiguationPopups();

    public int getCommandScreenPopupMapping(int var1);

    public int getHelpScreenPopupMapping(int var1);

    public void triggerHapticalPopup(int var1, boolean var2);

    public void triggerHapticalPartialPopup(int var1, boolean var2);

    public void triggerSpeechPopup(int var1, boolean var2);

    public int getCurrentBigCommandScreenPopupMapping();

    public void setCurrentBigCommandScreenPopupMapping(int var1);

    public int getCurrentHelpScreenPopupMappingID();

    public void setCurrentHelpScreenPopupMappingID(int var1);

    public void setViewSizeManager(IViewSizeManager var1);

    public void setAppSDSManager(AppSDSManager var1);

    public void setSDSAudioHandler(SDSAudioHandler var1);

    public void unsetViewSizeManager();

    public boolean isSmallStageActive();

    public boolean isSDSPopup(int var1);

    public void showDebugPopup(String var1, String var2, String var3);

    public boolean isBigCommandDisplay(int var1);

    public void setBigCommandDisplayToRemove(int var1);

    public void updateBigCommandDisplayConnected();

    public boolean isLogicalPopupRemovedBySDS();

    public void setLogicalPopupRemovedBySDS(boolean var1);

    public void updateFurtherCommandsRemoved();

    public void updateFurtherCommandsShown();

    public void setLastPartialPopupHiddenBySDSDialog();

    public void setLogicalPopupCalledToBeRemovedBySDS(boolean var1);

    public boolean isLogicalPopupCalledToBeRemovedBySDS();
}

