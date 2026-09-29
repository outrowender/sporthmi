/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;
import de.audi.tghu.hmi.evo.IDrawerListener$1;
import de.audi.tghu.hmi.evo.IDrawerListener$2;
import de.audi.tghu.hmi.evo.IDrawerListener$3;
import de.audi.tghu.hmi.evo.IDrawerListener$CallbackFunction;

public interface IDrawerListener {
    public static final IDrawerListener$CallbackFunction CALLBACK_OPTION_DRAWER_ACTIVATED = new IDrawerListener$1();
    public static final IDrawerListener$CallbackFunction CALLBACK_OPTION_DRAWER_LOCKED = new IDrawerListener$2();
    public static final IDrawerListener$CallbackFunction CALLBACK_SCREEN_SET = new IDrawerListener$3();

    default public void optionDrawerActivated(IScreenData iScreenData, Screen screen, IDrawerControllerEvo iDrawerControllerEvo) {
    }

    default public void optionDrawerLocked(Boolean bl) {
    }

    default public void screenSet(IScreenData iScreenData, Screen screen) {
    }
}

