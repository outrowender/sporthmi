/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.ADBSDSAddressDetails;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullADBSDSService
extends NullService
implements ADBSDSService {
    public NullADBSDSService(LogChannel logChannel) {
        super(logChannel, "ADBSDSService");
    }

    public byte freezeDynamicLists() {
        super.log();
        return 0;
    }

    public byte unfreezeDynamicLists() {
        super.log();
        return 0;
    }

    public void fillAdbPickList(long[] lArray, String[] stringArray, int[] nArray) {
        super.log();
    }

    public void fillTelNumberList(long l, int n) {
        super.log();
    }

    public void fillEmailList(long l) {
        super.log();
    }

    public ADBSDSService.EmailAddressDetails getEmailAddressDetails(int n, int n2) {
        super.log();
        return null;
    }

    public ADBSDSService.TelNumberDetails getTelNumberDetails(int n) {
        super.log();
        return null;
    }

    public long getCurrentEntryId() {
        super.log();
        return 0L;
    }

    public int getAdbProfileID() {
        super.log();
        return 0;
    }

    public void openEntryDetails(long l) {
        super.log();
    }

    public long getEntryIDFromListRow(EvoListRow evoListRow) {
        super.log();
        return 0L;
    }

    public void showAddresses(long l, boolean bl, boolean bl2) {
        super.log();
    }

    public ADBSDSAddressDetails getAddressDetails(int n) {
        super.log();
        return null;
    }

    public void getEntryNames(long[] lArray) {
        super.log();
    }
}

