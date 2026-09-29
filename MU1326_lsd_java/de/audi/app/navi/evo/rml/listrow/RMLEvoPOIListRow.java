/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.rml.listrow;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.hierarchiclist.rml.RMLUtil;
import de.audi.tghu.navi.app.rml.AbstractRMLListRow;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.rp.TripHandler$TripData;
import de.audi.tghu.navi.app.util.Util;
import java.util.Date;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.NavRouteListDataIcon;
import org.dsi.ifc.navigation.RgInfoForNextDestination;

public class RMLEvoPOIListRow
extends AbstractRMLListRow {
    private static final int ONE_MINUTE_IN_MS;
    private IRouteManager routeManager;

    public RMLEvoPOIListRow(LogChannel logChannel, CombinedRouteListElement combinedRouteListElement, int n, IconHandler iconHandler, NavigationEnv navigationEnv, IRouteManager iRouteManager) {
        super(logChannel, combinedRouteListElement, n, iconHandler, navigationEnv);
        this.routeManager = iRouteManager;
        this.fillLayout();
        this.fillIcon();
        this.fillDetailsAllowed();
        this.fillDistance();
        this.fillName();
    }

    public RMLEvoPOIListRow(RMLEvoPOIListRow rMLEvoPOIListRow) {
        super(rMLEvoPOIListRow);
        this.routeManager = rMLEvoPOIListRow.routeManager;
    }

    @Override
    public EvoListRow copy() {
        return new RMLEvoPOIListRow(this);
    }

    @Override
    protected void fillDistance() {
        if (RMLUtil.isCountryChange(this.combinedRouteListElement)) {
            return;
        }
        TripHandler$TripData tripHandler$TripData = this.routeManager.getTripDataAuto();
        long l = this.calculateRemainingDistance(this.combinedRouteListElement, tripHandler$TripData);
        long l2 = this.calculateRemainingTime(this.combinedRouteListElement, tripHandler$TripData);
        String string = Util.formatDistance((int)l, 1);
        this.setText(2, string);
        this.setMetrics(6, new DateMetric(new Date(l2), 11));
        if (l2 < 0) {
            this.setInteger(0, 3);
        } else {
            this.setInteger(0, 2);
        }
    }

    @Override
    protected void fillIcon() {
        int n = RMLUtil.getIconTypeIndex(this.combinedRouteListElement, 1, 0);
        if (n != -1) {
            NavRouteListDataIcon navRouteListDataIcon = this.combinedRouteListElement.getIcons()[n];
            int n2 = this.iconHandler.resolvePOIIconResourceID(navRouteListDataIcon.getCriteria1(), navRouteListDataIcon.getCriteria2());
            IconCell iconCell = new IconCell(new HMIResourceLocator(n2));
            this.setIconCell(3, iconCell);
            return;
        }
        this.setIconCell(3, new IconCell(new HMIResourceLocator(-1)));
    }

    @Override
    protected void fillName() {
        this.setText(4, this.combinedRouteListElement.getDescription());
    }

    @Override
    protected void fillDetailsAllowed() {
        this.setInteger(5, 1);
    }

    @Override
    protected void fillLayout() {
        if (RMLUtil.isCountryChange(this.combinedRouteListElement)) {
            this.setInteger(0, 1);
        } else {
            this.setInteger(0, 2);
        }
    }

    @Override
    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
        this.fillDistance();
    }
}

