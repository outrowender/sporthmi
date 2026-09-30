/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.search.DSISearch;
import de.esolutions.fw.comm.dsi.search.DSISearchC;
import de.esolutions.fw.comm.dsi.search.DSISearchReply;
import de.esolutions.fw.comm.dsi.search.impl.CarFunctionSerializer;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchReplyService;
import de.esolutions.fw.comm.dsi.search.impl.EnvironmentSerializer;
import de.esolutions.fw.comm.dsi.search.impl.NavPositionSerializer;
import de.esolutions.fw.comm.dsi.search.impl.RadioStationSerializer;
import de.esolutions.fw.comm.dsi.search.impl.SearchFilterSerializer;
import de.esolutions.fw.comm.dsi.search.impl.SearchQuerySerializer;
import de.esolutions.fw.comm.dsi.search.impl.SearchResultSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.search.CarFunction;
import org.dsi.ifc.search.Environment;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.RadioStation;
import org.dsi.ifc.search.SearchFilter;
import org.dsi.ifc.search.SearchQuery;
import org.dsi.ifc.search.SearchResult;

public class DSISearchProxy
implements DSISearch,
DSISearchC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.search.DSISearch");
    private Proxy proxy;

    public DSISearchProxy(int n, DSISearchReply dSISearchReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("c469770f-e781-5ef2-b4fe-b3a26ea25678", n, "ccd602ee-e33a-5d8a-a861-5faa95593df6", "dsi.search.DSISearch");
        DSISearchReplyService dSISearchReplyService = new DSISearchReplyService(dSISearchReply);
        this.proxy = new Proxy(serviceInstanceID, dSISearchReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void requestSupportedCountries() throws MethodException {
        this.proxy.remoteCallMethod((short)10, null);
    }

    public void setActiveSearchCountries(String[] stringArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalStringVarArray(stringArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)39, genericSerializable);
    }

    public void search(final SearchQuery searchQuery) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SearchQuerySerializer.putOptionalSearchQuery(iSerializer, searchQuery);
            }
        };
        this.proxy.remoteCallMethod((short)92, iSerializable);
    }

    public void addToHistory(final SearchResult searchResult) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SearchResultSerializer.putOptionalSearchResult(iSerializer, searchResult);
            }
        };
        this.proxy.remoteCallMethod((short)96, iSerializable);
    }

    public void requestSuggestion(final SearchQuery searchQuery) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SearchQuerySerializer.putOptionalSearchQuery(iSerializer, searchQuery);
            }
        };
        this.proxy.remoteCallMethod((short)91, iSerializable);
    }

    public void cancelQuery(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    public void setCurrentPosition(final NavPosition navPosition) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavPositionSerializer.putOptionalNavPosition(iSerializer, navPosition);
            }
        };
        this.proxy.remoteCallMethod((short)42, iSerializable);
    }

    public void setRoutePoints(final NavPosition[] navPositionArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavPositionSerializer.putOptionalNavPositionVarArray(iSerializer, navPositionArray);
            }
        };
        this.proxy.remoteCallMethod((short)43, iSerializable);
    }

    public void setLanguage(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)22, genericSerializable);
    }

    public void setActiveProfile(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    public void setCarFunctionStates(final CarFunction[] carFunctionArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                CarFunctionSerializer.putOptionalCarFunctionVarArray(iSerializer, carFunctionArray);
            }
        };
        this.proxy.remoteCallMethod((short)18, iSerializable);
    }

    public void setRadioStations(final int n, final RadioStation[] radioStationArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                RadioStationSerializer.putOptionalRadioStationVarArray(iSerializer, radioStationArray);
            }
        };
        this.proxy.remoteCallMethod((short)59, iSerializable);
    }

    public void setSearchFilter(final int n, final SearchFilter searchFilter) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                SearchFilterSerializer.putOptionalSearchFilter(iSerializer, searchFilter);
            }
        };
        this.proxy.remoteCallMethod((short)107, iSerializable);
    }

    public void prepareSources(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)35, genericSerializable);
    }

    public void resetToFactorySettings() throws MethodException {
        this.proxy.remoteCallMethod((short)37, null);
    }

    public void removeFromHistory(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)50, genericSerializable);
    }

    public void removeAllFromHistory() throws MethodException {
        this.proxy.remoteCallMethod((short)61, null);
    }

    public void removeAllFromHistoryBySource(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)93, genericSerializable);
    }

    public void resetAutocompletion(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)53, genericSerializable);
    }

    public void createBackupFile(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)63, genericSerializable);
    }

    public void importBackupFile(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)65, genericSerializable);
    }

    public void setEnvironment(final Environment environment) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                EnvironmentSerializer.putOptionalEnvironment(iSerializer, environment);
            }
        };
        this.proxy.remoteCallMethod((short)95, iSerializable);
    }

    public void profileChange(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)98, genericSerializable);
    }

    public void profileCopy(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)101, genericSerializable);
    }

    public void profileReset(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)102, genericSerializable);
    }

    public void profileResetAll() throws MethodException {
        this.proxy.remoteCallMethod((short)104, null);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)25, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)24, null);
    }

    public void clearNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)5, null);
    }

    public void yySet(String string, String string2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)33, genericSerializable);
    }
}

