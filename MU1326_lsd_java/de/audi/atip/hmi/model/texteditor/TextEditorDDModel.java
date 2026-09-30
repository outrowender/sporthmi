/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.texteditor;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.TextEditorListenerDD;
import de.audi.atip.hmi.model.texteditor.DoubleCursor;
import de.audi.atip.hmi.model.texteditor.TextEditorModelDDSynced;
import de.audi.atip.hmi.modelaccess.ICopyTo;
import de.audi.atip.hmi.modelaccess.TextEditorModelDDApp;
import de.audi.atip.hmi.modelaccess.TextEditorModelDDGUI;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;

public class TextEditorDDModel
extends AbstractModel
implements TextEditorModelDDApp,
TextEditorModelDDGUI {
    protected DoubleCursor mCursor = new DoubleCursor(this);
    protected volatile TextEditorModelDDSynced syncedAccess = null;
    private volatile boolean emptyListenerList = true;
    private volatile ArrayList textEditorListenerList = new ArrayList();
    private volatile int maxTextLength = -1;
    private static final int MAX_CHARS = 16384;
    private boolean isReadOnlyMode = false;

    public TextEditorDDModel(int n) {
        super(n);
    }

    public TextEditorDDModel(int n, int n2) {
        super(n, n2);
    }

    public boolean isEmpty() {
        return this.mCursor.length() == 0;
    }

    public int getModelType() {
        return 29;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resetListener() {
        ArrayList arrayList = this.textEditorListenerList;
        synchronized (arrayList) {
            this.textEditorListenerList.clear();
            this.textEditorListenerList.add(DUMMY_LISTENER);
            this.emptyListenerList = true;
        }
    }

    public void setListener(TextEditorListenerDD textEditorListenerDD) {
        this.addListener(textEditorListenerDD);
    }

    public String[][] resizeToShort(String[][] stringArray) {
        int n = 0;
        int n2 = 0;
        for (int i2 = 0; i2 < stringArray.length && (n += stringArray[i2][0].length()) <= 16384; ++i2) {
            ++n2;
        }
        String[][] stringArray2 = new String[n2][];
        for (int i3 = 0; i3 < n2; ++i3) {
            stringArray2[i3] = new String[stringArray[i3].length];
            System.arraycopy((Object)stringArray[i3], 0, (Object)stringArray2[i3], 0, stringArray[i3].length);
        }
        return stringArray2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean setText(String[][] stringArray, int n) {
        stringArray = this.resizeToShort(stringArray);
        boolean bl = false;
        try {
            this.mCursor.freezeModelNotif();
            this.mCursor.clear();
            bl = this.appendImpl(stringArray, n);
        }
        finally {
            this.mCursor.unfreezeModelNotif();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean setText(String string, int n) {
        if (string.length() > 16384) {
            string = string.substring(0, 16384);
        }
        boolean bl = false;
        try {
            this.mCursor.freezeModelNotif();
            this.mCursor.clear();
            bl = this.appendImpl(string, n);
        }
        finally {
            this.mCursor.unfreezeModelNotif();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected boolean appendImpl(String[][] stringArray, int n) {
        try {
            this.mCursor.freezeModelNotif();
            int n2 = this.mCursor.getCursorPos();
            this.mCursor.setCursorPos(this.mCursor.length());
            this.mCursor.insertWords(stringArray);
            this.setCursor(n, n2);
        }
        finally {
            this.mCursor.unfreezeModelNotif();
        }
        return true;
    }

    public boolean append(String[][] stringArray, int n) {
        return this.appendImpl(stringArray, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected boolean appendImpl(String string, int n) {
        try {
            this.mCursor.freezeModelNotif();
            int n2 = this.mCursor.getCursorPos();
            this.mCursor.setCursorPos(this.mCursor.length());
            this.mCursor.insertWord(string);
            this.setCursor(n, n2);
        }
        finally {
            this.mCursor.unfreezeModelNotif();
        }
        return true;
    }

    public boolean append(String string, int n) {
        return this.appendImpl(string, n);
    }

    public String getLastInsertion() {
        return this.mCursor.lastAdded();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean undoLastInsertion() {
        boolean bl = false;
        try {
            this.mCursor.freezeModelNotif();
            bl = this.mCursor.removeLastAdded();
        }
        finally {
            this.mCursor.unfreezeModelNotif();
        }
        return bl;
    }

    public String getText() {
        return this.mCursor.getString();
    }

    public String getSelectedWord() {
        return this.mCursor.currentWord();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clear() {
        try {
            this.mCursor.freezeModelNotif();
            this.mCursor.clear();
        }
        finally {
            this.mCursor.unfreezeModelNotif();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean replace(String[][] stringArray) {
        boolean bl = false;
        try {
            this.mCursor.freezeModelNotif();
            boolean bl2 = bl = stringArray != null && stringArray.length > 0 && this.mCursor.removeWord()[0] != -1;
            if (bl) {
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    this.mCursor.insertWord(stringArray[i2]);
                }
            }
        }
        finally {
            this.mCursor.unfreezeModelNotif();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean replace(String string) {
        boolean bl;
        boolean bl2 = bl = string != null;
        if (bl) {
            try {
                this.mCursor.freezeModelNotif();
                this.mCursor.remove();
                this.mCursor.insertWord(string);
            }
            finally {
                this.mCursor.unfreezeModelNotif();
            }
        }
        return bl;
    }

    public String[] getAlternatives() {
        return this.mCursor.getAlternatives();
    }

    public boolean selectAlternative(int n) {
        return this.mCursor.selectAlternative(n);
    }

    public DoubleCursor getCursor() {
        return this.mCursor;
    }

    private void setCursor(int n, int n2) {
        switch (n) {
            case 0: {
                this.mCursor.setCursorPos(0);
                break;
            }
            case -2: {
                this.mCursor.setCursorPos(this.mCursor.length());
                break;
            }
            case -3: {
                this.mCursor.setCursorPos(n2);
                break;
            }
            default: {
                if (n <= 0) break;
                this.mCursor.setCursorPos(n);
            }
        }
    }

    public boolean copyTo(ICopyTo iCopyTo) {
        if (!(iCopyTo instanceof TextEditorDDModel)) {
            return false;
        }
        TextEditorDDModel textEditorDDModel = (TextEditorDDModel)iCopyTo;
        if (textEditorDDModel.mCursor == null) {
            return false;
        }
        return this.mCursor.copyTo(textEditorDDModel.mCursor);
    }

    public boolean lock() {
        return this.mCursor.mtxAquireLock();
    }

    public void unlock() {
        this.mCursor.mtxReleaseLock();
    }

    public synchronized TextEditorModelDDApp getSyncedModel() {
        if (this.syncedAccess == null) {
            this.syncedAccess = TextEditorModelDDSynced.newInstance(this);
        }
        return this.syncedAccess;
    }

    public String toString() {
        return this.getSyncedModel().getText();
    }

    public String dumpContent() {
        return super.dumpContent() + "\nText:\n" + this.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void notifyTextChanged(int n) {
        ArrayList arrayList = this.textEditorListenerList;
        synchronized (arrayList) {
            for (int i2 = 0; i2 < this.textEditorListenerList.size(); ++i2) {
                ((TextEditorListenerDD)this.textEditorListenerList.get(i2)).textChanged(this.id, n, this.getTerminalID());
            }
        }
        this.fireModelUpdateEvent(6);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void notifyMaxTextLengthChanged() {
        ArrayList arrayList = this.textEditorListenerList;
        synchronized (arrayList) {
            for (int i2 = 0; i2 < this.textEditorListenerList.size(); ++i2) {
                ((TextEditorListenerDD)this.textEditorListenerList.get(i2)).maxTextLengthChanged(this.maxTextLength);
            }
        }
        this.fireModelUpdateEvent(4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void notifyAlternativeSelected(int n) {
        ArrayList arrayList = this.textEditorListenerList;
        synchronized (arrayList) {
            boolean bl = false;
            for (int i2 = 0; i2 < this.textEditorListenerList.size(); ++i2) {
                bl = ((TextEditorListenerDD)this.textEditorListenerList.get(i2)).alternativeSelected(bl, this.id, bl ? 0 : n, this.getTerminalID()) | bl;
            }
        }
        this.fireModelUpdateEvent(10);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addListener(TextEditorListenerDD textEditorListenerDD) {
        ArrayList arrayList = this.textEditorListenerList;
        synchronized (arrayList) {
            if (textEditorListenerDD != null && !this.textEditorListenerList.contains(textEditorListenerDD)) {
                if (this.emptyListenerList) {
                    this.emptyListenerList = false;
                    this.textEditorListenerList.clear();
                }
                this.textEditorListenerList.add(textEditorListenerDD);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeListener(TextEditorListenerDD textEditorListenerDD) {
        ArrayList arrayList = this.textEditorListenerList;
        synchronized (arrayList) {
            int n = this.textEditorListenerList.indexOf(textEditorListenerDD);
            if (n != -1) {
                this.textEditorListenerList.remove(n);
                if (this.textEditorListenerList.isEmpty()) {
                    this.emptyListenerList = true;
                    this.textEditorListenerList.add(DUMMY_LISTENER);
                }
            }
        }
    }

    public synchronized void setMaxLength(int n) {
        int n2 = Math.max(-1, n);
        if (n2 != this.maxTextLength) {
            this.maxTextLength = n2;
            this.notifyMaxTextLengthChanged();
        }
    }

    public synchronized int getMaxLength() {
        return this.maxTextLength;
    }

    public boolean insert(String string) {
        boolean bl = false;
        if (string != null && string.length() > 0 && this.mCursor != null) {
            this.mCursor.insertWord(string);
        }
        return bl;
    }

    public boolean insert(String[] stringArray) {
        boolean bl = false;
        if (stringArray != null && stringArray.length > 0 && this.mCursor != null) {
            this.mCursor.insertWord(stringArray);
        }
        return bl;
    }

    public boolean insert(String[][] stringArray) {
        boolean bl = false;
        if (this.validateWords(stringArray) && this.mCursor != null) {
            this.mCursor.insertWords(stringArray);
        }
        return bl;
    }

    private boolean validateWords(String[][] stringArray) {
        boolean bl = true;
        if (stringArray != null && stringArray.length > 0) {
            block0: for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (stringArray[i2] == null || stringArray[i2].length < 1) {
                    bl = false;
                    break;
                }
                for (int i3 = 0; i3 < stringArray[i2].length; ++i3) {
                    if (stringArray[i2][i3] != null && stringArray[i2][i3].length() >= 1) continue;
                    bl = false;
                    continue block0;
                }
            }
        }
        return bl;
    }

    public void remove(int n, int n2, int n3) {
        this.mCursor.remove(n, n2, n3);
    }

    public String validityCheck() {
        return this.mCursor.vaildityCheck();
    }

    public void setMode(int n) {
        if (n == 1) {
            this.lc.log(10000000, "TextEditorDDModel#setMode new mode: READONLY_ACTIVE");
            this.isReadOnlyMode = true;
        } else if (n == 0) {
            this.lc.log(10000000, "TextEditorDDModel#setMode new mode: READONLY_NOT_ACTIVE");
            this.isReadOnlyMode = false;
        } else {
            this.lc.log(10000, "TextEditorDDModel#setMode try to set wrong mode [%1]!", (long)n);
            return;
        }
        this.fireModelUpdateEvent(20);
    }

    public boolean isReadOnly() {
        return this.isReadOnlyMode;
    }

    public LogChannel getModelLogChannel() {
        return this.lc;
    }
}

