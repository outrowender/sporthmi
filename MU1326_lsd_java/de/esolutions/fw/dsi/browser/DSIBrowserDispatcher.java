/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.browser;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.browser.DSIBrowserReply;
import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.browser.DSIBrowserListener;
import org.dsi.ifc.browser.HistoryEntry;
import org.dsi.ifc.browser.KeyboardInfo;
import org.dsi.ifc.browser.SelectionEntry;
import org.dsi.ifc.browser.TimePeriod;

public class DSIBrowserDispatcher
extends AbstractDispatcher
implements DSIBrowserReply {
    private DSIBrowserReplyService service = new DSIBrowserReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$browser$DSIBrowserListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIBrowserDispatcher(int n) {
        super(n, (class$org$dsi$ifc$browser$DSIBrowserListener == null ? (class$org$dsi$ifc$browser$DSIBrowserListener = DSIBrowserDispatcher.class$("org.dsi.ifc.browser.DSIBrowserListener")) : class$org$dsi$ifc$browser$DSIBrowserListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void updateBrowserState(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    this.confirmNotificationListener(1, dSIBrowserListener);
                    dSIBrowserListener.updateBrowserState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    dSIBrowserListener.updateBrowserState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updatePageTitle(String string, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    this.confirmNotificationListener(2, dSIBrowserListener);
                    dSIBrowserListener.updatePageTitle(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    dSIBrowserListener.updatePageTitle(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateActiveUrl(String string, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    this.confirmNotificationListener(3, dSIBrowserListener);
                    dSIBrowserListener.updateActiveUrl(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    dSIBrowserListener.updateActiveUrl(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateZoomFactor(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    this.confirmNotificationListener(4, dSIBrowserListener);
                    dSIBrowserListener.updateZoomFactor(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    dSIBrowserListener.updateZoomFactor(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateVirtualKeyboardStatus(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    this.confirmNotificationListener(16, dSIBrowserListener);
                    dSIBrowserListener.updateVirtualKeyboardStatus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    dSIBrowserListener.updateVirtualKeyboardStatus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateEncryption(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    this.confirmNotificationListener(15, dSIBrowserListener);
                    dSIBrowserListener.updateEncryption(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    dSIBrowserListener.updateEncryption(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateHasFocus(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    this.confirmNotificationListener(14, dSIBrowserListener);
                    dSIBrowserListener.updateHasFocus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    dSIBrowserListener.updateHasFocus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateButtonState(int n, int n2, int n3) throws MethodException {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    this.confirmNotificationListener(10, dSIBrowserListener);
                    dSIBrowserListener.updateButtonState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    dSIBrowserListener.updateButtonState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateProgress(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    this.confirmNotificationListener(7, dSIBrowserListener);
                    dSIBrowserListener.updateProgress(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    dSIBrowserListener.updateProgress(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateScrollbarX(int n, int n2, int n3, int n4) throws MethodException {
        if ((n4 & 0x80) == 128) {
            n4 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    this.confirmNotificationListener(12, dSIBrowserListener);
                    dSIBrowserListener.updateScrollbarX(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    dSIBrowserListener.updateScrollbarX(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateScrollbarY(int n, int n2, int n3, int n4) throws MethodException {
        if ((n4 & 0x80) == 128) {
            n4 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    this.confirmNotificationListener(13, dSIBrowserListener);
                    dSIBrowserListener.updateScrollbarY(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    dSIBrowserListener.updateScrollbarY(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getPreferenceResult(int n, int n2, String string) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)objectArray[i2];
                    dSIBrowserListener.getPreferenceResult(n, n2, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void resumeBrowserResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)objectArray[i2];
                    dSIBrowserListener.resumeBrowserResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void indicateEfiUrl(String string) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)objectArray[i2];
                    dSIBrowserListener.indicateEfiUrl(string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void indicateUnknownMimeType(String string, String string2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)objectArray[i2];
                    dSIBrowserListener.indicateUnknownMimeType(string, string2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void indicateDownloadUrl(String string) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)objectArray[i2];
                    dSIBrowserListener.indicateDownloadUrl(string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void indicatePopup(String string) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)objectArray[i2];
                    dSIBrowserListener.indicatePopup(string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void indicateDownloadProgress(String string, String string2, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)objectArray[i2];
                    dSIBrowserListener.indicateDownloadProgress(string, string2, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void javascriptAlert(String string) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)objectArray[i2];
                    dSIBrowserListener.javascriptAlert(string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void javascriptConfirm(String string) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)objectArray[i2];
                    dSIBrowserListener.javascriptConfirm(string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void javascriptPrompt(String string, String string2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)objectArray[i2];
                    dSIBrowserListener.javascriptPrompt(string, string2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateSelectionListContent(SelectionEntry[] selectionEntryArray, boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    this.confirmNotificationListener(17, dSIBrowserListener);
                    dSIBrowserListener.updateSelectionListContent(selectionEntryArray, bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    dSIBrowserListener.updateSelectionListContent(selectionEntryArray, bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void exportBrowserDataResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)objectArray[i2];
                    dSIBrowserListener.exportBrowserDataResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void importBrowserDataResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)objectArray[i2];
                    dSIBrowserListener.importBrowserDataResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getHistoryResult(TimePeriod timePeriod, HistoryEntry[] historyEntryArray, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)objectArray[i2];
                    dSIBrowserListener.getHistoryResult(timePeriod, historyEntryArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateKeyboardDisplay(boolean bl, KeyboardInfo keyboardInfo, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    this.confirmNotificationListener(18, dSIBrowserListener);
                    dSIBrowserListener.updateKeyboardDisplay(bl, keyboardInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)iterator.next();
                    dSIBrowserListener.updateKeyboardDisplay(bl, keyboardInfo, n);
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
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)objectArray[i2];
                    dSIBrowserListener.asyncException(n, string, n2);
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
                    DSIBrowserListener dSIBrowserListener = (DSIBrowserListener)objectArray[i2];
                    Method method = dSIBrowserListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIBrowserDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIBrowserDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIBrowserListener, new Object[]{string, string2});
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

