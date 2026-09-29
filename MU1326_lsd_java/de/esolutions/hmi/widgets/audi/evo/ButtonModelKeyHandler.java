/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.modelaccess.ButtonModelGUI;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.IWidgetKeyHandler;

public class ButtonModelKeyHandler
implements IWidgetKeyHandler,
IWidgetLogChannel {
    public static final ButtonModelKeyHandler BUTTON_MODEL_KEY_HANDLER_INSTANCE = new ButtonModelKeyHandler();

    @Override
    public void keyPressed(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
        int n = keyEvent.getKeyCode();
        if (n != 17) {
            return;
        }
        ButtonModelGUI buttonModelGUI = this.getButtonModel(abstractWidgetController);
        if (buttonModelGUI == null) {
            return;
        }
        int n2 = abstractWidgetController.getTerminalImpl().getTerminalID();
        menuItemLogCh.log(1078071040, "ButtonModelKeyHandler#keyPressed: call model. modelID: %1, keyCode: %2", (long)buttonModelGUI.getID(), (long)n);
        buttonModelGUI.keyPressed(n, n2);
        buttonModelGUI.keyTyped(n, n2);
        keyEvent.consume(false);
    }

    @Override
    public void keyReleased(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 17) {
            return;
        }
        ButtonModelGUI buttonModelGUI = this.getButtonModel(abstractWidgetController);
        if (buttonModelGUI == null) {
            return;
        }
        int n = abstractWidgetController.getTerminalImpl().getTerminalID();
        menuItemLogCh.log(1078071040, "ButtonModelKeyHandler#keyReleased: call model. modelID: %1", (long)buttonModelGUI.getID());
        buttonModelGUI.keyReleased(0, n);
    }

    protected ButtonModelGUI getButtonModel(AbstractWidgetController abstractWidgetController) {
        Object object = abstractWidgetController.getModel();
        if (object == null) {
            menuItemLogCh.log(10000, "ButtonModelKeyHandler#getButtonModel: model is null. widget: %1", (Object)abstractWidgetController);
            return null;
        }
        if (object instanceof ButtonModelGUI) {
            return (ButtonModelGUI)object;
        }
        menuItemLogCh.log(10000, "ButtonModelKeyHandler#getButtonModel: model is not a button model. model: %1, widget: %2, Screen: %3", object, (Object)abstractWidgetController, (long)abstractWidgetController.getScreenId());
        return null;
    }

    @Override
    public void keyTurned(AbstractWidgetController abstractWidgetController, WheelButtonEvent wheelButtonEvent) {
    }

    @Override
    public void keyMoved(AbstractWidgetController abstractWidgetController, JoystickEvent joystickEvent) {
    }
}

