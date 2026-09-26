/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.dsi.IResource;

public interface IDSIResource
extends IResource {
    public static final int NOTHING_ACTIVE;
    public static final int RVC_ACTIVE;
    public static final int PHONE_ACTIVE;
    public static final int MEDIA_ACTIVE;
    public static final int NAVI_ACTIVE;
    public static final int SPEECH_ACTIVE;

    default public int getDSIResourceId() {
    }

    default public int getDSIResourceOwner() {
    }

    default public int getDSITakeType(boolean bl) {
    }

    default public int getDSITransferPriority(boolean bl) {
    }

    default public int getDSITakeConstraint(boolean bl) {
    }

    default public int getDSIBorrowConstraint(boolean bl) {
    }

    default public int getDSIUnborrowConstraint(boolean bl) {
    }
}

