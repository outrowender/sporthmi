/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.onlinefunctions.bap;

import de.audi.app.onlinefunctions.bap.TrafficLightInfo$Builder;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.generated.onlinefunctions.serializer.TrafficLightOnline_Info_Status$TrafficLightWarnings;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public final class TrafficLightInfo {
    private static final byte MAX_SIDESTREETS;
    private final int trafficLight;
    private final int mainDirection;
    private final int[] sideStreetDirections;
    private final int level;
    private final int layout;

    public static TrafficLightInfo$Builder builder() {
        return new TrafficLightInfo$Builder();
    }

    private TrafficLightInfo(int n, int n2, int[] nArray, int n3, int n4) {
        this.trafficLight = n;
        this.mainDirection = n2;
        this.sideStreetDirections = nArray;
        this.level = n3;
        this.layout = n4;
    }

    public int getTrafficLight() {
        return this.trafficLight;
    }

    public int getMainDirection() {
        return this.mainDirection;
    }

    public void setSideStreetsDirections(BAPString bAPString) {
        bAPString.setRawContent();
        try {
            bAPString.setContent(this.convertedSideStreetDirections());
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
    }

    private String convertedSideStreetDirections() {
        String string;
        if (this.sideStreetDirections == null || this.sideStreetDirections.length == 0) {
            string = "";
        } else {
            int n = Math.min(this.sideStreetDirections.length, 3);
            byte[] byArray = new byte[n];
            for (int i2 = 0; i2 < n; ++i2) {
                byArray[i2] = (byte)this.sideStreetDirections[i2];
            }
            string = new String(byArray, "ISO8859_1");
        }
        return string;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean isTrafficLightWarningsValid() {
        return this.level >= 0 && this.level <= 2;
    }

    public void setTrafficLightWarnings(TrafficLightOnline_Info_Status$TrafficLightWarnings trafficLightOnline_Info_Status$TrafficLightWarnings) {
        trafficLightOnline_Info_Status$TrafficLightWarnings.displayRedLightWarning1 = this.level == 1;
        trafficLightOnline_Info_Status$TrafficLightWarnings.displayRedLightWarning2 = this.level == 2;
    }

    public int getLayout() {
        return this.layout;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.layout;
        n = 31 * n + this.level;
        n = 31 * n + this.mainDirection;
        n = 31 * n + TrafficLightInfo.hashCode(this.sideStreetDirections);
        n = 31 * n + this.trafficLight;
        return n;
    }

    private static int hashCode(int[] nArray) {
        int n = 31;
        if (nArray == null) {
            return 0;
        }
        int n2 = 1;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            n2 = n * n2 + nArray[i2];
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        TrafficLightInfo trafficLightInfo = (TrafficLightInfo)object;
        if (this.layout != trafficLightInfo.layout) {
            return false;
        }
        if (this.level != trafficLightInfo.level) {
            return false;
        }
        if (this.mainDirection != trafficLightInfo.mainDirection) {
            return false;
        }
        if (!Arrays.equals(this.sideStreetDirections, trafficLightInfo.sideStreetDirections)) {
            return false;
        }
        return this.trafficLight == trafficLightInfo.trafficLight;
    }

    public String toString() {
        return new StringBuffer().append("TrafficLightInfo [trafficLight=").append(this.trafficLight).append(", mainDirection=").append(this.mainDirection).append(", sideStreetDirections=").append(this.sideStreetDirections != null ? TrafficLightInfo.arrayToString(this.sideStreetDirections, this.sideStreetDirections.length) : null).append(", level=").append(this.level).append(", layout=").append(this.layout).append("]").toString();
    }

    private static String arrayToString(Object object, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        for (int i2 = 0; i2 < n; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            if (!(object instanceof int[])) continue;
            stringBuffer.append(((int[])object)[i2]);
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }
}

