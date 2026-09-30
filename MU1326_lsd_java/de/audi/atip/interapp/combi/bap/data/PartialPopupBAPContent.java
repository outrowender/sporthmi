/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.data;

import de.esolutions.fw.util.commons.Buffer;

public final class PartialPopupBAPContent {
    private int priority;
    private int context;
    private int initialCursorPosition;
    private SelectionOption option1;
    private SelectionOption option2;
    private SelectionOption option3;
    private SelectionOption option4;
    private String text;
    private int icon;
    private int maximumDisplayTime;

    public PartialPopupBAPContent() {
        this(0, 0, "");
    }

    public PartialPopupBAPContent(int n, String string) {
        this(n, 0, string);
    }

    public PartialPopupBAPContent(int n, int n2, String string) {
        this.priority = n;
        this.context = n2;
        this.initialCursorPosition = 0;
        this.option1 = new SelectionOption();
        this.option2 = new SelectionOption();
        this.option3 = new SelectionOption();
        this.option4 = new SelectionOption();
        this.text = string;
        this.icon = 0;
        this.maximumDisplayTime = 0;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int n) {
        this.priority = n;
    }

    public int getContext() {
        return this.context;
    }

    public void setContext(int n) {
        this.context = n;
    }

    public int getInitialCursorPosition() {
        return this.initialCursorPosition;
    }

    public void setInitialCursorPosition(int n) {
        this.initialCursorPosition = n;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String string) {
        this.text = string;
    }

    public int getIcon() {
        return this.icon;
    }

    public void setIcon(int n) {
        this.icon = n;
    }

    public int getMaximumDisplayTime() {
        return this.maximumDisplayTime;
    }

    public void setMaximumDisplayTime(int n) {
        this.maximumDisplayTime = n;
    }

    public SelectionOption getSelectionOption1() {
        return this.option1;
    }

    public void setSelectionOption1(int n, int n2, String string) {
        this.option1.optionID = n;
        this.option1.optionType = n2;
        this.option1.optionString = string;
    }

    public SelectionOption getSelectionOption2() {
        return this.option2;
    }

    public void setSelectionOption2(int n, int n2, String string) {
        this.option2.optionID = n;
        this.option2.optionType = n2;
        this.option2.optionString = string;
    }

    public SelectionOption getSelectionOption3() {
        return this.option3;
    }

    public void setSelectionOption3(int n, int n2, String string) {
        this.option3.optionID = n;
        this.option3.optionType = n2;
        this.option3.optionString = string;
    }

    public SelectionOption getSelectionOption4() {
        return this.option4;
    }

    public void setSelectionOption4(int n, int n2, String string) {
        this.option4.optionID = n;
        this.option4.optionType = n2;
        this.option4.optionString = string;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("PartialPopupBAPContent{ priority=").append(this.priority);
        buffer.append(", context=").append(this.context);
        buffer.append(", text=").append(this.text);
        buffer.append("\noption1: ").append(this.option1.toString());
        if (this.option1.isAvailable() && this.initialCursorPosition == 1) {
            buffer.append(" <-- cursor");
        }
        if (this.option2.isAvailable()) {
            buffer.append("\noption2: ").append(this.option2.toString());
            if (this.initialCursorPosition == 2) {
                buffer.append(" <-- cursor");
            }
        }
        if (this.option3.isAvailable()) {
            buffer.append("\noption3: ").append(this.option3.toString());
            if (this.initialCursorPosition == 3) {
                buffer.append(" <-- cursor");
            }
        }
        if (this.option4.isAvailable()) {
            buffer.append("\noption4: ").append(this.option4.toString());
            if (this.initialCursorPosition == 4) {
                buffer.append(" <-- cursor");
            }
        }
        return buffer.toString();
    }

    public static class SelectionOption {
        int optionID;
        int optionType;
        String optionString;

        public SelectionOption() {
            this.optionID = -1;
            this.optionType = 0;
            this.optionString = "";
        }

        public SelectionOption(int n, int n2, String string) {
            this.optionID = n;
            this.optionType = n2;
            this.optionString = string;
        }

        public int getOptionID() {
            return this.optionID;
        }

        public int getOptionType() {
            return this.optionType;
        }

        public String getOptionString() {
            return this.optionString;
        }

        public boolean isAvailable() {
            return this.optionType != 0;
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("type=").append(this.optionType);
            buffer.append(", '").append(this.optionString).append("'");
            return buffer.toString();
        }
    }
}

