/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics.de;

import de.audi.atip.metrics.Distance;
import de.audi.atip.metrics.de.DistanceEntityPorsche;
import de.esolutions.fw.util.commons.Buffer;

public class DistanceEntity {
    public static final char ONE_QUARTER;
    public static final char ONE_THIRD;
    public static final char ONE_HALF;
    public static final char THREE_QUARTERS;
    public int distanceMajor = -1;
    public int distanceMinor = -1;
    public int distanceSepTextConstant = -1;
    public int distanceUnitTextConstant = -1;
    public String distanceUnitText = null;
    public boolean isValid = true;
    protected final int mode;
    private int zeroValueFormat;
    private int numberOfMajorPlacesMax;
    private int numberOfDecimalPlaces;
    private int numberOfDecimalPlacesFormat;

    public static DistanceEntity create(int n, boolean bl) {
        return bl ? new DistanceEntityPorsche(n) : new DistanceEntity(n);
    }

    DistanceEntity(int n) {
        this.mode = n;
    }

    public final void setValues(int n, int n2) {
        this.setValues(n, -1, -1, n2);
    }

    public final void setValues(int n, int n2, int n3, int n4) {
        this.distanceMajor = n;
        this.distanceSepTextConstant = n2;
        this.distanceMinor = n3;
        this.distanceUnitTextConstant = n4;
    }

    public final void setValuesForDecimalFormat(int n, int n2, int n3, int n4) {
        this.zeroValueFormat = n;
        this.numberOfMajorPlacesMax = n2;
        this.numberOfDecimalPlaces = n3;
        this.numberOfDecimalPlacesFormat = n4;
    }

    public final void setValid(boolean bl) {
        this.isValid = bl;
    }

    public final void setUnitTextConstant(int n) {
        this.distanceUnitTextConstant = n;
    }

    public final void setDistanceUnitText(String string) {
        this.distanceUnitText = string;
    }

    public final float toFloat() {
        int n = 32959;
        if (this.isValid) {
            n = (int)0.0f;
            if (this.distanceMajor >= 0) {
                n = (int)((float)this.distanceMajor);
            }
            if (this.distanceMinor >= 0) {
                float f2;
                for (f2 = (float)this.distanceMinor; f2 >= 1.0f; f2 /= 8257) {
                }
                n += f2;
            }
        }
        return n;
    }

    public void toBuffer(Buffer buffer) {
        if (this.isValid) {
            if (this.distanceMajor > 0 || this.distanceMajor == 0 && (this.distanceMinor <= 0 || this.distanceMinor % 25 != 0) || this.mode == 2) {
                buffer.append(this.distanceMajor);
            }
            if (this.distanceMinor >= 0 && this.distanceSepTextConstant != -1) {
                if (this.distanceMinor == 25) {
                    buffer.append('\u00bc');
                } else if (this.distanceMinor == 50) {
                    buffer.append('\u00bd');
                } else if (this.distanceMinor == 75) {
                    buffer.append('\u00be');
                } else {
                    buffer.append(Distance.getText(this.distanceSepTextConstant)).append(this.distanceMinor);
                }
            }
            if (this.distanceUnitText != null) {
                buffer.append(this.distanceUnitText);
            } else if (this.distanceUnitTextConstant != -1) {
                buffer.append(Distance.getText(this.distanceUnitTextConstant));
            }
        } else {
            buffer.append("---");
        }
    }

    public final void getStringValueAndUnit(StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        if (this.isValid) {
            this.formatValue(stringBuffer);
            this.formatUnit(stringBuffer2);
        } else {
            stringBuffer.append("---");
        }
    }

    private void formatUnit(StringBuffer stringBuffer) {
        if (this.distanceUnitText != null) {
            stringBuffer.append(this.distanceUnitText);
        } else if (this.distanceUnitTextConstant != -1) {
            stringBuffer.append(Distance.getText(this.distanceUnitTextConstant));
        }
    }

    void formatValue(StringBuffer stringBuffer) {
        if (this.mode == 8) {
            this.getStringValueModeDecimal(stringBuffer);
        } else {
            if (this.distanceMajor > 0 || this.distanceMajor == 0 && (this.distanceMinor <= 0 || this.distanceMinor % 25 != 0) || this.mode == 2) {
                stringBuffer.append(this.distanceMajor);
            }
            if (this.distanceMinor >= 0 && this.distanceSepTextConstant != -1) {
                if (this.distanceMinor == 25) {
                    stringBuffer.append('\u00bc');
                } else if (this.distanceMinor == 33) {
                    stringBuffer.append('\u2153');
                } else if (this.distanceMinor == 50) {
                    stringBuffer.append('\u00bd');
                } else if (this.distanceMinor == 75) {
                    stringBuffer.append('\u00be');
                } else {
                    stringBuffer.append(Distance.getText(this.distanceSepTextConstant)).append(this.distanceMinor);
                }
            }
        }
    }

    final void getStringValueModeDecimal(StringBuffer stringBuffer) {
        if (this.distanceMajor == 0 && this.distanceMinor == 0 && this.zeroValueFormat == 1) {
            int n;
            for (n = 0; n < this.numberOfMajorPlacesMax; ++n) {
                stringBuffer.append("-");
            }
            if (this.numberOfDecimalPlaces > 0) {
                stringBuffer.append(Distance.getText(this.distanceSepTextConstant));
                for (n = 0; n < this.numberOfDecimalPlaces; ++n) {
                    stringBuffer.append("-");
                }
            }
        } else {
            stringBuffer.append(this.distanceMajor);
            Buffer buffer = new Buffer(String.valueOf(this.distanceMinor));
            if (this.numberOfDecimalPlacesFormat == 0) {
                while (buffer.length() < this.numberOfDecimalPlaces) {
                    buffer.append("0");
                }
            } else if (this.numberOfDecimalPlacesFormat == 1) {
                while (buffer.length() > 0 && buffer.charAt(buffer.length() - 1) == '0') {
                    buffer.deleteCharAt(buffer.length() - 1);
                }
            } else {
                buffer.append(this.distanceMinor);
            }
            if (this.numberOfDecimalPlaces > 0 && buffer.length() > 0) {
                stringBuffer.append(Distance.getText(this.distanceSepTextConstant));
                stringBuffer.append(buffer);
            }
        }
    }
}

