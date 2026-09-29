/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi.evo;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.IMetricsTextConstants;
import de.audi.atip.metrics.IMetricsTextHandler;

public class MetricsTextHandler
implements IMetricsTextHandler,
IMetricsTextConstants {
    private HMIService hmiService;
    private LogChannel logMetrics;

    public MetricsTextHandler(IFrameworkAccess iFrameworkAccess, HMIService hMIService) {
        this.hmiService = hMIService;
        this.logMetrics = iFrameworkAccess.getLogChannel("Fw.Metrics");
    }

    @Override
    public String getText(int n) {
        int n2;
        boolean bl = false;
        switch (n) {
            case 0: {
                n2 = 1039;
                bl = true;
                break;
            }
            case 1: {
                n2 = 1040;
                bl = true;
                break;
            }
            case 2: {
                n2 = 1043;
                bl = true;
                break;
            }
            case 3: {
                n2 = 1044;
                bl = true;
                break;
            }
            case 4: {
                n2 = 1045;
                bl = true;
                break;
            }
            case 5: {
                n2 = 1046;
                bl = true;
                break;
            }
            case 6: {
                n2 = 1041;
                break;
            }
            case 7: {
                n2 = 1042;
                break;
            }
            case 8: {
                n2 = 1047;
                bl = true;
                break;
            }
            case 9: {
                n2 = 1048;
                bl = true;
                break;
            }
            case 10: {
                n2 = 1049;
                bl = true;
                break;
            }
            case 11: {
                n2 = 1041;
                break;
            }
            case 12: {
                n2 = 3473;
                break;
            }
            case 59: {
                n2 = 1041;
                break;
            }
            case 64: {
                n2 = 3473;
                break;
            }
            case 65: {
                n2 = 1041;
                break;
            }
            case 66: {
                n2 = 1041;
                break;
            }
            case 67: {
                n2 = 3473;
                break;
            }
            case 60: {
                n2 = 1499;
                break;
            }
            case 61: {
                n2 = 1500;
                break;
            }
            case 62: {
                n2 = 1501;
                break;
            }
            case 63: {
                n2 = 1502;
                break;
            }
            case 82: {
                n2 = 2867;
                break;
            }
            case 83: {
                n2 = 2869;
                break;
            }
            case 84: {
                n2 = 3473;
                break;
            }
            case 85: {
                n2 = 3473;
                break;
            }
            case 14: {
                n2 = 1052;
                bl = true;
                break;
            }
            case 15: {
                n2 = 1053;
                bl = true;
                break;
            }
            case 16: {
                n2 = 1054;
                break;
            }
            case 17: {
                n2 = 1054;
                break;
            }
            case 18: {
                n2 = 1057;
                bl = true;
                break;
            }
            case 19: {
                n2 = 1058;
                bl = true;
                break;
            }
            case 20: {
                n2 = 1054;
                break;
            }
            case 21: {
                n2 = 1054;
                break;
            }
            case 23: {
                n2 = 1061;
                break;
            }
            case 24: {
                n2 = 4072;
                break;
            }
            case 26: {
                n2 = 1062;
                bl = true;
                break;
            }
            case 27: {
                n2 = 1063;
                bl = true;
                break;
            }
            case 28: {
                n2 = 1064;
                bl = true;
                break;
            }
            case 29: {
                n2 = 3473;
                break;
            }
            case 30: {
                n2 = 1041;
                break;
            }
            case 31: {
                n2 = 1065;
                bl = true;
                break;
            }
            case 32: {
                n2 = 1066;
                bl = true;
                break;
            }
            case 33: {
                n2 = 1067;
                bl = true;
                break;
            }
            case 34: {
                n2 = 1068;
                bl = true;
                break;
            }
            case 35: {
                n2 = 1069;
                bl = true;
                break;
            }
            case 36: {
                n2 = 1041;
                break;
            }
            case 37: {
                n2 = 1070;
                bl = true;
                break;
            }
            case 38: {
                n2 = 1048;
                bl = true;
                break;
            }
            case 39: {
                n2 = 3473;
                break;
            }
            case 40: {
                n2 = 1041;
                break;
            }
            case 42: {
                n2 = 1072;
                break;
            }
            case 43: {
                n2 = 3473;
                break;
            }
            case 44: {
                n2 = 1073;
                break;
            }
            case 45: {
                n2 = 1074;
                break;
            }
            case 46: {
                n2 = 1077;
                break;
            }
            case 47: {
                n2 = 1075;
                break;
            }
            case 48: {
                n2 = 1078;
                break;
            }
            case 49: {
                n2 = 1076;
                break;
            }
            case 50: {
                n2 = 1041;
                break;
            }
            case 51: {
                n2 = 1041;
                break;
            }
            case 52: {
                n2 = 1079;
                bl = true;
                break;
            }
            case 53: {
                n2 = 1080;
                bl = true;
                break;
            }
            case 54: {
                n2 = 1081;
                bl = true;
                break;
            }
            case 55: {
                n2 = 1082;
                bl = true;
                break;
            }
            case 56: {
                n2 = 1083;
                bl = true;
                break;
            }
            case 58: {
                n2 = 1084;
                break;
            }
            case 69: {
                n2 = 2071;
                break;
            }
            case 68: {
                n2 = 3473;
                break;
            }
            case 70: {
                n2 = 2130;
                break;
            }
            case 71: {
                n2 = 2131;
                break;
            }
            case 72: {
                n2 = 2132;
                break;
            }
            case 73: {
                n2 = 2133;
                break;
            }
            case 74: {
                n2 = 2134;
                break;
            }
            case 75: {
                n2 = 2135;
                break;
            }
            case 76: {
                n2 = 2136;
                break;
            }
            case 77: {
                n2 = 2137;
                break;
            }
            case 78: {
                n2 = 2138;
                break;
            }
            case 79: {
                n2 = 2139;
                break;
            }
            case 80: {
                n2 = 2140;
                break;
            }
            case 81: {
                n2 = 2265;
                break;
            }
            case 88: {
                n2 = 3239;
                break;
            }
            case 87: {
                n2 = 3238;
                break;
            }
            case 90: {
                n2 = 3248;
                break;
            }
            case 89: {
                n2 = 3248;
                break;
            }
            case 91: {
                n2 = 3472;
                break;
            }
            case 92: {
                n2 = 3471;
                break;
            }
            case 93: {
                n2 = 3473;
                break;
            }
            case 96: {
                n2 = 4065;
                bl = true;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        if (n2 == -1) {
            this.logMetrics.log(1078071040, "MetricsTextHandler#getText no internationalized text for metrics constant: %1 available", (long)n);
            return null;
        }
        return new StringBuffer().append(bl ? " " : "").append(this.hmiService.getText(n2)).toString();
    }
}

