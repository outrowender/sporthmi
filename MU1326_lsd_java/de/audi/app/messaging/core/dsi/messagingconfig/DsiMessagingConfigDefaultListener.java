/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messagingconfig;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.component.IMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Logs;
import java.util.Collection;
import java.util.LinkedList;
import org.dsi.ifc.messaging.DSIMessagingServiceConfigurationListener;

final class DsiMessagingConfigDefaultListener
extends AbstractMessagingComponent
implements IMessagingComponent,
DSIMessagingServiceConfigurationListener {
    private final Collection subscribers = new LinkedList();

    public DsiMessagingConfigDefaultListener(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public synchronized void addSubscriber(DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener) {
        this.subscribers.add(dSIMessagingServiceConfigurationListener);
    }

    private synchronized DSIMessagingServiceConfigurationListener[] getCurrentSubscribers() {
        Object[] objectArray = new DSIMessagingServiceConfigurationListener[this.subscribers.size()];
        this.subscribers.toArray(objectArray);
        return objectArray;
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(100000, "[DsiMessagingConfigDefaultListener#asyncException] Not implemented.");
    }

    public void setSMSCNumberResponse(int n) {
        this.log.log(100000, "[DsiMessagingConfigDefaultListener#setSMSCNumberResponse] Not implemented.");
    }

    public void activateStoreSmsOnSentResponse(int n) {
        this.log.log(100000, "[DsiMessagingConfigDefaultListener#activateStoreSmsOnSentResponse] Not implemented.");
    }

    public void setShortMessageValidityPeriodResponse(int n) {
        this.log.log(100000, "[DsiMessagingConfigDefaultListener#setShortMessageValidityPeriodResponse] Not implemented.");
    }

    public void activateSMSDeliveryReportResponse(int n) {
        this.log.log(100000, "[DsiMessagingConfigDefaultListener#activateSMSDeliveryReportResponse] Not implemented.");
    }

    public void updateSMSCNumber(String string, int n) {
        DSIMessagingServiceConfigurationListener[] dSIMessagingServiceConfigurationListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingServiceConfigurationListenerArray.length; ++i2) {
            try {
                dSIMessagingServiceConfigurationListenerArray[i2].updateSMSCNumber(string, n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingConfigDefaultListener#updateSMSCNumber]");
            }
        }
    }

    public void setPhoneSystemRingingVolumeResponse(int n) {
        this.log.log(100000, "[DsiMessagingConfigDefaultListener#setPhoneSystemRingingVolumeResponse] Not implemented.");
    }

    public void setPhoneSystemRingingTypeResponse(int n) {
        this.log.log(100000, "[DsiMessagingConfigDefaultListener#setPhoneSystemRingingTypeResponse] Not implemented.");
    }

    public void activateEmailIncludeOldMailInReplyResponse(int n) {
        this.log.log(100000, "[DsiMessagingConfigDefaultListener#activateEmailIncludeOldMailInReplyResponse] Not implemented.");
    }

    public void activateEmailEmptySubjectNotificationResponse(int n) {
        this.log.log(100000, "[DsiMessagingConfigDefaultListener#activateEmailEmptySubjectNotificationResponse] Not implemented.");
    }

    public void changeFolderViewModeResponse(int n) {
        this.log.log(100000, "[DsiMessagingConfigDefaultListener#changeFolderViewModeResponse] Not implemented.");
    }

    public void restoreFactorySettingsResponse(int n) {
        this.log.log(100000, "[DsiMessagingConfigDefaultListener#restoreFactorySettingsResponse] Not implemented.");
    }

    public void updateAccountPreferences(int n, String string, int n2) {
        DSIMessagingServiceConfigurationListener[] dSIMessagingServiceConfigurationListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingServiceConfigurationListenerArray.length; ++i2) {
            try {
                dSIMessagingServiceConfigurationListenerArray[i2].updateAccountPreferences(n, string, n2);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingConfigDefaultListener#updateAccountPreferences]");
            }
        }
    }

    public void updateSmsDeliveryReport(boolean bl, int n) {
        DSIMessagingServiceConfigurationListener[] dSIMessagingServiceConfigurationListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingServiceConfigurationListenerArray.length; ++i2) {
            try {
                dSIMessagingServiceConfigurationListenerArray[i2].updateSmsDeliveryReport(bl, n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingConfigDefaultListener#updateSmsDeliveryReport]");
            }
        }
    }

    public void updateStoreSmsOnSent(boolean bl, int n) {
        DSIMessagingServiceConfigurationListener[] dSIMessagingServiceConfigurationListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingServiceConfigurationListenerArray.length; ++i2) {
            try {
                dSIMessagingServiceConfigurationListenerArray[i2].updateStoreSmsOnSent(bl, n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingConfigDefaultListener#updateStoreSmsOnSent]");
            }
        }
    }

    public void updateShortMessageValidityPeriod(int n, int n2) {
        DSIMessagingServiceConfigurationListener[] dSIMessagingServiceConfigurationListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingServiceConfigurationListenerArray.length; ++i2) {
            try {
                dSIMessagingServiceConfigurationListenerArray[i2].updateShortMessageValidityPeriod(n, n2);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingConfigDefaultListener#updateShortMessageValidityPeriod]");
            }
        }
    }

    public void updatePhoneSystemRingingVolume(int n, int n2) {
        DSIMessagingServiceConfigurationListener[] dSIMessagingServiceConfigurationListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingServiceConfigurationListenerArray.length; ++i2) {
            try {
                dSIMessagingServiceConfigurationListenerArray[i2].updatePhoneSystemRingingVolume(n, n2);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingConfigDefaultListener#updatePhoneSystemRingingVolume]");
            }
        }
    }

    public void updatePhoneSystemRingingType(int n, int n2) {
        DSIMessagingServiceConfigurationListener[] dSIMessagingServiceConfigurationListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingServiceConfigurationListenerArray.length; ++i2) {
            try {
                dSIMessagingServiceConfigurationListenerArray[i2].updatePhoneSystemRingingType(n, n2);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingConfigDefaultListener#updatePhoneSystemRingingType]");
            }
        }
    }

    public void updateEmailIncludeOldMailInReply(boolean bl, int n) {
        DSIMessagingServiceConfigurationListener[] dSIMessagingServiceConfigurationListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingServiceConfigurationListenerArray.length; ++i2) {
            try {
                dSIMessagingServiceConfigurationListenerArray[i2].updateEmailIncludeOldMailInReply(bl, n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingConfigDefaultListener#updateEmailIncludeOldMailInReply]");
            }
        }
    }

    public void updateEmailEmptySubjectNotification(boolean bl, int n) {
        DSIMessagingServiceConfigurationListener[] dSIMessagingServiceConfigurationListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingServiceConfigurationListenerArray.length; ++i2) {
            try {
                dSIMessagingServiceConfigurationListenerArray[i2].updateEmailEmptySubjectNotification(bl, n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingConfigDefaultListener#updateEmailEmptySubjectNotification]");
            }
        }
    }

    public void updateFolderViewMode(int n, int n2) {
        DSIMessagingServiceConfigurationListener[] dSIMessagingServiceConfigurationListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingServiceConfigurationListenerArray.length; ++i2) {
            try {
                dSIMessagingServiceConfigurationListenerArray[i2].updateFolderViewMode(n, n2);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingConfigDefaultListener#updateFolderViewMode]");
            }
        }
    }

    public void responseSetSmsIndications(int n) {
        this.log.log(100000, "[DsiMessagingConfigDefaultListener#responseSetSmsIndications] Not implemented.");
    }

    public void responseSetEmailIndications(int n) {
        this.log.log(100000, "[DsiMessagingConfigDefaultListener#responseSetEmailIndications] Not implemented.");
    }

    public void responseSetPushSms(int n) {
        this.log.log(100000, "[DsiMessagingConfigDefaultListener#responseSetPushSms] Not implemented.");
    }

    public void updateSmsIndications(boolean bl, int n) {
        DSIMessagingServiceConfigurationListener[] dSIMessagingServiceConfigurationListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingServiceConfigurationListenerArray.length; ++i2) {
            try {
                dSIMessagingServiceConfigurationListenerArray[i2].updateSmsIndications(bl, n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingConfigDefaultListener#updateSmsIndications]");
            }
        }
    }

    public void updateEmailIndications(boolean bl, int n) {
        DSIMessagingServiceConfigurationListener[] dSIMessagingServiceConfigurationListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingServiceConfigurationListenerArray.length; ++i2) {
            try {
                dSIMessagingServiceConfigurationListenerArray[i2].updateEmailIndications(bl, n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingConfigDefaultListener#updateEmailIndications]");
            }
        }
    }

    public void updatePushSms(boolean bl, int n) {
        DSIMessagingServiceConfigurationListener[] dSIMessagingServiceConfigurationListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingServiceConfigurationListenerArray.length; ++i2) {
            try {
                dSIMessagingServiceConfigurationListenerArray[i2].updatePushSms(bl, n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingConfigDefaultListener#updatePushSms]");
            }
        }
    }
}

