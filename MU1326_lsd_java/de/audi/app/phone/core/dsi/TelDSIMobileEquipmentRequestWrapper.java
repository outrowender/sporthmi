/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CFRequestData;
import org.dsi.ifc.telephoneng.DSIMobileEquipment;
import org.dsi.ifc.telephoneng.Favorite;
import org.dsi.ifc.telephoneng.MailboxDialingNumber;

public class TelDSIMobileEquipmentRequestWrapper
implements ITelDSIMobileEquipmentRequestWrapper {
    private final DSIMobileEquipment dsi;
    private final LogChannel log;

    private static CFRequestData[] convertCFRequestData(CFRequestData[] cFRequestDataArray) {
        CFRequestData[] cFRequestDataArray2 = null;
        if (cFRequestDataArray != null) {
            cFRequestDataArray2 = new CFRequestData[cFRequestDataArray.length];
            for (int i2 = 0; i2 < cFRequestDataArray2.length; ++i2) {
                if (cFRequestDataArray[i2] == null) continue;
                cFRequestDataArray2[i2] = new CFRequestData(cFRequestDataArray[i2].telCFMode, cFRequestDataArray[i2].telCFCondition, cFRequestDataArray[i2].telCFNumber, cFRequestDataArray[i2].telClass, cFRequestDataArray[i2].telCFTime);
            }
        }
        return cFRequestDataArray2;
    }

    public TelDSIMobileEquipmentRequestWrapper(DSIMobileEquipment dSIMobileEquipment, LogChannel logChannel) {
        this.dsi = dSIMobileEquipment;
        this.log = logChannel;
    }

    public void acceptCall(int n) {
        if (this.dsi != null) {
            this.dsi.acceptCall(n);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#acceptCall] dsi is null --> NOP!");
        }
    }

    public void hangupCall(int n) {
        if (this.dsi != null) {
            this.dsi.hangupCall(n);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#hangupCall] dsi is null --> NOP!");
        }
    }

    public void swapCalls() {
        if (this.dsi != null) {
            this.dsi.swapCalls();
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#swapCalls] dsi is null --> NOP!");
        }
    }

    public void splitCall(short s) {
        if (this.dsi != null) {
            this.dsi.splitCall(s);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#splitCall] dsi is null --> NOP!");
        }
    }

    public void joinCalls() {
        if (this.dsi != null) {
            this.dsi.joinCalls();
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#joinCalls] dsi is null --> NOP!");
        }
    }

    public void dialNumber(String string) {
        if (this.dsi != null) {
            this.dsi.dialNumber(string);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#dialNumber] dsi is null --> NOP!");
        }
    }

    public void dialOperator(int n, String string) {
        if (this.dsi != null) {
            this.dsi.dialOperator(n, string);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#dialOperator] dsi is null --> NOP!");
        }
    }

    public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2) {
        if (this.dsi != null) {
            this.dsi.dialNumberFromDBEntry(string, l, string2, s, s2, resourceLocator, n, n2);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#dialNumberFromDBEntry] dsi is null --> NOP!");
        }
    }

    public void sendDTMF(String string) {
        if (this.dsi != null) {
            this.dsi.sendDTMF(string);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#sendDTMF] dsi is null --> NOP!");
        }
    }

    public void requestNetworkRegistration(String string, int n) {
        if (this.dsi != null) {
            this.dsi.requestNetworkRegistration(string, n);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestNetworkRegistration] dsi is null --> NOP!");
        }
    }

    public void requestAbortNetworkRegistration() {
        if (this.dsi != null) {
            this.dsi.requestAbortNetworkRegistration();
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestAbortNetworkRegistration] dsi is null --> NOP!");
        }
    }

    public void requestNetworkSearch() {
        if (this.dsi != null) {
            this.dsi.requestNetworkSearch();
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestNetworkSearch] dsi is null --> NOP!");
        }
    }

    public void requestAbortNetworkSearch() {
        if (this.dsi != null) {
            this.dsi.requestAbortNetworkSearch();
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestAbortNetworkSearch] dsi is null --> NOP!");
        }
    }

    public void requestCallForward(CFRequestData[] cFRequestDataArray) {
        if (this.dsi != null) {
            this.dsi.requestCallForward(TelDSIMobileEquipmentRequestWrapper.convertCFRequestData(cFRequestDataArray));
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestCallForward] dsi is null --> NOP!");
        }
    }

    public void requestCallWaiting(int n) {
        if (this.dsi != null) {
            this.dsi.requestCallWaiting(n);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestCallWaiting] dsi is null --> NOP!");
        }
    }

    public void requestCLIR(int n) {
        if (this.dsi != null) {
            this.dsi.requestCLIR(n);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestCLIR] dsi is null --> NOP!");
        }
    }

    public void requestServiceCodeAbort() {
        if (this.dsi != null) {
            this.dsi.requestServiceCodeAbort();
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestServiceCodeAbort] dsi is null --> NOP!");
        }
    }

    public void requestSetAutomaticPinEntryActive(boolean bl) {
        if (this.dsi != null) {
            this.dsi.requestSetAutomaticPinEntryActive(bl);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetAutomaticPinEntryActive] dsi is null --> NOP!");
        }
    }

    public void requestSetAutomaticRedialActive(boolean bl) {
        if (this.dsi != null) {
            this.dsi.requestSetAutomaticRedialActive(bl);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetAutomaticRedialActive] dsi is null --> NOP!");
        }
    }

    public void requestSetCDMAThreeWayCallingSetting(boolean bl) {
        if (this.dsi != null) {
            this.dsi.requestSetCDMAThreeWayCallingSetting(bl);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetCDMAThreeWayCallingSetting] dsi is null --> NOP!");
        }
    }

    public void requestSetAutomaticEmergencyCallActive(boolean bl) {
        if (this.dsi != null) {
            this.dsi.requestSetAutomaticEmergencyCallActive(bl);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetAutomaticEmergencyCallActive] dsi is null --> NOP!");
        }
    }

    public void requestSetEnhancedPrivacyMode(boolean bl) {
        if (this.dsi != null) {
            this.dsi.requestSetEnhancedPrivacyMode(bl);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetEnhancedPrivacyMode] dsi is null --> NOP!");
        }
    }

    public void requestSetMailboxContent(String string) {
        if (this.dsi != null) {
            MailboxDialingNumber mailboxDialingNumber = new MailboxDialingNumber();
            mailboxDialingNumber.mailboxNumber = string;
            MailboxDialingNumber[] mailboxDialingNumberArray = new MailboxDialingNumber[]{mailboxDialingNumber};
            this.dsi.requestSetMailboxContent(mailboxDialingNumberArray);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetMailboxContent] dsi is null --> NOP!");
        }
    }

    public void requestSetPrivacyMode(boolean bl) {
        if (this.dsi != null) {
            this.dsi.requestSetPrivacyMode(bl);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetPrivacyMode] dsi is null --> NOP!");
        }
    }

    public void requestTelPower(int n) {
        if (this.dsi != null) {
            this.dsi.requestTelPower(n);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestTelPower] dsi is null --> NOP!");
        }
    }

    public void requestUnlockSIM(int n, String string, String string2) {
        if (this.dsi != null) {
            this.dsi.requestUnlockSIM(n, string, string2);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestUnlockSIM] dsi is null --> NOP!");
        }
    }

    public void requestCheckSIMPINCode(String string) {
        if (this.dsi != null) {
            this.dsi.requestCheckSIMPINCode(string);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestCheckSIMPINCode] dsi is null --> NOP!");
        }
    }

    public void requestChangeSIMCode(int n, String string, String string2) {
        if (this.dsi != null) {
            this.dsi.requestChangeSIMCode(n, string, string2);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestChangeSIMCode] dsi is null --> NOP!");
        }
    }

    public void requestSetHandsFreeMode(int n) {
        if (this.dsi != null) {
            this.dsi.requestSetHandsFreeMode(n);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetHandsFreeMode] dsi is null --> NOP!");
        }
    }

    public void requestSetMICMuteState(int n) {
        if (this.dsi != null) {
            this.dsi.requestSetMICMuteState(n);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetMICMuteState] dsi is null --> NOP!");
        }
    }

    public void requestSetLanguage(String string) {
        if (this.dsi != null) {
            this.dsi.requestSetLanguage(string);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetLanguage] dsi is null --> NOP!");
        }
    }

    public void requestSIMPINRequired(String string, boolean bl) {
        if (this.dsi != null) {
            this.dsi.requestSIMPINRequired(string, bl);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSIMPINRequired] dsi is null --> NOP!");
        }
    }

    public void restoreFactorySettings() {
        if (this.dsi != null) {
            this.dsi.restoreFactorySettings();
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#restoreFactorySettings] dsi is null --> NOP!");
        }
    }

    public void requestSetMicGainLevel(int n) {
        if (this.dsi != null) {
            this.dsi.requestSetMicGainLevel(n);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetMicGainLevel] dsi is null --> NOP!");
        }
    }

    public void requestDecreaseMicGainLevel(short s) {
        if (this.dsi != null) {
            this.dsi.requestDecreaseMicGainLevel(s);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestDecreaseMicGainLevel] dsi is null --> NOP!");
        }
    }

    public void requestIncreaseMicGainLevel(short s) {
        if (this.dsi != null) {
            this.dsi.requestIncreaseMicGainLevel(s);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestIncreaseMicGainLevel] dsi is null --> NOP!");
        }
    }

    public void requestSetOptimizationMode(int n) {
        if (this.dsi != null) {
            this.dsi.requestSetOptimizationMode(n);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetOptimizationMode] dsi is null --> NOP!");
        }
    }

    public void requestUnlockOtherSIM(int n, String string) {
        if (this.dsi != null) {
            this.dsi.requestUnlockOtherSIM(n, string);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestUnlockOtherSIM] dsi is null --> NOP!");
        }
    }

    public void requestSetSIMAliases(String string, String string2) {
        if (this.dsi != null) {
            this.dsi.requestSetSIMAliases(string, string2);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetSIMAliases] dsi is null --> NOP!");
        }
    }

    public void requestSetNADMode(int n) {
        if (this.dsi != null) {
            this.dsi.requestSetNADMode(n);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetNADMode] dsi is null --> NOP!");
        }
    }

    public void requestRemoveOtherSIM() {
        if (this.dsi != null) {
            this.dsi.requestRemoveOtherSIM();
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestRemoveOtherSIM] dsi is null --> NOP!");
        }
    }

    public void requestSetPhoneReminderSetting(boolean bl) {
        if (this.dsi != null) {
            this.dsi.requestSetPhoneReminderSetting(bl);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetPhoneReminderSetting] dsi is null --> NOP!");
        }
    }

    public void requestSetPrefixActivated(boolean bl) {
        if (this.dsi != null) {
            this.dsi.requestSetPrefixActivated(bl);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetPrefixActivated] dsi is null --> NOP!");
        }
    }

    public void requestSetPrefixContent(String string) {
        if (this.dsi != null) {
            this.dsi.requestSetPrefixContent(string);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetPrefixContent] dsi is null --> NOP!");
        }
    }

    public void requestSetPhoneRingtone(int n, String string) {
        if (this.dsi != null) {
            this.dsi.requestSetPhoneRingtone(n, string);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetPhoneRingtone] dsi is null --> NOP!");
        }
    }

    public void requestSetFavorites(Favorite[] favoriteArray) {
        if (this.dsi != null) {
            Favorite[] favoriteArray2 = null;
            if (favoriteArray != null) {
                favoriteArray2 = new Favorite[favoriteArray.length];
                for (int i2 = 0; i2 < favoriteArray.length; ++i2) {
                    if (favoriteArray[i2] == null) continue;
                    favoriteArray2[i2] = new Favorite(favoriteArray[i2].name, favoriteArray[i2].number);
                }
            }
            this.dsi.requestSetFavorites(favoriteArray2);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetFavorites] dsi is null --> NOP!");
        }
    }

    public void requestSetSIMName(String string) {
        if (this.dsi != null) {
            this.dsi.requestSetSIMName(string);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetSIMName] dsi is null --> NOP!");
        }
    }

    public void requestSetESIMActive(boolean bl) {
        if (this.dsi != null) {
            this.dsi.requestSetESIMActive(bl);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#requestSetESIMActive] dsi is null --> NOP!");
        }
    }

    public void deleteCallstacksAll(int n) {
        if (this.dsi != null) {
            this.dsi.deleteCallstacksAll(n);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#deleteCallstacksAll] dsi is null --> NOP!");
        }
    }

    public void deleteCallstacksEntry(int n, int n2) {
        if (this.dsi != null) {
            this.dsi.deleteCallstacksEntry(n, n2);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#deleteCallstacksEntry] dsi is null --> NOP!");
        }
    }

    public void resetMissedCallIndicator() {
        if (this.dsi != null) {
            this.dsi.resetMissedCallIndicator();
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#resetMissedCallIndicator] dsi is null --> NOP!");
        }
    }

    public void revertCallstacks(boolean bl) {
        if (this.dsi != null) {
            this.dsi.revertCallstacks(bl);
        } else {
            this.log.log(100000, "[TelDSIMobileEquipmentRequestWrapper#revertCallstacks] dsi is null --> NOP!");
        }
    }

    public boolean isDSIAvailable() {
        return this.dsi != null;
    }
}

