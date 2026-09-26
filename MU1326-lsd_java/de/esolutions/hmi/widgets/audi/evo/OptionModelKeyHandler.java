/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.modelaccess.OptionModelGUI;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IDrawerConditionEngine;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.IWidgetKeyHandler;

public class OptionModelKeyHandler
implements IWidgetKeyHandler,
IWidgetLogChannel {
    public static final OptionModelKeyHandler OPTION_MODEL_KEY_HANDLER_INSTANCE = new OptionModelKeyHandler();

    @Override
    public void keyPressed(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
        int n = keyEvent.getKeyCode();
        if (n != 17) {
            return;
        }
        OptionModelGUI optionModelGUI = this.getOptionModel(abstractWidgetController);
        if (optionModelGUI == null) {
            return;
        }
        HMITerminalEvo hMITerminalEvo = (HMITerminalEvo)abstractWidgetController.getTerminal();
        int n2 = hMITerminalEvo.getTerminalID();
        IDrawerConditionEngine iDrawerConditionEngine = hMITerminalEvo.getDrawerConditionEngine();
        if (iDrawerConditionEngine != null) {
            int n3 = iDrawerConditionEngine.getTargetModelID();
            int n4 = iDrawerConditionEngine.getTargetRow();
            int n5 = iDrawerConditionEngine.getTargetWidgetID();
            logDrawerCondtionEngine.log(-2137614336, "OptionModelKeyHandler#keyPressed: call model. modelID: %1, targetModelID: %2, targetRow: %3", (long)optionModelGUI.getID(), (long)n3, (long)n4);
            optionModelGUI.keyPressed(n3, n4, n5, n2);
            optionModelGUI.keyTyped(n3, n4, n5, n2);
        } else {
            logDrawerCondtionEngine.log(10000, "OptionModelKeyHandler#keyPressed drawerConditionEngine is null - model is NOT called.");
        }
        keyEvent.consume(false);
    }

    @Override
    public void keyReleased(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 17) {
            return;
        }
        OptionModelGUI optionModelGUI = this.getOptionModel(abstractWidgetController);
        if (optionModelGUI == null) {
            return;
        }
        HMITerminalEvo hMITerminalEvo = (HMITerminalEvo)abstractWidgetController.getTerminal();
        IDrawerConditionEngine iDrawerConditionEngine = hMITerminalEvo.getDrawerConditionEngine();
        if (iDrawerConditionEngine != null) {
            int n = iDrawerConditionEngine.getTargetModelID();
            int n2 = iDrawerConditionEngine.getTargetRow();
            int n3 = iDrawerConditionEngine.getTargetWidgetID();
            logDrawerCondtionEngine.log(-2137614336, "OptionModelKeyHandler#keyReleased: call model. modelID: %1, targetModelID: %2, targetRow: %3", (long)optionModelGUI.getID(), (long)n, (long)n2);
            optionModelGUI.keyReleased(n, n2, n3, hMITerminalEvo.getTerminalID());
        } else {
            logDrawerCondtionEngine.log(10000, "OptionModelKeyHandler#keyReleased drawerConditionEngine is null - model is NOT called.");
        }
    }

    protected OptionModelGUI getOptionModel(AbstractWidgetController abstractWidgetController) {
        Object object = abstractWidgetController.getModel();
        if (object == null) {
            logDrawerCondtionEngine.log(10000, "OptionModelKeyHandler#getModel: model is null. widget: %1", (Object)abstractWidgetController);
            return null;
        }
        if (object instanceof OptionModelGUI) {
            return (OptionModelGUI)object;
        }
        logDrawerCondtionEngine.log(10000, "OptionModelKeyHandler#getModel: model is not a option model. model: %1, widget: %2", object, (Object)abstractWidgetController);
        return null;
    }

    @Override
    public void keyTurned(AbstractWidgetController abstractWidgetController, WheelButtonEvent wheelButtonEvent) {
    }

    @Override
    public void keyMoved(AbstractWidgetController abstractWidgetController, JoystickEvent joystickEvent) {
    }
}

