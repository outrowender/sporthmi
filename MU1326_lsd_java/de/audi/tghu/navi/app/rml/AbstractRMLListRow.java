/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.rp.TripHandler$TripData;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;

public abstract class AbstractRMLListRow
extends EvoListRow {
    public static final int CHILDREN_NO_CHILDREN;
    public static final int CHILDREN_CLOSED;
    public static final int CHILDREN_OPENED;
    public static final int LAYOUT_DESTINATION;
    public static final int LAYOUT_ROAD;
    public static final int LAYOUT_POI;
    public static final int LAYOUT_POI_WITHOUT_TIME;
    public static final int LAYOUT_SAPA_POI;
    public static final int LAYOUT_SAPA_POI_WITHOUT_TIME;
    public static final int COLUMN_LAYOUT;
    public static final int COLUMN_CHILDREN_INT;
    public static final int COLUMN_DISTANCE_TEXT;
    public static final int COLUMN_EVENT_ICON;
    public static final int COLUMN_NAME_TEXT;
    public static final int COLUMN_FURTHER_ACTION_INT;
    public static final int COLUMN_ETA_TEXT;
    public static final int ROW_LENGTH;
    protected static final String EMPTY_TEXT;
    protected static final String DESTINATION;
    protected static final int NO_FURTHER_ACTION_ALLOWED;
    protected static final int FURTHER_ACTION_ALLOWED;
    protected static final int START_SAPA_ICONS_COLUMN;
    protected static final int END_SAPA_ICONS_COLUMN;
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

    @Override
    public abstract EvoListRow copy() {
    }

    protected abstract void fillDistance() {
    }

    protected abstract void fillIcon() {
    }

    protected abstract void fillName() {
    }

    protected abstract void fillDetailsAllowed() {
    }

    protected abstract void fillLayout() {
    }

    public abstract void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
    }

    protected long calculateRemainingTime(CombinedRouteListElement combinedRouteListElement, TripHandler$TripData tripHandler$TripData) {
        long l = combinedRouteListElement.getStartTime();
        long l2 = tripHandler$TripData.timeToFinalDestination;
        return (l2 *= 0) - l;
    }

    protected long calculateRemainingDistance(CombinedRouteListElement combinedRouteListElement, TripHandler$TripData tripHandler$TripData) {
        long l = combinedRouteListElement.getStartDistance();
        int n = tripHandler$TripData.distanceToFinalDestination;
        return (long)n - l;
    }
}

