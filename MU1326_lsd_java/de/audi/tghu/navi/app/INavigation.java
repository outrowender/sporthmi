/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.AbstractNavigationActivator;
import de.audi.tghu.navi.app.NavigationEnv;

public interface INavigation {
    default public void init(AbstractNavigationActivator abstractNavigationActivator, NavigationEnv navigationEnv) {
    }
}

