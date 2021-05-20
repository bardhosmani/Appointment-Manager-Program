package Cotrollers;

import java.util.ArrayList;

public class StoreCheckAppointment {

    private ArrayList<String> emriList = new ArrayList<String>();
    private ArrayList<String> ditaList = new ArrayList<String>();
    private ArrayList<String> oraList = new ArrayList<String>();
    private ArrayList<Boolean> weeklyList = new ArrayList<Boolean>();
    private String termin;
    private String ora;
    private String emri;
    private boolean weekly;

    public StoreCheckAppointment() {
    }

    public StoreCheckAppointment(ArrayList<String> emriList, ArrayList<String> ditaList, ArrayList<String> oraList,
            ArrayList<Boolean> weeklyList) {
        this.emriList = emriList;
        this.ditaList = ditaList;
        this.oraList = oraList;
        this.weeklyList = weeklyList;

    }

    public StoreCheckAppointment(String emriTermin, String terminTermin, String oraTerminit, boolean weeklyTermin) {
        this.emri = emriTermin;
        this.termin = terminTermin;
        this.ora = oraTerminit;
        this.weekly = weeklyTermin;
    }

    public void setEmriTermini(String emri) {
        this.emri = emri;
    }

    public void setDitaTermini(String termin) {
        this.termin = termin;
    }

    public void setOraTermini(String ora) {
        this.ora = ora;
    }

    public void setWeeklyTermini(boolean weekly) {
        this.weekly = weekly;
    }
    //---------------------Set Lists-----------------------------------------

    public void setEmriTerminiList(ArrayList<String> emriList) {
        this.emriList = emriList;
    }

    public void setDitaTerminiList(ArrayList<String> ditaList) {
        this.ditaList = ditaList;
    }

    public void setOraTerminiList(ArrayList<String> oraList) {
        this.oraList = oraList;
    }

    public void setWeeklyTermini(ArrayList<Boolean> weeklyList) {
        this.weeklyList = weeklyList;
    }
    //-----------------------get Lists-----------------------------

    public ArrayList<String> getEmriTermini() {

        return emriList;
    }

    public ArrayList<String> getDitaTermini() {

        return ditaList;
    }

    public ArrayList<String> getOraTermini() {
        return oraList;
    }

    public ArrayList<Boolean> getWeeklyTermini() {
        return weeklyList;
    }

    public boolean isValidTermin(String ditaTerminit, String oraeTerminit) {
        if (ditaList.contains(ditaTerminit)) {
            if (oraList.contains(oraeTerminit)) {
                return false;
            }
            return true;
        }
        return true;

    }

    public void termini() {
        emriList.add(emri);
        ditaList.add(termin);
        oraList.add(ora);
        weeklyList.add(weekly);
    }
}
