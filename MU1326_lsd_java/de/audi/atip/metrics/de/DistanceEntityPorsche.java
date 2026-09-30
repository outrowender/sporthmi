/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics.de;

import de.audi.atip.metrics.Distance;
import de.audi.atip.metrics.de.DistanceEntity;

public class DistanceEntityPorsche
extends DistanceEntity {
    DistanceEntityPorsche(int n) {
        super(n);
    }

    void formatValue(StringBuffer stringBuffer) {
        if (this.mode == 8) {
            this.getStringValueModeDecimal(stringBuffer);
            return;
        }
        if (this.distanceMajor > 0 || this.distanceMajor == 0 && (this.distanceMinor <= 0 || this.distanceMinor % 25 != 0 && this.distanceMinor % 33 != 0) || this.mode == 2) {
            stringBuffer.append(this.distanceMajor);
        }
        if ((this.distanceMinor >= 0 || this.mode == 5 || this.mode == 1) && this.distanceSepTextConstant != -1) {
            switch (this.distanceMinor) {
                case 25: {
                    if (this.distanceMajor == 0) {
                        stringBuffer.append('\u00bc');
                        break;
                    }
                    stringBuffer.append(Distance.getText(this.distanceSepTextConstant)).append("25");
                    break;
                }
                case 33: {
                    if (this.distanceMajor == 0) {
                        stringBuffer.append('\u2153');
                        break;
                    }
                    stringBuffer.append(Distance.getText(this.distanceSepTextConstant)).append("33");
                    break;
                }
                case 50: {
                    if (this.distanceMajor == 0) {
                        stringBuffer.append('\u00bd');
                        break;
                    }
                    stringBuffer.append(Distance.getText(this.distanceSepTextConstant)).append('5');
                    break;
                }
                case 75: {
                    if (this.distanceMajor == 0) {
                        stringBuffer.append('\u00be');
                        break;
                    }
                    stringBuffer.append(Distance.getText(this.distanceSepTextConstant)).append("75");
                    break;
                }
                default: {
                    stringBuffer.append(Distance.getText(this.distanceSepTextConstant)).append(this.distanceMinor);
                }
            }
        }
    }
}

