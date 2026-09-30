/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.utils;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.atip.hmi.model.TextEditorListenerDD;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.TextEditorModelDDApp;
import de.audi.atip.log.LogChannel;

public final class EditorModelListener
implements TextEditorListenerDD {
    private final TextEditorModelDDApp model;
    private final ChoiceModelApp textStateModel;
    private LabelModelApp completeTextModel;
    private final SDSHandlerService sdsHandlerService;
    private LogChannel lc = Logger.getMainLog();
    private final String name;

    private EditorModelListener(TextEditorModelDDApp textEditorModelDDApp, LabelModelApp labelModelApp, ChoiceModelApp choiceModelApp, SDSHandlerService sDSHandlerService, LogChannel logChannel) {
        this.name = "EditorModelListener";
        this.model = textEditorModelDDApp;
        this.completeTextModel = labelModelApp;
        this.textStateModel = choiceModelApp;
        this.sdsHandlerService = sDSHandlerService;
        if (logChannel != null) {
            this.lc = logChannel;
        }
    }

    public static EditorModelListener registerListener(TextEditorModelDDApp textEditorModelDDApp, LabelModelApp labelModelApp, ChoiceModelApp choiceModelApp, SDSHandlerService sDSHandlerService, LogChannel logChannel) {
        EditorModelListener editorModelListener = new EditorModelListener(textEditorModelDDApp, labelModelApp, choiceModelApp, sDSHandlerService, logChannel);
        editorModelListener.model.addListener(editorModelListener);
        return editorModelListener;
    }

    public void updateTextModelInfo() {
        this.completeTextModel.setText(this.model.getText());
        this.textStateModel.setValue(this.model == null || this.model.getText().length() == 0 ? 1 : 0);
    }

    public void openAlternativesList(int n, int n2, int n3) {
        this.lc.log(10000000, "%1#openAlternativesList: modelID=%2, index=%3", (Object)this.getName(), (long)n, (long)n2);
        if (!this.isSDSActive()) {
            this.lc.log(10000000, "%1#openAlternativesList: SDS not active => NOP!", (Object)this.getName());
            return;
        }
        this.sdsHandlerService.sendEvent(35000);
    }

    public boolean alternativeSelected(boolean bl, int n, int n2, int n3) {
        boolean bl2 = bl;
        this.lc.log(10000000, "%1#alternativeSelected: modelID=%2, index=%3", (Object)this.getName(), (long)n, (long)n2);
        if (!this.isSDSActive()) {
            this.lc.log(10000000, "%1#alternativeSelected: SDS inactive => NOP!");
            return bl2;
        }
        if (!bl2) {
            bl2 = this.model.selectAlternative(n2);
        }
        String string = this.model.getSyncedModel().getSelectedWord();
        SDSModelAccess.setMsgWordPromptLabel(string);
        this.updateTextModelInfo();
        this.sdsHandlerService.sendEvent(1009);
        return bl2;
    }

    public void textChanged(int n, int n2, int n3) {
        this.lc.log(10000000, "%1#textChanged: modelID=%2, index=%3", (Object)this.getName(), (long)n, (long)n2);
        if (!this.isSDSActive()) {
            this.lc.log(10000000, "%1#textChanged: SDS inactive => NOP!");
            return;
        }
        this.updateTextModelInfo();
    }

    public void commandPressed(int n, int n2, int n3) {
        this.lc.log(10000000, "%1#textChanged: modelID=%2, command=%3", (Object)this.getName(), (long)n, (long)n2);
        if (!this.isSDSActive()) {
            this.lc.log(10000000, "%1#commandPressed: SDS inactive => NOP!");
            return;
        }
        int n4 = n2 == 2 ? 35001 : (n2 == 1 ? 1010 : 75001);
        this.sdsHandlerService.sendEvent(n4);
    }

    private boolean isSDSActive() {
        return this.sdsHandlerService.isSDSActive();
    }

    private String getName() {
        this.getClass();
        return "EditorModelListener";
    }

    public void maxTextLengthChanged(int n) {
    }
}

