/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.EHGetAllCategoriesCommand;
import org.dsi.ifc.navigation.Category;

public class POICategoryManager {
    private static final int MAX_OBSERVERS = 2;
    private static final String GET_ALL_CATEGORIES_KEY = "ehGetAllCatKey";
    private final IconHandler iconHandler;
    private final LogChannel logChannel;
    private final NavigationEnv env;
    private final POICategoriesObserver[] observers;
    private int registeredObservers = 0;
    private boolean active;
    private final ICommandListFactory commandListFactory;

    public POICategoryManager(NavigationEnv navigationEnv, IconHandler iconHandler, ICommandListFactory iCommandListFactory) {
        this.iconHandler = iconHandler;
        this.commandListFactory = iCommandListFactory;
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
        this.observers = new POICategoriesObserver[2];
        this.active = false;
    }

    public CommandList languageChanged() {
        this.logChannel.log(10000000, "POICategoryManager#languageChanged() - resetting categories [active: %1] ", this.active);
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
    public boolean registerObserver(POICategoriesObserver pOICategoriesObserver) {
        this.logChannel.log(10000000, "POICategoryManager#registerObserver( %1 ) ", (Object)pOICategoriesObserver);
        boolean bl = false;
        POICategoriesObserver[] pOICategoriesObserverArray = this.observers;
        synchronized (this.observers) {
            if (this.registeredObservers < 2) {
                this.observers[this.registeredObservers] = pOICategoriesObserver;
                ++this.registeredObservers;
                bl = true;
            } else {
                this.logChannel.log(100000, "POICategoryManager#registerObserver() - %1 already registered! Failed to register additional observer!", 2L);
            }
            // ** MonitorExit[var3_3] (shouldn't be in output)
            return bl;
        }
    }

    public CommandList fetchPOICategories(final int n) {
        this.logChannel.log(10000000, "POICategoryManager#fetchPOICategories() ");
        CommandList commandList = this.commandListFactory.createCommandList();
        if (this.registeredObservers > 0) {
            this.active = true;
            commandList.add(new EHGetAllCategoriesCommand("EHGetAllCategoriesCommand", n){

                protected void processCategories(Category[] categoryArray) {
                    this.getCommandList().put(POICategoryManager.GET_ALL_CATEGORIES_KEY, categoryArray);
                }
            });
            commandList.add(new NavCommand("fetchPOICategories.notifyObserver"){

                public void execute() {
                    POICategoryManager.this.logChannel.log(10000000, "POICategoryManager#fetchPOICategories() - notify %1 registered observers", (long)POICategoryManager.this.registeredObservers);
                    Category[] categoryArray = (Category[])this.getCommandList().get(POICategoryManager.GET_ALL_CATEGORIES_KEY);
                    for (int i2 = 0; i2 < POICategoryManager.this.registeredObservers; ++i2) {
                        try {
                            POICategoryManager.this.observers[i2].processCategories(n, categoryArray);
                            continue;
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                    this.getCommandList().commandFinished();
                }
            });
        }
        return commandList;
    }

    public void preloadCategories() {
        boolean bl = Boolean.getBoolean("disablePOICategoryPreLoad");
        if (!bl) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new EHGetAllCategoriesCommand("EHGetAllCategoriesCommand", 0){

                protected void processCategories(final Category[] categoryArray) {
                    this.navigation.getDispatcher().execute(new Runnable(){

                        public void run() {
                            int n = categoryArray == null ? 0 : categoryArray.length;
                            for (int i2 = 0; i2 < n; ++i2) {
                                POICategoryManager.this.iconHandler.resolvePOIIconResourceID(categoryArray[i2].getIconIndex(), categoryArray[i2].getSubIconIndex());
                            }
                        }
                    });
                }
            });
            commandList.execute("POICategoryManager#preloadCategories()");
        }
    }

    public static interface POICategoriesObserver {
        public void processCategories(int var1, Category[] var2);
    }
}

