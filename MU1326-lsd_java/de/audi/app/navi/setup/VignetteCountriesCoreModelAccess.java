/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.setup;

import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.tghu.navi.app.IListRowBuilder;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;

public abstract class VignetteCountriesCoreModelAccess
implements IMatchspellerModelAccess {
    protected final ListModelApp previewListModelApp;
    protected final NavigationEnv env;
    protected final IListRowBuilder listRowBuilder;

    public VignetteCountriesCoreModelAccess(NavigationEnv navigationEnv, ListListener listListener, IListRowBuilder iListRowBuilder) {
        this.env = navigationEnv;
        this.listRowBuilder = iListRowBuilder;
        this.previewListModelApp = navigationEnv.getListModel(974980608);
        this.previewListModelApp.setListListener(listListener);
        this.previewListModelApp.setMaxColumns(iListRowBuilder.getColumnCount());
    }
}

