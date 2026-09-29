/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.ADBSDSAddressDetails;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.interapp.ADBSDSService$EmailAddressDetails;
import de.audi.atip.interapp.ADBSDSService$TelNumberDetails;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullADBSDSService
extends NullService
implements ADBSDSService {
    public NullADBSDSService(LogChannel logChannel) {
        super(logChannel, "ADBSDSService");
    }

    @Override
    public byte freezeDynamicLists() {
        super.log();
        return 0;
    }

    @Override
    public byte unfreezeDynamicLists() {
        super.log();
        return 0;
    }

    @Override
    public void fillAdbPickList(long[] lArray, String[] stringArray, int[] nArray) {
        super.log();
    }

    @Override
    public void fillTelNumberList(long l, int n) {
        super.log();
    }

    @Override
    public void fillEmailList(long l) {
        super.log();
    }

    @Override
    public ADBSDSService$EmailAddressDetails getEmailAddressDetails(int n, int n2) {
        super.log();
        return null;
    }

    @Override
    public ADBSDSService$TelNumberDetails getTelNumberDetails(int n) {
        super.log();
        return null;
    }

    @Override
    public long getCurrentEntryId() {
        super.log();
        return 0L;
    }

    @Override
    public int getAdbProfileID() {
        super.log();
        return 0;
    }

    @Override
    public void openEntryDetails(long l) {
        super.log();
    }

    @Override
    public long getEntryIDFromListRow(EvoListRow evoListRow) {
        super.log();
        return 0L;
    }

    @Override
    public void showAddresses(long l, boolean bl, boolean bl2) {
        super.log();
    }

    @Override
    public ADBSDSAddressDetails getAddressDetails(int n) {
        super.log();
        return null;
    }

    @Override
    public void getEntryNames(long[] lArray) {
        super.log();
    }
}

