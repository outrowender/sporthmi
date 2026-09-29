/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.atip.statemachine.ap.TVActionProxy;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.tm.ITouchpadHandler;
import de.audi.tv.app.tm.TouchPadHandler$ActionProxyListener;
import de.audi.tv.app.tm.UserInputModeHandler;

public class TouchPadHandler
extends UserInputModeHandler
implements ITouchpadHandler {
    public final TVActionProxy apListener = new TouchPadHandler$ActionProxyListener(this, null);

    public TouchPadHandler(TVEnv tVEnv, TVEventDispatcher tVEventDispatcher) {
        super(tVEnv, tVEventDispatcher);
    }

    @Override
    public short jsWest() {
        if (this.getCurrentMode() == 0) {
            this.changeUserInputMode(1);
            return -1;
        }
        return 14;
    }

    @Override
    public short jsEast() {
        if (this.getCurrentMode() == 0) {
            this.changeUserInputMode(1);
            return -1;
        }
        return 15;
    }

    @Override
    public short jsNorth() {
        if (this.getCurrentMode() == 0) {
            this.changeUserInputMode(1);
            return -1;
        }
        return 12;
    }

    @Override
    public short jsSouth() {
        if (this.getCurrentMode() == 0) {
            this.changeUserInputMode(1);
            return -1;
        }
        return 13;
    }

    @Override
    public short touchScreenPressed() {
        return -1;
    }

    @Override
    public short touchScreenReleased() {
        return -1;
    }

    @Override
    public short keyPressed() {
        if (this.getCurrentMode() == 1) {
            return 6;
        }
        return -1;
    }

    @Override
    public short keyReleased() {
        if (this.getCurrentMode() == 1) {
            return 6;
        }
        return -1;
    }

    @Override
    public short increment() {
        if (this.getCurrentMode() == 1) {
            this.changeUserInputMode(0);
        }
        return -1;
    }

    @Override
    public short decrement() {
        if (this.getCurrentMode() == 1) {
            this.changeUserInputMode(0);
        }
        return -1;
    }
}

