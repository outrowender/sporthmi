/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.view.Screen;
import de.audi.atip.hmi.view.ScreenData;
import de.audi.tghu.hmi.evo.IDrawerListener;
import de.audi.tghu.hmi.evo.IDrawerListener$CallbackFunction;

final class IDrawerListener$3
extends IDrawerListener$CallbackFunction {
    IDrawerListener$3() {
    }

    @Override
    public void informListener(IDrawerListener iDrawerListener, Object[] objectArray) {
        iDrawerListener.screenSet((ScreenData)objectArray[0], (Screen)objectArray[1]);
    }
}

