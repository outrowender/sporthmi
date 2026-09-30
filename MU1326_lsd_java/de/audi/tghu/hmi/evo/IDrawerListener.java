/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.hmi.view.ScreenData;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;
import java.util.Iterator;
import java.util.Map;

public interface IDrawerListener {
    public static final CallbackFunction CALLBACK_OPTION_DRAWER_ACTIVATED = new CallbackFunction(){

        public void informListener(IDrawerListener iDrawerListener, Object[] objectArray) {
            iDrawerListener.optionDrawerActivated((ScreenData)objectArray[0], (Screen)objectArray[1], (IDrawerControllerEvo)objectArray[2]);
        }
    };
    public static final CallbackFunction CALLBACK_OPTION_DRAWER_LOCKED = new CallbackFunction(){

        public void informListener(IDrawerListener iDrawerListener, Object[] objectArray) {
            iDrawerListener.optionDrawerLocked((Boolean)objectArray[0]);
        }
    };
    public static final CallbackFunction CALLBACK_SCREEN_SET = new CallbackFunction(){

        public void informListener(IDrawerListener iDrawerListener, Object[] objectArray) {
            iDrawerListener.screenSet((ScreenData)objectArray[0], (Screen)objectArray[1]);
        }
    };

    public void optionDrawerActivated(IScreenData var1, Screen var2, IDrawerControllerEvo var3);

    public void optionDrawerLocked(Boolean var1);

    public void screenSet(IScreenData var1, Screen var2);

    public static abstract class CallbackFunction {
        public abstract void informListener(IDrawerListener var1, Object[] var2);

        public static final void informListeners(Map map, CallbackFunction callbackFunction, Object[] objectArray) {
            if (map.size() > 0) {
                Iterator iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry)iterator.next();
                    IDrawerListener iDrawerListener = (IDrawerListener)entry.getValue();
                    callbackFunction.informListener(iDrawerListener, objectArray);
                }
            }
        }
    }
}

