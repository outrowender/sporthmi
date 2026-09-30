/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.picturestore;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.picturestore.DSIPictureViewerReply;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureViewerReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureViewerListener;
import org.dsi.ifc.picturestore.PictureEntryInfo;

public class DSIPictureViewerDispatcher
extends AbstractDispatcher
implements DSIPictureViewerReply {
    private DSIPictureViewerReplyService service = new DSIPictureViewerReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$picturestore$DSIPictureViewerListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIPictureViewerDispatcher(int n) {
        super(n, (class$org$dsi$ifc$picturestore$DSIPictureViewerListener == null ? (class$org$dsi$ifc$picturestore$DSIPictureViewerListener = DSIPictureViewerDispatcher.class$("org.dsi.ifc.picturestore.DSIPictureViewerListener")) : class$org$dsi$ifc$picturestore$DSIPictureViewerListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void updateViewerState(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)iterator.next();
                    this.confirmNotificationListener(1, dSIPictureViewerListener);
                    dSIPictureViewerListener.updateViewerState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)iterator.next();
                    dSIPictureViewerListener.updateViewerState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateScrollMode(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)iterator.next();
                    this.confirmNotificationListener(2, dSIPictureViewerListener);
                    dSIPictureViewerListener.updateScrollMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)iterator.next();
                    dSIPictureViewerListener.updateScrollMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateListPosition(long l, int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)iterator.next();
                    this.confirmNotificationListener(3, dSIPictureViewerListener);
                    dSIPictureViewerListener.updateListPosition(l, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)iterator.next();
                    dSIPictureViewerListener.updateListPosition(l, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateNumEntries(long l, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)iterator.next();
                    this.confirmNotificationListener(4, dSIPictureViewerListener);
                    dSIPictureViewerListener.updateNumEntries(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)iterator.next();
                    dSIPictureViewerListener.updateNumEntries(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateNumSelectedEntries(long l, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)iterator.next();
                    this.confirmNotificationListener(5, dSIPictureViewerListener);
                    dSIPictureViewerListener.updateNumSelectedEntries(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)iterator.next();
                    dSIPictureViewerListener.updateNumSelectedEntries(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getPictureInfoResult(long l, PictureEntryInfo pictureEntryInfo, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)objectArray[i2];
                    dSIPictureViewerListener.getPictureInfoResult(l, pictureEntryInfo, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void selectionResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)objectArray[i2];
                    dSIPictureViewerListener.selectionResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void createFilterSetResult(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)objectArray[i2];
                    dSIPictureViewerListener.createFilterSetResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void deleteFilterSetResult(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)objectArray[i2];
                    dSIPictureViewerListener.deleteFilterSetResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void changedFilterSetResult(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)objectArray[i2];
                    dSIPictureViewerListener.changedFilterSetResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getAvailableYearsResult(int[] nArray, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)objectArray[i2];
                    dSIPictureViewerListener.getAvailableYearsResult(nArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getAvailableMonthsResult(int[] nArray, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)objectArray[i2];
                    dSIPictureViewerListener.getAvailableMonthsResult(nArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void listForContextWithFilterResult(int n, ResourceLocator[] resourceLocatorArray, int n2, int n3) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)objectArray[i2];
                    dSIPictureViewerListener.listForContextWithFilterResult(n, resourceLocatorArray, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void deletePicturesWithFilterSetResult(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)objectArray[i2];
                    dSIPictureViewerListener.deletePicturesWithFilterSetResult(n, n2);
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
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)objectArray[i2];
                    dSIPictureViewerListener.asyncException(n, string, n2);
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
                    DSIPictureViewerListener dSIPictureViewerListener = (DSIPictureViewerListener)objectArray[i2];
                    Method method = dSIPictureViewerListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIPictureViewerDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIPictureViewerDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIPictureViewerListener, new Object[]{string, string2});
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

