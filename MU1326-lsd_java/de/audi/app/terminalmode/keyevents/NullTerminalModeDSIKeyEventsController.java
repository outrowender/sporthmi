/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.keyevents;

import de.audi.app.terminalmode.keyevents.ITerminalModeDSIKeyEventsController;
import de.audi.app.terminalmode.keyevents.Key;
import de.audi.app.terminalmode.keyevents.KeyState;
import de.audi.app.terminalmode.keyevents.TouchEvent;
import de.audi.atip.log.LogChannel;

public class NullTerminalModeDSIKeyEventsController
implements ITerminalModeDSIKeyEventsController {
    private static final String LOGCLASS;
    private final LogChannel logger;

    public NullTerminalModeDSIKeyEventsController(LogChannel logChannel) {
        this.logger = logChannel;
    }

    @Override
    public void updateKey(Key key, KeyState keyState) {
        this.logger.log(1078071040, "[%1.updateKey]", (Object)"NullTerminalModeDSIKeyEventsController");
    }

    @Override
    public void updateTouchEvents(TouchEvent[] touchEventArray) {
        this.logger.log(1078071040, "[%1.updateTouchEvents]", (Object)"NullTerminalModeDSIKeyEventsController");
    }

    public void updateTouchEvent(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.logger.log(1078071040, "[%1.updateTouchEvent]", (Object)"NullTerminalModeDSIKeyEventsController");
    }

    @Override
    public void updateRotary(int n) {
        this.logger.log(1078071040, "[%1.updateRotary]", (Object)"NullTerminalModeDSIKeyEventsController");
    }

    @Override
    public void updateCharacterEvent(String[] stringArray, int[] nArray) {
        this.logger.log(1078071040, "[%1.updateCharacterEvent]", (Object)"NullTerminalModeDSIKeyEventsController");
    }
}

