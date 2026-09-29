/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$TerminalModeDSIKeyEventsController;
import java.util.Comparator;
import org.dsi.ifc.carplay.TouchEvent;

class CarplayDSILifecycleController$TerminalModeDSIKeyEventsController$1
implements Comparator {
    private final /* synthetic */ CarplayDSILifecycleController$TerminalModeDSIKeyEventsController this$1;

    CarplayDSILifecycleController$TerminalModeDSIKeyEventsController$1(CarplayDSILifecycleController$TerminalModeDSIKeyEventsController carplayDSILifecycleController$TerminalModeDSIKeyEventsController) {
        this.this$1 = carplayDSILifecycleController$TerminalModeDSIKeyEventsController;
    }

    @Override
    public int compare(Object object, Object object2) {
        TouchEvent touchEvent = (TouchEvent)object;
        TouchEvent touchEvent2 = (TouchEvent)object2;
        return touchEvent.getX() - touchEvent2.getX();
    }
}

