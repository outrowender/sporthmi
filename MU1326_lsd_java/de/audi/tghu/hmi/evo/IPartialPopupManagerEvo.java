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
    public static final int STATE_POPUP_VISIBLE = 1;
    public static final int STATE_POPUP_HIDDEN = 2;
    public static final int STATE_POPUP_ERROR = 3;
    public static final int REGISTER_OK = 1;
    public static final int REGISTER_ERROR = 2;
    public static final int DEREGISTER_OK = 1;
    public static final int DEREGISTER_ERROR = 2;
    public static final int[] PARTIAL_POPUP_SLOT_DEPTHS = new int[]{30, 10, 11, 20, 19, 50, 0, 0, 20, 21, 29, 28, 0, 29};

    public int showPopup(int var1, IPartialPopupListener var2);

    public int popupVisible(int var1);

    public int popupHidden(int var1);

    public int registerPopup(IPartialPopupControllerEvo var1);

    public int deregisterPopup(IPartialPopupControllerEvo var1);

    public void newScreenConnected(Screen var1);

    public boolean processModelUpdateEvent(ModelUpdateEvent var1);

    public void paintUnboundPopups();

    public void keyPressed(KeyEvent var1);

    public void keyReleased(KeyEvent var1);

    public void keyTurned(WheelButtonEvent var1);

    public void keyMoved(JoystickEvent var1);

    public void processSDSEvent(SDSEvent var1);

    public void setPopupOpacity(float var1);

    public void hideNotScreenChangeSurvivingPopups();

    public int getEventID(int var1);

    public int getHMIPrio(int var1, int var2);

    public void setFocusedLayer(int var1);

    public void setPartialPopupCoordinates(int var1, int var2, int var3, int var4, int var5);

    public int hidePopup(int var1, boolean var2);
}

