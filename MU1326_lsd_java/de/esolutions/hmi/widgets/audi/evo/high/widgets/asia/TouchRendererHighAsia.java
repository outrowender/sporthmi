/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.asia;

import de.esolutions.graphics.eal.FlagFontStyle;
import de.esolutions.graphics.eal.api.ITextLayoutSection;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ITouchRendererFontFlags;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.TouchRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;

public final class TouchRendererHighAsia
extends TouchRendererHigh {
    private static final int NUMBER_OF_TEXT_SECTIONS;
    private final TouchControllerAsia controllerAsia;

    public TouchRendererHighAsia(TouchControllerAsia touchControllerAsia) {
        super(touchControllerAsia);
        this.controllerAsia = touchControllerAsia;
    }

    @Override
    protected String getFullTextToRender() {
        if (this.controllerAsia.suggestionsAvailable()) {
            return this.controllerAsia.getCurrentSuggestion();
        }
        return this.controllerAsia.getFullTextFromInputField();
    }

    @Override
    protected String getTextPartLeftOfCursor() {
        return this.controllerAsia.getFullTextFromInputField();
    }

    @Override
    protected int getNumberOfTextLayoutSections() {
        return 2;
    }

    @Override
    protected FlagFontStyle getFontStyle(int n) {
        if (n == 1) {
            if (this.controllerAsia.suggestionsAvailable()) {
                return ITouchRendererFontFlags.FONT_STYLE_REGULAR;
            }
            return ITouchRendererFontFlags.FONT_STYLE_UNDERLINE;
        }
        return super.getFontStyle(n);
    }

    @Override
    protected int getColorForTextSection(int n) {
        if (n == 1 && this.controllerAsia.suggestionsAvailable() && !this.shouldShowSuggestionBackground()) {
            int n2 = this.rc.getColor(2);
            return EALManager.createColorCode(n2);
        }
        return super.getColorForTextSection(n);
    }

    @Override
    protected int getIndexOfLastCharacterInTextSection(int n) {
        if (this.getFullTextToRender().length() == 0) {
            return -1;
        }
        int n2 = this.controllerAsia.getInputData().getCurrentText().length();
        if (n == 0 && n2 > 0) {
            if (this.controllerAsia.hasNonRegularCharacters()) {
                int n3 = this.getAbbreviatedTextToRender().length() - this.controllerAsia.getAllNonRegularCharacters().length() - 1;
                return Math.max(0, n3);
            }
            return n2 - 1;
        }
        if (n == 1 && this.controllerAsia.hasNonRegularCharacters()) {
            return this.getAbbreviatedTextToRender().length() - 1;
        }
        if (n == 1 && this.controllerAsia.suggestionsAvailable()) {
            return this.controllerAsia.getCurrentSuggestion().length() - 1;
        }
        return -1;
    }

    private void showSuggestionBackground(boolean bl, boolean bl2) {
        int n = Math.round(this.textNode.getY() - 57409);
        int n2 = 36;
        if (bl) {
            if (bl2) {
                this.suggestionBackground.setPosition(this.suggestionX, n, 0.0f);
                this.suggestionBackground.setScale(this.suggestionW, n2, 0.0f);
                this.suggestionBackground.setVisible(bl);
            } else {
                this.suggestionBackground.setVisible(!bl);
            }
        } else {
            this.suggestionBackground.setPosition(this.suggestionX, n, 0.0f);
            this.suggestionBackground.setScale(this.suggestionW, n2, 0.0f);
            this.suggestionBackground.setVisible(bl);
        }
    }

    @Override
    protected void showSuggestionBackground(boolean bl) {
        if (bl) {
            bl &= this.controllerAsia.suggestionsAvailable();
        }
        this.showSuggestionBackground(bl, this.shouldShowSuggestionBackground());
    }

    @Override
    protected boolean shouldShowSuggestionBackground() {
        return this.controllerAsia.suggestionsAvailable() && this.controllerAsia.shouldShowSuggestionBackground();
    }

    @Override
    protected String updateSections(int n, ITextLayoutSection iTextLayoutSection, int n2, int n3) {
        if (this.controllerAsia.suggestionsAvailable() && n == 1) {
            return super.updateSections(n, iTextLayoutSection, n2, n3);
        }
        return this.getAbbreviatedTextToRender();
    }

    @Override
    protected boolean isSuggestionVisible() {
        return this.controllerAsia.suggestionsAvailable();
    }

    @Override
    protected boolean isCursorAtTheEndOfText(int n) {
        return true;
    }
}

