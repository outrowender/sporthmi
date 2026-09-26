/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.poi.POICategoryManager$1;
import de.audi.tghu.navi.app.poi.POICategoryManager$2;
import de.audi.tghu.navi.app.poi.POICategoryManager$3;
import de.audi.tghu.navi.app.poi.POICategoryManager$POICategoriesObserver;

public class POICategoryManager {
    private static final int MAX_OBSERVERS;
    private static final String GET_ALL_CATEGORIES_KEY;
    private final IconHandler iconHandler;
    private final LogChannel logChannel;
    private final NavigationEnv env;
    private final POICategoryManager$POICategoriesObserver[] observers;
    private int registeredObservers = 0;
    private boolean active;
    private final ICommandListFactory commandListFactory;

    public POICategoryManager(NavigationEnv navigationEnv, IconHandler iconHandler, ICommandListFactory iCommandListFactory) {
        this.iconHandler = iconHandler;
        this.commandListFactory = iCommandListFactory;
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
        this.observers = new POICategoryManager$POICategoriesObserver[2];
        this.active = false;
    }

    public CommandList languageChanged() {
        this.logChannel.log(-2137614336, "POICategoryManager#languageChanged() - resetting categories [active: %1] ", this.active);
        CommandList commandList = null;
        if (this.active) {
            commandList = this.commandListFactory.createCommandList();
            commandList.add(this.fetchPOICategories(0));
        }
        return commandList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean registerObserver(POICategoryManager$POICategoriesObserver pOICategoryManager$POICategoriesObserver) {
        this.logChannel.log(-2137614336, "POICategoryManager#registerObserver( %1 ) ", (Object)pOICategoryManager$POICategoriesObserver);
        boolean bl = false;
        POICategoryManager$POICategoriesObserver[] pOICategoryManager$POICategoriesObserverArray = this.observers;
        synchronized (this.observers) {
            if (this.registeredObservers < 2) {
                this.observers[this.registeredObservers] = pOICategoryManager$POICategoriesObserver;
                ++this.registeredObservers;
                bl = true;
            } else {
                this.logChannel.log(-1601830656, "POICategoryManager#registerObserver() - %1 already registered! Failed to register additional observer!", (long)0);
            }
            // ** MonitorExit[var3_3] (shouldn't be in output)
            return bl;
        }
    }

    public CommandList fetchPOICategories(int n) {
        this.logChannel.log(-2137614336, "POICategoryManager#fetchPOICategories() ");
        CommandList commandList = this.commandListFactory.createCommandList();
        if (this.registeredObservers > 0) {
            this.active = true;
            commandList.add(new POICategoryManager$1(this, "EHGetAllCategoriesCommand", n));
            commandList.add(new POICategoryManager$2(this, "fetchPOICategories.notifyObserver", n));
        }
        return commandList;
    }

    public void preloadCategories() {
        boolean bl = Boolean.getBoolean("disablePOICategoryPreLoad");
        if (!bl) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new POICategoryManager$3(this, "EHGetAllCategoriesCommand", 0));
            commandList.execute("POICategoryManager#preloadCategories()");
        }
    }

    static /* synthetic */ int access$000(POICategoryManager pOICategoryManager) {
        return pOICategoryManager.registeredObservers;
    }

    static /* synthetic */ LogChannel access$100(POICategoryManager pOICategoryManager) {
        return pOICategoryManager.logChannel;
    }

    static /* synthetic */ POICategoryManager$POICategoriesObserver[] access$200(POICategoryManager pOICategoryManager) {
        return pOICategoryManager.observers;
    }

    static /* synthetic */ IconHandler access$400(POICategoryManager pOICategoryManager) {
        return pOICategoryManager.iconHandler;
    }
}

