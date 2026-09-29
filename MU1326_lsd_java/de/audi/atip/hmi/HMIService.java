/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.hmi.HMIBundle;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.IFocusManager;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.ILegalDisclaimer;
import de.audi.atip.hmi.IRootWindow;
import de.audi.atip.hmi.cc.IComponentConditionManager;
import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.atip.hmi.event.EventDispatcherAdmin;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.view.IDisplayManager;
import de.audi.atip.hmi.view.IModelConnectService;
import de.audi.atip.hmi.view.IPopupManager;
import de.audi.atip.hmi.view.IScreenManager;
import de.audi.atip.hmi.view.Screen;

public interface HMIService
extends IHMIServiceApp {
    default public HMIModel getModel(int n) {
    }

    default public HMIModel getModel(int n, int n2) {
    }

    default public IDisplayManager getDisplayManager() {
    }

    default public ILegalDisclaimer getLegalDisclaimer() {
    }

    default public EventDispatcher getEventDispatcher() {
    }

    default public EventDispatcherAdmin getEventDispatcherAdmin() {
    }

    default public HMITerminal getHMITerminal(int n) {
    }

    default public IRootWindow getRootWindow(int n) {
    }

    default public IModelConnectService getModelConnectService(int n) {
    }

    default public IFocusManager getFocusManager() {
    }

    default public void lockCurrentScreen(int n, boolean bl) {
    }

    default public boolean isPartialPopupVisibleInSlot(int n, int n2) {
    }

    default public void replacePartialPopup(int n, int n2, int n3) {
    }

    default public void removeAllPartialPopupsForSlots(int n, int[] nArray) {
    }

    default public Object getImage(int n, int n2, int n3, int n4) {
    }

    default public Object getUncachedImage(int n, int n2, int n3, int n4) {
    }

    default public void fireSMEventFromModelId(int n, int n2) {
    }

    default public void fireSMEventFromModelId(int n, int n2, AdditionalScreenData additionalScreenData) {
    }

    default public void fireKeyEvent(int n, long l, int n2, int n3) {
    }

    default public void fireKeyEventDirectlyInEventDispatchThread(int n, long l, int n2, int n3) {
    }

    default public void fireJoyStickEvent(int n, long l, int n2, int n3, int n4) {
    }

    default public void fireWheelButtonEvent(int n, long l, int n2, int n3, int n4, int n5) {
    }

    default public void fireTouchEvent(int n, long l, int n2, int n3, int n4, int n5, int n6) {
    }

    default public void fireTouchEvent(int n, long l, int n2, int n3, int n4, String string, int[] nArray, int n5) {
    }

    default public void fireTouchEvent(int n, long l, int n2, int n3, int n4, int n5, boolean bl, int n6, int n7, int n8, int n9) {
    }

    default public void fireGestureEvent(int n, long l, int n2, int n3, int n4) {
    }

    default public void fireGestureEvent(int n, long l, int n2, int n3, int n4, int n5, int n6, int n7) {
    }

    default public void fireGestureEvent(int n, long l, int n2, int n3, String[] stringArray, int[] nArray, int n4) {
    }

    default public void fireSDSEvent(int n, int n2, int n3, int[] nArray) {
    }

    default public void postModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
    }

    default public ModelUpdateEvent getModelUpdateEvent(int n) {
    }

    default public void postComponentConditionEvent(int[] nArray) {
    }

    default public void takeScreenshot(int n, String string) {
    }

    default public void setUnsupportedDevelopmentBuild(boolean bl) {
    }

    default public void setFallbackScreen(int n, Screen screen) {
    }

    default public void showFallbackScreen(int n) {
    }

    default public boolean isScreenChangeAnimationRunning(int n) {
    }

    default public IComponentConditionManager getComponentConditionManager() {
    }

    default public HMIBundle getHMIBundle(int n) {
    }

    default public void showVisualFeedback(long l, String string, int n) {
    }

    default public IPopupManager getPopupManager(int n) {
    }

    default public IScreenManager getScreenManager(int n) {
    }

    default public Screen getCurrentlyActiveCombiScreen() {
    }

    default public Screen[] getCurrentlyActiveCombiScreens() {
    }

    default public void refreshTerminal(int n) {
    }
}

