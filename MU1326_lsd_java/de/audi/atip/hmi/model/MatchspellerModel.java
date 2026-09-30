/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.MatchspellerListenerAsia;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.SpellerModel;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelGUI;
import de.esolutions.fw.util.commons.Buffer;

public class MatchspellerModel
extends SpellerModel
implements MatchspellerModelApp,
MatchspellerModelGUI {
    public static final int MATCH_COUNT_UNDEFINED = -1;
    private static final String DEFAULT_VALID_CHARS = "abcdefghijklmnopqrstuvwxyz0123456789";
    private String mValidChars = "abcdefghijklmnopqrstuvwxyz0123456789";
    private boolean mZIPFlag;
    private boolean fullMatch;
    private boolean uniqueMatch;
    private int hits;
    private int matchCountVisibility = -1;
    private int language = -1;
    private String phoneme = null;
    private String phonemeAlphabet = null;
    private MatchspellerListenerAsia asiaSpellerListener = DUMMY_LISTENER;
    private String validNonAlphaNumTPChars;
    private int nonAlphaNumMode;
    private int initialInputMode;
    private boolean allowNonAlphaNumInput = true;
    private String validCharacters;
    private int validCharactersAmount;

    public MatchspellerModel(int n) {
        super(n, 0);
    }

    public MatchspellerModel(int n, int n2) {
        super(n, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String dumpContent() {
        Buffer buffer = new Buffer(1000);
        buffer.append(super.dumpContent());
        Object object = this.mutex;
        synchronized (object) {
            buffer.append("\nmValidChars: ");
            buffer.append(this.mValidChars);
            buffer.append("\nphonemeString: ");
            buffer.append(this.phoneme);
            buffer.append("\nmZIPFlag: ");
            buffer.append(this.mZIPFlag);
            buffer.append("\nfullMatch: ");
            buffer.append(this.fullMatch);
            buffer.append("\nuniqueMatch: ");
            buffer.append(this.uniqueMatch);
            buffer.append("\nhits: ");
            buffer.append(this.hits);
            buffer.append("\nmatchCountVisibility: ");
            buffer.append(this.matchCountVisibility);
            buffer.append("\nlanguage: ");
            buffer.append(this.language);
            buffer.append("\nvalidNonAlphaNumTPChars: ");
            buffer.append(this.validNonAlphaNumTPChars);
            buffer.append("\nnonAlphaNumMode: ");
            buffer.append(this.nonAlphaNumMode);
            buffer.append("\ninitialInputMode: ");
            buffer.append(this.initialInputMode);
        }
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void copy(AbstractModel abstractModel) {
        try {
            Object object = this.mutex;
            synchronized (object) {
                MatchspellerModel matchspellerModel = (MatchspellerModel)abstractModel;
                this.mValidChars = matchspellerModel.mValidChars;
                this.mZIPFlag = matchspellerModel.mZIPFlag;
                this.fullMatch = matchspellerModel.fullMatch;
                this.uniqueMatch = matchspellerModel.uniqueMatch;
                this.hits = matchspellerModel.hits;
                this.language = matchspellerModel.language;
                this.phoneme = matchspellerModel.phoneme;
                this.validNonAlphaNumTPChars = matchspellerModel.validNonAlphaNumTPChars;
                this.nonAlphaNumMode = matchspellerModel.nonAlphaNumMode;
                this.initialInputMode = matchspellerModel.initialInputMode;
                super.copy(matchspellerModel);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "(%2) .MatchspellerModel.copy( %1 ) failed! ", (Object)abstractModel, (long)this.id);
            this.lc.log(10000, "ERROR: ", (Throwable)exception);
        }
    }

    public int getModelType() {
        return 7;
    }

    public String getValidChars() {
        return this.mValidChars;
    }

    public void setValidChars(String string) {
        this.setValidChars(string, -1, -1);
    }

    public void setValidChars(String string, int n) {
        this.setValidChars(string, n, -1);
    }

    public void setValidChars(String string, int n, int n2) {
        this.mValidChars = string;
        this.setControlButtonStates(n, n2);
    }

    public void setZIPFlag(boolean bl) {
        this.mZIPFlag = bl;
    }

    public boolean isZIP() {
        return this.mZIPFlag;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clear() {
        Object object = this.mutex;
        synchronized (object) {
            this.mValidChars = DEFAULT_VALID_CHARS;
            this.mZIPFlag = false;
            this.uniqueMatch = false;
            this.fullMatch = false;
            this.hits = 0;
            this.matchCountVisibility = -1;
            this.phoneme = null;
            super.clear();
        }
    }

    public void setMatchCount(int n) {
        this.setMatchCount(n, -1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setMatchCount(int n, int n2) {
        Object object = this.mutex;
        synchronized (object) {
            this.hits = n;
            this.matchCountVisibility = n2;
            this.stateChanged();
        }
        this.fireModelUpdateEvent(6);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setUniqueMatch(boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            this.uniqueMatch = bl;
            this.stateChanged();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setFullMatch(boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            this.fullMatch = bl;
            this.stateChanged();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getMatchCountVisibility() {
        Object object = this.mutex;
        synchronized (object) {
            return this.matchCountVisibility;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getMatchCount() {
        Object object = this.mutex;
        synchronized (object) {
            return this.hits;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isUniqueMatch() {
        Object object = this.mutex;
        synchronized (object) {
            return this.uniqueMatch;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isFullMatch() {
        Object object = this.mutex;
        synchronized (object) {
            return this.fullMatch;
        }
    }

    public void setLanguage(int n) {
        this.language = n;
    }

    public int getLanguage() {
        return this.language;
    }

    public void setPhonemeText(String string, String string2) {
        this.phoneme = string;
        this.phonemeAlphabet = string2;
    }

    public String getPhonemeAlphabet() {
        return this.phonemeAlphabet;
    }

    public String getPhonemeText() {
        return this.phoneme;
    }

    public void nonAlphaNumTPCharsChanged(String string, int n) {
        try {
            this.asiaSpellerListener.nonAlphaNumTPCharsChanged(this.id, n, string);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setValidNonAlphaNumTPCharacters(String string) {
        Object object = this.mutex;
        synchronized (object) {
            this.validNonAlphaNumTPChars = string;
            this.stateChanged();
        }
        this.fireModelUpdateEvent(17);
    }

    public void setInitialInputMode(int n) {
        this.initialInputMode = n;
    }

    public void setAllowNonAlphaNumInput(boolean bl) {
        this.allowNonAlphaNumInput = bl;
    }

    public int getNonAlphaNumMode(int n) {
        return this.nonAlphaNumMode;
    }

    public int getInitialInputMode(int n) {
        return this.initialInputMode;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getValidNonAlphaNumTPCharacters(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return this.validNonAlphaNumTPChars;
        }
    }

    public void inputModeTPChanged(int n, int n2) {
        try {
            this.asiaSpellerListener.inputModeTPChanged(this.id, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public boolean getAllowNonAlphaNumInput(int n) {
        return this.allowNonAlphaNumInput;
    }

    public void setSpellerListener(SpellerListener spellerListener) {
        super.setSpellerListener(spellerListener);
        this.asiaSpellerListener = DUMMY_LISTENER;
    }

    public void setSpellerListenerAsia(MatchspellerListenerAsia matchspellerListenerAsia) {
        super.setSpellerListener(matchspellerListenerAsia);
        this.asiaSpellerListener = matchspellerListenerAsia;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void strokesChanged(int n, String string, char c2) {
        Object object = this.mutex;
        synchronized (object) {
            try {
                this.asiaSpellerListener.strokesChanged(this.id, n, string, c2);
            }
            catch (Exception exception) {
                this.handleListenerException(exception);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestValidHanziCharsWindow(int n, int n2, int n3) {
        Object object = this.mutex;
        synchronized (object) {
            try {
                this.asiaSpellerListener.requestValidHanziCharsWindow(this.id, n, n2, n3);
            }
            catch (Exception exception) {
                this.handleListenerException(exception);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getValidHanziCharsWindowResult() {
        Object object = this.mutex;
        synchronized (object) {
            return this.validCharacters;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getTotalAmountOfHanziCharacters() {
        Object object = this.mutex;
        synchronized (object) {
            return this.validCharactersAmount;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setValidHanziChars(String string, int n) {
        Object object = this.mutex;
        synchronized (object) {
            this.validCharacters = string;
            this.validCharactersAmount = n;
            this.stateChanged();
        }
        this.fireModelUpdateEvent(19);
    }
}

