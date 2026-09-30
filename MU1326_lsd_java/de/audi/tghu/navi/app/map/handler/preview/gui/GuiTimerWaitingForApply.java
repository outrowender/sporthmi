/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview.gui;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.navi.app.NavigationEnv;

public class GuiTimerWaitingForApply
implements TimerListener {
    private static final int TIMEOUT_MSEC = 1000;
    protected NavigationEnv env;
    protected LogChannel logChannel;
    protected volatile Timer timerGuiWaitingForApply;
    protected int previewMapWaitSyncModelId;

    public GuiTimerWaitingForApply(NavigationEnv navigationEnv, LogChannel logChannel) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.timerGuiWaitingForApply = new Timer("GuiTimerWaitingForApply", 1000L, true, this);
    }

    public void setPreviewMapWaitSyncModelId(int n) {
        this.previewMapWaitSyncModelId = n;
        this.setStatusOk();
    }

    public void setActive(boolean bl) {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(this.previewMapWaitSyncModelId);
        if (choiceModelApp != null) {
            choiceModelApp.setStatus(bl ? 0 : 1);
        }
        if (bl) {
            Timer timer = this.timerGuiWaitingForApply;
            if (timer != null) {
                timer.restart();
            }
        } else {
            Timer timer = this.timerGuiWaitingForApply;
            if (timer != null) {
                timer.cancel();
            }
        }
    }

    public void cleanUp() {
        this.setStatusOk();
        Timer timer = this.timerGuiWaitingForApply;
        if (timer != null) {
            timer.cancel();
        }
        this.timerGuiWaitingForApply = null;
    }

    protected void setStatusOk() {
        ChoiceModelApp choiceModelApp = this.env.getHMIService().getChoiceModel(this.previewMapWaitSyncModelId);
        if (choiceModelApp != null) {
            choiceModelApp.setStatus(1);
        }
    }

    public void fireTimer(Timer timer) {
        this.logChannel.log(10000, "GuiTimerWaitingForApply#fireTimer()");
        this.setActive(false);
    }

    public void cancelTimer(Timer timer) {
    }
}

