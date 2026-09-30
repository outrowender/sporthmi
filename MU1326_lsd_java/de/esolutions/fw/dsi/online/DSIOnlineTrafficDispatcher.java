/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.online;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIOnlineTrafficReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineTrafficReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.online.DSIOnlineTrafficListener;
import org.dsi.ifc.online.FCDPosition;
import org.dsi.ifc.online.LocatablePosition;

public class DSIOnlineTrafficDispatcher
extends AbstractDispatcher
implements DSIOnlineTrafficReply {
    private DSIOnlineTrafficReplyService service = new DSIOnlineTrafficReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineTrafficListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIOnlineTrafficDispatcher(int n) {
        super(n, (class$org$dsi$ifc$online$DSIOnlineTrafficListener == null ? (class$org$dsi$ifc$online$DSIOnlineTrafficListener = DSIOnlineTrafficDispatcher.class$("org.dsi.ifc.online.DSIOnlineTrafficListener")) : class$org$dsi$ifc$online$DSIOnlineTrafficListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void updateConsumerReady(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineTrafficListener dSIOnlineTrafficListener = (DSIOnlineTrafficListener)iterator.next();
                    this.confirmNotificationListener(1, dSIOnlineTrafficListener);
                    dSIOnlineTrafficListener.updateConsumerReady(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineTrafficListener dSIOnlineTrafficListener = (DSIOnlineTrafficListener)iterator.next();
                    dSIOnlineTrafficListener.updateConsumerReady(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateWantOnlineTrafficData(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineTrafficListener dSIOnlineTrafficListener = (DSIOnlineTrafficListener)iterator.next();
                    this.confirmNotificationListener(2, dSIOnlineTrafficListener);
                    dSIOnlineTrafficListener.updateWantOnlineTrafficData(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineTrafficListener dSIOnlineTrafficListener = (DSIOnlineTrafficListener)iterator.next();
                    dSIOnlineTrafficListener.updateWantOnlineTrafficData(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getNewDataResult(int n, LocatablePosition[] locatablePositionArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineTrafficListener dSIOnlineTrafficListener = (DSIOnlineTrafficListener)objectArray[i2];
                    dSIOnlineTrafficListener.getNewDataResult(n, locatablePositionArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setNewDataResult(String string, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineTrafficListener dSIOnlineTrafficListener = (DSIOnlineTrafficListener)objectArray[i2];
                    dSIOnlineTrafficListener.setNewDataResult(string, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getNewSession() throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineTrafficListener dSIOnlineTrafficListener = (DSIOnlineTrafficListener)objectArray[i2];
                    dSIOnlineTrafficListener.getNewSession();
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setTimeoutForFallbackResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineTrafficListener dSIOnlineTrafficListener = (DSIOnlineTrafficListener)objectArray[i2];
                    dSIOnlineTrafficListener.setTimeoutForFallbackResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getNewFCDInformationResult(FCDPosition fCDPosition) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineTrafficListener dSIOnlineTrafficListener = (DSIOnlineTrafficListener)objectArray[i2];
                    dSIOnlineTrafficListener.getNewFCDInformationResult(fCDPosition);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getInventoryResult(String string) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineTrafficListener dSIOnlineTrafficListener = (DSIOnlineTrafficListener)objectArray[i2];
                    dSIOnlineTrafficListener.getInventoryResult(string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getDownloadFileResult(String string) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineTrafficListener dSIOnlineTrafficListener = (DSIOnlineTrafficListener)objectArray[i2];
                    dSIOnlineTrafficListener.getDownloadFileResult(string);
                    continue;
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
                    DSIOnlineTrafficListener dSIOnlineTrafficListener = (DSIOnlineTrafficListener)objectArray[i2];
                    dSIOnlineTrafficListener.asyncException(n, string, n2);
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
                    DSIOnlineTrafficListener dSIOnlineTrafficListener = (DSIOnlineTrafficListener)objectArray[i2];
                    Method method = dSIOnlineTrafficListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIOnlineTrafficDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIOnlineTrafficDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIOnlineTrafficListener, new Object[]{string, string2});
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

