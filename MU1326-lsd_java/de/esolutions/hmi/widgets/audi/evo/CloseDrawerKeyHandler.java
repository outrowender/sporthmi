/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.DecoratorKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.IWidgetKeyHandler;

public class CloseDrawerKeyHandler
extends DecoratorKeyHandler {
    private final boolean forceClosing;
    private boolean closeOptionDrawerAfterScreenConnected;

    public CloseDrawerKeyHandler(IWidgetKeyHandler iWidgetKeyHandler, boolean bl) {
        super(iWidgetKeyHandler);
        this.forceClosing = bl;
    }

    @Override
    public void keyPressed(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
        IWidgetLogChannel.logDrawerFocus.log(-2137614336, "MenuItemBuilder#createClosingKeyHandler#keyPressed widget=%1, event=%2", (Object)abstractWidgetController, (Object)keyEvent);
        super.keyPressed(abstractWidgetController, keyEvent);
        if (!keyEvent.isConsumed()) {
            if (this.forceClosing) {
                IWidgetLogChannel.logDrawerFocus.log(1078071040, "MenuItemBuilder#createClosingKeyHandler#keyPressed forcing to close drawer although event was not consumed widget=%1, event=%2", (Object)abstractWidgetController, (Object)keyEvent);
                keyEvent.consume();
            } else {
                return;
            }
        }
        IWidgetLogChannel.logDrawerFocus.log(-2137614336, "MenuItemBuilder#createClosingKeyHandler#keyPressed trying to close drawer");
        IDrawerFocusManagerEvo iDrawerFocusManagerEvo = ((ExtHMITerminalEvo)abstractWidgetController.getTerminal()).getDrawerFocusManager();
        if (iDrawerFocusManagerEvo != null) {
            int n = iDrawerFocusManagerEvo.getDrawerState();
            if (n != 16) {
                abstractWidgetController.getTerminal().getIAnimationController().setDrawerWasClosed(true);
            }
            if (n == 4 && abstractWidgetController.isInSelectionDrawer()) {
                IWidgetLogChannel.logDrawerFocus.log(-2137614336, "MenuItemBuilder#createClosingKeyHandler#keyPressed trying to close selection drawer");
                iDrawerFocusManagerEvo.requestDrawerClose(4);
            } else if (n == 8 && abstractWidgetController.isInOptionDrawer()) {
                IWidgetLogChannel.logDrawerFocus.log(-2137614336, "MenuItemBuilder#createClosingKeyHandler#keyPressed trying to close option drawer");
                if (this.closeOptionDrawerAfterScreenConnected && !this.forceClosing) {
                    iDrawerFocusManagerEvo.requestDrawerClose(8);
                } else {
                    iDrawerFocusManagerEvo.requestDrawerState(16);
                }
            }
        }
    }

    public void setCloseOptionDrawerAfterScreenConnected(boolean bl) {
        this.closeOptionDrawerAfterScreenConnected = bl;
    }
}

