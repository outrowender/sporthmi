/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.atip.hmi.model.DefaultVirtualButtonListener;
import de.audi.tv.app.tm.UserInputModeHandler;
import de.audi.tv.app.tm.UserInputModeHandler$1;

class UserInputModeHandler$BackVirtualButtonListener
extends DefaultVirtualButtonListener {
    private final /* synthetic */ UserInputModeHandler this$0;

    private UserInputModeHandler$BackVirtualButtonListener(UserInputModeHandler userInputModeHandler) {
        this.this$0 = userInputModeHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        int n4 = this.this$0.getCurrentMode();
        UserInputModeHandler.access$300((UserInputModeHandler)this.this$0).lcHMI.log(-2137614336, "[UserInputModeHandler.keyTyped] HK back pressed, mode: %1", (long)n4);
        if (n4 == 0) {
            this.this$0.changeUserInputMode(1);
        } else {
            UserInputModeHandler.access$300((UserInputModeHandler)this.this$0).properties.terminalMode.desiredTerminalMode.accept(new Integer(0));
            UserInputModeHandler.access$300(this.this$0).getVirtualButtonModelModel(n).fireEvent(n3);
        }
    }

    /* synthetic */ UserInputModeHandler$BackVirtualButtonListener(UserInputModeHandler userInputModeHandler, UserInputModeHandler$1 userInputModeHandler$1) {
        this(userInputModeHandler);
    }
}

