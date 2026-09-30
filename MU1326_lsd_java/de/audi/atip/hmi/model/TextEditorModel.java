/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.TextEditorListener;
import de.audi.atip.hmi.modelaccess.TextEditorModelApp;
import de.audi.atip.hmi.modelaccess.TextEditorModelGUI;
import java.util.Iterator;
import java.util.LinkedList;

public class TextEditorModel
extends AbstractModel
implements TextEditorModelApp,
TextEditorModelGUI {
    private LinkedList textWithAlternatives = new LinkedList();
    private volatile TextEditorListener textEditorListener = DUMMY_LISTENER;
    private int dictationMode = 0;
    private int maxLength = -1;

    public TextEditorModel(int n) {
        super(n, 0);
    }

    public TextEditorModel(int n, int n2) {
        super(n, n2);
    }

    public boolean isEmpty() {
        return this.textWithAlternatives.size() == 0;
    }

    public int getModelType() {
        return 23;
    }

    public void resetListener() {
        this.textEditorListener = DUMMY_LISTENER;
    }

    public void setListener(TextEditorListener textEditorListener) {
        this.textEditorListener = textEditorListener != null ? textEditorListener : DUMMY_LISTENER;
    }

    public void openAlternativesList(int n, int n2) {
        try {
            this.textEditorListener.openAlternativesList(this.id, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void alternativeSelected(int n, int n2, int n3) {
        try {
            this.textEditorListener.alternativeSelected(this.id, n, n2, n3);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void textChanged(int n, int n2, int n3) {
        try {
            this.textEditorListener.textChanged(this.id, n, n2, n3);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void editedText(LinkedList linkedList) {
        Object object = this.mutex;
        synchronized (object) {
            if (linkedList == null) {
                linkedList = new LinkedList();
            }
            this.textWithAlternatives = linkedList;
            this.stateChanged();
        }
    }

    public void setText(LinkedList linkedList) {
        this.editedText(linkedList);
        this.fireModelUpdateEvent(6);
    }

    public LinkedList getText() {
        return this.textWithAlternatives;
    }

    public void setTextArray(String[][] stringArray) {
        LinkedList linkedList = new LinkedList();
        if (stringArray != null) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                linkedList.add(stringArray[i2]);
            }
        }
        this.editedText(linkedList);
        this.fireModelUpdateEvent(6);
    }

    public String[][] getTextArray() {
        String[][] stringArray = new String[this.textWithAlternatives.size()][];
        Iterator iterator = this.textWithAlternatives.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            String[] stringArray2 = (String[])iterator.next();
            stringArray[n++] = stringArray2;
        }
        return stringArray;
    }

    public void setDictationMode(int n) {
        this.dictationMode = n;
    }

    public void setMaxLength(int n) {
        this.maxLength = n;
    }

    public int getDictationMode() {
        return this.dictationMode;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public void commandPressed(int n, int n2) {
        try {
            this.textEditorListener.commandPressed(this.id, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }
}

