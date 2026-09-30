/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IViewSizeChangeAnimationStatus;
import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.atip.mmicombi.IViewSizeManager;
import org.osgi.framework.BundleContext;

public class NullViewSizeManager
extends NullService
implements IViewSizeManager {
    public NullViewSizeManager(LogChannel logChannel) {
        super(logChannel, "IViewSizeManager");
    }

    public void optionMenuChange(int n) {
        super.log();
    }

    public void touchpadViewSizeChangeRequest() {
        super.log();
    }

    public void setViewSize(int n, boolean bl) {
        super.log();
    }

    public int getCurrentViewSize() {
        super.log();
        return 0;
    }

    public int getViewSize(Screen screen) {
        super.log();
        return 0;
    }

    public IViewSizeChangeAnimationStatus getAnimationStatus() {
        super.log();
        return null;
    }

    public void setScreen(Screen screen) {
        super.log();
    }

    public void startTrackingServices(BundleContext bundleContext, HMITerminal hMITerminal) {
        super.log();
    }

    public void registerViewSizeManagerService(IFrameworkAccess iFrameworkAccess) {
        super.log();
    }

    public void requestViewSizeChange(int n) {
        super.log();
    }

    public void addViewSizeListener(IViewSizeListener iViewSizeListener) {
        super.log();
    }

    public void viewSizeKeyPressed() {
    }

    public int getPreferredViewSize() {
        return 2;
    }

    public void setPreferredViewSize(int n) {
    }

    public void addViewSizeRequest(int n) {
    }

    public void requestLargeViewSize(int n) {
    }

    public void requestLargeViewSize(int n, int n2) {
    }

    public void unrequestLargeViewSize(int n) {
    }

    public void unrequestLargeViewSize(int n, int n2) {
    }

    public void unrequestLargeViewSize(int n, boolean bl) {
    }

    public boolean isRequestActive(int n) {
        return false;
    }

    public void dumpAllViewSizeRequests() {
    }

    public int getRequestedViewSize() {
        return 0;
    }

    public void resetRequestedViewSize() {
    }

    public boolean isViewSizeInitialized() {
        return false;
    }

    public void releaseInvalidation() {
    }

    public boolean isNonScreenBasedRequestActive() {
        return false;
    }

    public boolean setLocked(boolean bl, boolean bl2) {
        return false;
    }

    public boolean isLocked() {
        return false;
    }

    public void setSportskinSmallStage(boolean bl) {
    }

    public boolean isSportskinSmallStage() {
        return false;
    }

    public void setRequestedViewSize(int n) {
    }

    public boolean isLargeViewSizeRequestActive() {
        return false;
    }

    public void setSelectionDrawerOpened(boolean bl) {
    }

    public void mfwArrowKeyPressed(int n, long l) {
    }

    public void requestEarlyViewSizeChange(int n, int n2) {
    }

    public LogChannel getLogChannel() {
        return null;
    }

    public void screenChangeStateFinished(int n) {
    }

    public void requestLargeViewSizeViaBitfield(long l) {
    }

    public boolean isKombiPopupHandlingActive() {
        return false;
    }

    public boolean isHMIPopupHandlingActive() {
        return false;
    }

    public boolean isAnimationRunning() {
        return false;
    }
}

