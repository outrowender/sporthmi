/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.tghu.hmi.evo.IDrawerListener;
import de.audi.tghu.hmi.evo.IDrawerListener$CallbackFunction;

final class IDrawerListener$2
extends IDrawerListener$CallbackFunction {
    IDrawerListener$2() {
    }

    @Override
    public void informListener(IDrawerListener iDrawerListener, Object[] objectArray) {
        iDrawerListener.optionDrawerLocked((Boolean)objectArray[0]);
    }
}

