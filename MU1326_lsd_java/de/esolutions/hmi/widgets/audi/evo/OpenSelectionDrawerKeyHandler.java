/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.IWidgetKeyHandler;

public class OpenSelectionDrawerKeyHandler
implements IWidgetKeyHandler,
IWidgetLogChannel {
    public static final OpenSelectionDrawerKeyHandler OPEN_SELECTION_DRAWER_KEY_HANDLER_INSTANCE = new OpenSelectionDrawerKeyHandler();

    @Override
    public void keyPressed(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
        int n = keyEvent.getKeyCode();
        if (n != 17) {
            return;
        }
        HMITerminalEvo hMITerminalEvo = (HMITerminalEvo)abstractWidgetController.getTerminal();
        IDrawerFocusManagerEvo iDrawerFocusManagerEvo = hMITerminalEvo.getDrawerFocusManager();
        menuItemLogCh.log(-2137614336, "OpenSelectionDrawerKeyHandler#keyPressed: key pressed, open selection drawer");
        boolean bl = iDrawerFocusManagerEvo.requestDrawerState(4);
        if (!bl) {
            menuItemLogCh.log(-1601830656, "OpenSelectionDrawerKeyHandler#keyPressed: open selection drawer failed");
        }
        keyEvent.consume();
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

