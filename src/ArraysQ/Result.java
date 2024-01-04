//package Arrays;
//
//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.function.*;
//import java.util.regex.*;
//import java.util.stream.*;
//import static java.util.stream.Collectors.joining;
//import static java.util.stream.Collectors.toList;
//import java.net.*;
//import org.json.simple.*;
//import org.json.simple.parser.*;
//
//class Result {
//
//    /*
//     * Complete the 'totalTransactions' function below.
//     *
//     * The function is expected to return a 2D_INTEGER_ARRAY.
//     * The function accepts following parameters:
//     *  1. INTEGER locationId
//     *  2. STRING transactionType
//     *
//     * Base url for copy/paste
//     * https://jsonmock.hackerrank.com/api/transactions/search?txnType=<transactionType>&page=<pageNumber>
//     */
//
//    public static List<List<Integer>> totalTransactions(int locationId, String transactionType) {
//        List<List<Integer>> totalTranRec = new ArrayList<>();
//        try{
//            URL url = new URL("https://jsonmock.hackerrank.com/api/transactions/search?txnType="+transactionType);
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("GET");
//            con.connect();
//            int resCode = con.getResponseCode();
//            if(resCode != 200){
//                throw new RuntimeException("Httpcode="+resCode);
//            }else{
//                String inline ="";
//                Scanner scanner = new Scanner(url.openStream());
//                while(scanner.hasNext()){
//                    inline+= scanner.nextLine();
//                }
//                scanner.close();
//                JSONParser pa = new JSONParser();
//                JSONObject res_obj = (JSONObject) pa.parse(inline);
//                long totalpages = (long)((JSONObject)res_obj).get("total_pages");
//                JSONArray data = getAllData(res_obj, transactionType,locationId,totalpages);
//                Map <Long,Double> groupedBy = calculateTotal(data);
//                System.out.println(groupedBy.size());
//                List<Integer> onelement = new ArrayList<>();
//                groupedBy.forEach((k,v) ->{
//                    onelement.add(k.intValue());
//                    onelement.add((int)Math.round(v));
//                    totalTranRec.add(onelement);
//                    onelement.clear();
//                });
//
//            }
//        }
//        catch(Exception er){
//            System.out.println("error"+er);
//        }
//        finally{
//            return totalTranRec;
//        }
//
//    }
//
//
//    public static JSONArray getAllData(JSONObject res_obj,String transactionType, int location,long totalpages){
//        JSONArray totalData = new JSONArray();
//        for(int i =0; i< totalpages;i++){
//            try{
//                URL url = new URL("https://jsonmock.hackerrank.com/api/transactions/search?txnType="+transactionType+"&page="+i);
//                HttpURLConnection con = (HttpURLConnection) url.openConnection();
//                con.setRequestMethod("GET");
//                con.connect();
//                int resCode = con.getResponseCode();
//                if(resCode != 200){
//                    throw new RuntimeException("Httpcode="+resCode);
//                }else{
//                    String inline ="";
//                    Scanner scanner = new Scanner(url.openStream());
//                    while(scanner.hasNext()){
//                        inline+= scanner.nextLine();
//                    }
//                    scanner.close();
//                    JSONParser pa = new JSONParser();
//                    JSONObject curRes = (JSONObject) pa.parse(inline);
//                    JSONArray data = (JSONArray)curRes.get("data");
//                    for(int j =0 ; j<data.size();j++){
//                        JSONObject obj =(JSONObject)data.get(j);
//                        if((long)((JSONObject)obj.get("location")).get("id") == (long)location){
//                            totalData.add(obj);
//                        }
//                    }
//                }
//            }
//            catch(Exception er){
//                System.out.println("error"+er);
//            }
//        }
//        return totalData;
//    }
//
//    public static Map<Long,Double> calculateTotal(JSONArray data){
//        Map<Long,Double> group = new HashMap<>();
//        for(int j =0 ; j<data.size();j++){
//            long userId= (long)((JSONObject)data.get(j)).get("userId");
//            String amount =(String)((JSONObject)data.get(j)).get("amount");
//            String amountDoub = amount.replace("$","").replace(",","");
//            if(group.containsKey(userId)){
//                double val = group.get(userId);
//                val = val+ Double.parseDouble(amountDoub);
//                group.replace(userId, val);
//            }else{
//                group.put(userId,Double.parseDouble(amountDoub));
//            }
//        }
//        return group;
//    }
//
//
//
//}
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int locationId = Integer.parseInt(bufferedReader.readLine().trim());
//
//        String transactionType = bufferedReader.readLine();
//
//        List<List<Integer>> result = Result.totalTransactions(locationId, transactionType);
//
//        result.stream()
//                .map(
//                        r -> r.stream()
//                                .map(Object::toString)
//                                .collect(joining(" "))
//                )
//                .map(r -> r + "\n")
//                .collect(toList())
//                .forEach(e -> {
//                    try {
//                        bufferedWriter.write(e);
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                });
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
