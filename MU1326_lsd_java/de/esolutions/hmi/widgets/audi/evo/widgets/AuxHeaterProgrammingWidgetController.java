/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractTimeDateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DateSettingsWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TimeSettingsWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;

public class AuxHeaterProgrammingWidgetController
extends MenuItemController {
    TimeSettingsWidgetController time;
    DateSettingsWidgetController date;
    boolean pressed = false;

    public void add(AbstractWidget abstractWidget) {
        super.add(abstractWidget);
        if (abstractWidget instanceof TimeSettingsWidgetController) {
            this.time = (TimeSettingsWidgetController)abstractWidget;
        } else if (abstractWidget instanceof DateSettingsWidgetController) {
            this.date = (DateSettingsWidgetController)abstractWidget;
        }
    }

    public void connected(InitializationContext initializationContext) {
        menuItemLogCh.log(10000000, "AuxiliaryHeaterProgrammingWidgetController#connected");
        super.connected(initializationContext);
        if (!this.date.isDateValid()) {
            menuItemLogCh.log(1000000, "AuxiliaryHeaterProgrammingWidgetController#connected Date seems to be not valid (%1)! Date is reset to reference calendar.", (Object)this.date.getCalendar().getTime());
            AbstractTimeDateController.writeDataToModel(this.getModel(), DateSettingsWidgetController.getReferenceCalendar(), this.terminal.getTerminalID());
        }
    }

    public void disconnecting() {
        if (this.isHighlighted()) {
            this.setHighlighted(false);
        }
        this.time.exitEditableModeWithoutSavings();
        this.date.exitEditableModeWithoutSavings();
        super.disconnecting();
    }

    public int getCurrentVisState() {
        int n = 2;
        if ((this.widgetState & 4) != 0 && (this.widgetState & 0x20) != 0) {
            n = (this.widgetState & 8) != 0 ? 3 : 1;
        }
        return n;
    }

    public void keyPressed(KeyEvent keyEvent) {
        menuItemLogCh.log(10000000, "AuxiliaryHeaterProgrammingWidgetController#keyPressed KeyCode = %1", (long)keyEvent.getKeyCode());
        if (keyEvent.getKeyCode() == 17) {
            this.pressed = true;
            keyEvent.consume();
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        menuItemLogCh.log(10000000, "AuxiliaryHeaterProgrammingWidgetController#keyReleased KeyCode = %1", (long)keyEvent.getKeyCode());
        if (this.pressed && keyEvent.getKeyCode() == 17) {
            if (this.getCurrentVisState() == 1) {
                this.setHighlighted(true);
                this.time.enterEditableMode();
            } else if (this.getCurrentVisState() == 3) {
                if (this.time.getCursorPos() == TimeSettingsWidgetController.cursorPosHours) {
                    this.time.cursorPosition = TimeSettingsWidgetController.cursorPosMinutes;
                } else if (this.time.getCursorPos() == TimeSettingsWidgetController.cursorPosMinutes) {
                    this.time.exitEditableMode();
                    this.date.enterEditableMode();
                } else if (this.date.getCursorPos() == DateSettingsWidgetController.cursorPosDay) {
                    this.setHighlighted(false);
                    this.date.exitEditableMode();
                }
            }
            this.setCompositesDirty(true);
            this.time.setCompositesDirty(true);
            this.date.setCompositesDirty(true);
        }
        this.pressed = false;
        keyEvent.consume();
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        if (this.getCurrentVisState() == 3) {
            if (wheelButtonEvent.getClickCount() == 0) {
                wheelButtonEvent.consume(false);
                return;
            }
            if (this.time.getCurrentVisState() == 3) {
                this.time.keyTurned(wheelButtonEvent);
            } else {
                this.date.keyTurned(wheelButtonEvent);
            }
            wheelButtonEvent.consume();
        }
    }

    public void setEnabled(boolean bl) {
        if (!bl) {
            this.setHighlighted(false);
        }
        super.setEnabled(bl);
    }
}

