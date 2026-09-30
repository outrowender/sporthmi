/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.media;

public interface IMediaValues {
    public static final int NONE = -1;

    public String getTimeLeftAsString();

    public String getTimeTotalAsString();

    public String getTimePlayingAsString();

    public String getLine1Text();

    public String getLine2Text();

    public String getLine3Text();

    public String getCover();

    public void setTrackId(String var1);

    public String getTrackId();

    public void setLine1Text(String var1);

    public void setLine2Text(String var1);

    public void setLine3Text(String var1);

    public void setCover(String var1);

    public void clearTimeValues();

    public void setGridListIndex(int var1);

    public int getTimePlaying();

    public int getTimeTotal();

    public void setTimePlaying(int var1);

    public void setTimeTotal(int var1);

    public int getGridListIndex();

    public void setOriginalCover(String var1);

    public String getOriginalCover();

    public int getOldTimeTotal();

    public int getOldTimePlaying();

    public String getTitle();

    public String getGenre();

    public String getAlbum();

    public String getStation();

    public String getArtist();

    public void setTextInGivenOrder(String var1, String var2, String var3);

    public int[] getTextLineOrder();

    public void setTextLineOrder(int[] var1);
}

