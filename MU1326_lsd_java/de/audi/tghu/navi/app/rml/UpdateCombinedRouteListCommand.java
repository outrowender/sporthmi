/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.rml.IRMLModelAccess;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.Route;

public class UpdateCombinedRouteListCommand
extends NavCommand {
    private final IRMLModelAccess modelAccess;
    private final int requestId;
    private final long openedAnchorId;
    private final Route route;

    public UpdateCombinedRouteListCommand(IRMLModelAccess iRMLModelAccess, int n, long l, Route route) {
        this.requestId = n;
        this.modelAccess = iRMLModelAccess;
        this.openedAnchorId = l;
        this.route = route;
    }

    public void execute() {
        long l = this.dsiResponseContainer.getCombinedRouteListResultAnchorId();
        CombinedRouteListElement[] combinedRouteListElementArray = this.dsiResponseContainer.getCombinedRouteListResultCombinedRouteListElements();
        this.env.getRMLLogChannel().log(10000000, "UpdateCombinedRouteListCommand#execute - list will be updated with requestID = %1, combinedRouteListResultAnchorId = %2", (long)this.requestId, l);
        this.modelAccess.onUpdateList(l, combinedRouteListElementArray, this.requestId, this.openedAnchorId, this.route);
        this.getCommandList().commandFinished();
    }
}

