/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.texteditor;

import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.texteditor.IExtendedTextEditor;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import de.audi.atip.hmi.modelaccess.TextEditorModelApp;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public final class ExtendedTextEditor
extends AbstractDictationComponent
implements IExtendedTextEditor {
    private static final int TRUNCATION_INDEX_NONE = -1;
    private final TextEditorModelApp textEditorModel = this.framework.getHmiServiceApp().getTextEditorModel(153);
    private volatile int truncationIndex = -1;

    public ExtendedTextEditor(BundleEnvironment bundleEnvironment) {
        super(bundleEnvironment, "App.SDS.Dictation");
    }

    private void setLastDictationText(String string) {
        this.log.log(10000000, "[ExtendedTextEditor#setLastDictationText]");
        this.framework.getHmiServiceApp().getLabelModel(271).setText(string);
    }

    private void setTruncationIndex(int n) {
        this.log.log(10000000, "[ExtendedTextEditor#setTruncationIndex] truncationIndex = %1", (long)n);
        this.truncationIndex = n;
        int n2 = n == -1 ? 0 : 1;
        this.framework.getHmiServiceApp().getChoiceModel(3881).setValue(n2);
    }

    private static String mapToString(LinkedList linkedList) {
        Buffer buffer = new Buffer(linkedList.size() * 4);
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            String[] stringArray = (String[])iterator.next();
            buffer.append(stringArray[0]);
        }
        return buffer.toString();
    }

    private static LinkedList mapToTextList(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, " ,.?!-\"\\:;()<>=@~/%#\u00a7\u0080$\n", true);
        LinkedList linkedList = new LinkedList();
        while (stringTokenizer.hasMoreTokens()) {
            linkedList.add(new String[]{stringTokenizer.nextToken()});
        }
        return linkedList;
    }

    private static LinkedList concatDictationText(LinkedList linkedList, LinkedList linkedList2) {
        LinkedList linkedList3 = null;
        if (linkedList.isEmpty()) {
            linkedList3 = new LinkedList(linkedList2);
        } else if (linkedList2.isEmpty()) {
            linkedList3 = new LinkedList(linkedList);
        } else {
            String string;
            linkedList3 = new LinkedList(linkedList);
            boolean bl = true;
            String[] stringArray = (String[])linkedList.getLast();
            String[] stringArray2 = (String[])linkedList.getFirst();
            if (stringArray != null && stringArray.length == 1 && (string = stringArray[0]) != null && string.length() == 1) {
                boolean bl2 = bl = !Character.isWhitespace(string.charAt(0));
            }
            if (bl && stringArray2 != null && stringArray2.length == 1 && (string = stringArray2[0]) != null && string.length() == 1) {
                boolean bl3 = bl = !Character.isWhitespace(string.charAt(0));
            }
            if (bl) {
                linkedList3.add(new String[]{" "});
            }
            linkedList3.addAll(linkedList2);
        }
        return linkedList3;
    }

    private static LinkedList truncateDictationText(LinkedList linkedList, int n) {
        return new LinkedList(linkedList.subList(0, n));
    }

    private static void setText(TextEditorModelApp textEditorModelApp, LinkedList linkedList, boolean bl, int n, LogChannel logChannel) {
        logChannel.log(10000000, "[TextEditorUtil#setTextEditorContent] hasAlternatives = %1, focusedIndex = %2", bl, (long)n);
        int n2 = n;
        int n3 = linkedList.size();
        if (n != 0) {
            if (n3 == 0) {
                n2 = 0;
            } else if (n < 0) {
                n2 = 0;
            } else if (n > n3 - 1) {
                n2 = n3 - 1;
            }
            if (n2 != n) {
                logChannel.log(100000, "[TextEditorUtil#setTextEditorContent] focusedIndex out of bounds, adjusted value: %1 -> %2.", (long)n, (long)n2);
            }
        }
        int n4 = bl ? 1 : 0;
        textEditorModelApp.setDictationMode(n4);
        textEditorModelApp.setText(linkedList);
    }

    private static void addCaseAlternative(LinkedList linkedList, LogChannel logChannel) {
        try {
            String string;
            String[] stringArray;
            if (!linkedList.isEmpty() && (stringArray = (String[])linkedList.getFirst()) != null && stringArray.length == 1 && (string = stringArray[0]) != null && string.length() > 0) {
                char c2 = string.charAt(0);
                String string2 = null;
                if (Character.isUpperCase(c2)) {
                    string2 = string.toLowerCase();
                } else if (Character.isLowerCase(c2)) {
                    string2 = string.toUpperCase();
                }
                if (string2 != null) {
                    String[] stringArray2 = new String[]{string, string2};
                    linkedList.set(0, stringArray2);
                }
            }
        }
        catch (Exception exception) {
            DictationUtil.logException(logChannel, exception, "[TextEditorUtil#addCaseAlternative]");
        }
    }

    public TextEditorModelApp getTextEditorModelApp() {
        return this.textEditorModel;
    }

    public void editorTextChanged() {
        this.log.log(10000000, "[ExtendedTextEditor#editorTextChanged]");
        this.setTruncationIndex(-1);
    }

    public void clear() {
        this.truncationIndex = -1;
        this.setText("");
    }

    public void setText(String string) {
        this.log.log(10000000, "[ExtendedTextEditor#setText]");
        ExtendedTextEditor.setText(this.textEditorModel, ExtendedTextEditor.mapToTextList(string), false, 0, this.log);
    }

    public void setText(LinkedList linkedList, int n) {
        this.log.log(10000000, "[ExtendedTextEditor#setText] focusedIndex = %1", (long)n);
        ExtendedTextEditor.setText(this.textEditorModel, linkedList, true, n, this.log);
    }

    public void append(LinkedList linkedList) {
        this.log.log(10000000, "[ExtendedTextEditor#append]");
        String string = ExtendedTextEditor.mapToString(linkedList);
        this.setLastDictationText(string);
        LinkedList linkedList2 = null;
        LinkedList linkedList3 = this.textEditorModel.getText();
        linkedList2 = ExtendedTextEditor.concatDictationText(linkedList3, linkedList);
        int n = linkedList3.size();
        this.setTruncationIndex(n);
        ExtendedTextEditor.setText(this.textEditorModel, linkedList2, true, 0, this.log);
    }

    public void undoAppend() {
        this.log.log(10000000, "[ExtendedTextEditor#undoAppend]");
        if (this.truncationIndex == -1) {
            throw new IllegalStateException("Nothing to undo.");
        }
        LinkedList linkedList = this.textEditorModel.getText();
        LinkedList linkedList2 = ExtendedTextEditor.truncateDictationText(linkedList, this.truncationIndex);
        this.truncationIndex = -1;
        ExtendedTextEditor.setText(this.textEditorModel, linkedList2, true, 0, this.log);
    }

    public void replaceSelection(LinkedList linkedList) {
        this.log.log(10000000, "[ExtendedTextEditor#replaceSelection]");
        String string = ExtendedTextEditor.mapToString(linkedList);
        this.setLastDictationText(string);
        ExtendedTextEditor.addCaseAlternative(linkedList, this.log);
        this.editorTextChanged();
    }
}

