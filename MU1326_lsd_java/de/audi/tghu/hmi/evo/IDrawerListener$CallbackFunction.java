/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.tghu.hmi.evo.IDrawerListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;

public abstract class IDrawerListener$CallbackFunction {
    public abstract void informListener(IDrawerListener iDrawerListener, Object[] objectArray) {
    }

    public static final void informListeners(Map map, IDrawerListener$CallbackFunction iDrawerListener$CallbackFunction, Object[] objectArray) {
        if (map.size() > 0) {
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map$Entry map$Entry = (Map$Entry)iterator.next();
                IDrawerListener iDrawerListener = (IDrawerListener)map$Entry.getValue();
                iDrawerListener$CallbackFunction.informListener(iDrawerListener, objectArray);
            }
        }
    }
}

