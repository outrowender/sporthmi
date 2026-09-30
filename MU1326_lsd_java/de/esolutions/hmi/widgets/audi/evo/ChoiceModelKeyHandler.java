/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.IWidgetKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;

public class ChoiceModelKeyHandler
implements IWidgetKeyHandler,
IWidgetLogChannel,
WidgetConstants {
    public static final ChoiceModelKeyHandler CHOICE_MODEL_HANDLER_INSTANCE = new ChoiceModelKeyHandler();

    public void keyPressed(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
        int n = keyEvent.getKeyCode();
        if (n != 17) {
            return;
        }
        ChoiceModelGUI choiceModelGUI = this.getModel(abstractWidgetController);
        if (choiceModelGUI == null) {
            return;
        }
        int n2 = this.getNewModelValue(abstractWidgetController);
        if (n2 == -1) {
            menuItemLogCh.log(100000, "ChoiceModelKeyHandler#keyPressed: don't call model because new model value would be -1. modelID: %1, keyCode: %2", (long)choiceModelGUI.getID(), (long)n);
            return;
        }
        int n3 = abstractWidgetController.getTerminalImpl().getTerminalID();
        menuItemLogCh.log(1000000, "ChoiceModelKeyHandler#keyPressed: call model. modelID: %1, new model value: %2, keyCode: %3", (long)choiceModelGUI.getID(), (long)n2, (long)n);
        choiceModelGUI.itemSelected(n2, n3);
        keyEvent.consume(false);
    }

    public void keyReleased(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
    }

    protected ChoiceModelGUI getModel(AbstractWidgetController abstractWidgetController) {
        Object object = abstractWidgetController.getModel();
        if (object == null) {
            menuItemLogCh.log(10000, "ChoiceModelKeyHandler#getModel: model is null. widget: %1", (Object)abstractWidgetController);
            return null;
        }
        if (object instanceof ChoiceModelGUI) {
            return (ChoiceModelGUI)object;
        }
        menuItemLogCh.log(10000, "ChoiceModelKeyHandler#getModel: model is not a choice model. model: %1, widget: %2", object, (Object)abstractWidgetController);
        return null;
    }

    protected int getNewModelValue(AbstractWidgetController abstractWidgetController) {
        if (abstractWidgetController instanceof MenuItemController) {
            return ((MenuItemController)abstractWidgetController).getWidgetID();
        }
        menuItemLogCh.log(10000, "ChoiceModelKeyHandler#getNewModelValue: widget has no ID. widget: %1", (Object)abstractWidgetController);
        return -1;
    }

    public void keyTurned(AbstractWidgetController abstractWidgetController, WheelButtonEvent wheelButtonEvent) {
    }

    public void keyMoved(AbstractWidgetController abstractWidgetController, JoystickEvent joystickEvent) {
    }
}

