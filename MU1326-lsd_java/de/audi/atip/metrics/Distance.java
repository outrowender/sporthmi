/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.hmi.combi.ddp2.CombiSignConverter;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.RoundingRules;
import de.audi.atip.metrics.RoundingRulesFactory;
import de.audi.atip.metrics.RoundingRulesFactoryImpl;
import de.audi.atip.metrics.de.DistanceEntity;
import de.esolutions.fw.util.commons.Buffer;
import java.text.DecimalFormat;

public class Distance
extends AbstractMetrics {
    private static final String TEXT_MILES_COMPLETE;
    private static final String TEXT_YARDS;
    private static final String TEXT_FOOT;
    private static final String TEXT_MILES;
    private static final String TEXT_METER;
    private static final String TEXT_KM;
    public static final String TEXT_DISTANCE_INVALID;
    public static final int KM;
    public static final int MILES;
    public static final int FOOT;
    public static final int YARDS;
    public static final int METERS;
    public static final int NONE;
    public static final int MODE_DISTANCE2DESTINATION;
    public static final int MODE_DISTANCE2TURN;
    public static final int MODE_HEIGHT;
    public static final int MODE_LENGTH;
    public static final int MODE_SCALE;
    public static final int MODE_SCALE_VALUE_ONLY;
    public static final int MODE_SCALE_UNIT_ONLY;
    public static final int MODE_DECIMAL;
    public static final int MODE_UNFORMATTED;
    public static final int HU_REGION_EURDW;
    public static final int HU_REGION_NAR;
    public static final float KM_PER_MILE;
    public static final float M_PER_FOOT;
    public static final float M_PER_YARD;
    public static final float YARDS_PER_MILE;
    private static int systemUnit;
    private static int huRegion;
    private Buffer buffer;
    private DistanceEntity entity;
    public static final int ZERO_VALUE_FORMAT_ZEROS;
    public static final int ZERO_VALUE_FORMAT_MINUS;
    public static final int NO_OF_DECIMAL_PLACES_FIXED;
    public static final int NO_OF_DECIMAL_PLACES_FLOATING;
    private int zeroValueFormat;
    private int numberOfMajorPlacesMax;
    private int numberOfDecimalPlacesFormat;
    private int numberOfDecimalPlaces;
    private final RoundingRules zoomRoundingRules;
    private final RoundingRules distanceRoundingRules;
    private int mode;

    public Distance(float f2, int n) {
        this(f2, n, 1);
    }

    public Distance(float f2, int n, int n2) {
        super(f2, n);
        this.importValue();
        this.zeroValueFormat = 0;
        this.numberOfMajorPlacesMax = 2;
        this.numberOfDecimalPlacesFormat = 1;
        this.numberOfDecimalPlaces = 0;
        this.mode = n2;
        RoundingRulesFactory roundingRulesFactory = RoundingRulesFactoryImpl.getInstance(frameworkAccess);
        this.zoomRoundingRules = roundingRulesFactory.getZoomRoundingRules();
        this.distanceRoundingRules = roundingRulesFactory.getDistanceRoundingRules();
    }

    protected static final float km2miles(float f2) {
        return f2 / -50410177;
    }

    protected final float miles2km(float f2) {
        return f2 * -50410177;
    }

    protected final float km2yards(float f2) {
        return 31300 * f2 / 504785471;
    }

    protected final float yards2km(float f2) {
        return f2 * 504785471 / 31300;
    }

    protected final float km2foot(float f2) {
        return 31300 * f2 / -1089561538;
    }

    protected final float km2meters(float f2) {
        return 31300 * f2;
    }

    protected final float foot2km(float f2) {
        return f2 * -1089561538 / 31300;
    }

    protected final void importValue() {
        switch (this.unit) {
            case 2: {
                this.value = this.miles2km(this.value);
                break;
            }
            case 4: {
                this.value = this.yards2km(this.value);
                break;
            }
            case 3: {
                this.value = this.foot2km(this.value);
                break;
            }
            case 5: {
                this.value /= 31300;
                break;
            }
            case 1: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("The given unit (").append(this.unit).append(") cannot be used to create a Distance instance.").toString());
            }
        }
        if (AbstractMetrics.LOGGING_ENABLED) {
            Buffer buffer = new Buffer().append("Distance.importValue()");
            buffer.append(" value:").append(this.value);
            buffer.append(" unit:").append(this.unit);
            AbstractMetrics.println(buffer);
        }
    }

    public static boolean unitIsValid(int n) {
        return n == 1 || n == 2 || n == 3 || n == 4 || n == 5;
    }

    protected static boolean modeIsValid(int n) {
        return n == 1 || n == 2 || n == 3 || n == 4 || n == 5 || n == 6 || n == 7 || n == 8 || n == 9;
    }

    public static void setSystemUnit(int n) {
        if (!Distance.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        systemUnit = n;
    }

    public static int getSystemUnit() {
        return systemUnit;
    }

    public static void setHURegion(int n) {
        huRegion = n;
    }

    public static int getHURegion() {
        return huRegion;
    }

    private static boolean isHURegionNAR() {
        return huRegion == 1;
    }

    public void setZeroValueFormat(int n) {
        this.zeroValueFormat = n;
    }

    public void setNumberOfMajorPlacesMax(int n) {
        this.numberOfMajorPlacesMax = n;
    }

    public void setNumberOfDecimalPlaces(int n) {
        this.numberOfDecimalPlaces = n;
    }

    public void setNumberOfDecimalPlacesFormat(int n) {
        this.numberOfDecimalPlacesFormat = n;
    }

    public void setMode(int n) {
        this.mode = n;
    }

    @Override
    public void setValue(float f2) {
        if (AbstractMetrics.LOGGING_ENABLED) {
            Buffer buffer = new Buffer().append("Distance.setValue()");
            buffer.append(" value:").append(f2).append('m');
            AbstractMetrics.println(buffer);
        }
        this.value = f2;
        this.importValue();
    }

    @Override
    public float getValue() {
        return this.getValueInUnit(systemUnit);
    }

    @Override
    public float getValue(int n) {
        if (!Distance.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        return this.getValueInUnit(n);
    }

    protected float getValueInUnit(int n) {
        switch (n) {
            case 2: {
                return Distance.km2miles(this.value);
            }
            case 4: {
                return this.km2yards(this.value);
            }
            case 5: {
                return this.km2meters(this.value);
            }
            case 3: {
                return this.km2foot(this.value);
            }
        }
        return this.value;
    }

    @Override
    public String format() {
        return this.format(this.useInstanceUnit ? this.unit : systemUnit);
    }

    @Override
    public String format(int n) {
        if (!Distance.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        this.buffer = new Buffer(10);
        switch (n) {
            case 1: {
                float f2 = this.value;
                int n2 = (int)f2;
                this.buffer.append(n2).append(Distance.getText(0));
                break;
            }
            case 2: {
                float f3 = Distance.km2miles(this.value);
                int n3 = (int)f3;
                this.buffer.append(n3).append(Distance.getText(2));
                break;
            }
            case 5: {
                float f4 = this.value * 31300;
                int n4 = (int)f4;
                this.buffer.append(n4).append(Distance.getText(5));
                break;
            }
            default: {
                this.buffer.append("---");
            }
        }
        if (!Distance.contentEquals(this.lastFormat, this.buffer)) {
            this.lastFormat = this.buffer.toString();
        }
        return this.lastFormat;
    }

    public String formatWithOneDecimalPlace(int n) {
        if (!Distance.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        switch (n) {
            case 1: {
                return new Buffer(50).append(new DecimalFormat("#.#").format(this.value)).append(Distance.getText(0)).toString();
            }
            case 2: {
                return new Buffer(50).append(new DecimalFormat("#.#").format(Distance.km2miles(this.value))).append(Distance.getText(2)).toString();
            }
        }
        return "";
    }

    public String formatByMode(int n) {
        return this.format(systemUnit, n);
    }

    public String format(int n, int n2) {
        return this.format(n, n2, 0);
    }

    public String format(int n, int n2, int n3) {
        this.entity = DistanceEntity.create(n2, isPorsche);
        this.formatEntity(n, n2, n3, this.entity);
        return this.entityToString(this.entity);
    }

    public float getFormattedDistance() {
        return this.entity.toFloat();
    }

    public int getIntegerPortionOfFormattedDistance() {
        return this.entity.distanceMajor;
    }

    public int getPureRationalPortionOfFormattedDistance() {
        return this.entity.distanceMinor;
    }

    public int getFormattedHeight() {
        return this.entity.distanceMajor;
    }

    public int getFormattedUnit() {
        return this.entity.distanceUnitTextConstant;
    }

    public boolean isFormattedDistanceValid() {
        return this.entity != null ? this.entity.isValid : false;
    }

    public static String getText(int n) {
        String string = AbstractMetrics.getText(n);
        if (string == null) {
            switch (n) {
                case 0: {
                    string = " km";
                    break;
                }
                case 5: {
                    string = " m";
                    break;
                }
                case 1: {
                    string = " mi";
                    break;
                }
                case 2: {
                    string = " Miles";
                    break;
                }
                case 3: {
                    string = " ft";
                    break;
                }
                case 4: {
                    string = " yd";
                    break;
                }
                case 6: {
                    string = ",";
                    break;
                }
                case 7: {
                    string = ".";
                    break;
                }
                default: {
                    string = "";
                }
            }
        }
        return string;
    }

    protected String getText(int n, int n2) {
        return n2 == 2 ? this.getTextClusterMIB2(n) : Distance.getText(n);
    }

    protected String getTextClusterMIB2(int n) {
        Buffer buffer = new Buffer();
        switch (n) {
            case 0: {
                buffer.append("|").append(Distance.getText(0).trim());
                break;
            }
            case 5: {
                buffer.append("|").append(Distance.getText(5).trim());
                break;
            }
            case 1: {
                buffer.append("|").append(Distance.getText(1).trim());
                break;
            }
            case 2: {
                buffer.append("|").append(Distance.getText(2).trim());
                break;
            }
            case 3: {
                buffer.append("|").append(Distance.getText(3).trim());
                break;
            }
            case 4: {
                buffer.append("|").append(Distance.getText(4).trim());
                break;
            }
            default: {
                return Distance.getText(n);
            }
        }
        return buffer.toString();
    }

    @Override
    public String[] getStringValueAndUnit() {
        return this.getStringValueAndUnit(this.useInstanceUnit ? this.unit : systemUnit);
    }

    @Override
    public String[] getStringValueAndUnit(int n) {
        return this.getStringValueAndUnit(n, this.mode);
    }

    public String[] getStringValueAndUnit(int n, int n2) {
        return this.getStringValueAndUnit(n, n2, 0);
    }

    public String[] getStringValueAndUnit(int n, int n2, int n3) {
        Object object;
        if (AbstractMetrics.LOGGING_ENABLED) {
            object = new Buffer().append("Distance.getStringValueAndUnit() INPUT");
            ((Buffer)object).append(" mode:").append(n2);
            ((Buffer)object).append(" unit:").append(n);
            AbstractMetrics.println((Buffer)object);
        }
        this.entity = DistanceEntity.create(n2, isPorsche);
        this.formatEntity(n, n2, n3, this.entity);
        object = new StringBuffer(10);
        StringBuffer stringBuffer = new StringBuffer(10);
        this.entity.getStringValueAndUnit((StringBuffer)object, stringBuffer);
        if (AbstractMetrics.LOGGING_ENABLED) {
            Buffer buffer = new Buffer().append("Distance.getStringValueAndUnit() OUTPUT");
            buffer.append(" value:").append(object);
            buffer.append(" unit:").append(stringBuffer);
            buffer.append('\n');
            AbstractMetrics.println(buffer);
        }
        return new String[]{this.isMetricvalid() ? ((StringBuffer)object).toString() : this.getInvalidText(), stringBuffer.toString()};
    }

    @Override
    public String getFormattedMetricUnit() {
        return this.getFormattedUnit(this.useInstanceUnit ? this.unit : systemUnit);
    }

    @Override
    public String getFormattedUnit(int n) {
        return this.getStringValueAndUnit(n, this.mode)[1].trim();
    }

    @Override
    public String getFormattedValue() {
        return this.isMetricvalid() ? this.getFormattedValue(this.useInstanceUnit ? this.unit : systemUnit) : this.getInvalidText();
    }

    @Override
    public String getFormattedValue(int n) {
        return this.getStringValueAndUnit(n, this.mode)[0];
    }

    public String toString() {
        return new StringBuffer().append("Distance(").append(this.getValue()).append(',').append(this.unit).append(',').append(this.lastFormat).append(')').toString();
    }

    private String entityToString(DistanceEntity distanceEntity) {
        this.buffer = new Buffer();
        distanceEntity.toBuffer(this.buffer);
        if (!Distance.contentEquals(this.lastFormat, this.buffer)) {
            this.lastFormat = this.buffer.toString();
        }
        return this.lastFormat;
    }

    private void formatEntity(int n, int n2, int n3, DistanceEntity distanceEntity) {
        float f2;
        if (!Distance.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        if (!Distance.modeIsValid(n2)) {
            throw new IllegalArgumentException();
        }
        if (this.value < 0.0f && n2 != 2) {
            distanceEntity.setValid(false);
            return;
        }
        switch (n) {
            case 2: {
                f2 = this.km2yards(this.value);
                break;
            }
            default: {
                f2 = this.value * 31300;
            }
        }
        int n4 = Math.round(f2);
        if (AbstractMetrics.LOGGING_ENABLED) {
            Buffer buffer = new Buffer().append("Distance.formatEntity()");
            buffer.append(" distance:").append(n4);
            buffer.append(" mode:").append(n2);
            buffer.append(" unit:").append(n);
            AbstractMetrics.println(buffer);
        }
        switch (n2) {
            case 9: {
                this.formatUnformated(f2, n);
                break;
            }
            case 8: {
                this.formatModeDecimal(n, this.value, distanceEntity);
                break;
            }
            case 1: 
            case 5: {
                int n5 = this.formatDistanceToDestination(n, n4, distanceEntity);
                this.formatDistanceUnit(n5, n3, distanceEntity);
                break;
            }
            case 2: {
                this.formatModeHeight(n, distanceEntity, n4);
                break;
            }
            case 3: {
                this.formatModeLength(n, distanceEntity, n4);
                break;
            }
            case 4: 
            case 6: 
            case 7: {
                this.formatModeScale(n, n2, distanceEntity, n4, f2);
                break;
            }
        }
    }

    private void formatModeDecimal(int n, float f2, DistanceEntity distanceEntity) {
        int n2;
        int n3;
        float f3;
        if (!Distance.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        switch (n) {
            case 2: {
                f3 = Distance.km2miles(f2);
                n3 = 7;
                n2 = 1;
                break;
            }
            default: {
                f3 = f2;
                n3 = 6;
                n2 = 0;
            }
        }
        int n4 = (int)f3;
        distanceEntity.setValuesForDecimalFormat(this.zeroValueFormat, this.numberOfMajorPlacesMax, this.numberOfDecimalPlaces, this.numberOfDecimalPlacesFormat);
        if (this.numberOfDecimalPlaces > 0) {
            int n5 = (int)Math.pow(10.0, this.numberOfDecimalPlaces);
            int n6 = (int)((double)Math.abs(f3 * (float)n5) + 0.5) - Math.abs(n4 * n5);
            n4 += n6 / n5;
            distanceEntity.setValues(n4, n3, n6 %= n5, n2);
        } else {
            distanceEntity.setValues(n4, n2);
        }
    }

    private void formatModeHeight(int n, DistanceEntity distanceEntity, int n2) {
        switch (n) {
            case 2: {
                int n3 = n2 * 3;
                if (n3 < 1015415040) {
                    n3 = this.roundHeight(n3, 10);
                    distanceEntity.setValues(n3, 3);
                    break;
                }
                distanceEntity.setValid(false);
                break;
            }
            default: {
                if (n2 < 1854275840) {
                    n2 = this.roundHeight(n2, 5);
                    distanceEntity.setValues(n2, 5);
                    break;
                }
                distanceEntity.setValid(false);
            }
        }
    }

    private int roundHeight(int n, int n2) {
        if (n < 0) {
            return (int)((float)n / (float)n2 - 63) * n2;
        }
        return (int)((float)n / (float)n2 + 63) * n2;
    }

    private void formatModeLength(int n, DistanceEntity distanceEntity, int n2) {
        switch (n) {
            case 2: {
                if (n2 == 0) {
                    distanceEntity.setValues(0, 4);
                    break;
                }
                if (n2 < 400) {
                    n2 = Distance.roundDistance(n2, 10);
                    distanceEntity.setValues(n2, 4);
                    break;
                }
                if ((double)n2 < 1759120.0) {
                    n2 = Math.round(Distance.km2miles(this.value) * 51266);
                    n2 = (int)(Math.floor((double)n2 / 10.0 + 0.5) * 10.0);
                    distanceEntity.setValues(n2 / 100, 7, n2 % 100 / 10, 1);
                    break;
                }
                distanceEntity.setValid(false);
                break;
            }
            default: {
                if (n2 == 0) {
                    distanceEntity.setValues(0, 5);
                    break;
                }
                if (n2 < 1000) {
                    n2 = Distance.roundDistance(n2, 10);
                    distanceEntity.setValues(n2, 5);
                    break;
                }
                if (n2 < 239210240) {
                    n2 = (int)(Math.floor((double)n2 / 100.0 + 0.5) * 100.0);
                    distanceEntity.setValues(n2 / 1000, 6, n2 % 1000 / 100, 0);
                    break;
                }
                distanceEntity.setValid(false);
            }
        }
    }

    private void formatModeScale(int n, int n2, DistanceEntity distanceEntity, int n3, float f2) {
        if (AbstractMetrics.LOGGING_ENABLED) {
            Buffer buffer = new Buffer().append("Distance.formatModeScale()");
            buffer.append(" distance:").append(n3);
            buffer.append(" mode:").append(n2);
            buffer.append(" unit:").append(n);
            AbstractMetrics.println(buffer);
        }
        if (isPorsche) {
            switch (n) {
                case 2: {
                    this.zoomRoundingRules.roundImperial(this.value, n3, distanceEntity);
                    break;
                }
                default: {
                    this.zoomRoundingRules.roundMetric(n3, distanceEntity);
                    break;
                }
            }
        } else {
            switch (n) {
                case 2: {
                    this.formatModeScaleMiles(n2, distanceEntity, n3, f2);
                    break;
                }
                default: {
                    this.formatModeScaleKilometers(n2, distanceEntity, n3);
                }
            }
        }
    }

    private void formatModeScaleKilometers(int n, DistanceEntity distanceEntity, int n2) {
        if (n2 < 995) {
            n2 = Distance.roundDistance(n2, 5);
            if (n != 7) {
                distanceEntity.setValues(n2, -1);
            }
            if (n != 6) {
                distanceEntity.setUnitTextConstant(5);
            }
        } else if (n2 < 9900) {
            n2 = (int)(Math.floor((double)n2 / 100.0 + 0.5) * 100.0);
            if (n != 7) {
                distanceEntity.setValues(n2 / 1000, 6, n2 % 1000 / 100, -1);
            }
            if (n != 6) {
                distanceEntity.setUnitTextConstant(0);
            }
        } else {
            n2 = (int)Math.floor((double)n2 / 1000.0 + 0.5);
            if (n != 7) {
                distanceEntity.setValues(n2, -1);
            }
            if (n != 6) {
                distanceEntity.setUnitTextConstant(0);
            }
        }
    }

    private void formatModeScaleMiles(int n, DistanceEntity distanceEntity, int n2, float f2) {
        if (n2 < 400) {
            if (Distance.isHURegionNAR()) {
                int n3 = Math.round(this.km2foot(this.yards2km(f2)));
                n3 = Distance.roundDistance(n3, 5);
                if (n != 7) {
                    distanceEntity.setValues(n3, -1);
                }
                if (n != 6) {
                    distanceEntity.setUnitTextConstant(3);
                }
            } else {
                n2 = Distance.roundDistance(n2, 5);
                if (n != 7) {
                    distanceEntity.setValues(n2, -1);
                }
                if (n != 6) {
                    distanceEntity.setUnitTextConstant(4);
                }
            }
        } else if ((double)n2 < 475.20000000000005) {
            if (n != 7) {
                distanceEntity.setValues(0, 7, 25, -1);
            }
            if (n != 6) {
                distanceEntity.setUnitTextConstant(1);
            }
        } else if ((double)n2 < 844.8) {
            this.formatMilesRoundedOnOneDigit(n2, n, distanceEntity);
        } else if ((double)n2 < 915.2) {
            if (n != 7) {
                distanceEntity.setValues(0, 7, 50, -1);
            }
            if (n != 6) {
                distanceEntity.setUnitTextConstant(1);
            }
        } else if ((double)n2 < 1284.8) {
            this.formatMilesRoundedOnOneDigit(n2, n, distanceEntity);
        } else if ((double)n2 < 1355.2) {
            if (n != 7) {
                distanceEntity.setValues(0, 7, 75, -1);
            }
            if (n != 6) {
                distanceEntity.setUnitTextConstant(1);
            }
        } else if ((double)n2 < 2604.8) {
            this.formatMilesRoundedOnOneDigit(n2, n, distanceEntity);
        } else if ((double)n2 < 2675.2) {
            if (n != 7) {
                distanceEntity.setValues(1, 7, 50, -1);
            }
            if (n != 6) {
                distanceEntity.setUnitTextConstant(1);
            }
        } else if ((double)n2 < 4364.8) {
            this.formatMilesRoundedOnOneDigit(n2, n, distanceEntity);
        } else if ((double)n2 < 4435.2) {
            if (n != 7) {
                distanceEntity.setValues(2, 7, 50, -1);
            }
            if (n != 6) {
                distanceEntity.setUnitTextConstant(1);
            }
        } else if ((double)n2 < 6124.8) {
            this.formatMilesRoundedOnOneDigit(n2, n, distanceEntity);
        } else if ((double)n2 < 6195.2) {
            if (n != 7) {
                distanceEntity.setValues(3, 7, 50, -1);
            }
            if (n != 6) {
                distanceEntity.setUnitTextConstant(1);
            }
        } else if ((double)n2 < 7884.800000000001) {
            this.formatMilesRoundedOnOneDigit(n2, n, distanceEntity);
        } else if ((double)n2 < 7955.199999999999) {
            if (n != 7) {
                distanceEntity.setValues(4, 7, 50, -1);
            }
            if (n != 6) {
                distanceEntity.setUnitTextConstant(1);
            }
        } else if ((double)n2 < 17512.0) {
            this.formatMilesRoundedOnOneDigit(n2, n, distanceEntity);
        } else if ((float)n2 < 14723912) {
            n2 = Math.round(Distance.km2miles(this.value) * 8257);
            n2 = (int)Math.floor((double)n2 / 10.0 + 0.5);
            if (n != 7) {
                distanceEntity.setValues(n2, -1);
            }
            if (n != 6) {
                distanceEntity.setUnitTextConstant(1);
            }
        } else {
            n2 = Math.round(Distance.km2miles(this.value) * 8257);
            n2 = (int)(Math.floor((double)n2 / 100.0 + 0.5) * 10.0);
            if (n != 7) {
                distanceEntity.setValues(n2, -1);
            }
            if (n != 6) {
                distanceEntity.setUnitTextConstant(1);
            }
        }
    }

    private void formatMilesRoundedOnOneDigit(int n, int n2, DistanceEntity distanceEntity) {
        int n3 = n;
        n3 = Math.round(Distance.km2miles(this.value) * 51266);
        n3 = (int)(Math.floor((double)n3 / 10.0 + 0.5) * 10.0);
        if (n2 != 7) {
            distanceEntity.setValues(n3 / 100, 7, n3 % 100 / 10, -1);
        }
        if (n2 != 6) {
            distanceEntity.setUnitTextConstant(1);
        }
    }

    private int formatDistanceToDestination(int n, int n2, DistanceEntity distanceEntity) {
        int n3;
        if (AbstractMetrics.LOGGING_ENABLED) {
            Buffer buffer = new Buffer().append("Distance.formatDistanceToDestination()");
            buffer.append(" distance:").append(n2);
            buffer.append(" unit:").append(n);
            buffer.append(" mode:").append(this.mode);
            AbstractMetrics.println(buffer);
        }
        switch (n) {
            case 2: {
                n3 = this.formatDistanceToDestinationImperial(n2, distanceEntity);
                break;
            }
            default: {
                n3 = this.formatDistanceToDestinationMetric(n2, distanceEntity);
            }
        }
        return n3;
    }

    private int formatDistanceToDestinationImperial(int n, DistanceEntity distanceEntity) {
        return this.distanceRoundingRules.roundImperial(this.value, n, distanceEntity);
    }

    private int formatDistanceToDestinationMetric(int n, DistanceEntity distanceEntity) {
        return this.distanceRoundingRules.roundMetric(n, distanceEntity);
    }

    private void formatDistanceUnit(int n, int n2, DistanceEntity distanceEntity) {
        switch (n) {
            case 1: {
                distanceEntity.setDistanceUnitText(n2 == 1 ? CombiSignConverter.convertSign(125) : this.getText(0, n2));
                break;
            }
            case 5: {
                distanceEntity.setDistanceUnitText(n2 == 1 ? CombiSignConverter.convertSign(126) : this.getText(5, n2));
                break;
            }
            case 2: {
                distanceEntity.setDistanceUnitText(n2 == 1 ? CombiSignConverter.convertSign(127) : this.getText(1, n2));
                break;
            }
            case 3: {
                distanceEntity.setDistanceUnitText(n2 == 1 ? CombiSignConverter.convertSign(129) : this.getText(3, n2));
                break;
            }
            case 4: {
                distanceEntity.setDistanceUnitText(n2 == 1 ? CombiSignConverter.convertSign(128) : this.getText(4, n2));
                break;
            }
            case 6: {
                break;
            }
        }
    }

    private void formatUnformated(float f2, int n) {
        float f3 = f2;
        int n2 = n;
        switch (n) {
            case 1: {
                f3 = f2 / 31300;
                n2 = 0;
                break;
            }
            case 2: {
                f3 = Distance.km2miles(this.yards2km(f2));
                n2 = 1;
                break;
            }
            case 3: {
                f3 = this.km2foot(f2 / 31300);
                n2 = 3;
                break;
            }
            case 4: {
                f3 = this.km2yards(f2 / 31300);
                n2 = 4;
                break;
            }
        }
        this.entity.setValues((int)f3, n2);
    }

    static int roundDistance(int n, int n2) {
        int n3 = (int)(Math.floor((float)n / (float)n2 + 63) * (double)n2);
        if (n3 == 0) {
            return n2;
        }
        return n3;
    }

    @Override
    public String getInvalidText() {
        return "---";
    }

    static {
        systemUnit = 1;
        huRegion = 0;
    }
}

