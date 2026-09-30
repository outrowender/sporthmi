/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites;

import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.data.favorites.persistent.MediaFavoriteData;
import de.audi.app.media.i18n.I18NString;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.StringUtilities;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.ListEntryExt;

public class MediaFavorite {
    private static final String LOGCLASS = "MediaFavorite";
    public static final int BROWSEMODE_RAW_PLAYLIST = 4;
    private final LogChannel logger;
    private final MediaListEntry favoriteEntry;
    private final MediaListEntry[] folderStack;
    private int browseType;
    private boolean playable;
    private int intContentType;

    public MediaFavorite(LogChannel logChannel, MediaFavoriteData mediaFavoriteData) {
        this.logger = logChannel;
        this.browseType = this.setIntContentType(mediaFavoriteData.getBroweMode());
        this.favoriteEntry = MediaFavorite.getFavoriteFromPersistence(this.logger, mediaFavoriteData.getFavorite());
        this.folderStack = MediaFavorite.getPathFromPersistence(mediaFavoriteData.getPath());
        this.playable = true;
    }

    public MediaFavorite(LogChannel logChannel, MediaListEntry mediaListEntry, MediaListEntry[] mediaListEntryArray, int n) {
        this.logger = logChannel;
        this.favoriteEntry = mediaListEntry;
        this.folderStack = mediaListEntryArray;
        this.browseType = this.setIntContentType(n);
        this.playable = true;
    }

    public MediaFavorite(LogChannel logChannel, MediaFavorite mediaFavorite) {
        this.logger = logChannel;
        this.favoriteEntry = mediaFavorite.favoriteEntry;
        this.folderStack = mediaFavorite.folderStack;
        this.browseType = mediaFavorite.browseType;
        this.playable = mediaFavorite.playable;
        this.intContentType = mediaFavorite.intContentType;
    }

    public int getBrowseType() {
        return this.browseType;
    }

    private int setIntContentType(int n) {
        this.intContentType = 0;
        if (n == 4) {
            this.intContentType = 6;
            return 0;
        }
        return n;
    }

    protected int getInternalBrowseType() {
        return this.browseType == 0 && (this.intContentType == 6 || this.intContentType == 5) ? 4 : this.browseType;
    }

    public int getContentType() {
        int n;
        if (0 == this.browseType) {
            if (this.intContentType == 6 || this.intContentType == 5) {
                this.logger.log(1000000, "[%1.getContentType] Content type playlist detected.", (Object)LOGCLASS);
                return 6;
            }
            return 4;
        }
        if (null == this.folderStack || this.folderStack.length < 2) {
            this.logger.log(1000000, "[%1.getContentType] No folder stack. %2", (Object)LOGCLASS, (Object)this.toString());
            return 0;
        }
        switch (this.folderStack[1].getTitle().getI18NKey()) {
            case 8: {
                if (this.folderStack.length == 4) {
                    n = 14;
                    break;
                }
                if (this.folderStack.length == 3) {
                    n = 13;
                    break;
                }
                n = 16;
                break;
            }
            case 2: {
                if (this.folderStack.length == 3) {
                    n = 14;
                    break;
                }
                n = 13;
                break;
            }
            case 5: {
                n = 14;
                break;
            }
            case 1: {
                n = 6;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    public I18NString getFavoriteEntry() {
        return this.favoriteEntry.getTitle();
    }

    protected boolean isPlayable() {
        return this.playable;
    }

    protected void setPlayable(boolean bl) {
        this.playable = bl;
    }

    public boolean isFolderstackEmpty() {
        return this.folderStack.length == 0;
    }

    public I18NString getFavoriteMetaData() {
        if (!this.hasMetadata()) {
            return new I18NString("", false);
        }
        if (null == this.folderStack || this.folderStack.length < 2) {
            this.logger.log(1000000, "[%1.getFavoriteMetaData] No folder stack. %2", (Object)LOGCLASS, (Object)this.toString());
            return new I18NString("", false);
        }
        switch (this.folderStack[1].getTitle().getI18NKey()) {
            case 5: {
                return this.favoriteEntry.getArtist();
            }
            case 2: {
                return this.folderStack[2].getTitle();
            }
            case 8: {
                return this.folderStack[3].getTitle();
            }
        }
        return new I18NString("", false);
    }

    public boolean hasMetadata() {
        if (null == this.folderStack || this.folderStack.length < 2) {
            this.logger.log(1000000, "[%1.hasMetadata] No folder stack. %2", (Object)LOGCLASS, (Object)this.toString());
            return false;
        }
        if (null == this.folderStack[1].getTitle()) {
            this.logger.log(1000000, "[%1.hasMetadata] No title information", (Object)LOGCLASS);
            return false;
        }
        switch (this.folderStack[1].getTitle().getI18NKey()) {
            case 5: {
                return this.favoriteEntry.getArtist() != null;
            }
            case 2: {
                return this.folderStack.length == 3;
            }
            case 8: {
                return this.folderStack.length == 4;
            }
        }
        return false;
    }

    public MediaListEntry[] getFavoritePath() {
        MediaListEntry[] mediaListEntryArray = new MediaListEntry[this.folderStack.length + 1];
        for (int i2 = 0; i2 < this.folderStack.length; ++i2) {
            mediaListEntryArray[i2] = new MediaListEntry(-1L, -1, this.folderStack[i2].getContentType() == 4 ? this.folderStack[i2].getFilename().getOriginalString() : this.folderStack[i2].getTitle().getOriginalString());
        }
        String string = this.getContentType() == 6 ? this.favoriteEntry.getFilename().getOriginalString() : this.getFavoriteEntry().getOriginalString();
        mediaListEntryArray[mediaListEntryArray.length - 1] = new MediaListEntry(-1L, -1, string);
        return mediaListEntryArray;
    }

    protected String getPath() {
        boolean bl = 0 == this.browseType;
        Buffer buffer = new Buffer(50);
        for (int i2 = 0; i2 < this.folderStack.length; ++i2) {
            buffer.append(this.folderStack[i2].getFilename().getOriginalString());
            buffer.append('#');
            buffer.append(bl ? this.folderStack[i2].getFilename().getOriginalString() : this.folderStack[i2].getTitle().getOriginalString());
            buffer.append('#');
        }
        if (buffer.length() > 0 && buffer.charAt(buffer.length() - 1) == '#') {
            return buffer.substring(0, buffer.length() - 1);
        }
        return buffer.toString();
    }

    protected static MediaListEntry[] getPathFromPersistence(String string) {
        Object[] objectArray;
        List list = StringUtilities.split(string, '#');
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            objectArray = (String)list.get(i2);
            String string2 = (String)list.get(++i2);
            arrayList.add(new MediaListEntry(new ListEntry(-1L, (String)objectArray, string2, 0, 0, 16, null)));
        }
        objectArray = new MediaListEntry[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    protected static MediaListEntry getFavoriteFromPersistence(LogChannel logChannel, String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, ";");
        int n = stringTokenizer.countTokens();
        if (1 == n) {
            return new MediaListEntry(new ListEntry(-1L, "", string, 0, 0, 16, null));
        }
        String[] stringArray = new String[n];
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < n; ++i2) {
            stringArray[i2] = stringTokenizer.nextToken();
            buffer.append("[").append(stringArray[i2]).append("]");
        }
        logChannel.log(100000000, "[%1.getFavoriteFromPersistence] Token: %2", (Object)LOGCLASS, (Object)buffer.toString());
        if (2 == n) {
            return new MediaListEntry(new ListEntry(-1L, stringArray[0], stringArray[1], 0, 0, 16, null));
        }
        return new MediaListEntry(new ListEntry(-1L, stringArray[0], stringArray[1], 0, 0, 16, new ListEntryExt("", -1L, stringArray[2], -1L, null, -1L, -1, -1, -1)));
    }

    public MediaFavoriteData getSerializableData() {
        return new MediaFavoriteData(this.getInternalBrowseType(), this.getPath(), this.getSerializedFavorite());
    }

    protected String getSerializedFavorite() {
        String string;
        I18NString i18NString = this.getFavoriteEntry();
        String string2 = this.favoriteEntry.getFilename().getOriginalString();
        if (this.hasMetadata()) {
            I18NString i18NString2 = this.getFavoriteMetaData();
            string = string2 + ";" + I18NString.getOriginalString(i18NString.getI18NString(), i18NString.getI18NKey()) + ";" + I18NString.getOriginalString(i18NString2.getI18NString(), i18NString2.getI18NKey());
        } else {
            string = string2 + ";" + I18NString.getOriginalString(i18NString.getI18NString(), i18NString.getI18NKey());
        }
        return string;
    }

    public static MediaFavorite deserializeData(LogChannel logChannel, Object object) {
        return new MediaFavorite(logChannel, (MediaFavoriteData)object);
    }

    public int hashCode() {
        return 0;
    }

    public boolean equals(Object object) {
        if (!(object instanceof MediaFavorite)) {
            return false;
        }
        MediaFavorite mediaFavorite = (MediaFavorite)object;
        I18NString i18NString = this.getFavoriteEntry();
        I18NString i18NString2 = mediaFavorite.getFavoriteEntry();
        I18NString i18NString3 = this.getFavoriteMetaData();
        I18NString i18NString4 = mediaFavorite.getFavoriteMetaData();
        return i18NString != null && i18NString2 != null && null != i18NString.getOriginalString() && i18NString.getOriginalString().equals(i18NString2.getOriginalString()) && this.getContentType() == mediaFavorite.getContentType() && i18NString3 != null && i18NString4 != null && i18NString3.getOriginalString().equals(i18NString4.getOriginalString());
    }

    public boolean validateMediaFavoriteData() {
        if (null == this.favoriteEntry) {
            this.logger.log(1000000, "[%1.validateMediaFavoriteData] favEntry null.", (Object)LOGCLASS);
            return false;
        }
        if (null == this.folderStack) {
            this.logger.log(1000000, "[%1.validateMediaFavoriteData] folder stack null.", (Object)LOGCLASS);
            return false;
        }
        if (1 != this.browseType && 0 != this.browseType) {
            this.logger.log(1000000, "[%1.validateMediaFavoriteData] unknown browse mode %2", (Object)LOGCLASS, (long)this.browseType);
            return false;
        }
        if (1 == this.browseType && this.folderStack.length < 2) {
            this.logger.log(1000000, "[%1.validateMediaFavoriteData] folder stack size %2", (Object)LOGCLASS, (long)this.folderStack.length);
            return false;
        }
        if (this.hasMetadata() && null == this.getFavoriteMetaData()) {
            this.logger.log(1000000, "[%1.validateMediaFavoriteData] Metadata is not available.", (Object)LOGCLASS);
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(40);
        stringBuffer.append("MediaFavorite '");
        stringBuffer.append(this.browseType);
        stringBuffer.append("' '");
        stringBuffer.append(this.favoriteEntry);
        stringBuffer.append("' '");
        for (int i2 = 0; i2 < this.folderStack.length; ++i2) {
            stringBuffer.append(this.folderStack[i2]);
        }
        stringBuffer.append('\'');
        return stringBuffer.toString();
    }
}

