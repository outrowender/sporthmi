/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.hmi.view.IScreenData;

public interface HMIServiceSM {
    default public void showScreen(int n, int n2, IScreenData iScreenData) {
    }

    default public void showPopupScreen(int n, IScreenData iScreenData) {
    }

    default public void removePopupScreen(int n, int n2, int n3, boolean bl) {
    }

    default public void replacePopupScreen(int n, int n2, int n3, IScreenData iScreenData) {
    }

    default public void showPartialPopupsForPopup(int n, int n2, int n3, int[] nArray) {
    }

    default public void showPartialPopups(int n, int n2, int[] nArray) {
    }

    default public void removePartialPopupsFromPopup(int n, int n2, int n3, int[] nArray) {
    }

    default public void removePartialPopups(int n, int n2, int[] nArray) {
    }

    default public void fireSMEvent(int n, int n2) {
    }

    default public void fireSMEventDirectlyInEventDispatchThread(int n, int n2) {
    }

    default public void sMActionRequiresNoScreenChange(int n) {
    }

    default public int getFocusedTerminal() {
    }

    default public int getCurrentPopupID(int n) {
    }

    default public void setActiveSubterminal(int n, int n2) {
    }
}

