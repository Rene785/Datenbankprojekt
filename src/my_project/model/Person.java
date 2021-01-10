package my_project.model;

public class Person {

    private int perso_id;
    private int reisepass_id;
    private int fuehrerschein_id;
    private int punkte;
    private boolean gueltig;
    private String vorname;
    private String nachname;
    private String staatsangehoerigkeit;
    private String perso_gueltig;
    private String reisepass_gueltig;
    private String fuehrerschein_gueltig;
    private String mistakeReason;

    public Person(){
        punkte = 0;
        perso_id = 1;
        reisepass_id = 1;
        fuehrerschein_id = 1;
    }

    public void zufallsVorname(){
        double i = (int) (Math.random() * 100);
        if(i<10){
            vorname = "Dieter";
        }else if(i>=10&&i<20){
            vorname = "Marie";
        }else if(i>=20&&i<30){
            vorname = "Mario";
        }else if(i>=30&&i<40){
            vorname = "Olivia";
        }else if(i>=40&&i<50){
            vorname = "Peter";
        }else if(i>=50&&i<60){
            vorname = "Julia";
        }else if(i>=60&&i<70){
            vorname = "David";
        }else if(i>=70&&i<80){
            vorname = "Lara";
        }else if(i>=80&&i<90){
            vorname = "Daniel";
        }else if(i>=90 && i<=100){
            vorname = "Sophie";
        }
    }

    public void zufallsNachname(){
        double i = (int) (Math.random() * 100);
        if(i<10){
            nachname= "Müller";
        }else if(i>=10&&i<20){
            nachname = "Meier";
        }else if(i>=20&&i<30){
            nachname = "Schulze";
        }else if(i>=30&&i<40){
            nachname = "Fischer";
        }else if(i>=40&&i<50){
            nachname = "Ali";
        }else if(i>=50&&i<60){
            nachname = "Johnson";
        }else if(i>=60&&i<70){
            nachname = "Kurie";
        }else if(i>=70&&i<80){
            nachname = "Merkel";
        }else if(i>=80&&i<90){
            nachname = "Friedrich";
        }else if(i>=90 && i<=100){
            nachname = "König";
        }
    }
    public void zufallsStaatsangehoerigkeit(){
        double i = (int) (Math.random() * 100);
        if(i<10){
            staatsangehoerigkeit = "Deutschland";
        }else if(i>=10&&i<20){
            staatsangehoerigkeit = "Deutschland";
        }else if(i>=20&&i<30){
            staatsangehoerigkeit = "Deutschland";
        }else if(i>=30&&i<40){
            staatsangehoerigkeit = "Frankreich";
        }else if(i>=40&&i<50){
            staatsangehoerigkeit = "Spanien";
        }else if(i>=50&&i<60){
            staatsangehoerigkeit = "Ghana";
        }else if(i>=60&&i<70){
            staatsangehoerigkeit = "Marokko";
        }else if(i>=70&&i<80){
            staatsangehoerigkeit = "Schweiz";
        }else if(i>=80&&i<90){
            staatsangehoerigkeit = "Mexiko";
        }else if(i>=90 && i<=100){
            staatsangehoerigkeit = "Südafrika";
        }
    }

    public void zufallFehler() {
        if (gueltig) {
            rechneGueltigeZufallsDaten();
        }else if(!gueltig){
            double mistake = (int) (Math.random()*100);
            if(mistake <50){
                mistakeReason = "Mindestens ein Dokument ist nicht gültig";
                double p = (int) (Math.random() * 100);
                double r = (int) (Math.random() * 100);
                double f = (int) (Math.random() * 100);
                if(p<50){
                    perso_gueltig = "2019-05-06";
                }else if(p>=50 && p<100){
                    perso_gueltig = "2020-12-24";
                }
                if(r<50){
                    reisepass_gueltig = "2022-07-18";
                }else if(r>=50 && r<100){
                    reisepass_gueltig = "2023-01-01";
                }
                if(f<50){
                    fuehrerschein_gueltig = "2024-10-13";
                }else if(f>=50 && f<100){
                    fuehrerschein_gueltig = "2018-11-16";
                }
            }else if(mistake >=50 && mistake<100){
                mistakeReason = "Kriterien wurden nicht erfüllt";
                rechneGueltigeZufallsDaten();
            }
            System.out.println(mistakeReason);
        }

    }

    public void rechneGueltigeZufallsDaten(){
        double p = (int) (Math.random() * 100);
        double r = (int) (Math.random() * 100);
        double f = (int) (Math.random() * 100);
        if (p < 20) {
            perso_gueltig = "2021-05-06";
        } else if (p > 20 && p < 40) {
            perso_gueltig = "2022-08-20";
        } else if (p > 40 && p < 60) {
            perso_gueltig = "2023-01-03";
        } else if (p > 60 && p < 80) {
            perso_gueltig = "2024-04-22";
        } else if (p > 80 && p < 100) {
            perso_gueltig = "2025-12-28";
        }
        if (r < 20) {
            reisepass_gueltig = "2021-05-06";
        } else if (r > 20 && r < 40) {
            reisepass_gueltig = "2022-08-20";
        } else if (r > 40 && r < 60) {
            reisepass_gueltig = "2023-01-03";
        } else if (r > 60 && r < 80) {
            reisepass_gueltig = "2024-04-22";
        } else if (r > 80 && r < 100) {
            reisepass_gueltig = "2025-12-28";
        }
        if (f < 20) {
            fuehrerschein_gueltig = "2021-05-06";
        } else if (f > 20 && f < 40) {
            fuehrerschein_gueltig = "2022-08-20";
        } else if (f > 40 && f < 60) {
            fuehrerschein_gueltig = "2023-01-03";
        } else if (f > 60 && f < 80) {
            fuehrerschein_gueltig = "2024-04-22";
        } else if (f > 80 && f < 100) {
            fuehrerschein_gueltig = "2025-12-28";
        }
    }

    public void setzeGueltigkeit(boolean g){
        gueltig = g;
    }
    public boolean getGueltig(){
        return gueltig;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getStaatsangehoerigkeit() {
        return staatsangehoerigkeit;
    }

    public int getPerso_id(){
        return perso_id;
    }
    public void addOneOnPersoID(){
        perso_id++;
    }

    public int getReisepass_id() {
        return reisepass_id;
    }
    public void addOneOnReisepassID(){
        reisepass_id++;
    }

    public int getFuehrerschein_id() {
        return fuehrerschein_id;
    }
    public void addOneOnFuehrerscheinID(){
        fuehrerschein_id++;
    }

    public String getPerso_gueltig() {
        return perso_gueltig;
    }

    public void setPerso_gueltig(String perso_gueltig) {
        this.perso_gueltig = perso_gueltig;
    }

    public String getReisepass_gueltig() {
        return reisepass_gueltig;
    }

    public void setReisepass_gueltig(String reisepass_gueltig) {
        this.reisepass_gueltig = reisepass_gueltig;
    }

    public String getFuehrerschein_gueltig() {
        return fuehrerschein_gueltig;
    }

    public void setFuehrerschein_gueltig(String fuehrerschein_gueltig) {
        this.fuehrerschein_gueltig = fuehrerschein_gueltig;
    }

    public int getPunkte(){
        return punkte;
    }

    public void setPunkte(int s){
        punkte = punkte +s;
    }
}
