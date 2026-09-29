/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb;

import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.app.sdsmanager.apps.adb.AddressBookSDSHandler$TelNumberInfo;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.interapp.ADBSDSService$TelNumberDetails;
import de.audi.atip.interapp.NaviService;

public interface AddressBookSDSHandler
extends ISDSApplication {
    default public void setADBService(ADBSDSService aDBSDSService) {
    }

    default public ADBSDSService getADBService() {
    }

    default public void unsetADBService() {
    }

    default public void setNaviService(NaviService naviService) {
    }

    default public void unsetNaviService() {
    }

    default public int getProfileID() {
    }

    default public long getCurrentEntryID() {
    }

    default public void setPhoneNumberTypes(int n) {
    }

    default public int getPhoneNumberTypes() {
    }

    default public TelNumberInfo getTelNumberInfo() {
    }

    default public long getADBID(int n) {
    }

    default public void setCurrentEntryID(long l) {
    }

    default public long getSelectedEntryID() {
    }

    default public void setSelectedEntryID(long l) {
    }

    default public void setNavLocations(int[] nArray) {
    }

    default public long[] getEntryIDs() {
    }

    default public void setEntryIDs(long[] lArray) {
    }

    default public void handleItemSelectionInAdbList(int n, int n2) {
    }

    default public long getADBEntrySelectionInterruptID() {
    }

    default public void setADBEntrySelectionInterruptID(long l) {
    }

    default public void setTelNumberDetails(ADBSDSService$TelNumberDetails aDBSDSService$TelNumberDetails) {
    }

    default public int getNavLocationSize() {
    }

    default public int getNavLocationType(int n) {
    }

    default public int getNavLocationTypeByCategory(int n) {
    }

    default public void responseGetEntryNames(String[] stringArray) {
    }

    default public ADBSDSService$TelNumberDetails getTelNumberDetails(int n) {
    }

    default public void updateTelNumberInfo(int n, int n2, String string) {
    }
}

