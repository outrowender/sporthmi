/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.IWidgetKeyHandler;

public class DecoratorKeyHandler
implements IWidgetKeyHandler {
    private final IWidgetKeyHandler keyHandler;

    public DecoratorKeyHandler(IWidgetKeyHandler iWidgetKeyHandler) {
        this.keyHandler = iWidgetKeyHandler;
    }

    public IWidgetKeyHandler getKeyHandler() {
        return this.keyHandler;
    }

    public void keyPressed(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
        if (this.keyHandler != null) {
            this.keyHandler.keyPressed(abstractWidgetController, keyEvent);
        }
    }

    public void keyReleased(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
        if (this.keyHandler != null) {
            this.keyHandler.keyReleased(abstractWidgetController, keyEvent);
        }
    }

    public void keyTurned(AbstractWidgetController abstractWidgetController, WheelButtonEvent wheelButtonEvent) {
        if (this.keyHandler != null) {
            this.keyHandler.keyTurned(abstractWidgetController, wheelButtonEvent);
        }
    }

    public void keyMoved(AbstractWidgetController abstractWidgetController, JoystickEvent joystickEvent) {
        if (this.keyHandler != null) {
            this.keyHandler.keyMoved(abstractWidgetController, joystickEvent);
        }
    }

    public String toString() {
        String string = super.toString();
        if (this.keyHandler != null) {
            return string + " [delegate: " + this.keyHandler + "]";
        }
        return string + " [no delegate]";
    }
}

