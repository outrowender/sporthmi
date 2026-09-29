/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.phone;

import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.atip.phone.ITelServiceSDS;
import java.util.Map;

public interface PhoneSDSHandler
extends ISDSApplication {
    public static final byte SPELLER_PHONE_NUMBER;
    public static final byte SPELLER_PIN_CODE;
    public static final byte SPELLER_MAILBOX_NUMBER;
    public static final int LIST_MODE_CALL_LIST;
    public static final int LIST_MODE_CALL_LIST_NBEST;
    public static final int LIST_MODE_CALL_LIST_DETAIL;
    public static final int LIST_MODE_FAVORITES;
    public static final int LIST_MODE_FAVORITES_DETAIL;
    public static final int LIST_MODE_REDIAL_NUMBER;
    public static final int LIST_MODE_MAILBOX;
    public static final int LIST_MODE_FIRST_ENTRY;
    public static final int LIST_MODE_CALL_LIST_TITLE;
    public static final int LIST_MODE_FAVORITES_TITLE;

    default public void setPhoneService(ITelServiceSDS iTelServiceSDS) {
    }

    default public void unsetPhoneService() {
    }

    default public ITelServiceSDS getPhoneService() {
    }

    default public void setPhoneSpeller(byte by, String string, boolean bl) {
    }

    default public String getCallStackNumber(int n) {
    }

    default public String getCallStackName(int n) {
    }

    default public int getCallStackLength() {
    }

    default public int getFavoritesLength() {
    }

    default public long getCallStackAdbId(int n) {
    }

    default public short getCallStackPhoneType(int n) {
    }

    default public int getCallStackIndexById(long l) {
    }

    default public int getCallStackIndexByADBId(long l) {
    }

    default public int getFavoriteIndexById(long l) {
    }

    default public String getFavoriteNumber(int n) {
    }

    default public String getFavoriteName(int n) {
    }

    default public Map getAdbToCallStackMapping() {
    }

    default public void matchTextWithPINSequenceDirect(String string) {
    }

    default public void matchTextWithNumberSequenceDirect(String string) {
    }

    default public void matchTextWithMailboxSequenceDirect(String string) {
    }
}

