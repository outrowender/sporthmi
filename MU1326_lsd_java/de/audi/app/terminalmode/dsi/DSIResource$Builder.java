/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.dsi.DSIResource;
import de.audi.app.terminalmode.dsi.IDSIResource;
import de.audi.app.terminalmode.dsi.IResource$OwnershipType;

public class DSIResource$Builder {
    private int pResourceId = -1;
    private int pOwner = -1;
    private IResource$OwnershipType ownershipType = IResource$OwnershipType.UNSPECIFIED;
    private int dsiResourceId = -1;
    private int dsiResourceOwner = -1;
    private int dsiTakeType = -1;
    private int dsiTransferPriority = -1;
    private int dsiTakeConstraint = -1;
    private int dsiBorrowConstraint = -1;
    private int dsiUnborrowConstraint = -1;

    public IDSIResource build() {
        return new DSIResource(this.pResourceId, this.pOwner, this.ownershipType, this.dsiResourceId, this.dsiResourceOwner, this.dsiTakeType, this.dsiTransferPriority, this.dsiTakeConstraint, this.dsiBorrowConstraint, this.dsiUnborrowConstraint);
    }

    public DSIResource$Builder setpResourceId(int n) {
        this.pResourceId = n;
        return this;
    }

    public DSIResource$Builder setpOwner(int n) {
        this.pOwner = n;
        return this;
    }

    public DSIResource$Builder setOwnershipType(IResource$OwnershipType iResource$OwnershipType) {
        this.ownershipType = iResource$OwnershipType;
        return this;
    }

    public DSIResource$Builder setDsiResourceId(int n) {
        this.dsiResourceId = n;
        return this;
    }

    public DSIResource$Builder setDsiResourceOwner(int n) {
        this.dsiResourceOwner = n;
        return this;
    }

    public DSIResource$Builder setDsiTakeType(int n) {
        this.dsiTakeType = n;
        return this;
    }

    public DSIResource$Builder setDSITransferPriority(int n) {
        this.dsiTransferPriority = n;
        return this;
    }

    public DSIResource$Builder setDsiTakeConstraint(int n) {
        this.dsiTakeConstraint = n;
        return this;
    }

    public DSIResource$Builder setDsiBorrowConstraint(int n) {
        this.dsiBorrowConstraint = n;
        return this;
    }

    public DSIResource$Builder setDsiUnborrowConstraint(int n) {
        this.dsiUnborrowConstraint = n;
        return this;
    }
}

