/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.config.carcoding;

import de.audi.atip.config.carcoding.BitHelper;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import de.esolutions.fw.util.commons.Buffer;

public final class CarFuncAdapImpl
implements CarFuncAdap {
    public static String[] carMenuTxt = new String[]{"ACC", "INT_LIGHT", "PARKING", "AWV", "LDW", "SWA", "EXT_LIGHT", "WINDOW", "AIRCONDITION", "AUXHEATER", "BC_CLUSTER", "RDK", "WIPER", "SIA", "SEAT", "CENTRAL_LOCKING", "COMPASS", "CHARISMA", "OILLEVEL", "VIN", "CLOCK", "AIRSUSPENSION", "HUD", "UNITMASTER", "HYBRID", "UGDO", "NIGHTVISION", "SIDEVIEW", "RGS", "MFL_JOKER", "TSD", "ATTENTION_IDENT", "APTIVE_KEY_CLAMP", "MIRROR", "DRV_SCHOOL", "MKE", "BCME", "BATTERY_STATE", "BRAKE", "START_STOP_REASONS", "ANGLE_OF_SLOPE", "BATTERY_MGMNT", "REAR_SEAT_ENTERTAINMENT", "SPECIAL_FUNCTIONS", "TRAILER_ASSIST", "TV_TUNER", "AUX_COOLING", "PEDESTRIAN_ASSIST", "SEAT_PNEUMATIC", "CURVE_ASSIST", "E_CALL", "ENI", "SPORT_HMI", "AD_BLUE", "THING_BLUE", "PEA"};
    private static byte[] carFunctionAdap;

    public CarFuncAdapImpl(byte[] byArray) {
        carFunctionAdap = byArray;
    }

    public byte getByteCoding(short s) {
        return carFunctionAdap[s];
    }

    public boolean isMenuDisplayActivated(short s) {
        return BitHelper.testBit(carFunctionAdap[s], 0);
    }

    public boolean isMenuDisClamp15OffActivated(short s) {
        return BitHelper.testBit(carFunctionAdap[s], 1);
    }

    public boolean isMenuDisOverThresholdHighActivated(short s) {
        return BitHelper.testBit(carFunctionAdap[s], 2);
    }

    public boolean isMenuDisStandstillActivated(short s) {
        return BitHelper.testBit(carFunctionAdap[s], 3);
    }

    public boolean isMenuDisAfterDisclaimerActivated(short s) {
        return BitHelper.testBit(carFunctionAdap[s], 4);
    }

    public String toString() {
        Buffer buffer = new Buffer(1024);
        String string = "                                                     ";
        String string2 = "            \t";
        if (carFunctionAdap != null) {
            String string3 = "[ 0x";
            buffer.append("\n\nCarFuncAdapData");
            for (int i2 = 0; i2 < carFunctionAdap.length; ++i2) {
                buffer.append(string3);
                buffer.append(Integer.toHexString(carFunctionAdap[i2]));
                string3 = ", 0x";
            }
            buffer.append(" ]\n");
        }
        for (int i3 = 0; i3 < 56; ++i3) {
            buffer.append(carMenuTxt[i3]).append(": \t");
            buffer.append(this.getByteCoding((short)i3)).append(string2);
            if (this.isMenuDisplayActivated((short)i3)) {
                if (!this.isMenuDisClamp15OffActivated((short)i3)) {
                    buffer.append("clamp15 On req.").append(string2);
                }
                if (!this.isMenuDisOverThresholdHighActivated((short)i3)) {
                    buffer.append("v < vThr req.").append(string2);
                }
                if (this.isMenuDisStandstillActivated((short)i3)) {
                    buffer.append("standstill req.").append(string2);
                }
            } else {
                buffer.append("not coded").append(string2);
            }
            buffer.append('\n');
        }
        return buffer.toString();
    }
}

