/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.remotehmi.media.IMediaValues;

public class MediaValues
implements IMediaValues {
    private int gridListIndex = -1;
    private String trackId = "";
    private String cover = "";
    private String originalCover = "";
    private String title = "";
    private String artist = "";
    private String album = "";
    public static final int[] defaulttextLineOrder = new int[]{0, 1, 2};
    private int[] textLineOrder = defaulttextLineOrder;
    private int timeTotal = 0;
    private int timePlaying = 0;
    private long oldTimeId = -1L;
    private int oldTimeTotal = 0;
    private int oldTimePlaying = 0;

    public String toString() {
        return "MediaValues [ gridListIndex=" + this.gridListIndex + ", " + "oldTimeId='" + this.getOldTimeId() + "', " + "trackId=" + this.trackId + ", " + "title='" + this.title + "', " + "timeTotal=" + this.timeTotal + ", " + "timePlaying=" + this.timePlaying + ", " + "artist='" + this.artist + "', " + "album='" + this.album + "', " + "cover='" + this.cover + "', " + "originalCover='" + this.originalCover + "', " + "]";
    }

    public static String convertTimeToString(int n) {
        return MediaValues.convertTimeToStringUseSign(n, true);
    }

    public static String convertTimeToStringUseSign(int n, boolean bl) {
        int n2 = Math.abs(n);
        int n3 = n2 / 60;
        int n4 = n2 % 60;
        String string = "";
        if (n4 < 10) {
            string = "0";
        }
        String string2 = n3 + ":" + string + n4;
        if (bl) {
            String string3 = n < 0 ? "-" : "";
            return string3 + string2;
        }
        return string2;
    }

    public String getTimeLeftAsString() {
        return this.isTimeGiven() ? MediaValues.convertTimeToStringUseSign(this.getTimeLeft(), false) : "";
    }

    public String getTimePlayingAsString() {
        return this.isTimeGiven() ? MediaValues.convertTimeToString(this.getTimePlaying()) : "";
    }

    public String getTimeTotalAsString() {
        return this.isTimeGiven() ? MediaValues.convertTimeToString(this.getTimeTotal()) : "";
    }

    public String getCover() {
        return this.cover;
    }

    public void setCover(String string) {
        this.cover = string;
    }

    public String getOriginalCover() {
        return this.originalCover;
    }

    public void setOriginalCover(String string) {
        this.originalCover = string;
    }

    public String getLine1Text() {
        return this.getTextOnOrderIndex(0);
    }

    public void setLine1Text(String string) {
        this.title = string;
    }

    public String getLine2Text() {
        return this.getTextOnOrderIndex(1);
    }

    public void setLine2Text(String string) {
        this.artist = string;
    }

    public String getLine3Text() {
        return this.getTextOnOrderIndex(2);
    }

    public void setLine3Text(String string) {
        this.album = string;
    }

    public int getTimeLeft() {
        return this.timeTotal - this.timePlaying;
    }

    public int getTimeTotal() {
        return this.timeTotal;
    }

    public void setTimeTotal(int n) {
        this.timeTotal = Math.max(0, n);
    }

    public int getTimePlaying() {
        return this.timePlaying;
    }

    public void setTimePlaying(int n) {
        this.timePlaying = Math.max(0, n);
    }

    public String getTrackId() {
        return this.trackId;
    }

    public void setTrackId(String string) {
        this.trackId = string;
    }

    public void clearTimeValues() {
        this.timeTotal = 0;
        this.timePlaying = 0;
    }

    public int getGridListIndex() {
        return this.gridListIndex;
    }

    public void setGridListIndex(int n) {
        this.gridListIndex = n;
    }

    public long getOldTimeId() {
        return this.oldTimeId;
    }

    public int getOldTimeTotal() {
        return this.oldTimeTotal;
    }

    public int getOldTimePlaying() {
        return this.oldTimePlaying;
    }

    private boolean isTimeGiven() {
        return this.timeTotal >= 0 && this.timePlaying >= 0;
    }

    public void clear() {
        this.trackId = "";
        this.cover = "";
        this.originalCover = "";
        this.title = "";
        this.album = "";
        this.artist = "";
        this.timeTotal = 0;
        this.timePlaying = 0;
        this.oldTimeId = -1L;
        this.oldTimeTotal = 0;
        this.oldTimePlaying = 0;
    }

    public int findOrderIndex(int n) {
        for (int i2 = 0; i2 < this.textLineOrder.length; ++i2) {
            if (this.textLineOrder[i2] != n) continue;
            return i2;
        }
        return -1;
    }

    public String getTitle() {
        return this.getTextOnOrderIndex(0);
    }

    public String getGenre() {
        return this.getTextOnOrderIndex(4);
    }

    public String getAlbum() {
        return this.getTextOnOrderIndex(2);
    }

    public String getStation() {
        return this.getTextOnOrderIndex(3);
    }

    public String getArtist() {
        return this.getTextOnOrderIndex(1);
    }

    public int[] getTextLineOrder() {
        return this.textLineOrder;
    }

    public void setTextLineOrder(int[] nArray) {
        this.textLineOrder = nArray;
    }

    public void setTextInGivenOrder(String string, String string2, String string3) {
        this.title = string;
        this.album = string2;
        this.artist = string3;
    }

    private String getTextOnOrderIndex(int n) {
        switch (this.textLineOrder[n]) {
            case 0: 
            case 4: {
                return this.title;
            }
            case 1: {
                return this.artist;
            }
            case 2: 
            case 3: {
                return this.album;
            }
        }
        return "";
    }
}

