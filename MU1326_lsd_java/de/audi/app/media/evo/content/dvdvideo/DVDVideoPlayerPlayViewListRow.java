/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.dvdvideo;

import de.audi.app.media.content.media.AbstractMediaPlayViewListRow;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.i18n.I18NString;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;

public class DVDVideoPlayerPlayViewListRow
extends AbstractMediaPlayViewListRow {
    private static final int[] EMPTY_PROPERTIES = new int[0];
    private static final String EMPTY_TEXT_CELL = "";
    private static final int EMPTY_INT_CELL = 0;
    private static final int RECORDSET_BIT_PLAYING = 1;
    private static final int CELL_COUNT = 7;
    private static final int CELL_ID_UNIQUE_ID = 0;
    private static final int CELL_ID_RECORD_SET = 1;
    private static final int CELL_ID_CHAPTER_NUMBER = 2;
    private static final int CELL_ID_PLAYTIME = 3;
    private static final int CELL_ID_PLAYTIME_REMAINING = 4;
    private static final int CELL_ID_PLAYTIME_PROGRESS = 5;
    private static final int CELL_ID_PROPERTY = 6;
    private final I18NString title;

    public DVDVideoPlayerPlayViewListRow(MediaListEntry mediaListEntry) {
        super(mediaListEntry.getEntryID(), 7);
        this.title = mediaListEntry.getTitle();
        this.setInteger(1, 0);
        this.setLong(0, mediaListEntry.getEntryID());
        this.setText(2, this.title.getI18NString());
        this.setText(3, EMPTY_TEXT_CELL);
        this.setText(4, EMPTY_TEXT_CELL);
        this.setInteger(5, 0);
        this.setPropertyCell(6, new PropertyListCell(890526283, EMPTY_PROPERTIES));
    }

    public DVDVideoPlayerPlayViewListRow(DVDVideoPlayerPlayViewListRow dVDVideoPlayerPlayViewListRow) {
        super(dVDVideoPlayerPlayViewListRow);
        this.title = dVDVideoPlayerPlayViewListRow.getTitle();
    }

    public void setTime(PlayTime playTime) {
        if (playTime == null) {
            this.setText(3, EMPTY_TEXT_CELL);
            this.setText(4, EMPTY_TEXT_CELL);
            this.setInteger(5, 0);
        } else {
            this.setText(3, playTime.getRestrictedPlayTimeStr());
            this.setText(4, playTime.getRemainTimeStr());
            this.setInteger(5, playTime.getProgress());
        }
    }

    public void setPlaying(boolean bl) {
        int n = this.getInteger(1);
        if (bl) {
            this.setInteger(1, n | 1);
            this.setPropertyCell(6, new PropertyListCell(-1596414918, EMPTY_PROPERTIES));
        } else {
            this.setInteger(1, n & 0xFFFFFFFE);
            this.setPropertyCell(6, new PropertyListCell(890526283, EMPTY_PROPERTIES));
        }
    }

    public void setDetailInfos(MediaDetailInfo mediaDetailInfo) {
    }

    public void setCoverArt(ResourceLocator resourceLocator) {
    }

    public I18NString getTitle() {
        return this.title;
    }

    public boolean isEnabled() {
        return true;
    }

    public int getDisabledState() {
        return 0;
    }

    public EvoListRow copy() {
        return new DVDVideoPlayerPlayViewListRow(this);
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("[ID='");
        buffer.append(this.getUniqueID());
        buffer.append("',eID='");
        buffer.append(this.getEntryID());
        buffer.append("', pro='");
        buffer.append(((PropertyListCell)this.getCell(6)).getCategory());
        buffer.append("']");
        return buffer.toString();
    }
}

