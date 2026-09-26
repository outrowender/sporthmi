/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.event.DrawerEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.hmi.evo.DrawerAnimationListener;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;
import de.audi.tghu.hmi.evo.IDrawerListener;
import de.audi.tghu.hmi.evo.IEventListenerEvo;
import de.audi.tghu.hmi.evo.IFocusedPropertyProvider;
import de.audi.tghu.hmi.evo.IGEMKeyHandler;
import de.audi.tghu.hmi.evo.ILockingListener;
import de.audi.tghu.hmi.evo.ILongpressKeyHandler;
import de.audi.tghu.hmi.evo.IPhoneKeyHandler;
import de.audi.tghu.hmi.evo.IPresetInputHandler;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.audi.tghu.hmi.evo.ScreenChangeAnimationItem;
import org.osgi.framework.BundleContext;

public interface IDrawerFocusManagerEvo
extends IEventListenerEvo,
ScreenChangeAnimationItem,
ILockingListener {
    public static final int STATE_SELECTION_MENU;
    public static final int STATE_OPTION_MENU;
    public static final int STATE_MAIN_AREA;
    public static final int STATE_ENTERTAINMENT_MENU;
    public static final int STATE_PARTIAL_POPUP;
    public static final int STATE_CONNECT;
    public static final int ILLUNINATION_KEY_EVENT_LEFT;
    public static final int ILLUNINATION_KEY_EVENT_RIGHT;

    default public void setPartialPopupManager(IPartialPopupManager iPartialPopupManager) {
    }

    default public void setPresetPopupHandler(IPresetInputHandler iPresetInputHandler) {
    }

    default public void setPhoneKeyHandler(IPhoneKeyHandler iPhoneKeyHandler) {
    }

    default public void setGEMKeyHandler(IGEMKeyHandler iGEMKeyHandler) {
    }

    default public void setScreen(IScreenData iScreenData, Screen screen) {
    }

    default public void setSelectionDrawer(Object object) {
    }

    default public void setOptionDrawer(Object object, Comparable comparable) {
    }

    default public Object getSelectionDrawer() {
    }

    default public Object getOptionDrawer() {
    }

    default public Object getEntertainmentDrawer() {
    }

    default public Object getPreviousSelectionDrawer() {
    }

    default public Object getPreviousOptionDrawer() {
    }

    default public void setEntertainmentDrawer(Object object) {
    }

    default public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
    }

    @Override
    default public void screenChangeFinished() {
    }

    default public void screenFadedOut() {
    }

    default public void paintDrawers() {
    }

    default public int getDrawerState() {
    }

    default public int getPredictedDrawerState(Screen screen, IScreenData iScreenData) {
    }

    default public void setDrawerState(int n, boolean bl) {
    }

    default public void registerDrawerFocusManagerService(IFrameworkAccess iFrameworkAccess) {
    }

    default public void startTrackingServices(BundleContext bundleContext, HMITerminal hMITerminal) {
    }

    default public boolean requestDrawerState(int n) {
    }

    default public void registerFocusPropertyProvider(IFocusedPropertyProvider iFocusedPropertyProvider) {
    }

    default public void deRegisterFocusPropertyProvider(IFocusedPropertyProvider iFocusedPropertyProvider) {
    }

    default public IPresetPopupData getPresetPopupData() {
    }

    default public void setViewSize(int n, boolean bl) {
    }

    default public void requestDrawerClose(int n) {
    }

    default public boolean isDrawerClosingRequested(int n) {
    }

    default public void setUsePersistence(boolean bl) {
    }

    default public boolean isUsePersistence() {
    }

    default public void updateOptionDrawerContent() {
    }

    default public void setDrawersAndPopupsInvalid() {
    }

    default public void processDrawerEvent(DrawerEvent drawerEvent) {
    }

    default public IDrawerControllerEvo getLastValidOptionDrawer() {
    }

    default public void reconnectDrawers() {
    }

    default public void setLongpressKeyHandler(ILongpressKeyHandler iLongpressKeyHandler) {
    }

    default public void setDisclaimerActive(boolean bl) {
    }

    default public void registerDrawerAnimationListener(DrawerAnimationListener drawerAnimationListener) {
    }

    default public void unregisterDrawerAnimationListener(DrawerAnimationListener drawerAnimationListener) {
    }

    default public void closeCurrentOptionDrawer() {
    }

    default public void initializeDrawerAnimation(DrawerAnimationListener drawerAnimationListener) {
    }

    default public void addDrawerListener(IDrawerListener iDrawerListener) {
    }

    default public void removeDrawerListener(IDrawerListener iDrawerListener) {
    }

    default public void registerPopupDrawerAction(Runnable runnable) {
    }

    default public void setPartialPopupDrawerOpen(boolean bl) {
    }

    default public void reinitScreen(Screen screen) {
    }

    default public void changeToCurrentConnectedScreen(boolean bl) {
    }

    default public void setOptionIconOffset(int n, int n2) {
    }

    default public int getDrawerTargetState() {
    }

    default public void atLeastOnePartialPopupVisible(boolean bl) {
    }

    default public void setOptionDrawerOpenedDuringScreenChange(boolean bl) {
    }

    default public void setEarlyEntertainmentDrawerVisibility(boolean bl) {
    }

    default public void setMenuMoveModeActive(boolean bl) {
    }
}

