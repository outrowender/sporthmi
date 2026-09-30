/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.messaging.sm;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.SMModuleConstants;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.ap.MessagingActionProxy;
import de.audi.atip.statemachine.ap.OnlineActionProxy;
import de.audi.atip.statemachine.ap.PhoneActionProxy;
import java.util.NoSuchElementException;

public class MessagingSMMActions
implements SMModuleConstants {
    private final AbstractSMM smm;
    private final LogChannel logChannel;
    private volatile MessagingActionProxy ap0;
    private volatile PhoneActionProxy ap1;
    private volatile OnlineActionProxy ap2;
    public static int[] REQUIRED_ACTION_PROXY_MODULE_IDS = new int[]{8, 11, 12};

    protected MessagingSMMActions(AbstractSMM abstractSMM, LogChannel logChannel) {
        this.smm = abstractSMM;
        this.logChannel = logChannel;
    }

    public void removeActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof MessagingActionProxy) {
            this.ap0 = null;
            this.logChannel.log(10000000, "MessagingActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof OnlineActionProxy) {
            this.ap2 = null;
            this.logChannel.log(10000000, "OnlineActionProxy Action Proxy removed");
            return;
        }
        if (actionProxy instanceof PhoneActionProxy) {
            this.ap1 = null;
            this.logChannel.log(10000000, "PhoneActionProxy Action Proxy removed");
            return;
        }
    }

    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        if (actionProxy instanceof MessagingActionProxy) {
            this.ap0 = (MessagingActionProxy)actionProxy;
            this.logChannel.log(10000000, "MessagingActionProxy Action Proxy added");
            return this.ap0;
        }
        if (actionProxy instanceof OnlineActionProxy) {
            this.ap2 = (OnlineActionProxy)actionProxy;
            this.logChannel.log(10000000, "OnlineActionProxy Action Proxy added");
            return this.ap2;
        }
        if (actionProxy instanceof PhoneActionProxy) {
            this.ap1 = (PhoneActionProxy)actionProxy;
            this.logChannel.log(10000000, "PhoneActionProxy Action Proxy added");
            return this.ap1;
        }
        return null;
    }

    private void catchActionExceptionMessagingActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'MessagingActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'MessagingActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionOnlineActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'OnlineActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'OnlineActionProxy' missing for call '%1'", (Object)string);
    }

    private void catchActionExceptionPhoneActionProxy(ActionProxy actionProxy, NullPointerException nullPointerException, String string) {
        if (actionProxy != null) {
            this.logChannel.log(1000, "Action Proxy 'PhoneActionProxy' is causing an exception in call '%1'", (Object)string, (Throwable)nullPointerException);
            throw nullPointerException;
        }
        this.logChannel.log(1000000, "Action Proxy 'PhoneActionProxy' missing for call '%1'", (Object)string);
    }

    public void execFocusGainedAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    public void execFocusLostAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    private void ap0_searchableViewTransition_109716468() {
        MessagingActionProxy messagingActionProxy = this.ap0;
        try {
            messagingActionProxy.searchableViewTransition(this.smm.getTerminalID(), 0, 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMessagingActionProxy(messagingActionProxy, nullPointerException, "searchableViewTransition");
        }
    }

    private void ap0_readoutScreensExited_2107068339() {
        MessagingActionProxy messagingActionProxy = this.ap0;
        try {
            messagingActionProxy.readoutScreensExited(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMessagingActionProxy(messagingActionProxy, nullPointerException, "readoutScreensExited");
        }
    }

    private void ap0_detailViewTransition_725899434() {
        MessagingActionProxy messagingActionProxy = this.ap0;
        try {
            messagingActionProxy.detailViewTransition(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMessagingActionProxy(messagingActionProxy, nullPointerException, "detailViewTransition");
        }
    }

    private void ap0_editViewTransition_725899434() {
        MessagingActionProxy messagingActionProxy = this.ap0;
        try {
            messagingActionProxy.editViewTransition(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMessagingActionProxy(messagingActionProxy, nullPointerException, "editViewTransition");
        }
    }

    private void ap0_templateReplacementExited_2107068339() {
        MessagingActionProxy messagingActionProxy = this.ap0;
        try {
            messagingActionProxy.templateReplacementExited(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMessagingActionProxy(messagingActionProxy, nullPointerException, "templateReplacementExited");
        }
    }

    private void ap0_messagingTransition_725899434() {
        MessagingActionProxy messagingActionProxy = this.ap0;
        try {
            messagingActionProxy.messagingTransition(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMessagingActionProxy(messagingActionProxy, nullPointerException, "messagingTransition");
        }
    }

    private void ap0_searchableViewTransition_109746259() {
        MessagingActionProxy messagingActionProxy = this.ap0;
        try {
            messagingActionProxy.searchableViewTransition(this.smm.getTerminalID(), 1, 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMessagingActionProxy(messagingActionProxy, nullPointerException, "searchableViewTransition");
        }
    }

    private void ap0_messageCompositionTransition_725899434() {
        MessagingActionProxy messagingActionProxy = this.ap0;
        try {
            messagingActionProxy.messageCompositionTransition(this.smm.getTerminalID(), 1);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMessagingActionProxy(messagingActionProxy, nullPointerException, "messageCompositionTransition");
        }
    }

    public void execExitAction(SMServices sMServices, int n) {
        switch (n) {
            case 2200009: {
                sMServices.removeContext(-913270519L);
                this.ap0_searchableViewTransition_109716468();
                return;
            }
            case 2200010: {
                sMServices.removeContext(369222116L);
                this.ap0_readoutScreensExited_2107068339();
                this.ap0_detailViewTransition_725899434();
                return;
            }
            case 2200024: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2200034: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2200037: {
                sMServices.removeContext(-1305960882L);
                sMServices.popDrawerIDs();
                return;
            }
            case 2200049: {
                sMServices.removeContext(1329459982L);
                sMServices.popDrawerIDs();
                return;
            }
            case 2200064: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                return;
            }
            case 2200073: {
                sMServices.removeContext(2128184204L);
                this.ap0_editViewTransition_725899434();
                return;
            }
            case 2200074: {
                sMServices.removeContext(-736506653L);
                this.ap0_editViewTransition_725899434();
                return;
            }
            case 2200075: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2200087: {
                sMServices.popDrawerIDs();
                sMServices.setScreenMode(1);
                return;
            }
            case 0x219222: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2200101: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2200111: {
                this.ap0_templateReplacementExited_2107068339();
                return;
            }
            case 2200121: {
                this.ap0_templateReplacementExited_2107068339();
                return;
            }
            case 2200145: {
                sMServices.popDrawerIDs();
                return;
            }
            case 2200150: {
                sMServices.removeContext(-1919187206L);
                sMServices.popDrawerIDs();
                this.ap0_messagingTransition_725899434();
                return;
            }
            case 2200151: {
                sMServices.removeContext(-399568537L);
                sMServices.popDrawerIDs();
                return;
            }
            case 2200153: {
                sMServices.removeContext(-1494997765L);
                sMServices.popDrawerIDs();
                this.ap0_messagingTransition_725899434();
                return;
            }
            case 2200154: {
                this.ap0_searchableViewTransition_109746259();
                sMServices.popDrawerIDs();
                return;
            }
            case 2200155: {
                this.ap0_searchableViewTransition_109746259();
                sMServices.popDrawerIDs();
                return;
            }
            case 2200158: {
                this.ap0_messageCompositionTransition_725899434();
                return;
            }
            case 2200161: {
                this.ap0_messageCompositionTransition_725899434();
                return;
            }
            case 2200242: {
                sMServices.removeContext(1329459982L);
                sMServices.popDrawerIDs();
                return;
            }
            case 2200244: {
                sMServices.removeContext(-1305960882L);
                sMServices.popDrawerIDs();
                return;
            }
            case 2200245: {
                sMServices.removeContext(494302687L);
                this.ap0_searchableViewTransition_109716468();
                return;
            }
            case 2200249: {
                sMServices.removeContext(-901076816L);
                this.ap0_readoutScreensExited_2107068339();
                this.ap0_detailViewTransition_725899434();
                return;
            }
            case 2200278: {
                sMServices.removeContext(-1305960882L);
                sMServices.popDrawerIDs();
                return;
            }
            case 2200284: {
                sMServices.removeContext(1329459982L);
                sMServices.popDrawerIDs();
                return;
            }
        }
    }

    public void execEnteredAction(SMServices sMServices, int n) {
        switch (n) {
            default: 
        }
    }

    private void ap0_searchableViewTransition_109716467() {
        MessagingActionProxy messagingActionProxy = this.ap0;
        try {
            messagingActionProxy.searchableViewTransition(this.smm.getTerminalID(), 0, 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMessagingActionProxy(messagingActionProxy, nullPointerException, "searchableViewTransition");
        }
    }

    private void ap0_detailViewTransition_725899433() {
        MessagingActionProxy messagingActionProxy = this.ap0;
        try {
            messagingActionProxy.detailViewTransition(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMessagingActionProxy(messagingActionProxy, nullPointerException, "detailViewTransition");
        }
    }

    private void ap0_editViewTransition_725899433() {
        MessagingActionProxy messagingActionProxy = this.ap0;
        try {
            messagingActionProxy.editViewTransition(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMessagingActionProxy(messagingActionProxy, nullPointerException, "editViewTransition");
        }
    }

    private void ap0_messagingTransition_725899433() {
        MessagingActionProxy messagingActionProxy = this.ap0;
        try {
            messagingActionProxy.messagingTransition(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMessagingActionProxy(messagingActionProxy, nullPointerException, "messagingTransition");
        }
    }

    private void ap1_adbEntered_2107068339() {
        PhoneActionProxy phoneActionProxy = this.ap1;
        try {
            phoneActionProxy.adbEntered(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionPhoneActionProxy(phoneActionProxy, nullPointerException, "adbEntered");
        }
    }

    private void ap0_searchableViewTransition_109746258() {
        MessagingActionProxy messagingActionProxy = this.ap0;
        try {
            messagingActionProxy.searchableViewTransition(this.smm.getTerminalID(), 1, 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMessagingActionProxy(messagingActionProxy, nullPointerException, "searchableViewTransition");
        }
    }

    private void ap0_messageCompositionTransition_725899433() {
        MessagingActionProxy messagingActionProxy = this.ap0;
        try {
            messagingActionProxy.messageCompositionTransition(this.smm.getTerminalID(), 0);
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMessagingActionProxy(messagingActionProxy, nullPointerException, "messageCompositionTransition");
        }
    }

    public void execEnterAction(SMServices sMServices, int n) {
        switch (n) {
            case 2200009: {
                sMServices.addContext(-913270519L);
                this.ap0_searchableViewTransition_109716467();
                return;
            }
            case 2200010: {
                sMServices.addContext(369222116L);
                this.ap0_detailViewTransition_725899433();
                return;
            }
            case 2200021: {
                sMServices.setColor(4);
                return;
            }
            case 2200024: {
                sMServices.setColor(4);
                sMServices.pushDrawerIDs(0L, 300003L);
                return;
            }
            case 2200032: {
                sMServices.setScreenMode(2);
                return;
            }
            case 2200034: {
                sMServices.setColor(4);
                sMServices.pushDrawerIDs(0L, 2200001L);
                return;
            }
            case 2200037: {
                sMServices.addContext(-1305960882L);
                sMServices.pushDrawerIDs(0L, 300003L);
                return;
            }
            case 2200049: {
                sMServices.addContext(1329459982L);
                sMServices.pushDrawerIDs(0L, 300003L);
                return;
            }
            case 2200063: {
                sMServices.setColor(4);
                return;
            }
            case 2200064: {
                sMServices.pushDrawerIDs(0L, 0L);
                sMServices.setScreenMode(2);
                return;
            }
            case 2200069: {
                sMServices.setScreenMode(1);
                return;
            }
            case 2200071: {
                sMServices.setColor(4);
                return;
            }
            case 2200073: {
                sMServices.addContext(2128184204L);
                this.ap0_editViewTransition_725899433();
                return;
            }
            case 2200074: {
                sMServices.addContext(-736506653L);
                this.ap0_editViewTransition_725899433();
                return;
            }
            case 2200075: {
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 2200087: {
                sMServices.pushDrawerIDs(0L, 0L);
                sMServices.setScreenMode(2);
                return;
            }
            case 2200088: {
                sMServices.setScreenMode(1);
                return;
            }
            case 0x219219: {
                sMServices.setScreenMode(2);
                return;
            }
            case 0x219222: {
                sMServices.pushDrawerIDs(0L, 69L);
                return;
            }
            case 2200101: {
                sMServices.pushDrawerIDs(0L, 69L);
                return;
            }
            case 2200145: {
                sMServices.pushDrawerIDs(0L, 300003L);
                return;
            }
            case 2200150: {
                sMServices.pushDrawerIDs(300002L, 300003L);
                sMServices.addContext(-1919187206L);
                sMServices.setColor(4);
                this.ap0_messagingTransition_725899433();
                return;
            }
            case 2200151: {
                sMServices.addContext(1848205283L);
                sMServices.addScreenAnimation(16);
                sMServices.pushDrawerIDs(2200000L, 2200001L);
                this.ap1_adbEntered_2107068339();
                return;
            }
            case 2200153: {
                sMServices.addContext(-1494997765L);
                sMServices.pushDrawerIDs(300002L, 300003L);
                sMServices.setColor(4);
                this.ap0_messagingTransition_725899433();
                return;
            }
            case 2200154: {
                this.ap0_searchableViewTransition_109746258();
                sMServices.pushDrawerIDs(0L, 300003L);
                return;
            }
            case 2200155: {
                this.ap0_searchableViewTransition_109746258();
                sMServices.pushDrawerIDs(0L, 300003L);
                return;
            }
            case 2200158: {
                this.ap0_messageCompositionTransition_725899433();
                return;
            }
            case 2200161: {
                this.ap0_messageCompositionTransition_725899433();
                return;
            }
            case 2200166: {
                sMServices.setScreenMode(2);
                return;
            }
            case 2200215: {
                this.ap1_adbEntered_2107068339();
                return;
            }
            case 2200233: {
                sMServices.setColor(4);
                return;
            }
            case 2200235: {
                sMServices.setColor(4);
                return;
            }
            case 2200242: {
                sMServices.addContext(1329459982L);
                sMServices.pushDrawerIDs(0L, 300003L);
                return;
            }
            case 2200244: {
                sMServices.addContext(-1305960882L);
                sMServices.pushDrawerIDs(0L, 300003L);
                return;
            }
            case 2200245: {
                sMServices.addContext(494302687L);
                this.ap0_searchableViewTransition_109716467();
                return;
            }
            case 2200249: {
                sMServices.addContext(-901076816L);
                this.ap0_detailViewTransition_725899433();
                return;
            }
            case 2200252: {
                sMServices.setColor(4);
                return;
            }
            case 2200264: {
                sMServices.setScreenMode(2);
                return;
            }
            case 2200266: {
                sMServices.setScreenMode(2);
                return;
            }
            case 2200278: {
                sMServices.addContext(-1305960882L);
                sMServices.pushDrawerIDs(0L, 300003L);
                return;
            }
            case 2200284: {
                sMServices.addContext(1329459982L);
                sMServices.pushDrawerIDs(0L, 300003L);
                return;
            }
        }
    }

    private void ap0_parentFolderSelected_2107068339() {
        MessagingActionProxy messagingActionProxy = this.ap0;
        try {
            messagingActionProxy.parentFolderSelected(this.smm.getTerminalID());
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionMessagingActionProxy(messagingActionProxy, nullPointerException, "parentFolderSelected");
        }
    }

    private void ap2_licenseCheckEntered__997340422() {
        OnlineActionProxy onlineActionProxy = this.ap2;
        try {
            onlineActionProxy.licenseCheckEntered(this.smm.getTerminalID(), "dictation", "SMS Dictation");
        }
        catch (NullPointerException nullPointerException) {
            this.catchActionExceptionOnlineActionProxy(onlineActionProxy, nullPointerException, "licenseCheckEntered");
        }
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        switch (n) {
            case 2200008: {
                switch (n2) {
                    case 0: {
                        this.ap0_parentFolderSelected_2107068339();
                        return;
                    }
                    case 1: {
                        sMServices.removeContext(-1919187206L);
                        return;
                    }
                }
                return;
            }
            case 2200012: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200020: {
                switch (n2) {
                    case 0: {
                        this.ap0_parentFolderSelected_2107068339();
                        return;
                    }
                }
                return;
            }
            case 2200039: {
                sMServices.addContext(8L);
                return;
            }
            case 2200040: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200044: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200047: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200048: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200051: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200054: {
                sMServices.addContext(8L);
                return;
            }
            case 2200077: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2200084: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 0x219222: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200099: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2200122: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200123: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200130: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2200134: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200143: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200144: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200145: {
                sMServices.addContext(8L);
                return;
            }
            case 2200146: {
                sMServices.addContext(8L);
                return;
            }
            case 2200179: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200185: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200199: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200208: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(0x219211);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(2200080);
                        return;
                    }
                }
                return;
            }
            case 0x219291: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(2200075);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(2200074);
                        return;
                    }
                }
                return;
            }
            case 2200215: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200227: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200240: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(2200148);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(2200148);
                        return;
                    }
                }
                return;
            }
            case 2200248: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200249: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200254: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(2200149);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(2200149);
                        return;
                    }
                }
                return;
            }
            case 2200264: {
                sMServices.addContext(128L);
                return;
            }
            case 2200277: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200278: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200285: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(2200148);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(2200148);
                        return;
                    }
                }
                return;
            }
            case 2200287: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(2200149);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(2200149);
                        return;
                    }
                }
                return;
            }
            case 2200289: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200291: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200298: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200299: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200300: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200301: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200303: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200304: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200321: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 2200322: {
                sMServices.addScreenAnimation(32);
                return;
            }
            case 2200323: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200324: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200325: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200330: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200360: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2200363: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2200370: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200371: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200373: {
                return;
            }
            case 2200376: {
                this.ap2_licenseCheckEntered__997340422();
                return;
            }
            case 2200378: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200388: {
                sMServices.addScreenAnimation(64);
                sMServices.setScreenMode(1);
                return;
            }
            case 2200389: {
                sMServices.addScreenAnimation(64);
                sMServices.setScreenMode(1);
                return;
            }
            case 2200395: {
                return;
            }
            case 2200403: {
                return;
            }
            case 2200404: {
                return;
            }
            case 2200410: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2200412: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2200486: {
                return;
            }
            case 2200487: {
                return;
            }
            case 2200493: {
                return;
            }
            case 2200507: {
                return;
            }
            case 2200523: {
                return;
            }
            case 2200524: {
                return;
            }
            case 2200534: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200535: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200565: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200571: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200572: {
                return;
            }
            case 2200579: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(2200144);
                        return;
                    }
                    case 1: {
                        sMServices.showPartialPopup(2200145);
                        return;
                    }
                    case 2: {
                        sMServices.showPartialPopup(2200143);
                        return;
                    }
                }
                return;
            }
            case 2200581: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200584: {
                sMServices.hidePartialPopup(2200146);
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(2200147);
                        return;
                    }
                }
                return;
            }
            case 2200588: {
                return;
            }
            case 2200591: {
                sMServices.hidePartialPopup(2200146);
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(2200147);
                        return;
                    }
                }
                return;
            }
            case 2200594: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(2200148);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(2200148);
                        return;
                    }
                }
                return;
            }
            case 2200595: {
                switch (n2) {
                    case 0: {
                        sMServices.showPartialPopup(2200149);
                        return;
                    }
                    case 1: {
                        sMServices.hidePartialPopup(2200149);
                        return;
                    }
                }
                return;
            }
            case 2200597: {
                return;
            }
            case 2200598: {
                return;
            }
            case 2200615: {
                this.ap2_licenseCheckEntered__997340422();
                return;
            }
            case 2200622: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 2200623: {
                sMServices.addScreenAnimation(16);
                return;
            }
            case 2200628: {
                sMServices.addScreenAnimation(8);
                sMServices.setScreenMode(2);
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 2200629: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 2200630: {
                sMServices.addScreenAnimation(64);
                return;
            }
            case 2200633: {
                sMServices.popDrawerIDs();
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2200636: {
                sMServices.addContext(-1494997765L);
                return;
            }
            case 2200637: {
                return;
            }
            case 2200643: {
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2200652: {
                sMServices.popDrawerIDs();
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2200657: {
                sMServices.setScreenMode(2);
                sMServices.addScreenAnimation(8);
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 2200661: {
                sMServices.setScreenMode(2);
                sMServices.addScreenAnimation(8);
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 2200663: {
                sMServices.popDrawerIDs();
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2200668: {
                sMServices.setScreenMode(2);
                sMServices.addScreenAnimation(8);
                sMServices.pushDrawerIDs(0L, 0L);
                return;
            }
            case 2200670: {
                sMServices.popDrawerIDs();
                sMServices.addScreenAnimation(128);
                return;
            }
            case 2200679: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200683: {
                return;
            }
            case 2200685: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200686: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200687: {
                sMServices.addScreenAnimation(8);
                return;
            }
            case 2200695: {
                sMServices.showPartialPopup(2200146);
                return;
            }
            case 2200696: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(2200147);
                        return;
                    }
                }
                return;
            }
            case 2200698: {
                sMServices.showPartialPopup(2200146);
                return;
            }
            case 2200699: {
                switch (n2) {
                    case 1: {
                        sMServices.showPartialPopup(2200147);
                        return;
                    }
                }
                return;
            }
        }
    }

    public HMIModel getModel(int n) throws NoSuchElementException {
        return this.smm.getModel(n);
    }
}

