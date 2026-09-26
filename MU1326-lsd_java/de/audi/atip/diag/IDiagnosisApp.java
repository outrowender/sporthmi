/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.diag;

public interface IDiagnosisApp {
    public static final int FALSE;
    public static final int TRUE;
    public static final int DIAG_ACTION_SWITCH_SOURCE;
    public static final int DIAG_ACTION_RESET_DVD_PM_PASSWORD;
    public static final int DIAG_ACTION_RESET_DVD_PM_LEVEL;
    public static final int TUNER_APP;
    public static final int MEDIA_APP;

    default public void performAction(int n, Object object) {
    }

    default public void startDiagSession() {
    }

    default public void stopDiagSession() {
    }

    default public void switch2OriginSource(int n, int n2) {
    }

    default public void updateDiagnosticValueChanged(int n, long l) {
    }
}

