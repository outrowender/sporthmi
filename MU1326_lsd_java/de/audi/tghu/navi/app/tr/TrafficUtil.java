/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.tr;

import de.audi.tghu.navi.app.NavigationEnv;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;

public class TrafficUtil {
    public static final int NO_SIGN = -1;
    public static final int TYPE_TRAFFIC_SIGN = 0;
    public static final int TYPE_ADDITIONAL_SIGN = 1;
    public static final int TYPE_WARNING_SIGN = 2;

    public static boolean isTrafficRegulationInfoEnabled(NavigationEnv navigationEnv) {
        return navigationEnv.getChoiceModel(400801).getValue() == 1;
    }

    public static int retrieveCurrentSignID(TrafficSignInformation trafficSignInformation) {
        if (trafficSignInformation == null) {
            return -1;
        }
        int n = trafficSignInformation.getHighestPrioritySign();
        int n2 = TrafficUtil.getSignID(trafficSignInformation, n, 0);
        if (n2 != 0) {
            return n2;
        }
        int n3 = trafficSignInformation.getSecondHighestPrioritySign();
        n2 = TrafficUtil.getSignID(trafficSignInformation, n3, 0);
        if (n2 != 0) {
            return n2;
        }
        int n4 = TrafficUtil.getThirdPrioritySign(n, n3, trafficSignInformation);
        n2 = TrafficUtil.getSignID(trafficSignInformation, n4, 0);
        return n2;
    }

    public static int getSignID(TrafficSignInformation trafficSignInformation, int n, int n2) {
        int n3;
        if (trafficSignInformation == null) {
            n3 = 0;
        } else {
            switch (n) {
                case 0: {
                    n3 = 0;
                    break;
                }
                case 1: {
                    if (n2 == 1) {
                        n3 = trafficSignInformation.getAdditionalSignOne();
                        break;
                    }
                    if (n2 == 2) {
                        n3 = trafficSignInformation.getWarningSignOne();
                        break;
                    }
                    n3 = trafficSignInformation.getTrafficSignOne();
                    break;
                }
                case 2: {
                    if (n2 == 1) {
                        n3 = trafficSignInformation.getAdditionalSignTwo();
                        break;
                    }
                    if (n2 == 2) {
                        n3 = trafficSignInformation.getWarningSignTwo();
                        break;
                    }
                    n3 = trafficSignInformation.getTrafficSignTwo();
                    break;
                }
                case 3: {
                    if (n2 == 1) {
                        n3 = trafficSignInformation.getAdditionalSignThree();
                        break;
                    }
                    if (n2 == 2) {
                        n3 = trafficSignInformation.getWarningSignThree();
                        break;
                    }
                    n3 = trafficSignInformation.getTrafficSignThree();
                    break;
                }
                default: {
                    n3 = 0;
                }
            }
        }
        return n3;
    }

    public static int getThirdPrioritySign(int n, int n2, TrafficSignInformation trafficSignInformation) {
        int n3 = n == 1 || n2 == 1 ? (n == 2 || n2 == 2 ? 3 : 2) : 1;
        return n3;
    }

    public static int extractSpeedLimitFromSignID(int n) {
        switch (n) {
            case 2: {
                return 5;
            }
            case 3: {
                return 10;
            }
            case 4: {
                return 15;
            }
            case 5: {
                return 20;
            }
            case 6: {
                return 25;
            }
            case 7: {
                return 30;
            }
            case 8: {
                return 35;
            }
            case 9: {
                return 40;
            }
            case 10: {
                return 45;
            }
            case 11: {
                return 50;
            }
            case 12: {
                return 55;
            }
            case 13: {
                return 60;
            }
            case 14: {
                return 65;
            }
            case 15: {
                return 70;
            }
            case 16: {
                return 75;
            }
            case 17: {
                return 80;
            }
            case 18: {
                return 85;
            }
            case 19: {
                return 90;
            }
            case 20: {
                return 95;
            }
            case 21: {
                return 100;
            }
            case 22: {
                return 110;
            }
            case 23: {
                return 120;
            }
            case 24: {
                return 130;
            }
            case 25: {
                return 140;
            }
            case 26: {
                return 150;
            }
            case 27: {
                return 160;
            }
            case 28: {
                return 200;
            }
            case 122: {
                return 250;
            }
            case 30: {
                return 5;
            }
            case 31: {
                return 10;
            }
            case 32: {
                return 15;
            }
            case 33: {
                return 20;
            }
            case 34: {
                return 25;
            }
            case 35: {
                return 30;
            }
            case 36: {
                return 35;
            }
            case 37: {
                return 40;
            }
            case 38: {
                return 45;
            }
            case 39: {
                return 50;
            }
            case 40: {
                return 55;
            }
            case 41: {
                return 60;
            }
            case 42: {
                return 65;
            }
            case 43: {
                return 70;
            }
            case 44: {
                return 75;
            }
            case 45: {
                return 80;
            }
            case 46: {
                return 85;
            }
            case 47: {
                return 90;
            }
            case 48: {
                return 95;
            }
            case 49: {
                return 100;
            }
            case 50: {
                return 110;
            }
            case 51: {
                return 120;
            }
            case 52: {
                return 130;
            }
            case 53: {
                return 140;
            }
            case 54: {
                return 150;
            }
            case 55: {
                return 160;
            }
            case 125: {
                return 200;
            }
            case 126: {
                return 250;
            }
            case 61: {
                return 5;
            }
            case 62: {
                return 10;
            }
            case 63: {
                return 15;
            }
            case 64: {
                return 20;
            }
            case 65: {
                return 25;
            }
            case 66: {
                return 30;
            }
            case 67: {
                return 35;
            }
            case 68: {
                return 40;
            }
            case 69: {
                return 45;
            }
            case 70: {
                return 50;
            }
            case 71: {
                return 55;
            }
            case 72: {
                return 60;
            }
            case 73: {
                return 65;
            }
            case 74: {
                return 70;
            }
            case 75: {
                return 75;
            }
            case 76: {
                return 80;
            }
            case 77: {
                return 85;
            }
            case 78: {
                return 90;
            }
            case 79: {
                return 95;
            }
            case 80: {
                return 100;
            }
            case 81: {
                return 110;
            }
            case 82: {
                return 120;
            }
            case 83: {
                return 130;
            }
            case 84: {
                return 140;
            }
            case 85: {
                return 150;
            }
            case 86: {
                return 160;
            }
            case 87: {
                return 200;
            }
            case 121: {
                return 250;
            }
            case 89: {
                return 5;
            }
            case 90: {
                return 10;
            }
            case 91: {
                return 15;
            }
            case 92: {
                return 20;
            }
            case 93: {
                return 25;
            }
            case 94: {
                return 30;
            }
            case 95: {
                return 35;
            }
            case 96: {
                return 40;
            }
            case 97: {
                return 45;
            }
            case 98: {
                return 50;
            }
            case 99: {
                return 55;
            }
            case 100: {
                return 60;
            }
            case 101: {
                return 65;
            }
            case 102: {
                return 70;
            }
            case 103: {
                return 75;
            }
            case 104: {
                return 80;
            }
            case 105: {
                return 85;
            }
            case 106: {
                return 90;
            }
            case 107: {
                return 95;
            }
            case 108: {
                return 100;
            }
            case 109: {
                return 110;
            }
            case 110: {
                return 120;
            }
            case 111: {
                return 130;
            }
            case 112: {
                return 140;
            }
            case 113: {
                return 150;
            }
            case 114: {
                return 160;
            }
            case 123: {
                return 200;
            }
            case 124: {
                return 250;
            }
        }
        return 0;
    }

    public static int extractSpeedLimitUnitFromSign(TrafficSignInformation trafficSignInformation) {
        if (trafficSignInformation == null) {
            return 0;
        }
        return trafficSignInformation.getHighestPrioritySpeedLimit().getSpeedUnit();
    }
}

