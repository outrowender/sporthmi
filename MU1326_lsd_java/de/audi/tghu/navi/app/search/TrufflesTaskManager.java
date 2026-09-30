/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.Distance;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultNavLocationExtractor;
import de.audi.tghu.navi.app.search.AbstractNaviGuiSearchHandler;
import de.audi.tghu.navi.app.search.IntelliDestDistanceRow;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.Job;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.search.SearchResult;

public class TrufflesTaskManager {
    public static final int FLUSH_BUFFER_JOBS = 0;
    public static final int CURSOR_FOCUS_JOBS = 1;
    private final BaseListModelApp listModel;
    private final Object lock;
    private final AbstractNaviGuiSearchHandler guiSearchHandler;
    private final SearchResultNavLocationExtractor searchResultNavLocationExtractor;
    private final IVehicle vehicle;
    private final DispatcherBase dispatcher;
    private final LogChannel logger;
    private List flushBufferJobs = new ArrayList();
    private List cursorFocusJobs = new ArrayList();
    private Job focusPreviewMapJob;

    public TrufflesTaskManager(BaseListModelApp baseListModelApp, Object object, IVehicle iVehicle, SearchResultNavLocationExtractor searchResultNavLocationExtractor, DispatcherBase dispatcherBase, LogChannel logChannel, AbstractNaviGuiSearchHandler abstractNaviGuiSearchHandler) {
        this.listModel = baseListModelApp;
        this.lock = object;
        this.vehicle = iVehicle;
        this.searchResultNavLocationExtractor = searchResultNavLocationExtractor;
        this.dispatcher = dispatcherBase;
        this.logger = logChannel;
        this.guiSearchHandler = abstractNaviGuiSearchHandler;
    }

    public void resolveCoordinates(List list, int n) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            EvoListRow evoListRow = (EvoListRow)iterator.next();
            if (evoListRow instanceof IntelliDestDistanceRow && !((IntelliDestDistanceRow)((Object)evoListRow)).hasGeoCoordinates() && ((SearchResultListRow)evoListRow).getNodeType() == 0) {
                if (this.logger.isDebug2()) {
                    this.logger.log(100000000, "TrufflesTaskManager#resolveCoordinates add a new %1 job", (long)n);
                }
                if (n == 0) {
                    this.flushBufferJobs.add(this.dispatcher.execute(new ResolveNavLocationTask(evoListRow)));
                    continue;
                }
                this.cursorFocusJobs.add(this.dispatcher.execute(new ResolveNavLocationTask(evoListRow)));
                continue;
            }
            if (!this.logger.isDebug2()) continue;
            this.logger.log(100000000, "TrufflesTaskManager#resolveCoordinates row does not need resolving");
        }
    }

    public void focusPreviewMap(EvoListRow evoListRow) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "TrufflesTaskManager#focusPreviewMap %1", (Object)evoListRow);
        }
        if (this.focusPreviewMapJob != null) {
            if (this.logger.isDebug2()) {
                this.logger.log(100000000, "TrufflesTaskManager#focusPreviewMap cancel job %1", (Object)evoListRow);
            }
            this.focusPreviewMapJob.cancel();
        }
        this.focusPreviewMapJob = this.dispatcher.execute(new FocusPreviewMapTask(evoListRow));
    }

    public void cancelAllJobs() {
        this.cancelCursorFocusJobs();
        this.cancelFlushBufferJobs();
        this.cancelFocusPreviewMapJob();
    }

    public void cancelFocusPreviewMapJob() {
        if (this.focusPreviewMapJob != null) {
            this.focusPreviewMapJob.cancel();
        }
    }

    public void cancelCursorFocusJobs() {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "TrufflesTaskManager#cancelCursorFocusJobs aborting %1 jobs", (long)this.cursorFocusJobs.size());
        }
        Iterator iterator = this.cursorFocusJobs.iterator();
        while (iterator.hasNext()) {
            Job job = (Job)iterator.next();
            job.cancel();
        }
        this.cursorFocusJobs.clear();
    }

    public void cancelFlushBufferJobs() {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "TrufflesTaskManager#cancelFlushBufferJobs aborting %1 jobs", (long)this.flushBufferJobs.size());
        }
        Iterator iterator = this.flushBufferJobs.iterator();
        while (iterator.hasNext()) {
            Job job = (Job)iterator.next();
            job.cancel();
        }
        this.flushBufferJobs.clear();
    }

    private class FocusPreviewMapTask
    implements Runnable {
        private final EvoListRow row;

        private FocusPreviewMapTask(EvoListRow evoListRow) {
            this.row = evoListRow;
        }

        public void run() {
            NavLocation navLocation = null;
            if (this.row instanceof SearchResultListRow && ((SearchResultListRow)this.row).getNodeType() == 1) {
                TrufflesTaskManager.this.guiSearchHandler.hidePreviewMap();
            } else if (this.row instanceof SearchResultListRow && ((SearchResultListRow)this.row).getSearchResult().entryType == 2) {
                navLocation = TrufflesTaskManager.this.guiSearchHandler.extractNavLocationFromRow(this.row);
                if (navLocation != null && navLocation.isPositionValid()) {
                    TrufflesTaskManager.this.guiSearchHandler.focusPreviewMapOnPOIs(new NavLocation[]{navLocation});
                } else {
                    TrufflesTaskManager.this.logger.log(100000, "FocusPreviewMapTask#itemFocused # hidePreviewMap due to location: %1", (Object)navLocation);
                    TrufflesTaskManager.this.guiSearchHandler.hidePreviewMap();
                }
            } else if (this.row instanceof SearchResultListRow && (((SearchResultListRow)this.row).getSearchResult().entryType == 16 || ((SearchResultListRow)this.row).getSearchResult().entryType == 64)) {
                navLocation = TrufflesTaskManager.this.guiSearchHandler.extractNavLocationFromRow(this.row);
                if (navLocation != null && navLocation.isPositionValid()) {
                    TrufflesTaskManager.this.guiSearchHandler.focusPreviewMapOnCity(navLocation);
                } else {
                    TrufflesTaskManager.this.logger.log(100000, "FocusPreviewMapTask#itemFocused # hidePreviewMap due to location: %1", (Object)navLocation);
                    TrufflesTaskManager.this.guiSearchHandler.hidePreviewMap();
                }
            } else if (this.row instanceof SearchResultListRow && ((SearchResultListRow)this.row).getSearchResult().source == 4) {
                SearchResult searchResult = ((SearchResultListRow)this.row).getSearchResult();
                navLocation = TrufflesTaskManager.this.guiSearchHandler.getNavLocationFromTrufflesCoord(searchResult.position.lon, searchResult.position.lat);
                TrufflesTaskManager.this.guiSearchHandler.focusPreviewMapOnNavLocation(navLocation, false);
            } else {
                navLocation = TrufflesTaskManager.this.guiSearchHandler.extractNavLocationFromRow(this.row);
                if (navLocation != null && navLocation.isPositionValid()) {
                    if (this.row instanceof SearchResultListRow && ((SearchResultListRow)this.row).getSearchResult().source == 5) {
                        TrufflesTaskManager.this.guiSearchHandler.focusPreviewMapOnNavLocation(navLocation, true);
                    } else {
                        TrufflesTaskManager.this.guiSearchHandler.focusPreviewMapOnNavLocation(navLocation, false);
                    }
                } else {
                    TrufflesTaskManager.this.logger.log(10000000, "FocusPreviewMapTask#itemFocused # hidePreviewMap due to location: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
                    TrufflesTaskManager.this.guiSearchHandler.hidePreviewMap();
                }
            }
            TrufflesTaskManager.this.guiSearchHandler.handleIfPoiIsCallable(navLocation, this.row);
        }
    }

    private class ResolveNavLocationTask
    implements Runnable {
        private final EvoListRow row;

        private ResolveNavLocationTask(EvoListRow evoListRow) {
            this.row = evoListRow;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void run() {
            NavLocation navLocation;
            if (TrufflesTaskManager.this.logger.isDebug2()) {
                TrufflesTaskManager.this.logger.log(100000000, "ResolveNavLocationTask#run %1", (Object)this.row);
            }
            if (null == (navLocation = TrufflesTaskManager.this.searchResultNavLocationExtractor.extractNavLocationFromRow(this.row)) || !navLocation.isPositionValid()) {
                return;
            }
            PosPosition posPosition = TrufflesTaskManager.this.vehicle.getPosition();
            int n = ((SearchResultListRow)this.row).getSearchResult().listPosition;
            IntelliDestDistanceRow intelliDestDistanceRow = (IntelliDestDistanceRow)((Object)this.row);
            intelliDestDistanceRow.setLatitude(navLocation.latitude);
            intelliDestDistanceRow.setLongitude(navLocation.longitude);
            intelliDestDistanceRow.setHasGeoCoordinates(true);
            int n2 = Util.computeAbsoluteDirection(posPosition, intelliDestDistanceRow.getLongitude(), intelliDestDistanceRow.getLatitude());
            int n3 = Util.convertRotatingDirection(n2, posPosition.directionAngle);
            intelliDestDistanceRow.setArrowColumn(n3);
            int n4 = Util.computeAirDistance(posPosition.getLongitude(), posPosition.getLatitude(), intelliDestDistanceRow.getLongitude(), intelliDestDistanceRow.getLatitude());
            intelliDestDistanceRow.setDistanceColumn(new Distance(n4, 5));
            intelliDestDistanceRow.setLayoutWithDirection();
            Object object = TrufflesTaskManager.this.lock;
            synchronized (object) {
                EvoListRow evoListRow = TrufflesTaskManager.this.listModel.getRow(n);
                if (evoListRow != null && evoListRow.equals(this.row)) {
                    TrufflesTaskManager.this.listModel.setRow(n, this.row);
                }
            }
        }
    }
}

