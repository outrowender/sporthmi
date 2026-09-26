/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting;

import de.audi.atip.interapp.IFormattingResponse;
import de.audi.atip.search.util.TextLineList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.addressformatting.FormattedHighlightedText;
import de.esolutions.fw.util.commons.Buffer;
import java.util.LinkedList;
import java.util.List;
import org.dsi.ifc.search.Token;

public class LocationFormattingResponse
implements IFormattingResponse {
    private List firstLine = new LinkedList();
    private List secondLine = new LinkedList();
    private List thirdLine = new LinkedList();

    public LocationFormattingResponse createOneLineLocationFormattingResponse() {
        int n;
        LocationFormattingResponse locationFormattingResponse = new LocationFormattingResponse();
        for (n = 0; n < this.firstLine.size(); ++n) {
            locationFormattingResponse.appendToFirstLine((FormattedHighlightedText)this.firstLine.get(n));
        }
        if (this.secondLine.size() > 0 && this.firstLine.size() > 0) {
            locationFormattingResponse.appendToFirstLine(new FormattedHighlightedText(", "));
        }
        for (n = 0; n < this.secondLine.size(); ++n) {
            locationFormattingResponse.appendToFirstLine((FormattedHighlightedText)this.secondLine.get(n));
        }
        return locationFormattingResponse;
    }

    public void appendToFirstLine(FormattedHighlightedText formattedHighlightedText) {
        this.firstLine.add(formattedHighlightedText);
    }

    public void appendToSecondLine(FormattedHighlightedText formattedHighlightedText) {
        this.secondLine.add(formattedHighlightedText);
    }

    public void appendToThirdLine(FormattedHighlightedText formattedHighlightedText) {
        this.thirdLine.add(formattedHighlightedText);
    }

    @Override
    public String getFirstLineAsText() {
        return this.getLineAsTextFrom(this.firstLine);
    }

    public TextLineList getFirstLineForTruffles() {
        return this.getLineForTrufflesFrom(this.firstLine);
    }

    @Override
    public String getSecondLineAsText() {
        return this.getLineAsTextFrom(this.secondLine);
    }

    public TextLineList getSecondLineForTruffles() {
        return this.getLineForTrufflesFrom(this.secondLine);
    }

    @Override
    public String getThirdLineAsText() {
        return this.getLineAsTextFrom(this.thirdLine);
    }

    public TextLineList getThirdLineForTruffles() {
        return this.getLineForTrufflesFrom(this.thirdLine);
    }

    private String getLineAsTextFrom(List list) {
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            buffer.append(((FormattedHighlightedText)list.get((int)i2)).formattedText);
        }
        return buffer.toString();
    }

    private TextLineList getLineForTrufflesFrom(List list) {
        TextLineList textLineList = new TextLineList();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            Token token = new Token(0, ((FormattedHighlightedText)list.get((int)i2)).formattedText, ((FormattedHighlightedText)list.get((int)i2)).highlightedTextPositions);
            textLineList.addToken(token);
        }
        return textLineList;
    }

    public void swapLines() {
        List list = this.firstLine;
        this.firstLine = this.secondLine;
        this.secondLine = list;
    }

    public List getFirstLineList() {
        return new LinkedList(this.firstLine);
    }

    public List getSecondLineList() {
        return new LinkedList(this.secondLine);
    }

    public List getThirdLineList() {
        return new LinkedList(this.thirdLine);
    }

    public void replaceFirstLine(List list) {
        this.firstLine = new LinkedList(list);
    }

    public void replaceSecondLine(List list) {
        this.secondLine = new LinkedList(list);
    }

    public void replaceThirdLine(List list) {
        this.thirdLine = new LinkedList(list);
    }

    @Override
    public String getPhoneticsAsText() {
        FormattedHighlightedText formattedHighlightedText;
        int n;
        Buffer buffer = new Buffer();
        for (n = 0; n < this.firstLine.size(); ++n) {
            formattedHighlightedText = (FormattedHighlightedText)this.firstLine.get(n);
            if (!formattedHighlightedText.isPhonetic()) continue;
            buffer.append(formattedHighlightedText.phonemeText);
        }
        for (n = 0; n < this.secondLine.size(); ++n) {
            formattedHighlightedText = (FormattedHighlightedText)this.secondLine.get(n);
            if (!formattedHighlightedText.isPhonetic()) continue;
            buffer.append(formattedHighlightedText.phonemeText);
        }
        return buffer.toString();
    }

    public String getPhoneticsAsTextForPAGAsia(NavigationEnv navigationEnv) {
        Buffer buffer = new Buffer();
        int n = navigationEnv.getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageIndex();
        if (n == 15 || n == 13 || n == 17 || n == 25) {
            FormattedHighlightedText formattedHighlightedText;
            int n2;
            for (n2 = this.secondLine.size() - 1; n2 >= 0; --n2) {
                formattedHighlightedText = (FormattedHighlightedText)this.secondLine.get(n2);
                if (!formattedHighlightedText.isPhonetic()) continue;
                buffer.append(formattedHighlightedText.phonemeText);
            }
            for (n2 = this.firstLine.size() - 1; n2 >= 0; --n2) {
                formattedHighlightedText = (FormattedHighlightedText)this.firstLine.get(n2);
                if (!formattedHighlightedText.isPhonetic()) continue;
                buffer.append(formattedHighlightedText.phonemeText);
            }
        } else {
            FormattedHighlightedText formattedHighlightedText;
            int n3;
            for (n3 = 0; n3 < this.secondLine.size(); ++n3) {
                formattedHighlightedText = (FormattedHighlightedText)this.secondLine.get(n3);
                if (!formattedHighlightedText.isPhonetic()) continue;
                buffer.append(formattedHighlightedText.phonemeText);
            }
            for (n3 = 0; n3 < this.firstLine.size(); ++n3) {
                formattedHighlightedText = (FormattedHighlightedText)this.firstLine.get(n3);
                if (!formattedHighlightedText.isPhonetic()) continue;
                buffer.append(formattedHighlightedText.phonemeText);
            }
        }
        return buffer.toString();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        if (!this.firstLine.isEmpty()) {
            buffer.append("#1 - ").append(this.getFirstLineAsText()).append('\n');
        }
        if (!this.secondLine.isEmpty()) {
            buffer.append("#2 - ").append(this.getSecondLineAsText()).append('\n');
        }
        if (!this.thirdLine.isEmpty()) {
            buffer.append("#3 - ").append(this.getThirdLineAsText()).append('\n');
        }
        return buffer.toString();
    }
}

