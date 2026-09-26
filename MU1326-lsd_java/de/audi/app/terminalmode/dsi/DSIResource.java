/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.dsi.AbstractResource;
import de.audi.app.terminalmode.dsi.IDSIResource;
import de.audi.app.terminalmode.dsi.IResource$OwnershipType;

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

    private DSIResource(int n, int n2, IResource$OwnershipType iResource$OwnershipType, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        super(n, n2, iResource$OwnershipType);
        this.dsiResourceId = n3;
        this.dsiResourceOwner = n4;
        this.dsiTakeType = n5;
        this.dsiTransferPriority = n6;
        this.dsiTakeConstraint = n7;
        this.dsiBorrowConstraint = n8;
        this.dsiUnborrowConstraint = n9;
    }

    @Override
    public int getDSIResourceId() {
        return this.dsiResourceId;
    }

    @Override
    public int getDSIResourceOwner() {
        return this.dsiResourceOwner;
    }

    @Override
    public int getDSITakeType(boolean bl) {
        return this.dsiTakeType;
    }

    @Override
    public int getDSITransferPriority(boolean bl) {
        return this.dsiTransferPriority;
    }

    @Override
    public int getDSITakeConstraint(boolean bl) {
        return this.dsiTakeConstraint;
    }

    @Override
    public int getDSIBorrowConstraint(boolean bl) {
        return this.dsiBorrowConstraint;
    }

    @Override
    public int getDSIUnborrowConstraint(boolean bl) {
        return this.dsiUnborrowConstraint;
    }
}

