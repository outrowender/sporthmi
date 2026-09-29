/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.view.Screen;
import de.audi.atip.hmi.view.ScreenData;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;
import de.audi.tghu.hmi.evo.IDrawerListener;
import de.audi.tghu.hmi.evo.IDrawerListener$CallbackFunction;

final class IDrawerListener$1
extends IDrawerListener$CallbackFunction {
    IDrawerListener$1() {
    }

    @Override
    public void informListener(IDrawerListener iDrawerListener, Object[] objectArray) {
        iDrawerListener.optionDrawerActivated((ScreenData)objectArray[0], (Screen)objectArray[1], (IDrawerControllerEvo)objectArray[2]);
    }
}

