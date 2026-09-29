/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.CompositeRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.MenuDecoratorController$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuCallback;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;

public class MenuDecoratorController
extends AbstractWidgetController
implements IMenuCallback {
    private static final int TIMEOUT_SHOW_OVERLAY_DECORATORS;
    private boolean hideOverlayDecoratorDuringScrolling = true;
    private TimerEvent timerEventShowOverlayDecorators;
    private Job timerJobShowOverlayDecorators;
    private CompositeRenderer renderer;
    private MenuController menu;

    @Override
    public void disconnecting() {
        this.cancelOverlayDecoratorShowTimer();
        this.timerJobShowOverlayDecorators = null;
        this.timerEventShowOverlayDecorators = null;
        this.setOnScreen(true);
        super.disconnecting();
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(CompositeRenderer compositeRenderer) {
        this.renderer = compositeRenderer;
    }

    @Override
    public void setActiveMenuController(MenuController menuController) {
        this.menu = menuController;
    }

    @Override
    public void menuFocusChanged(MenuItemIndex menuItemIndex) {
        if (this.hideOverlayDecoratorDuringScrolling && !Util.equals(menuItemIndex, this.menu.getFocusedIndex())) {
            menuLogCh.log(-2137614336, "MenuDecoratorController#menuFocusChanged hide decorator");
            this.setOnScreen(false);
            this.cancelOverlayDecoratorShowTimer();
        }
    }

    @Override
    public void menuFocusChangeFinished() {
        if (this.hideOverlayDecoratorDuringScrolling) {
            this.restartOverlayDecoratorShowTimer(this.menu);
        }
    }

    private void restartOverlayDecoratorShowTimer(MenuController menuController) {
        this.cancelOverlayDecoratorShowTimer();
        if (this.timerEventShowOverlayDecorators == null) {
            this.timerEventShowOverlayDecorators = new TimerEvent(new MenuDecoratorController$1(this, menuController));
        }
        menuLogCh.log(-2137614336, "MenuDecoratorController#restartOverlayDecoratorShowTimer with timeout: %1", (long)0);
        this.timerJobShowOverlayDecorators = hmiService.getEventDispatcher().postEvent(this.timerEventShowOverlayDecorators, 0);
    }

    public void cancelOverlayDecoratorShowTimer() {
        if (this.timerJobShowOverlayDecorators != null && !this.timerJobShowOverlayDecorators.isCanceled()) {
            menuLogCh.log(-2137614336, "MenuDecoratorController#cancelOverlayDecoratorShowTimer");
            this.timerJobShowOverlayDecorators.cancel();
            this.timerJobShowOverlayDecorators = null;
        }
    }

    private void overlayDecoratorShowTimerFired(ATIPEvent aTIPEvent, MenuController menuController) {
        if (aTIPEvent.equals(this.timerEventShowOverlayDecorators)) {
            this.timerJobShowOverlayDecorators = null;
            this.showOverlayDecorators(menuController);
        } else {
            menuLogCh.log(-1601830656, "MenuDecoratorController#overlayDecoratorShowTimerFired is called with unexpected timer: %1, expected timer: %2, menu: %3", (Object)aTIPEvent, (Object)this.timerEventShowOverlayDecorators, (Object)menuController);
        }
    }

    private void showOverlayDecorators(MenuController menuController) {
        boolean bl;
        boolean bl2 = bl = !this.isCursorOnTouchPad(menuController);
        if (bl == this.isOnScreen()) {
            menuLogCh.log(-2137614336, "MenuDecoratorController#overlayDecoratorShowTimerFired: timer fired. visibility didn't change. visible: %1, menu: %2", bl, (Object)menuController);
            return;
        }
        menuLogCh.log(-2137614336, "MenuDecoratorController#overlayDecoratorShowTimerFired. show decorators: %1, menu: %2", bl, (Object)menuController);
        this.setOnScreen(bl);
        if (logRepaintCause.isDebug()) {
            logRepaintCause.log(-2137614336, "MenuDecoratorController#showOverlayDecorators: trigger repaint. screen id: %2, show overlays: %1", (Object)bl, (long)this.getScreenId());
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

    @Override
    public void setHideOverlayDecoratorDuringScrolling(boolean bl) {
        this.hideOverlayDecoratorDuringScrolling = bl;
    }

    @Override
    public void menuLayouted() {
    }

    @Override
    public void viewportUpdated(boolean bl) {
    }

    @Override
    public void menuSelectionChanged(MenuItemIndex menuItemIndex, Long l, MenuUpdateDelta menuUpdateDelta) {
    }

    static /* synthetic */ void access$000(MenuDecoratorController menuDecoratorController, ATIPEvent aTIPEvent, MenuController menuController) {
        menuDecoratorController.overlayDecoratorShowTimerFired(aTIPEvent, menuController);
    }
}

