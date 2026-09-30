/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IDrawerConditionEngine;
import de.audi.tghu.hmi.evo.IRightDrawerActionReceiver;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.IWidgetKeyHandler;

public class RightDrawerActionKeyHandler
implements IWidgetKeyHandler,
IWidgetLogChannel {
    private int actionID = -1;

    public RightDrawerActionKeyHandler(int n) {
        this.actionID = n;
    }

    public void keyPressed(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
        int n = keyEvent.getKeyCode();
        if (n != 17) {
            return;
        }
        HMITerminalEvo hMITerminalEvo = (HMITerminalEvo)abstractWidgetController.getTerminal();
        IDrawerConditionEngine iDrawerConditionEngine = hMITerminalEvo.getDrawerConditionEngine();
        if (iDrawerConditionEngine != null) {
            IRightDrawerActionReceiver iRightDrawerActionReceiver = iDrawerConditionEngine.getTargetActionReceiver();
            logDrawerCondtionEngine.log(10000000, "OptionModelKeyHandler#keyPressed: call touchField (%1) to execute an action (actionId=%2)", (Object)iRightDrawerActionReceiver, (long)this.actionID);
            if (iRightDrawerActionReceiver != null) {
                iRightDrawerActionReceiver.executeAction(this.actionID);
            }
        } else {
            logDrawerCondtionEngine.log(10000, "OptionModelKeyHandler#keyPressed drawerConditionEngine is null - widget is NOT called.");
        }
        keyEvent.consume(false);
    }

    public void keyReleased(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
    }

    public void keyTurned(AbstractWidgetController abstractWidgetController, WheelButtonEvent wheelButtonEvent) {
    }

    public void keyMoved(AbstractWidgetController abstractWidgetController, JoystickEvent joystickEvent) {
    }
}

