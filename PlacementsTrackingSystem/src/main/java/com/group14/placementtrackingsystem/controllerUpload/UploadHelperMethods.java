package com.group14.placementtrackingsystem.controllerUpload;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.web.servlet.tags.EditorAwareTag;
import java.sql.Date;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;


/**
 * This class is used to store all string manipulation methods
 * @author aamd1
 * **/
public class UploadHelperMethods {
    public static SimpleDateFormat dateFromat = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * @param  input - a text extracted from the form
     * @return output - the extracted Date from the input
     * **/
    public static Date getDate(String input) throws ParseException {
        String re = "\\d{2}/\\d{2}/\\d{4}";

        Pattern pattern= Pattern.compile(re);
        Matcher matcher = pattern.matcher(input.replace(" ", ""));
        if(matcher.find()) {
            String[] split_date = matcher.group(0).split("/");
            return new Date(Date.parse(split_date[1]+"/"+split_date[0]+"/"+split_date[2]));
        }
        Date d = new Date(Date.parse("01/01/2023"));
        return d;

    }

    /**
     * @param  input - a text extracted from the form
     * @return output - the extracted floating-point number from input
     * **/
    public static float getFloatFromString(String input){
        String re = "\\d+.\\d+";
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(input.replace(" ", ""));
        matcher.find();
        return Float.parseFloat(matcher.group(0));
    }

    /**
     * @param  input - a text extracted from the form
     * @return output - the extracted integer from input
     * **/
    public static int getIntFromString(String input){
        String re = "\\d+";
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(input.replace(" ", ""));
        matcher.find();
        System.out.println("Matcher"+matcher.groupCount());
        if(matcher.groupCount()==0){
            return 999999999;
        }
        return Integer.parseInt(matcher.group(0));
    }

    /**
     * @param  input - a text extracted from the form
     * @return output - the index of the first selected options
     * **/
    public static int getBooleanIntStateFromString(String input ){
        Map<List<Integer>, Character> dic = new HashMap<List<Integer>, Character>();
        char character;
        int index = 0;
        for(int i = 0; i < input.length(); i++){
            character= input.charAt(i);
            if(character== '☒' || character== '☐') {
                dic.put(Arrays.asList(index, i), character);
                index +=1;
            }
        }

        return dic.entrySet().stream().filter(item -> '☒' ==item.getValue()).collect(Collectors.toList()).get(0).getKey().get(0);

    }

    /**
     * @param  input - a text extracted from the form
     * @param  options - an array of options to choose from
     * @return output - the selected option or the last in the selection which is "Other"
     * **/
    public static String getOptionFromList(String input, String[] options){
        for(String option : options){
            if(input.contains(option)){
                return option;
            }
        }
        return options[options.length -1];
    }

    /**
     * @param  input - a text extracted from the from
     * @param  options - an array of options to choose from
     * @return output - a string of all selected options
     * **/
    public static String getMultiOptionFromList(String input, String[] options){
        String output = "";
        for(String option : options){
            if(input.contains(option)){
                output += option+", ";
            }
        }
        if (!output.equals("")){
            return output;
        }
        return options[options.length -1];
    }


    public static String processString(List<XWPFTableRow> rows,int index , int rowNumber){
        List<Integer> sectionHeaderIndecies = Arrays.asList(0, 10, 19, 29, 33, 39, 43, 49, 51);
        String toReturn = rows.get(rowNumber+sectionHeaderIndecies.get(index)).getTableCells().get(1).getText().replace(" ", "");

        if(toReturn.equals("")){
            return  "";
        }

        return toReturn;
    }
    public static byte getByteFromString(String input){
        Pattern patternY = Pattern.compile("☒ Yes");
        Pattern patternN = Pattern.compile("☒ No");
        Pattern patternU = Pattern.compile("☒ Unsure");
        Pattern patternNA = Pattern.compile("☒ N/A");
        Pattern patternPerm = Pattern.compile("☒ Permanently");
        Pattern patternHyb = Pattern.compile("☒ Hybrid working");
        Pattern patternRemote = Pattern.compile("☒ Fully Remote");
        Matcher matcherY = patternY.matcher(input);
        Matcher matcherN = patternN.matcher(input);
        Matcher matcherU = patternU.matcher(input);
        Matcher matcherNA = patternNA.matcher(input);
        Matcher matcherPerm = patternPerm.matcher(input);
        Matcher matcherRemote = patternHyb.matcher(input);
        Matcher matcherHyb = patternRemote.matcher(input);
        if (matcherY.find()){
            System.out.println("yes");
            return 1;
        }
        else if (matcherN.find()){return 0;}
        else if (matcherU.find()){return 2;}
        else if (matcherNA.find()){return 2;}
        else if (matcherPerm.find()){return 1;}
        else if (matcherRemote.find()){return 2;}
        else if (matcherHyb.find()){return 0;}
        else{ return 3;}

    }

    public static String getExplanation(String input){


        input = input.replace(" ", "");

        String[] output = input.split(":");
        if (output.length > 1){
        return output[1].strip();}
        return "none";
    }

    public static String getName(String input){

        Pattern p = Pattern.compile("a. Name of provider:(.*?)b.");
        Matcher m = p.matcher(input);
        if (m.find()){
            String s = m.group(0).substring(20,m.group().length()-2).strip();
            System.out.println(s);
            return s;
        }

        return "EMPTY";


    }

    public static String getExpiry(String input){



        Pattern p = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        Matcher m = p.matcher(input);


        if (m.find()){

            String s = m.group(0);
            System.out.println(s);
            return m.group(0);
        }

        return "EMPTY";

    }

    public static String replace(String input){
        input = input.replace(" ", "");
        if (input.length() > 0){
            System.out.println(input);
            return input;
        }
        return "EMPTY";
    }








}
