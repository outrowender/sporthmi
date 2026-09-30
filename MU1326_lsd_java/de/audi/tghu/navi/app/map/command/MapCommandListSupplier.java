/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.command;

import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListSupplier;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.command.MapCommand;
import de.audi.tghu.navi.app.util.Util;
import java.util.Iterator;

public class MapCommandListSupplier
implements ICommandListSupplier {
    private static final int DEBUG_POPUP_UNDEFINED = -1;
    private static final int DEBUG_POPUP_DEACTIVATED = 0;
    private static final int DEBUG_POPUP_ACTIVATED = 1;
    private final NavigationEnv env;
    private final AbstractMap naviMap;
    private int debugPopupActivated = -1;

    public MapCommandListSupplier(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        this.env = navigationEnv;
        this.naviMap = abstractMap;
    }

    private boolean isDebugPopupActivated() {
        if (this.debugPopupActivated == -1) {
            this.debugPopupActivated = Boolean.getBoolean("ActivateNaviDebugPopup") ? 1 : 0;
        }
        return this.debugPopupActivated == 1;
    }

    public void showDebugPopup(CommandList commandList, String string, String string2) {
        if (!this.isDebugPopupActivated()) {
            return;
        }
        ListModelApp listModelApp = this.env.getListModel(400145);
        listModelApp.setMaxRows(40);
        listModelApp.clear();
        listModelApp.addRow(new TextListCell(string));
        listModelApp.addRow(new TextListCell(string2));
        if (commandList.getInvocationSource() != null) {
            listModelApp.addRow(new TextListCell(commandList.getInvocationSource()));
        }
        int n = 1;
        Iterator iterator = commandList.getCommands().iterator();
        int n2 = commandList.getCommands().size();
        while (iterator.hasNext()) {
            String string3 = ((MapCommand)iterator.next()).getName();
            string3 = string3.substring(string3.lastIndexOf(46) + 1);
            listModelApp.addRow(new TextListCell(n++ + "/" + n2 + ": " + string3));
        }
    }

    public boolean isApplicationOperable() {
        return this.naviMap.isInitialized();
    }

    public boolean isDSIsAvailable(CommandList commandList) {
        return this.naviMap.getMainRequestCtl().isReady();
    }

    public String getApplicationName(CommandList commandList) {
        return "AppNavi";
    }

    public void handleException(Exception exception) {
        Util.handleDSIException(exception, this.env);
    }
}

