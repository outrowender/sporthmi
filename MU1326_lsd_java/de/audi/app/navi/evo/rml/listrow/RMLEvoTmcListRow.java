/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.rml.listrow;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.hierarchiclist.rml.RMLUtil;
import de.audi.tghu.navi.app.rml.AbstractRMLListRow;
import de.audi.tghu.navi.app.util.TextUtil;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.NavRouteListDataIcon;
import org.dsi.ifc.navigation.RgInfoForNextDestination;

public class RMLEvoTmcListRow
extends AbstractRMLListRow {
    public RMLEvoTmcListRow(LogChannel logChannel, CombinedRouteListElement combinedRouteListElement, int n, IconHandler iconHandler, NavigationEnv navigationEnv) {
        super(logChannel, combinedRouteListElement, n, iconHandler, navigationEnv);
        this.fillLayout();
        this.fillIcon();
        this.fillDetailsAllowed();
        this.fillDistance();
        this.fillName();
    }

    public RMLEvoTmcListRow(RMLEvoTmcListRow rMLEvoTmcListRow) {
        super(rMLEvoTmcListRow);
    }

    @Override
    protected void fillIcon() {
        IconCell iconCell;
        int n = RMLUtil.getIconTypeIndex(this.combinedRouteListElement, 2, 0);
        if (n != -1) {
            if (this.combinedRouteListElement.getIcons()[n] == null) {
                this.logChannel.log(-1601830656, "RMLEvoTmcListRow#fillIcon() - getIcons()[iconIdx] is null iconIdx = %1", (long)n);
                return;
            }
            NavRouteListDataIcon navRouteListDataIcon = this.combinedRouteListElement.getIcons()[n];
            int n2 = this.iconHandler.resolveTMCIconResourceID(navRouteListDataIcon.getCriteria1(), navRouteListDataIcon.getCriteria2());
            iconCell = new IconCell(new HMIResourceLocator(n2));
        } else {
            iconCell = new IconCell(new HMIResourceLocator(-1));
        }
        this.setIconCell(3, iconCell);
    }

    @Override
    public EvoListRow copy() {
        return new RMLEvoTmcListRow(this);
    }

    @Override
    protected void fillDistance() {
        this.setText(2, Util.formatDistance((int)(this.combinedRouteListElement.getStartDistanceTraffic() - this.combinedRouteListElement.getEndDistanceTraffic()), 1));
    }

    @Override
    protected void fillName() {
        if (RMLUtil.isOffroad(this.combinedRouteListElement)) {
            if (this.env.getRMLLogChannel().isDebug2()) {
                this.env.getRMLLogChannel().log(14808325, "RMLEvoRoadSegmentListRow#fillName - road part is offroad. Fill with TextConstant");
            }
            this.setText(4, TextUtil.getOffRoadName());
        } else {
            this.setText(4, this.combinedRouteListElement.getDescription());
        }
    }

    @Override
    protected void fillDetailsAllowed() {
        this.setInteger(5, 0);
    }

    @Override
    protected void fillLayout() {
        this.setInteger(0, 1);
    }

    @Override
    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
    }
}

