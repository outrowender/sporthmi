/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.SDSEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.view.IPartialPopupListener;
import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.hmi.evo.IPartialPopupControllerEvo;

public interface IPartialPopupManagerEvo
extends IPartialPopupManager {
    public static final int STATE_POPUP_VISIBLE;
    public static final int STATE_POPUP_HIDDEN;
    public static final int STATE_POPUP_ERROR;
    public static final int REGISTER_OK;
    public static final int REGISTER_ERROR;
    public static final int DEREGISTER_OK;
    public static final int DEREGISTER_ERROR;
    public static final int[] PARTIAL_POPUP_SLOT_DEPTHS;

    default public int showPopup(int n, IPartialPopupListener iPartialPopupListener) {
    }

    default public int popupVisible(int n) {
    }

    default public int popupHidden(int n) {
    }

    default public int registerPopup(IPartialPopupControllerEvo iPartialPopupControllerEvo) {
    }

    default public int deregisterPopup(IPartialPopupControllerEvo iPartialPopupControllerEvo) {
    }

    default public void newScreenConnected(Screen screen) {
    }

    default public boolean processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
    }

    default public void paintUnboundPopups() {
    }

    default public void keyPressed(KeyEvent keyEvent) {
    }

    default public void keyReleased(KeyEvent keyEvent) {
    }

    default public void keyTurned(WheelButtonEvent wheelButtonEvent) {
    }

    default public void keyMoved(JoystickEvent joystickEvent) {
    }

    default public void processSDSEvent(SDSEvent sDSEvent) {
    }

    default public void setPopupOpacity(float f2) {
    }

    default public void hideNotScreenChangeSurvivingPopups() {
    }

    default public int getEventID(int n) {
    }

    default public int getHMIPrio(int n, int n2) {
    }

    default public void setFocusedLayer(int n) {
    }

    default public void setPartialPopupCoordinates(int n, int n2, int n3, int n4, int n5) {
    }

    default public int hidePopup(int n, boolean bl) {
    }

    static {
        PARTIAL_POPUP_SLOT_DEPTHS = new int[]{30, 10, 11, 20, 19, 50, 0, 0, 20, 21, 29, 28, 0, 29};
    }
}

