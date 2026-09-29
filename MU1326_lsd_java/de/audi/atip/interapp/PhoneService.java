/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.AbstractSDSApplicationService;
import org.dsi.ifc.global.ResourceLocator;

public interface PhoneService
extends AbstractSDSApplicationService {
    public static final int NUMBER_MAX_LENGTH;
    public static final int CALLSTACK_NONE;
    public static final int CALLSTACK_LAST_CALLS;
    public static final int CALLSTACK_MISSED_CALLS;
    public static final int CALLSTACK_RECEIVED_CALLS;
    public static final int CALLSTACK_COMBINED_CALLS;
    public static final int CALLSTACK_SMS;
    public static final int CALL_STACK_SCREEN_SIZE;
    public static final int POWERSTATE_OK;
    public static final int POWERSTATE_NO_PHONE;
    public static final int POWERSTATE_NO_SIM;
    public static final int POWERSTATE_ERROR;
    public static final int PIN_MAX_LENGTH;

    default public void dialNumber(String string, String string2, boolean bl) {
    }

    default public void dialNumber(String string, String string2, long l, long l2, long l3, ResourceLocator resourceLocator, int n, int n2, boolean bl) {
    }

    default public boolean isDefaultRingingActive() {
    }

    default public void setMicGainLevel(int n) {
    }

    default public String getIMSI() {
    }

    default public void fillCallStackList(ListModelApp listModelApp, int n) {
    }

    default public String getCallStackNumber(ListModelApp listModelApp, int n) {
    }

    default public int getCallStackLength(int n) {
    }

    default public String getLastDialedNumber() {
    }

    default public boolean callLastDialedNumber() {
    }

    default public String getCallStackNumber(int n) {
    }

    default public boolean dialMailboxNumber(boolean bl) {
    }

    default public void setWaitForDialing(boolean bl) {
    }

    default public int getPhonePowerState() {
    }

    default public int getPhoneLockState() {
    }

    default public boolean hasNetwork() {
    }

    default public void setNumberSpeller(String string) {
    }

    default public String getNumberSpellerContent() {
    }

    default public void setPINSpeller(String string, boolean bl) {
    }

    default public String getPINSpellerContent() {
    }

    default public boolean checkForSuppService(String string) {
    }

    default public int getNumType(String string) {
    }

    default public boolean isPrivacyModeOn() {
    }

    default public void unlock(int n, String string) {
    }

    default public void setUserDefinedRingtone(String string, String string2) {
    }

    default public void updateConnectedBTProfiles(boolean bl) {
    }

    default public String getFavoritesNumber(int n) {
    }
}

