/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.ADBSDSAddressDetails;
import de.audi.atip.interapp.ADBSDSService$EmailAddressDetails;
import de.audi.atip.interapp.ADBSDSService$TelNumberDetails;
import de.audi.atip.interapp.AbstractSDSApplicationService;

public interface ADBSDSService
extends AbstractSDSApplicationService {
    public static final int ADB_RESULT_OK;
    public static final int ADB_RESULT_ERROR;

    default public int getAdbProfileID() {
    }

    default public void fillAdbPickList(long[] lArray, String[] stringArray, int[] nArray) {
    }

    default public void fillTelNumberList(long l, int n) {
    }

    default public TelNumberDetails getTelNumberDetails(int n) {
    }

    default public void fillEmailList(long l) {
    }

    default public EmailAddressDetails getEmailAddressDetails(int n, int n2) {
    }

    default public void showAddresses(long l, boolean bl, boolean bl2) {
    }

    default public ADBSDSAddressDetails getAddressDetails(int n) {
    }

    default public long getCurrentEntryId() {
    }

    default public void openEntryDetails(long l) {
    }

    default public long getEntryIDFromListRow(EvoListRow evoListRow) {
    }

    default public void getEntryNames(long[] lArray) {
    }
}

