/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.emergency;

public interface IEmergencyTextFactory {
    public static final int DEFAULT_EMERGENCY_NUMBER_ID;
    public static final int KOREA_NATIONAL_SECURITY_INSTITUTION;
    public static final int KOREA_POLICE;
    public static final int KOREA_SUSPECTED_ESPIONAGE;
    public static final int KOREA_REPORT_SCHOOL_VIOLENCE;
    public static final int KOREA_CYBER_TERRORISM;
    public static final int KOREA_FIRE_DEPARTMENT;
    public static final int KOREA_COAST_GUARD;
    public static final int KOREA_REPORT_CONTRABAND;
    public static final int KOREA_NARCOTICS_REPORT;

    default public String getText(int n) {
    }

    default public String[] getEmergencyNumbers() {
    }

    default public int[] getEmergencyNumbersIDs() {
    }
}

