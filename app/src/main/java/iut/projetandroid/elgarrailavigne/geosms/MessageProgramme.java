package iut.projetandroid.elgarrailavigne.geosms;

import android.app.TimePickerDialog;
import android.location.Location;
import android.provider.ContactsContract;
import android.widget.TimePicker;

import java.util.Date;

/**
 * Created by POSTE on 08/03/2016.
 */
public class MessageProgramme {
    private String titre;
    private ContactsContract.CommonDataKinds.Phone num;
    private Date dateDenvoi;
    private TimePickerDialog heureDenvoi;
    private Location lieuDenvoi;
    private String contenuMessage;

    public String getTitre() {return titre;}
    public void setTitre(String titre) {this.titre = titre;}

    public ContactsContract.CommonDataKinds.Phone getNum() {return num;}
    public void setNum(ContactsContract.CommonDataKinds.Phone num) {this.num = num;}

    public Date getDateDenvoi() {return dateDenvoi;}
    public void setDateDenvoi(Date dateDenvoi) {this.dateDenvoi = dateDenvoi;}

    public TimePickerDialog getHeureDenvoi() {return heureDenvoi;}
    public void setHeureDenvoi(TimePickerDialog heureDenvoi) {this.heureDenvoi = heureDenvoi;}

    public Location getLieuDenvoi() {return lieuDenvoi;}
    public void setLieuDenvoi(Location lieuDenvoi) {this.lieuDenvoi = lieuDenvoi;}

    public String getContenuMessage() {return contenuMessage;}
    public void setContenuMessage(String contenuMessage) {this.contenuMessage = contenuMessage;}

    //Type toast pour afficher pop-up sur l'écran

    public MessageProgramme(String titre,
                            ContactsContract.CommonDataKinds.Phone num,
                            Date dateDenvoi,
                            TimePickerDialog heureDenvoi,
                            Location lieuDenvoi,
                            String contenuMessage) {
        this.titre = titre;
        this.num = num;
        this.dateDenvoi = dateDenvoi;
        this.heureDenvoi = heureDenvoi;
        this.lieuDenvoi = lieuDenvoi;
        this.contenuMessage = contenuMessage;
    }
}
