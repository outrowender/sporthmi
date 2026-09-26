/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.event;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.event.IEventBroker;
import de.audi.tghu.navi.app.map.event.MapEventListener;

public class MapEventDispatcher
implements IEventBroker {
    public static final int MAX_COUNT_OF_LISTENER;
    private MapEventListener[] listeners = new MapEventListener[10];
    private LogChannel logger;

    public MapEventDispatcher(NavigationEnv navigationEnv) {
        this.logger = navigationEnv.getLogChannel("App.Map.Main");
    }

    @Override
    public void addListener(MapEventListener mapEventListener) {
        boolean bl = false;
        for (int i2 = 0; i2 < 10; ++i2) {
            if (this.listeners[i2] != null) continue;
            this.listeners[i2] = mapEventListener;
            bl = true;
            break;
        }
        if (!bl) {
            this.logger.log(10000, "MapEventDispatcher#addListener() - listener pool is full. %1", (Object)mapEventListener);
        }
    }

    @Override
    public void fireEvent(int n) {
        this.fireEvent(n, -1);
    }

    @Override
    public void fireEvent(int n, int n2) {
        this.logger.log(14808325, "MapEventDispatcher#fireEvent( %1, %2)", (long)n, (long)n2);
        switch (n) {
            default: 
        }
        this.dispatchEvent(n, n2);
    }

    private void dispatchEvent(int n, int n2) {
        for (int i2 = 0; i2 < 10; ++i2) {
            if (this.listeners[i2] == null) continue;
            try {
                this.listeners[i2].onEvent(n, n2);
                continue;
            }
            catch (Exception exception) {
                this.logger.log(-1601830656, "MapEventDispatcher#dispatchEvent() - %1", (Object)this.listeners[i2]);
                this.logger.log(-1601830656, "MapEventDispatcher#dispatchEvent() - %1", (Throwable)exception);
            }
        }
    }
}

