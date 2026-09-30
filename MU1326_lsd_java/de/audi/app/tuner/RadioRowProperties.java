/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner;

import de.esolutions.fw.util.commons.SimpleIntIntMap;

public class RadioRowProperties {
    public static final int SEEK_POSSIBILITY_NO = 0;
    public static final int SEEK_POSSIBILITY_YES = 1;
    public static final int SEEK_POSSIBILITY_ALREADY = 2;
    private final SimpleIntIntMap props = new SimpleIntIntMap(20);
    private int category;

    public int getCategory() {
        return this.category;
    }

    public void setCategory(int n) {
        this.category = n;
    }

    public void setActive(boolean bl) {
        if (bl) {
            this.props.add(721126732, 42);
        } else {
            this.props.remove(721126732);
        }
    }

    public boolean isActive() {
        return this.props.get(721126732) != -1;
    }

    public void setNoRadioText(boolean bl) {
        if (bl) {
            this.props.add(-1294461149, 42);
        } else {
            this.props.remove(-1294461149);
        }
    }

    public void setScrollingPS(boolean bl) {
        if (bl) {
            this.props.add(1990178604, 42);
        } else {
            this.props.remove(1990178604);
        }
    }

    public void setTaggingInfosAvailable(boolean bl) {
        if (bl) {
            this.props.add(-926428959, 42);
        } else {
            this.props.remove(-926428959);
        }
    }

    public void setSongSeekPossible(int n) {
        this.props.remove(1228727261);
        this.props.remove(-585203077);
        switch (n) {
            case 2: {
                this.props.add(-585203077, 42);
                this.props.add(1228727261, 42);
                break;
            }
            case 1: {
                this.props.add(1228727261, 42);
                break;
            }
        }
    }

    public void setArtistSeekPossible(int n) {
        this.props.remove(1245411570);
        this.props.remove(1128195393);
        switch (n) {
            case 2: {
                this.props.add(1128195393, 42);
                this.props.add(1245411570, 42);
                break;
            }
            case 1: {
                this.props.add(1245411570, 42);
                break;
            }
        }
    }

    public void setTeam1SeekPossible(int n) {
        this.props.remove(1388298451);
        this.props.remove(-486301509);
        switch (n) {
            case 2: {
                this.props.add(-486301509, 42);
                this.props.add(1388298451, 42);
                break;
            }
            case 1: {
                this.props.add(1388298451, 42);
                break;
            }
        }
    }

    public void setTeam2SeekPossible(int n) {
        this.props.remove(-1622456851);
        this.props.remove(-9322235);
        switch (n) {
            case 2: {
                this.props.add(-9322235, 42);
                this.props.add(-1622456851, 42);
                break;
            }
            case 1: {
                this.props.add(-1622456851, 42);
                break;
            }
        }
    }

    public void setNoSlideShow(boolean bl) {
        if (bl) {
            this.props.add(-2084961097, 42);
        } else {
            this.props.remove(-2084961097);
        }
    }

    public void setNameFreezed(boolean bl) {
        if (bl) {
            this.props.add(-1850142783, 42);
        } else {
            this.props.remove(-1850142783);
        }
    }

    public int[] toArray() {
        return this.props.getKeys();
    }
}

