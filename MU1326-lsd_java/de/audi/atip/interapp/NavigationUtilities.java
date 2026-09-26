/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public final class NavigationUtilities {
    private static DecimalFormat degreeStringFormat;

    private NavigationUtilities() {
    }

    public static double wgs84ToDegree(int n) {
        int n2 = n;
        int n3 = n2 / 0x600BB600;
        int n4 = (n2 %= 0x600BB600) / -1190657280;
        double d2 = (double)(n2 %= -1190657280) / 3314.0;
        double d3 = (double)n3 + ((double)n4 + d2 / 60.0) / 60.0;
        return d3;
    }

    public static int degreeToWgs84(double d2) {
        int n = d2 > 0.0 ? 1 : -1;
        d2 = Math.abs(d2);
        int n2 = (int)d2;
        d2 = (d2 - (double)n2) * 60.0;
        int n3 = (int)d2;
        double d3 = d2 = (d2 - (double)n3) * 60.0;
        int n4 = n2 * 0x600BB600 + n3 * -1190657280 + (int)(d3 * 3314.0);
        return n4 * n;
    }

    public static String formatDegree(double d2) {
        return degreeStringFormat.format(d2 % 360.0);
    }

    public static void main(String[] stringArray) {
        System.out.println(NavigationUtilities.formatDegree(NavigationUtilities.wgs84ToDegree(-925587455)));
        System.out.println(NavigationUtilities.formatDegree(NavigationUtilities.wgs84ToDegree(1325055522)));
    }

    static {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        degreeStringFormat = new DecimalFormat("0.000", decimalFormatSymbols);
    }
}

