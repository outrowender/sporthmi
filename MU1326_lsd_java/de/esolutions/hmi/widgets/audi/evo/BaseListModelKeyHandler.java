/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.ButtonModelKeyHandler;

public class BaseListModelKeyHandler
extends ButtonModelKeyHandler {
    public static final BaseListModelKeyHandler BASE_LIST_MODEL_KEY_HANDLER_INSTANCE = new BaseListModelKeyHandler();
    private boolean checkRangeLimits = true;
    private boolean handlePressReleaseEvents = true;
    private int currentValue;

    public BaseListModelKeyHandler() {
    }

    public BaseListModelKeyHandler(boolean bl, boolean bl2) {
        this.handlePressReleaseEvents = bl;
        this.checkRangeLimits = bl2;
    }

    @Override
    public void keyTurned(AbstractWidgetController abstractWidgetController, WheelButtonEvent wheelButtonEvent) {
        int n;
        boolean bl;
        int n2 = wheelButtonEvent.getDirection();
        int n3 = wheelButtonEvent.getClickCount();
        BaseListModel baseListModel = this.getBaseListModel(abstractWidgetController);
        if (baseListModel == null) {
            return;
        }
        menuItemLogCh.log(1078071040, "BaseListModelKeyHandler#keyTurned: modelID: %1, clickCount: %2, direction: %3", (long)baseListModel.getID(), (long)n3, (long)n2);
        this.currentValue = baseListModel.getSelected() != null ? baseListModel.getSelected().getIndex() : 0;
        int n4 = baseListModel.getLength() - 1;
        boolean bl2 = bl = n2 == 0;
        if (this.checkRangeLimits) {
            n = bl ? n4 : 0;
            int n5 = bl ? n - this.currentValue : this.currentValue - n;
            if ((n5 = Math.max(0, n5)) < n3) {
                menuItemLogCh.log(-2137614336, "BaseListModelKeyHandler#keyTurned range limit %1 reached. Reduce clickCount to: %2", (long)n, (long)n5);
                n3 = n5;
            }
        }
        if (n3 == 0) {
            wheelButtonEvent.consume(false);
            return;
        }
        n = abstractWidgetController.getTerminalImpl().getTerminalID();
        if (bl) {
            menuItemLogCh.log(-2137614336, "BaseListModelKeyHandler#keyTurned calling increment at rangeModel with id: %1 clickCount: %2", (long)baseListModel.getID(), (long)n3);
            if (this.currentValue == n4) {
                wheelButtonEvent.consume(false);
                return;
            }
            this.currentValue += n3;
            if (this.currentValue > n4) {
                this.currentValue = n4;
                EvoListRow evoListRow = baseListModel.getRow(this.currentValue);
                baseListModel.itemFocused(evoListRow.getUniqueID(), 0, n);
                wheelButtonEvent.consume(false);
                return;
            }
            EvoListRow evoListRow = baseListModel.getRow(this.currentValue);
            baseListModel.itemFocused(evoListRow.getUniqueID(), 0, n);
        } else {
            menuItemLogCh.log(-2137614336, "BaseListModelKeyHandler#keyTurned calling decrement at rangeModel with id: %1 clickCount: %2", (long)baseListModel.getID(), (long)n3);
            if (this.currentValue == 0) {
                wheelButtonEvent.consume(false);
                return;
            }
            this.currentValue -= n3;
            if (this.currentValue < 0) {
                this.currentValue = 0;
                EvoListRow evoListRow = baseListModel.getRow(this.currentValue);
                baseListModel.itemFocused(evoListRow.getUniqueID(), 0, n);
                wheelButtonEvent.consume(false);
                return;
            }
            EvoListRow evoListRow = baseListModel.getRow(this.currentValue);
            baseListModel.itemFocused(evoListRow.getUniqueID(), 0, n);
        }
        wheelButtonEvent.consume(false);
    }

    @Override
    public void keyPressed(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
        int n = keyEvent.getKeyCode();
        if (n != 17) {
            return;
        }
        BaseListModel baseListModel = this.getBaseListModel(abstractWidgetController);
        if (baseListModel == null) {
            return;
        }
        int n2 = abstractWidgetController.getTerminalImpl().getTerminalID();
        menuItemLogCh.log(1078071040, "BaseListModelKeyHandler#keyReleased: call model. modelID: %1, keyCode: %2", (long)baseListModel.getID(), (long)n);
        EvoListRow evoListRow = baseListModel.getRow(this.currentValue);
        baseListModel.itemSelected(evoListRow.getUniqueID(), 0, n2);
        keyEvent.consume(false);
    }

    protected BaseListModel getBaseListModel(AbstractWidgetController abstractWidgetController) {
        Object object = abstractWidgetController.getModel();
        if (object == null) {
            menuItemLogCh.log(10000, "BaseListModelKeyHandler#getModel: model is null. widget: %1", (Object)abstractWidgetController);
            return null;
        }
        if (object instanceof BaseListModel) {
            return (BaseListModel)object;
        }
        menuItemLogCh.log(10000, "BaseListModelKeyHandler#getModel: model is not a Base List model. model: %1, widget: %2", object, (Object)abstractWidgetController);
        return null;
    }

    public boolean isCheckRangeLimits() {
        return this.checkRangeLimits;
    }

    public boolean isHandlePressReleaseEvents() {
        return this.handlePressReleaseEvents;
    }
}

