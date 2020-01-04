/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilsLibrary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ModelLibrary.CardLibrary.Card;
import ModelLibrary.PlayerLibrary.UT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;



/**
 *
 * @author Hicham
 */
public class JSON {
    
    private static String relativePathJSONCards = "./resources/json/cards/";
    private static String relativePathJSONUTs = "./resources/json/wonders/";
    
    public static ArrayList<UT> readUTs(String fileName)
    {
        JSONArray jsonArray = null;
        ArrayList<UT> arrayList = new ArrayList<UT>();
        try (FileReader reader = new FileReader(relativePathJSONUTs + fileName))
        {
            //JSON parser object to parse read file
            JSONParser jsonParser = new JSONParser();
            
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            jsonArray = (JSONArray)obj;
            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            //convert json string to object
            if (jsonArray != null) { 
                int len = jsonArray.size();
                for (int i=0;i<len;i++){ 
                    arrayList.add(objectMapper.convertValue(jsonArray.get(i), UT.class));
                } 
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
    
    public static ArrayList<Card> readCards(String fileName)
    {
        JSONArray jsonArray = null;
        ArrayList<Card> arrayList = new ArrayList<Card>();
        try (FileReader reader = new FileReader(relativePathJSONCards + fileName))
        {
            //JSON parser object to parse read file
            JSONParser jsonParser = new JSONParser();
            
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            jsonArray = (JSONArray)obj;
            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            //convert json string to object
            if (jsonArray != null) { 
                int len = jsonArray.size();
                for (int i=0;i<len;i++){ 
                    arrayList.add(objectMapper.convertValue(jsonArray.get(i), Card.class));
                } 
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
