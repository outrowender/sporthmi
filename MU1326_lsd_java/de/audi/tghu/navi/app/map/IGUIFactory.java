/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.gui.GUIEventDispatcher;

public interface IGUIFactory {
    public GUIEventDispatcher createGUIEventDispatcher(NavigationEnv var1, MapManager var2);

    public GUIInterface createGUIMain(NavigationEnv var1, AbstractMap var2);
}

