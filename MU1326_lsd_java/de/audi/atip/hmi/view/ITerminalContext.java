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
    default public ITerminalContext getSubterminal(int n) {
    }

    default public IScreenManager getScreenManager() {
    }

    default public IPopupManager getPopupManager() {
    }

    default public IPartialPopupManager getPartialPopupManager() {
    }

    default public IRootWindow getRootWindow() {
    }

    default public HMIModel getModel(int n) {
    }

    default public Object getImageImpl(int n, boolean bl, int n2, int n3) {
    }

    default public void initialize(HMIService hMIService) {
    }

    default public HMIService getHMIService() {
    }

    default public boolean isCluster() {
    }

    default public int getTerminalID() {
    }

    default public IFrameworkAccess getFramework() {
    }

    default public HMITerminal getHmiTerminal() {
    }

    default public Screen getScreenFromCache(int n) {
    }

    default public void callbackPopupRemoved(int n, int n2) {
    }

    default public void callbackPopupHidden(int n, int n2) {
    }

    default public void callbackPopupVisible(int n, int n2) {
    }

    default public void callbackScreenHidden(int n) {
    }

    default public void callbackScreenVisible(int n) {
    }

    default public HMIApplication getHMIApplication(int n) {
    }

    default public void dump(PrintStream printStream) {
    }
}

