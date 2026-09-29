/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.media;

public interface IMediaValues {
    public static final int NONE;

    default public String getTimeLeftAsString() {
    }

    default public String getTimeTotalAsString() {
    }

    default public String getTimePlayingAsString() {
    }

    default public String getLine1Text() {
    }

    default public String getLine2Text() {
    }

    default public String getLine3Text() {
    }

    default public String getCover() {
    }

    default public void setTrackId(String string) {
    }

    default public String getTrackId() {
    }

    default public void setLine1Text(String string) {
    }

    default public void setLine2Text(String string) {
    }

    default public void setLine3Text(String string) {
    }

    default public void setCover(String string) {
    }

    default public void clearTimeValues() {
    }

    default public void setGridListIndex(int n) {
    }

    default public int getTimePlaying() {
    }

    default public int getTimeTotal() {
    }

    default public void setTimePlaying(int n) {
    }

    default public void setTimeTotal(int n) {
    }

    default public int getGridListIndex() {
    }

    default public void setOriginalCover(String string) {
    }

    default public String getOriginalCover() {
    }

    default public int getOldTimeTotal() {
    }

    default public int getOldTimePlaying() {
    }

    default public String getTitle() {
    }

    default public String getGenre() {
    }

    default public String getAlbum() {
    }

    default public String getStation() {
    }

    default public String getArtist() {
    }

    default public void setTextInGivenOrder(String string, String string2, String string3) {
    }

    default public int[] getTextLineOrder() {
    }

    default public void setTextLineOrder(int[] nArray) {
    }
}

