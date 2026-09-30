/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

public final class DestinationKind {
    public static final int UNKNOWN = 0;
    public static final int POI = 1;
    public static final int STOP_OVER = 2;
    public static final int FINAL_DESTINATION = 3;
    public static final int FINAL_DESTINATION_START_ROUTE_GUIDANCE_IMMEDIATELY = 4;

    private DestinationKind() {
        throw new AssertionError((Object)"DestinationKind is not intended to be instantiated.");
    }
}

