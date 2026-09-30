/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.modelaccess.ButtonModelGUI;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.IIdleTimerWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.ButtonGroupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;

public class ButtonController
extends IconController
implements ATIPEventListener,
IIdleTimerWidget {
    private Job timerJob = null;
    private TimerEvent timerEvent = null;
    private int longTypedTimeout = 0;
    private boolean longTyped;
    private int buttonID;

    protected void initializeWidget() {
        super.initializeWidget();
    }

    public void setLongTypedTimeout(int n) {
        this.longTypedTimeout = n;
    }

    public void setFocused(boolean bl) {
        super.setFocused(bl);
        if (bl && this.model instanceof ChoiceModelGUI && this.getTerminalImpl() != null) {
            ((ChoiceModelGUI)this.model).itemFocused(this.buttonID, this.getTerminalImpl().getTerminalID());
        }
    }

    protected Object calculateModelContent() {
        return null;
    }

    private void notifyButtonGroup() {
        if (this.parent != null && this.parent instanceof ButtonGroupController) {
            ((ButtonGroupController)this.parent).childrenChanged();
        }
    }

    public void setVisible(boolean bl) {
        super.setVisible(bl);
        this.notifyButtonGroup();
    }

    public void keyPressed(KeyEvent keyEvent) {
        if (!(this.isActive() && this.isEnabled() && this.isVisible())) {
            return;
        }
        if (this.model instanceof ChoiceModelGUI) {
            IWidgetLogChannel.logChannel.log(10000000, "ButtonController#keyPressed() ChoiceModelGUI");
            ((ChoiceModelGUI)this.model).itemSelected(this.buttonID, this.getTerminalImpl().getTerminalID());
        } else if (this.model instanceof ButtonModelGUI) {
            IWidgetLogChannel.logChannel.log(10000000, "ButtonController#keyPressed() ButtonModelGUI");
            ((ButtonModelGUI)this.model).keyPressed(this.modelID, this.getTerminalImpl().getTerminalID());
        }
        super.keyPressed(keyEvent);
        if (!this.isTimerRunning()) {
            IWidgetLogChannel.logChannel.log(10000000, "ButtonController#keyPressed() timerStarted");
            this.restartTimer();
        }
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        super.keyTurned(wheelButtonEvent);
        if (this.isTimerRunning()) {
            this.cancelTimer();
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        if (!(this.isActive() && this.isEnabled() && this.isVisible() && keyEvent.getKeyCode() != 13 && keyEvent.getKeyCode() != 14)) {
            return;
        }
        this.cancelTimer();
        if (this.model instanceof ButtonModelGUI) {
            if (!this.longTyped) {
                IWidgetLogChannel.logChannel.log(10000000, "ButtonController#keyReleased() keyTyped longtyped: %1", this.longTyped);
                ((ButtonModelGUI)this.model).keyTyped(this.modelID, this.getTerminalImpl().getTerminalID());
            }
            IWidgetLogChannel.logChannel.log(10000000, "ButtonController#keyReleased() keyReleased longtyped: %1", this.longTyped);
            ((ButtonModelGUI)this.model).keyReleased(this.modelID, this.getTerminalImpl().getTerminalID());
        }
        super.keyReleased(keyEvent);
    }

    public void restartTimer() {
        this.longTyped = false;
        this.cancelTimer();
        if (this.longTypedTimeout > 0) {
            if (!this.isConnected()) {
                return;
            }
            if (this.timerEvent == null) {
                this.timerEvent = new TimerEvent(this);
            }
            this.timerJob = hmiService.getEventDispatcher().postEvent(this.timerEvent, this.longTypedTimeout);
            IWidgetLogChannel.logChannel.log(10000000, "ButtonController#restartTimer()");
        }
    }

    public void cancelTimer() {
        if (this.isTimerRunning()) {
            this.timerJob.cancel();
            this.timerJob = null;
            IWidgetLogChannel.logChannel.log(10000000, "ButtonController#cancelTimer()");
        }
    }

    public void processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent.equals(this.timerEvent) && this.isTimerRunning()) {
            this.timerJob = null;
            if (this.execute()) {
                IWidgetLogChannel.logChannel.log(10000000, "ButtonController#processEvent()");
                this.longTypedTimeoutOccured();
            }
        }
    }

    private boolean isTimerRunning() {
        return this.timerJob != null && !this.timerJob.isCanceled();
    }

    private boolean execute() {
        if (!this.isConnected()) {
            return false;
        }
        return this.isEnabled();
    }

    private void longTypedTimeoutOccured() {
        IWidgetLogChannel.logChannel.log(10000000, "ButtonController#longTypedTimeoutOccured()");
        this.longTyped = true;
        ((ButtonModelGUI)this.model).keyLongTyped(this.modelID, this.getTerminalImpl().getTerminalID());
    }

    public void setButtonID(int n) {
        this.buttonID = n;
    }

    public int getButtonID() {
        return this.buttonID;
    }

    public int getCurrentVisState() {
        int n = 2;
        if ((this.widgetState & 4) != 0 && (this.widgetState & 0x20) != 0) {
            n = (this.widgetState & 0x80) != 0 ? ((this.widgetState & 8) != 0 ? 5 : 3) : ((this.widgetState & 8) != 0 ? 4 : 1);
        }
        return n;
    }
}

