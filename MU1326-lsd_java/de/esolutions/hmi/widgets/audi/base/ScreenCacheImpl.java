/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.hmi.view.ScreenCache;
import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ScreenCacheImpl
implements ScreenCache {
    private static final int MAX_SCREENS_PASSIVE_APPLICATION = Integer.getInteger("screenCacheSizePassive", 3);
    private static final int APPLICATION_MULTIPLIER;
    private static final int MAX_SCREENS_ACTIVE_APPLICATION;
    private Map screenCache = new HashMap();
    private int currentApplicationID = -1;
    private Map cachedScreensPerApplication = new HashMap();
    private boolean cachingDisabled = false;
    private LogChannel logScreenCache = AbstractWidget.framework.getLogChannel("Fw.ScreenCache");

    @Override
    public void putScreen(Screen screen) {
        if (this.cachingDisabled) {
            return;
        }
        int n = screen.getCacheBehaviour();
        if (n == 2) {
            return;
        }
        this.insertIntoCache(screen);
        if (n == 1) {
            this.handleScreenChange(screen);
        } else {
            this.logScreenCache.log(-2137614336, "ScreenCacheImpl#putScreen screen with id: %1 is always cached", (long)screen.getID());
        }
    }

    private void handleScreenChange(Screen screen) {
        int n = screen.getID() / -1601830656;
        if (n == this.currentApplicationID) {
            this.logScreenCache.log(1078071040, "ScreenCacheImpl#handleScreenChange screenchange in application: %1", (long)this.currentApplicationID);
            this.changeInSameApplication(screen);
        } else {
            this.logScreenCache.log(1078071040, "ScreenCacheImpl#handleScreenChange screenchange from application: %1 to new application: %2", (long)this.currentApplicationID, (long)n);
            this.leaveCurrentApplication();
            this.currentApplicationID = n;
            this.changeInSameApplication(screen);
        }
    }

    @Override
    public Screen getScreen(int n) {
        Screen screen = (Screen)this.screenCache.get(new Integer(n));
        if (screen != null && screen.getCacheBehaviour() == 1) {
            this.handleScreenChange(screen);
        }
        return screen;
    }

    private void changeInSameApplication(Screen screen) {
        ArrayList arrayList = (ArrayList)this.cachedScreensPerApplication.get(new Integer(this.currentApplicationID));
        if (arrayList == null) {
            arrayList = new ArrayList(10);
            this.cachedScreensPerApplication.put(new Integer(this.currentApplicationID), arrayList);
            arrayList.add(screen);
        } else if (arrayList.contains(screen)) {
            int n = arrayList.indexOf(screen);
            if (n != 0) {
                arrayList.remove(n);
                arrayList.add(1, screen);
            }
        } else {
            if (arrayList.size() == MAX_SCREENS_ACTIVE_APPLICATION) {
                Screen screen2 = (Screen)arrayList.remove(arrayList.size() - 1);
                this.removeFromCache(screen2);
            }
            arrayList.add(1, screen);
        }
    }

    private void insertIntoCache(Screen screen) {
        Integer n = new Integer(screen.getID());
        if (this.screenCache.get(n) == null) {
            this.screenCache.put(n, screen);
            this.logScreenCache.log(1078071040, "ScreenCacheImpl#insertIntoCache put screen with id %1 in cache", (long)screen.getID());
        } else {
            this.logScreenCache.log(1078071040, "ScreenCacheImpl#insertIntoCache screen with id %1 is already in cache", (long)screen.getID());
        }
    }

    private void removeFromCache(Screen screen) {
        Integer n = new Integer(screen.getID());
        if (this.screenCache.get(n) != null) {
            this.screenCache.remove(n);
            this.logScreenCache.log(1078071040, "ScreenCacheImpl#removeFromCache removed screen with id %1 from cache", (long)screen.getID());
        } else {
            this.logScreenCache.log(1078071040, "ScreenCacheImpl#removeFromCache screen with id %1 was not in the cache", (long)screen.getID());
        }
    }

    private void leaveCurrentApplication() {
        ArrayList arrayList = (ArrayList)this.cachedScreensPerApplication.get(new Integer(this.currentApplicationID));
        if (arrayList != null) {
            this.logScreenCache.log(1078071040, "ScreenCacheImpl#leaveCurrentApplication leaving application: %1 no of cached screens: %2", (long)this.currentApplicationID, (long)arrayList.size());
            long l = AbstractWidget.framework.getMonotonicTime();
            while (arrayList.size() > MAX_SCREENS_PASSIVE_APPLICATION) {
                Screen screen = (Screen)arrayList.remove(arrayList.size() - 1);
                this.removeFromCache(screen);
            }
            this.logScreenCache.log(1078071040, "ScreenCacheImpl#leaveCurrentApplication leaving application: %1 took: %2", (long)this.currentApplicationID, System.currentTimeMillis() - l);
        }
    }

    @Override
    public void clear() {
        this.screenCache.clear();
        this.cachedScreensPerApplication.clear();
        this.clearDrawerCache();
    }

    private void clearDrawerCache() {
        HMITerminal hMITerminal = AbstractWidget.framework.getHMITerminalRegistry().getTerminal(0);
        if (hMITerminal instanceof HMITerminalImpl) {
            ((HMITerminalImpl)hMITerminal).getDrawerManager().clear();
        }
    }

    @Override
    public void clear(int n) {
        this.logScreenCache.log(1078071040, "ScreenCacheImpl#clear applicationId=%1", (long)n);
        this.removeScreensFromCache(n);
        this.clearDrawerCache();
    }

    private void removeScreensFromCache(int n) {
        Collection collection = this.screenCache.values();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Screen screen = (Screen)iterator.next();
            int n2 = screen.getID();
            int n3 = n2 / -1601830656;
            if (n3 != n) continue;
            this.logScreenCache.log(-2137614336, "ScreenCacheImpl#clear remove screen(%1) from cache", (long)n2);
            iterator.remove();
        }
        this.cachedScreensPerApplication.remove(new Integer(n));
    }

    @Override
    public void setCachingDisabled(boolean bl) {
        this.cachingDisabled = bl;
    }

    static {
        MAX_SCREENS_ACTIVE_APPLICATION = Integer.getInteger("screenCacheSizeActive", 6);
    }
}

