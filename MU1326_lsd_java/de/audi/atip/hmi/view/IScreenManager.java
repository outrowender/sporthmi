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
    public static final boolean IS_ANIMATED_SCREEN_CHANGE;
    public static final boolean ALWAYS_DISCONNECT_ON_SCREEN_CHANGE;

    default public int getCurrentScreenId() {
    }

    default public Screen getCurrentConnectedScreen() {
    }

    default public void lockCurrentConnectedScreen(boolean bl) {
    }

    default public void showScreen(IScreenData iScreenData) {
    }

    default public void setFallbackScreen(Screen screen) {
    }

    default public IScreenData getFallbackScreenData() {
    }

    default public boolean isScreenAvailable() {
    }

    default public Screen getScreen(IScreenData iScreenData) {
    }

    default public void dump(PrintStream printStream, String string) {
    }

    default public IModelConnectService getModelConnectService() {
    }

    default public void refresh() {
    }

    default public IScreenData getCurrentConnectedScreenData() {
    }

    default public IScreenData getPreviousConnectedScreenData() {
    }

    default public IScreenData getCurrentScreenData() {
    }

    default public void showPartialPopups(int n, int[] nArray) {
    }

    default public void removePartialPopups(int n, int[] nArray) {
    }

    default public boolean isScreenChangeAnimationRunning(int n) {
    }

    default public IScreenChangeManager getScreenChangeUnit() {
    }

    default public void setScreenChangeUnit(IScreenChangeManager iScreenChangeManager) {
    }

    default public ITerminalContext getTerminalContext() {
    }

    default public boolean isCurrentConnectedScreen(int n) {
    }

    default public IScreenData getTargetScreenData() {
    }

    default public void clearPendingScreenChange() {
    }

    default public void setPendingScreenChange(IScreenData iScreenData) {
    }

    default public int getPendingScreenId() {
    }

    default public Screen getPendingScreen() {
    }

    default public IScreenData getPendingScreenData() {
    }

    default public boolean isClusterAnScreenHidden(Screen screen) {
    }

    default public void clearCurrentConnectedScreenData() {
    }

    default public void setCurrentConnectedScreenData(IScreenData iScreenData) {
    }

    default public void setCurrentScreenData(IScreenData iScreenData) {
    }

    default public boolean isCurrentScreen(int n) {
    }

    default public boolean isScreenChangePending() {
    }

    default public void logToInfotainmentRecorder(int n) {
    }

    default public int getCurrentConnectedScreenId() {
    }

    default public boolean isCluster() {
    }

    default public EventDispatcherAdmin getEventDispatcherAdmin() {
    }

    default public IFrameworkAccess getFramework() {
    }

    default public boolean removePartialPopupFromScreenData(int n, int n2) {
    }
}

