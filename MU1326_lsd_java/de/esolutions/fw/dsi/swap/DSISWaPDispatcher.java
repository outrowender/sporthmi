/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.swap;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.swap.DSISWaPReply;
import de.esolutions.fw.comm.dsi.swap.impl.DSISWaPReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.swap.ConfigInfo;
import org.dsi.ifc.swap.DSISWaPListener;
import org.dsi.ifc.swap.SFscDetails;
import org.dsi.ifc.swap.SFscHistory;
import org.dsi.ifc.swap.SFscImportStatus;
import org.dsi.ifc.swap.SFscStatus;

public class DSISWaPDispatcher
extends AbstractDispatcher
implements DSISWaPReply {
    private DSISWaPReplyService service = new DSISWaPReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$swap$DSISWaPListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSISWaPDispatcher(int n) {
        super(n, (class$org$dsi$ifc$swap$DSISWaPListener == null ? (class$org$dsi$ifc$swap$DSISWaPListener = DSISWaPDispatcher.class$("org.dsi.ifc.swap.DSISWaPListener")) : class$org$dsi$ifc$swap$DSISWaPListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void updateSoftwareEnabling(int[] nArray, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)iterator.next();
                    this.confirmNotificationListener(1, dSISWaPListener);
                    dSISWaPListener.updateSoftwareEnabling(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)iterator.next();
                    dSISWaPListener.updateSoftwareEnabling(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateIllegalFSCs(int[] nArray, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)iterator.next();
                    this.confirmNotificationListener(2, dSISWaPListener);
                    dSISWaPListener.updateIllegalFSCs(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)iterator.next();
                    dSISWaPListener.updateIllegalFSCs(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAreFSCsSigned(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)iterator.next();
                    this.confirmNotificationListener(3, dSISWaPListener);
                    dSISWaPListener.updateAreFSCsSigned(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)iterator.next();
                    dSISWaPListener.updateAreFSCsSigned(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateLimitedLifetime(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)iterator.next();
                    this.confirmNotificationListener(4, dSISWaPListener);
                    dSISWaPListener.updateLimitedLifetime(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)iterator.next();
                    dSISWaPListener.updateLimitedLifetime(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateConfigCheck(ConfigInfo configInfo, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)iterator.next();
                    this.confirmNotificationListener(5, dSISWaPListener);
                    dSISWaPListener.updateConfigCheck(configInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)iterator.next();
                    dSISWaPListener.updateConfigCheck(configInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateConfigPrepare(String string, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)iterator.next();
                    this.confirmNotificationListener(6, dSISWaPListener);
                    dSISWaPListener.updateConfigPrepare(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)iterator.next();
                    dSISWaPListener.updateConfigPrepare(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateConfigFinalize(ConfigInfo configInfo, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)iterator.next();
                    this.confirmNotificationListener(7, dSISWaPListener);
                    dSISWaPListener.updateConfigFinalize(configInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)iterator.next();
                    dSISWaPListener.updateConfigFinalize(configInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateFscList(SFscStatus[] sFscStatusArray, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)iterator.next();
                    this.confirmNotificationListener(8, dSISWaPListener);
                    dSISWaPListener.updateFscList(sFscStatusArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)iterator.next();
                    dSISWaPListener.updateFscList(sFscStatusArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void encryptFile(String string, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)objectArray[i2];
                    dSISWaPListener.encryptFile(string, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void checkSignature(boolean bl, String string) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)objectArray[i2];
                    dSISWaPListener.checkSignature(bl, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getPublicKey(short[] sArray, boolean bl) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)objectArray[i2];
                    dSISWaPListener.getPublicKey(sArray, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void checkSingleFsc(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)objectArray[i2];
                    dSISWaPListener.checkSingleFsc(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void decryptFile(String string, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)objectArray[i2];
                    dSISWaPListener.decryptFile(string, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getFscDetail(SFscDetails sFscDetails) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)objectArray[i2];
                    dSISWaPListener.getFscDetail(sFscDetails);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void importFSCs(int n, SFscImportStatus sFscImportStatus) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)objectArray[i2];
                    dSISWaPListener.importFSCs(n, sFscImportStatus);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void importFSCsList(int n, SFscImportStatus[] sFscImportStatusArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)objectArray[i2];
                    dSISWaPListener.importFSCsList(n, sFscImportStatusArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void exportCCD(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)objectArray[i2];
                    dSISWaPListener.exportCCD(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getHistory(SFscHistory sFscHistory) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)objectArray[i2];
                    dSISWaPListener.getHistory(sFscHistory);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getHistoryList(SFscHistory[] sFscHistoryArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)objectArray[i2];
                    dSISWaPListener.getHistoryList(sFscHistoryArray);
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
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)objectArray[i2];
                    dSISWaPListener.asyncException(n, string, n2);
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
                    DSISWaPListener dSISWaPListener = (DSISWaPListener)objectArray[i2];
                    Method method = dSISWaPListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSISWaPDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSISWaPDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSISWaPListener, new Object[]{string, string2});
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

