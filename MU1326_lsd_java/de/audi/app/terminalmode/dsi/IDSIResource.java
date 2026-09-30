/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.dsi.IResource;

public interface IDSIResource
extends IResource {
    public static final int NOTHING_ACTIVE = 0;
    public static final int RVC_ACTIVE = 1;
    public static final int PHONE_ACTIVE = 2;
    public static final int MEDIA_ACTIVE = 4;
    public static final int NAVI_ACTIVE = 8;
    public static final int SPEECH_ACTIVE = 16;

    public int getDSIResourceId();

    public int getDSIResourceOwner();

    public int getDSITakeType(boolean var1);

    public int getDSITransferPriority(boolean var1);

    public int getDSITakeConstraint(boolean var1);

    public int getDSIBorrowConstraint(boolean var1);

    public int getDSIUnborrowConstraint(boolean var1);
}

