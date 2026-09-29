/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.vcardexchange;

public class VCardImportProgress {
    int countSuccess = 0;
    int countFailure = 0;
    int errorReason = 0;

    public int getCountSuccess() {
        return this.countSuccess;
    }

    public int getCountFailure() {
        return this.countFailure;
    }

    public int getErrorReason() {
        return this.errorReason;
    }

    public void reset() {
        this.countSuccess = 0;
        this.countFailure = 0;
        this.errorReason = 0;
    }

    public void updateImportProgress(int n, int n2, int n3) {
        this.countSuccess += n;
        this.countFailure += n2;
        if (n3 == 0) {
            return;
        }
        if (n3 == 6 && this.errorReason != 0) {
            return;
        }
        if ((n3 == 5 || n3 == 9) && this.errorReason != 0 && this.errorReason != 6) {
            return;
        }
        if ((n3 == 1 || n3 == 2) && this.errorReason != 0 && this.errorReason != 6 && this.errorReason != 5 && this.errorReason != 9) {
            return;
        }
        this.errorReason = n3;
    }
}

