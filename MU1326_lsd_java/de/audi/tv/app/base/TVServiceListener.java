/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.media.IMediaDrawerContext;
import de.audi.atip.interapp.tv.ITVService;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.ISourceChanger;
import de.audi.tv.app.audio.AudioFocusClient;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVServiceListener$1;
import de.audi.tv.app.base.TVServiceListener$2;
import de.audi.tv.app.base.TVServiceListener$CallListener;
import de.audi.tv.app.base.TVServiceListener$ContextListener;
import de.audi.tv.app.base.TVServiceListener$TVEventListener;
import de.audi.tv.app.base.TVServiceListener$TVListener;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.lists.DefaultTVListsListener;
import de.audi.tv.app.lists.FocusHandler;
import java.util.ArrayList;

public class TVServiceListener
extends DefaultTVListsListener
implements ITVService {
    private IMediaDrawerContext drawerContext = null;
    private final LogChannel log;
    private final FocusHandler focusHandler;
    private final ISourceChanger sourceManager;
    private final AudioFocusClient audioFocusClient;
    private boolean tvIsActive = false;
    private final Object mutex = new Object();
    private volatile boolean isFavoritesActive = false;
    private int lastSource = 0;
    private final TVServiceListener$ContextListener contextListener = new TVServiceListener$ContextListener(this, null);
    final DSICallListener callListener = new TVServiceListener$CallListener(this, null);
    final DefaultTVListener tvListener = new TVServiceListener$TVListener(this, null);
    final ITVEventListener tvStatusListener = new TVServiceListener$TVEventListener(this, null);
    private DSIHandler dsiHandler;

    public TVServiceListener(LogChannel logChannel, FocusHandler focusHandler, ISourceChanger iSourceChanger, AudioFocusClient audioFocusClient, DSIHandler dSIHandler) {
        this.log = logChannel;
        this.focusHandler = focusHandler;
        this.sourceManager = iSourceChanger;
        this.audioFocusClient = audioFocusClient;
        this.dsiHandler = dSIHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void activate(int n, IMediaDrawerContext iMediaDrawerContext) {
        this.log.log(1078071040, "[TVServiceListener.activate] isTvIsActive:%1 ,activating source: %2", this.tvIsActive, (long)n);
        Object object = this.mutex;
        synchronized (object) {
            this.drawerContext = iMediaDrawerContext;
            if (this.tvIsActive) {
                this.sourceManager.switchSource(n == 0 ? 0 : 1, true);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void deactivate() {
        this.log.log(1078071040, "[TVServiceListener.deactivate] deactivating TV");
        Object object = this.mutex;
        synchronized (object) {
            if (this.drawerContext != null && this.tvIsActive) {
                this.drawerContext.setDrawerElements(new ArrayList(0), null);
            }
            this.drawerContext = null;
        }
    }

    private void sendSubList(int n) {
        if (this.drawerContext == null) {
            this.log.log(-2137614336, "[TVServiceListener.sendSubList] will not send sub list because drawer context is null.");
            return;
        }
        ArrayList arrayList = new ArrayList(2);
        int n2 = this.focusHandler.getFocusedListId();
        this.lastSource = n;
        if (n == 0) {
            if (!this.focusHandler.isFavoritesEmpty()) {
                this.isFavoritesActive = true;
                arrayList.add(new TVServiceListener$1(this, n2));
            } else {
                this.isFavoritesActive = false;
            }
            arrayList.add(new TVServiceListener$2(this, n2));
            this.drawerContext.setDrawerElements(arrayList, this.contextListener);
        } else {
            this.drawerContext.setDrawerElements(arrayList, null);
        }
        int n3 = arrayList.size();
        this.log.log(-2137614336, "[TVServiceListener.sendSubList] sending sub elements for source %2 -> %1, list: %3", (long)n3, (long)n, (long)n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateFavoritesListSize(int n) {
        boolean bl;
        boolean bl2 = bl = n == 0;
        if (bl == this.isFavoritesActive) {
            Object object = this.mutex;
            synchronized (object) {
                this.sendSubList(this.lastSource);
            }
        }
    }

    static /* synthetic */ FocusHandler access$400(TVServiceListener tVServiceListener) {
        return tVServiceListener.focusHandler;
    }

    static /* synthetic */ Object access$500(TVServiceListener tVServiceListener) {
        return tVServiceListener.mutex;
    }

    static /* synthetic */ int access$600(TVServiceListener tVServiceListener) {
        return tVServiceListener.lastSource;
    }

    static /* synthetic */ void access$700(TVServiceListener tVServiceListener, int n) {
        tVServiceListener.sendSubList(n);
    }

    static /* synthetic */ boolean access$802(TVServiceListener tVServiceListener, boolean bl) {
        tVServiceListener.tvIsActive = bl;
        return tVServiceListener.tvIsActive;
    }

    static /* synthetic */ boolean access$800(TVServiceListener tVServiceListener) {
        return tVServiceListener.tvIsActive;
    }
}

