/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.emergency;

public interface IEmergencyTextFactory {
    public static final int DEFAULT_EMERGENCY_NUMBER_ID = 0;
    public static final int KOREA_NATIONAL_SECURITY_INSTITUTION = 1;
    public static final int KOREA_POLICE = 2;
    public static final int KOREA_SUSPECTED_ESPIONAGE = 3;
    public static final int KOREA_REPORT_SCHOOL_VIOLENCE = 4;
    public static final int KOREA_CYBER_TERRORISM = 5;
    public static final int KOREA_FIRE_DEPARTMENT = 6;
    public static final int KOREA_COAST_GUARD = 7;
    public static final int KOREA_REPORT_CONTRABAND = 8;
    public static final int KOREA_NARCOTICS_REPORT = 9;

    public String getText(int var1);

    public String[] getEmergencyNumbers();

    public int[] getEmergencyNumbersIDs();
}

