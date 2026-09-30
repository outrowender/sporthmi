/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.call.CommandCallResponse;
import de.audi.tghu.navi.app.call.CommandListCallManager;
import de.audi.tghu.navi.app.dsi.AbstractDSINavigationHandler;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import de.audi.tghu.navi.app.dsi.NonDSIFunctionality;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.BapManeuverDescriptor;
import org.dsi.ifc.navigation.BapTurnToInfo;
import org.dsi.ifc.navigation.BlockElement;
import org.dsi.ifc.navigation.Brand;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.Category;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.CountryInfo;
import org.dsi.ifc.navigation.DSIBlockingListener;
import org.dsi.ifc.navigation.DSICombinedRouteListListener;
import org.dsi.ifc.navigation.DSINavigationListener;
import org.dsi.ifc.navigation.DirectionToWaypoint;
import org.dsi.ifc.navigation.DistanceToNextManeuver;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIStateHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.NavDataBase;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.NavNextWayPointInfo;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.NavTraceListData;
import org.dsi.ifc.navigation.NavTraceMemoryUtilization;
import org.dsi.ifc.navigation.NavVersionInfo;
import org.dsi.ifc.navigation.PoiExtendedInfo;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.PosTimeInfo;
import org.dsi.ifc.navigation.RRListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.RgTurnToInfo;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.RouteProperties;
import org.dsi.ifc.navigation.RrdCalculationInfo;
import org.dsi.ifc.navigation.ThesaurusHistoryEntry;
import org.dsi.ifc.navigation.TourImportStatus;
import org.dsi.ifc.navigation.TryBestMatchResultData;
import org.dsi.ifc.navigation.TryMatchLocationResultData;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.navigation.ValueListStatus;
import org.dsi.ifc.navigation.ViaPointListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class DSINavigationDispatcher
implements DSINavigationListener,
DSIBlockingListener,
DSICombinedRouteListListener,
NonDSIFunctionality,
ICommandResponseSupplier {
    private final IDSINavigationHandler defaultHandler;
    private final CommandListManager manager;
    private final int dsiType;
    private final String listenerName;
    private final LogChannel logChannel;
    private final DispatcherBase dispatcher;

    public DSINavigationDispatcher(NavigationEnv navigationEnv, CommandListManager commandListManager, IDSINavigationHandler iDSINavigationHandler, int n, DispatcherBase dispatcherBase) {
        this.manager = commandListManager;
        this.defaultHandler = iDSINavigationHandler;
        this.dsiType = n;
        this.listenerName = "DSINavigationDispatcher[" + DSINavigationManager.dsiTypeToString(n) + "]";
        this.logChannel = navigationEnv.getDSILogChannel();
        this.dispatcher = dispatcherBase;
    }

    public IDSINavigationHandler getDefaultHandler() {
        return this.defaultHandler;
    }

    public void cleanUp() {
        if (this.defaultHandler instanceof AbstractDSINavigationHandler) {
            ((AbstractDSINavigationHandler)this.defaultHandler).cleanUp();
        }
    }

    private void logEnter(int n, String string) {
        if (n == 100000000 && this.logChannel.isDebug2() || n != 100000000) {
            this.logChannel.log(n, "%1#%2() - enter", (Object)this.listenerName, (Object)string);
        }
    }

    private void logExit(int n, String string) {
        if (n == 100000000 && this.logChannel.isDebug2() || n != 100000000) {
            this.logChannel.log(n, "%1#%2() - exit", (Object)this.listenerName, (Object)string);
        }
    }

    private void logEnter(String string) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "%1#%2() - enter", (Object)this.listenerName, (Object)string);
        }
    }

    private void logExit(String string) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "%1#%2() - exit", (Object)this.listenerName, (Object)string);
        }
    }

    public void propagateDSIData() {
        if (this.defaultHandler instanceof AbstractDSINavigationHandler) {
            this.logChannel.log(10000000, "%1#triggerRSEData()", (Object)this.listenerName);
            ((AbstractDSINavigationHandler)this.defaultHandler).propagateDSIData();
        } else {
            this.logChannel.log(10000, "%1#triggerRSEData() - could not trigger handler!", (Object)this.listenerName);
        }
    }

    public AbstractDSINavigationHandler getDSINavigationDefaultHandler() {
        if (this.defaultHandler instanceof AbstractDSINavigationHandler) {
            return (AbstractDSINavigationHandler)this.defaultHandler;
        }
        this.logChannel.log(10000, "%1#getDSINavigationDefaultHandler() - could not get handler!", (Object)this.listenerName);
        return null;
    }

    public CommandList getActiveCommandList() {
        CommandList commandList = this.manager.getActiveCommandList();
        return commandList != null && DSINavigationManager.getDSIType(commandList) == this.dsiType ? commandList : null;
    }

    public DSIListener getDSIDefaultHandler() {
        return this.defaultHandler;
    }

    public String getHandlerName() {
        return this.listenerName;
    }

    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    public void asyncException(final int n, final String string, final int n2) {
        this.logEnter("asyncException");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).asyncException(n, string, n2);
            }
        });
        this.logExit("asyncException");
    }

    public void responseAudioTrigger(final int n) {
        this.logEnter("responseAudioTrigger");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).responseAudioTrigger(n);
            }
        });
        this.logExit("responseAudioTrigger");
    }

    public void updateDistanceToNextManeuver(final DistanceToNextManeuver distanceToNextManeuver, int n) {
        this.logEnter(10000000, "updateDistanceToNextManeuver");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateDistanceToNextManeuver(distanceToNextManeuver);
                }
            });
        }
        this.logExit(100000000, "updateDistanceToNextManeuver");
    }

    public void dmLastDestinationsGetResult(final long l, final NavLocation navLocation) {
        this.logEnter("dmLastDestinationsGetResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).dmLastDestinationsGetResult(l, navLocation);
            }
        });
        this.logExit("dmLastDestinationsGetResult");
    }

    public void dmRecentRoutesGetResult(final long l, final Route route) {
        this.logEnter("dmRecentRoutesGetResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).dmRecentRoutesGetResult(l, route);
            }
        });
        this.logExit("dmRecentRoutesGetResult");
    }

    public void dmResult(final long l, final long l2) {
        this.logEnter("dmResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).dmResult(l, l2);
            }
        });
        this.logExit("dmResult");
    }

    public void liCurrentState(final NavLocation navLocation, final int[] nArray, final int[] nArray2, final long l) {
        this.logEnter("liCurrentState");
        CommandResponse.executeTryCatch(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liCurrentState(navLocation, nArray, nArray2, l);
            }
        }, "liCurrentState");
        this.logExit("liCurrentState");
    }

    public void liGetLocationDescriptionTransformResult(final NavLocation navLocation) {
        this.logEnter("liGetLocationDescriptionTransformResult");
        CommandCallResponse.executeCall(this, (CommandListCallManager)this.manager, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liGetLocationDescriptionTransformResult(navLocation);
            }
        });
        this.logExit("liGetLocationDescriptionTransformResult");
    }

    public void liGetStateResult(final LISpellerData lISpellerData) {
        this.logEnter("liGetStateResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liGetStateResult(lISpellerData);
            }
        });
        this.logExit("liGetStateResult");
    }

    public void liStripLocationResult(final NavLocation navLocation) {
        this.logEnter("liStripLocationResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liStripLocationResult(navLocation);
            }
        });
        this.logExit("liStripLocationResult");
    }

    public void liResult(final long l) {
        this.logEnter("liResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liResult(l);
            }
        });
        this.logExit("liResult");
    }

    public void liValueList(LIValueList lIValueList, final long l) {
        LIValueList lIValueList2;
        this.logEnter("liValueList");
        if (lIValueList != null && lIValueList.getList() != null) {
            if (l < (long)lIValueList.getList().length) {
                LIValueListElement[] lIValueListElementArray = new LIValueListElement[(int)l];
                System.arraycopy((Object)lIValueList.getList(), 0, (Object)lIValueListElementArray, 0, (int)l);
                lIValueList2 = new LIValueList(lIValueListElementArray, lIValueList.isHasNextPage(), lIValueList.isHasPrevPage());
            } else {
                lIValueList2 = lIValueList;
            }
        } else {
            lIValueList2 = lIValueList;
            this.logChannel.log(100000, "%1#liValueList() - either lispValueList or lispValueList.getList() is null! lispValueListCount = %2", (Object)this.listenerName, l);
        }
        CommandResponse.executeTryCatch(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liValueList(lIValueList2, l);
            }
        }, "liValueList");
        this.logExit("liValueList");
    }

    public void lispUpdateSpellerResult(final String string, final int n, final boolean bl, final boolean bl2, final String string2, final int n2, final int n3, final boolean bl3, final boolean bl4, final int n4, final long l) {
        this.logEnter("lispUpdateSpellerResult");
        CommandResponse.executeTryCatch(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).lispUpdateSpellerResult(string, n, bl, bl2, string2, n2, n3, bl3, bl4, n4, l);
            }
        }, "lispUpdateSpellerResult");
        this.logExit("lispUpdateSpellerResult");
    }

    public void liGetLastCityHistoryEntryResult(final NavLocation navLocation, final boolean bl) {
        this.logEnter("liGetLastCityHistoryEntryResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liGetLastCityHistoryEntryResult(navLocation, bl);
            }
        });
        this.logExit("liGetLastCityHistoryEntryResult");
    }

    public void liGetLastStreetHistoryEntryResult(final NavLocation navLocation, final boolean bl) {
        this.logEnter("liGetLastStreetHistoryEntryResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liGetLastStreetHistoryEntryResult(navLocation, bl);
            }
        });
        this.logExit("liGetLastStreetHistoryEntry");
    }

    public void liLastCityAndStreetHistoryResult(final long l) {
        this.logEnter("liLastCityAndStreetHistoryResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liLastCityAndStreetHistoryResult(l);
            }
        });
        this.logExit("liLastCityAndStreetHistoryResult");
    }

    public void liValueListFileStatus(final int n, final int n2, final String string) {
        this.logEnter("liValueListFileStatus");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liValueListFileStatus(n, n2, string);
            }
        });
        this.logExit("liValueListFileStatus");
    }

    public void liValueListOutputMethod(final int n) {
        this.logEnter("liValueListOutputMethod");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liValueListOutputMethod(n);
            }
        });
        this.logExit("liValueListOutputMethod");
    }

    public void liSetCountryForCityAndStreetHistoryResult(final int n) {
        this.logEnter("liSetCountryForCityAndStreetHistoryResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liSetCountryForCityAndStreetHistoryResult(n);
            }
        });
        this.logExit("liSetCountryForCityAndStreetHistoryResult");
    }

    public void poiValueList(final LIValueList lIValueList, final long l) {
        this.logEnter("poiValueList");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).poiValueList(lIValueList, l);
            }
        });
        this.logExit("poiValueList");
    }

    public void rmRouteAddResult(final int n, final long l) {
        this.logEnter("rmRouteAddResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).rmRouteAddResult(n, l);
            }
        });
        this.logExit("rmRouteAddResult");
    }

    public void rmRouteDeleteAllResult(final int n) {
        this.logEnter("rmRouteDeleteAllResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).rmRouteDeleteAllResult(n);
            }
        });
        this.logExit("rmRouteDeleteAllResult");
    }

    public void rmRouteDeleteResult(final int n) {
        this.logEnter("rmRouteDeleteResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).rmRouteDeleteResult(n);
            }
        });
        this.logExit("rmRouteDeleteResult");
    }

    public void rmRouteGetResult(final int n, final Route route) {
        this.logEnter("rmRouteGetResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).rmRouteGetResult(n, route);
            }
        });
        this.logExit("rmRouteGetResult");
    }

    public void rmRouteRenameResult(final int n) {
        this.logEnter("rmRouteRenameResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).rmRouteRenameResult(n);
            }
        });
        this.logExit("rmRouteRenameResult");
    }

    public void rmRouteReplaceResult(final int n, final long l, final int n2) {
        this.logEnter("rmRouteReplaceResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).rmRouteReplaceResult(n, l, n2);
            }
        });
        this.logExit("rmRouteReplaceResult");
    }

    public void soPosPositionDescriptionVehicleResult(final NavLocation navLocation) {
        this.logEnter("soPosPositionDescriptionVehicleResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).soPosPositionDescriptionVehicleResult(navLocation);
            }
        });
        this.logExit("soPosPositionDescriptionVehicleResult");
    }

    public void translateRouteResult(final Route route) {
        this.logEnter("translateRouteResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).translateRouteResult(route);
            }
        });
        this.logExit("translateRouteResult");
    }

    public void trDeleteAllTracesResult(final int n, final int n2) {
        this.logEnter("trDeleteAllTracesResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).trDeleteAllTracesResult(n, n2);
            }
        });
        this.logExit("trDeleteAllTracesResult");
    }

    public void trDeleteTraceResult(final int n, final int n2) {
        this.logEnter("trDeleteTraceResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).trDeleteTraceResult(n, n2);
            }
        });
        this.logExit("trDeleteTraceResult");
    }

    public void trRenameTraceResult(final int n, final int n2) {
        this.logEnter("trRenameTraceResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).trRenameTraceResult(n, n2);
            }
        });
        this.logExit("trRenameTraceResult");
    }

    public void trStartTraceRecordingResult(final int n, final long l, final int n2) {
        this.logEnter("trStartTraceRecordingResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).trStartTraceRecordingResult(n, l, n2);
            }
        });
        this.logExit("trStartTraceRecordingResult");
    }

    public void trStopTraceRecordingResult(final int n, final long l, final int n2) {
        this.logEnter("trStopTraceRecordingResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).trStopTraceRecordingResult(n, l, n2);
            }
        });
        this.logExit("trStopTraceRecordingResult");
    }

    public void trStoreTraceResult(final int n, final NavSegmentID navSegmentID, final int n2) {
        this.logEnter("trStoreTraceResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).trStoreTraceResult(n, navSegmentID, n2);
            }
        });
        this.logExit("trStoreTraceResult");
    }

    public void rgSetRouteGuidanceModeResult() {
        this.logEnter("rgSetRouteGuidanceModeResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).rgSetRouteGuidanceModeResult();
            }
        });
        this.logExit("rgSetRouteGuidanceModeResult");
    }

    public void rgStartGuidanceCalculatedRouteResult(final int n) {
        this.logEnter("rgStartGuidanceCalculatedRouteResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).rgStartGuidanceCalculatedRouteResult(n);
            }
        });
        this.logExit("rgStartGuidanceCalculatedRouteResult");
    }

    public void updateAfaMode(final int n, int n2) {
        this.logEnter("updateAfaMode");
        if (n2 == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateAfaMode(n);
                }
            });
        }
        this.logExit("updateAfaMode");
    }

    public void updateAfaSpeaking(final boolean bl, int n) {
        this.logEnter("updateAfaSpeaking");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateAfaSpeaking(bl);
                }
            });
        }
        this.logExit("updateAfaSpeaking");
    }

    public void updateDmLastDestinationsList(final LDListElement[] lDListElementArray, int n) {
        this.logEnter("updateDmLastDestinationsList");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateDmLastDestinationsList(lDListElementArray);
                }
            });
        }
        this.logExit("updateDmLastDestinationsList");
    }

    public void updateDmRecentRoutesList(final RRListElement[] rRListElementArray, int n) {
        this.logEnter("updateDmRecentRoutesList");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateDmRecentRoutesList(rRListElementArray);
                }
            });
        }
        this.logExit("updateDmRecentRoutesList");
    }

    public void updateDmFlagDestination(final NavLocation navLocation, int n) {
        this.logEnter("updateDmFlagDestination");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateDmFlagDestination(navLocation);
                }
            });
        }
        this.logExit("updateDmFlagDestination");
    }

    public void updateEtcDemoModeState(final boolean bl, int n) {
        this.logEnter("updateEtcDemoModeState");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateEtcDemoModeState(bl);
                }
            });
        }
        this.logExit("updateEtcDemoModeState");
    }

    public void updateEtcMetricSystem(final int n, int n2) {
        this.logEnter("updateEtcMetricSystem");
        if (n2 == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateEtcMetricSystem(n);
                }
            });
        }
        this.logExit("updateEtcMetricSystem");
    }

    public void etcSensorDataReplayRoute(final Route route) {
        this.logEnter("etcSensorDataReplayRoute");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).etcSensorDataReplayRoute(route);
            }
        });
        this.logExit("etcSensorDataReplayRoute");
    }

    public void etcSensorDataReplayGuidance(final boolean bl) {
        this.logEnter("etcSensorDataReplayGuidance");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).etcSensorDataReplayGuidance(bl);
            }
        });
        this.logExit("etcSensorDataReplayGuidance");
    }

    public void updateEtcVersionInfo(final NavVersionInfo navVersionInfo, int n) {
        this.logEnter("updateEtcVersionInfo");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateEtcVersionInfo(navVersionInfo);
                }
            });
        }
        this.logExit("updateEtcVersionInfo");
    }

    public void updateEtcCurrentNavDataBase(final NavDataBase navDataBase, int n) {
        this.logEnter("updateEtcCurrentNavDataBase");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateEtcCurrentNavDataBase(navDataBase);
                }
            });
        }
        this.logExit("updateEtcCurrentNavDataBase");
    }

    public void updateEtcAvailableNavDataBases(final NavDataBase[] navDataBaseArray, int n) {
        this.logEnter("updateEtcAvailableNavDataBases");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateEtcAvailableNavDataBases(navDataBaseArray);
                }
            });
        }
        this.logExit("updateEtcAvailableNavDataBases");
    }

    public void updateLispIsSpellerActive(final boolean bl, int n) {
        this.logEnter("updateLispIsSpellerActive");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateLispIsSpellerActive(bl);
                }
            });
        }
        this.logExit("updateLispIsSpellerActive");
    }

    public void updateLiCityHistory(final LICityHistoryEntry[] lICityHistoryEntryArray, int n) {
        this.logEnter("updateLiCityHistory");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateLiCityHistory(lICityHistoryEntryArray);
                }
            });
        }
        this.logExit("updateLiCityHistory");
    }

    public void updateLiStreetHistory(final LIStreetHistoryEntry[] lIStreetHistoryEntryArray, int n) {
        this.logEnter("updateLiStreetHistory");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateLiStreetHistory(lIStreetHistoryEntryArray);
                }
            });
        }
        this.logExit("updateLiStreetHistory");
    }

    public void updateLiCountryForCityAndStreetHistory(final String string, int n) {
        this.logEnter("updateLiCountryForCityAndStreetHistory");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateLiCountryForCityAndStreetHistory(string);
                }
            });
        }
        this.logExit("updateLiCountryForCityAndStreetHistory");
    }

    public void updatePoiSubstringSearchStatus(final ValueListStatus valueListStatus, int n) {
        this.logEnter("updatePoiSubstringSearchStatus");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updatePoiSubstringSearchStatus(valueListStatus);
                }
            });
        }
        this.logExit("updatePoiSubstringSearchStatus");
    }

    public void rgNotPossible(final int n) {
        this.logEnter("rgNotPossible");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).rgNotPossible(n);
            }
        });
        this.logExit("rgNotPossible");
    }

    public void rgException(final int n) {
        this.logEnter("rgException");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).rgException(n);
            }
        });
        this.logExit("rgException");
    }

    public void updateBapManeuverDescriptor(final BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
        this.logEnter("updateBapManeuverDescriptor");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateBapManeuverDescriptor(bapManeuverDescriptorArray);
                }
            });
        }
        this.logExit("updateBapManeuverDescriptor");
    }

    public void updateRgInfoForNextDestination(final RgInfoForNextDestination rgInfoForNextDestination, int n) {
        this.logEnter(100000000, "updateRgInfoForNextDestination");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgInfoForNextDestination(rgInfoForNextDestination);
                }
            });
        }
        this.logExit(100000000, "updateRgInfoForNextDestination");
    }

    public void updateRgRouteProperties(final RouteProperties routeProperties, int n) {
        this.logEnter("updateRgRouteProperties");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgRouteProperties(routeProperties);
                }
            });
        }
        this.logExit("updateRgRouteProperties");
    }

    public void updateRgActive(final boolean bl, int n) {
        this.logEnter("updateRgActive");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgActive(bl);
                }
            });
        }
        this.logExit("updateRgActive");
    }

    public void updateRgCalculatedRoutes(final CalculatedRouteListElement[] calculatedRouteListElementArray, int n) {
        this.logEnter("updateRgCalculatedRoutes");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgCalculatedRoutes(calculatedRouteListElementArray);
                }
            });
        }
        this.logExit("updateRgCalculatedRoutes");
    }

    public void updateRgCurrentRoute(final Route route, int n) {
        this.logEnter("updateRgCurrentRoute");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgCurrentRoute(route);
                }
            });
        }
        this.logExit("updateRgCurrentRoute");
    }

    public void updateRgCurrentRouteOptions(final RouteOptions routeOptions, int n) {
        this.logEnter("updateRgCurrentRouteOptions");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgCurrentRouteOptions(routeOptions);
                }
            });
        }
        this.logExit("updateRgCurrentRouteOptions");
    }

    public void updateRgDestinationInfo(final NavRouteListData[] navRouteListDataArray, int n) {
        this.logEnter("updateRgDestinationInfo");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgDestinationInfo(navRouteListDataArray);
                }
            });
        }
        this.logExit("updateRgDestinationInfo");
    }

    public void updateRgLaneGuidance(final NavLaneGuidanceData[] navLaneGuidanceDataArray, final boolean bl, int n) {
        this.logEnter("updateRgLaneGuidance");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgLaneGuidance(navLaneGuidanceDataArray, bl);
                }
            });
        }
        this.logExit("updateRgLaneGuidance");
    }

    public void updateRgPoiInfo(final NavPoiInfo[] navPoiInfoArray, int n) {
        this.logEnter("updateRgPoiInfo");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgPoiInfo(navPoiInfoArray);
                }
            });
        }
        this.logExit("updateRgPoiInfo");
    }

    public void updateRgPoiInfoCalculationHorizon(final long l, int n) {
        this.logEnter("updateRgPoiInfoCalculationHorizon");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgPoiInfoCalculationHorizon(l);
                }
            });
        }
        this.logExit("updateRgPoiInfoCalculationHorizon");
    }

    public void updateRgTurnListCalculationHorizon(final long l, int n) {
        this.logEnter("updateRgTurnListCalculationHorizon");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgTurnListCalculationHorizon(l);
                }
            });
        }
        this.logExit("updateRgTurnListCalculationHorizon");
    }

    public void updateRgStreetList(final NavRouteListData[] navRouteListDataArray, int n) {
        this.logEnter("updateRgStreetList");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgStreetList(navRouteListDataArray);
                }
            });
        }
        this.logExit("updateRgStreetList");
    }

    public void updateRgTimeAfaToDestination(final long l, int n) {
        this.logEnter("updateRgTimeAfaToDestination");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgTimeAfaToDestination(l);
                }
            });
        }
        this.logExit("updateRgTimeAfaToDestination");
    }

    public void updateRgTurnList(final TurnListElement[] turnListElementArray, int n) {
        this.logEnter("updateRgTurnList");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgTurnList(turnListElementArray);
                }
            });
        }
        this.logExit("updateRgTurnList");
    }

    public void updateRgTurnToStreet(final String string, final boolean bl, int n) {
        this.logEnter("updateRgTurnToStreet");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgTurnToStreet(string, bl);
                }
            });
        }
        this.logExit("updateRgTurnToStreet");
    }

    public void updateRgUnfulfilledRouteOptions(final RouteOptions routeOptions, int n) {
        this.logEnter("updateRgUnfulfilledRouteOptions");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgUnfulfilledRouteOptions(routeOptions);
                }
            });
        }
        this.logExit("updateRgUnfulfilledRouteOptions");
    }

    public void updateRmRouteList(final NavRmRouteListArrayData[] navRmRouteListArrayDataArray, int n) {
        this.logEnter("updateRmRouteList");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRmRouteList(navRmRouteListArrayDataArray);
                }
            });
        }
        this.logExit("updateRmRouteList");
    }

    public void updateRrdActive(final boolean bl, int n) {
        this.logEnter("updateRrdActive");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRrdActive(bl);
                }
            });
        }
        this.logExit("updateRrdActive");
    }

    public void updateRrdCalculationInfo(final RrdCalculationInfo[] rrdCalculationInfoArray, int n) {
        this.logEnter("updateRrdCalculationInfo");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRrdCalculationInfo(rrdCalculationInfoArray);
                }
            });
        }
        this.logExit("updateRrdCalculationInfo");
    }

    public void updateSoPosPosition(final PosPosition posPosition, int n) {
        this.logEnter(100000000, "updateSoPosPosition");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateSoPosPosition(posPosition);
                }
            });
        }
        this.logExit(100000000, "updateSoPosPosition");
    }

    public void updateSoPosPositionDescription(final NavLocation navLocation, final boolean bl, int n) {
        this.logEnter("updateSoPosPositionDescription");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateSoPosPositionDescription(navLocation, bl);
                }
            });
        }
        this.logExit("updateSoPosPositionDescription");
    }

    public void updateTrMemoryUtilization(final NavTraceMemoryUtilization navTraceMemoryUtilization, int n) {
        this.logEnter("updateTrMemoryUtilization");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateTrMemoryUtilization(navTraceMemoryUtilization);
                }
            });
        }
        this.logExit("updateTrMemoryUtilization");
    }

    public void updateTrRecordingState(final int n, int n2) {
        this.logEnter("updateTrRecordingState");
        if (n2 == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateTrRecordingState(n);
                }
            });
        }
        this.logExit("updateTrRecordingState");
    }

    public void updateTrOperatingMode(final int n, int n2) {
        this.logEnter("updateTrOperatingMode");
        if (n2 == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateTrOperatingMode(n);
                }
            });
        }
        this.logExit("updateTrOperatingMode");
    }

    public void updateTrTraceList(final NavTraceListData[] navTraceListDataArray, int n) {
        this.logEnter("updateTrTraceList");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateTrTraceList(navTraceListDataArray);
                }
            });
        }
        this.logExit("updateTrTraceList");
    }

    public void updateTrDirectionToWaypoint(final DirectionToWaypoint directionToWaypoint, int n) {
        this.logEnter("updateTrDirectionToWaypoint");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateTrDirectionToWaypoint(directionToWaypoint);
                }
            });
        }
        this.logExit("updateTrDirectionToWaypoint");
    }

    public void rmMakeRoutePersistentResult(final long l) {
        this.logEnter("rmMakeRoutePersistentResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).rmMakeRoutePersistentResult(l);
            }
        });
        this.logExit("rmMakeRoutePersistentResult");
    }

    public void updateAudioRequest(final int n, int n2) {
        this.logEnter("updateAudioRequest");
        if (n2 == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateAudioRequest(n);
                }
            });
        }
        this.logExit("updateAudioRequest");
    }

    public void updateRgDetailedStreetList(final NavRouteListData[] navRouteListDataArray, int n) {
        this.logEnter("updateRgDetailedStreetList");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgDetailedStreetList(navRouteListDataArray);
                }
            });
        }
        this.logExit("updateRgDetailedStreetList");
    }

    public void updateRmPersistentRoute(final Route route, int n) {
        this.logEnter("updateRmPersistentRoute");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRmPersistentRoute(route);
                }
            });
        }
        this.logExit("updateRmPersistentRoute");
    }

    public void liTryBestMatchResult(final TryBestMatchResultData[] tryBestMatchResultDataArray) {
        this.logEnter("liTryBestMatchResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liTryBestMatchResult(tryBestMatchResultDataArray);
            }
        });
        this.logExit("liTryBestMatchResult");
    }

    public void liTryMatchLocationResult(final TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
        this.logEnter("liTryMatchLocationResult");
        CommandCallResponse.executeCall(this, (CommandListCallManager)this.manager, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liTryMatchLocationResult(tryMatchLocationResultDataArray);
            }
        });
        this.logExit("liTryMatchLocationResult");
    }

    public void updateRgRouteCostChangeInformation(final RgRouteCostChangeInformation rgRouteCostChangeInformation, int n) {
        this.logEnter("updateRgRouteCostChangeInformation");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgRouteCostChangeInformation(rgRouteCostChangeInformation);
                }
            });
        }
        this.logExit("updateRgRouteCostChangeInformation");
    }

    public void locationToStreamResult(final boolean bl, final byte[] byArray) {
        this.logEnter("locationToStreamResult");
        CommandCallResponse.executeCall(this, (CommandListCallManager)this.manager, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).locationToStreamResult(bl, byArray);
            }
        });
        this.logExit("locationToStreamResult");
    }

    public void streamToLocationResult(final boolean bl, final NavLocation navLocation) {
        this.logEnter("streamToLocationResult");
        CommandCallResponse.executeCall(this, (CommandListCallManager)this.manager, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).streamToLocationResult(bl, navLocation);
            }
        });
        this.logExit("streamToLocationResult");
    }

    public void updateRgRouteCalculationState(final int n, int n2) {
        this.logEnter("updateRgRouteCalculationState");
        if (n2 == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgRouteCalculationState(n);
                }
            });
        }
        this.logExit("updateRgRouteCalculationState");
    }

    public void updateNavstateOfOperation(final int n, int n2) {
        this.logEnter("updateNavstateOfOperation");
        if (n2 == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateNavstateOfOperation(n);
                }
            });
        }
        this.logExit("updateNavstateOfOperation");
    }

    public void updateNavMedia(final String[] stringArray, int n) {
        this.logEnter("updateNavMedia");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateNavMedia(stringArray);
                }
            });
        }
        this.logExit("updateNavMedia");
    }

    public void updateAvailableLanguages(final String[] stringArray, int n) {
        this.logEnter("updateAvailableLanguages");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateAvailableLanguages(stringArray);
                }
            });
        }
        this.logExit("updateAvailableLanguages");
    }

    public void updateLanguage(final String string, int n) {
        this.logEnter("updateLanguage");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateLanguage(string);
                }
            });
        }
        this.logExit("updateLanguage");
    }

    public void updateEtcLanguageLoadProgress(final long l, int n) {
        this.logEnter("updateEtcLanguageLoadProgress");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateEtcLanguageLoadProgress(l);
                }
            });
        }
        this.logExit("updateEtcLanguageLoadProgress");
    }

    public void updateEtcLanguageLoadStatus(final int n, int n2) {
        this.logEnter("updateEtcLanguageLoadStatus");
        if (n2 == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateEtcLanguageLoadStatus(n);
                }
            });
        }
        this.logExit("updateEtcLanguageLoadStatus");
    }

    public void updateRenderingInfoProvider(final RenderingInfoProvider renderingInfoProvider) {
        this.logEnter("updateRenderingInfoProvider");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).updateRenderingInfoProvider(renderingInfoProvider);
            }
        });
        this.logExit("updateRenderingInfoProvider");
    }

    public void updateClockAdjusted(final boolean bl) {
        this.logEnter("updateClockAdjusted");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).updateClockAdjusted(bl);
            }
        });
        this.logExit("updateClockAdjusted");
    }

    public void updateCityVignettes(final int[] nArray, int n) {
        this.logEnter("updateCityVignettes");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateCityVignettes(nArray);
                }
            });
        }
        this.logExit("updateCityVignettes");
    }

    public void fireTimer(final Timer timer) {
        this.logEnter("fireTimer");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).fireTimer(timer);
            }
        });
        this.logExit("fireTimer");
    }

    public void ehGetAllCategoriesResult(final int n, final Category[] categoryArray, final int n2) {
        this.logEnter("ehGetAllCategoriesResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).ehGetAllCategoriesResult(n, categoryArray, n2);
            }
        });
        this.logExit("ehGetAllCategoriesResult");
    }

    public void ehGetAllBrandsOfCategoryResult(final int n, final int n2, final Brand[] brandArray, final int n3) {
        this.logEnter("ehGetAllBrandsOfCategoryResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).ehGetAllBrandsOfCategoryResult(n, n2, brandArray, n3);
            }
        });
        this.logExit("ehGetAllBrandsOfCategoryResult");
    }

    public void ehResult(final int n, final int n2) {
        this.logEnter("ehResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).ehResult(n, n2);
            }
        });
        this.logExit("ehResult");
    }

    public void updateCountryInfo(final CountryInfo[] countryInfoArray, int n) {
        this.logEnter("updateCountryInfo");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateCountryInfo(countryInfoArray);
                }
            });
        }
        this.logExit("updateCountryInfo");
    }

    public void updateBapTurnToInfo(final BapTurnToInfo[] bapTurnToInfoArray, int n) {
        this.logEnter("updateBapTurnToInfo");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateBapTurnToInfo(bapTurnToInfoArray);
                }
            });
        }
        this.logExit("updateBapTurnToInfo");
    }

    public void updateRgiString(final short[] sArray, int n) {
        this.logEnter("updateRgiString");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRgiString(sArray);
                }
            });
        }
        this.logExit("updateRgiString");
    }

    public void liGetViaPointListResult(final int n, final ViaPointListElement[] viaPointListElementArray, final int n2, final int n3) {
        this.logEnter("liGetViaPointListResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liGetViaPointListResult(n, viaPointListElementArray, n2, n3);
            }
        });
        this.logExit("liGetViaPointListResult");
    }

    public void liSelectViaPointResult(final NavLocation navLocation, final int n) {
        this.logEnter("liSelectViaPointResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liSelectViaPointResult(navLocation, n);
            }
        });
        this.logExit("liSelectViaPointResult");
    }

    public void requestCountryInfoResult(final CountryInfo countryInfo, final int n) {
        this.logEnter("requestCountryInfoResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).requestCountryInfoResult(countryInfo, n);
            }
        });
        this.logExit("requestCountryInfoResult");
    }

    public void updateStyleDBPaths(final String[] stringArray, int n) {
        this.logEnter("updateStyleDBPaths");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateStyleDBPaths(stringArray);
                }
            });
        }
        this.logExit("updateStyleDBPaths");
    }

    public void updateRouteResumePossible(final boolean bl, int n) {
        this.logEnter("updateRouteResumePossible");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateRouteResumePossible(bl);
                }
            });
        }
        this.logExit("updateRouteResumePossible");
    }

    public void getSpellableCharactersResult(final String string, final String string2, final int n, final String string3, final int n2) {
        this.logEnter("getSpellableCharactersResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).getSpellableCharactersResult(string, string2, n, string3, n2);
            }
        });
        this.logExit("getSpellableCharactersResult");
    }

    public void liGetSpellableCharactersResult(final NavLocation navLocation, final int n, final String string, final int n2) {
        this.logEnter("liGetSpellableCharactersResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liGetSpellableCharactersResult(navLocation, n, string, n2);
            }
        });
        this.logExit("liGetSpellableCharactersResult");
    }

    public void cancelTimer(Timer timer) {
    }

    public void etcGetCountryAbbreviationResult(String string, long l) {
    }

    public void languageSpellableCharactersResult(String string) {
    }

    public void createExportFileResult(int n, boolean bl) {
    }

    public void importFileResult(int n, boolean bl) {
    }

    public void liThesaurusHistoryAddResult(int n, int n2) {
    }

    public void liThesaurusHistoryGetEntryResult(ThesaurusHistoryEntry thesaurusHistoryEntry, int n) {
    }

    public void liThesaurusHistoryDeleteResult(int n, int n2) {
    }

    public void liThesaurusHistoryDeleteAllResult(int n) {
    }

    public void updateLIThesaurusHistory(ThesaurusHistoryEntry[] thesaurusHistoryEntryArray, int n) {
    }

    public void setRemainingRangeOfVehicleResult(int n) {
    }

    public void setVehicleConsumptionInfoResult(int n) {
    }

    public void setUserDefinedPOIsResult(int n) {
        this.logEnter("setUserDefinedPOIsResult");
        this.logExit("setUserDefinedPOIsResult");
    }

    public void setTrailerStatusResult(int n) {
    }

    public void rgStartGuidanceCalculatedRouteByUIDResult(final NavSegmentID navSegmentID, final int n) {
        this.logEnter("rgStartGuidanceCalculatedRouteByUIDResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).rgStartGuidanceCalculatedRouteByUIDResult(navSegmentID, n);
            }
        });
        this.logExit("rgStartGuidanceCalculatedRouteByUIDResult");
    }

    public void updatePOIsEnteringProximityRange(final NavLocation[] navLocationArray, int n) {
        this.logEnter("updatePOIsEnteringProximityRange");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).updatePOIsEnteringProximityRange(navLocationArray);
            }
        });
        this.logExit("updatePOIsEnteringProximityRange");
    }

    public void updatePOIsInsideProximityRange(NavLocation[] navLocationArray, int n) {
    }

    public void updateEtcAvailablePersonalPOIDataBases(final NavDataBase[] navDataBaseArray, final int n) {
        this.logEnter("updateEtcAvailablePersonalPOIDataBases");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).updateEtcAvailablePersonalPOIDataBases(navDataBaseArray, n);
            }
        });
        this.logExit("updateEtcAvailablePersonalPOIDataBases");
    }

    public void updatePersonalPOISearchStatus(final int n, final int n2) {
        this.logEnter("updatePersonalPOISearchStatus");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).updatePersonalPOISearchStatus(n, n2);
            }
        });
        this.logExit("updatePersonalPOISearchStatus");
    }

    public void deletePersonalPOIDataBasesResult(final int n) {
        this.logEnter("deletePersonalPOIDataBasesResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).deletePersonalPOIDataBasesResult(n);
            }
        });
        this.logExit("deletePersonalPOIDataBasesResult");
    }

    public void createNavLocationOfPOIUIDResult(long l, NavLocation navLocation, int n) {
        this.logChannel.log(100000, "%1#createNavLocationOfPOIUIDResult() - unexpected call!", (Object)this.listenerName);
    }

    public void setVehicleFuelTypeResult(int n, int n2) {
        this.logChannel.log(100000, "%1#setVehicleFuelTypeResult() - unexpected call!", (Object)this.listenerName);
    }

    public void updateLiStateHistory(final LIStateHistoryEntry[] lIStateHistoryEntryArray, int n) {
        this.logEnter("updateLiStateHistory");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateLiStateHistory(lIStateHistoryEntryArray);
                }
            });
        }
        this.logExit("updateLiStateHistory");
    }

    public void liHistoryResult(final int n) {
        this.logEnter("liHistoryResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liHistoryResult(n);
            }
        });
        this.logExit("liHistoryResult");
    }

    public void liGetLastStateHistoryEntryResult(final NavLocation navLocation, final boolean bl) {
        this.logEnter("liGetLastStateHistoryEntryResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liGetLastStateHistoryEntryResult(navLocation, bl);
            }
        });
        this.logExit("liGetLastStateHistoryEntryResult");
    }

    public void setNavInternalDataToFactorySettingsResult(int n) {
        this.logChannel.log(100000, "%1#setNavInternalDataToFactorySettingsResult() - unexpected call!", (Object)this.listenerName);
    }

    public void rgSwitchToNextPossibleRoadResult(final boolean bl) {
        this.logEnter("rgSwitchToNextPossibleRoadResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).rgSwitchToNextPossibleRoadResult(bl);
            }
        });
        this.logExit("rgSwitchToNextPossibleRoadResult");
    }

    public void blockAreaResult(final long l, final int n) {
        this.logEnter("blockAreaResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).blockAreaResult(l, n);
            }
        });
        this.logExit("blockAreaResult");
    }

    public void blockRoadSegmentsResult(final long l, final int n) {
        this.logEnter("blockRoadSegmentsResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).blockRoadSegmentsResult(l, n);
            }
        });
        this.logExit("blockRoadSegmentsResult");
    }

    public void blockRouteBasedOnLengthResult(final long l, final int n) {
        this.logEnter("blockRouteBasedOnLengthResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).blockRouteBasedOnLengthResult(l, n);
            }
        });
        this.logExit("blockRouteBasedOnLengthResult");
    }

    public void blockRouteSegmentsResult(final long l, final int n) {
        this.logEnter("blockRouteSegmentsResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).blockRouteSegmentsResult(l, n);
            }
        });
        this.logExit("blockRouteSegmentsResult");
    }

    public void deleteBlockResult(final long[] lArray, final int n) {
        this.logEnter("deleteBlockResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).deleteBlockResult(lArray, n);
            }
        });
        this.logExit("deleteBlockResult");
    }

    public void persistBlockResult(final long[] lArray, final int n) {
        this.logEnter("persistBlockResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).persistBlockResult(lArray, n);
            }
        });
        this.logExit("persistBlockResult");
    }

    public void setBlockDescriptionResult(final long[] lArray, final int n) {
        this.logEnter("setBlockDescriptionResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).setBlockDescriptionResult(lArray, n);
            }
        });
        this.logExit("setBlockDescriptionResult");
    }

    public void updateListOfBlocks(final BlockElement[] blockElementArray, int n) {
        this.logEnter("updateListOfBlocks");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateListOfBlocks(blockElementArray);
                }
            });
        }
        this.logExit("updateListOfBlocks");
    }

    public void updateMaximumDimensionsOfBlockedArea(int n, int n2, int n3) {
        this.logChannel.log(100000, "%1#updateMaximumDimensionsOfBlockedArea() - unexpected call!", (Object)this.listenerName);
    }

    public void updateMaximumLengthOfBlockRouteBasedOnLength(final int n, int n2) {
        this.logEnter("updateMaximumLengthOfBlockRouteBasedOnLength");
        if (n2 == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateMaximumLengthOfBlockRouteBasedOnLength(n);
                }
            });
        }
        this.logExit("updateMaximumLengthOfBlockRouteBasedOnLength");
    }

    public void updateMaximumNumberOfBlockedAreas(int n, int n2) {
        this.logChannel.log(100000, "%1#updateMaximumNumberOfBlockedAreas() - unexpected call!", (Object)this.listenerName);
    }

    public void updateMaximumNumberOfBlockedRoadSegments(int n, int n2) {
        this.logChannel.log(100000, "%1#updateMaximumNumberOfBlockedRoadSegments() - unexpected call!", (Object)this.listenerName);
    }

    public void updateMaximumNumberOfBlockedRouteSegments(int n, int n2) {
        this.logChannel.log(100000, "%1#updateMaximumNumberOfBlockedRouteSegments() - unexpected call!", (Object)this.listenerName);
    }

    public void updateMaximumSegmentLengthOfBlockedRouteSegment(int n, int n2) {
        this.logChannel.log(100000, "%1#updateMaximumSegmentLengthOfBlockedRouteSegment() - unexpected call!", (Object)this.listenerName);
    }

    public void updateNaviCoreAvailableToSetBlocks(final int n, int n2) {
        this.logEnter("updateNaviCoreAvailableToSetBlocks");
        if (n2 == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateNaviCoreAvailableToSetBlocks(n);
                }
            });
        }
        this.logExit("updateNaviCoreAvailableToSetBlocks");
    }

    public void combinedRouteListResult(final long l, final CombinedRouteListElement[] combinedRouteListElementArray, final int n) {
        this.logEnter("combinedRouteListResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).combinedRouteListResult(l, combinedRouteListElementArray, n);
            }
        });
        this.logExit("combinedRouteListResult");
    }

    public void poiInformationResult(final NavPoiInfo navPoiInfo, final int n) {
        this.logEnter("poiInformationResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).poiInformationResult(navPoiInfo, n);
            }
        });
        this.logExit("poiInformationResult");
    }

    public void trafficInformationResult(TmcMessage tmcMessage, int n) {
        this.logChannel.log(100000, "%1#trafficInformationResult() - unexpected call!", (Object)this.listenerName);
    }

    public void updateElementsTotal(final long l, final long l2, final int n) {
        this.logEnter("updateElementsTotal");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).updateElementsTotal(l, l2, n);
            }
        });
        this.logExit("updateElementsTotal");
    }

    public void windowChanged(final int n) {
        this.logEnter("windowChanged");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).windowChanged(n);
            }
        });
        this.logExit("windowChanged");
    }

    public void updateNavDbRegionsState(final int n, final String[] stringArray, final int n2) {
        this.logEnter("updateNavDbRegionsState");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).updateNavDbRegionsState(n, stringArray, n2);
            }
        });
        this.logExit("updateNavDbRegionsState");
    }

    public void getBoundingRectangleOfCombinedRouteListElementsResult(final long[] lArray, final NavRectangle navRectangle) {
        this.logEnter("getBoundingRectangleOfCombinedRouteListElementsResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).getBoundingRectangleOfCombinedRouteListElementsResult(lArray, navRectangle);
            }
        });
        this.logExit("getBoundingRectangleOfCombinedRouteListElementsResult");
    }

    public void getBoundingRectangleOfBlocksResult(long[] lArray, NavRectangle navRectangle) {
        this.logChannel.log(100000, "%1#getBoundingRectangleOfBlocksResult() - unexpected call!", (Object)this.listenerName);
    }

    public void trImportTrailsResult(final NavSegmentID[] navSegmentIDArray, final int n) {
        this.logEnter("trImportTrailsResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).trImportTrailsResult(navSegmentIDArray, n);
            }
        });
        this.logExit("trImportTrailsResult");
    }

    public void trExportTrailsResult(final int n) {
        this.logEnter("trExportTrailsResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).trExportTrailsResult(n);
            }
        });
        this.logExit("trExportTrailsResult");
    }

    public void updateTrInfoForNextWaypoint(final NavNextWayPointInfo navNextWayPointInfo, int n) {
        this.logEnter("updateTrInfoForNextWaypoint");
        if (n == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateTrInfoForNextWaypoint(navNextWayPointInfo);
                }
            });
        }
        this.logExit("updateTrInfoForNextWaypoint");
    }

    public void rgStartRubberbandManipulationResult(final int n) {
        this.logEnter("rgStartRubberbandManipulationResult");
        if (n == 0) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).rgStartRubberbandManipulationResult(n);
                }
            });
        }
        this.logExit("rgStartRubberbandManipulationResult");
    }

    public void rgGetRouteBoundingRectangleResult(final NavRectangle navRectangle, int n) {
        this.logEnter("rgGetRouteBoundingRectangleResult");
        if (n == 0) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).rgGetRouteBoundingRectangleResult(navRectangle);
                }
            });
        }
        this.logExit("rgGetRouteBoundingRectangleResult");
    }

    public void rgGetLocationOnRouteResult(final NavLocation navLocation, int n) {
        this.logEnter("rgGetLocationOnRouteResult");
        if (n == 0) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).rgGetLocationOnRouteResult(navLocation);
                }
            });
        }
        this.logExit("rgGetLocationOnRouteResult");
    }

    public void rgResult(final int n) {
        this.logEnter("rgResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).rgResult(n);
            }
        });
        this.logExit("rgResult");
    }

    public void updateRgEnhancedSignPostInfoStatus(boolean bl, int n) {
        this.logChannel.log(100000, "%1#updateRgEnhancedSignPostInfoStatus", (Object)this.listenerName);
    }

    public void updateSoPosTimeInformation(PosTimeInfo posTimeInfo, int n) {
        this.logChannel.log(100000, "%1#updateSoPosTimeInformation", (Object)this.listenerName);
    }

    public void rgGetRubberBandPointPositionResult(final NavLocationWgs84 navLocationWgs84, final boolean bl, int n) {
        this.logEnter("rgGetRubberBandPointPositionResult");
        if (n == 0) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).rgGetRubberBandPointPositionResult(navLocationWgs84, bl);
                }
            });
        }
        this.logExit("rgGetRubberBandPointPositionResult");
    }

    public void lispGetMatchingNVCResult(final String string) {
        this.logEnter("lispGetMatchingNVCResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).lispGetMatchingNVCResult(string);
            }
        });
        this.logExit("lispGetMatchingNVCResult");
    }

    public void etcSetDemoModeResult(int n) {
    }

    public void lispGetLocationFromLiValueListResult(final int n, final NavLocation navLocation) {
        this.logEnter("lispGetLocationFromLiValueListResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).lispGetLocationFromLiValueListResult(n, navLocation);
            }
        });
        this.logExit("lispGetLocationFromLiValueListResult");
    }

    public void poiGetXt9LDBsResult(final String[] stringArray) {
        this.logEnter("poiGetXt9LDBsResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).poiGetXt9LDBsResult(stringArray);
            }
        });
        this.logExit("poiGetXt9LDBsResult");
    }

    public void updateRgMotorwayInfo(NavPoiInfo[] navPoiInfoArray, int n) {
    }

    public void updateRgVirtualDestinationInfo(RgInfoForNextDestination rgInfoForNextDestination, int n) {
    }

    public void rgTriggerRCCIUpdateResult(int n) {
    }

    public void liGetLocationDescriptionTransformNearByResult(final NavLocation navLocation) {
        this.logEnter("liGetLocationDescriptionTransformNearByResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liGetLocationDescriptionTransformNearByResult(navLocation);
            }
        });
        this.logExit("liGetLocationDescriptionTransformNearByResult");
    }

    public void updateRgTurnToInfo(RgTurnToInfo rgTurnToInfo, int n) {
    }

    public void etcGetPositionTimeInfoResult(PosTimeInfo posTimeInfo, int n) {
    }

    public void poiGetCategoryTypesFromUIdResult(final int[] nArray) {
        this.logEnter("poiGetCategoryTypesFromUIdResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).poiGetCategoryTypesFromUIdResult(nArray);
            }
        });
        this.logExit("poiGetCategoryTypesFromUIdResult");
    }

    public void updateRgPersistedRouteDataAvailable(boolean bl, int n) {
    }

    public void liDisambiguateLocationResult(final int[] nArray, final NavLocation[] navLocationArray) {
        this.logEnter("liDisambiguateLocationResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).liDisambiguateLocationResult(nArray, navLocationArray);
            }
        });
        this.logExit("liDisambiguateLocationResult");
    }

    public void requestPriceInfoResult(NavPriceInfo navPriceInfo, int n) {
    }

    public void triggerEventAudioMessageResult(final int n) {
        this.logEnter("triggerEventAudioMessageResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).triggerEventAudioMessageResult(n);
            }
        });
        this.logExit("triggerEventAudioMessageResult");
    }

    public void lispRequestNVCListResult(final int n, final String string, final int n2) {
        this.logEnter("lispRequestNVCListResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).lispRequestNVCListResult(n, string, n2);
            }
        });
        this.logExit("lispRequestNVCListResult");
    }

    public void updateMapIntegrationState(final int n, int n2) {
        this.logEnter("updateMapIntegrationState");
        if (1 == n2) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateMapIntegrationState(n);
                }
            });
        }
        this.logExit("updateMapIntegrationState");
    }

    public void deleteSatelliteCacheResult(int n) {
    }

    public void updateMapIntegrationProgress(int n, int n2) {
    }

    public void etcTriggerNavigationRestartResult(int n, int n2) {
    }

    public void updateBapManeuverState(final int n, int n2) {
        this.logEnter("updateBapManeuverState");
        if (n2 == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateBapManeuverState(n);
                }
            });
        }
        this.logExit("updateBapManeuverState");
    }

    public void rmImportToursFromGpxFileResult(int n) {
    }

    public void updateRmImportToursFromGpxFileStatus(TourImportStatus tourImportStatus, int n) {
    }

    public void importRouteFromGpxFileResult(final NavLocation navLocation) {
        this.logEnter("importRouteFromGpxFileResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).importRouteFromGpxFileResult(navLocation);
            }
        });
        this.logExit("importRouteFromGpxFileResult");
    }

    public void updateBapManeuverInformation(final BapManeuverDescriptor[] bapManeuverDescriptorArray, final int n, int n2) {
        this.logEnter("updateBapManeuverInformation");
        if (n2 == 1) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((IDSINavigationHandler)dSIListener).updateBapManeuverInformation(bapManeuverDescriptorArray, n);
                }
            });
        }
        this.logExit("updateBapManeuverInformation");
    }

    public void poiRequestExtendedInfoResult(final PoiExtendedInfo poiExtendedInfo, final boolean bl) {
        this.logEnter("poiRequestExtendedInfoResult");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((IDSINavigationHandler)dSIListener).poiRequestExtendedInfoResult(poiExtendedInfo, bl);
            }
        });
        this.logExit("poiRequestExtendedInfoResult");
    }

    public void trClearRecordedTraceCacheResult() {
    }

    public void updateProfileState(int n, int n2, int n3) {
    }

    public void profileChanged(int n, int n2) {
    }

    public void profileCopied(int n, int n2, int n3) {
    }

    public void profileReset(int n, int n2) {
    }

    public void profileResetAll(int n) {
    }
}

