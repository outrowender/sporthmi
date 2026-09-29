/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.gui.IBriefingModelAccess;
import de.audi.tghu.navi.app.map.gui.IRouteBriefingOptionRowBuilder;
import de.audi.tghu.navi.app.setup.IRouteCriteria;

public class BriefingModelAccess
implements IBriefingModelAccess {
    private final NavigationEnv env;
    private final IRouteBriefingOptionRowBuilder routeBriefingRowBuilder;
    private final ListModelApp listModelApp;

    public BriefingModelAccess(NavigationEnv navigationEnv, IRouteBriefingOptionRowBuilder iRouteBriefingOptionRowBuilder) {
        navigationEnv.getLogChannel().log(-2137614336, "[RouteBriefing] BriefingModelAccess#BriefingModelAccess()");
        this.env = navigationEnv;
        this.routeBriefingRowBuilder = iRouteBriefingOptionRowBuilder;
        this.listModelApp = navigationEnv.getListModel(1579025920);
        this.listModelApp.setMaxColumns(iRouteBriefingOptionRowBuilder.getColumnCount());
    }

    @Override
    public void onStart() {
        this.env.getLogChannel().log(-2137614336, "[RouteBriefing] BriefingModelAccess#onStart()");
        this.listModelApp.clear();
    }

    @Override
    public void onUpdateOptionsList(IRouteCriteria iRouteCriteria) {
        this.env.getLogChannel().log(-2137614336, "[RouteBriefing] BriefingModelAccess#onUpdateOptionsList( %1 )", (Object)iRouteCriteria);
        this.listModelApp.clear();
        if (iRouteCriteria == null) {
            return;
        }
        try {
            ListCell[] listCellArray = this.routeBriefingRowBuilder.buildListRow(iRouteCriteria, 0);
            this.listModelApp.addRow(listCellArray);
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(-2137614336, exception.getMessage());
        }
    }
}

