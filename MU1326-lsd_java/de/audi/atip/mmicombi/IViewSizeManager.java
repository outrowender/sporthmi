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
    public static final int REQUEST_UNDEFINED;
    public static final int REQUEST_OPTION_DRAWER_OPENED;
    public static final int REQUEST_SELECTION_DRAWER_SUBLIST_OPENED;
    public static final int REQUEST_ENTER_SCREEN_SMALL_STAGE_TYPE_REPLACE;
    public static final int REQUEST_ENTER_SCREEN_SMALL_STAGE_TYPE_SCREENSHOT;
    public static final int REQUEST_ENTER_SCREEN_SMALL_STAGE_TYPE_SCREENSHOT_FULLSCREEN;
    public static final int REQUEST_ENTER_SCREEN_SMALL_STAGE_TYPE_CANCEL;
    public static final int REQUEST_ENTER_OPTIONSCREEN;
    public static final int REQUEST_KEY_TURNED_IN_NOT_FOCUSABLE_SCREEN;
    public static final int REQUEST_KEY_PRESSED_IN_NOT_FOCUSABLE_SCREEN;
    public static final int REQUEST_SCREEN_PREFERS_LARGE_VIEWSIZE;
    public static final int REQUEST_MAP_BRIEFING;
    public static final int REQUEST_SPELLER_OPENED;
    public static final int REQUEST_FULLSCREEN_POPUP_HMI;
    public static final int REQUEST_FULLSCREEN_POPUP_KOMBI;
    public static final int REQUEST_ENTER_SCREEN_SMALL_STAGE_TYPE_KEEP_VIEWSIZE;
    public static final int REQUEST_SDS;
    public static final int REQUEST_KOMBI_INTERNAL_REASON_FOR_LARGE_VIEW_SIZE_ACTIVE;
    public static final int NUM_REQUEST_TYPES;

    default public void optionMenuChange(int n) {
    }

    default public void touchpadViewSizeChangeRequest() {
    }

    default public void setViewSize(int n, boolean bl) {
    }

    default public int getCurrentViewSize() {
    }

    default public int getViewSize(Screen screen) {
    }

    default public void setScreen(Screen screen) {
    }

    default public void setSelectionDrawerOpened(boolean bl) {
    }

    default public void startTrackingServices(BundleContext bundleContext, HMITerminal hMITerminal) {
    }

    default public void registerViewSizeManagerService(IFrameworkAccess iFrameworkAccess) {
    }

    default public void requestViewSizeChange(int n) {
    }

    default public void requestEarlyViewSizeChange(int n, int n2) {
    }

    default public void requestLargeViewSizeViaBitfield(long l) {
    }

    default public void requestLargeViewSize(int n) {
    }

    default public void requestLargeViewSize(int n, int n2) {
    }

    default public void unrequestLargeViewSize(int n) {
    }

    default public void unrequestLargeViewSize(int n, int n2) {
    }

    default public void unrequestLargeViewSize(int n, boolean bl) {
    }

    default public void addViewSizeListener(IViewSizeListener iViewSizeListener) {
    }

    default public void viewSizeKeyPressed() {
    }

    default public int getPreferredViewSize() {
    }

    default public void setPreferredViewSize(int n) {
    }

    default public void addViewSizeRequest(int n) {
    }

    default public boolean isRequestActive(int n) {
    }

    default public boolean isLargeViewSizeRequestActive() {
    }

    default public boolean isNonScreenBasedRequestActive() {
    }

    default public void dumpAllViewSizeRequests() {
    }

    default public int getRequestedViewSize() {
    }

    default public void resetRequestedViewSize() {
    }

    default public void setRequestedViewSize(int n) {
    }

    default public boolean isViewSizeInitialized() {
    }

    default public void releaseInvalidation() {
    }

    default public boolean setLocked(boolean bl, boolean bl2) {
    }

    default public boolean isLocked() {
    }

    default public void setSportskinSmallStage(boolean bl) {
    }

    default public boolean isSportskinSmallStage() {
    }

    default public void mfwArrowKeyPressed(int n, long l) {
    }

    default public LogChannel getLogChannel() {
    }

    default public void screenChangeStateFinished(int n) {
    }

    default public boolean isKombiPopupHandlingActive() {
    }

    default public boolean isHMIPopupHandlingActive() {
    }

    default public boolean isAnimationRunning() {
    }
}

