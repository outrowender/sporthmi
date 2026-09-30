/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.hierarchiclist.via;

import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.DynamicListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.hierarchiclist.via.ViaListManager;

public class ViaApp {
    private final NavigationEnv env;
    private final IconHandler iconHandler;
    private LogChannel logChannel;
    private ViaListManager[] managers;
    private final ICommandListFactory commandListFactory;

    public ViaApp(NavigationEnv navigationEnv, IconHandler iconHandler, ICommandListFactory iCommandListFactory) {
        this.env = navigationEnv;
        this.iconHandler = iconHandler;
        this.logChannel = navigationEnv.getLogChannel();
        this.managers = new ViaListManager[8];
        this.commandListFactory = iCommandListFactory;
        if (navigationEnv.getFramework().isFrontMU()) {
            this.getViaListManager(0);
        } else {
            this.getViaListManager(3);
            this.getViaListManager(4);
        }
    }

    final ViaListManager getViaListManager(int n) {
        if (this.managers[n] == null) {
            DynamicListModelApp dynamicListModelApp = this.env.getDynamicListModel(n, 400839);
            ChoiceModelApp choiceModelApp = this.env.getChoiceModel(n, 400840);
            this.managers[n] = new ViaListManager(this.iconHandler, this.logChannel, dynamicListModelApp, choiceModelApp, n, this, this.commandListFactory);
        }
        return this.managers[n];
    }

    void requestInitialWindow(int n) {
        this.logChannel.log(10000000, "ViaApp#requestInitialWindow()");
        this.getViaListManager(n).requestInitialWindow();
    }

    void requestWindow(ListRow listRow, int n) {
        this.logChannel.log(10000000, "ViaApp#requestWindow()");
        this.getViaListManager(n).requestWindow(listRow, false);
    }

    void itemFocused(ListRow listRow, int n, int n2) {
        this.logChannel.log(10000000, "ViaApp#itemFocused()");
        this.getViaListManager(n2).itemFocused(listRow, n);
    }

    public void itemSelected(int n, ListRow listRow, int n2) {
        this.logChannel.log(10000000, "ViaApp#itemSelected()");
        DynamicListModelApp dynamicListModelApp = this.env.getDynamicListModel(n);
        this.getViaListManager(n2).itemSelected(dynamicListModelApp, listRow, n2, false);
    }

    public void updateList() {
        this.logChannel.log(10000000, "ViaApp#updateList()");
        if (this.env.getFramework().isFrontMU()) {
            this.getViaListManager(0).updateList();
        } else {
            this.getViaListManager(3).updateList();
            this.getViaListManager(4).updateList();
        }
    }

    void setCountryListAvailability(boolean bl) {
        this.logChannel.log(10000000, "ViaApp#setCountryListAvailability( %1 )", bl);
        if (this.env.getFramework().isFrontMU()) {
            this.getViaListManager(0).setCountryListAvailability(bl);
        } else {
            this.getViaListManager(3).setCountryListAvailability(bl);
            this.getViaListManager(4).setCountryListAvailability(bl);
        }
    }

    public void resetAll() {
        this.logChannel.log(10000000, "ViaApp#resetAll()");
        if (this.env.getFramework().isFrontMU()) {
            this.getViaListManager(0).resetAll();
        } else {
            this.getViaListManager(3).resetAll();
            this.getViaListManager(4).resetAll();
        }
    }
}

