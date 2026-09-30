/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.organizer;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbUserProfileReply;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbUserProfileReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.organizer.DSIAdbUserProfileListener;
import org.dsi.ifc.organizer.DownloadInfo;
import org.dsi.ifc.organizer.EntryMeter;
import org.dsi.ifc.organizer.ProfileInfo;

public class DSIAdbUserProfileDispatcher
extends AbstractDispatcher
implements DSIAdbUserProfileReply {
    private DSIAdbUserProfileReplyService service = new DSIAdbUserProfileReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfileListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIAdbUserProfileDispatcher(int n) {
        super(n, (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = DSIAdbUserProfileDispatcher.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void updateProfileInfo(ProfileInfo[] profileInfoArray, int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)iterator.next();
                    this.confirmNotificationListener(2, dSIAdbUserProfileListener);
                    dSIAdbUserProfileListener.updateProfileInfo(profileInfoArray, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)iterator.next();
                    dSIAdbUserProfileListener.updateProfileInfo(profileInfoArray, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateDeviceConnected(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)iterator.next();
                    this.confirmNotificationListener(3, dSIAdbUserProfileListener);
                    dSIAdbUserProfileListener.updateDeviceConnected(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)iterator.next();
                    dSIAdbUserProfileListener.updateDeviceConnected(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateDownloadCountSim(DownloadInfo downloadInfo, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)iterator.next();
                    this.confirmNotificationListener(5, dSIAdbUserProfileListener);
                    dSIAdbUserProfileListener.updateDownloadCountSim(downloadInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)iterator.next();
                    dSIAdbUserProfileListener.updateDownloadCountSim(downloadInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateDownloadCountMe(DownloadInfo downloadInfo, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)iterator.next();
                    this.confirmNotificationListener(6, dSIAdbUserProfileListener);
                    dSIAdbUserProfileListener.updateDownloadCountMe(downloadInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)iterator.next();
                    dSIAdbUserProfileListener.updateDownloadCountMe(downloadInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateDownloadCountOpp(DownloadInfo downloadInfo, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)iterator.next();
                    this.confirmNotificationListener(7, dSIAdbUserProfileListener);
                    dSIAdbUserProfileListener.updateDownloadCountOpp(downloadInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)iterator.next();
                    dSIAdbUserProfileListener.updateDownloadCountOpp(downloadInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateDownloadState(int n, int n2, int n3) throws MethodException {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)iterator.next();
                    this.confirmNotificationListener(8, dSIAdbUserProfileListener);
                    dSIAdbUserProfileListener.updateDownloadState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)iterator.next();
                    dSIAdbUserProfileListener.updateDownloadState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void newDeviceConnected(String string) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)objectArray[i2];
                    dSIAdbUserProfileListener.newDeviceConnected(string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void downloadToProfileResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)objectArray[i2];
                    dSIAdbUserProfileListener.downloadToProfileResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void restartDownloadResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)objectArray[i2];
                    dSIAdbUserProfileListener.restartDownloadResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void profileDeleted(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)objectArray[i2];
                    dSIAdbUserProfileListener.profileDeleted(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setProfileNameResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)objectArray[i2];
                    dSIAdbUserProfileListener.setProfileNameResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void deleteProfilesResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)objectArray[i2];
                    dSIAdbUserProfileListener.deleteProfilesResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void commonEntryCountResult(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)objectArray[i2];
                    dSIAdbUserProfileListener.commonEntryCountResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void entryMeterResult(int n, EntryMeter[] entryMeterArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)objectArray[i2];
                    dSIAdbUserProfileListener.entryMeterResult(n, entryMeterArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setPairingCodeResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)objectArray[i2];
                    dSIAdbUserProfileListener.setPairingCodeResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setHomeIdResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)objectArray[i2];
                    dSIAdbUserProfileListener.setHomeIdResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateDownloadState2ndPhone(int n, int n2, int n3) throws MethodException {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)iterator.next();
                    this.confirmNotificationListener(9, dSIAdbUserProfileListener);
                    dSIAdbUserProfileListener.updateDownloadState2ndPhone(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)iterator.next();
                    dSIAdbUserProfileListener.updateDownloadState2ndPhone(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setSOSButtonResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)objectArray[i2];
                    dSIAdbUserProfileListener.setSOSButtonResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateSOSButton(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)iterator.next();
                    this.confirmNotificationListener(10, dSIAdbUserProfileListener);
                    dSIAdbUserProfileListener.updateSOSButton(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)iterator.next();
                    dSIAdbUserProfileListener.updateSOSButton(bl, n);
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
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)objectArray[i2];
                    dSIAdbUserProfileListener.asyncException(n, string, n2);
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
                    DSIAdbUserProfileListener dSIAdbUserProfileListener = (DSIAdbUserProfileListener)objectArray[i2];
                    Method method = dSIAdbUserProfileListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIAdbUserProfileDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIAdbUserProfileDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIAdbUserProfileListener, new Object[]{string, string2});
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

