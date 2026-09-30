/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.dsi.AbstractResource;
import de.audi.app.terminalmode.dsi.IDSIResource;
import de.audi.app.terminalmode.dsi.IResource;

public class DSIResource
extends AbstractResource
implements IDSIResource {
    private final int dsiResourceId;
    private final int dsiResourceOwner;
    private final int dsiTakeType;
    private final int dsiTakeConstraint;
    private final int dsiBorrowConstraint;
    private final int dsiUnborrowConstraint;
    private final int dsiTransferPriority;

    private DSIResource(int n, int n2, IResource.OwnershipType ownershipType, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        super(n, n2, ownershipType);
        this.dsiResourceId = n3;
        this.dsiResourceOwner = n4;
        this.dsiTakeType = n5;
        this.dsiTransferPriority = n6;
        this.dsiTakeConstraint = n7;
        this.dsiBorrowConstraint = n8;
        this.dsiUnborrowConstraint = n9;
    }

    public int getDSIResourceId() {
        return this.dsiResourceId;
    }

    public int getDSIResourceOwner() {
        return this.dsiResourceOwner;
    }

    public int getDSITakeType(boolean bl) {
        return this.dsiTakeType;
    }

    public int getDSITransferPriority(boolean bl) {
        return this.dsiTransferPriority;
    }

    public int getDSITakeConstraint(boolean bl) {
        return this.dsiTakeConstraint;
    }

    public int getDSIBorrowConstraint(boolean bl) {
        return this.dsiBorrowConstraint;
    }

    public int getDSIUnborrowConstraint(boolean bl) {
        return this.dsiUnborrowConstraint;
    }

    public static class Builder {
        private int pResourceId = -1;
        private int pOwner = -1;
        private IResource.OwnershipType ownershipType = IResource.OwnershipType.UNSPECIFIED;
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

        public Builder setpResourceId(int n) {
            this.pResourceId = n;
            return this;
        }

        public Builder setpOwner(int n) {
            this.pOwner = n;
            return this;
        }

        public Builder setOwnershipType(IResource.OwnershipType ownershipType) {
            this.ownershipType = ownershipType;
            return this;
        }

        public Builder setDsiResourceId(int n) {
            this.dsiResourceId = n;
            return this;
        }

        public Builder setDsiResourceOwner(int n) {
            this.dsiResourceOwner = n;
            return this;
        }

        public Builder setDsiTakeType(int n) {
            this.dsiTakeType = n;
            return this;
        }

        public Builder setDSITransferPriority(int n) {
            this.dsiTransferPriority = n;
            return this;
        }

        public Builder setDsiTakeConstraint(int n) {
            this.dsiTakeConstraint = n;
            return this;
        }

        public Builder setDsiBorrowConstraint(int n) {
            this.dsiBorrowConstraint = n;
            return this;
        }

        public Builder setDsiUnborrowConstraint(int n) {
            this.dsiUnborrowConstraint = n;
            return this;
        }
    }
}

