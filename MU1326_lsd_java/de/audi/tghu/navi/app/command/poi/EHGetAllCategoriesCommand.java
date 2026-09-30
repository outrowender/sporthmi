/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.Category;

public abstract class EHGetAllCategoriesCommand
extends NavCommand {
    private int mapSetType;

    public EHGetAllCategoriesCommand(String string) {
        super(string);
        this.mapSetType = 0;
    }

    public EHGetAllCategoriesCommand(String string, int n) {
        super(string);
        this.mapSetType = n;
    }

    protected abstract void processCategories(Category[] var1);

    public void execute() {
        this.logger.log(1000000, "EHGetAllCategoriesCommand#execute() - calling ehGetAllCategories() ");
        this.getDSINavigation().ehGetAllCategories(this.mapSetType);
    }

    public void ehGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
        if (n2 == 0) {
            if (this.mapSetType == n) {
                this.logger.log(1000000, "EHGetAllCategoriesCommand#ehGetAllCategoriesResult() - processing");
                this.processCategories(categoryArray);
                this.getCommandList().commandFinished();
            } else {
                this.logger.log(1000000, "EHGetAllCategoriesCommand#ehGetAllCategoriesResult() - ignored (waiting for mapStyleType: %1, but received %2)", (long)this.mapSetType, (long)n);
            }
        } else {
            this.logger.log(10000, "EHGetAllCategoriesCommand#ehGetAllCategoriesResult( %1 ) - aborting", (long)n2);
            this.getCommandList().commandAborted(n2);
        }
    }

    public void ehResult(int n, int n2) {
        this.logger.log(1000000, "%1#ehResult() - mapStyleType = %2, resultCode = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (this.mapSetType == n && n2 != 0) {
            this.logger.log(10000, "EHGetAllCategoriesCommand#ehResult( %1, %2 ) - aborting", (long)n, (long)n2);
            this.getCommandList().commandAborted(n2);
        }
    }
}

