/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites;

import de.audi.app.media.evo.content.data.favorites.MediaFavorite;
import de.audi.app.media.i18n.I18NString;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;

public class FavoritesListRow
extends EvoListRow {
    private static final int MAX_COLUMNS = 8;
    private static final int CELL_ID_RECORDSET = 0;
    private static final int CELL_ID_FAV_FIRST_ROW = 1;
    private static final int CELL_ID_FAV_FIRST_ROW_I18N = 2;
    private static final int CELL_ID_FAV_SECOND_ROW = 3;
    private static final int CELL_ID_FAV_SECOND_ROW_I18N = 4;
    private static final int CELL_ID_ENABLED = 5;
    private static final int CELL_ID_PROPERTY = 6;
    private static final int CELL_ID_ICON = 7;
    private static final int ICON_UNDEFINED = 0;
    private static final int ICON_ARTIST = 1;
    private static final int ICON_ALBUM = 2;
    private static final int ICON_GENRE = 3;
    private static final int ICON_FOLDER = 4;
    private static final int ICON_PLAYLIST = 5;
    private static final int RECORDSET_ONELINE = 0;
    private static final int RECORDSET_TWOLINE = 1;
    private static final PropertyListCell FAVORITES_PROPERTIES = new PropertyListCell(1065699435, new int[0]);
    private static final PropertyListCell DEADLINK_PROPERTIES = new PropertyListCell(-211503700, new int[0]);
    private final MediaFavorite mediaFavorite;

    public FavoritesListRow(int n, MediaFavorite mediaFavorite) {
        super(n, 8);
        this.mediaFavorite = mediaFavorite;
        I18NString i18NString = mediaFavorite.getFavoriteEntry();
        this.setText(1, i18NString.getI18NString());
        this.setInteger(2, i18NString.getI18NKey());
        if (mediaFavorite.hasMetadata()) {
            I18NString i18NString2 = mediaFavorite.getFavoriteMetaData();
            this.setText(3, i18NString2.getI18NString());
            this.setInteger(4, i18NString2.getI18NKey());
        }
        if (mediaFavorite.hasMetadata()) {
            this.setInteger(0, 1);
        } else {
            this.setInteger(0, 0);
        }
        this.setInteger(5, mediaFavorite.isPlayable() ? 1 : 0);
        this.setPropertyCell(6, mediaFavorite.isPlayable() ? FAVORITES_PROPERTIES : DEADLINK_PROPERTIES);
        this.setInteger(7, FavoritesListRow.getFavoriteIcon(mediaFavorite.getContentType()));
    }

    public FavoritesListRow(FavoritesListRow favoritesListRow) {
        super(favoritesListRow);
        this.mediaFavorite = favoritesListRow.mediaFavorite;
    }

    public boolean isEnabled() {
        return this.mediaFavorite.isPlayable();
    }

    public MediaFavorite getMediaFavorite() {
        return this.mediaFavorite;
    }

    public EvoListRow copy() {
        return new FavoritesListRow(this);
    }

    private static int getFavoriteIcon(int n) {
        switch (n) {
            case 14: {
                return 2;
            }
            case 13: {
                return 1;
            }
            case 16: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: 
            case 6: {
                return 5;
            }
        }
        return 0;
    }
}

