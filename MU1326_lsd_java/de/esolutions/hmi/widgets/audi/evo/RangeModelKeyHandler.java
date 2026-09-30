/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.ButtonModelKeyHandler;

public class RangeModelKeyHandler
extends ButtonModelKeyHandler {
    public static final RangeModelKeyHandler RANGE_MODEL_KEY_HANDLER_INSTANCE = new RangeModelKeyHandler();
    private boolean checkRangeLimits = true;
    private boolean handlePressReleaseEvents = true;

    public RangeModelKeyHandler() {
    }

    public RangeModelKeyHandler(boolean bl, boolean bl2) {
        this.handlePressReleaseEvents = bl;
        this.checkRangeLimits = bl2;
    }

    public void keyTurned(AbstractWidgetController abstractWidgetController, WheelButtonEvent wheelButtonEvent) {
        int n;
        boolean bl;
        int n2 = wheelButtonEvent.getDirection();
        int n3 = wheelButtonEvent.getClickCount();
        RangeModelGUI rangeModelGUI = this.getRangeModel(abstractWidgetController);
        if (rangeModelGUI == null) {
            return;
        }
        menuItemLogCh.log(1000000, "RangeModelKeyHandler#keyTurned: modelID: %1, clickCount: %2, direction: %3", (long)rangeModelGUI.getID(), (long)n3, (long)n2);
        n3 *= rangeModelGUI.getStep();
        int n4 = rangeModelGUI.getValue();
        boolean bl2 = bl = n2 == 0;
        if (this.checkRangeLimits) {
            n = bl ? rangeModelGUI.getMaximum() : rangeModelGUI.getMinimum();
            int n5 = bl ? n - n4 : n4 - n;
            if ((n5 = Math.max(0, n5)) < n3) {
                menuItemLogCh.log(10000000, "RangeModelKeyHandler#keyTurned range limit %1 reached. Reduce clickCount to: %2", (long)n, (long)n5);
                n3 = n5;
            }
        }
        if (n3 == 0) {
            wheelButtonEvent.consume(false);
            return;
        }
        n = abstractWidgetController.getTerminalImpl().getTerminalID();
        if (bl) {
            menuItemLogCh.log(10000000, "RangeModelKeyHandler#keyTurned calling increment at rangeModel with id: %1 clickCount: %2", (long)rangeModelGUI.getID(), (long)n3);
            rangeModelGUI.increment(n3, n);
        } else {
            menuItemLogCh.log(10000000, "RangeModelKeyHandler#keyTurned calling decrement at rangeModel with id: %1 clickCount: %2", (long)rangeModelGUI.getID(), (long)n3);
            rangeModelGUI.decrement(n3, n);
        }
        wheelButtonEvent.consume(false);
    }

    public void keyPressed(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
        if (this.handlePressReleaseEvents) {
            super.keyPressed(abstractWidgetController, keyEvent);
        }
    }

    public void keyReleased(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
        if (this.handlePressReleaseEvents) {
            super.keyReleased(abstractWidgetController, keyEvent);
        }
    }

    protected RangeModelGUI getRangeModel(AbstractWidgetController abstractWidgetController) {
        Object object = abstractWidgetController.getModel();
        if (object == null) {
            menuItemLogCh.log(10000, "RangeModelKeyHandler#getModel: model is null. widget: %1", (Object)abstractWidgetController);
            return null;
        }
        if (object instanceof RangeModelGUI) {
            return (RangeModelGUI)object;
        }
        menuItemLogCh.log(10000, "RangeModelKeyHandler#getModel: model is not a range model. model: %1, widget: %2", object, (Object)abstractWidgetController);
        return null;
    }

    public boolean isCheckRangeLimits() {
        return this.checkRangeLimits;
    }

    public boolean isHandlePressReleaseEvents() {
        return this.handlePressReleaseEvents;
    }
}

