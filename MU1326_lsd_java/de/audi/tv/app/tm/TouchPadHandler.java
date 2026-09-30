/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.atip.statemachine.ap.TVActionProxy;
import de.audi.tv.app.ap.TVActionProxyDefaultListenerEvo;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.tm.ITouchpadHandler;
import de.audi.tv.app.tm.UserInputModeHandler;

public class TouchPadHandler
extends UserInputModeHandler
implements ITouchpadHandler {
    public final TVActionProxy apListener = new ActionProxyListener();

    public TouchPadHandler(TVEnv tVEnv, TVEventDispatcher tVEventDispatcher) {
        super(tVEnv, tVEventDispatcher);
    }

    public short jsWest() {
        if (this.getCurrentMode() == 0) {
            this.changeUserInputMode(1);
            return -1;
        }
        return 14;
    }

    public short jsEast() {
        if (this.getCurrentMode() == 0) {
            this.changeUserInputMode(1);
            return -1;
        }
        return 15;
    }

    public short jsNorth() {
        if (this.getCurrentMode() == 0) {
            this.changeUserInputMode(1);
            return -1;
        }
        return 12;
    }

    public short jsSouth() {
        if (this.getCurrentMode() == 0) {
            this.changeUserInputMode(1);
            return -1;
        }
        return 13;
    }

    public short touchScreenPressed() {
        return -1;
    }

    public short touchScreenReleased() {
        return -1;
    }

    public short keyPressed() {
        if (this.getCurrentMode() == 1) {
            return 6;
        }
        return -1;
    }

    public short keyReleased() {
        if (this.getCurrentMode() == 1) {
            return 6;
        }
        return -1;
    }

    public short increment() {
        if (this.getCurrentMode() == 1) {
            this.changeUserInputMode(0);
        }
        return -1;
    }

    public short decrement() {
        if (this.getCurrentMode() == 1) {
            this.changeUserInputMode(0);
        }
        return -1;
    }

    private class ActionProxyListener
    extends TVActionProxyDefaultListenerEvo {
        private ActionProxyListener() {
        }

        public void tvCasDisclaimerEntered(int n) {
            TouchPadHandler.this.changeUserInputMode(0);
        }

        public void tvDataBroadcastEntered(int n) {
            TouchPadHandler.this.changeUserInputMode(0);
        }

        public void tvEngineeringEntered(int n) {
            TouchPadHandler.this.changeUserInputMode(0);
        }

        public void tvEPGEntered(int n) {
            TouchPadHandler.this.changeUserInputMode(0);
        }

        public void tvTeletextEntered(int n) {
            TouchPadHandler.this.changeUserInputMode(0);
        }

        public void tvVisualAudioEntered(int n) {
            TouchPadHandler.this.changeUserInputMode(0);
        }
    }
}

