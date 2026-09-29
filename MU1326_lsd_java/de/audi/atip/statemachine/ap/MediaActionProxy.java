/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface MediaActionProxy
extends ActionProxy {
    default public void hmiActivated(int n) {
    }

    default public void hmiDeactivated(int n) {
    }

    default public void mediaToggleSource(int n) {
    }

    default public void mediaToggleSourceEntered(int n) {
    }

    default public void mediaStartBrowsing(int n, int n2, boolean bl) {
    }

    default public void mediaChangeToParentFolder(int n) {
    }

    default public void mediaManualSeekEnter(int n) {
    }

    default public void mediaManualSeekLeft(int n) {
    }

    default public void mediaBrowserTrufflesDisable(int n) {
    }

    default public void mediaBrowserRestoreSelectionPath(int n) {
    }

    default public void mediaPlayerNewSearch(int n) {
    }

    default public void mediaDataSetSelectedList(int n, int n2) {
    }

    default public void mediaBrowserFavoritesRestoreSelectionPath(int n) {
    }

    default public void medialoadingFinished(int n) {
    }

    default public void mediaBrowserTrufflesDisableAnimWait(int n) {
    }

    default public void setBrowserActive(int n, int n2) {
    }

    default public void mediaStartSearchBrowser(int n, int n2) {
    }

    default public void setOptionOpenInNextScreen(int n, int n2) {
    }
}

