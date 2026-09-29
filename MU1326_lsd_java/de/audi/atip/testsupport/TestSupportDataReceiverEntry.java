/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.testsupport;

public class TestSupportDataReceiverEntry {
    private final int id;
    private String description;
    private final boolean checkBox;
    private boolean checked;

    public TestSupportDataReceiverEntry(int n, String string, boolean bl, boolean bl2) {
        this.id = n;
        this.description = string;
        this.checked = bl2;
        this.checkBox = bl;
    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isCheckBox() {
        return this.checkBox;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean bl) {
        this.checked = bl;
    }

    public void setDescription(String string) {
        this.description = string;
    }
}

