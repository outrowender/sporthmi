/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.organizer;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbVCardExchangeReply;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbVCardExchangeReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DSIAdbVCardExchangeListener;
import org.dsi.ifc.organizer.DownloadInfo;

public class DSIAdbVCardExchangeDispatcher
extends AbstractDispatcher
implements DSIAdbVCardExchangeReply {
    private DSIAdbVCardExchangeReplyService service = new DSIAdbVCardExchangeReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIAdbVCardExchangeDispatcher(int n) {
        super(n, (class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener == null ? (class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener = DSIAdbVCardExchangeDispatcher.class$("org.dsi.ifc.organizer.DSIAdbVCardExchangeListener")) : class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void updateExportCount(DownloadInfo downloadInfo, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIAdbVCardExchangeListener dSIAdbVCardExchangeListener = (DSIAdbVCardExchangeListener)iterator.next();
                    this.confirmNotificationListener(4, dSIAdbVCardExchangeListener);
                    dSIAdbVCardExchangeListener.updateExportCount(downloadInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIAdbVCardExchangeListener dSIAdbVCardExchangeListener = (DSIAdbVCardExchangeListener)iterator.next();
                    dSIAdbVCardExchangeListener.updateExportCount(downloadInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateImportCount(DownloadInfo downloadInfo, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIAdbVCardExchangeListener dSIAdbVCardExchangeListener = (DSIAdbVCardExchangeListener)iterator.next();
                    this.confirmNotificationListener(5, dSIAdbVCardExchangeListener);
                    dSIAdbVCardExchangeListener.updateImportCount(downloadInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIAdbVCardExchangeListener dSIAdbVCardExchangeListener = (DSIAdbVCardExchangeListener)iterator.next();
                    dSIAdbVCardExchangeListener.updateImportCount(downloadInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void importVCardResult(int n, int n2, int n3, int n4) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbVCardExchangeListener dSIAdbVCardExchangeListener = (DSIAdbVCardExchangeListener)objectArray[i2];
                    dSIAdbVCardExchangeListener.importVCardResult(n, n2, n3, n4);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void exportVCardResult(int n, int n2, int n3, int n4) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbVCardExchangeListener dSIAdbVCardExchangeListener = (DSIAdbVCardExchangeListener)objectArray[i2];
                    dSIAdbVCardExchangeListener.exportVCardResult(n, n2, n3, n4);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void exportSpellerVCardResult(int n, int n2, int n3, int n4, int n5) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbVCardExchangeListener dSIAdbVCardExchangeListener = (DSIAdbVCardExchangeListener)objectArray[i2];
                    dSIAdbVCardExchangeListener.exportSpellerVCardResult(n, n2, n3, n4, n5);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void createVCardResult(int n, long[] lArray, int n2, String string) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbVCardExchangeListener dSIAdbVCardExchangeListener = (DSIAdbVCardExchangeListener)objectArray[i2];
                    dSIAdbVCardExchangeListener.createVCardResult(n, lArray, n2, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void parseVCardResult(int n, AdbEntry[] adbEntryArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbVCardExchangeListener dSIAdbVCardExchangeListener = (DSIAdbVCardExchangeListener)objectArray[i2];
                    dSIAdbVCardExchangeListener.parseVCardResult(n, adbEntryArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseAbort(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbVCardExchangeListener dSIAdbVCardExchangeListener = (DSIAdbVCardExchangeListener)objectArray[i2];
                    dSIAdbVCardExchangeListener.responseAbort(n);
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
                    DSIAdbVCardExchangeListener dSIAdbVCardExchangeListener = (DSIAdbVCardExchangeListener)objectArray[i2];
                    dSIAdbVCardExchangeListener.asyncException(n, string, n2);
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
                    DSIAdbVCardExchangeListener dSIAdbVCardExchangeListener = (DSIAdbVCardExchangeListener)objectArray[i2];
                    Method method = dSIAdbVCardExchangeListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIAdbVCardExchangeDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIAdbVCardExchangeDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIAdbVCardExchangeListener, new Object[]{string, string2});
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

