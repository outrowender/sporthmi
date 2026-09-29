/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.sdars.CategoryFilter;
import de.audi.tuner.app.sdars.CategoryFilter$1;
import de.audi.tuner.app.sdars.CategoryFilterRow;

class CategoryFilter$ListListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ CategoryFilter this$0;

    private CategoryFilter$ListListener(CategoryFilter categoryFilter) {
        this.this$0 = categoryFilter;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        CategoryFilterRow categoryFilterRow = (CategoryFilterRow)evoListRow;
        if (categoryFilterRow.isChecked()) {
            categoryFilterRow.setChecked(false);
        } else {
            categoryFilterRow.setChecked(true);
        }
        CategoryFilter.access$600(this.this$0).setRow(n2, categoryFilterRow);
        CategoryFilter.access$700(this.this$0);
    }

    /* synthetic */ CategoryFilter$ListListener(CategoryFilter categoryFilter, CategoryFilter$1 categoryFilter$1) {
        this(categoryFilter);
    }
}

