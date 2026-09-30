/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.PhoneService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.ResourceLocator;

public class NullPhoneService
extends NullService
implements PhoneService {
    public NullPhoneService(LogChannel logChannel) {
        super(logChannel, "PhoneService");
    }

    public void dialNumber(String string, String string2, boolean bl) {
        super.log();
    }

    public void dialNumber(String string, String string2, long l, long l2, long l3, ResourceLocator resourceLocator, int n, int n2, boolean bl) {
        super.log();
    }

    public boolean isDefaultRingingActive() {
        super.log();
        return false;
    }

    public void telCombiAppEntered() {
        super.log();
    }

    public void telCombiAppLeft() {
        super.log();
    }

    public void setMicGainLevel(int n) {
        super.log();
    }

    public String getIMSI() {
        super.log();
        return "";
    }

    public void fillCallStackList(ListModelApp listModelApp, int n) {
        super.log();
    }

    public String getCallStackNumber(ListModelApp listModelApp, int n) {
        super.log();
        return null;
    }

    public int getCallStackLength(int n) {
        super.log();
        return 0;
    }

    public String getCallStackNumber(int n) {
        super.log();
        return null;
    }

    public String getLastDialedNumber() {
        super.log();
        return null;
    }

    public boolean dialMailboxNumber(boolean bl) {
        super.log();
        return false;
    }

    public void setWaitForDialing(boolean bl) {
        super.log();
    }

    public int getPhonePowerState() {
        super.log();
        return 0;
    }

    public int getPhoneLockState() {
        super.log();
        return 0;
    }

    public boolean hasNetwork() {
        super.log();
        return false;
    }

    public void setNumberSpeller(String string) {
        super.log();
    }

    public String getNumberSpellerContent() {
        super.log();
        return null;
    }

    public void setPINSpeller(String string, boolean bl) {
        super.log();
    }

    public String getPINSpellerContent() {
        super.log();
        return null;
    }

    public boolean checkForSuppService(String string) {
        super.log();
        return false;
    }

    public int getNumType(String string) {
        super.log();
        return 0;
    }

    public boolean isPrivacyModeOn() {
        super.log();
        return false;
    }

    public void unlock(int n, String string) {
        super.log();
    }

    public byte freezeDynamicLists() {
        super.log();
        return 0;
    }

    public byte unfreezeDynamicLists() {
        super.log();
        return 0;
    }

    public void setUserDefinedRingtone(String string, String string2) {
        super.log();
    }

    public void updateConnectedBTProfiles(boolean bl) {
        super.log();
    }

    public boolean callLastDialedNumber() {
        super.log();
        return false;
    }

    public String getFavoritesNumber(int n) {
        super.log();
        return null;
    }
}

