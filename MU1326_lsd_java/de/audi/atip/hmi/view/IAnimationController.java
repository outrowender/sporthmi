/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.view.IAnimation;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.mmicombi.IMMICombiAnimationSyncer;
import java.util.List;

public interface IAnimationController {
    public static final int INDEX_EXIT_SCREEN_ANIMATION_TYPE;
    public static final int INDEX_EXIT_SCREEN_ADDITIONAL_INFO;
    public static final int INDEX_ENTER_SCREEN_ANIMATION_TYPE;
    public static final int INDEX_ENTER_SCREEN_ADDITIONAL_INFO;
    public static final int INDEX_MODELLED_INFO_CURRENT_SCREEN;
    public static final int INDEX_MODELLED_INFO_TARGET_SCREEN;
    public static final int BITFIELD_MODELLED_INFO_APPLICATION_CHANGE;
    public static final int BITFIELD_MODELLED_INFO_FORWARD_ANIMATION;
    public static final int BITFIELD_MODELLED_INFO_BACKWARD_ANIMATION;
    public static final int BITFIELD_MODELLED_INFO_TRIGGERED_BY_OPTION_DRAWER;
    public static final int BITFIELD_MODELLED_INFO_TRIGGERED_BY_SELECTION_DRAWER;
    public static final int BITFIELD_MODELLED_INFO_EXPLICIT_NO_ANIMATION;
    public static final int BITFIELD_MODELLED_INFO_TRIGGERED_BY_HK_SELECTION;
    public static final int BITFIELD_MODELLED_INFO_CLOSING_TO_OPTION_DRAWER;
    public static final int BITFIELD_MODELLED_INFO_REINIT_SCREEN;
    public static final int BITFIELD_MODELLED_INFO_SHOW_POPUP;
    public static final int BITFIELD_MODELLED_INFO_HIDE_POPUP;
    public static final int BITFIELD_MODELLED_INFO_ROLLBACK;
    public static final int BITFIELD_ADDITIONAL_INFO_BACKGROUND_FADING;
    public static final int BITFIELD_ADDITIONAL_INFO_BACKWARDS_ANIMATION;
    public static final int BITFIELD_ADDITIONAL_INFO_ANIMATE_OPTION_DRAWER;
    public static final int BITFIELD_ADDITIONAL_INFO_ANIMATE_SELECTION_DRAWER;

    default public IAnimation getIAnimation(int n) {
    }

    default public int[] getScreenChangeTypes(int[] nArray, IScreenData iScreenData, IScreenData iScreenData2, int[] nArray2) {
    }

    default public boolean isScreenChangeType(int n) {
    }

    default public void setAnimationBlocked(int n, boolean bl) {
    }

    default public boolean isAnimationBlocked(int n) {
    }

    default public List getActiveAnimations(int n) {
    }

    default public void setMMICombiAnimationSyncer(IMMICombiAnimationSyncer iMMICombiAnimationSyncer) {
    }

    default public boolean isScreenChangeAnimationRunning() {
    }

    default public void registerService(IFrameworkAccess iFrameworkAccess) {
    }

    default public void startWaitAnimation(int n) {
    }

    default public void stopWaitAnimation(int n) {
    }

    default public void newMainScreenConnected(Screen screen) {
    }

    default public Screen getConnectedMainScreen() {
    }

    default public boolean isFirstScreenShown() {
    }

    default public String getAnimationName(int n) {
    }

    default public int[] getAnimationsTypesForCombiSync() {
    }

    default public void readAnimationParametersFromFile(String string) {
    }

    default public void setDrawerWasClosed(boolean bl) {
    }

    default public boolean isAnimationRunning(int n) {
    }
}

