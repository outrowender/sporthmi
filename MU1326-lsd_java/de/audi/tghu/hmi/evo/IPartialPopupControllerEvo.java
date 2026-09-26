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
    public static final int STYLE_ANIMATED;
    public static final int STYLE_NOT_ANIMATED;
    public static final int SHOW_OK;
    public static final int SHOW_ERROR;
    public static final int HIDE_OK;
    public static final int HIDE_ERROR;
    public static final int TIMER_MODE_DEFAULT;
    public static final int TIMER_MODE_IDLE_TIMER;
    public static final int LAYER_ALL;
    public static final int LAYER_BEHIND_DRAWERS;
    public static final int LAYER_IN_FRONT_OF_DRAWERS;
    public static final int LAYER_POPUP_DRAWER;
    public static final int LAYER_BETWEEN_DRAWERS;

    default public int show(int n) {
    }

    default public int getStyle() {
    }

    default public int hide(int n) {
    }

    default public int getType() {
    }

    default public void setType(int n) {
    }

    default public int getWidth() {
    }

    default public int getHeight() {
    }

    default public void setAutoHideTime(int n) {
    }

    default public void restartAutoHideTimer() {
    }

    default public void setScreenFactory(AbstractScreenFactory abstractScreenFactory) {
    }

    default public boolean processModelUpdateEventWithBoolean(ModelUpdateEvent modelUpdateEvent) {
    }

    default public void setInvalid(boolean bl) {
    }

    default public boolean survivesScreenChange() {
    }

    default public void processSDSEvent(SDSEvent sDSEvent) {
    }

    default public void setConsumeHKReturn(int n) {
    }

    default public void setConsumeDDSPress(int n) {
    }

    default public void setConsumeKeyTurned(int n) {
    }

    default public void setConsumeSKPress(int n) {
    }

    default public void setConsumeTouchPad(int n) {
    }

    default public void setConsumeGenericKeys(int n, int[] nArray) {
    }

    default public void setOpacity(float f2) {
    }

    default public void setDepth(int n) {
    }

    default public void setHKReturnEvent(int n) {
    }

    default public void setEvent(int n) {
    }

    default public boolean checkModelStatusAndInformPopupManager() {
    }

    default public void notifyPartialPopup(int n, int n2) {
    }

    default public void setShowPopupAfterConnecting(boolean bl) {
    }

    default public int getSlot() {
    }

    default public void setSlot(int n) {
    }

    default public void connected(boolean bl, boolean bl2) {
    }

    default public void makeSubtreeDirty() {
    }

    default public void setLayer(int n) {
    }

    default public int getlayer() {
    }

    default public void activateBackgroundGrayOut() {
    }

    default public void deactivateBackgroundGrayOut() {
    }

    default public boolean isPopupActive() {
    }

    default public boolean hasPopupDrawer() {
    }

    default public void setFocusedLayer(int n) {
    }

    default public void closePopupDrawer() {
    }

    default public int getX() {
    }

    default public int getY() {
    }

    default public boolean isVisible() {
    }

    default public boolean isFallbackScreenAllowed() {
    }

    default public void setFallbackScreenAllowed(boolean bl) {
    }
}

