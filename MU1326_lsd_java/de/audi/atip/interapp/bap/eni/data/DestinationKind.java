/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

public final class DestinationKind {
    public static final int UNKNOWN;
    public static final int POI;
    public static final int STOP_OVER;
    public static final int FINAL_DESTINATION;
    public static final int FINAL_DESTINATION_START_ROUTE_GUIDANCE_IMMEDIATELY;

    private DestinationKind() {
        throw new AssertionError((Object)"DestinationKind is not intended to be instantiated.");
    }
}

