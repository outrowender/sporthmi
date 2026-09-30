/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tv.app.lists.favorites.IFavoritesList;
import de.audi.tv.app.storage.TVStorage;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class FavoriteListSaver
implements Runnable {
    private final IFrameworkAccess framework;
    private final IFavoritesList memoryList;
    private final TVStorage storage;
    private boolean saveRequests = false;
    private boolean currentlySaving = false;

    public FavoriteListSaver(IFrameworkAccess iFrameworkAccess, IFavoritesList iFavoritesList, TVStorage tVStorage) {
        this.framework = iFrameworkAccess;
        this.memoryList = iFavoritesList;
        this.storage = tVStorage;
    }

    public void save() {
        this.saveRequests = true;
        if (!this.currentlySaving) {
            this.framework.getUtilThreadPool().execute(this);
        }
    }

    public void run() {
        this.currentlySaving = true;
        Thread.currentThread().setName(Thread.currentThread().getName() + "TV FavoriteList Saver");
        while (this.saveRequests) {
            this.saveRequests = false;
            ServiceInfo[] serviceInfoArray = this.memoryList.getServices();
            ServiceInfo[] serviceInfoArray2 = new ServiceInfo[50];
            System.arraycopy((Object)serviceInfoArray, 0, (Object)serviceInfoArray2, 0, serviceInfoArray.length);
            this.storage.saveFavoriteList(serviceInfoArray2);
        }
        this.currentlySaving = false;
    }
}

