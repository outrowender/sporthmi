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
        return new StringBuffer().append("MediaValues [ gridListIndex=").append(this.gridListIndex).append(", ").append("oldTimeId='").append(this.getOldTimeId()).append("', ").append("trackId=").append(this.trackId).append(", ").append("title='").append(this.title).append("', ").append("timeTotal=").append(this.timeTotal).append(", ").append("timePlaying=").append(this.timePlaying).append(", ").append("artist='").append(this.artist).append("', ").append("album='").append(this.album).append("', ").append("cover='").append(this.cover).append("', ").append("originalCover='").append(this.originalCover).append("', ").append("]").toString();
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
        String string2 = new StringBuffer().append(n3).append(":").append(string).append(n4).toString();
        if (bl) {
            String string3 = n < 0 ? "-" : "";
            return new StringBuffer().append(string3).append(string2).toString();
        }
        return string2;
    }

    @Override
    public String getTimeLeftAsString() {
        return this.isTimeGiven() ? MediaValues.convertTimeToStringUseSign(this.getTimeLeft(), false) : "";
    }

    @Override
    public String getTimePlayingAsString() {
        return this.isTimeGiven() ? MediaValues.convertTimeToString(this.getTimePlaying()) : "";
    }

    @Override
    public String getTimeTotalAsString() {
        return this.isTimeGiven() ? MediaValues.convertTimeToString(this.getTimeTotal()) : "";
    }

    @Override
    public String getCover() {
        return this.cover;
    }

    @Override
    public void setCover(String string) {
        this.cover = string;
    }

    @Override
    public String getOriginalCover() {
        return this.originalCover;
    }

    @Override
    public void setOriginalCover(String string) {
        this.originalCover = string;
    }

    @Override
    public String getLine1Text() {
        return this.getTextOnOrderIndex(0);
    }

    @Override
    public void setLine1Text(String string) {
        this.title = string;
    }

    @Override
    public String getLine2Text() {
        return this.getTextOnOrderIndex(1);
    }

    @Override
    public void setLine2Text(String string) {
        this.artist = string;
    }

    @Override
    public String getLine3Text() {
        return this.getTextOnOrderIndex(2);
    }

    @Override
    public void setLine3Text(String string) {
        this.album = string;
    }

    public int getTimeLeft() {
        return this.timeTotal - this.timePlaying;
    }

    @Override
    public int getTimeTotal() {
        return this.timeTotal;
    }

    @Override
    public void setTimeTotal(int n) {
        this.timeTotal = Math.max(0, n);
    }

    @Override
    public int getTimePlaying() {
        return this.timePlaying;
    }

    @Override
    public void setTimePlaying(int n) {
        this.timePlaying = Math.max(0, n);
    }

    @Override
    public String getTrackId() {
        return this.trackId;
    }

    @Override
    public void setTrackId(String string) {
        this.trackId = string;
    }

    @Override
    public void clearTimeValues() {
        this.timeTotal = 0;
        this.timePlaying = 0;
    }

    @Override
    public int getGridListIndex() {
        return this.gridListIndex;
    }

    @Override
    public void setGridListIndex(int n) {
        this.gridListIndex = n;
    }

    public long getOldTimeId() {
        return this.oldTimeId;
    }

    @Override
    public int getOldTimeTotal() {
        return this.oldTimeTotal;
    }

    @Override
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

    @Override
    public String getTitle() {
        return this.getTextOnOrderIndex(0);
    }

    @Override
    public String getGenre() {
        return this.getTextOnOrderIndex(4);
    }

    @Override
    public String getAlbum() {
        return this.getTextOnOrderIndex(2);
    }

    @Override
    public String getStation() {
        return this.getTextOnOrderIndex(3);
    }

    @Override
    public String getArtist() {
        return this.getTextOnOrderIndex(1);
    }

    @Override
    public int[] getTextLineOrder() {
        return this.textLineOrder;
    }

    @Override
    public void setTextLineOrder(int[] nArray) {
        this.textLineOrder = nArray;
    }

    @Override
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

