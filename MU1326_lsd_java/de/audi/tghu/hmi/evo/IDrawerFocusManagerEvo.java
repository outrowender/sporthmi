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
    public static final int STATE_SELECTION_MENU = 4;
    public static final int STATE_OPTION_MENU = 8;
    public static final int STATE_MAIN_AREA = 16;
    public static final int STATE_ENTERTAINMENT_MENU = 32;
    public static final int STATE_PARTIAL_POPUP = 64;
    public static final int STATE_CONNECT = 256;
    public static final int ILLUNINATION_KEY_EVENT_LEFT = 77;
    public static final int ILLUNINATION_KEY_EVENT_RIGHT = 78;

    public void setPartialPopupManager(IPartialPopupManager var1);

    public void setPresetPopupHandler(IPresetInputHandler var1);

    public void setPhoneKeyHandler(IPhoneKeyHandler var1);

    public void setGEMKeyHandler(IGEMKeyHandler var1);

    public void setScreen(IScreenData var1, Screen var2);

    public void setSelectionDrawer(Object var1);

    public void setOptionDrawer(Object var1, Comparable var2);

    public Object getSelectionDrawer();

    public Object getOptionDrawer();

    public Object getEntertainmentDrawer();

    public Object getPreviousSelectionDrawer();

    public Object getPreviousOptionDrawer();

    public void setEntertainmentDrawer(Object var1);

    public void processModelUpdateEvent(ModelUpdateEvent var1);

    public void screenChangeFinished();

    public void screenFadedOut();

    public void paintDrawers();

    public int getDrawerState();

    public int getPredictedDrawerState(Screen var1, IScreenData var2);

    public void setDrawerState(int var1, boolean var2);

    public void registerDrawerFocusManagerService(IFrameworkAccess var1);

    public void startTrackingServices(BundleContext var1, HMITerminal var2);

    public boolean requestDrawerState(int var1);

    public void registerFocusPropertyProvider(IFocusedPropertyProvider var1);

    public void deRegisterFocusPropertyProvider(IFocusedPropertyProvider var1);

    public IPresetPopupData getPresetPopupData();

    public void setViewSize(int var1, boolean var2);

    public void requestDrawerClose(int var1);

    public boolean isDrawerClosingRequested(int var1);

    public void setUsePersistence(boolean var1);

    public boolean isUsePersistence();

    public void updateOptionDrawerContent();

    public void setDrawersAndPopupsInvalid();

    public void processDrawerEvent(DrawerEvent var1);

    public IDrawerControllerEvo getLastValidOptionDrawer();

    public void reconnectDrawers();

    public void setLongpressKeyHandler(ILongpressKeyHandler var1);

    public void setDisclaimerActive(boolean var1);

    public void registerDrawerAnimationListener(DrawerAnimationListener var1);

    public void unregisterDrawerAnimationListener(DrawerAnimationListener var1);

    public void closeCurrentOptionDrawer();

    public void initializeDrawerAnimation(DrawerAnimationListener var1);

    public void addDrawerListener(IDrawerListener var1);

    public void removeDrawerListener(IDrawerListener var1);

    public void registerPopupDrawerAction(Runnable var1);

    public void setPartialPopupDrawerOpen(boolean var1);

    public void reinitScreen(Screen var1);

    public void changeToCurrentConnectedScreen(boolean var1);

    public void setOptionIconOffset(int var1, int var2);

    public int getDrawerTargetState();

    public void atLeastOnePartialPopupVisible(boolean var1);

    public void setOptionDrawerOpenedDuringScreenChange(boolean var1);

    public void setEarlyEntertainmentDrawerVisibility(boolean var1);

    public void setMenuMoveModeActive(boolean var1);
}

