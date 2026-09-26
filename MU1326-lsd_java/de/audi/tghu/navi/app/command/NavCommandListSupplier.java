/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListSupplier;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;

public class NavCommandListSupplier
implements ICommandListSupplier {
    private static final int DEBUG_POPUP_UNDEFINED;
    private static final int DEBUG_POPUP_DEACTIVATED;
    private static final int DEBUG_POPUP_ACTIVATED;
    private final NavigationEnv env;
    private int debugPopupActivated = -1;
    private Navigation navigation;

    public NavCommandListSupplier(NavigationEnv navigationEnv, Navigation navigation) {
        this.env = navigationEnv;
        this.navigation = navigation;
    }

    public void cleanUp() {
        this.navigation = null;
    }

    private boolean isDebugPopupActivated() {
        if (this.debugPopupActivated == -1) {
            this.debugPopupActivated = Boolean.getBoolean("ActivateNaviDebugPopup") ? 1 : 0;
        }
        return this.debugPopupActivated == 1;
    }

    @Override
    public void showDebugPopup(CommandList commandList, String string, String string2) {
        if (!this.isDebugPopupActivated()) {
            return;
        }
        ListModelApp listModelApp = this.env.getListModel(286983680);
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
            String string3 = ((NavCommand)iterator.next()).getName();
            string3 = string3.substring(string3.lastIndexOf(46) + 1);
            listModelApp.addRow(new TextListCell(new StringBuffer().append(n++).append("/").append(n2).append(": ").append(string3).toString()));
        }
    }

    @Override
    public boolean isApplicationOperable() {
        return this.navigation.getOperationManager().isFullyOperable();
    }

    @Override
    public String getApplicationName(CommandList commandList) {
        if (commandList != null) {
            return new Buffer().append("AppNavi[").append(DSINavigationManager.dsiTypeToString(DSINavigationManager.getDSIType(commandList))).append(']').toString();
        }
        return "AppNavi";
    }

    @Override
    public boolean isDSIsAvailable(CommandList commandList) {
        return this.navigation.getDsiNavigationManager().getDSINavigation(DSINavigationManager.getDSIType(commandList)) != null;
    }

    @Override
    public void handleException(Exception exception) {
        Util.handleDSIException(exception, this.env);
    }
}

