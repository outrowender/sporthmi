/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.diag;

public interface IDiagnosisApp {
    public static final int FALSE = 0;
    public static final int TRUE = 1;
    public static final int DIAG_ACTION_SWITCH_SOURCE = 5;
    public static final int DIAG_ACTION_RESET_DVD_PM_PASSWORD = 9;
    public static final int DIAG_ACTION_RESET_DVD_PM_LEVEL = 10;
    public static final int TUNER_APP = 0;
    public static final int MEDIA_APP = 1;

    public void performAction(int var1, Object var2);

    public void startDiagSession();

    public void stopDiagSession();

    public void switch2OriginSource(int var1, int var2);

    public void updateDiagnosticValueChanged(int var1, long var2);
}

