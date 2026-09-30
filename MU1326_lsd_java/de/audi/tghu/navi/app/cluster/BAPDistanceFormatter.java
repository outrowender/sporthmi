/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.Distance;
import de.esolutions.fw.util.commons.Buffer;

public class BAPDistanceFormatter {
    private final LogChannel logChannel;

    public BAPDistanceFormatter(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public BAPDistance changeUnits(BAPDistance bAPDistance, boolean bl) {
        if (bAPDistance.isMaximumMapScale()) {
            return this.formatMaximumMapScale(bAPDistance.meters, bl);
        }
        return this.formatMapScale(bAPDistance.meters, bl);
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
        this.logChannel.log(100000, "BAPDistanceFormatter#convertFormattedDistanceUnit2BapUnit - unknown unit: %1", (long)n);
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
        this.logChannel.log(100000, "BAPDistanceFormatter#convertFormattedAltitudeUnit2BapUnit - unknown unit: %1", (long)n);
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

    public BAPDistance formatDistanceToDestination(int n, boolean bl) {
        BAPDistance bAPDistance = this.formatDistance(n, bl, 1);
        if (bAPDistance == BAPDistance.INVALID || bAPDistance.getValue() == 0) {
            bAPDistance = BAPDistance.INVALID_HANDELED_BY_APPCOMBIBAP;
        }
        return bAPDistance;
    }

    public BAPDistance formatDistanceToTurn(int n, boolean bl) {
        BAPDistance bAPDistance = this.formatDistance(n, bl, 5);
        if (bAPDistance == BAPDistance.INVALID || bAPDistance.getValue() == 0) {
            bAPDistance = BAPDistance.INVALID_HANDELED_BY_APPCOMBIBAP;
        }
        return bAPDistance;
    }

    public BAPDistance formatMapScale(int n, boolean bl) {
        return this.formatDistance(n, bl, 4);
    }

    public BAPDistance formatMaximumMapScale(int n, boolean bl) {
        BAPDistance bAPDistance = this.formatMapScale(n, bl);
        return new BAPDistance(65534, bAPDistance.getUnit(), n);
    }

    private BAPDistance formatDistance(int n, boolean bl, int n2) {
        if (n <= 0) {
            return BAPDistance.invalid();
        }
        Distance distance = this.createFormattedDistanceInstance(n, n2, bl);
        int n3 = distance.getIntegerPortionOfFormattedDistance();
        int n4 = distance.getPureRationalPortionOfFormattedDistance();
        int n5 = this.convertFormattedDistanceUnit2BapUnit(distance.getFormattedUnit());
        if (n3 < 0) {
            return BAPDistance.invalid();
        }
        int n6 = this.getQuarterMiles(n5, n3, n4);
        if (n6 > 0) {
            return new BAPDistance(10 * n6, 5, n);
        }
        if (n4 >= 0 && n2 == 4) {
            if (n5 == 1) {
                n5 = 6;
            } else if (n5 == 4) {
                n5 = 7;
            }
        }
        return new BAPDistance(Math.round(distance.getFormattedDistance() * 10.0f), n5, n);
    }

    public BAPDistance formatAltitude(int n, boolean bl) {
        Distance distance = this.createFormattedDistanceInstance(n, 2, bl);
        int n2 = Math.round(distance.getFormattedHeight());
        int n3 = this.convertFormattedAltitudeUnit2BapUnit(distance.getFormattedUnit());
        return new BAPDistance(n2, n3, n);
    }

    public static class BAPDistance {
        private final int value;
        private final int unit;
        private final int meters;
        public static final BAPDistance INVALID = new BAPDistance(0, 0, 0);
        public static final BAPDistance INVALID_HANDELED_BY_APPCOMBIBAP = new BAPDistance(-1, 0, -1);

        private BAPDistance(int n, int n2, int n3) {
            this.value = n;
            this.unit = n2;
            this.meters = n3;
        }

        public int getValue() {
            return this.value;
        }

        public int getUnit() {
            return this.unit;
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("BAPDistance[value = ");
            buffer.append(this.value);
            buffer.append(", unit = ");
            buffer.append(this.unit);
            buffer.append("]");
            return buffer.toString();
        }

        public static BAPDistance invalid() {
            return INVALID;
        }

        public boolean isMaximumMapScale() {
            return this.value == 65534;
        }
    }
}

