/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import de.audi.atip.hmi.view.IScreenData;
import java.io.PrintStream;

public interface IPopupManager {
    default public void showPopup(int n) {
    }

    default public void removePopup(int n) {
    }

    default public void setPopupKeyConsuptionStrategy(IPopupKeyConsuptionStrategy iPopupKeyConsuptionStrategy) {
    }

    default public boolean removeCurrentPopup() {
    }

    default public int getCurrentPopupID() {
    }

    default public int getCurrentPopupPriority() {
    }

    default public void enablePopups() {
    }

    default public void disablePopups(int n) {
    }

    default public boolean isPopupVisible() {
    }

    default public boolean popupAvailable() {
    }

    default public void showPopupScreen(IScreenData iScreenData) {
    }

    default public void removePopupScreen(int n, boolean bl, boolean bl2) {
    }

    default public void showPartialPopupsForPopup(int n, int n2, int[] nArray) {
    }

    default public void removePartialPopupsFromPopup(int n, int n2, int[] nArray) {
    }

    default public void replacePopupScreen(int n, IScreenData iScreenData) {
    }

    default public void dump(PrintStream printStream, String string) {
    }

    default public IScreenData getCurrentPopup() {
    }

    default public IPartialPopupManager getPPManager() {
    }

    default public boolean isLogicalPopup(IScreenData iScreenData) {
    }

    default public void callBackPopupHidden(IScreenData iScreenData) {
    }

    default public void callbackPopupRemoved(int n, int n2) {
    }

    default public boolean isInPopupList(int n) {
    }

    default public void processPopupQuit(int n) {
    }
}

