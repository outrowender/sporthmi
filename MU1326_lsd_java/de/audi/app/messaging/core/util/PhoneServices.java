/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import org.dsi.ifc.organizer.AdbEntry;

public final class PhoneServices {
    public static void callUnmatchedNumber(final String string, final LogChannel logChannel, AbstractMsgApplication abstractMsgApplication) {
        logChannel.log(1000000, "[PhoneServices#callMatchedNumber] Attempting to call unmatched number = %1", (Object)string);
        final ITelService iTelService = abstractMsgApplication.getTelService();
        if (iTelService == null) {
            logChannel.log(100000, "[PhoneServices#callMatchedNumber] ITelService not available.");
        } else {
            abstractMsgApplication.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

                public void run() {
                    try {
                        iTelService.dialNumber(string, null, true);
                    }
                    catch (Exception exception) {
                        Logs.logException(logChannel, exception, "[PhoneServices#callMatchedNumber]");
                    }
                }
            });
        }
    }

    public static void prepareUnmatchedNumber(final String string, final LogChannel logChannel, AbstractMsgApplication abstractMsgApplication) {
        logChannel.log(1000000, "[PhoneServices#prepareUnmatchedNumber] Attempting to prepare a unmatched number for dial = %1", (Object)string);
        final ITelService iTelService = abstractMsgApplication.getTelService();
        if (iTelService == null) {
            logChannel.log(100000, "[PhoneServices#prepareUnmatchedNumber] ITelService not available.");
        } else {
            abstractMsgApplication.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

                public void run() {
                    try {
                        iTelService.prepareDialing(string, null);
                    }
                    catch (Exception exception) {
                        Logs.logException(logChannel, exception, "[PhoneServices#prepareUnmatchedNumber]");
                    }
                }
            });
        }
    }

    public static void callMatchedNumber(final String string, final AdbEntry adbEntry, final int n, final LogChannel logChannel, AbstractMsgApplication abstractMsgApplication) {
        logChannel.log(1000000, "[PhoneServices#callMatchedNumber] Attempting to call contact %1, number = %2", (Object)adbEntry.getCombinedName(), (Object)string);
        final ITelService iTelService = abstractMsgApplication.getTelService();
        if (iTelService == null) {
            logChannel.log(100000, "[PhoneServices#callMatchedNumber] ITelService not available.");
        } else {
            abstractMsgApplication.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

                public void run() {
                    try {
                        iTelService.dialNumberFromADBEntry(adbEntry.getCombinedName(), string, (short)adbEntry.phoneData[n].getNumberType(), (short)adbEntry.getEntryType(), adbEntry.getEntryId(), adbEntry.getPersonalData().getContactPicture(), n, ADBUtils.countPhoneNumbers(adbEntry), null, true);
                    }
                    catch (Exception exception) {
                        Logs.logException(logChannel, exception, "[PhoneServices#callMatchedNumber]");
                    }
                }
            });
        }
    }

    public static void prepareMatchedNumber(final String string, final AdbEntry adbEntry, final int n, final LogChannel logChannel, AbstractMsgApplication abstractMsgApplication) {
        logChannel.log(1000000, "[PhoneServices#prepareMatchedNumber] Attempting to call contact %1, number = %2", (Object)adbEntry.getCombinedName(), (Object)string);
        final ITelService iTelService = abstractMsgApplication.getTelService();
        if (iTelService == null) {
            logChannel.log(100000, "[PhoneServices#prepareMatchedNumber] ITelService not available.");
        } else {
            abstractMsgApplication.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

                public void run() {
                    try {
                        iTelService.prepareDialing(adbEntry.getCombinedName(), string, (short)adbEntry.phoneData[n].getNumberType(), (short)adbEntry.getEntryType(), adbEntry.getEntryId(), adbEntry.getPersonalData().getContactPicture(), n, ADBUtils.countPhoneNumbers(adbEntry), null);
                    }
                    catch (Exception exception) {
                        Logs.logException(logChannel, exception, "[PhoneServices#prepareMatchedNumber]");
                    }
                }
            });
        }
    }
}

