/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.rml.RMLSequence;
import de.audi.tghu.navi.app.rml.RequestNavRectangleForCombinedRouteListElement;
import org.dsi.ifc.global.NavRectangle;

class RMLSequence$17
extends NavCommand {
    private final /* synthetic */ RMLSequence this$0;

    RMLSequence$17(RMLSequence rMLSequence, String string) {
        this.this$0 = rMLSequence;
        super(string);
    }

    @Override
    public void execute() {
        NavRectangle navRectangle = (NavRectangle)this.getCommandList().get(RequestNavRectangleForCombinedRouteListElement.NAV_RECTANGLE_FOR_COMBINED_ROUTE_LIST_NAV_RECTANGLE);
        this.navigation.getMapInterface().getPreviewMap().setPreviewTrafficInfoTmcEventsForRouteList(navRectangle, 13, null, null);
        this.getCommandList().commandFinished();
    }
}

