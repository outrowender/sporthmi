/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

public class CharismaIndivOption {
    private final String optionName;
    private final int optionID;
    private final int dsiOption;
    private final int dsiMaskStep;

    public CharismaIndivOption(String string, int n, int n2, int n3) {
        this.optionName = string;
        this.optionID = n;
        this.dsiOption = n2;
        this.dsiMaskStep = n3;
    }

    public String getOptionName() {
        return this.optionName;
    }

    public int getOptionID() {
        return this.optionID;
    }

    public int getDsiOption() {
        return this.dsiOption;
    }

    public int getDsiMaskStep() {
        return this.dsiMaskStep;
    }

    public boolean hasOptionID(int n) {
        return this.getOptionID() == n;
    }

    public boolean hasDsiOption(int n) {
        return this.getDsiOption() == n;
    }

    public int useMaskOnHint(int n, int n2) {
        int n3 = n;
        return n3 += (n2 & this.getDsiMaskStep()) != 0 ? 1 << this.getOptionID() : 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(140);
        stringBuffer.append("CharismaIndivOption (");
        if (this.optionName != null) {
            stringBuffer.append("optionName=").append(this.optionName).append(", ");
        }
        stringBuffer.append("optionID=").append(this.optionID).append(", dsiOption=").append(this.dsiOption).append(", dsiMaskStep=").append(this.dsiMaskStep).append(')');
        return stringBuffer.toString();
    }
}

