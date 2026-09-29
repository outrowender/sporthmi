/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.predictivenav;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.Vehicle;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import java.util.Date;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.predictivenavigation.LikelyDestination;

public class PredictiveNavListRow
extends EvoListRow {
    protected static final int COLUMN_LAYOUT;
    protected static final int COLUMN_PNAV_ICON_ID;
    protected static final int COLUMN_DESTINATION_FIRST_LINE;
    protected static final int COLUMN_DESTINATION_SECOND_LINE;
    protected static final int COLUMN_DESTINATION_ICON_ID;
    protected static final int COLUMN_ETA;
    protected static final int COLUMN_DIRECTION;
    protected static final int COLUMN_DISTANCE;
    protected static final int COLUMN_TRAFFIC_ICON_ID;
    protected static final int COLUMN_TRAFFIC_OFFSET;
    protected static final int COLUMN_PROPERTIES;
    protected static final int NUMBER_OF_COLUMNS;
    private static final int LAYOUT_NO_EVENT;
    private static final int LAYOUT_DELAY;
    private static final int LAYOUT_BLOCKED;
    private static final int LAYOUT_NOT_CALCULATED_YET;
    public static final int FLAG_NOT_VISIBLE;
    public static final int FLAG_VISIBLE;
    private static final int INVALID_ETA;
    private static final int ICON_NO_ICON_ID;
    private static final int ICON_DELAY_ID;
    private static final int ICON_BLOCKED_ID;
    private static final int ICON_DELAY_NAR_ID;
    private static final int ICON_BLOCKED_NAR_ID;
    protected static long idCounter;
    protected NavigationEnv env = null;
    protected LogChannel logChannel = null;
    protected LikelyDestination likelyDestination = null;

    public PredictiveNavListRow(NavigationEnv navigationEnv, LikelyDestination likelyDestination) {
        super(idCounter++, 11);
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getPredictiveNavigationLogChannel();
        this.likelyDestination = likelyDestination;
        this.updateInformation(likelyDestination);
    }

    public PredictiveNavListRow(PredictiveNavListRow predictiveNavListRow) {
        super(predictiveNavListRow);
        if (predictiveNavListRow != null) {
            this.env = predictiveNavListRow.env;
            this.logChannel = predictiveNavListRow.logChannel;
            this.likelyDestination = predictiveNavListRow.likelyDestination;
        }
    }

    public void updateInformation(LikelyDestination likelyDestination) {
        this.likelyDestination = likelyDestination;
        this.updateInformation();
    }

    public LikelyDestination getLikelyDestination() {
        return this.likelyDestination;
    }

    private void updateInformation() {
        DateMetric dateMetric = this.likelyDestination.timeDelay >= 0L ? this.getEtaAsDateMetric(this.env.getFramework().getKombiTime() + this.likelyDestination.remainingTravelTime, true) : this.getEtaAsDateMetric(-1L, false);
        if (this.likelyDestination.getCalculationState() == 1) {
            this.setInteger(0, 3);
        } else if (this.likelyDestination.timeDelay == 0L) {
            this.setInteger(0, 0);
            this.setInteger(8, 0);
        } else if (this.likelyDestination.timeDelay > 0L) {
            DateMetric dateMetric2 = this.getTrafficDelayAsDateMetric(this.likelyDestination.timeDelay, true);
            this.setInteger(0, 1);
            this.setInteger(8, this.getDelayIcon());
            this.setMetrics(9, dateMetric2);
        } else {
            DateMetric dateMetric3 = this.getTrafficDelayAsDateMetric(this.likelyDestination.timeDelay, true);
            this.setInteger(0, 2);
            this.setInteger(8, this.getBlockedIcon());
            this.setMetrics(9, dateMetric3);
        }
        this.setInteger(1, this.likelyDestination.getRouteColor());
        this.setDestinationInformation();
        this.setInteger(4, 1);
        this.setMetrics(5, dateMetric);
        Distance distance = new Distance(this.likelyDestination.distance, 5);
        this.setMetrics(7, distance);
        PosPosition posPosition = Vehicle.getInstance().getPosition();
        int n = Util.computeAbsoluteDirection(posPosition, this.likelyDestination.getDestination().getLongitude(), this.likelyDestination.getDestination().getLatitude());
        int n2 = Util.convertRotatingDirection(n, posPosition.directionAngle);
        this.setDirection(n2);
    }

    public void setDestinationInformation() {
        LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatTwoLines(this.likelyDestination.getDestination(), this.env);
        this.setText(2, locationFormattingResponse.getFirstLineAsText());
        this.setText(3, locationFormattingResponse.getSecondLineAsText());
    }

    private DateMetric getEtaAsDateMetric(long l, boolean bl) {
        DateMetric dateMetric = new DateMetric(new Date(l), 1);
        dateMetric.setDateValid(bl);
        return dateMetric;
    }

    private DateMetric getTrafficDelayAsDateMetric(long l, boolean bl) {
        DateMetric dateMetric = new DateMetric(new Date(l), 7);
        dateMetric.setDate(l);
        dateMetric.setDateValid(bl);
        return dateMetric;
    }

    private int getDelayIcon() {
        if (this.env.getFramework().isNar()) {
            return 3;
        }
        return 1;
    }

    private int getBlockedIcon() {
        if (this.env.getFramework().isNar()) {
            return 4;
        }
        return 2;
    }

    public int getLayout() {
        return this.getInteger(0);
    }

    public int getPNavIconID() {
        return this.getInteger(1);
    }

    public String getDestinationFirstLine() {
        return this.getText(2);
    }

    public String getDestinationSecondLine() {
        return this.getText(3);
    }

    public int getDestinationIconID() {
        return this.getInteger(4);
    }

    public DateMetric getETA() {
        return (DateMetric)this.getMetrics(5);
    }

    public void setDirection(int n) {
        this.setInteger(6, n);
    }

    public int getDirection() {
        return this.getInteger(6);
    }

    public Distance getDistance() {
        return (Distance)this.getMetrics(7);
    }

    public int getTrafficIconID() {
        return this.getInteger(8);
    }

    public DateMetric getTrafficOffset() {
        return (DateMetric)this.getMetrics(9);
    }

    public NavLocation getDestination() {
        return this.likelyDestination.getDestination();
    }

    @Override
    public EvoListRow copy() {
        return new PredictiveNavListRow(this);
    }

    static {
        idCounter = 1L;
    }
}

