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
    default public int getCurrentHMIPopup() {
    }

    default public void removeAllSDSPopups() {
    }

    default public void removeSmallCommandDisplay() {
    }

    default public void removeAllBigCommandPopups() {
    }

    default public void removeBigCommandDisplay() {
    }

    default public void removeAllFurtherCommandPopups() {
    }

    default public boolean isFurtherCommandDisplayActive() {
    }

    default public void showFurtherCommandDisplay() {
    }

    default public void removeFurtherCommandDisplay() {
    }

    default public void toggleFurtherCommandDisplay() {
    }

    default public void removeAllDisambiguationPopups() {
    }

    default public int getCommandScreenPopupMapping(int n) {
    }

    default public int getHelpScreenPopupMapping(int n) {
    }

    default public void triggerHapticalPopup(int n, boolean bl) {
    }

    default public void triggerHapticalPartialPopup(int n, boolean bl) {
    }

    default public void triggerSpeechPopup(int n, boolean bl) {
    }

    default public int getCurrentBigCommandScreenPopupMapping() {
    }

    default public void setCurrentBigCommandScreenPopupMapping(int n) {
    }

    default public int getCurrentHelpScreenPopupMappingID() {
    }

    default public void setCurrentHelpScreenPopupMappingID(int n) {
    }

    default public void setViewSizeManager(IViewSizeManager iViewSizeManager) {
    }

    default public void setAppSDSManager(AppSDSManager appSDSManager) {
    }

    default public void setSDSAudioHandler(SDSAudioHandler sDSAudioHandler) {
    }

    default public void unsetViewSizeManager() {
    }

    default public boolean isSmallStageActive() {
    }

    default public boolean isSDSPopup(int n) {
    }

    default public void showDebugPopup(String string, String string2, String string3) {
    }

    default public boolean isBigCommandDisplay(int n) {
    }

    default public void setBigCommandDisplayToRemove(int n) {
    }

    default public void updateBigCommandDisplayConnected() {
    }

    default public boolean isLogicalPopupRemovedBySDS() {
    }

    default public void setLogicalPopupRemovedBySDS(boolean bl) {
    }

    default public void updateFurtherCommandsRemoved() {
    }

    default public void updateFurtherCommandsShown() {
    }

    default public void setLastPartialPopupHiddenBySDSDialog() {
    }

    default public void setLogicalPopupCalledToBeRemovedBySDS(boolean bl) {
    }

    default public boolean isLogicalPopupCalledToBeRemovedBySDS() {
    }
}

