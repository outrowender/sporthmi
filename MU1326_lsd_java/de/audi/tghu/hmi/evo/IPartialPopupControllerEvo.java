/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.SDSEvent;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.IPartialPopupController;

public interface IPartialPopupControllerEvo
extends IPartialPopupController {
    public static final int STYLE_ANIMATED = 1;
    public static final int STYLE_NOT_ANIMATED = 2;
    public static final int SHOW_OK = 1;
    public static final int SHOW_ERROR = 2;
    public static final int HIDE_OK = 1;
    public static final int HIDE_ERROR = 2;
    public static final int TIMER_MODE_DEFAULT = 0;
    public static final int TIMER_MODE_IDLE_TIMER = 1;
    public static final int LAYER_ALL = -1;
    public static final int LAYER_BEHIND_DRAWERS = 0;
    public static final int LAYER_IN_FRONT_OF_DRAWERS = 1;
    public static final int LAYER_POPUP_DRAWER = 2;
    public static final int LAYER_BETWEEN_DRAWERS = 3;

    public int show(int var1);

    public int getStyle();

    public int hide(int var1);

    public int getType();

    public void setType(int var1);

    public int getWidth();

    public int getHeight();

    public void setAutoHideTime(int var1);

    public void restartAutoHideTimer();

    public void setScreenFactory(AbstractScreenFactory var1);

    public boolean processModelUpdateEventWithBoolean(ModelUpdateEvent var1);

    public void setInvalid(boolean var1);

    public boolean survivesScreenChange();

    public void processSDSEvent(SDSEvent var1);

    public void setConsumeHKReturn(int var1);

    public void setConsumeDDSPress(int var1);

    public void setConsumeKeyTurned(int var1);

    public void setConsumeSKPress(int var1);

    public void setConsumeTouchPad(int var1);

    public void setConsumeGenericKeys(int var1, int[] var2);

    public void setOpacity(float var1);

    public void setDepth(int var1);

    public void setHKReturnEvent(int var1);

    public void setEvent(int var1);

    public boolean checkModelStatusAndInformPopupManager();

    public void notifyPartialPopup(int var1, int var2);

    public void setShowPopupAfterConnecting(boolean var1);

    public int getSlot();

    public void setSlot(int var1);

    public void connected(boolean var1, boolean var2);

    public void makeSubtreeDirty();

    public void setLayer(int var1);

    public int getlayer();

    public void activateBackgroundGrayOut();

    public void deactivateBackgroundGrayOut();

    public boolean isPopupActive();

    public boolean hasPopupDrawer();

    public void setFocusedLayer(int var1);

    public void closePopupDrawer();

    public int getX();

    public int getY();

    public boolean isVisible();

    public boolean isFallbackScreenAllowed();

    public void setFallbackScreenAllowed(boolean var1);
}

