/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.hmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.KeyListener;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.modelaccess.ButtonModelGUI;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.audi.atip.log.LogChannel;
import java.util.Vector;

public final class VirtualButtonHandler
implements KeyListener {
    private final IFrameworkAccess framework;
    private final LogChannel logButtonHandler;
    private final Vector models = new Vector();
    private final int buttonId;

    public VirtualButtonHandler(IFrameworkAccess iFrameworkAccess, int n) {
        this.framework = iFrameworkAccess;
        this.buttonId = n;
        this.logButtonHandler = this.framework.getLogChannel("Fw.Kbd.VirtualButtonHandler");
    }

    public int getVirtualButtonID() {
        return this.buttonId;
    }

    public void addModel(ButtonModelGUI buttonModelGUI) {
        this.models.add(buttonModelGUI);
    }

    public void removeModel(ButtonModelGUI buttonModelGUI) {
        this.models.remove(buttonModelGUI);
    }

    public void keyPressed(KeyEvent keyEvent) {
        if (this.models != null) {
            this.logButtonHandler.log(10000000, "VirtualButtonHandler.keyPressed(%1)", (Object)keyEvent);
            Object[] objectArray = this.models.toArray();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                ButtonModelGUI buttonModelGUI = (ButtonModelGUI)objectArray[i2];
                this.logButtonHandler.log(1000000, "VirtualButtonHandler.keyPressed: Inform listener! (id=%1)", (long)buttonModelGUI.getID());
                buttonModelGUI.keyPressed(keyEvent.getKeyCode(), keyEvent.getTerminalID());
                buttonModelGUI.keyTyped(keyEvent.getKeyCode(), keyEvent.getTerminalID());
            }
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        if (this.models != null) {
            this.logButtonHandler.log(10000000, "VirtualButtonHandler.keyReleased(%1)", (Object)keyEvent);
            Object[] objectArray = this.models.toArray();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                ButtonModelGUI buttonModelGUI = (ButtonModelGUI)objectArray[i2];
                this.logButtonHandler.log(1000000, "VirtualButtonHandler.keyReleased: Inform listener! (id=%1)", (long)buttonModelGUI.getID());
                buttonModelGUI.keyReleased(keyEvent.getKeyCode(), keyEvent.getTerminalID());
            }
        }
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        if (this.models != null) {
            this.logButtonHandler.log(10000000, "VirtualButtonHandler.keyTurned(%1)", (Object)wheelButtonEvent);
            Object[] objectArray = this.models.toArray();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                ButtonModelGUI buttonModelGUI = (ButtonModelGUI)objectArray[i2];
                this.logButtonHandler.log(1000000, "VirtualButtonHandler.keyTurned: Inform listener! (id=%1)", (long)buttonModelGUI.getID());
                if (!(buttonModelGUI instanceof RangeModelGUI)) continue;
                if (wheelButtonEvent.getDirection() == 1) {
                    ((RangeModelGUI)buttonModelGUI).decrement(wheelButtonEvent.getClickCount(), wheelButtonEvent.getTerminalID());
                    continue;
                }
                ((RangeModelGUI)buttonModelGUI).increment(wheelButtonEvent.getClickCount(), wheelButtonEvent.getTerminalID());
            }
        }
    }

    public void keyMoved(JoystickEvent joystickEvent) {
    }
}

