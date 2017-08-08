package com.venkat.jsongen.json;

import com.venkat.jsongen.entity.CompositeRequest;
import com.venkat.jsongen.entity.Product;
import com.venkat.jsongen.entity.Provider;
import com.venkat.jsongen.reader.WordList;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by venkatram.veerareddy on 8/8/2017.
 */
public class CompositeRequestJsonGen {

    public static final String JSON_FILE="requests.json";
    private static final String CHAR_LIST =	"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int RANDOM_STRING_LENGTH = 10;
    private static final String[] CLASSIFICATION = new String[]{"Differentiated Data", "Industry Data", "Market Data", "Research,Publications/Newsletters",  "Other"};
    private static final String[] EMP_REVIEW_TYPE = new String[]{"Samples", "Trial/POC", "Subscription", "Other"};
    private static final String[] EMP_REQ_GROUP = new String[]{"XYZ", "Mario"};
    private static final String[] DOMAIN_GROUPS = new String[]{".com", ".org",".net"};
    private static final Integer[] dateRange = new Integer[]{10,20,30,40,50,60,70,80,90,-10,-20,-30,-40,-50,-60,-70,-80,-90};

    public static void main(String[] args) throws FileNotFoundException {

        reqJsonGenerator();
    }

    private static void reqJsonGenerator() throws FileNotFoundException {

        JsonArrayBuilder reqArrayBuilder = Json.createArrayBuilder();

        List<CompositeRequest> reqList = createRequests();

        for(CompositeRequest r : reqList){

            JsonObjectBuilder jobj = Json.createObjectBuilder();

            jobj.add("empRequestID", r.getEmpRequestID());
            jobj.add("requestDate", r.getRequestDate().toString());
            jobj.add("Provider", generateProviderJson(r.getProvider()));
            jobj.add("empProductClassification", r.getEmpProductClassification());
            jobj.add("empProductSubClassification", r.getEmpProductSubClassification());
            jobj.add("empReviewType", r.getEmpReviewType());
            jobj.add("empRequestingGroup", r.getEmpRequestingGroup());
            jobj.add("questionnaireUrl", r.getQuestionnaireUrl());
            jobj.add("priority", r.getPriority());

            reqArrayBuilder.add(jobj);

        }

        JsonArray reqJsonObject = reqArrayBuilder.build();

        JsonObjectBuilder reqJsonBuilder = Json.createObjectBuilder();
        reqJsonBuilder.add("Requests", reqJsonObject);
        JsonObject reqObj = reqJsonBuilder.build();

        System.out.println("Request JSON String\n"+reqObj);

        //write to file
        OutputStream os = new FileOutputStream(JSON_FILE);
        //JsonWriter jsonWriter = Json.createWriter(os);
        JsonWriterFactory wf = getJsonWriteFactory();
        JsonWriter jsonWriter = wf.createWriter(os);

        jsonWriter.writeObject(reqObj);
        jsonWriter.close();
    }

    private static String formattedDate(){
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int randomDate = dateRange[getRandomNumber(18)];
        c.add(Calendar.DATE, randomDate);
        Date d = c.getTime();
        return format.format(d);
    }

    private static JsonObject generateProviderJson(Provider provider){

        JsonArrayBuilder reqArrayBuilder = Json.createArrayBuilder();

        JsonObjectBuilder jobj = Json.createObjectBuilder();
        jobj.add("empProviderID", provider.getProviderId());
        jobj.add("empProviderName", provider.getProviderName().trim());
        jobj.add("product", generateProductJson(provider.getProduct()));
        return jobj.build();
			/*reqArrayBuilder.add(jobj);
	
		return reqArrayBuilder.build();*/
    }

    private static JsonObject generateProductJson(Product prod){

        JsonArrayBuilder reqArrayBuilder = Json.createArrayBuilder();

        JsonObjectBuilder jobj = Json.createObjectBuilder();
        jobj.add("empProductID", prod.getProductId());
        jobj.add("empProductName", prod.getProductName().trim());
        return jobj.build();
			/*reqArrayBuilder.add(jobj);
	
		return reqArrayBuilder.build();*/
    }

    private static JsonWriterFactory getJsonWriteFactory(){

        Map<String, Boolean> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);
        JsonWriterFactory wf = Json.createWriterFactory(config);
        return wf;
    }

    public static List<CompositeRequest> createRequests(){

        List<CompositeRequest> reqList = new ArrayList<>();

        for(int i = 0; i < 1000; i++){

            CompositeRequest req = new CompositeRequest();

            UUID uuid = UUID.randomUUID();
            req.setEmpRequestID(uuid.toString());

            req.setRequestDate(formattedDate());
			

            req.setProvider(generateRandomProviders());

            req.setEmpProductClassification(CLASSIFICATION[getRandomNumber(6)]);

            req.setEmpProductSubClassification(generateRandomString());

            req.setEmpReviewType(EMP_REVIEW_TYPE[getRandomNumber(5)]);

            req.setEmpRequestingGroup(EMP_REQ_GROUP[getRandomNumber(3)]);

            req.setQuestionnaireUrl("http://"+generateRandomString()+DOMAIN_GROUPS[getRandomNumber(4)]);

            int val = getRandomNumber(11);
            if(val == 0) val = 1;
            req.setPriority(val);

            reqList.add(req);

        }

        return reqList;

    }

    private static Provider generateRandomProviders(){

        Provider p = new Provider();
        for(int ip = 0; ip < 1;ip++){
            UUID uuid = UUID.randomUUID();
            p.setProviderId(uuid.toString());
            //String name = generateRandomWords();
            String name = genMeaningFulWords();
            p.setProviderName(name.trim());
            p.setProduct(generateRandomProducts());
            //providers.add(p);
        }

        return p;
    }

    private static String genMeaningFulWords(){
        String[] words = WordList.fileReader();
        StringBuilder name = new StringBuilder();

        for(int ip = 0; ip < getRandomNumber(4) + 1;ip++){
            int num = getRandomNumber(100);
            name.append(words[num]);
            name.append("  ");
        }
        return name.toString();

    }


    private static Product generateRandomProducts(){

        Product p = new Product();
        for(int ip = 0; ip < 1;ip++){
            UUID uuid = UUID.randomUUID();
            p.setProductId(uuid.toString());
            //String prodName = generateRandomWords();
            String prodName = genMeaningFulWords();
            p.setProductName(prodName);

        }
        return p;
    }

    private static String generateRandomWords() {
        StringBuilder name = new StringBuilder();
        for(int ip = 0; ip < getRandomNumber(5) + 1;ip++){
            name.append(generateRandomString());
            name.append("  ");
        }
        return name.toString();
    }

    public static String generateRandomString(){

        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
            int number = getRandomNumber(CHAR_LIST.length());
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }


    private static int getRandomNumber(int length) {

        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(length);
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }
}
