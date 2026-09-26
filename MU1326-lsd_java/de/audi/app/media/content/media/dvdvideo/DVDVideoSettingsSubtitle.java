/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.dvdvideo;

import de.audi.app.media.AbstractSettingsList;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

public class DVDVideoSettingsSubtitle
extends AbstractSettingsList {
    private static final String LOGCLASS;
    private final BaseListModelApp subtitleList;
    private final LabelModelApp previewNumber;
    private final ChoiceModelApp previewLanguage;
    private final IMediaDSIPlayerController dsiPlayer;
    private static final int SUBTITLE_LIST_COLUMNS;
    private static final int SUBTITLE_LIST_COL_LANGUAGE_NAME;
    private static final int SUBTITLE_LIST_COL_LANGUAGE_NUMBER;
    private static final int SUBTITLE_LIST_COL_LANGUAGE_CODE;
    private static final int SUBTITLE_LIST_COL_SELECTION;

    public DVDVideoSettingsSubtitle(IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController, BaseListModelApp baseListModelApp, ChoiceModelApp choiceModelApp, LabelModelApp labelModelApp) {
        super(iMediaTerminal);
        this.dsiPlayer = iMediaDSIPlayerController;
        this.subtitleList = baseListModelApp;
        this.previewLanguage = choiceModelApp;
        this.previewNumber = labelModelApp;
        this.subtitleList.setListener(this);
        this.subtitleList.removeAll();
    }

    @Override
    protected int getCheckboxColumn() {
        return 2;
    }

    @Override
    protected BaseListModelApp getListModel() {
        return this.subtitleList;
    }

    @Override
    protected void entrySelected(int n) {
        this.dsiPlayer.setSubtitleLanguage(n);
    }

    public void updateSubtitleList(int[] nArray) {
        int[] nArray2 = this.trimToLanguageCodes(nArray);
        BaseListModelApp baseListModelApp = this.subtitleList.getCopy();
        baseListModelApp.removeAll();
        baseListModelApp.setSelectedIndex(-1);
        baseListModelApp.setLength(nArray2.length);
        int[] nArray3 = this.calculateLanguageNumbers(nArray2);
        for (int i2 = 0; i2 < nArray2.length; ++i2) {
            baseListModelApp.setRow(i2, this.createRow(i2, nArray2[i2], nArray3[i2]));
        }
        this.subtitleList.update(baseListModelApp);
    }

    public void updateActiveSubtitle(int n) {
        this.logger.main().log(1078071040, "[%1.updateActiveSubtitle] activeSubtitleIdx='%2'.", (Object)"DVDVideoSettingsSubtitle", (long)n);
        if (this.updateActiveEntry(n)) {
            String string = this.subtitleList.getRow(n).getText(1);
            int n2 = this.subtitleList.getRow(n).getInteger(3);
            this.previewLanguage.setValue(this.languageMapper.getArrayPosition(n2));
            if ("".equals(string)) {
                this.previewNumber.setStatus(0);
            } else {
                this.previewNumber.setStatus(1);
            }
            this.previewNumber.setText(string);
        } else {
            this.previewLanguage.setValue(0);
            this.previewNumber.setText("");
            this.previewNumber.setStatus(1);
        }
    }

    private EvoListRow createRow(int n, int n2, int n3) {
        EvoListRow evoListRow = new EvoListRow(n, 4);
        evoListRow.setInteger(0, this.languageMapper.getArrayPosition(n2));
        evoListRow.setText(1, n3 > 0 ? Integer.toString(n3) : "");
        evoListRow.setInteger(2, 0);
        evoListRow.setInteger(3, n2);
        return evoListRow;
    }

    protected int[] trimToLanguageCodes(int[] nArray) {
        int[] nArray2 = new int[nArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            nArray2[i2] = nArray[i2] & 0xFFFF0000;
        }
        return nArray2;
    }

    protected int[] calculateLanguageNumbers(int[] nArray) {
        int n;
        int n2;
        SimpleIntIntMap simpleIntIntMap = new SimpleIntIntMap(nArray.length);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            n2 = nArray[i2];
            n = simpleIntIntMap.get(n2);
            if (n == -1) {
                n = 0;
            }
            simpleIntIntMap.add(n2, ++n);
        }
        int[] nArray2 = simpleIntIntMap.getKeys();
        for (n2 = 0; n2 < nArray2.length; ++n2) {
            n = simpleIntIntMap.get(nArray2[n2]);
            if (n >= 2) continue;
            simpleIntIntMap.remove(nArray2[n2]);
        }
        int[] nArray3 = new int[nArray.length];
        for (n = nArray.length - 1; n >= 0; --n) {
            int n3 = nArray[n];
            int n4 = simpleIntIntMap.get(n3);
            if (n4 > 0) {
                simpleIntIntMap.add(n3, n4 - 1);
                nArray3[n] = n4;
                continue;
            }
            nArray3[n] = -1;
        }
        return nArray3;
    }
}

