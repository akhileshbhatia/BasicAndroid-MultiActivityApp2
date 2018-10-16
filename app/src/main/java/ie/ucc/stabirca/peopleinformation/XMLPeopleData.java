package ie.ucc.stabirca.peopleinformation;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLPeopleData {
    private Context context;
    private Person[] data;

    public  XMLPeopleData(Context context){
        this.context = context;

        //get stream to xml and parse it
        InputStream stream = this.context.getResources().openRawResource(R.raw.people);
        DocumentBuilder builder =null;
        Document document = null;
        try{
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = builder.parse(stream);
        }catch (Exception e){

        }
        //extract the nodelists for name,address etc.
        NodeList nameList = document.getElementsByTagName("name");
        NodeList addressList = document.getElementsByTagName("address");
        NodeList phoneList = document.getElementsByTagName("phone");
        NodeList imageList = document.getElementsByTagName("image");
        NodeList urlList = document.getElementsByTagName("url");

        data = new Person[nameList.getLength()];
        //traverse these node lists to populate data
        for(int i=0; i<nameList.getLength();i++){
            //extract name,address etc
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String address = addressList.item(i).getFirstChild().getNodeValue();
            String phone = phoneList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();

            //make a Person object
            Person p = new Person(name,address,phone,image,url);

            // add it to data
            data[i] = p;
        }
    }

    public Person getPersonData(int i){
        return data[i];
    }


    public String [] getNames(){

        String [] names = new String[data.length];
        for(int i = 0;i<data.length;i++){

            names[i] = data[i].getName();

        }
        return names;
    }

    public int getLength(){
        return data.length;
    }
}
