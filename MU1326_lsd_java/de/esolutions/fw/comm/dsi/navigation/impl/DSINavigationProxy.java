/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.comm.dsi.global.impl.NavSegmentIDSerializer;
import de.esolutions.fw.comm.dsi.navigation.DSINavigation;
import de.esolutions.fw.comm.dsi.navigation.DSINavigationC;
import de.esolutions.fw.comm.dsi.navigation.DSINavigationReply;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationReplyService;
import de.esolutions.fw.comm.dsi.navigation.impl.LIExtDataSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.LISpellerDataSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.NavLastDestSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.NavPoiInfoConfigurationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.RouteOptionsSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.RouteSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.TryBestMatchDataSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.TryMatchLocationDataSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.NavLastDest;
import org.dsi.ifc.navigation.NavPoiInfoConfiguration;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.navigation.TryMatchLocationData;

public class DSINavigationProxy
implements DSINavigation,
DSINavigationC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.navigation.DSINavigation");
    private Proxy proxy;

    public DSINavigationProxy(int n, DSINavigationReply dSINavigationReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("fe4268ba-8993-5832-ab71-812fc59e1c31", n, "b38cc32c-de3d-5bed-a081-224a895256d3", "dsi.navigation.DSINavigation");
        DSINavigationReplyService dSINavigationReplyService = new DSINavigationReplyService(dSINavigationReply);
        this.proxy = new Proxy(serviceInstanceID, dSINavigationReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void afaRepeat(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)0, genericSerializable);
    }

    public void createExportFile(String string, int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void dmFlagDestinationSet(final NavLocation navLocation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            }
        };
        this.proxy.remoteCallMethod((short)12, iSerializable);
    }

    public void dmFlagDestinationRemove() throws MethodException {
        this.proxy.remoteCallMethod((short)11, null);
    }

    public void dmFlagDestinationSetName(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    public void dmLastDestinationsAddList(final NavLastDest[] navLastDestArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLastDestSerializer.putOptionalNavLastDestVarArray(iSerializer, navLastDestArray);
            }
        };
        this.proxy.remoteCallMethod((short)322, iSerializable);
    }

    public void dmLastDestinationsDelete(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    public void dmLastDestinationsDeleteAll() throws MethodException {
        this.proxy.remoteCallMethod((short)16, null);
    }

    public void dmLastDestinationsGet(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    public void dmLastDestinationsReplace(final long l, final NavLocation navLocation, final String string) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt64(l);
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
                iSerializer.putOptionalString(string);
            }
        };
        this.proxy.remoteCallMethod((short)19, iSerializable);
    }

    public void dmRecentRoutesAdd(final Route route, final String string) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                RouteSerializer.putOptionalRoute(iSerializer, route);
                iSerializer.putOptionalString(string);
            }
        };
        this.proxy.remoteCallMethod((short)20, iSerializable);
    }

    public void dmRecentRoutesDelete(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    public void dmRecentRoutesDeleteAll() throws MethodException {
        this.proxy.remoteCallMethod((short)22, null);
    }

    public void dmRecentRoutesGet(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    public void dmRecentRoutesReplace(final long l, final Route route, final String string) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt64(l);
                RouteSerializer.putOptionalRoute(iSerializer, route);
                iSerializer.putOptionalString(string);
            }
        };
        this.proxy.remoteCallMethod((short)25, iSerializable);
    }

    public void enableRgStreetLists(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)39, genericSerializable);
    }

    public void enableRgLaneGuidance(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)37, genericSerializable);
    }

    public void enableRgPoiInfo(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)38, genericSerializable);
    }

    public void etcGetCountryAbbreviation(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)40, genericSerializable);
    }

    public void etcSetDemoMode(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)46, genericSerializable);
    }

    public void etcSetDemoModeSpeed(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)47, genericSerializable);
    }

    public void etcSetMetricSystem(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)48, genericSerializable);
    }

    public void etcSelectDatabase(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)42, genericSerializable);
    }

    public void etcSelectNavDataBase(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)43, genericSerializable);
    }

    public void importFile(String string, int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)51, genericSerializable);
    }

    public void languageSpellableCharacters(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)54, genericSerializable);
    }

    public void liGetCurrentState() throws MethodException {
        this.proxy.remoteCallMethod((short)58, null);
    }

    public void liGetLastCityHistoryEntry(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)59, genericSerializable);
    }

    public void liGetLastStreetHistoryEntry(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)63, genericSerializable);
    }

    public void liGetLocationDescriptionTransform(final NavLocation navLocation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            }
        };
        this.proxy.remoteCallMethod((short)65, iSerializable);
    }

    public void liGetLocationDescriptionTransformNearBy(final NavLocation navLocation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            }
        };
        this.proxy.remoteCallMethod((short)332, iSerializable);
    }

    public void liGetState() throws MethodException {
        this.proxy.remoteCallMethod((short)69, null);
    }

    public void liGetLastStateHistoryEntry(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)61, genericSerializable);
    }

    public void liLastStateHistoryAdd(final NavLocation navLocation, final boolean bl, final String string) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
                iSerializer.putBool(bl);
                iSerializer.putOptionalString(string);
            }
        };
        this.proxy.remoteCallMethod((short)79, iSerializable);
    }

    public void liLastStateHistoryAddExtended(final NavLocation navLocation, final boolean bl, final String string, final LIExtData[] lIExtDataArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
                iSerializer.putBool(bl);
                iSerializer.putOptionalString(string);
                LIExtDataSerializer.putOptionalLIExtDataVarArray(iSerializer, lIExtDataArray);
            }
        };
        this.proxy.remoteCallMethod((short)80, iSerializable);
    }

    public void liLastStateHistoryDelete(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)81, genericSerializable);
    }

    public void liLastStateHistoryDeleteAll() throws MethodException {
        this.proxy.remoteCallMethod((short)82, null);
    }

    public void liLastCityHistoryAdd(final NavLocation navLocation, final boolean bl, final String string) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
                iSerializer.putBool(bl);
                iSerializer.putOptionalString(string);
            }
        };
        this.proxy.remoteCallMethod((short)75, iSerializable);
    }

    public void liLastCityHistoryAddExtended(final NavLocation navLocation, final boolean bl, final String string, final LIExtData[] lIExtDataArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
                iSerializer.putBool(bl);
                iSerializer.putOptionalString(string);
                LIExtDataSerializer.putOptionalLIExtDataVarArray(iSerializer, lIExtDataArray);
            }
        };
        this.proxy.remoteCallMethod((short)76, iSerializable);
    }

    public void liLastCityHistoryDelete(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)77, genericSerializable);
    }

    public void liLastCityHistoryDeleteAll() throws MethodException {
        this.proxy.remoteCallMethod((short)78, null);
    }

    public void liLastStreetHistoryAdd(final NavLocation navLocation, final String string) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
                iSerializer.putOptionalString(string);
            }
        };
        this.proxy.remoteCallMethod((short)83, iSerializable);
    }

    public void liLastStreetHistoryAddExtended(final NavLocation navLocation, final String string, final LIExtData[] lIExtDataArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
                iSerializer.putOptionalString(string);
                LIExtDataSerializer.putOptionalLIExtDataVarArray(iSerializer, lIExtDataArray);
            }
        };
        this.proxy.remoteCallMethod((short)84, iSerializable);
    }

    public void liLastStreetHistoryDelete(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)85, genericSerializable);
    }

    public void liLastStreetHistoryDeleteAll() throws MethodException {
        this.proxy.remoteCallMethod((short)86, null);
    }

    public void liRestoreState(final LISpellerData lISpellerData) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                LISpellerDataSerializer.putOptionalLISpellerData(iSerializer, lISpellerData);
            }
        };
        this.proxy.remoteCallMethod((short)87, iSerializable);
    }

    public void liSetCountryForCityAndStreetHistory(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)91, genericSerializable);
    }

    public void liSetHistory(String string, String string2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)94, genericSerializable);
    }

    public void liSetStreetForCityHistory(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)284, genericSerializable);
    }

    public void liDeleteHistory() throws MethodException {
        this.proxy.remoteCallMethod((short)57, null);
    }

    public void liSetCurrentLD(final NavLocation navLocation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            }
        };
        this.proxy.remoteCallMethod((short)93, iSerializable);
    }

    public void lispAddCharacter(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)116, genericSerializable);
    }

    public void lispCancelSpeller() throws MethodException {
        this.proxy.remoteCallMethod((short)117, null);
    }

    public void lispDeleteAllCharacters() throws MethodException {
        this.proxy.remoteCallMethod((short)118, null);
    }

    public void lispRequestValueListByListIndex(int n, boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)119, genericSerializable);
    }

    public void lispSelectListItem(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)122, genericSerializable);
    }

    public void lispSelectItemFromLocation(final NavLocation navLocation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            }
        };
        this.proxy.remoteCallMethod((short)121, iSerializable);
    }

    public void lispSelectByCategoryUid(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)120, genericSerializable);
    }

    public void lispSelectByMultipleCategoryUids(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)275, genericSerializable);
    }

    public void lispSetInput(String string, boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)124, genericSerializable);
    }

    public void lispGetMatchingNVC(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)319, genericSerializable);
    }

    public void lispUndoCharacter() throws MethodException {
        this.proxy.remoteCallMethod((short)125, null);
    }

    public void liStartMultiCriteriaSpeller(int n, int n2, boolean bl, boolean bl2, boolean bl3) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putBool(bl);
            genericSerializable.putBool(bl2);
            genericSerializable.putBool(bl3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)95, genericSerializable);
    }

    public void liStartSpeller(int n, boolean bl, boolean bl2, boolean bl3) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
            genericSerializable.putBool(bl2);
            genericSerializable.putBool(bl3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)96, genericSerializable);
    }

    public void liTryBestMatch(final TryBestMatchData tryBestMatchData) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                TryBestMatchDataSerializer.putOptionalTryBestMatchData(iSerializer, tryBestMatchData);
            }
        };
        this.proxy.remoteCallMethod((short)108, iSerializable);
    }

    public void liValueListFilename(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)112, genericSerializable);
    }

    public void liValueListOutputMethod(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)114, genericSerializable);
    }

    public void locationToStream(final NavLocation navLocation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            }
        };
        this.proxy.remoteCallMethod((short)127, iSerializable);
    }

    public void poiSelectSelectionCriteria(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)129, genericSerializable);
    }

    public void poiSetContext(final NavLocation navLocation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            }
        };
        this.proxy.remoteCallMethod((short)130, iSerializable);
    }

    public void poiSetSortOrder2(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)131, genericSerializable);
    }

    public void poiStartSpellerAlongRoute(int n, long l, long l2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
            genericSerializable.putInt64(l2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)133, genericSerializable);
    }

    public void poiStartSpellerAlongRouteAdvanced(int n, long l, long l2, long l3, boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
            genericSerializable.putInt64(l2);
            genericSerializable.putInt64(l3);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)276, genericSerializable);
    }

    public void requestSoPosPositionDescriptionVehicle() throws MethodException {
        this.proxy.remoteCallMethod((short)138, null);
    }

    public void rgCalculateRoute(final Route route, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                RouteSerializer.putOptionalRoute(iSerializer, route);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)140, iSerializable);
    }

    public void rgSetPosition(final NavLocation navLocation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            }
        };
        this.proxy.remoteCallMethod((short)144, iSerializable);
    }

    public void rgSetRouteGuidanceMode(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)145, genericSerializable);
    }

    public void rgSetRouteOptions(final RouteOptions routeOptions) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                RouteOptionsSerializer.putOptionalRouteOptions(iSerializer, routeOptions);
            }
        };
        this.proxy.remoteCallMethod((short)147, iSerializable);
    }

    public void rgStartGuidanceCalculatedRoute(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)148, genericSerializable);
    }

    public void rgStopGuidance() throws MethodException {
        this.proxy.remoteCallMethod((short)152, null);
    }

    public void rmMakeRoutePersistent(final Route route) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                RouteSerializer.putOptionalRoute(iSerializer, route);
            }
        };
        this.proxy.remoteCallMethod((short)156, iSerializable);
    }

    public void rmRouteAdd(final int n, final Route route, final String string) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                RouteSerializer.putOptionalRoute(iSerializer, route);
                iSerializer.putOptionalString(string);
            }
        };
        this.proxy.remoteCallMethod((short)158, iSerializable);
    }

    public void rmRouteDelete(int n, long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)160, genericSerializable);
    }

    public void rmRouteDeleteAll(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)161, genericSerializable);
    }

    public void rmRouteGet(int n, long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)164, genericSerializable);
    }

    public void rmRouteRename(int n, long l, String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)166, genericSerializable);
    }

    public void rrdStartCalculationByListIndex(int n, long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)170, genericSerializable);
    }

    public void rrdStartCalculationForPosition(final NavLocationWgs84[] navLocationWgs84Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationWgs84Serializer.putOptionalNavLocationWgs84VarArray(iSerializer, navLocationWgs84Array);
            }
        };
        this.proxy.remoteCallMethod((short)171, iSerializable);
    }

    public void rrdStopCalculation() throws MethodException {
        this.proxy.remoteCallMethod((short)172, null);
    }

    public void setLanguage(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)173, genericSerializable);
    }

    public void streamToLocation(byte[] byArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt8VarArray(byArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)189, genericSerializable);
    }

    public void translateRoute(final Route route) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                RouteSerializer.putOptionalRoute(iSerializer, route);
            }
        };
        this.proxy.remoteCallMethod((short)204, iSerializable);
    }

    public void trCreateWaypoint() throws MethodException {
        this.proxy.remoteCallMethod((short)191, null);
    }

    public void trDeleteAllTraces() throws MethodException {
        this.proxy.remoteCallMethod((short)192, null);
    }

    public void trDeleteTrace(final NavSegmentID navSegmentID) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavSegmentIDSerializer.putOptionalNavSegmentID(iSerializer, navSegmentID);
            }
        };
        this.proxy.remoteCallMethod((short)194, iSerializable);
    }

    public void trRenameTrace(final NavSegmentID navSegmentID, final String string) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavSegmentIDSerializer.putOptionalNavSegmentID(iSerializer, navSegmentID);
                iSerializer.putOptionalString(string);
            }
        };
        this.proxy.remoteCallMethod((short)196, iSerializable);
    }

    public void trStartTraceRecording(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)198, genericSerializable);
    }

    public void trStopTraceRecording() throws MethodException {
        this.proxy.remoteCallMethod((short)200, null);
    }

    public void trStoreTrace(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)202, genericSerializable);
    }

    public void liStripLocation(final NavLocation navLocation, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)98, iSerializable);
    }

    public void liSetNVCRange(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)318, genericSerializable);
    }

    public void liValueListWindowSize(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)274, genericSerializable);
    }

    public void requestAudioTrigger(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)135, genericSerializable);
    }

    public void liThesaurusHistoryAdd(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)100, genericSerializable);
    }

    public void liThesaurusHistoryGetEntry(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)106, genericSerializable);
    }

    public void liThesaurusHistoryDelete(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)102, genericSerializable);
    }

    public void liThesaurusHistoryDeleteAll() throws MethodException {
        this.proxy.remoteCallMethod((short)103, null);
    }

    public void ehGetAllCategories(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)29, genericSerializable);
    }

    public void ehGetAllBrandsOfCategory(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)27, genericSerializable);
    }

    public void ehSetCategoryVisibility(int n, int[] nArray, boolean[] blArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalInt32VarArray(nArray);
            genericSerializable.putOptionalBoolVarArray(blArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)36, genericSerializable);
    }

    public void ehSetCategoryVisibilityToDefault(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)273, genericSerializable);
    }

    public void ehSetCategoryAudioWarning(int n, int[] nArray, boolean[] blArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalInt32VarArray(nArray);
            genericSerializable.putOptionalBoolVarArray(blArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)34, genericSerializable);
    }

    public void ehSetCategoryMonitoring(int[] nArray, boolean[] blArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
            genericSerializable.putOptionalBoolVarArray(blArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)35, genericSerializable);
    }

    public void ehSetBrandVisibility(int n, int[] nArray, boolean[] blArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalInt32VarArray(nArray);
            genericSerializable.putOptionalBoolVarArray(blArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)33, genericSerializable);
    }

    public void ehSetBrandPreference(int n, int[] nArray, boolean[] blArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalInt32VarArray(nArray);
            genericSerializable.putOptionalBoolVarArray(blArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)32, genericSerializable);
    }

    public void setRemainingRangeOfVehicle(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)178, genericSerializable);
    }

    public void setUserDefinedPOIs(final NavLocation[] navLocationArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocationVarArray(iSerializer, navLocationArray);
            }
        };
        this.proxy.remoteCallMethod((short)182, iSerializable);
    }

    public void setTrailerStatus(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)180, genericSerializable);
    }

    public void requestCountryInfo(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)136, genericSerializable);
    }

    public void jumpToNextManeuver() throws MethodException {
        this.proxy.remoteCallMethod((short)53, null);
    }

    public void liGetViaPointCountryList() throws MethodException {
        this.proxy.remoteCallMethod((short)283, null);
    }

    public void liSetViaPointCountry(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)285, genericSerializable);
    }

    public void liGetViaPointList(int n, int n2, int n3, int n4) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
            genericSerializable.putInt32(n4);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)71, genericSerializable);
    }

    public void liSelectViaPoint(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)89, genericSerializable);
    }

    public void rgStartGuidanceCalculatedRouteByUID(final NavSegmentID navSegmentID) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavSegmentIDSerializer.putOptionalNavSegmentID(iSerializer, navSegmentID);
            }
        };
        this.proxy.remoteCallMethod((short)149, iSerializable);
    }

    public void liGetSpellableCharacters(final NavLocation navLocation, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)67, iSerializable);
    }

    public void liStopSpeller() throws MethodException {
        this.proxy.remoteCallMethod((short)97, null);
    }

    public void liValueListMaximumLength(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)113, genericSerializable);
    }

    public void setPathsToPersonalPOIDataBases(String[] stringArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalStringVarArray(stringArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)177, genericSerializable);
    }

    public void deletePersonalPOIDataBases(String[] stringArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalStringVarArray(stringArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    public void rgStopRouteCalculation() throws MethodException {
        this.proxy.remoteCallMethod((short)153, null);
    }

    public void rgSwitchToNextPossibleRoad() throws MethodException {
        this.proxy.remoteCallMethod((short)154, null);
    }

    public void setVehicleFuelType(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)186, genericSerializable);
    }

    public void createNavLocationOfPOIUID(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    public void lispSelectListItemByIdent(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)123, genericSerializable);
    }

    public void rmRouteReplace(final int n, final long l, final Route route) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt64(l);
                RouteSerializer.putOptionalRoute(iSerializer, route);
            }
        };
        this.proxy.remoteCallMethod((short)168, iSerializable);
    }

    public void setNavInternalDataToFactorySettings() throws MethodException {
        this.proxy.remoteCallMethod((short)277, null);
    }

    public void liTryMatchLocation(final TryMatchLocationData tryMatchLocationData) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                TryMatchLocationDataSerializer.putOptionalTryMatchLocationData(iSerializer, tryMatchLocationData);
            }
        };
        this.proxy.remoteCallMethod((short)324, iSerializable);
    }

    public void trImportTrails(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)306, genericSerializable);
    }

    public void trExportTrails(final NavSegmentID[] navSegmentIDArray, final String string) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavSegmentIDSerializer.putOptionalNavSegmentIDVarArray(iSerializer, navSegmentIDArray);
                iSerializer.putOptionalString(string);
            }
        };
        this.proxy.remoteCallMethod((short)304, iSerializable);
    }

    public void rgSkipNextWayPoints(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)300, genericSerializable);
    }

    public void rgReverseTrailDirection() throws MethodException {
        this.proxy.remoteCallMethod((short)298, null);
    }

    public void rgPrepareRubberbandManipulation(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)296, genericSerializable);
    }

    public void rgStartRubberbandManipulation(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)301, genericSerializable);
    }

    public void rgSetRubberbandPosition(final NavLocationWgs84 navLocationWgs84) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, navLocationWgs84);
            }
        };
        this.proxy.remoteCallMethod((short)299, iSerializable);
    }

    public void rgGetRouteBoundingRectangle(boolean bl, int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)294, genericSerializable);
    }

    public void rgGetLocationOnRoute(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)292, genericSerializable);
    }

    public void rgStopRubberbandManipulation() throws MethodException {
        this.proxy.remoteCallMethod((short)303, null);
    }

    public void rgDeleteCalculatedRubberbandPoint() throws MethodException {
        this.proxy.remoteCallMethod((short)312, null);
    }

    public void rgGetRubberBandPointPosition() throws MethodException {
        this.proxy.remoteCallMethod((short)313, null);
    }

    public void rgEnableEnhancedSignPostInfo(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)291, genericSerializable);
    }

    public void lispGetLocationFromLiValueListElement(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)325, genericSerializable);
    }

    public void rgSetTurnListMode(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)342, genericSerializable);
    }

    public void liHistoryAddLocation(final NavLocation navLocation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            }
        };
        this.proxy.remoteCallMethod((short)334, iSerializable);
    }

    public void liLastCityHistorySetStreet(final NavLocation navLocation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            }
        };
        this.proxy.remoteCallMethod((short)335, iSerializable);
    }

    public void liLastStreetHistorySetCity(final NavLocation navLocation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            }
        };
        this.proxy.remoteCallMethod((short)336, iSerializable);
    }

    public void enableRgMotorwayInfo(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)331, genericSerializable);
    }

    public void rgTriggerRCCIUpdate() throws MethodException {
        this.proxy.remoteCallMethod((short)343, null);
    }

    public void poiGetXt9LDBs(final NavLocation navLocation, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)338, iSerializable);
    }

    public void poiSetListStyle(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)340, genericSerializable);
    }

    public void etcGetPositionTimeInfo(final NavLocationWgs84 navLocationWgs84) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, navLocationWgs84);
            }
        };
        this.proxy.remoteCallMethod((short)352, iSerializable);
    }

    public void poiGetCategoryTypesFromUId(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)354, genericSerializable);
    }

    public void rgDeletePersistedRouteData() throws MethodException {
        this.proxy.remoteCallMethod((short)357, null);
    }

    public void rgCalculate1stRouteAndPostponeRemaining(final Route route, final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                RouteSerializer.putOptionalRoute(iSerializer, route);
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)356, iSerializable);
    }

    public void liDisambiguateLocation(final NavLocation navLocation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            }
        };
        this.proxy.remoteCallMethod((short)365, iSerializable);
    }

    public void triggerEventAudioMessage(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)374, genericSerializable);
    }

    public void lispAddStroke(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)370, genericSerializable);
    }

    public void lispRequestNVCList(int n, int n2, int n3) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)371, genericSerializable);
    }

    public void poiConfigureContext(final String string, final int n, final NavLocation navLocation, final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putInt32(n);
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
                iSerializer.putOptionalInt32VarArray(nArray);
            }
        };
        this.proxy.remoteCallMethod((short)373, iSerializable);
    }

    public void etcTriggerNavigationRestart(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)376, genericSerializable);
    }

    public void rmImportToursFromGpxFile(int n, String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)384, genericSerializable);
    }

    public void rmAbortImportToursFromGpxFile() throws MethodException {
        this.proxy.remoteCallMethod((short)383, null);
    }

    public void importRouteFromGpxFile(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)381, genericSerializable);
    }

    public void poiRequestExtendedInfo(final NavLocation navLocation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            }
        };
        this.proxy.remoteCallMethod((short)392, iSerializable);
    }

    public void rgConfigurePoiInfo(final NavPoiInfoConfiguration navPoiInfoConfiguration) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavPoiInfoConfigurationSerializer.putOptionalNavPoiInfoConfiguration(iSerializer, navPoiInfoConfiguration);
            }
        };
        this.proxy.remoteCallMethod((short)394, iSerializable);
    }

    public void trClearRecordedTraceCache() throws MethodException {
        this.proxy.remoteCallMethod((short)404, null);
    }

    public void setVirtualRouteGuidance(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)410, genericSerializable);
    }

    public void profileChange(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)396, genericSerializable);
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
        this.proxy.remoteCallMethod((short)399, genericSerializable);
    }

    public void profileReset(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)400, genericSerializable);
    }

    public void profileResetAll() throws MethodException {
        this.proxy.remoteCallMethod((short)402, null);
    }

    public void deleteSatelliteCache() throws MethodException {
        this.proxy.remoteCallMethod((short)411, null);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)175, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)176, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)174, null);
    }

    public void clearNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)2, null);
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
        this.proxy.remoteCallMethod((short)272, genericSerializable);
    }
}

