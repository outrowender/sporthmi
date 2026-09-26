/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.rml.listrow;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.rml.AbstractRMLListRow;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;

public class RMLEvoDestinationListRow
extends AbstractRMLListRow {
    public RMLEvoDestinationListRow(LogChannel logChannel, CombinedRouteListElement combinedRouteListElement, int n, IconHandler iconHandler, NavigationEnv navigationEnv, Route route) {
        super(logChannel, combinedRouteListElement, n, iconHandler, navigationEnv, route);
        this.fillLayout();
        this.fillIcon();
        this.fillDetailsAllowed();
        this.fillDistance();
        this.fillName();
    }

    public RMLEvoDestinationListRow(RMLEvoDestinationListRow rMLEvoDestinationListRow) {
        super(rMLEvoDestinationListRow);
        this.env = rMLEvoDestinationListRow.getEnv();
    }

    public NavigationEnv getEnv() {
        return this.env;
    }

    @Override
    public EvoListRow copy() {
        return new RMLEvoDestinationListRow(this);
    }

    @Override
    protected void fillDistance() {
        this.setText(2, "");
    }

    @Override
    protected void fillIcon() {
        int n = this.getOffset(this.combinedRouteListElement);
        this.setInteger(3, n);
    }

    @Override
    protected void fillName() {
        int n;
        int n2 = this.route.getRoutelist().length;
        if (n2 > (n = this.combinedRouteListElement.getDestinationIndex())) {
            NavLocation navLocation = this.route.getRoutelist()[this.combinedRouteListElement.getDestinationIndex()].getRouteLocation();
            LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatOneLine(navLocation, this.env);
            String string = locationFormattingResponse.getFirstLineAsText();
            this.setText(4, string);
        } else {
            this.env.getRMLLogChannel().log(-1601830656, "RMLEvoDestinationListRow#fillName numDests(%1) > destIndex(%2)", (long)n2, (long)n);
        }
    }

    @Override
    protected void fillDetailsAllowed() {
        this.setInteger(5, 1);
    }

    private int getOffset(CombinedRouteListElement combinedRouteListElement) {
        this.env.getRMLLogChannel().log(-2137614336, "RMLEvoDestinationListRow#getOffset(%1)", (Object)combinedRouteListElement);
        if (this.env.getRMLLogChannel().isDebug2()) {
            this.env.getRMLLogChannel().log(14808325, "RMLEvoDestinationListRow#getOffset() destinationIndex = %1", (long)combinedRouteListElement.getDestinationIndex());
        }
        int n = combinedRouteListElement.getDestinationIndex();
        if (this.route != null) {
            if (this.env.getRMLLogChannel().isDebug2()) {
                this.env.getRMLLogChannel().log(14808325, "RMLEvoDestinationListRow#getOffset() routeList length = %1", (long)this.route.getRoutelist().length);
            }
            int n2 = this.route.getRoutelist().length;
            n = (n + 1) % n2;
        }
        return n;
    }

    @Override
    protected void fillLayout() {
        this.setInteger(0, 0);
    }

    @Override
    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
    }
}

