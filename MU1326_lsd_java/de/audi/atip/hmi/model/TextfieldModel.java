/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.modelaccess.TextfieldModelApp;
import de.audi.atip.hmi.modelaccess.TextfieldModelGUI;
import de.esolutions.fw.util.commons.Buffer;

public class TextfieldModel
extends ButtonModel
implements TextfieldModelGUI,
TextfieldModelApp {
    public static final int TEXT1_CHANGED = 1;
    public static final int TEXT2_CHANGED = 2;
    public static final int BOTH_TEXTS_CHANGED = 3;
    public static final int BITMAP_CHANGED = 4;
    private String mText1 = "";
    private String mText2 = "";
    private int iconRessourceID = -1;

    public TextfieldModel(int n) {
        super(n);
    }

    public TextfieldModel(int n, int n2) {
        super(n, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String dumpContent() {
        Buffer buffer = new Buffer(100);
        buffer.append(super.dumpContent());
        Object object = this.mutex;
        synchronized (object) {
            buffer.append("\nmText1: ");
            buffer.append(this.mText1);
            buffer.append("\nmText2: ");
            buffer.append(this.mText2);
            buffer.append("\niconRessourceID: ");
            buffer.append(this.iconRessourceID);
        }
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void copy(AbstractModel abstractModel) {
        try {
            Object object = this.mutex;
            synchronized (object) {
                TextfieldModel textfieldModel = (TextfieldModel)abstractModel;
                this.mText1 = textfieldModel.mText1;
                this.mText2 = textfieldModel.mText2;
                this.iconRessourceID = textfieldModel.iconRessourceID;
                this.setChangeState(textfieldModel.getChangeState());
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "(%2) TextfieldModel.copy( %1 ) failed! ", (Object)abstractModel, (long)this.id);
            this.lc.log(10000, "ERROR: ", (Throwable)exception);
        }
    }

    public int getModelType() {
        return 8;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getText1() {
        Object object = this.mutex;
        synchronized (object) {
            return this.mText1;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getText2() {
        Object object = this.mutex;
        synchronized (object) {
            return this.mText2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setText1(String string) {
        Object object = this.mutex;
        synchronized (object) {
            this.mText1 = string;
            this.stateChanged();
        }
        this.fireModelUpdateEvent(1, 1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setText2(String string) {
        Object object = this.mutex;
        synchronized (object) {
            this.mText2 = string;
            this.stateChanged();
        }
        this.fireModelUpdateEvent(1, 2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setTexts(String string, String string2) {
        Object object = this.mutex;
        synchronized (object) {
            this.mText1 = string;
            this.mText2 = string2;
            this.stateChanged();
        }
        this.fireModelUpdateEvent(1, 3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setBitmapResourceID(int n) {
        Object object = this.mutex;
        synchronized (object) {
            this.iconRessourceID = n;
            this.stateChanged();
        }
        this.fireModelUpdateEvent(1, 4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getBitmapRessourceID() {
        Object object = this.mutex;
        synchronized (object) {
            return this.iconRessourceID;
        }
    }
}

