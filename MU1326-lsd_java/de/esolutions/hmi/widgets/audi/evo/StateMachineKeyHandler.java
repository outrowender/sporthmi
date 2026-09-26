/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.IWidgetKeyHandler;

public class StateMachineKeyHandler
implements IWidgetKeyHandler,
IWidgetLogChannel {
    public static final StateMachineKeyHandler STATE_MACHINE_HANDLER_INSTANCE = new StateMachineKeyHandler();

    @Override
    public void keyPressed(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
        int n = keyEvent.getKeyCode();
        if (n != 17) {
            return;
        }
        int n2 = abstractWidgetController.getEvent();
        if (n2 != 0) {
            keyEvent.consume(false);
            if (AbstractWidget.hmiService != null) {
                int n3 = abstractWidgetController.getTerminalImpl().getTerminalID();
                AbstractWidget.hmiService.fireSMEvent(n3, n2);
            }
        } else {
            menuItemLogCh.log(1078071040, "StateMachineKeyHandler#keyPressed no event configured, keyPressed event is not processed and not consumed");
        }
    }

    @Override
    public void keyReleased(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
    }

    @Override
    public void keyTurned(AbstractWidgetController abstractWidgetController, WheelButtonEvent wheelButtonEvent) {
    }

    @Override
    public void keyMoved(AbstractWidgetController abstractWidgetController, JoystickEvent joystickEvent) {
    }
}

