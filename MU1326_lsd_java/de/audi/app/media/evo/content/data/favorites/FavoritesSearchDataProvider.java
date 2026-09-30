/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.evo.content.data.favorites.FavoritesList;
import de.audi.app.media.evo.content.data.favorites.IFavoritesController;
import de.audi.app.media.evo.content.data.favorites.IMediaFavoriteListListener;
import de.audi.app.media.evo.content.data.favorites.MediaFavorite;
import de.audi.app.media.evo.content.data.search.AbstractMediaSearchDataProvider;
import de.audi.app.media.i18n.I18NString;
import de.audi.atip.log.LogChannel;
import java.util.List;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.Searchable;

public class FavoritesSearchDataProvider
extends AbstractMediaSearchDataProvider
implements IMediaFavoriteListListener {
    private static final String LOGCLASS = "FavoritesSearchDataProvider";
    private final LogChannel logger;
    private final IFavoritesController favoritesController;
    private volatile FavoritesList favoritesList;

    public FavoritesSearchDataProvider(IMediaTerminal iMediaTerminal, LogChannel logChannel, IFavoritesController iFavoritesController) {
        super(iMediaTerminal, 20011);
        this.logger = logChannel;
        this.favoritesController = iFavoritesController;
    }

    public void init() {
        super.init();
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.favoritesController.addFavoriteListListener(this);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.favoritesController.removeFavoriteListListener(this);
        super.deinit();
    }

    public void listChanged(FavoritesList favoritesList) {
        this.logger.log(1000000, "[%1.listChanged]", (Object)LOGCLASS);
        this.favoritesList = favoritesList;
        if (this.isActive()) {
            this.sourceDataAvailabilityChanged(true);
            this.invalidateAllData();
        }
    }

    protected void providerSourceActivated() {
        this.logger.log(1000000, "[%1.providerSourceActivated]", (Object)LOGCLASS);
        if (null != this.favoritesList) {
            this.sourceDataAvailabilityChanged(true);
        }
    }

    public void invalidateAllDataResult(boolean bl, int n) {
        this.logger.log(1000000, "[%1.invalidateAllDataResult]", (Object)LOGCLASS);
    }

    public void provideData(int n, int n2, int n3) {
        this.logger.log(1000000, "[%1.provideData] src='%2' offset='%3' len='%4'", (Object)LOGCLASS, (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)Integer.toString(n3));
        DataSet[] dataSetArray = this.createDataSet(this.favoritesList.getFavoritesList(), n2, n3);
        if (this.logger.isDebug()) {
            for (int i2 = 0; i2 < dataSetArray.length; ++i2) {
                this.logger.log(10000000, "[%1.provideData] idx='%2' '%3'", (Object)LOGCLASS, (Object)Integer.toString(i2), (Object)dataSetArray[i2].toString());
            }
        }
        this.storeDataSets(dataSetArray, this.favoritesList.getListSize());
    }

    public void storeDataSetsResult(boolean bl, int n) {
        this.logger.log(1000000, "[%1.storeDataSetsResult]", (Object)LOGCLASS);
    }

    public void deleteDataSetResult(boolean bl, int n, long l) {
        this.logger.log(1000000, "[%1.deleteDataSetResult]", (Object)LOGCLASS);
    }

    public void asyncException(int n, String string, int n2) {
        this.logger.log(1000000, "[%1.asyncException]", (Object)LOGCLASS);
    }

    private DataSet[] createDataSet(List list, int n, int n2) {
        this.logger.log(1000000, "[%1.createDataSet]", (Object)LOGCLASS);
        int n3 = n + n2 > list.size() ? list.size() - n : n2;
        DataSet[] dataSetArray = new DataSet[n3];
        int n4 = 0;
        int n5 = n;
        while (n4 < n3) {
            MediaFavorite mediaFavorite = (MediaFavorite)list.get(n5);
            if (mediaFavorite.isPlayable()) {
                dataSetArray[n4] = this.createSearchDataFromFavorite(n5, mediaFavorite);
            }
            ++n4;
            ++n5;
        }
        return dataSetArray;
    }

    private DataSet createSearchDataFromFavorite(int n, MediaFavorite mediaFavorite) {
        Searchable[] searchableArray;
        int n2;
        this.logger.log(1000000, "[%1.createSearchDataFromFavorite]", (Object)LOGCLASS);
        int n3 = 0;
        switch (mediaFavorite.getContentType()) {
            case 14: {
                Searchable searchable;
                n2 = 6;
                I18NString i18NString = mediaFavorite.getFavoriteEntry();
                if (null != i18NString) {
                    if (i18NString.getI18NKey() == 6) {
                        n3 |= 8;
                    }
                    searchable = new Searchable(5, i18NString.getI18NString());
                } else {
                    searchable = null;
                }
                I18NString i18NString2 = mediaFavorite.getFavoriteMetaData();
                if (null != i18NString2) {
                    if (i18NString2.getI18NKey() == 3) {
                        n3 |= 2;
                    }
                    if (i18NString2.getI18NKey() == 30) {
                        n3 |= 4;
                    }
                    searchableArray = new Searchable[]{searchable, new Searchable(16, i18NString2.getI18NString())};
                    break;
                }
                searchableArray = new Searchable[]{searchable};
                break;
            }
            case 13: {
                n2 = 5;
                I18NString i18NString = mediaFavorite.getFavoriteEntry();
                if (null != i18NString) {
                    if (i18NString.getI18NKey() == 3) {
                        n3 |= 2;
                    }
                    if (i18NString.getI18NKey() == 30) {
                        n3 |= 4;
                    }
                    searchableArray = new Searchable[]{new Searchable(5, i18NString.getI18NString())};
                    break;
                }
                searchableArray = new Searchable[]{};
                break;
            }
            case 16: {
                n2 = 9;
                I18NString i18NString = mediaFavorite.getFavoriteEntry();
                if (null != i18NString) {
                    if (i18NString.getI18NKey() == 9) {
                        n3 |= 0x10;
                    }
                    searchableArray = new Searchable[]{new Searchable(5, i18NString.getI18NString())};
                    break;
                }
                searchableArray = new Searchable[]{};
                break;
            }
            case 4: {
                n2 = 12;
                I18NString i18NString = mediaFavorite.getFavoriteEntry();
                if (null != i18NString) {
                    searchableArray = new Searchable[]{new Searchable(5, i18NString.getI18NString())};
                    break;
                }
                searchableArray = new Searchable[]{};
                break;
            }
            default: {
                n2 = 1;
                searchableArray = new Searchable[]{};
            }
        }
        return new DataSet(n, n2, n3, searchableArray);
    }
}

