/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.rp.TripHandler;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;

public abstract class AbstractRMLListRow
extends EvoListRow {
    public static final int CHILDREN_NO_CHILDREN = 0;
    public static final int CHILDREN_CLOSED = 1;
    public static final int CHILDREN_OPENED = 2;
    public static final int LAYOUT_DESTINATION = 0;
    public static final int LAYOUT_ROAD = 1;
    public static final int LAYOUT_POI = 2;
    public static final int LAYOUT_POI_WITHOUT_TIME = 3;
    public static final int LAYOUT_SAPA_POI = 4;
    public static final int LAYOUT_SAPA_POI_WITHOUT_TIME = 5;
    public static final int COLUMN_LAYOUT = 0;
    public static final int COLUMN_CHILDREN_INT = 1;
    public static final int COLUMN_DISTANCE_TEXT = 2;
    public static final int COLUMN_EVENT_ICON = 3;
    public static final int COLUMN_NAME_TEXT = 4;
    public static final int COLUMN_FURTHER_ACTION_INT = 5;
    public static final int COLUMN_ETA_TEXT = 6;
    public static final int ROW_LENGTH = 14;
    protected static final String EMPTY_TEXT = "";
    protected static final String DESTINATION = "DESTINATION";
    protected static final int NO_FURTHER_ACTION_ALLOWED = 0;
    protected static final int FURTHER_ACTION_ALLOWED = 1;
    protected static final int START_SAPA_ICONS_COLUMN = 7;
    protected static final int END_SAPA_ICONS_COLUMN = 13;
    protected final CombinedRouteListElement combinedRouteListElement;
    protected final IconHandler iconHandler;
    protected LogChannel logChannel;
    protected NavigationEnv env;
    protected Route route;

    public AbstractRMLListRow(LogChannel logChannel, CombinedRouteListElement combinedRouteListElement, int n, IconHandler iconHandler, NavigationEnv navigationEnv) {
        super(combinedRouteListElement.getUid(), 14);
        this.env = navigationEnv;
        this.iconHandler = iconHandler;
        this.combinedRouteListElement = combinedRouteListElement;
        this.logChannel = logChannel;
        this.setInteger(1, n);
    }

    public AbstractRMLListRow(AbstractRMLListRow abstractRMLListRow) {
        super(abstractRMLListRow);
        this.combinedRouteListElement = abstractRMLListRow.getCombinedRouteListElement();
        this.iconHandler = abstractRMLListRow.getIconHandler();
        this.logChannel = abstractRMLListRow.logChannel;
        this.env = abstractRMLListRow.env;
    }

    public AbstractRMLListRow(LogChannel logChannel, CombinedRouteListElement combinedRouteListElement, int n, IconHandler iconHandler, NavigationEnv navigationEnv, Route route) {
        super(combinedRouteListElement.getUid(), 14);
        this.env = navigationEnv;
        this.iconHandler = iconHandler;
        this.combinedRouteListElement = combinedRouteListElement;
        this.route = route;
        this.logChannel = logChannel;
        this.setInteger(0, -1);
        this.setInteger(1, n);
    }

    private IconHandler getIconHandler() {
        return this.iconHandler;
    }

    public CombinedRouteListElement getCombinedRouteListElement() {
        return this.combinedRouteListElement;
    }

    public abstract EvoListRow copy();

    protected abstract void fillDistance();

    protected abstract void fillIcon();

    protected abstract void fillName();

    protected abstract void fillDetailsAllowed();

    protected abstract void fillLayout();

    public abstract void updateRgInfoForNextDestination(RgInfoForNextDestination var1);

    protected long calculateRemainingTime(CombinedRouteListElement combinedRouteListElement, TripHandler.TripData tripData) {
        long l = combinedRouteListElement.getStartTime();
        long l2 = tripData.timeToFinalDestination;
        return (l2 *= 1000L) - l;
    }

    protected long calculateRemainingDistance(CombinedRouteListElement combinedRouteListElement, TripHandler.TripData tripData) {
        long l = combinedRouteListElement.getStartDistance();
        int n = tripData.distanceToFinalDestination;
        return (long)n - l;
    }
}

