/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.util.Util;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.seek.AbstractListControllerButtonHandler;
import de.audi.tuner.app.sdars.seek.AbstractSeekListSizeRistrictionHandler;
import de.audi.tuner.app.sdars.seek.AbstractTeamRow;
import de.audi.tuner.app.sdars.seek.LeagueRow;
import de.audi.tuner.app.sdars.seek.SelectedTeamRow;
import de.audi.tuner.app.sdars.seek.TeamRow;
import de.audi.tuner.app.sdars.seek.comparators.LeagueComparator;
import de.audi.tuner.app.sdars.seek.comparators.TeamComparator;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.IntList;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.sdars.LeagueEntry;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.TeamEntry;

public class GameHandler {
    public final DsiUpListener dsiUpListener = new DsiUpListener();
    public final TunerActionProxyListener actionProxy = new ActionProxy();
    private final SDARSDSISeekDownManager dsiSeek;
    private final TunerModels models;
    private final ITunerVariantExt varExt;
    private final LanguageManager langMngr;
    private final Object mutex = new Object();
    private final BaseListModelApp leagueList;
    private final BaseListModelApp teamList;
    private final BaseListModelApp selectedTeamList;
    private final ButtonModelApp manageAlertsButton;
    private final LabelModelApp leagueLabel;
    private int selectedTeams = 0;
    private final SimpleIntObjectMap seekIdToLeagueEntry = new SimpleIntObjectMap();
    private TeamEntry[] shownTeamEntries = new TeamEntry[0];
    private final HashMap seekIdToSeekEntryForSelectedTeam = new HashMap(50);
    private final HashMap sessionSeekIdToSeekEntryForSelectedTeam = new HashMap(50);
    private final AbstractSeekListSizeRistrictionHandler sizeRestriction;
    private final SelectedTeamsControllerButtonHandler selectedTeamsListController;

    public GameHandler(TunerBasics tunerBasics, LanguageManager languageManager, SDARSDSISeekDownManager sDARSDSISeekDownManager, ITunerVariantExt iTunerVariantExt, AbstractSeekListSizeRistrictionHandler abstractSeekListSizeRistrictionHandler) {
        this.langMngr = languageManager;
        this.dsiSeek = sDARSDSISeekDownManager;
        this.models = tunerBasics.getModels();
        this.varExt = iTunerVariantExt;
        this.sizeRestriction = abstractSeekListSizeRistrictionHandler;
        TunerModels tunerModels = tunerBasics.getModels();
        this.leagueList = tunerModels.getBaseListModel(100477);
        this.teamList = tunerModels.getBaseListModel(100484);
        this.selectedTeamList = tunerModels.getBaseListModel(100481);
        this.manageAlertsButton = tunerModels.getButtonModel(100650);
        this.leagueLabel = tunerModels.getLabelModel(100440);
        this.initNewEditingSession();
        this.manageAlertsButton.setButtonListener(new ManageAlertsButtonListener());
        this.leagueList.setListener(new LeagueListModelListener());
        this.teamList.setListener(new TeamListModelListener());
        this.selectedTeamList.setListener(new SelectedTeamListModelListener());
        tunerModels.getButtonModel(100659).setButtonListener(new ButtonListener());
        TeamListControllerButtonListener teamListControllerButtonListener = new TeamListControllerButtonListener();
        tunerModels.getButtonModel(100764).setButtonListener(teamListControllerButtonListener);
        tunerModels.getButtonModel(100763).setButtonListener(teamListControllerButtonListener);
        OptionModelApp optionModelApp = tunerModels.getOptionModel(100657);
        optionModelApp.setListener(new OptionModelListener(), this.selectedTeamList.getID());
        this.selectedTeamsListController = new SelectedTeamsControllerButtonHandler(this.selectedTeamList, tunerModels.getButtonModel(100810), tunerModels.getButtonModel(100811), tunerModels.getButtonModel(100809), sDARSDSISeekDownManager, iTunerVariantExt);
    }

    private void onManageAlertsButtonPressed(int n) {
        this.dsiSeek.getLeagues();
        this.initNewEditingSession();
        this.manageAlertsButton.fireEvent(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onLeagueListItemSelected(LeagueRow leagueRow, int n) {
        Object object = this.mutex;
        synchronized (object) {
            this.leagueLabel.setText(leagueRow.getLeagueName());
            this.teamList.removeAll();
        }
        this.dsiSeek.getTeamsOfLeague(leagueRow.getLeagueID());
    }

    private void onLeagueListItemLongSelected(int n, LeagueRow leagueRow) {
        this.toggleSeekForLeague(this.leagueList, n, leagueRow);
    }

    private void onTeamListItemSelected(int n, TeamRow teamRow) {
        this.toggleSeekForTeam(this.teamList, n, teamRow);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onSelectedTeamListItemSelected(int n, SelectedTeamRow selectedTeamRow) {
        Object object = this.mutex;
        synchronized (object) {
            if (Utilities.isPGen1OrBentley()) {
                this.selectedTeamsListController.toggleRow(n);
            } else {
                int n2 = selectedTeamRow.getTeamID();
                int n3 = selectedTeamRow.getLeagueId();
                selectedTeamRow.toggleActivationCheckbox();
                this.selectedTeamList.setRow(n, selectedTeamRow);
                int n4 = selectedTeamRow.isActivationCheckboxSelected() ? 1 : 3;
                this.dsiSeek.manageSeek2(3, n2, n3, n4);
                this.dsiSeek.clearSeekListNotification();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onButtonClearGameAlertsTyped() {
        IntList intList = new IntList(this.selectedTeamList.getLength());
        IntList intList2 = new IntList(this.selectedTeamList.getLength());
        Object object = this.mutex;
        synchronized (object) {
            for (int i2 = 0; i2 < this.selectedTeamList.getLength(); ++i2) {
                SelectedTeamRow selectedTeamRow = (SelectedTeamRow)this.selectedTeamList.getRow(i2);
                if (!selectedTeamRow.isActivationCheckboxSelected()) continue;
                intList.add(selectedTeamRow.getTeamID());
                intList2.add(selectedTeamRow.getLeagueId());
            }
            this.selectedTeamList.removeAll();
        }
        this.dsiSeek.clearSeekListNotification();
        for (int i3 = 0; i3 < intList.size(); ++i3) {
            this.dsiSeek.manageSeek2(3, intList.get(i3), intList2.get(i3), 3);
        }
        this.models.getChoiceModel(100680).setValue(0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onOptionDeleteCurrentGameAlert(OptionModelApp optionModelApp, int n, int n2) {
        boolean bl = false;
        int n3 = -1;
        int n4 = -1;
        Object object = this.mutex;
        synchronized (object) {
            SelectedTeamRow selectedTeamRow = (SelectedTeamRow)this.selectedTeamList.getRow(n);
            if (selectedTeamRow != null) {
                bl = true;
                n3 = selectedTeamRow.getTeamID();
                n4 = selectedTeamRow.getLeagueId();
                this.selectedTeamList.remove(selectedTeamRow);
            }
        }
        if (bl) {
            this.dsiSeek.clearSeekListNotification();
            this.dsiSeek.manageSeek2(3, n3, n4, 3);
            optionModelApp.fireEvent(n2);
            int n5 = this.selectedTeamList.getLength() == 0 ? 0 : 1;
            this.models.getChoiceModel(100680).setValue(n5);
        }
    }

    private void updateSessionAddCounter(int n) {
        LabelModelApp labelModelApp = this.models.getLabelModel(100783);
        int n2 = Integer.parseInt(labelModelApp.getText()) + n;
        labelModelApp.setText(String.valueOf(n2));
    }

    private void initNewEditingSession() {
        this.models.getLabelModel(100783).setText("0");
        this.sessionSeekIdToSeekEntryForSelectedTeam.clear();
        this.sessionSeekIdToSeekEntryForSelectedTeam.putAll(this.seekIdToSeekEntryForSelectedTeam);
    }

    private void onSMTunerSDARSManageAlertsLeft() {
        this.dsiSeek.setSeekListNotification();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onDSILeagues(LeagueEntry[] leagueEntryArray) {
        Arrays.sort(leagueEntryArray, new LeagueComparator(this.langMngr));
        Object object = this.mutex;
        synchronized (object) {
            this.seekIdToLeagueEntry.clear();
            for (int i2 = 0; i2 < leagueEntryArray.length; ++i2) {
                this.seekIdToLeagueEntry.add(leagueEntryArray[i2].seekID, leagueEntryArray[i2]);
            }
        }
        this.updateLeagueList();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onDSITeamsOfLeague(TeamEntry[] teamEntryArray) {
        Arrays.sort(teamEntryArray, new TeamComparator(this.langMngr));
        Object object = this.mutex;
        synchronized (object) {
            this.shownTeamEntries = teamEntryArray;
        }
        this.updateTeamList();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onDSIUpdateSeekList(SeekEntry[] seekEntryArray) {
        boolean bl = false;
        Object object = this.mutex;
        synchronized (object) {
            this.seekIdToSeekEntryForSelectedTeam.clear();
            for (int i2 = 0; i2 < seekEntryArray.length; ++i2) {
                SeekEntry seekEntry = seekEntryArray[i2];
                if (seekEntry.typeOfContent != 3) continue;
                this.seekIdToSeekEntryForSelectedTeam.put(Util.createInteger(seekEntry.seekID), seekEntry);
                bl = true;
            }
        }
        this.updateSelectedTeamList();
        this.updateTeamList();
        this.updateLeagueList();
        this.models.getChoiceModel(100680).setValue(bl ? 1 : 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateLeagueList() {
        BaseListModelApp baseListModelApp = this.leagueList.getEmptyCopy();
        Object object = this.mutex;
        synchronized (object) {
            Object[] objectArray;
            HashSet hashSet = new HashSet();
            Iterator iterator = this.seekIdToSeekEntryForSelectedTeam.values().iterator();
            while (iterator.hasNext()) {
                objectArray = (Object[])iterator.next();
                hashSet.add(new Integer(objectArray.contentLink));
            }
            objectArray = new LeagueEntry[this.seekIdToLeagueEntry.size()];
            this.seekIdToLeagueEntry.valuesToArray(objectArray);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                Object object2 = objectArray[i2];
                int n = hashSet.contains(new Integer(((LeagueEntry)object2).seekID)) ? 128 : 0;
                LeagueRow leagueRow = new LeagueRow(((LeagueEntry)object2).seekID, ((LeagueEntry)object2).leagueName, n);
                baseListModelApp.append(leagueRow);
            }
            this.leagueList.update(baseListModelApp);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateTeamList() {
        this.selectedTeams = 0;
        BaseListModelApp baseListModelApp = this.teamList.getEmptyCopy();
        ArrayList arrayList = new ArrayList(500);
        Object object = this.mutex;
        synchronized (object) {
            for (int i2 = 0; i2 < this.shownTeamEntries.length; ++i2) {
                TeamEntry teamEntry = this.shownTeamEntries[i2];
                Integer n = Util.createInteger(teamEntry.seekID);
                boolean bl = this.seekIdToSeekEntryForSelectedTeam.containsKey(n);
                if (bl) {
                    ++this.selectedTeams;
                }
                int n2 = TunerModels.booleanToCheckboxConstant(bl);
                boolean bl2 = this.sessionSeekIdToSeekEntryForSelectedTeam.containsKey(n);
                int n3 = TunerModels.booleanToCheckboxConstant(bl2);
                Buffer buffer = new Buffer(100).append(teamEntry.teamName).append(' ').append(teamEntry.teamNameNick);
                TeamRow teamRow = new TeamRow(teamEntry.seekID, buffer.toString(), n2, teamEntry.leagueLink, n3);
                arrayList.add(teamRow);
            }
            baseListModelApp.append((EvoListRow[])arrayList.toArray(new EvoListRow[arrayList.size()]));
            this.teamList.update(baseListModelApp);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateSelectedTeamList() {
        BaseListModelApp baseListModelApp = this.selectedTeamList.getEmptyCopy();
        Object object = this.mutex;
        synchronized (object) {
            Iterator iterator = this.seekIdToSeekEntryForSelectedTeam.values().iterator();
            while (iterator.hasNext()) {
                SeekEntry seekEntry = (SeekEntry)iterator.next();
                int n = seekEntry.contentLink;
                LeagueEntry leagueEntry = (LeagueEntry)this.seekIdToLeagueEntry.get(n);
                String string = leagueEntry != null ? leagueEntry.leagueName : "";
                SelectedTeamRow selectedTeamRow = new SelectedTeamRow(string, n, seekEntry.seekID, seekEntry.title2);
                baseListModelApp.append(selectedTeamRow);
            }
            this.selectedTeamList.update(baseListModelApp);
            this.selectedTeamsListController.setList(this.selectedTeamList);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void toggleSeekForLeague(BaseListModelApp baseListModelApp, int n, LeagueRow leagueRow) {
        Object object = this.mutex;
        synchronized (object) {
            int n2 = leagueRow.getCheckBox();
            int n3 = n2 == 1 ? 3 : 1;
            boolean bl = this.sizeRestriction.isSeekListFull(3);
            if (bl && n3 == 1) {
                this.varExt.showPartialPopup(16);
            } else {
                int n4 = leagueRow.getLeagueID();
                this.dsiSeek.manageSeek2(2, n4, 0, n3);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void toggleSeekForTeam(BaseListModelApp baseListModelApp, int n, AbstractTeamRow abstractTeamRow) {
        Object object = this.mutex;
        synchronized (object) {
            int n2 = abstractTeamRow.getActivationCheckBox();
            int n3 = n2 == 1 ? 3 : 1;
            boolean bl = this.sizeRestriction.isSeekListFull(3);
            if (bl && n3 == 1) {
                this.varExt.showPartialPopup(16);
            } else {
                int n4 = n3 == 1 ? 1 : -1;
                this.selectedTeams += n4;
                this.updateSessionAddCounter(n4);
                int n5 = abstractTeamRow.getTeamID();
                int n6 = abstractTeamRow.getLeagueId();
                this.dsiSeek.manageSeek2(3, n5, n6, n3);
            }
        }
    }

    private class ActionProxy
    extends TunerActionProxyListener {
        private ActionProxy() {
        }

        public void tunerSDARSManageAlertsLeft() {
            GameHandler.this.onSMTunerSDARSManageAlertsLeft();
        }
    }

    private class DsiUpListener
    extends SDARSDsiUpInfo {
        private DsiUpListener() {
        }

        public void leagues(LeagueEntry[] leagueEntryArray) {
            GameHandler.this.onDSILeagues(leagueEntryArray);
        }

        public void teamsOfLeague(TeamEntry[] teamEntryArray) {
            GameHandler.this.onDSITeamsOfLeague(teamEntryArray);
        }

        public void updateSeekList(SeekEntry[] seekEntryArray) {
            GameHandler.this.onDSIUpdateSeekList(seekEntryArray);
        }

        public void updateAvailability(int n) {
            if (n == 1) {
                GameHandler.this.leagueList.fireEvent(0);
                GameHandler.this.teamList.fireEvent(0);
            }
        }
    }

    private class ButtonListener
    extends DefaultButtonListener {
        private ButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            GameHandler.this.onButtonClearGameAlertsTyped();
        }
    }

    private class OptionModelListener
    extends DefaultOptionListener {
        private OptionModelListener() {
        }

        public void keyTyped(int n, int n2, int n3, int n4, int n5) {
            GameHandler.this.onOptionDeleteCurrentGameAlert(GameHandler.this.models.getOptionModel(n), n3, n5);
        }
    }

    private class TeamListModelListener
    extends DefaultBaseListModelListener {
        private TeamListModelListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            GameHandler.this.onTeamListItemSelected(n2, (TeamRow)evoListRow);
        }
    }

    private class LeagueListModelListener
    extends DefaultBaseListModelListener {
        private LeagueListModelListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            GameHandler.this.onLeagueListItemSelected((LeagueRow)evoListRow, n4);
        }

        public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            GameHandler.this.onLeagueListItemLongSelected(n2, (LeagueRow)evoListRow);
        }
    }

    private class ManageAlertsButtonListener
    extends DefaultButtonListener {
        private ManageAlertsButtonListener() {
        }

        public void keyReleased(int n, int n2, int n3) {
            GameHandler.this.onManageAlertsButtonPressed(n3);
        }
    }

    private class SelectedTeamListModelListener
    extends DefaultBaseListModelListener {
        private SelectedTeamListModelListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            GameHandler.this.onSelectedTeamListItemSelected(n2, (SelectedTeamRow)evoListRow);
        }
    }

    private class TeamListControllerButtonListener
    extends DefaultButtonListener {
        private TeamListControllerButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            switch (n) {
                case 100764: {
                    this.setAllEntriesSelected(true);
                    break;
                }
                case 100763: {
                    this.setAllEntriesSelected(false);
                    break;
                }
            }
        }

        private void setAllEntriesSelected(boolean bl) {
            int n = GameHandler.this.teamList.getLength() - GameHandler.this.selectedTeams;
            if (bl && n > GameHandler.this.sizeRestriction.getRemainingSpace(3)) {
                GameHandler.this.varExt.showPartialPopup(18);
            } else {
                int n2 = bl ? 1 : 3;
                int n3 = bl ? n : GameHandler.this.selectedTeams;
                int n4 = bl ? 1 : 0;
                int[] nArray = new int[n3];
                int[] nArray2 = new int[n3];
                int n5 = 0;
                for (int i2 = 0; i2 < GameHandler.this.teamList.getLength(); ++i2) {
                    TeamRow teamRow = (TeamRow)GameHandler.this.teamList.getRow(i2);
                    if (teamRow.getActivationCheckBox() == n4) continue;
                    nArray[n5] = teamRow.getTeamID();
                    nArray2[n5] = teamRow.getLeagueId();
                    ++n5;
                }
                GameHandler.this.dsiSeek.bulkManageSeek2(3, nArray, nArray2, n2);
            }
        }
    }

    private static class SelectedTeamsControllerButtonHandler
    extends AbstractListControllerButtonHandler {
        private final SDARSDSISeekDownManager dsiSeek;
        private final ITunerVariantExt variantExt;

        public SelectedTeamsControllerButtonHandler(BaseListModelApp baseListModelApp, ButtonModelApp buttonModelApp, ButtonModelApp buttonModelApp2, ButtonModelApp buttonModelApp3, SDARSDSISeekDownManager sDARSDSISeekDownManager, ITunerVariantExt iTunerVariantExt) {
            super(baseListModelApp, buttonModelApp, buttonModelApp2, buttonModelApp3);
            this.dsiSeek = sDARSDSISeekDownManager;
            this.variantExt = iTunerVariantExt;
        }

        public void deleteMarkedRows(List list) {
            int n = this.list.getLength();
            int[] nArray = new int[list.size()];
            int[] nArray2 = new int[list.size()];
            int n2 = 0;
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                SelectedTeamRow selectedTeamRow = (SelectedTeamRow)iterator.next();
                nArray[n2] = selectedTeamRow.getTeamID();
                nArray2[n2] = selectedTeamRow.getLeagueId();
                ++n2;
            }
            this.dsiSeek.bulkManageSeek2(3, nArray, nArray2, 3);
            this.variantExt.showPartialPopup(4);
            if (n == list.size()) {
                this.list.fireEvent(0);
            }
        }
    }
}

