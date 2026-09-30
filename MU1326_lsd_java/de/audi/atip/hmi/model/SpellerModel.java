/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelGUI;
import de.esolutions.fw.util.commons.Buffer;

public class SpellerModel
extends AbstractModel
implements SpellerModelApp,
SpellerModelGUI {
    static final int COMMAND_CHAR_LENGTH = 17;
    protected String text = "";
    private int maxLength = Integer.MAX_VALUE;
    private int minLength = 1;
    protected volatile SpellerListener spellerListener = DUMMY_LISTENER;
    private boolean[] commandEnabled;
    private int deleteButtonState = -1;
    private int exitButtonState = -1;
    private int exitButtonText = -1;
    private String countryAbbreviation;
    private String possibleCompletion = "";
    private String truffleSuggestion = null;
    private String suggestedNewSearchString = null;
    private boolean spellerOpen = false;
    private TouchEvent touchEvent = null;

    public SpellerModel(int n) {
        super(n, 0);
    }

    public SpellerModel(int n, int n2) {
        super(n, n2);
    }

    public void resetListener() {
        this.spellerListener = DUMMY_LISTENER;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String dumpContent() {
        Buffer buffer = new Buffer(200);
        buffer.append(super.dumpContent());
        Object object = this.mutex;
        synchronized (object) {
            buffer.append("\ntext: ");
            buffer.append(this.text);
            buffer.append("\nmaxLength: ");
            buffer.append(this.maxLength);
            buffer.append("\nminLength: ");
            buffer.append(this.minLength);
            buffer.append("\npossibleCompletion: ");
            buffer.append(this.possibleCompletion);
            if (this.commandEnabled == null) {
                buffer.append("\ncommandEnabled: null");
            } else {
                for (int i2 = 0; i2 < this.commandEnabled.length; ++i2) {
                    buffer.append("\ncommandEnabled[");
                    buffer.append(i2);
                    buffer.append("]: ");
                    buffer.append(this.commandEnabled[i2]);
                }
            }
            buffer.append("\ntruffleSuggestion: ");
            buffer.append(this.truffleSuggestion);
            buffer.append("\nsuggestedNewSearchString: ");
            buffer.append(this.suggestedNewSearchString);
            buffer.append("\ndeleteButtonState: ");
            buffer.append(this.getDeleteButtonState());
            buffer.append("\nexitButtonState: ");
            buffer.append(this.getExitButtonState());
            buffer.append("\ncountryAbbreviation: ");
            buffer.append(this.getCountryAbbreviation());
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
                SpellerModel spellerModel = (SpellerModel)abstractModel;
                this.text = spellerModel.text;
                this.minLength = spellerModel.minLength;
                this.maxLength = spellerModel.maxLength;
                this.deleteButtonState = spellerModel.deleteButtonState;
                this.exitButtonState = spellerModel.exitButtonState;
                this.possibleCompletion = spellerModel.possibleCompletion;
                this.suggestedNewSearchString = spellerModel.suggestedNewSearchString;
                this.truffleSuggestion = spellerModel.truffleSuggestion;
                if (spellerModel.commandEnabled != null) {
                    this.commandEnabled = (boolean[])spellerModel.commandEnabled.clone();
                }
                this.countryAbbreviation = spellerModel.countryAbbreviation;
                this.setChangeState(spellerModel.getChangeState());
                super.copy(spellerModel);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "(%2) SpellerModel.copy( %1 ) failed! ", (Object)abstractModel, (long)this.id);
            this.lc.log(10000, "ERROR: ", (Throwable)exception);
        }
    }

    public String toString() {
        return "SpellerModel (id: " + this.id + ")\n" + "min length: " + this.minLength + "\n" + "max length: " + this.maxLength + "\n" + "text: \"" + this.text + "\"\n" + "empty: " + this.isEmpty() + "\n" + "status: " + this.getStatus() + "\n" + "deleteButtonState: " + this.getDeleteButtonState() + "\n" + "exitButtonState: " + this.getExitButtonState();
    }

    public int getModelType() {
        return 6;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isEmpty() {
        Object object = this.mutex;
        synchronized (object) {
            return this.text == null || this.text.length() == 0;
        }
    }

    public int getMinLength() {
        return this.minLength;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getText() {
        Object object = this.mutex;
        synchronized (object) {
            return this.text;
        }
    }

    public int getDeleteButtonState() {
        return this.deleteButtonState;
    }

    public int getExitButtonState() {
        return this.exitButtonState;
    }

    public String getCountryAbbreviation() {
        return this.countryAbbreviation;
    }

    public void setMaxLength(int n) {
        this.maxLength = n;
    }

    public void setMinLength(int n) {
        this.minLength = n;
    }

    public void setSpellerListener(SpellerListener spellerListener) {
        this.spellerListener = spellerListener != null ? spellerListener : DUMMY_LISTENER;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setText(String string) {
        Object object = this.mutex;
        synchronized (object) {
            this.text = string;
            this.stateChanged();
        }
        this.fireModelUpdateEvent(1);
    }

    public void clear() {
        this.setText("");
        this.setCompletionText(null);
        this.setSuggestions(null, null);
    }

    public void setCountryAbbreviation(String string) {
        this.countryAbbreviation = string;
    }

    public void keyPressed(int n, int n2) {
        try {
            this.spellerListener.keyPressed(this.id, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void keyReleased(int n, int n2) {
        try {
            this.spellerListener.keyReleased(this.id, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void keyTyped(int n, int n2) {
        try {
            this.spellerListener.keyTyped(this.id, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void textChanged(String string, char c2, int n) {
        Object object = this.mutex;
        synchronized (object) {
            this.text = string;
            this.stateChanged();
        }
        try {
            this.spellerListener.textChanged(this.id, string, c2, n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void setMailBoxState(boolean bl) {
        if (this.commandEnabled == null) {
            this.commandEnabled = new boolean[17];
        }
        this.commandEnabled[0] = bl;
        this.fireModelUpdateEvent(11);
    }

    public void setControlButtonStates(int n, int n2) {
        this.deleteButtonState = n;
        this.exitButtonState = n2;
        this.fireModelUpdateEvent(11);
    }

    public void setExitButtonText(int n) {
        this.exitButtonText = n;
        this.fireModelUpdateEvent(11);
    }

    public int getExitButtonText() {
        return this.exitButtonText;
    }

    public void setCommandAvailable(int n, boolean bl) {
        if (this.commandEnabled == null) {
            this.commandEnabled = new boolean[17];
        }
        this.commandEnabled[n] = bl;
        this.fireModelUpdateEvent(11);
    }

    public boolean getCommandAvailable(int n) {
        return this.commandEnabled == null ? true : this.commandEnabled[n];
    }

    public void commandPressed(int n, int n2) {
        try {
            this.spellerListener.commandPressed(this.id, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void focusedCharacter(char c2, int n) {
        try {
            this.spellerListener.focusedCharacter(this.id, c2, n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void setCompletionText(String string) {
        this.possibleCompletion = string;
        this.fireModelUpdateEvent(10);
    }

    public String getCompletionText() {
        return this.possibleCompletion;
    }

    public String getTruffleSuggestion() {
        return this.truffleSuggestion;
    }

    public String getSuggestedNewSearchString() {
        return this.suggestedNewSearchString;
    }

    public void setSuggestions(String string, String string2) {
        this.truffleSuggestion = string;
        this.suggestedNewSearchString = string2;
        this.fireModelUpdateEvent(10);
    }

    public void setSpellerInitiallyOpen(boolean bl) {
        this.spellerOpen = bl;
    }

    public boolean shallSpellerBeInitiallyOpen() {
        return this.spellerOpen;
    }

    public TouchEvent getTouchEventForFollowUpScreen() {
        return this.touchEvent;
    }

    public void setTouchEventForFollowUpScreen(TouchEvent touchEvent) {
        this.touchEvent = touchEvent;
    }
}

