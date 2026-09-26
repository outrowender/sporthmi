/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.MenuDecoratorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;

class MenuDecoratorController$1
implements ATIPEventListener {
    private final /* synthetic */ MenuController val$menu;
    private final /* synthetic */ MenuDecoratorController this$0;

    MenuDecoratorController$1(MenuDecoratorController menuDecoratorController, MenuController menuController) {
        this.this$0 = menuDecoratorController;
        this.val$menu = menuController;
    }

    @Override
    public void processEvent(ATIPEvent aTIPEvent) {
        MenuDecoratorController.access$000(this.this$0, aTIPEvent, this.val$menu);
    }
}

