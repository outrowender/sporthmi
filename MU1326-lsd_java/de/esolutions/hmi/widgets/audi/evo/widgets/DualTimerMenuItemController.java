/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.KeyEvent;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.TimeSettingsWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;

public class DualTimerMenuItemController
extends MenuItemController {
    TimeSettingsWidgetController startTimeSettings = null;
    TimeSettingsWidgetController endTimeSettings = null;
    private static final int STATE_UNSELECTED;
    private static final int STATE_START_HOUR;
    private static final int STATE_START_MINUTE;
    private static final int STATE_END_HOUR;
    private static final int STATE_END_MINUTE;
    private int selectionState = 0;

    @Override
    public void add(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof TimeSettingsWidgetController) {
            if (this.startTimeSettings == null) {
                this.startTimeSettings = (TimeSettingsWidgetController)abstractWidget;
            } else if (this.endTimeSettings == null) {
                this.endTimeSettings = (TimeSettingsWidgetController)abstractWidget;
            }
        }
        super.add(abstractWidget);
    }

    @Override
    public void disconnecting() {
        this.processBack(new KeyEvent(null, 0, 15, this.startTimeSettings.getTerminal().getTerminalID()));
        super.disconnecting();
    }

    private KeyEvent generateEnter(KeyEvent keyEvent) {
        return new KeyEvent(null, keyEvent.getID(), 17, keyEvent.getTerminalID());
    }

    private KeyEvent generateBack(KeyEvent keyEvent) {
        return new KeyEvent(null, keyEvent.getID(), 15, keyEvent.getTerminalID());
    }

    private void processEnter(KeyEvent keyEvent) {
        switch (this.selectionState) {
            case 0: {
                this.startTimeSettings.keyPressed(this.generateEnter(keyEvent));
                this.startTimeSettings.keyReleased(this.generateEnter(keyEvent));
                this.selectionState = 1;
                keyEvent.consume();
                break;
            }
            case 1: {
                this.startTimeSettings.keyPressed(this.generateEnter(keyEvent));
                this.startTimeSettings.keyReleased(this.generateEnter(keyEvent));
                this.selectionState = 2;
                keyEvent.consume();
                break;
            }
            case 2: {
                this.startTimeSettings.keyPressed(this.generateEnter(keyEvent));
                this.startTimeSettings.keyReleased(this.generateEnter(keyEvent));
                this.endTimeSettings.keyPressed(this.generateEnter(keyEvent));
                this.endTimeSettings.keyReleased(this.generateEnter(keyEvent));
                this.selectionState = 3;
                keyEvent.consume();
                break;
            }
            case 3: {
                this.endTimeSettings.keyPressed(this.generateEnter(keyEvent));
                this.endTimeSettings.keyReleased(this.generateEnter(keyEvent));
                this.selectionState = 4;
                keyEvent.consume();
                break;
            }
            case 4: {
                this.endTimeSettings.keyPressed(this.generateEnter(keyEvent));
                this.endTimeSettings.keyReleased(this.generateEnter(keyEvent));
                this.selectionState = 0;
                keyEvent.consume();
                break;
            }
        }
    }

    private void processBack(KeyEvent keyEvent) {
        this.startTimeSettings.keyPressed(this.generateBack(keyEvent));
        this.startTimeSettings.keyReleased(this.generateBack(keyEvent));
        this.startTimeSettings.keyPressed(this.generateBack(keyEvent));
        this.startTimeSettings.keyReleased(this.generateBack(keyEvent));
        this.endTimeSettings.keyPressed(this.generateBack(keyEvent));
        this.endTimeSettings.keyReleased(this.generateBack(keyEvent));
        this.endTimeSettings.keyPressed(this.generateBack(keyEvent));
        this.endTimeSettings.keyReleased(this.generateBack(keyEvent));
        this.selectionState = 0;
        keyEvent.consume();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 17: {
                this.processEnter(keyEvent);
                break;
            }
            case 15: {
                this.processBack(keyEvent);
                break;
            }
        }
    }

    public String toString() {
        return "DualTimerController";
    }

    @Override
    public String getDiagnosisText() {
        return "DualTimerController";
    }
}

