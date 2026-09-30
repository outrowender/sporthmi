/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.WheelButtonEvent;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public class SuggestionController
extends AbstractWidgetController {
    private static final int CURSOR_POS_SPELLER_OPEN = 0;
    public static final int MAX_USED_SUGGESTIONS = 3;
    private String[] suggestions;
    private int cursorPos;
    private boolean isSuggestionBarActive;
    private IRenderer renderer;

    protected void initializeWidget() {
        this.isSuggestionBarActive = false;
        this.cursorPos = 0;
    }

    public void suggestionsUpdated(String[] stringArray) {
        this.suggestions = stringArray;
        if (stringArray != null && stringArray.length > 0) {
            if (!this.isSuggestionBarActive || this.cursorPos > stringArray.length) {
                this.cursorPos = 1;
            }
            this.setCompositesDirty(true);
        }
    }

    public String[] getSuggestions() {
        return this.suggestions;
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        super.keyTurned(wheelButtonEvent);
        if (!wheelButtonEvent.isConsumed() && this.suggestions != null && this.isSuggestionBarActive) {
            int n = Math.min(3, this.suggestions.length);
            this.cursorPos += wheelButtonEvent.getClickCount() * (wheelButtonEvent.getDirection() == 1 ? -1 : 1);
            this.cursorPos = Math.min(this.cursorPos, n);
            this.cursorPos = Math.max(0, this.cursorPos);
            this.setCompositesDirty(true);
            wheelButtonEvent.consume(true);
        }
    }

    public int getCurrentCursorPos() {
        return this.cursorPos;
    }

    public void setSuggestionBarActive(boolean bl) {
        this.isSuggestionBarActive = bl;
        this.cursorPos = this.suggestions != null && this.suggestions.length > 0 ? 1 : 0;
        this.setCompositesDirty(true);
    }

    public boolean showCursor() {
        return this.isSuggestionBarActive;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    public boolean isSpellerIconSelected() {
        return this.cursorPos == 0;
    }

    public String getCurrentSelectedSuggestion() {
        if (this.suggestions != null && 1 <= this.cursorPos && this.cursorPos <= this.suggestions.length) {
            return this.suggestions[this.cursorPos - 1];
        }
        return "";
    }
}

