package my_project.control;

import KAGO_framework.control.DatabaseController;
import KAGO_framework.model.abitur.datenbanken.mysql.QueryResult;
import my_project.model.Person;

public class SQLControll {
    //Attribute

    //Referenzen
    private DatabaseController dbController;
    private Person person;

    public SQLControll(Person person){
        this.person = person;
        dbController = new DatabaseController();
        dbController.connect();
        loescheTabelle();
        createTables();
        createNewEntity();
    }

    private String formatSQLOutput(String[] attributes, String[][] result){
        String formattedString = "";
        for(String attribute:attributes)
        {
            formattedString = formattedString + attribute + "; ";
        }
        formattedString = formattedString + "\n\n";
        for(String[] row:result){
            for(String entry:row){
                formattedString = formattedString + entry + "; ";
            }
            formattedString = formattedString + "\n";
        }
        return formattedString;
    }

    private String processSQL(String statement) {
        if(dbController.isConnected())
        {
            dbController.executeStatement(statement);
            QueryResult queryResult = dbController.getCurrentQueryResult();
            if(queryResult !=null)
            {
                return formatSQLOutput(queryResult.getColumnNames(), queryResult.getData());
            }
            else
            {
                String error = dbController.getErrorMessage();
                if(error !=null)
                {
                    return error;
                }
                else
                {
                    return "Success";
                }
            }
        }
        else
        {
            return "Connection not established.";
        }
    }
/*
    public void loescheTables(){
        System.out.println("Lösche " + processSQL("SHOW TABLES LIKE 'RG_%'"));
        if(dbController.isConnected()){
            if(dbController.getCurrentQueryResult() != null && dbController.getCurrentQueryResult().getData().length>0){
                String[][] tmpA = dbController.getCurrentQueryResult().getData();
                String delete = "DROP TABLE " + tmpA[0][0];
                for(int i = 0; i< tmpA.length;i++){
                    delete = delete + ", " +tmpA[i][0];
                }
                System.out.println("SQL-Löschbefehl: "+ processSQL(delete));
                processSQL(delete);
            }else{
                System.out.println("Keine Tabellen vorhanden");
            }
        }else{
            System.out.println("Keine Verbindung hergestellt");

        }
    }
*/
    public void loescheTabelle(){
        System.out.println("Vorhandene Tables: "+ processSQL("SHOW TABLES LIKE 'RG_%'"));
        if(dbController.isConnected()){
            if(dbController.getCurrentQueryResult() != null && dbController.getCurrentQueryResult().getData().length>0) {
                processSQL("SET FOREIGN_KEY_CHECKS=0;");
                processSQL("DROP TABLE RG_Fuehrerschein");
                processSQL("DROP TABLE RG_Personalausweis");
                processSQL("DROP TABLE RG_Reisepass");
                processSQL("SET FOREIGN_KEY_CHECKS=1;");
            }
        }
    }

    public void createTables(){
        processSQL("CREATE TABLE RG_Personalausweis(" +
                "ID INTEGER NOT NULL," +
                "Vorname VARCHAR(20),"+
                "Nachname VARCHAR(20)," +
                "Staatsangehörigkeit VARCHAR(20)," +
                "Gültig_bis DATE," +
                "Reisepass_ID INTEGER," +
                "Fuehrerschein_ID INTEGER," +
                "PRIMARY KEY(ID))" +
                ";");
        System.out.println("RG_Personalausweis erfolgreich erstellt");
        processSQL("CREATE TABLE RG_Reisepass(" +
                "ID INTEGER NOT NULL," +
                "Vorname VARCHAR(20)," +
                "Nachname VARCHAR(20)," +
                "Staatsangehörigkeit VARCHAR(20)," +
                "Gültig_bis DATE," +
                "Personalausweis_ID INTEGER," +
                "Fuehrerschein_ID INTEGER," +
                "PRIMARY KEY(ID))" +
                ";");
        System.out.println("RG_Reisepass erfolgreich erstellt");
        processSQL("CREATE TABLE RG_Fuehrerschein(" +
                "ID INTEGER NOT NULL," +
                "Vorname VARCHAR(20)," +
                "Nachname VARCHAR(20)," +
                "Staatsangehörigkeit VARCHAR(20)," +
                "Gültig_bis DATE," +
                "Personalausweis_ID INTEGER," +
                "Reisepass_ID INTEGER," +
                "PRIMARY KEY(ID))" +
                ";");
        System.out.println("RG_Fuehrerschein erfolgreich erstellt");
        //Fremdschlüssel

        processSQL("ALTER TABLE RG_Personalausweis " +
                "ADD CONSTRAINT FOREIGN KEY (Reisepass_ID) REFERENCES RG_Reisepass (ID), " +
                "ADD CONSTRAINT FOREIGN KEY (Fuehrerschein_ID) REFERENCES RG_Fuehrerschein (ID) " +
                "; ");

        processSQL("ALTER TABLE RG_Reisepass " +
                "ADD CONSTRAINT FOREIGN KEY (Personalausweis_ID) REFERENCES RG_Personalausweis (ID), " +
                "ADD CONSTRAINT FOREIGN KEY (Fuehrerschein_ID) REFERENCES RG_Fuehrerschein (ID) " +
                ";");

        processSQL("ALTER TABLE RG_Fuehrerschein " +
                "ADD CONSTRAINT FOREIGN KEY (Personalausweis_ID) REFERENCES RG_Personalausweis (ID), " +
                "ADD CONSTRAINT FOREIGN KEY (Reisepass_ID) REFERENCES RG_Reisepass (ID) " +
                ";");

        //createEntities();
    }
/*
    public void createEntities(){
        //Datensätze für RG_Fuehrerschein
        System.out.println(processSQL("INSERT INTO RG_Fuehrerschein " +
                "VALUES " +
                "(1,'Klaus','Peter','Deutschland','2022-04-22',1,1) " +
                ";"));
        System.out.println(processSQL("INSERT INTO RG_Fuehrerschein " +
                "VALUES " +
                "(2,'Kilian','Ludewig','Schweiz','2021-01-08',2,2) " +
                ";"));
        System.out.println(processSQL("INSERT INTO RG_Fuehrerschein " +
                "VALUES " +
                "(3,'Olivia','König','Deutschland','2024-10-30',3,null)" +
                ";"));
        System.out.println("INSERT INTO RG_Fuehrerschein " +
                "VALUES " +
                "(4,'Dieter','Dietermann','Belgien',4,3)" +
                ";");
        System.out.println("INSERT INTO RG_Fuehrerschein " +
                "VALUES " +
                "(5,Sead','Kolasinac','Bosnien',2023-06-10,NULL,4)" +
                ";");
        //Datensätze für RG_Reisepass
        System.out.println(processSQL("INSERT INTO RG_Reisepass " +
                "VALUES " +
                "(1,'Klaus','Peter','Deutschland',2019-05-01,1,1)" +
                ";"));
        System.out.println(processSQL("INSERT INTO RG_Reisepass " +
                "VALUES " +
                "(2,'Kilian','Ludewig','Schweiz',2022-08-01,2,2)" +
                ";"));
        System.out.println("INSERT INTO RG_Reisepass " +
                "VALUES " +
                "(3,'Dieter','Dietermann','Luxemburg',2020-04-18,4,4)" +
                ";");
        System.out.println("INSERT INTO RG_Reisepass " +
                "VALUES " +
                "(4,'Sead','Kolasinac','Bosnien',2023-06-06,NULL,5)" +
                ";");
        System.out.println(processSQL("INSERT INTO RG_Reisepass " +
                "VALUES " +
                "(5,'Marianne','Rosenberg','Deutschland',2022-01-01,5,NULL)" +
                ";"));
        //Datensätze für RG_Personalausweis
        System.out.println(processSQL("INSERT INTO RG_Personalausweis " +
                "VALUES " +
                "(1,'Klaus','Peter','Deutschland',2021-03-05,1,1)" +
                ";"));
    }

 */

    public void createNewEntity(){
        processSQL("INSERT INTO RG_Personalausweis " +
                "VALUES " +
                "("+person.getPerso_id()+
                ",'"+person.getVorname()+
                "','"+person.getNachname()+
                "','"+person.getStaatsangehoerigkeit()+
                "','"+person.getPerso_gueltig()+
                "',null"+
                ",null);");
        processSQL("INSERT INTO RG_Reisepass " +
                "VALUES " +
                "("+person.getReisepass_id()+
                ",'"+person.getVorname()+
                "','"+person.getNachname()+
                "','"+person.getStaatsangehoerigkeit()+
                "','"+person.getReisepass_gueltig()+
                "',"+person.getPerso_id()+
                ",null);");
        processSQL("INSERT INTO RG_Fuehrerschein " +
                "VALUES " +
                "("+person.getFuehrerschein_id()+
                ",'"+person.getVorname()+
                "','"+person.getNachname()+
                "','"+person.getStaatsangehoerigkeit()+
                "','"+person.getReisepass_gueltig()+
                "',"+person.getPerso_id()+
                ","+person.getReisepass_id()+
                ");");
        processSQL("UPDATE RG_Personalausweis SET Reisepass_ID = "+person.getReisepass_id()+" WHERE ID = "+person.getReisepass_id()+";");
        processSQL("UPDATE RG_Personalausweis SET Fuehrerschein_ID = "+person.getFuehrerschein_id()+" WHERE ID = "+person.getFuehrerschein_id()+";");
        processSQL("UPDATE RG_Reisepass SET Fuehrerschein_ID = "+person.getFuehrerschein_id()+" WHERE ID = "+person.getFuehrerschein_id()+";");
    }

}
