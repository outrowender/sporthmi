/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.search;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.search.DSISearchReply;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.search.ConflictMatch;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.DSISearchListener;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Suggestion;

public class DSISearchDispatcher
extends AbstractDispatcher
implements DSISearchReply {
    private DSISearchReplyService service = new DSISearchReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSISearchDispatcher(int n) {
        super(n, (class$org$dsi$ifc$search$DSISearchListener == null ? (class$org$dsi$ifc$search$DSISearchListener = DSISearchDispatcher.class$("org.dsi.ifc.search.DSISearchListener")) : class$org$dsi$ifc$search$DSISearchListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void requestSupportedCountriesResult(int n, Country[] countryArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.requestSupportedCountriesResult(n, countryArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void searchResult(int n, SearchResult searchResult) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.searchResult(n, searchResult);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void addToHistoryResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.addToHistoryResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void requestSuggestionResult(int n, int n2, Suggestion[] suggestionArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.requestSuggestionResult(n, n2, suggestionArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void cancelQueryResult(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.cancelQueryResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setCurrentPositionResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.setCurrentPositionResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setRoutePointsResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.setRoutePointsResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setLanguageResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.setLanguageResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateSearchIsActive(int n, boolean bl, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)iterator.next();
                    this.confirmNotificationListener(1, dSISearchListener);
                    dSISearchListener.updateSearchIsActive(n, bl, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)iterator.next();
                    dSISearchListener.updateSearchIsActive(n, bl, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updatePotentialConflict(int n, boolean bl, ConflictMatch conflictMatch, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)iterator.next();
                    this.confirmNotificationListener(2, dSISearchListener);
                    dSISearchListener.updatePotentialConflict(n, bl, conflictMatch, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)iterator.next();
                    dSISearchListener.updatePotentialConflict(n, bl, conflictMatch, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setCarFunctionStatesResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.setCarFunctionStatesResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setRadioStationsResult(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.setRadioStationsResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setSearchFilterResult(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.setSearchFilterResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setActiveProfileResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.setActiveProfileResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setActiveSearchCountriesResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.setActiveSearchCountriesResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void resetToFactorySettingsResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.resetToFactorySettingsResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void invalidateData(int[] nArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.invalidateData(nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void prepareSourcesResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.prepareSourcesResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void removeFromHistoryResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.removeFromHistoryResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void removeAllFromHistoryResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.removeAllFromHistoryResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void removeAllFromHistoryBySourceResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.removeAllFromHistoryBySourceResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void resetAutocompletionResult(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.resetAutocompletionResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void sourceDataAvailabilityChanged(int n, boolean bl) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.sourceDataAvailabilityChanged(n, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void createBackupFileResult(int n, String string) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.createBackupFileResult(n, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void importBackupFileResult(int n, String string) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.importBackupFileResult(n, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setEnvironmentResult(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.setEnvironmentResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateProfileState(int n, int n2, int n3) throws MethodException {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)iterator.next();
                    this.confirmNotificationListener(3, dSISearchListener);
                    dSISearchListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)iterator.next();
                    dSISearchListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void profileChanged(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.profileChanged(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void profileCopied(int n, int n2, int n3) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.profileCopied(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void profileReset(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.profileReset(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void profileResetAll(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.profileResetAll(n);
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
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    dSISearchListener.asyncException(n, string, n2);
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
                    DSISearchListener dSISearchListener = (DSISearchListener)objectArray[i2];
                    Method method = dSISearchListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSISearchDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSISearchDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSISearchListener, new Object[]{string, string2});
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

