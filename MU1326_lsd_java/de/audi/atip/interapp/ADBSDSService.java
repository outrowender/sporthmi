/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.ADBSDSAddressDetails;
import de.audi.atip.interapp.AbstractSDSApplicationService;

public interface ADBSDSService
extends AbstractSDSApplicationService {
    public static final int ADB_RESULT_OK = 0;
    public static final int ADB_RESULT_ERROR = 1;

    public int getAdbProfileID();

    public void fillAdbPickList(long[] var1, String[] var2, int[] var3);

    public void fillTelNumberList(long var1, int var3);

    public TelNumberDetails getTelNumberDetails(int var1);

    public void fillEmailList(long var1);

    public EmailAddressDetails getEmailAddressDetails(int var1, int var2);

    public void showAddresses(long var1, boolean var3, boolean var4);

    public ADBSDSAddressDetails getAddressDetails(int var1);

    public long getCurrentEntryId();

    public void openEntryDetails(long var1);

    public long getEntryIDFromListRow(EvoListRow var1);

    public void getEntryNames(long[] var1);

    public static class TelNumberDetails {
        public String telNumber;
        public int telNumberType;
        public String combinedName;
        public int entryType;
    }

    public static class EmailAddressDetails {
        public String email;
        public String combinedName;
        public int entryType;
    }
}

