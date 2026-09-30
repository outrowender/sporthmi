/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IViewSizeListener;
import org.osgi.framework.BundleContext;

public interface IViewSizeManager {
    public static final int REQUEST_UNDEFINED = -1;
    public static final int REQUEST_OPTION_DRAWER_OPENED = 0;
    public static final int REQUEST_SELECTION_DRAWER_SUBLIST_OPENED = 1;
    public static final int REQUEST_ENTER_SCREEN_SMALL_STAGE_TYPE_REPLACE = 2;
    public static final int REQUEST_ENTER_SCREEN_SMALL_STAGE_TYPE_SCREENSHOT = 3;
    public static final int REQUEST_ENTER_SCREEN_SMALL_STAGE_TYPE_SCREENSHOT_FULLSCREEN = 4;
    public static final int REQUEST_ENTER_SCREEN_SMALL_STAGE_TYPE_CANCEL = 5;
    public static final int REQUEST_ENTER_OPTIONSCREEN = 6;
    public static final int REQUEST_KEY_TURNED_IN_NOT_FOCUSABLE_SCREEN = 7;
    public static final int REQUEST_KEY_PRESSED_IN_NOT_FOCUSABLE_SCREEN = 8;
    public static final int REQUEST_SCREEN_PREFERS_LARGE_VIEWSIZE = 9;
    public static final int REQUEST_MAP_BRIEFING = 10;
    public static final int REQUEST_SPELLER_OPENED = 11;
    public static final int REQUEST_FULLSCREEN_POPUP_HMI = 12;
    public static final int REQUEST_FULLSCREEN_POPUP_KOMBI = 13;
    public static final int REQUEST_ENTER_SCREEN_SMALL_STAGE_TYPE_KEEP_VIEWSIZE = 14;
    public static final int REQUEST_SDS = 15;
    public static final int REQUEST_KOMBI_INTERNAL_REASON_FOR_LARGE_VIEW_SIZE_ACTIVE = 16;
    public static final int NUM_REQUEST_TYPES = 17;

    public void optionMenuChange(int var1);

    public void touchpadViewSizeChangeRequest();

    public void setViewSize(int var1, boolean var2);

    public int getCurrentViewSize();

    public int getViewSize(Screen var1);

    public void setScreen(Screen var1);

    public void setSelectionDrawerOpened(boolean var1);

    public void startTrackingServices(BundleContext var1, HMITerminal var2);

    public void registerViewSizeManagerService(IFrameworkAccess var1);

    public void requestViewSizeChange(int var1);

    public void requestEarlyViewSizeChange(int var1, int var2);

    public void requestLargeViewSizeViaBitfield(long var1);

    public void requestLargeViewSize(int var1);

    public void requestLargeViewSize(int var1, int var2);

    public void unrequestLargeViewSize(int var1);

    public void unrequestLargeViewSize(int var1, int var2);

    public void unrequestLargeViewSize(int var1, boolean var2);

    public void addViewSizeListener(IViewSizeListener var1);

    public void viewSizeKeyPressed();

    public int getPreferredViewSize();

    public void setPreferredViewSize(int var1);

    public void addViewSizeRequest(int var1);

    public boolean isRequestActive(int var1);

    public boolean isLargeViewSizeRequestActive();

    public boolean isNonScreenBasedRequestActive();

    public void dumpAllViewSizeRequests();

    public int getRequestedViewSize();

    public void resetRequestedViewSize();

    public void setRequestedViewSize(int var1);

    public boolean isViewSizeInitialized();

    public void releaseInvalidation();

    public boolean setLocked(boolean var1, boolean var2);

    public boolean isLocked();

    public void setSportskinSmallStage(boolean var1);

    public boolean isSportskinSmallStage();

    public void mfwArrowKeyPressed(int var1, long var2);

    public LogChannel getLogChannel();

    public void screenChangeStateFinished(int var1);

    public boolean isKombiPopupHandlingActive();

    public boolean isHMIPopupHandlingActive();

    public boolean isAnimationRunning();
}

