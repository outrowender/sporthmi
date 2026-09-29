/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.rml.listrow;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.icon.ExtRenderingInfo;
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

public class RMLEvoRoadSegmentListRow
extends AbstractRMLListRow {
    public RMLEvoRoadSegmentListRow(LogChannel logChannel, CombinedRouteListElement combinedRouteListElement, int n, IconHandler iconHandler, NavigationEnv navigationEnv) {
        super(logChannel, combinedRouteListElement, n, iconHandler, navigationEnv);
        this.fillLayout();
        this.fillIcon();
        this.fillDetailsAllowed();
        this.fillDistance();
        this.fillName();
    }

    public RMLEvoRoadSegmentListRow(RMLEvoRoadSegmentListRow rMLEvoRoadSegmentListRow) {
        super(rMLEvoRoadSegmentListRow);
    }

    @Override
    protected void fillIcon() {
        if (RMLUtil.isOfType(this.combinedRouteListElement, 7)) {
            this.fillFerrySegmentIcon();
        } else {
            this.fillRoadSegmentIcon();
        }
    }

    private void fillFerrySegmentIcon() {
        int n = RMLUtil.getIconTypeIndex(this.combinedRouteListElement, 1, 0);
        if (n != -1) {
            NavRouteListDataIcon navRouteListDataIcon = this.combinedRouteListElement.getIcons()[n];
            int n2 = this.iconHandler.resolvePOIIconResourceID(navRouteListDataIcon.getCriteria1(), navRouteListDataIcon.getCriteria2());
            IconCell iconCell = new IconCell(new HMIResourceLocator(n2));
            this.setIconCell(3, iconCell);
        } else {
            this.setIconCell(3, new IconCell(new HMIResourceLocator(-1)));
        }
    }

    private void fillRoadSegmentIcon() {
        int n = RMLUtil.getIconTypeIndex(this.combinedRouteListElement, 0, 0);
        if (n != -1) {
            ExtRenderingInfo extRenderingInfo;
            NavRouteListDataIcon navRouteListDataIcon = this.combinedRouteListElement.getIcons()[n];
            if (!Util.isEmpty(this.combinedRouteListElement.getStreetIconText()) && (extRenderingInfo = this.iconHandler.resolveStreetIconResourceID(navRouteListDataIcon.getCriteria1(), this.combinedRouteListElement.getStreetIconText().length())) != null && extRenderingInfo.isValid()) {
                IconCell iconCell = new IconCell(new HMIResourceLocator(-1));
                iconCell.initializeIconTextLocator(new HMIResourceLocator(extRenderingInfo.getResourceId()), this.combinedRouteListElement.getStreetIconText(), extRenderingInfo.getFontSize(), extRenderingInfo.getFontSize(), extRenderingInfo.getFontColor(), extRenderingInfo.getDeltaX(), extRenderingInfo.getDeltaY());
                this.setIconCell(3, iconCell);
                return;
            }
        }
        this.setIconCell(3, new IconCell(new HMIResourceLocator(-1)));
    }

    @Override
    public EvoListRow copy() {
        return new RMLEvoRoadSegmentListRow(this);
    }

    @Override
    protected void fillDistance() {
        this.setText(2, Util.formatDistance((int)(this.combinedRouteListElement.getStartDistance() - this.combinedRouteListElement.getEndDistance()), 1));
    }

    @Override
    protected void fillName() {
        if (!Util.isHURegionAsia()) {
            IconCell iconCell = (IconCell)this.getCell(3);
            if (RMLUtil.isOffroad(this.combinedRouteListElement)) {
                if (this.env.getRMLLogChannel().isDebug2()) {
                    this.env.getRMLLogChannel().log(14808325, "RMLEvoRoadSegmentListRow#fillName - road part is offroad. Fill with TextConstant");
                }
                this.setText(4, TextUtil.getOffRoadName());
            } else if (iconCell.getResourceLocator().getResourceID() == -1) {
                this.setText(4, this.combinedRouteListElement.getDescription());
            } else {
                this.setText(4, "");
            }
        } else if (RMLUtil.isOffroad(this.combinedRouteListElement)) {
            if (this.env.getRMLLogChannel().isDebug2()) {
                this.env.getRMLLogChannel().log(14808325, "RMLEvoRoadSegmentListRow#fillName - road part is offroad. Fill with TextConstant");
            }
            this.setText(4, TextUtil.getOffRoadName());
        } else {
            String string = this.combinedRouteListElement.getDescription();
            this.setText(4, Util.isEmpty(string) ? "" : string);
        }
    }

    @Override
    protected void fillDetailsAllowed() {
        int n = this.getInteger(1);
        if (n == 1 || n == 2) {
            this.setInteger(5, 1);
        } else {
            this.setInteger(5, 0);
        }
    }

    @Override
    protected void fillLayout() {
        this.setInteger(0, 1);
    }

    @Override
    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
    }
}

