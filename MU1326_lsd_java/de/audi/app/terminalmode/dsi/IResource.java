/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.util.Enum;

public interface IResource {
    public static final int RESOURCE_UNKNOWN = 0;
    public static final int RESOURCE_SCREEN = 1;
    public static final int RESOURCE_MAIN_AUDIO = 2;
    public static final int RESOURCE_AUDIO_MEDIA = 3;
    public static final int RESOURCE_AUDIO_PHONE = 4;
    public static final int RESOURCE_AUDIO_SPEECH = 5;
    public static final int RESOURCE_AUDIO_GUIDANCE = 6;
    public static final int RESOURCE_AUDIO_RINGTONE = 7;
    public static final int RESOURCE_NOTIFICATION = 8;
    public static final int RESOURCE_OWNER_UNKNOWN = 0;
    public static final int RESOURCE_OWNER_MAINUNIT = 1;
    public static final int RESOURCE_OWNER_DEVICE = 2;

    public int getResourceId();

    public int getOwner();

    public OwnershipType getOwnershipType();

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class OwnershipType
    extends Enum<OwnershipType> {
        public static final OwnershipType UNSPECIFIED = new OwnershipType("UNSPECIFIED");
        public static final OwnershipType BORROW = new OwnershipType("BORROW");
        public static final OwnershipType TAKE = new OwnershipType("TAKE");

        protected OwnershipType(String string) {
            super(string);
        }
    }
}

