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
    public HMIModel getModel(int var1);

    public HMIModel getModel(int var1, int var2);

    public IDisplayManager getDisplayManager();

    public ILegalDisclaimer getLegalDisclaimer();

    public EventDispatcher getEventDispatcher();

    public EventDispatcherAdmin getEventDispatcherAdmin();

    public HMITerminal getHMITerminal(int var1);

    public IRootWindow getRootWindow(int var1);

    public IModelConnectService getModelConnectService(int var1);

    public IFocusManager getFocusManager();

    public void lockCurrentScreen(int var1, boolean var2);

    public boolean isPartialPopupVisibleInSlot(int var1, int var2);

    public void replacePartialPopup(int var1, int var2, int var3);

    public void removeAllPartialPopupsForSlots(int var1, int[] var2);

    public Object getImage(int var1, int var2, int var3, int var4);

    public Object getUncachedImage(int var1, int var2, int var3, int var4);

    public void fireSMEventFromModelId(int var1, int var2);

    public void fireSMEventFromModelId(int var1, int var2, AdditionalScreenData var3);

    public void fireKeyEvent(int var1, long var2, int var4, int var5);

    public void fireKeyEventDirectlyInEventDispatchThread(int var1, long var2, int var4, int var5) throws Exception;

    public void fireJoyStickEvent(int var1, long var2, int var4, int var5, int var6);

    public void fireWheelButtonEvent(int var1, long var2, int var4, int var5, int var6, int var7);

    public void fireTouchEvent(int var1, long var2, int var4, int var5, int var6, int var7, int var8);

    public void fireTouchEvent(int var1, long var2, int var4, int var5, int var6, String var7, int[] var8, int var9);

    public void fireTouchEvent(int var1, long var2, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12);

    public void fireGestureEvent(int var1, long var2, int var4, int var5, int var6);

    public void fireGestureEvent(int var1, long var2, int var4, int var5, int var6, int var7, int var8, int var9);

    public void fireGestureEvent(int var1, long var2, int var4, int var5, String[] var6, int[] var7, int var8);

    public void fireSDSEvent(int var1, int var2, int var3, int[] var4);

    public void postModelUpdateEvent(ModelUpdateEvent var1);

    public ModelUpdateEvent getModelUpdateEvent(int var1);

    public void postComponentConditionEvent(int[] var1);

    public void takeScreenshot(int var1, String var2);

    public void setUnsupportedDevelopmentBuild(boolean var1);

    public void setFallbackScreen(int var1, Screen var2);

    public void showFallbackScreen(int var1);

    public boolean isScreenChangeAnimationRunning(int var1);

    public IComponentConditionManager getComponentConditionManager();

    public HMIBundle getHMIBundle(int var1);

    public void showVisualFeedback(long var1, String var3, int var4);

    public IPopupManager getPopupManager(int var1);

    public IScreenManager getScreenManager(int var1);

    public Screen getCurrentlyActiveCombiScreen();

    public Screen[] getCurrentlyActiveCombiScreens();

    public void refreshTerminal(int var1);
}

