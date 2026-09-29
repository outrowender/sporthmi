/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

public interface IDataBrowserListChangeListener {
    default public void browseListTypeChanged(int n) {
    }

    default public void browseListLayoutChanged(int n) {
    }

    default public void browseListCategorySelected(int n) {
    }

    default public void lastBrowseListCategoryChanged(int n) {
    }
}

