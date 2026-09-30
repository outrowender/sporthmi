/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.hmi.ITTSHandler;
import de.audi.atip.hmi.KbdService;
import de.audi.atip.hmi.view.IAnimationController;
import de.audi.atip.hmi.view.IGUIManager;
import de.audi.atip.hmi.view.IImageLoader;
import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.atip.hmi.view.IStatistics;
import de.audi.atip.hmi.view.ITouchInputManager;
import de.audi.atip.hmi.view.ScreenCache;
import de.audi.atip.interapp.tts.TTSSessionBasedService;

public interface HMITerminal {
    public static final int UNDEFINED = -2;
    public static final int ALL = -1;
    public static final int MAIN = 0;
    public static final int CLUSTER = 1;
    public static final int FRONT_PASSENGER = 2;
    public static final int REAR_SEAT_LEFT = 3;
    public static final int REAR_SEAT_RIGHT = 4;
    public static final int REAR_SEAT_JOINT = 5;
    public static final int SPEECH = 6;
    public static final int MAIN_SIDECONTEXT = 7;
    public static final int MAX_TERMINALS = 8;
    public static final int SUBTERMINAL_NONE = 0;
    public static final int SUBTERMINAL_ENTERTAINMENT = 1;
    public static final int SUBTERMINAL_PHONE = 2;
    public static final int SUBTERMINAL_NAVI = 3;
    public static final int MAX_SUBTERMINALS = 4;
    public static final long STATE_ACTIVE = 1L;
    public static final long STATE_NOT_ACTIVE = 2L;
    public static final long STATE_ACTIVE_NO_SWAPPING = 4L;
    public static final long STATE_REAR_SEAT_LEFT_JOINT = 8L;
    public static final long STATE_REAR_SEAT_RIGHT_JOINT = 16L;

    public IAnimationController getIAnimationController();

    public void start();

    public void stop();

    public int getTerminalID();

    public boolean isStarted();

    public IGUIManager getGUIManager();

    public IImageLoader getImageLoader();

    public ScreenCache getScreenCache();

    public IPartialPopupManager getPartialPopupManager();

    public IStatistics getStatistics();

    public void setFocus(boolean var1);

    public void setTTSService(TTSSessionBasedService var1);

    public ITTSHandler getTTSHandler();

    public ITouchInputManager getTouchInputManager();

    public KbdService getKbdService();
}

