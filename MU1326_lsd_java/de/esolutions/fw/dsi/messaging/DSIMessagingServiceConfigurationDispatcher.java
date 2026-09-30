/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.messaging;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.messaging.DSIMessagingServiceConfigurationReply;
import de.esolutions.fw.comm.dsi.messaging.impl.DSIMessagingServiceConfigurationReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.messaging.DSIMessagingServiceConfigurationListener;

public class DSIMessagingServiceConfigurationDispatcher
extends AbstractDispatcher
implements DSIMessagingServiceConfigurationReply {
    private DSIMessagingServiceConfigurationReplyService service = new DSIMessagingServiceConfigurationReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMessagingServiceConfigurationDispatcher(int n) {
        super(n, (class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener == null ? (class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener = DSIMessagingServiceConfigurationDispatcher.class$("org.dsi.ifc.messaging.DSIMessagingServiceConfigurationListener")) : class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void setSMSCNumberResponse(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)objectArray[i2];
                    dSIMessagingServiceConfigurationListener.setSMSCNumberResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void activateStoreSmsOnSentResponse(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)objectArray[i2];
                    dSIMessagingServiceConfigurationListener.activateStoreSmsOnSentResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setShortMessageValidityPeriodResponse(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)objectArray[i2];
                    dSIMessagingServiceConfigurationListener.setShortMessageValidityPeriodResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void activateSMSDeliveryReportResponse(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)objectArray[i2];
                    dSIMessagingServiceConfigurationListener.activateSMSDeliveryReportResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateSMSCNumber(String string, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMessagingServiceConfigurationListener);
                    dSIMessagingServiceConfigurationListener.updateSMSCNumber(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    dSIMessagingServiceConfigurationListener.updateSMSCNumber(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setPhoneSystemRingingVolumeResponse(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)objectArray[i2];
                    dSIMessagingServiceConfigurationListener.setPhoneSystemRingingVolumeResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setPhoneSystemRingingTypeResponse(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)objectArray[i2];
                    dSIMessagingServiceConfigurationListener.setPhoneSystemRingingTypeResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void activateEmailIncludeOldMailInReplyResponse(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)objectArray[i2];
                    dSIMessagingServiceConfigurationListener.activateEmailIncludeOldMailInReplyResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void activateEmailEmptySubjectNotificationResponse(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)objectArray[i2];
                    dSIMessagingServiceConfigurationListener.activateEmailEmptySubjectNotificationResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void changeFolderViewModeResponse(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)objectArray[i2];
                    dSIMessagingServiceConfigurationListener.changeFolderViewModeResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void restoreFactorySettingsResponse(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)objectArray[i2];
                    dSIMessagingServiceConfigurationListener.restoreFactorySettingsResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseSetSmsIndications(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)objectArray[i2];
                    dSIMessagingServiceConfigurationListener.responseSetSmsIndications(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseSetEmailIndications(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)objectArray[i2];
                    dSIMessagingServiceConfigurationListener.responseSetEmailIndications(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseSetPushSms(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)objectArray[i2];
                    dSIMessagingServiceConfigurationListener.responseSetPushSms(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateSmsDeliveryReport(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    this.confirmNotificationListener(2, dSIMessagingServiceConfigurationListener);
                    dSIMessagingServiceConfigurationListener.updateSmsDeliveryReport(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    dSIMessagingServiceConfigurationListener.updateSmsDeliveryReport(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateStoreSmsOnSent(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    this.confirmNotificationListener(3, dSIMessagingServiceConfigurationListener);
                    dSIMessagingServiceConfigurationListener.updateStoreSmsOnSent(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    dSIMessagingServiceConfigurationListener.updateStoreSmsOnSent(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateShortMessageValidityPeriod(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    this.confirmNotificationListener(4, dSIMessagingServiceConfigurationListener);
                    dSIMessagingServiceConfigurationListener.updateShortMessageValidityPeriod(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    dSIMessagingServiceConfigurationListener.updateShortMessageValidityPeriod(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updatePhoneSystemRingingVolume(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    this.confirmNotificationListener(5, dSIMessagingServiceConfigurationListener);
                    dSIMessagingServiceConfigurationListener.updatePhoneSystemRingingVolume(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    dSIMessagingServiceConfigurationListener.updatePhoneSystemRingingVolume(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updatePhoneSystemRingingType(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    this.confirmNotificationListener(6, dSIMessagingServiceConfigurationListener);
                    dSIMessagingServiceConfigurationListener.updatePhoneSystemRingingType(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    dSIMessagingServiceConfigurationListener.updatePhoneSystemRingingType(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateEmailIncludeOldMailInReply(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    this.confirmNotificationListener(7, dSIMessagingServiceConfigurationListener);
                    dSIMessagingServiceConfigurationListener.updateEmailIncludeOldMailInReply(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    dSIMessagingServiceConfigurationListener.updateEmailIncludeOldMailInReply(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateEmailEmptySubjectNotification(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    this.confirmNotificationListener(8, dSIMessagingServiceConfigurationListener);
                    dSIMessagingServiceConfigurationListener.updateEmailEmptySubjectNotification(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    dSIMessagingServiceConfigurationListener.updateEmailEmptySubjectNotification(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateFolderViewMode(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    this.confirmNotificationListener(9, dSIMessagingServiceConfigurationListener);
                    dSIMessagingServiceConfigurationListener.updateFolderViewMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    dSIMessagingServiceConfigurationListener.updateFolderViewMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAccountPreferences(int n, String string, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    this.confirmNotificationListener(10, dSIMessagingServiceConfigurationListener);
                    dSIMessagingServiceConfigurationListener.updateAccountPreferences(n, string, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    dSIMessagingServiceConfigurationListener.updateAccountPreferences(n, string, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateSmsIndications(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    this.confirmNotificationListener(11, dSIMessagingServiceConfigurationListener);
                    dSIMessagingServiceConfigurationListener.updateSmsIndications(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    dSIMessagingServiceConfigurationListener.updateSmsIndications(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateEmailIndications(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    this.confirmNotificationListener(12, dSIMessagingServiceConfigurationListener);
                    dSIMessagingServiceConfigurationListener.updateEmailIndications(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    dSIMessagingServiceConfigurationListener.updateEmailIndications(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updatePushSms(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    this.confirmNotificationListener(13, dSIMessagingServiceConfigurationListener);
                    dSIMessagingServiceConfigurationListener.updatePushSms(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)iterator.next();
                    dSIMessagingServiceConfigurationListener.updatePushSms(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void asyncException(int n, String string, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)objectArray[i2];
                    dSIMessagingServiceConfigurationListener.asyncException(n, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void yyIndication(String string, String string2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)objectArray[i2];
                    Method method = dSIMessagingServiceConfigurationListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMessagingServiceConfigurationDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMessagingServiceConfigurationDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMessagingServiceConfigurationListener, new Object[]{string, string2});
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

