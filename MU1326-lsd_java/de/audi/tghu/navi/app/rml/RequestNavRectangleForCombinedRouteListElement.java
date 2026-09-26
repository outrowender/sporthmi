/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.CombinedRouteListElement;

public class RequestNavRectangleForCombinedRouteListElement
extends NavCommand {
    public static final Object NAV_RECTANGLE_FOR_COMBINED_ROUTE_LIST_UIDS = "NAV_RECTANGLE_FOR_COMBINED_ROUTE_LISTE_UIDS";
    public static final Object NAV_RECTANGLE_FOR_COMBINED_ROUTE_LIST_NAV_RECTANGLE = "NAV_RECTANGLE_FOR_COMBINED_ROUTE_LIST_NAV_RECTANGLE";
    private CombinedRouteListElement combinedRouteListElement;

    public RequestNavRectangleForCombinedRouteListElement(CombinedRouteListElement combinedRouteListElement) {
        this.combinedRouteListElement = combinedRouteListElement;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "RequestNavRectangleForCombinedRouteListElement#execute calling getBoundingRectangleOfCombinedRouteListElements [%1]", this.combinedRouteListElement.getUid());
        long[] lArray = new long[]{this.combinedRouteListElement.getUid()};
        this.getDSICombinedRouteList().getBoundingRectangleOfCombinedRouteListElements(lArray);
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    @Override
    public void getBoundingRectangleOfCombinedRouteListElementsResult(long[] lArray, NavRectangle navRectangle) {
        this.logger.log(-2137614336, "RequestNavRectangleForCombinedRouteListElement#getBoundingRectangleOfCombinedRouteListElementsResult uids %1", lArray.length > 0 ? lArray[0] : -1L);
        if (lArray.length == 1 && lArray[0] == this.combinedRouteListElement.getUid()) {
            this.getCommandList().put(NAV_RECTANGLE_FOR_COMBINED_ROUTE_LIST_UIDS, lArray);
            this.getCommandList().put(NAV_RECTANGLE_FOR_COMBINED_ROUTE_LIST_NAV_RECTANGLE, navRectangle);
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted("unexpected uids");
        }
    }
}

