/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.CompositeRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuCallback;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;

public class MenuDecoratorController
extends AbstractWidgetController
implements IMenuCallback {
    private static final int TIMEOUT_SHOW_OVERLAY_DECORATORS = 500;
    private boolean hideOverlayDecoratorDuringScrolling = true;
    private TimerEvent timerEventShowOverlayDecorators;
    private Job timerJobShowOverlayDecorators;
    private CompositeRenderer renderer;
    private MenuController menu;

    public void disconnecting() {
        this.cancelOverlayDecoratorShowTimer();
        this.timerJobShowOverlayDecorators = null;
        this.timerEventShowOverlayDecorators = null;
        this.setOnScreen(true);
        super.disconnecting();
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(CompositeRenderer compositeRenderer) {
        this.renderer = compositeRenderer;
    }

    public void setActiveMenuController(MenuController menuController) {
        this.menu = menuController;
    }

    public void menuFocusChanged(MenuItemIndex menuItemIndex) {
        if (this.hideOverlayDecoratorDuringScrolling && !Util.equals(menuItemIndex, this.menu.getFocusedIndex())) {
            menuLogCh.log(10000000, "MenuDecoratorController#menuFocusChanged hide decorator");
            this.setOnScreen(false);
            this.cancelOverlayDecoratorShowTimer();
        }
    }

    public void menuFocusChangeFinished() {
        if (this.hideOverlayDecoratorDuringScrolling) {
            this.restartOverlayDecoratorShowTimer(this.menu);
        }
    }

    private void restartOverlayDecoratorShowTimer(final MenuController menuController) {
        this.cancelOverlayDecoratorShowTimer();
        if (this.timerEventShowOverlayDecorators == null) {
            this.timerEventShowOverlayDecorators = new TimerEvent(new ATIPEventListener(){

                public void processEvent(ATIPEvent aTIPEvent) {
                    MenuDecoratorController.this.overlayDecoratorShowTimerFired(aTIPEvent, menuController);
                }
            });
        }
        menuLogCh.log(10000000, "MenuDecoratorController#restartOverlayDecoratorShowTimer with timeout: %1", 500L);
        this.timerJobShowOverlayDecorators = hmiService.getEventDispatcher().postEvent(this.timerEventShowOverlayDecorators, 500L);
    }

    public void cancelOverlayDecoratorShowTimer() {
        if (this.timerJobShowOverlayDecorators != null && !this.timerJobShowOverlayDecorators.isCanceled()) {
            menuLogCh.log(10000000, "MenuDecoratorController#cancelOverlayDecoratorShowTimer");
            this.timerJobShowOverlayDecorators.cancel();
            this.timerJobShowOverlayDecorators = null;
        }
    }

    private void overlayDecoratorShowTimerFired(ATIPEvent aTIPEvent, MenuController menuController) {
        if (aTIPEvent.equals(this.timerEventShowOverlayDecorators)) {
            this.timerJobShowOverlayDecorators = null;
            this.showOverlayDecorators(menuController);
        } else {
            menuLogCh.log(100000, "MenuDecoratorController#overlayDecoratorShowTimerFired is called with unexpected timer: %1, expected timer: %2, menu: %3", (Object)aTIPEvent, (Object)this.timerEventShowOverlayDecorators, (Object)menuController);
        }
    }

    private void showOverlayDecorators(MenuController menuController) {
        boolean bl;
        boolean bl2 = bl = !this.isCursorOnTouchPad(menuController);
        if (bl == this.isOnScreen()) {
            menuLogCh.log(10000000, "MenuDecoratorController#overlayDecoratorShowTimerFired: timer fired. visibility didn't change. visible: %1, menu: %2", bl, (Object)menuController);
            return;
        }
        menuLogCh.log(10000000, "MenuDecoratorController#overlayDecoratorShowTimerFired. show decorators: %1, menu: %2", bl, (Object)menuController);
        this.setOnScreen(bl);
        if (logRepaintCause.isDebug()) {
            logRepaintCause.log(10000000, "MenuDecoratorController#showOverlayDecorators: trigger repaint. screen id: %2, show overlays: %1", (Object)bl, (long)this.getScreenId());
        }
        this.triggerRepaint();
    }

    private boolean isCursorOnTouchPad(MenuController menuController) {
        if (!menuController.hasFocusedItem()) {
            return false;
        }
        AbstractWidget abstractWidget = menuController.getChild(menuController.getFocusedIndex().widget);
        return abstractWidget instanceof TouchController;
    }

    public boolean isHideOverlayDecoratorDuringScrolling() {
        return this.hideOverlayDecoratorDuringScrolling;
    }

    public void setHideOverlayDecoratorDuringScrolling(boolean bl) {
        this.hideOverlayDecoratorDuringScrolling = bl;
    }

    public void menuLayouted() {
    }

    public void viewportUpdated(boolean bl) {
    }

    public void menuSelectionChanged(MenuItemIndex menuItemIndex, Long l, MenuUpdateDelta menuUpdateDelta) {
    }
}

