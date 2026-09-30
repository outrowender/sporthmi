/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.texteditor;

import de.audi.atip.hmi.model.TextEditorListenerDD;
import de.audi.atip.hmi.model.texteditor.DoubleCursor;
import de.audi.atip.hmi.modelaccess.ICopyTo;
import de.audi.atip.hmi.modelaccess.TextEditorModelDDApp;

public class TextEditorModelDDSynced
implements TextEditorModelDDApp {
    protected TextEditorModelDDApp m_wrapped;

    public static TextEditorModelDDSynced newInstance(TextEditorModelDDApp textEditorModelDDApp) {
        return textEditorModelDDApp != null ? new TextEditorModelDDSynced(textEditorModelDDApp) : null;
    }

    private TextEditorModelDDSynced(TextEditorModelDDApp textEditorModelDDApp) {
        this.m_wrapped = textEditorModelDDApp;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean copyTo(ICopyTo iCopyTo) {
        boolean bl = false;
        try {
            this.m_wrapped.lock();
            bl = this.m_wrapped.copyTo(iCopyTo);
        }
        finally {
            this.m_wrapped.unlock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean setText(String[][] stringArray, int n) {
        boolean bl = false;
        try {
            this.m_wrapped.lock();
            bl = this.m_wrapped.setText(stringArray, n);
        }
        finally {
            this.m_wrapped.unlock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean setText(String string, int n) {
        boolean bl = false;
        try {
            this.m_wrapped.lock();
            bl = this.m_wrapped.setText(string, n);
        }
        finally {
            this.m_wrapped.unlock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean replace(String[][] stringArray) {
        boolean bl = false;
        try {
            this.m_wrapped.lock();
            bl = this.m_wrapped.replace(stringArray);
        }
        finally {
            this.m_wrapped.unlock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean replace(String string) {
        boolean bl = false;
        try {
            this.m_wrapped.lock();
            bl = this.m_wrapped.replace(string);
        }
        finally {
            this.m_wrapped.unlock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean append(String[][] stringArray, int n) {
        boolean bl = false;
        try {
            this.m_wrapped.lock();
            bl = this.m_wrapped.append(stringArray, n);
        }
        finally {
            this.m_wrapped.unlock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean append(String string, int n) {
        boolean bl = false;
        try {
            this.m_wrapped.lock();
            bl = this.m_wrapped.append(string, n);
        }
        finally {
            this.m_wrapped.unlock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getLastInsertion() {
        String string = null;
        try {
            this.m_wrapped.lock();
            string = this.m_wrapped.getLastInsertion();
        }
        finally {
            this.m_wrapped.unlock();
        }
        return string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean undoLastInsertion() {
        boolean bl = false;
        try {
            this.m_wrapped.lock();
            bl = this.m_wrapped.undoLastInsertion();
        }
        finally {
            this.m_wrapped.unlock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getText() {
        String string = null;
        try {
            this.m_wrapped.lock();
            string = this.m_wrapped.getText();
        }
        finally {
            this.m_wrapped.unlock();
        }
        return string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getSelectedWord() {
        String string = null;
        try {
            this.m_wrapped.lock();
            string = this.m_wrapped.getSelectedWord();
        }
        finally {
            this.m_wrapped.unlock();
        }
        return string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String[] getAlternatives() {
        String[] stringArray = null;
        try {
            this.m_wrapped.lock();
            stringArray = this.m_wrapped.getAlternatives();
        }
        finally {
            this.m_wrapped.unlock();
        }
        return stringArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean selectAlternative(int n) {
        boolean bl = false;
        try {
            this.m_wrapped.lock();
            bl = this.m_wrapped.selectAlternative(n);
        }
        finally {
            this.m_wrapped.unlock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clear() {
        try {
            this.m_wrapped.lock();
            this.m_wrapped.clear();
        }
        finally {
            this.m_wrapped.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DoubleCursor getCursor() {
        DoubleCursor doubleCursor = null;
        try {
            this.m_wrapped.lock();
            doubleCursor = this.m_wrapped.getCursor();
        }
        finally {
            this.m_wrapped.unlock();
        }
        return doubleCursor;
    }

    public TextEditorModelDDApp getSyncedModel() {
        return this;
    }

    public boolean lock() {
        return this.m_wrapped.lock();
    }

    public void unlock() {
        this.m_wrapped.unlock();
    }

    public void resetListener() {
        this.m_wrapped.resetListener();
    }

    public void setListener(TextEditorListenerDD textEditorListenerDD) {
        this.m_wrapped.setListener(textEditorListenerDD);
    }

    public void addListener(TextEditorListenerDD textEditorListenerDD) {
        this.m_wrapped.addListener(textEditorListenerDD);
    }

    public void removeListener(TextEditorListenerDD textEditorListenerDD) {
        this.m_wrapped.removeListener(textEditorListenerDD);
    }

    public void setMaxLength(int n) {
        this.m_wrapped.setMaxLength(n);
    }

    public int getMaxLength() {
        return this.m_wrapped.getMaxLength();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean insert(String string) {
        boolean bl = false;
        try {
            this.m_wrapped.lock();
            bl = this.m_wrapped.insert(string);
        }
        finally {
            this.m_wrapped.unlock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean insert(String[] stringArray) {
        boolean bl = false;
        try {
            this.m_wrapped.lock();
            bl = this.m_wrapped.insert(stringArray);
        }
        finally {
            this.m_wrapped.unlock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean insert(String[][] stringArray) {
        boolean bl = false;
        try {
            this.m_wrapped.lock();
            bl = this.m_wrapped.insert(stringArray);
        }
        finally {
            this.m_wrapped.unlock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void remove(int n, int n2, int n3) {
        try {
            this.m_wrapped.lock();
            this.m_wrapped.remove(n, n2, n3);
        }
        finally {
            this.m_wrapped.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String validityCheck() {
        String string = null;
        try {
            this.m_wrapped.lock();
            string = this.m_wrapped.validityCheck();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            this.m_wrapped.unlock();
        }
        return string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setMode(int n) {
        try {
            this.m_wrapped.lock();
            this.m_wrapped.setMode(n);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            this.m_wrapped.unlock();
        }
    }
}

