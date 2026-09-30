/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.slidinglist.poi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.slidinglist.poi.DistanceDifferentiationRow;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.PosPosition;

public class DistanceUtil {
    public static void updateRRDfor(LogChannel logChannel, DistanceDifferentiationRow distanceDifferentiationRow, int n, IVehicle iVehicle) {
        if (distanceDifferentiationRow != null) {
            if (n >= 0) {
                distanceDifferentiationRow.setRRDDistance(n);
            } else {
                logChannel.log(10000000, "DistanceUtil#updateRRDfor() - invalid rrd. Air distance calculation started. ");
                PosPosition posPosition = iVehicle.getPosition();
                int n2 = distanceDifferentiationRow.getLongitude();
                int n3 = distanceDifferentiationRow.getLatitude();
                int n4 = Util.computeAirDistance(posPosition.longitude, posPosition.latitude, n2, n3);
                distanceDifferentiationRow.setAirDistance(n4);
            }
        } else {
            logChannel.log(100000, "DistanceUtil#updateRRDfor() - row is null! ");
        }
    }
}

