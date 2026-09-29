/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.Distance;
import de.audi.tghu.navi.app.cluster.BAPDistanceFormatter$BAPDistance;

public class BAPDistanceFormatter {
    private final LogChannel logChannel;

    public BAPDistanceFormatter(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public BAPDistanceFormatter$BAPDistance changeUnits(BAPDistanceFormatter$BAPDistance bAPDistanceFormatter$BAPDistance, boolean bl) {
        if (bAPDistanceFormatter$BAPDistance.isMaximumMapScale()) {
            return this.formatMaximumMapScale(BAPDistanceFormatter$BAPDistance.access$000(bAPDistanceFormatter$BAPDistance), bl);
        }
        return this.formatMapScale(BAPDistanceFormatter$BAPDistance.access$000(bAPDistanceFormatter$BAPDistance), bl);
    }

    private int convertFormattedDistanceUnit2BapUnit(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 5: {
                return 0;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 2;
            }
            case 1: 
            case 2: {
                return 4;
            }
        }
        this.logChannel.log(-1601830656, "BAPDistanceFormatter#convertFormattedDistanceUnit2BapUnit - unknown unit: %1", (long)n);
        return 255;
    }

    private int convertFormattedAltitudeUnit2BapUnit(int n) {
        switch (n) {
            case 5: {
                return 0;
            }
            case 3: {
                return 1;
            }
        }
        this.logChannel.log(-1601830656, "BAPDistanceFormatter#convertFormattedAltitudeUnit2BapUnit - unknown unit: %1", (long)n);
        return 255;
    }

    private Distance createFormattedDistanceInstance(int n, int n2, boolean bl) {
        Distance distance = new Distance(n, 5);
        distance.format(bl ? 1 : 2, n2, 2);
        return distance;
    }

    private int getQuarterMiles(int n, int n2, int n3) {
        if (n != 4) {
            return -1;
        }
        if (n3 > 0 && n3 < 100 && n3 % 25 == 0) {
            return 4 * n2 + n3 / 25;
        }
        return -1;
    }

    public BAPDistanceFormatter$BAPDistance formatDistanceToDestination(int n, boolean bl) {
        BAPDistanceFormatter$BAPDistance bAPDistanceFormatter$BAPDistance = this.formatDistance(n, bl, 1);
        if (bAPDistanceFormatter$BAPDistance == BAPDistanceFormatter$BAPDistance.INVALID || bAPDistanceFormatter$BAPDistance.getValue() == 0) {
            bAPDistanceFormatter$BAPDistance = BAPDistanceFormatter$BAPDistance.INVALID_HANDELED_BY_APPCOMBIBAP;
        }
        return bAPDistanceFormatter$BAPDistance;
    }

    public BAPDistanceFormatter$BAPDistance formatDistanceToTurn(int n, boolean bl) {
        BAPDistanceFormatter$BAPDistance bAPDistanceFormatter$BAPDistance = this.formatDistance(n, bl, 5);
        if (bAPDistanceFormatter$BAPDistance == BAPDistanceFormatter$BAPDistance.INVALID || bAPDistanceFormatter$BAPDistance.getValue() == 0) {
            bAPDistanceFormatter$BAPDistance = BAPDistanceFormatter$BAPDistance.INVALID_HANDELED_BY_APPCOMBIBAP;
        }
        return bAPDistanceFormatter$BAPDistance;
    }

    public BAPDistanceFormatter$BAPDistance formatMapScale(int n, boolean bl) {
        return this.formatDistance(n, bl, 4);
    }

    public BAPDistanceFormatter$BAPDistance formatMaximumMapScale(int n, boolean bl) {
        BAPDistanceFormatter$BAPDistance bAPDistanceFormatter$BAPDistance = this.formatMapScale(n, bl);
        return new BAPDistanceFormatter$BAPDistance(-16842752, bAPDistanceFormatter$BAPDistance.getUnit(), n, null);
    }

    private BAPDistanceFormatter$BAPDistance formatDistance(int n, boolean bl, int n2) {
        if (n <= 0) {
            return BAPDistanceFormatter$BAPDistance.invalid();
        }
        Distance distance = this.createFormattedDistanceInstance(n, n2, bl);
        int n3 = distance.getIntegerPortionOfFormattedDistance();
        int n4 = distance.getPureRationalPortionOfFormattedDistance();
        int n5 = this.convertFormattedDistanceUnit2BapUnit(distance.getFormattedUnit());
        if (n3 < 0) {
            return BAPDistanceFormatter$BAPDistance.invalid();
        }
        int n6 = this.getQuarterMiles(n5, n3, n4);
        if (n6 > 0) {
            return new BAPDistanceFormatter$BAPDistance(10 * n6, 5, n, null);
        }
        if (n4 >= 0 && n2 == 4) {
            if (n5 == 1) {
                n5 = 6;
            } else if (n5 == 4) {
                n5 = 7;
            }
        }
        return new BAPDistanceFormatter$BAPDistance(Math.round(distance.getFormattedDistance() * 8257), n5, n, null);
    }

    public BAPDistanceFormatter$BAPDistance formatAltitude(int n, boolean bl) {
        Distance distance = this.createFormattedDistanceInstance(n, 2, bl);
        int n2 = Math.round(distance.getFormattedHeight());
        int n3 = this.convertFormattedAltitudeUnit2BapUnit(distance.getFormattedUnit());
        return new BAPDistanceFormatter$BAPDistance(n2, n3, n, null);
    }
}

