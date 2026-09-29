/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.tv.app.lists.IRowProperties;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

public class TVRowProperties
implements IRowProperties {
    private final SimpleIntIntMap props = new SimpleIntIntMap(20);
    public final int category;

    public TVRowProperties(int n) {
        this.category = n;
    }

    @Override
    public void setElementIsFavorite(boolean bl) {
        if (bl) {
            this.props.add(1714859157, 42);
        } else {
            this.props.remove(1714859157);
        }
    }

    @Override
    public void setDatabroadcastIsAvailable(boolean bl) {
        if (bl) {
            this.props.add(1711971779, 42);
        } else {
            this.props.remove(1711971779);
        }
    }

    @Override
    public void setDatabroadcastIsLoading(boolean bl) {
        if (bl) {
            this.props.add(-1175825325, 42);
        } else {
            this.props.remove(-1175825325);
        }
    }

    @Override
    public void setDatabroadcastIsCheckingOrUnavailable(boolean bl) {
        if (bl) {
            this.props.add(194867602, 42);
        } else {
            this.props.remove(194867602);
        }
    }

    @Override
    public void setVisualAudioIsAvailable(boolean bl) {
        if (bl) {
            this.props.add(-1151749279, 42);
        } else {
            this.props.remove(-1151749279);
        }
    }

    @Override
    public void setVisualAudioIsLoading(boolean bl) {
        if (bl) {
            this.props.add(26686355, 42);
        } else {
            this.props.remove(26686355);
        }
    }

    @Override
    public void setVisualAudioIsUnavailable(boolean bl) {
        if (bl) {
            this.props.add(588584050, 42);
        } else {
            this.props.remove(588584050);
        }
    }

    @Override
    public void setTeletextIsAvailable(boolean bl) {
        if (bl) {
            this.props.add(-384001756, 42);
        } else {
            this.props.remove(-384001756);
        }
    }

    @Override
    public void setTeletextIsLoading(boolean bl) {
        if (bl) {
            this.props.add(-361800949, 42);
        } else {
            this.props.remove(-361800949);
        }
    }

    @Override
    public void setTeletextIsUnavailable(boolean bl) {
        if (bl) {
            this.props.add(214470605, 42);
        } else {
            this.props.remove(214470605);
        }
    }

    @Override
    public int[] toArray() {
        return this.props.getKeys();
    }

    @Override
    public int getCategory() {
        return this.category;
    }
}

