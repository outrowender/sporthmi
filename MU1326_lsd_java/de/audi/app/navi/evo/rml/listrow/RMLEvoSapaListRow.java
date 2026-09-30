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
import de.audi.tghu.navi.app.rp.TripHandler;
import de.audi.tghu.navi.app.util.Util;
import java.util.Date;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.NavRouteListDataIcon;
import org.dsi.ifc.navigation.RgInfoForNextDestination;

public class RMLEvoSapaListRow
extends AbstractRMLListRow {
    private static final int ONE_MINUTE_IN_MS = 60000;
    private static final int SAPA_ICON_POSITION = 0;
    private IRouteManager routeManager;

    public RMLEvoSapaListRow(LogChannel logChannel, CombinedRouteListElement combinedRouteListElement, int n, IconHandler iconHandler, NavigationEnv navigationEnv, IRouteManager iRouteManager) {
        super(logChannel, combinedRouteListElement, n, iconHandler, navigationEnv);
        this.routeManager = iRouteManager;
        this.fillLayout();
        this.fillDetailsAllowed();
        this.fillIcon();
        this.fillDistance();
        this.fillName();
    }

    public RMLEvoSapaListRow(RMLEvoSapaListRow rMLEvoSapaListRow) {
        super(rMLEvoSapaListRow);
        this.routeManager = rMLEvoSapaListRow.routeManager;
    }

    public EvoListRow copy() {
        return new RMLEvoSapaListRow(this);
    }

    protected void fillDistance() {
        if (RMLUtil.isCountryChange(this.combinedRouteListElement)) {
            return;
        }
        TripHandler.TripData tripData = this.routeManager.getTripDataAuto();
        long l = this.calculateRemainingDistance(this.combinedRouteListElement, tripData);
        long l2 = this.calculateRemainingTime(this.combinedRouteListElement, tripData);
        String string = Util.formatDistance((int)l, 1);
        this.setText(2, string);
        this.setMetrics(6, new DateMetric(new Date(l2), 11));
        if (l2 < 60000L) {
            this.setInteger(0, 5);
        } else {
            this.setInteger(0, 4);
        }
    }

    protected void fillIcon() {
        NavRouteListDataIcon navRouteListDataIcon = this.combinedRouteListElement.getIcons()[0];
        int n = this.iconHandler.resolvePOIIconResourceID(navRouteListDataIcon.getCriteria1(), navRouteListDataIcon.getCriteria2());
        IconCell iconCell = new IconCell(new HMIResourceLocator(n));
        this.setIconCell(3, iconCell);
        if (this.getInteger(5) == 1) {
            int n2 = this.combinedRouteListElement.getIcons().length - 1;
            int n3 = n2 + 7;
            n3 = n3 > 13 ? 13 : n3;
            int n4 = 1;
            for (int i2 = 7; i2 < n3; ++i2) {
                NavRouteListDataIcon navRouteListDataIcon2 = this.combinedRouteListElement.getIcons()[n4];
                int n5 = this.iconHandler.resolvePOIIconResourceID(navRouteListDataIcon2.getCriteria1(), navRouteListDataIcon2.getCriteria2());
                IconCell iconCell2 = new IconCell(new HMIResourceLocator(n5));
                this.setIconCell(i2, iconCell2);
                ++n4;
            }
        }
    }

    protected void fillName() {
        this.setText(4, this.combinedRouteListElement.getDescription());
    }

    protected void fillDetailsAllowed() {
        this.setInteger(5, 1);
    }

    protected void fillLayout() {
        if (RMLUtil.isCountryChange(this.combinedRouteListElement)) {
            this.setInteger(0, 1);
        } else {
            this.setInteger(0, 4);
        }
    }

    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
        this.fillDistance();
    }
}

