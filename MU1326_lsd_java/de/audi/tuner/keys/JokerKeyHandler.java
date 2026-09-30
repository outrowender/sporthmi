/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.keys;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.TimerSyncer;
import de.audi.atip.timer.Timer;
import de.audi.tuner.keys.DefaultButtonHandler;
import de.audi.tuner.keys.DefaultKeyHandler;
import de.audi.tuner.keys.KeyHandlerBasics;

final class JokerKeyHandler
extends DefaultKeyHandler {
    private final IFrameworkAccess framework;
    private final DefaultButtonHandler defaultButtonHandler;
    private Timer synchronizingTimer;

    JokerKeyHandler(KeyHandlerBasics keyHandlerBasics, DefaultButtonHandler defaultButtonHandler) {
        super(keyHandlerBasics);
        this.framework = keyHandlerBasics.getBasics().getFramework();
        this.defaultButtonHandler = defaultButtonHandler;
        this.models.getButtonModel(100436).setButtonListener(this);
    }

    public void keyReleased(int n, int n2, int n3) {
        this.logger.hmi.log(10000000, "JokerKeyHandler#keyReleased: ");
        if (n != 100436) {
            this.logger.hmi.log(10000000, "JokerKeyHandler#keyReleased: unhandled key code %1", (long)n);
            return;
        }
        int n4 = this.models.getChoiceModel(395).getValue();
        if (n4 == 7) {
            this.logger.hmi.log(10000000, "JokerKeyHandler#keyReleased: switch traffic announcement");
            if (this.announce.toggleTaMode()) {
                this.framework.getMsgDistrib().sendMessage(66);
            } else {
                this.framework.getMsgDistrib().sendMessage(67);
            }
            return;
        }
        boolean bl = this.status.hasAudioFocus(0);
        if (n4 == 8 && !bl) {
            this.logger.hmi.log(10000000, "JokerKeyHandler#keyReleased: switch Media to Tuner -> start timer");
            if (this.synchronizingTimer == null) {
                this.synchronizingTimer = new Timer("SyncTimer", 5, null, new TimerSyncer(this), 1L, true);
            }
            this.synchronizingTimer.restart();
            return;
        }
        if (n4 == 8 && bl) {
            this.logger.hmi.log(10000000, "JokerKeyHandler#keyReleased: switch Tuner to Media");
        }
        if (n4 == 9 && bl) {
            this.logger.hmi.log(10000000, "JokerKeyHandler#keyReleased: skip forward");
            this.defaultButtonHandler.keyTyped(100428, n2, 0);
            return;
        }
        if (n4 == 14 && bl) {
            this.logger.hmi.log(10000000, "JokerKeyHandler#keyReleased: skip backward");
            this.defaultButtonHandler.keyTyped(100429, n2, 0);
            return;
        }
    }

    public void fireTimer(Timer timer) {
        if ("SyncTimer".equals(timer.getName())) {
            this.logger.hmi.log(10000000, "JokerKeyHandler#fireTimer: -> switch Media to Tuner");
            int n = this.models.getActiveTuner();
            this.audioFocusClient.switchSource(0, n, null);
        }
    }
}

