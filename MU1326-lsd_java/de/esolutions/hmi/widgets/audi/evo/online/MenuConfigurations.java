/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.esolutions.hmi.widgets.audi.evo.online.GridMenuChanger;
import de.esolutions.hmi.widgets.audi.evo.online.MenuChangeController;

public class MenuConfigurations {
    public static final void configureMenu(MenuChangeController menuChangeController, int n, AbstractScreenFactory abstractScreenFactory) {
        menuChangeController.setMenuChangeFactory(new GridMenuChanger(menuChangeController, n, abstractScreenFactory));
    }
}

