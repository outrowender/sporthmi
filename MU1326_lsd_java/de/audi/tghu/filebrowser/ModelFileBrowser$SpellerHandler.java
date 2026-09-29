/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.filebrowser;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.MatchspellerListenerAsia;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelAsiaApp;
import de.audi.tghu.filebrowser.ModelFileBrowser;
import de.audi.tghu.filebrowser.ModelFileBrowser$1;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;

final class ModelFileBrowser$SpellerHandler
implements MatchspellerListenerAsia {
    private final MatchspellerModelApp speller;
    private final ListModelApp preview;
    private boolean active = false;
    private final /* synthetic */ ModelFileBrowser this$0;

    private ModelFileBrowser$SpellerHandler(ModelFileBrowser modelFileBrowser, MatchspellerModelApp matchspellerModelApp, ListModelApp listModelApp) {
        this.this$0 = modelFileBrowser;
        this.speller = matchspellerModelApp;
        this.preview = listModelApp;
        listModelApp.setMaxColumns(4);
        matchspellerModelApp.setSpellerListener(this);
        matchspellerModelApp.setMaxLength(128);
    }

    private boolean isActive() {
        return this.active;
    }

    private void setActive(boolean bl) {
        if (bl) {
            this.start();
        } else {
            this.stop();
        }
    }

    private void cleanup() {
        this.this$0.getLog().log(-2137614336, "ModelFileBrowser.SpellerHandler.cleanup()");
        this.stop();
        this.speller.setSpellerListener(null);
    }

    private void start() {
        this.this$0.getLog().log(-2137614336, "ModelFileBrowser.SpellerHandler.start()");
        this.stop();
        this.active = true;
        this.showBusySpellerCursor(true);
        this.speller.clear();
        this.preview.clear();
        this.this$0.startSpeller();
    }

    private void stop() {
        this.this$0.getLog().log(-2137614336, "ModelFileBrowser.SpellerHandler.stop()");
        if (this.isActive()) {
            this.active = false;
            this.this$0.stopSpeller();
            this.showBusySpellerCursor(false);
        }
    }

    private void showBusySpellerCursor(boolean bl) {
        this.this$0.getLog().log(-2137614336, "ModelFileBrowser.SpellerHandler.showBusyCursor(%1)", bl);
        this.speller.setStatus(bl ? 0 : 1);
        this.preview.setStatus(bl ? 0 : 1);
    }

    private void spellerResult(String string, String string2) {
        this.this$0.getLog().log(1078071040, "[ModelFileBrowser#spellerResult] uniqueChars : %1, validChars : %2", (Object)string, (Object)string2);
        if (this.active) {
            this.speller.setText(string);
            this.speller.setValidChars(string2);
            ModelFileBrowser.access$800(this.this$0);
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        Object object;
        this.this$0.getLog().log(-2137614336, "ModelFileBrowser.SpellerHandler.keyTyped(%1, %2)", (long)n, (long)n2);
        if (this.speller.getMatchCount() == 1 && (object = this.preview.getCell(0, 3)) != null && object instanceof ObjectListCell) {
            BrowsedFile browsedFile = (BrowsedFile)((ObjectListCell)object).getValue();
            boolean bl = !browsedFile.isSelected();
            ModelFileBrowser.access$900(this.this$0, browsedFile, bl);
            this.this$0.spellerHandler.stop();
            this.this$0.jumpToEntry(browsedFile);
            this.speller.fireEvent(n3);
            return;
        }
        object = this.this$0.getSearchFilteredList();
        if (null != object) {
            object.clearAll();
        }
        ModelFileBrowser.access$1000(this.this$0);
        this.speller.fireEvent(n3);
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.this$0.getLog().log(-2137614336, "ModelFileBrowser.SpellerHandler.textChanged(%1, %2)", (Object)string, (long)c2);
        if (n == this.speller.getID()) {
            if (c2 == '\r') {
                this.this$0.getLog().log(-2137614336, "ModelFileBrowser.SpellerHandler.textChanged: ignore lastest char 13 ( = CR )");
                return;
            }
            if (string == null || "".equals(string)) {
                this.start();
            } else if (c2 == '\b') {
                this.showBusySpellerCursor(true);
                ModelFileBrowser.access$1100(this.this$0);
            } else {
                this.showBusySpellerCursor(true);
                ModelFileBrowser.access$1200(this.this$0, new String(new char[]{c2}));
            }
        }
    }

    @Override
    public void nonAlphaNumTPCharsChanged(int n, int n2, String string) {
        this.this$0.getLog().log(-2137614336, "ModelFileBrowser.SpellerHandler.nonAlphaNumTPCharsChanged(%2, %3, %1)", (Object)string, (long)n, (long)n2);
        ModelFileBrowser.access$1300(this.this$0, string);
    }

    private void updatePreview(BrowsedFileSet browsedFileSet, int n) {
        this.this$0.getLog().log(-2137614336, "ModelFileBrowser.SpellerHandler.updatePreview(%1, %2)", (Object)browsedFileSet, (long)n);
        this.preview.beginTransaction();
        this.preview.clear();
        BrowsedFile[] browsedFileArray = browsedFileSet.getFiles();
        this.preview.setMaxRows(browsedFileArray.length);
        for (int i2 = 0; i2 < browsedFileArray.length; ++i2) {
            this.preview.addRow(new ListCell[]{IntegerListCell.create(i2), new TextListCell(browsedFileArray[i2].getFilename()), new LongListCell(browsedFileArray[i2].getId()), new ObjectListCell(browsedFileArray[i2])});
        }
        this.preview.endTransaction();
        this.showBusySpellerCursor(false);
    }

    private void updateMatchCount(int n) {
        this.this$0.getLog().log(-2137614336, "ModelFileBrowser.SpellerHandler.updateMatchCount(%1)", (long)n);
        this.speller.setMatchCount(n);
    }

    private void setValidNonAlphaNumTPCharacters(String string) {
        this.this$0.getLog().log(-2137614336, "ModelFileBrowser.SpellerHandler.setValidNonAlphaNumTPCharacters( %1 )", (Object)string);
        try {
            ((MatchspellerModelAsiaApp)this.speller).setValidNonAlphaNumTPCharacters(string);
        }
        catch (ClassCastException classCastException) {
            this.this$0.getLog().log(10000, "ModelFileBrowser.SpellerHandler.setValidNonAlphaNumTPCharacters failed! This is no asis speller model!", (Throwable)classCastException);
        }
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
        this.this$0.getLog().log(-2137614336, "ModelFileBrowser.SpellerHandler.commandPressed(%1, %2)", (long)n, (long)n2);
    }

    @Override
    public void inputModeTPChanged(int n, int n2, int n3) {
        this.this$0.getLog().log(-2137614336, "ModelFileBrowser.SpellerHandler.inputModeTPChanged(%1, %2, %3)", (long)n, (long)n3, (long)n3);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.this$0.getLog().log(-2137614336, "ModelFileBrowser.SpellerHandler.keyReleased(%1, %2)", (long)n, (long)n2);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.this$0.getLog().log(-2137614336, "ModelFileBrowser.SpellerHandler.keyPressed(%1, %2)", (long)n, (long)n2);
    }

    @Override
    public void strokesChanged(int n, int n2, String string, char c2) {
        this.this$0.getLog().log(-2137614336, "ModelFileBrowsers.strokesChanged - modelId=%1, strokes=%2, lastStroke=%3", (Object)String.valueOf(n), (Object)string, (long)c2);
    }

    @Override
    public void requestValidHanziCharsWindow(int n, int n2, int n3, int n4) {
        this.this$0.getLog().log(-2137614336, "%ModelFileBrowser.getValidHanziCharsWindow - modelId=%1, offset=%2, windowSize=%3", (Object)String.valueOf(n), (Object)String.valueOf(n3), (Object)String.valueOf(n4));
    }

    static /* synthetic */ void access$000(ModelFileBrowser$SpellerHandler modelFileBrowser$SpellerHandler) {
        modelFileBrowser$SpellerHandler.cleanup();
    }

    static /* synthetic */ boolean access$100(ModelFileBrowser$SpellerHandler modelFileBrowser$SpellerHandler) {
        return modelFileBrowser$SpellerHandler.isActive();
    }

    /* synthetic */ ModelFileBrowser$SpellerHandler(ModelFileBrowser modelFileBrowser, MatchspellerModelApp matchspellerModelApp, ListModelApp listModelApp, ModelFileBrowser$1 modelFileBrowser$1) {
        this(modelFileBrowser, matchspellerModelApp, listModelApp);
    }

    static /* synthetic */ void access$300(ModelFileBrowser$SpellerHandler modelFileBrowser$SpellerHandler, boolean bl) {
        modelFileBrowser$SpellerHandler.setActive(bl);
    }

    static /* synthetic */ void access$400(ModelFileBrowser$SpellerHandler modelFileBrowser$SpellerHandler, BrowsedFileSet browsedFileSet, int n) {
        modelFileBrowser$SpellerHandler.updatePreview(browsedFileSet, n);
    }

    static /* synthetic */ void access$500(ModelFileBrowser$SpellerHandler modelFileBrowser$SpellerHandler, int n) {
        modelFileBrowser$SpellerHandler.updateMatchCount(n);
    }

    static /* synthetic */ void access$600(ModelFileBrowser$SpellerHandler modelFileBrowser$SpellerHandler, String string, String string2) {
        modelFileBrowser$SpellerHandler.spellerResult(string, string2);
    }

    static /* synthetic */ void access$700(ModelFileBrowser$SpellerHandler modelFileBrowser$SpellerHandler, String string) {
        modelFileBrowser$SpellerHandler.setValidNonAlphaNumTPCharacters(string);
    }
}

