/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultNavLocationExtractor;
import de.audi.tghu.navi.app.search.AbstractNaviGuiSearchHandler;
import de.audi.tghu.navi.app.search.IntelliDestDistanceRow;
import de.audi.tghu.navi.app.search.TrufflesTaskManager$FocusPreviewMapTask;
import de.audi.tghu.navi.app.search.TrufflesTaskManager$ResolveNavLocationTask;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.Job;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TrufflesTaskManager {
    public static final int FLUSH_BUFFER_JOBS;
    public static final int CURSOR_FOCUS_JOBS;
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
                    this.logger.log(14808325, "TrufflesTaskManager#resolveCoordinates add a new %1 job", (long)n);
                }
                if (n == 0) {
                    this.flushBufferJobs.add(this.dispatcher.execute(new TrufflesTaskManager$ResolveNavLocationTask(this, evoListRow, null)));
                    continue;
                }
                this.cursorFocusJobs.add(this.dispatcher.execute(new TrufflesTaskManager$ResolveNavLocationTask(this, evoListRow, null)));
                continue;
            }
            if (!this.logger.isDebug2()) continue;
            this.logger.log(14808325, "TrufflesTaskManager#resolveCoordinates row does not need resolving");
        }
    }

    public void focusPreviewMap(EvoListRow evoListRow) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "TrufflesTaskManager#focusPreviewMap %1", (Object)evoListRow);
        }
        if (this.focusPreviewMapJob != null) {
            if (this.logger.isDebug2()) {
                this.logger.log(14808325, "TrufflesTaskManager#focusPreviewMap cancel job %1", (Object)evoListRow);
            }
            this.focusPreviewMapJob.cancel();
        }
        this.focusPreviewMapJob = this.dispatcher.execute(new TrufflesTaskManager$FocusPreviewMapTask(this, evoListRow, null));
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
            this.logger.log(14808325, "TrufflesTaskManager#cancelCursorFocusJobs aborting %1 jobs", (long)this.cursorFocusJobs.size());
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
            this.logger.log(14808325, "TrufflesTaskManager#cancelFlushBufferJobs aborting %1 jobs", (long)this.flushBufferJobs.size());
        }
        Iterator iterator = this.flushBufferJobs.iterator();
        while (iterator.hasNext()) {
            Job job = (Job)iterator.next();
            job.cancel();
        }
        this.flushBufferJobs.clear();
    }

    static /* synthetic */ LogChannel access$200(TrufflesTaskManager trufflesTaskManager) {
        return trufflesTaskManager.logger;
    }

    static /* synthetic */ SearchResultNavLocationExtractor access$300(TrufflesTaskManager trufflesTaskManager) {
        return trufflesTaskManager.searchResultNavLocationExtractor;
    }

    static /* synthetic */ IVehicle access$400(TrufflesTaskManager trufflesTaskManager) {
        return trufflesTaskManager.vehicle;
    }

    static /* synthetic */ Object access$500(TrufflesTaskManager trufflesTaskManager) {
        return trufflesTaskManager.lock;
    }

    static /* synthetic */ BaseListModelApp access$600(TrufflesTaskManager trufflesTaskManager) {
        return trufflesTaskManager.listModel;
    }

    static /* synthetic */ AbstractNaviGuiSearchHandler access$700(TrufflesTaskManager trufflesTaskManager) {
        return trufflesTaskManager.guiSearchHandler;
    }
}

