package Validator.ValidationGlobale;

import java.time.format.DateTimeFormatter;

public  final  class DateFormat {
 DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd,yyyy,hh:mm");

    public   DateTimeFormatter getFormatMoisJourAnneeHeureMinute() {
        return f;
    }

    public void setF(DateTimeFormatter f) { //si  tu souhaites une classe immuable, enlève le setter setF(DateTimeFormatter f) et déclare l'attribut f comme private final.
        // Cela garantit que l'objet ne pourra pas être modifié après son initialisation.
        this.f = f;
    }
}

