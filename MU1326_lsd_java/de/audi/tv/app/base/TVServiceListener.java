/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.media.IMediaDrawerContext;
import de.audi.atip.interapp.media.IMediaDrawerContextListener;
import de.audi.atip.interapp.media.IMediaDrawerElement;
import de.audi.atip.interapp.tv.ITVService;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.ISourceChanger;
import de.audi.tv.app.audio.AudioFocusClient;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEventDefaultListener;
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
    private final ContextListener contextListener = new ContextListener();
    final DSICallListener callListener = new CallListener();
    final DefaultTVListener tvListener = new TVListener();
    final ITVEventListener tvStatusListener = new TVEventListener();
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
    public void activate(int n, IMediaDrawerContext iMediaDrawerContext) {
        this.log.log(1000000, "[TVServiceListener.activate] isTvIsActive:%1 ,activating source: %2", this.tvIsActive, (long)n);
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
    public void deactivate() {
        this.log.log(1000000, "[TVServiceListener.deactivate] deactivating TV");
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
            this.log.log(10000000, "[TVServiceListener.sendSubList] will not send sub list because drawer context is null.");
            return;
        }
        ArrayList arrayList = new ArrayList(2);
        final int n2 = this.focusHandler.getFocusedListId();
        this.lastSource = n;
        if (n == 0) {
            if (!this.focusHandler.isFavoritesEmpty()) {
                this.isFavoritesActive = true;
                arrayList.add(new IMediaDrawerElement(){

                    public String getName() {
                        return "favorites";
                    }

                    public int getIconID() {
                        return 0;
                    }

                    public int getID() {
                        return 1;
                    }

                    public boolean isSelected() {
                        return n2 == 1;
                    }

                    public boolean isFocused() {
                        return n2 == 1;
                    }
                });
            } else {
                this.isFavoritesActive = false;
            }
            arrayList.add(new IMediaDrawerElement(){

                public String getName() {
                    return "stations";
                }

                public int getIconID() {
                    return 0;
                }

                public int getID() {
                    return 0;
                }

                public boolean isSelected() {
                    return n2 == 0;
                }

                public boolean isFocused() {
                    return n2 == 0;
                }
            });
            this.drawerContext.setDrawerElements(arrayList, this.contextListener);
        } else {
            this.drawerContext.setDrawerElements(arrayList, null);
        }
        int n3 = arrayList.size();
        this.log.log(10000000, "[TVServiceListener.sendSubList] sending sub elements for source %2 -> %1, list: %3", (long)n3, (long)n, (long)n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
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

    private class TVListener
    extends DefaultTVListener {
        private TVListener() {
        }

        public void updateSelectedSource(int n) {
            TVServiceListener.this.sendSubList(n == 0 ? 0 : 1);
        }
    }

    private class CallListener
    extends DSICallListener {
        private CallListener() {
        }

        public void switchSource(int n, boolean bl) {
            TVServiceListener.this.sendSubList(n == 0 ? 0 : 1);
        }
    }

    private class ContextListener
    implements IMediaDrawerContextListener {
        private ContextListener() {
        }

        public void drawerElementSelected(IMediaDrawerElement iMediaDrawerElement) {
            TVServiceListener.this.focusHandler.changeFocus(iMediaDrawerElement.getID());
        }
    }

    private class TVEventListener
    extends TVEventDefaultListener {
        private TVEventListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onTunerAvailable() {
            Object object = TVServiceListener.this.mutex;
            synchronized (object) {
                TVServiceListener.this.sendSubList(TVServiceListener.this.lastSource);
                TVServiceListener.this.tvIsActive = true;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onTunerUnavailable() {
            Object object = TVServiceListener.this.mutex;
            synchronized (object) {
                TVServiceListener.this.deactivate();
                TVServiceListener.this.tvIsActive = false;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onFocusedListChanged(int n) {
            Object object = TVServiceListener.this.mutex;
            synchronized (object) {
                if (TVServiceListener.this.tvIsActive) {
                    TVServiceListener.this.sendSubList(TVServiceListener.this.lastSource);
                }
            }
        }
    }
}

