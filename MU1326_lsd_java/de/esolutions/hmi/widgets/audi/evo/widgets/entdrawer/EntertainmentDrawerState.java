/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer;

import de.audi.tghu.hmi.evo.IDrawer;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerContentController;
import de.esolutions.hmi.widgets.audi.evo.widgets.anim.AnimUtils;

public class EntertainmentDrawerState {
    public static final int NONE = -1;
    private int yScreenOffset;
    private float yTranslation;
    private int height;
    private int width;
    private float opacity;
    private float gapHeight;
    private int drawerState;
    private boolean animateDrawerStateChange;
    private int audioSource;
    private EntertainmentDrawerContentController content;
    private boolean isVisible;
    private float isHeaderVisible;

    public EntertainmentDrawerState() {
        this.yScreenOffset = 0;
        this.yTranslation = 0.0f;
        this.width = 0;
        this.height = 0;
        this.opacity = 0.0f;
        this.gapHeight = 0.0f;
        this.drawerState = 1;
        this.animateDrawerStateChange = false;
        this.audioSource = -1;
        this.content = null;
        this.isVisible = true;
        this.isHeaderVisible = 0.0f;
    }

    public EntertainmentDrawerState(int n, float f2, float f3, int n2, int n3, float f4, float f5, int n4, boolean bl, int n5, EntertainmentDrawerContentController entertainmentDrawerContentController, boolean bl2, float f6) {
        this.yScreenOffset = n;
        this.yTranslation = f2;
        this.width = n2;
        this.height = n3;
        this.opacity = f4;
        this.gapHeight = f5;
        this.drawerState = n4;
        this.animateDrawerStateChange = bl;
        this.audioSource = n5;
        this.content = entertainmentDrawerContentController;
        this.isVisible = bl2;
        this.isHeaderVisible = f6;
    }

    public EntertainmentDrawerState(EntertainmentDrawerState entertainmentDrawerState) {
        this.yScreenOffset = entertainmentDrawerState.getYScreenOffset();
        this.yTranslation = entertainmentDrawerState.getYTranslation();
        this.width = entertainmentDrawerState.getWidth();
        this.height = entertainmentDrawerState.getHeight();
        this.opacity = entertainmentDrawerState.getOpacity();
        this.gapHeight = entertainmentDrawerState.getGapHeight();
        this.drawerState = entertainmentDrawerState.getDrawerState();
        this.animateDrawerStateChange = entertainmentDrawerState.isAnimateDrawerStateChange();
        this.audioSource = entertainmentDrawerState.getAudioSource();
        this.content = entertainmentDrawerState.getContent();
        this.isVisible = entertainmentDrawerState.isVisible();
        this.isHeaderVisible = entertainmentDrawerState.isHeaderVisible();
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.animateDrawerStateChange ? 1231 : 1237);
        n = 31 * n + this.audioSource;
        n = 31 * n + this.drawerState;
        n = 31 * n + Float.floatToIntBits(this.gapHeight);
        n = 31 * n + this.height;
        n = 31 * n + Float.floatToIntBits(this.isHeaderVisible);
        n = 31 * n + (this.isVisible ? 1231 : 1237);
        n = 31 * n + Float.floatToIntBits(this.opacity);
        n = 31 * n + this.width;
        n = 31 * n + this.yScreenOffset;
        n = 31 * n + Float.floatToIntBits(this.yTranslation);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof EntertainmentDrawerState)) {
            return false;
        }
        EntertainmentDrawerState entertainmentDrawerState = (EntertainmentDrawerState)object;
        if (this.animateDrawerStateChange != entertainmentDrawerState.animateDrawerStateChange) {
            return false;
        }
        if (this.audioSource != entertainmentDrawerState.audioSource) {
            return false;
        }
        if (this.drawerState != entertainmentDrawerState.drawerState) {
            return false;
        }
        if (Float.floatToIntBits(this.gapHeight) != Float.floatToIntBits(entertainmentDrawerState.gapHeight)) {
            return false;
        }
        if (this.height != entertainmentDrawerState.height) {
            return false;
        }
        if (Float.floatToIntBits(this.isHeaderVisible) != Float.floatToIntBits(entertainmentDrawerState.isHeaderVisible)) {
            return false;
        }
        if (this.isVisible != entertainmentDrawerState.isVisible) {
            return false;
        }
        if (Float.floatToIntBits(this.opacity) != Float.floatToIntBits(entertainmentDrawerState.opacity)) {
            return false;
        }
        if (this.width != entertainmentDrawerState.width) {
            return false;
        }
        if (this.yScreenOffset != entertainmentDrawerState.yScreenOffset) {
            return false;
        }
        return Float.floatToIntBits(this.yTranslation) == Float.floatToIntBits(entertainmentDrawerState.yTranslation);
    }

    public boolean equalsIfMinimizedExcludingAnimate(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (object instanceof EntertainmentDrawerState) {
            EntertainmentDrawerState entertainmentDrawerState = (EntertainmentDrawerState)object;
            return this.yScreenOffset == entertainmentDrawerState.getYScreenOffset() && this.yTranslation == entertainmentDrawerState.getYTranslation() && this.width == entertainmentDrawerState.getWidth() && this.height == entertainmentDrawerState.getHeight() && this.opacity == entertainmentDrawerState.getOpacity() && this.gapHeight == entertainmentDrawerState.getGapHeight() && this.drawerState == entertainmentDrawerState.getDrawerState() && (entertainmentDrawerState.getDrawerState() == 2 || this.animateDrawerStateChange == entertainmentDrawerState.isAnimateDrawerStateChange()) && this.audioSource == entertainmentDrawerState.getAudioSource() && this.content == entertainmentDrawerState.getContent() && this.isVisible == entertainmentDrawerState.isVisible() && this.isHeaderVisible == entertainmentDrawerState.isHeaderVisible();
        }
        return false;
    }

    public String toString() {
        Buffer buffer = new Buffer(350);
        buffer.append("\nEntertainmentDrawerState [\nyScreenOffset=").append(this.yScreenOffset).append(",\nyTranslation=").append(this.yTranslation).append(",\nheight=").append(this.height).append(",\nwidth=").append(this.width).append(",\nopacity=").append(this.opacity).append(",\ngapHeight=").append(this.gapHeight).append(",\ndrawerState=").append(AnimUtils.valueToString(this.drawerState, IDrawer.DRAWER_STATE_TO_STRING)).append(",\nanimateDrawerStateChange=").append(this.animateDrawerStateChange).append(",\naudioSource=").append(this.audioSource).append(",\ncontent=").append(this.content).append(",\ndrawerVisible=").append(this.isVisible).append(",\nheaderVisible=").append(this.isHeaderVisible).append("]\n\n");
        return buffer.toString();
    }

    public int getYScreenOffset() {
        return this.yScreenOffset;
    }

    public void setYScreenOffset(int n) {
        this.yScreenOffset = n;
    }

    public float getYTranslation() {
        return this.yTranslation;
    }

    public void setYTranslation(float f2) {
        this.yTranslation = f2;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int n) {
        this.height = n;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int n) {
        this.width = n;
    }

    public float getOpacity() {
        return this.opacity;
    }

    public void setOpacity(float f2) {
        this.opacity = f2;
    }

    public float getGapHeight() {
        return this.gapHeight;
    }

    public void setGapHeight(float f2) {
        this.gapHeight = f2;
    }

    public int getDrawerState() {
        return this.drawerState;
    }

    public void setDrawerState(int n) {
        this.drawerState = n;
    }

    public boolean isAnimateDrawerStateChange() {
        return this.animateDrawerStateChange;
    }

    public void setAnimateDrawerStateChange(boolean bl) {
        this.animateDrawerStateChange = bl;
    }

    public int getAudioSource() {
        return this.audioSource;
    }

    public void setAudioSource(int n) {
        this.audioSource = n;
    }

    public EntertainmentDrawerContentController getContent() {
        return this.content;
    }

    public void setContent(EntertainmentDrawerContentController entertainmentDrawerContentController) {
        this.content = entertainmentDrawerContentController;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public void setVisible(boolean bl) {
        this.isVisible = bl;
    }

    public float isHeaderVisible() {
        return this.isHeaderVisible;
    }

    public void setHeaderVisible(float f2) {
        this.isHeaderVisible = f2;
    }

    public String getDifference(EntertainmentDrawerState entertainmentDrawerState) {
        Buffer buffer = new Buffer("");
        if (entertainmentDrawerState != null) {
            if (this.yScreenOffset != entertainmentDrawerState.getYScreenOffset()) {
                buffer.append("yScreenOffset:\t\t\t\t\t\t" + this.yScreenOffset + " --> " + entertainmentDrawerState.getYScreenOffset() + "\n");
            }
            if (this.yTranslation != entertainmentDrawerState.getYTranslation()) {
                buffer.append("yTranslation:\t\t\t\t\t\t" + this.yTranslation + " --> " + entertainmentDrawerState.getYTranslation() + "\n");
            }
            if (this.width != entertainmentDrawerState.getWidth()) {
                buffer.append("width:\t\t\t\t\t\t\t\t" + this.width + " --> " + entertainmentDrawerState.getWidth() + "\n");
            }
            if (this.height != entertainmentDrawerState.getHeight()) {
                buffer.append("height:\t\t\t\t\t\t\t\t" + this.height + " --> " + entertainmentDrawerState.getHeight() + "\n");
            }
            if (this.opacity != entertainmentDrawerState.getOpacity()) {
                buffer.append("opacity:\t\t\t\t\t\t\t" + this.opacity + " --> " + entertainmentDrawerState.getOpacity() + "\n");
            }
            if (this.gapHeight != entertainmentDrawerState.getGapHeight()) {
                buffer.append("gapHeight:\t\t\t\t\t\t\t" + this.gapHeight + " --> " + entertainmentDrawerState.getGapHeight() + "\n");
            }
            if (this.drawerState != entertainmentDrawerState.getDrawerState()) {
                buffer.append("drawerState:\t\t\t\t\t\t" + AnimUtils.valueToString(this.drawerState, IDrawer.DRAWER_STATE_TO_STRING) + " --> " + AnimUtils.valueToString(entertainmentDrawerState.getDrawerState(), IDrawer.DRAWER_STATE_TO_STRING) + "\n");
            }
            if (this.animateDrawerStateChange != entertainmentDrawerState.isAnimateDrawerStateChange()) {
                buffer.append("animateDrawerStateChange:\t\t\t" + this.animateDrawerStateChange + " --> " + entertainmentDrawerState.isAnimateDrawerStateChange() + "\n");
            }
            if (this.audioSource != entertainmentDrawerState.getAudioSource()) {
                buffer.append("audioSource:\t\t\t\t\t\t" + this.audioSource + " --> " + entertainmentDrawerState.getAudioSource() + "\n");
            }
            if (this.isVisible != entertainmentDrawerState.isVisible()) {
                buffer.append("isVisible:\t\t\t\t\t\t\t" + this.isVisible + " --> " + entertainmentDrawerState.isVisible() + "\n");
            }
            if (this.isHeaderVisible != entertainmentDrawerState.isHeaderVisible()) {
                buffer.append("isHeaderVisible:\t\t\t\t\t" + this.isHeaderVisible + " --> " + entertainmentDrawerState.isHeaderVisible() + "\n");
            }
            if (this.content != null && !this.content.equals(entertainmentDrawerState.getContent())) {
                buffer.append("content:\t\t\t\t\t\t\t" + this.content + "\n\t\t\t\t\t\t\t\t\t--> " + entertainmentDrawerState.getContent() + "\n");
            }
        }
        return buffer.toString();
    }
}

