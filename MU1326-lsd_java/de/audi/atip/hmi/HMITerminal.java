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
    public static final int UNDEFINED;
    public static final int ALL;
    public static final int MAIN;
    public static final int CLUSTER;
    public static final int FRONT_PASSENGER;
    public static final int REAR_SEAT_LEFT;
    public static final int REAR_SEAT_RIGHT;
    public static final int REAR_SEAT_JOINT;
    public static final int SPEECH;
    public static final int MAIN_SIDECONTEXT;
    public static final int MAX_TERMINALS;
    public static final int SUBTERMINAL_NONE;
    public static final int SUBTERMINAL_ENTERTAINMENT;
    public static final int SUBTERMINAL_PHONE;
    public static final int SUBTERMINAL_NAVI;
    public static final int MAX_SUBTERMINALS;
    public static final long STATE_ACTIVE;
    public static final long STATE_NOT_ACTIVE;
    public static final long STATE_ACTIVE_NO_SWAPPING;
    public static final long STATE_REAR_SEAT_LEFT_JOINT;
    public static final long STATE_REAR_SEAT_RIGHT_JOINT;

    default public IAnimationController getIAnimationController() {
    }

    default public void start() {
    }

    default public void stop() {
    }

    default public int getTerminalID() {
    }

    default public boolean isStarted() {
    }

    default public IGUIManager getGUIManager() {
    }

    default public IImageLoader getImageLoader() {
    }

    default public ScreenCache getScreenCache() {
    }

    default public IPartialPopupManager getPartialPopupManager() {
    }

    default public IStatistics getStatistics() {
    }

    default public void setFocus(boolean bl) {
    }

    default public void setTTSService(TTSSessionBasedService tTSSessionBasedService) {
    }

    default public ITTSHandler getTTSHandler() {
    }

    default public ITouchInputManager getTouchInputManager() {
    }

    default public KbdService getKbdService() {
    }
}

