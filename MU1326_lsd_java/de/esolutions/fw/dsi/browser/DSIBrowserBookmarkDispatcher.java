/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.browser;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.browser.DSIBrowserBookmarkReply;
import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserBookmarkReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.DSIBrowserBookmarkListener;
import org.dsi.ifc.browser.ImportReport;
import org.dsi.ifc.browser.PathInfo;

public class DSIBrowserBookmarkDispatcher
extends AbstractDispatcher
implements DSIBrowserBookmarkReply {
    private DSIBrowserBookmarkReplyService service = new DSIBrowserBookmarkReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$browser$DSIBrowserBookmarkListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIBrowserBookmarkDispatcher(int n) {
        super(n, (class$org$dsi$ifc$browser$DSIBrowserBookmarkListener == null ? (class$org$dsi$ifc$browser$DSIBrowserBookmarkListener = DSIBrowserBookmarkDispatcher.class$("org.dsi.ifc.browser.DSIBrowserBookmarkListener")) : class$org$dsi$ifc$browser$DSIBrowserBookmarkListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void listBookmarksResult(String string, Bookmark[] bookmarkArray, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserBookmarkListener dSIBrowserBookmarkListener = (DSIBrowserBookmarkListener)objectArray[i2];
                    dSIBrowserBookmarkListener.listBookmarksResult(string, bookmarkArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void bookmarkListInvalid() throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserBookmarkListener dSIBrowserBookmarkListener = (DSIBrowserBookmarkListener)objectArray[i2];
                    dSIBrowserBookmarkListener.bookmarkListInvalid();
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void addBookmarkResult(Bookmark bookmark, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserBookmarkListener dSIBrowserBookmarkListener = (DSIBrowserBookmarkListener)objectArray[i2];
                    dSIBrowserBookmarkListener.addBookmarkResult(bookmark, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void editBookmarkResult(Bookmark bookmark, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserBookmarkListener dSIBrowserBookmarkListener = (DSIBrowserBookmarkListener)objectArray[i2];
                    dSIBrowserBookmarkListener.editBookmarkResult(bookmark, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void deleteBookmarkResult(Bookmark bookmark, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserBookmarkListener dSIBrowserBookmarkListener = (DSIBrowserBookmarkListener)objectArray[i2];
                    dSIBrowserBookmarkListener.deleteBookmarkResult(bookmark, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void createFolderResult(Bookmark bookmark, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserBookmarkListener dSIBrowserBookmarkListener = (DSIBrowserBookmarkListener)objectArray[i2];
                    dSIBrowserBookmarkListener.createFolderResult(bookmark, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void deleteFolderResult(String string, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserBookmarkListener dSIBrowserBookmarkListener = (DSIBrowserBookmarkListener)objectArray[i2];
                    dSIBrowserBookmarkListener.deleteFolderResult(string, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void renameFolderResult(String string, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserBookmarkListener dSIBrowserBookmarkListener = (DSIBrowserBookmarkListener)objectArray[i2];
                    dSIBrowserBookmarkListener.renameFolderResult(string, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void exportBookmarksResult(PathInfo pathInfo, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserBookmarkListener dSIBrowserBookmarkListener = (DSIBrowserBookmarkListener)objectArray[i2];
                    dSIBrowserBookmarkListener.exportBookmarksResult(pathInfo, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateExportBookmarksProgress(PathInfo pathInfo, int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserBookmarkListener dSIBrowserBookmarkListener = (DSIBrowserBookmarkListener)iterator.next();
                    this.confirmNotificationListener(2, dSIBrowserBookmarkListener);
                    dSIBrowserBookmarkListener.updateExportBookmarksProgress(pathInfo, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserBookmarkListener dSIBrowserBookmarkListener = (DSIBrowserBookmarkListener)iterator.next();
                    dSIBrowserBookmarkListener.updateExportBookmarksProgress(pathInfo, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void importBookmarksResult(PathInfo pathInfo, ImportReport importReport, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserBookmarkListener dSIBrowserBookmarkListener = (DSIBrowserBookmarkListener)objectArray[i2];
                    dSIBrowserBookmarkListener.importBookmarksResult(pathInfo, importReport, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateImportBookmarksProgress(PathInfo pathInfo, int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserBookmarkListener dSIBrowserBookmarkListener = (DSIBrowserBookmarkListener)iterator.next();
                    this.confirmNotificationListener(1, dSIBrowserBookmarkListener);
                    dSIBrowserBookmarkListener.updateImportBookmarksProgress(pathInfo, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserBookmarkListener dSIBrowserBookmarkListener = (DSIBrowserBookmarkListener)iterator.next();
                    dSIBrowserBookmarkListener.updateImportBookmarksProgress(pathInfo, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getQuotaInformationResult(int n, int n2, int n3) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserBookmarkListener dSIBrowserBookmarkListener = (DSIBrowserBookmarkListener)objectArray[i2];
                    dSIBrowserBookmarkListener.getQuotaInformationResult(n, n2, n3);
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
                    DSIBrowserBookmarkListener dSIBrowserBookmarkListener = (DSIBrowserBookmarkListener)objectArray[i2];
                    dSIBrowserBookmarkListener.asyncException(n, string, n2);
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
                    DSIBrowserBookmarkListener dSIBrowserBookmarkListener = (DSIBrowserBookmarkListener)objectArray[i2];
                    Method method = dSIBrowserBookmarkListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIBrowserBookmarkDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIBrowserBookmarkDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIBrowserBookmarkListener, new Object[]{string, string2});
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

