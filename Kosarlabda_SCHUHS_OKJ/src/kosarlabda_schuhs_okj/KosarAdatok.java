/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kosarlabda_schuhs_okj;

/**
 *
 * @author Soma
 */
public class KosarAdatok 
{
    //hazai;idegen;hazai_pont;idegen_pont;helyszín;időpont
    public String Hazai;
    public String Idegen;
    public int HazaiPont;
    public int IdegenPont;
    public String Helyszin;
    public String Idopont;

    public String getHazai() {
        return Hazai;
    }

    public void setHazai(String Hazai) {
        this.Hazai = Hazai;
    }

    public String getIdegen() {
        return Idegen;
    }

    public void setIdegen(String Idegen) {
        this.Idegen = Idegen;
    }

    public int getHazaiPont() {
        return HazaiPont;
    }

    public void setHazaiPont(int HazaiPont) {
        this.HazaiPont = HazaiPont;
    }

    public int getIdegenPont() {
        return IdegenPont;
    }

    public void setIdegenPont(int IdegenPont) {
        this.IdegenPont = IdegenPont;
    }

    public String getHelyszin() {
        return Helyszin;
    }

    public void setHelyszin(String Helyszin) {
        this.Helyszin = Helyszin;
    }

    public String getIdopont() {
        return Idopont;
    }

    public void setIdopont(String Idopont) {
        this.Idopont = Idopont;
    }

    public KosarAdatok(String Hazai, String Idegen, int HazaiPont, int IdegenPont, String Helyszin, String Idopont) {
        this.Hazai = Hazai;
        this.Idegen = Idegen;
        this.HazaiPont = HazaiPont;
        this.IdegenPont = IdegenPont;
        this.Helyszin = Helyszin;
        this.Idopont = Idopont;
    }

}