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

    public void setElementIsFavorite(boolean bl) {
        if (bl) {
            this.props.add(-1783875994, 42);
        } else {
            this.props.remove(-1783875994);
        }
    }

    public void setDatabroadcastIsAvailable(boolean bl) {
        if (bl) {
            this.props.add(-1013118362, 42);
        } else {
            this.props.remove(-1013118362);
        }
    }

    public void setDatabroadcastIsLoading(boolean bl) {
        if (bl) {
            this.props.add(1398074041, 42);
        } else {
            this.props.remove(1398074041);
        }
    }

    public void setDatabroadcastIsCheckingOrUnavailable(boolean bl) {
        if (bl) {
            this.props.add(-1838047989, 42);
        } else {
            this.props.remove(-1838047989);
        }
    }

    public void setVisualAudioIsAvailable(boolean bl) {
        if (bl) {
            this.props.add(1639143867, 42);
        } else {
            this.props.remove(1639143867);
        }
    }

    public void setVisualAudioIsLoading(boolean bl) {
        if (bl) {
            this.props.add(-1825335551, 42);
        } else {
            this.props.remove(-1825335551);
        }
    }

    public void setVisualAudioIsUnavailable(boolean bl) {
        if (bl) {
            this.props.add(1913918755, 42);
        } else {
            this.props.remove(1913918755);
        }
    }

    public void setTeletextIsAvailable(boolean bl) {
        if (bl) {
            this.props.add(614014185, 42);
        } else {
            this.props.remove(614014185);
        }
    }

    public void setTeletextIsLoading(boolean bl) {
        if (bl) {
            this.props.add(190541802, 42);
        } else {
            this.props.remove(190541802);
        }
    }

    public void setTeletextIsUnavailable(boolean bl) {
        if (bl) {
            this.props.add(-846215156, 42);
        } else {
            this.props.remove(-846215156);
        }
    }

    public int[] toArray() {
        return this.props.getKeys();
    }

    public int getCategory() {
        return this.category;
    }
}

