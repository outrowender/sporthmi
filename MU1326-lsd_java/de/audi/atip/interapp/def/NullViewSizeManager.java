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

    @Override
    public void optionMenuChange(int n) {
        super.log();
    }

    @Override
    public void touchpadViewSizeChangeRequest() {
        super.log();
    }

    @Override
    public void setViewSize(int n, boolean bl) {
        super.log();
    }

    @Override
    public int getCurrentViewSize() {
        super.log();
        return 0;
    }

    @Override
    public int getViewSize(Screen screen) {
        super.log();
        return 0;
    }

    public IViewSizeChangeAnimationStatus getAnimationStatus() {
        super.log();
        return null;
    }

    @Override
    public void setScreen(Screen screen) {
        super.log();
    }

    @Override
    public void startTrackingServices(BundleContext bundleContext, HMITerminal hMITerminal) {
        super.log();
    }

    @Override
    public void registerViewSizeManagerService(IFrameworkAccess iFrameworkAccess) {
        super.log();
    }

    @Override
    public void requestViewSizeChange(int n) {
        super.log();
    }

    @Override
    public void addViewSizeListener(IViewSizeListener iViewSizeListener) {
        super.log();
    }

    @Override
    public void viewSizeKeyPressed() {
    }

    @Override
    public int getPreferredViewSize() {
        return 2;
    }

    @Override
    public void setPreferredViewSize(int n) {
    }

    @Override
    public void addViewSizeRequest(int n) {
    }

    @Override
    public void requestLargeViewSize(int n) {
    }

    @Override
    public void requestLargeViewSize(int n, int n2) {
    }

    @Override
    public void unrequestLargeViewSize(int n) {
    }

    @Override
    public void unrequestLargeViewSize(int n, int n2) {
    }

    @Override
    public void unrequestLargeViewSize(int n, boolean bl) {
    }

    @Override
    public boolean isRequestActive(int n) {
        return false;
    }

    @Override
    public void dumpAllViewSizeRequests() {
    }

    @Override
    public int getRequestedViewSize() {
        return 0;
    }

    @Override
    public void resetRequestedViewSize() {
    }

    @Override
    public boolean isViewSizeInitialized() {
        return false;
    }

    @Override
    public void releaseInvalidation() {
    }

    @Override
    public boolean isNonScreenBasedRequestActive() {
        return false;
    }

    @Override
    public boolean setLocked(boolean bl, boolean bl2) {
        return false;
    }

    @Override
    public boolean isLocked() {
        return false;
    }

    @Override
    public void setSportskinSmallStage(boolean bl) {
    }

    @Override
    public boolean isSportskinSmallStage() {
        return false;
    }

    @Override
    public void setRequestedViewSize(int n) {
    }

    @Override
    public boolean isLargeViewSizeRequestActive() {
        return false;
    }

    @Override
    public void setSelectionDrawerOpened(boolean bl) {
    }

    @Override
    public void mfwArrowKeyPressed(int n, long l) {
    }

    @Override
    public void requestEarlyViewSizeChange(int n, int n2) {
    }

    @Override
    public LogChannel getLogChannel() {
        return null;
    }

    @Override
    public void screenChangeStateFinished(int n) {
    }

    @Override
    public void requestLargeViewSizeViaBitfield(long l) {
    }

    @Override
    public boolean isKombiPopupHandlingActive() {
        return false;
    }

    @Override
    public boolean isHMIPopupHandlingActive() {
        return false;
    }

    @Override
    public boolean isAnimationRunning() {
        return false;
    }
}

