/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.atip.hmi.model.DefaultVirtualButtonListener;
import de.audi.tv.app.tm.UserInputModeHandler;
import de.audi.tv.app.tm.UserInputModeHandler$1;

class UserInputModeHandler$JoystickWestVirtualButtonListener
extends DefaultVirtualButtonListener {
    private final /* synthetic */ UserInputModeHandler this$0;

    private UserInputModeHandler$JoystickWestVirtualButtonListener(UserInputModeHandler userInputModeHandler) {
        this.this$0 = userInputModeHandler;
    }

    @Override
    public void stickW(int n, int n2) {
        int n3 = this.this$0.getCurrentMode();
        UserInputModeHandler.access$300((UserInputModeHandler)this.this$0).lcHMI.log(-2137614336, "[UserInputModeHandler.keyTyped] Joystick west pressed, mode: %1", (long)n3);
        UserInputModeHandler.access$300((UserInputModeHandler)this.this$0).properties.terminalMode.desiredTerminalMode.accept(new Integer(0));
        UserInputModeHandler.access$300(this.this$0).getVirtualButtonModelModel(n).fireEvent(n2);
    }

    /* synthetic */ UserInputModeHandler$JoystickWestVirtualButtonListener(UserInputModeHandler userInputModeHandler, UserInputModeHandler$1 userInputModeHandler$1) {
        this(userInputModeHandler);
    }
}

