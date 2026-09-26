/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.hmi;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.KeyListener;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.kbd.hmi.VirtualGUIManager;
import de.audi.kbd.hmi.VirtualGUIManager$1;

class VirtualGUIManager$DefaultVirtualButtonHandler
implements KeyListener {
    private final /* synthetic */ VirtualGUIManager this$0;

    private VirtualGUIManager$DefaultVirtualButtonHandler(VirtualGUIManager virtualGUIManager) {
        this.this$0 = virtualGUIManager;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        VirtualGUIManager.access$100(this.this$0).log(1078071040, "DefaultVirtualButtonHandler.keyPressed: No virtual button! (evenz=%1)", (Object)keyEvent);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        VirtualGUIManager.access$100(this.this$0).log(1078071040, "DefaultVirtualButtonHandler.keyReleased: No virtual button! (evenz=%1)", (Object)keyEvent);
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        VirtualGUIManager.access$100(this.this$0).log(1078071040, "DefaultVirtualButtonHandler.keyTurned: No virtual button! (evenz=%1)", (Object)wheelButtonEvent);
    }

    @Override
    public void keyMoved(JoystickEvent joystickEvent) {
        VirtualGUIManager.access$100(this.this$0).log(1078071040, "DefaultVirtualButtonHandler.keyMoved: No virtual button! (evenz=%1)", (Object)joystickEvent);
    }

    /* synthetic */ VirtualGUIManager$DefaultVirtualButtonHandler(VirtualGUIManager virtualGUIManager, VirtualGUIManager$1 virtualGUIManager$1) {
        this(virtualGUIManager);
    }
}

