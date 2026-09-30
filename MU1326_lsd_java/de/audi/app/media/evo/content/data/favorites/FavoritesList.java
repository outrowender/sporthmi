/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites;

import de.audi.app.media.evo.content.data.favorites.MediaFavorite;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.List;

public class FavoritesList {
    private static final String LOGCLASS = "FavoritesList";
    private final LogChannel logger;
    private final List mediaFavorites;
    private final Object listMutex = new Object();
    private ModelTrigger trigger;

    public FavoritesList(LogChannel logChannel, List list) {
        this.logger = logChannel;
        this.mediaFavorites = list;
    }

    public FavoritesList(LogChannel logChannel) {
        this(logChannel, new ArrayList());
    }

    private FavoritesList(FavoritesList favoritesList) {
        this.logger = favoritesList.logger;
        this.trigger = favoritesList.trigger;
        this.mediaFavorites = new ArrayList(favoritesList.mediaFavorites);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean addFavorite(MediaFavorite mediaFavorite) {
        Object object = this.listMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.addFavorite]", (Object)LOGCLASS);
            if (!this.mediaFavorites.contains(mediaFavorite)) {
                this.mediaFavorites.add(mediaFavorite);
                return true;
            }
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeFavorite(MediaFavorite mediaFavorite) {
        Object object = this.listMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.removeFavorite]", (Object)LOGCLASS);
            this.mediaFavorites.remove(mediaFavorite);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateFavorite(MediaFavorite mediaFavorite) {
        Object object = this.listMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.updateFavorite]", (Object)LOGCLASS);
            int n = this.mediaFavorites.indexOf(mediaFavorite);
            if (n >= 0) {
                this.mediaFavorites.set(n, mediaFavorite);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void moveFavorite(int n, int n2) {
        Object object = this.listMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.moveFavorite]", (Object)LOGCLASS);
            this.mediaFavorites.add(n2, this.mediaFavorites.remove(n));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getListSize() {
        int n = 0;
        Object object = this.listMutex;
        synchronized (object) {
            n = this.mediaFavorites.size();
        }
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public MediaFavorite getFavorite(int n) {
        Object object = this.listMutex;
        synchronized (object) {
            return (MediaFavorite)this.mediaFavorites.get(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public List getFavoritesList() {
        Object object = this.listMutex;
        synchronized (object) {
            return new ArrayList(this.mediaFavorites);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public FavoritesList getCopy() {
        Object object = this.listMutex;
        synchronized (object) {
            return new FavoritesList(this);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addTrigger(ModelTrigger modelTrigger) {
        Object object = this.listMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.addTrigger]", (Object)LOGCLASS);
            this.trigger = modelTrigger;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ModelTrigger getAndRemoveTrigger() {
        Object object = this.listMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.getAndRemoveTrigger]", (Object)LOGCLASS);
            ModelTrigger modelTrigger = this.trigger;
            this.trigger = null;
            return modelTrigger;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isTriggerAvailable() {
        Object object = this.listMutex;
        synchronized (object) {
            return this.trigger != null;
        }
    }
}

