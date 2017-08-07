package com.venkat.jsongen.json;

import com.venkat.jsongen.entity.Request;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * Created by venkatram.veerareddy on 8/7/2017.
 */
public class JsonGen {

    public static final String JSON_FILE="requests.json";
    private static final String CHAR_LIST =	"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int RANDOM_STRING_LENGTH = 10;
    private static final String[] CLASSIFICATION = new String[]{"Differentiated Data", "Industry Data", "Market Data", "Research, Publications/Newsletters",  "Other"};
    private static final String[] EMP_REVIEW_TYPE = new String[]{"Samples", "Trial/POC", "Subscription", "Other"};
    private static final String[] EMP_REQ_GROUP = new String[]{"XYZ", "Mario"};

    public static void main(String[] args) throws FileNotFoundException {

        reqJsonGenerator();
    }

    private static void reqJsonGenerator() throws FileNotFoundException {
        JsonArrayBuilder reqBuilder = Json.createArrayBuilder();
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();

        List<Request> reqList = createRequests();
        for(Request r : reqList){
            JsonObjectBuilder jobj = Json.createObjectBuilder();
            jobj.add("empRequestID", r.getEmpRequestID());
            jobj.add("requestDate", r.getRequestDate().toString());
            jobj.add("empProviderID", r.getEmpProviderID());
            jobj.add("empProviderName", r.getEmpProviderName());
            jobj.add("empProductClassification", r.getEmpProductClassification());
            jobj.add("empProductSubClassification", r.getEmpProductSubClassification());
            jobj.add("empReviewType", r.getEmpReviewType());
            jobj.add("empRequestingGroup", r.getEmpRequestingGroup());

            jobj.add("QuestionnaireUrl", r.getQuestionnaireUrl());
            jobj.add("Priority", r.getPriority());
            reqBuilder.add(jobj);

        }

        JsonArray reqJsonObject = reqBuilder.build();
        jsonBuilder.add("Requests", reqJsonObject);
        JsonObject reqObj = jsonBuilder.build();
        System.out.println("Request JSON String\n"+reqObj);

        //write to file
        OutputStream os = new FileOutputStream(JSON_FILE);
        //JsonWriter jsonWriter = Json.createWriter(os);
        JsonWriterFactory wf = getJsonWriteFactory();
        JsonWriter jsonWriter = wf.createWriter(os);

        jsonWriter.writeObject(reqObj);
        jsonWriter.close();
    }

    private static JsonWriterFactory getJsonWriteFactory(){

        Map<String, Boolean> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);
        JsonWriterFactory wf = Json.createWriterFactory(config);
        return wf;
    }

    public static List<Request> createRequests(){
        List<Request> reqList = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            Request req = new Request();
            UUID uuid = UUID.randomUUID();
            req.setEmpRequestID(uuid.toString());
            req.setRequestDate(Calendar.getInstance().getTime() +"");
            uuid = UUID.randomUUID();
            req.setEmpProviderID(uuid.toString());
            req.setEmpProviderName(generateRandomString());
            uuid = UUID.randomUUID();
            req.setEmpProductID(uuid.toString());
            req.setEmpProductName(generateRandomString());
            req.setEmpProductClassification(CLASSIFICATION[getRandomNum(6)]);
            req.setEmpProductSubClassification(generateRandomString());
            req.setEmpReviewType(EMP_REVIEW_TYPE[getRandomNum(5)]);
            req.setEmpRequestingGroup(EMP_REQ_GROUP[getRandomNum(3)]);
            req.setQuestionnaireUrl("http://"+generateRandomString()+".com");
            int val = getRandomNum(10);
            if(val == 0) val = 1;
            req.setPriority(val);
            reqList.add(req);
        }

        return reqList;

    }

    public static String generateRandomString(){

        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }


    private static int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }

    private static int getRandomNum(int length) {
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
