package ie.ucc.stabirca.peopleinformation;

public class PeopleData {

    private Person [] data =
            {
                    new Person("Sabin Tabirca", "11111111", "WGB, CS, UCC", "sabin.jpg", "http://www.cs.ucc.ie"),
                    new Person("Sabina Tabirca", "22222222", "WGB, CS, UCC", "sabin.jpg", "http://www.cs.ucc.ie"),
                    new Person("Sabine Tabirca", "33333333", "WGB, CS, UCC", "sabin.jpg", "http://www.cs.ucc.ie"),
                    new Person("Saby Tabirca", "44444444", "WGB, CS, UCC", "sabin.jpg", "http://www.cs.ucc.ie")

            };

    public Person getPersonData(int i){return data[i];}


    public String [] getNames(){

        String [] names = new String[data.length];
        for(int i = 0;i<data.length;i++){

            names[i] = data[i].getName();

        }
        return names;
    }

    public int getLength(){return data.length;}


}
