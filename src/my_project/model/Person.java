package my_project.model;

public class Person {

    private int perso_id;
    private int reisepass_id;
    private int fuehrerschein_id;
    private String vorname;
    private String nachname;
    private String staatsangehoerigkeit;
    private String perso_gueltig;
    private String reisepass_gueltig;
    private String fuehrerschein_gueltig;

    public Person(){
        perso_id = 1;
        reisepass_id = 1;
        fuehrerschein_id = 1;
        zufallsVorname();
        zufallsNachname();
        zufallsStaatsangehoerigkeit();
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
            staatsangehoerigkeit = "Großbritannien";
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
}
