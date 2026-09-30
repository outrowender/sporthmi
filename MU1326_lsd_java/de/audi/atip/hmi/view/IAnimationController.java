/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.view.IAnimation;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.mmicombi.IMMICombiAnimationSyncer;
import java.util.List;

public interface IAnimationController {
    public static final int INDEX_EXIT_SCREEN_ANIMATION_TYPE = 0;
    public static final int INDEX_EXIT_SCREEN_ADDITIONAL_INFO = 1;
    public static final int INDEX_ENTER_SCREEN_ANIMATION_TYPE = 2;
    public static final int INDEX_ENTER_SCREEN_ADDITIONAL_INFO = 3;
    public static final int INDEX_MODELLED_INFO_CURRENT_SCREEN = 0;
    public static final int INDEX_MODELLED_INFO_TARGET_SCREEN = 1;
    public static final int BITFIELD_MODELLED_INFO_APPLICATION_CHANGE = 1;
    public static final int BITFIELD_MODELLED_INFO_FORWARD_ANIMATION = 2;
    public static final int BITFIELD_MODELLED_INFO_BACKWARD_ANIMATION = 4;
    public static final int BITFIELD_MODELLED_INFO_TRIGGERED_BY_OPTION_DRAWER = 8;
    public static final int BITFIELD_MODELLED_INFO_TRIGGERED_BY_SELECTION_DRAWER = 16;
    public static final int BITFIELD_MODELLED_INFO_EXPLICIT_NO_ANIMATION = 32;
    public static final int BITFIELD_MODELLED_INFO_TRIGGERED_BY_HK_SELECTION = 64;
    public static final int BITFIELD_MODELLED_INFO_CLOSING_TO_OPTION_DRAWER = 128;
    public static final int BITFIELD_MODELLED_INFO_REINIT_SCREEN = 256;
    public static final int BITFIELD_MODELLED_INFO_SHOW_POPUP = 512;
    public static final int BITFIELD_MODELLED_INFO_HIDE_POPUP = 1024;
    public static final int BITFIELD_MODELLED_INFO_ROLLBACK = 2048;
    public static final int BITFIELD_ADDITIONAL_INFO_BACKGROUND_FADING = 1;
    public static final int BITFIELD_ADDITIONAL_INFO_BACKWARDS_ANIMATION = 2;
    public static final int BITFIELD_ADDITIONAL_INFO_ANIMATE_OPTION_DRAWER = 4;
    public static final int BITFIELD_ADDITIONAL_INFO_ANIMATE_SELECTION_DRAWER = 8;

    public IAnimation getIAnimation(int var1);

    public int[] getScreenChangeTypes(int[] var1, IScreenData var2, IScreenData var3, int[] var4);

    public boolean isScreenChangeType(int var1);

    public void setAnimationBlocked(int var1, boolean var2);

    public boolean isAnimationBlocked(int var1);

    public List getActiveAnimations(int var1);

    public void setMMICombiAnimationSyncer(IMMICombiAnimationSyncer var1);

    public boolean isScreenChangeAnimationRunning();

    public void registerService(IFrameworkAccess var1);

    public void startWaitAnimation(int var1);

    public void stopWaitAnimation(int var1);

    public void newMainScreenConnected(Screen var1);

    public Screen getConnectedMainScreen();

    public boolean isFirstScreenShown();

    public String getAnimationName(int var1);

    public int[] getAnimationsTypesForCombiSync();

    public void readAnimationParametersFromFile(String var1);

    public void setDrawerWasClosed(boolean var1);

    public boolean isAnimationRunning(int var1);

    public static class ModelContainer {
        public static ChoiceModel screenExitRemoteHMI = null;
        public static ChoiceModel screenExitAdditionalInformationRemoteHMI;
        public static ChoiceModel screenEnterRemoteHMI;
        public static ChoiceModel screenEnterAdditionalInformationRemoteHMI;

        static {
            screenEnterRemoteHMI = null;
        }
    }
}

