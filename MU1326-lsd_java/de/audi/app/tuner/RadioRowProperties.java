/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner;

import de.esolutions.fw.util.commons.SimpleIntIntMap;

public class RadioRowProperties {
    public static final int SEEK_POSSIBILITY_NO;
    public static final int SEEK_POSSIBILITY_YES;
    public static final int SEEK_POSSIBILITY_ALREADY;
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
            this.props.add(1283849002, 42);
        } else {
            this.props.remove(1283849002);
        }
    }

    public boolean isActive() {
        return this.props.get(1283849002) != -1;
    }

    public void setNoRadioText(boolean bl) {
        if (bl) {
            this.props.add(588765362, 42);
        } else {
            this.props.remove(588765362);
        }
    }

    public void setScrollingPS(boolean bl) {
        if (bl) {
            this.props.add(750231414, 42);
        } else {
            this.props.remove(750231414);
        }
    }

    public void setTaggingInfosAvailable(boolean bl) {
        if (bl) {
            this.props.add(-506411064, 42);
        } else {
            this.props.remove(-506411064);
        }
    }

    public void setSongSeekPossible(int n) {
        this.props.remove(-572310455);
        this.props.remove(2072125149);
        switch (n) {
            case 2: {
                this.props.add(2072125149, 42);
                this.props.add(-572310455, 42);
                break;
            }
            case 1: {
                this.props.add(-572310455, 42);
                break;
            }
        }
    }

    public void setArtistSeekPossible(int n) {
        this.props.remove(-227001526);
        this.props.remove(1105542723);
        switch (n) {
            case 2: {
                this.props.add(1105542723, 42);
                this.props.add(-227001526, 42);
                break;
            }
            case 1: {
                this.props.add(-227001526, 42);
                break;
            }
        }
    }

    public void setTeam1SeekPossible(int n) {
        this.props.remove(-742342830);
        this.props.remove(-1147141149);
        switch (n) {
            case 2: {
                this.props.add(-1147141149, 42);
                this.props.add(-742342830, 42);
                break;
            }
            case 1: {
                this.props.add(-742342830, 42);
                break;
            }
        }
    }

    public void setTeam2SeekPossible(int n) {
        this.props.remove(-314225761);
        this.props.remove(96563711);
        switch (n) {
            case 2: {
                this.props.add(96563711, 42);
                this.props.add(-314225761, 42);
                break;
            }
            case 1: {
                this.props.add(-314225761, 42);
                break;
            }
        }
    }

    public void setNoSlideShow(boolean bl) {
        if (bl) {
            this.props.add(-1224426877, 42);
        } else {
            this.props.remove(-1224426877);
        }
    }

    public void setNameFreezed(boolean bl) {
        if (bl) {
            this.props.add(-1055934063, 42);
        } else {
            this.props.remove(-1055934063);
        }
    }

    public int[] toArray() {
        return this.props.getKeys();
    }
}

