package apiTest;


	/* Java 1.8 샘플 코드 */


	import java.io.InputStreamReader;
	import java.net.HttpURLConnection;
	import java.net.URL;
	import java.net.URLEncoder;
	import java.io.BufferedReader;
	import java.io.IOException;

	public class ApiExplorer {
	    public static void main(String[] args) throws IOException {
	        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1262000/CountryFlagService2/getCountryFlagList2"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gIRuJ6SH90S7hO6ge7hXAuHS%2B4vIFD7xlcE0wYySD1oJjLDjM%2Fk9jPakuzBfc%2FGKN5ru6syjhABujJX4yWUC3Q%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*XML 또는 JSON*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("cond[country_nm::EQ]","UTF-8") + "=" + URLEncoder.encode("가나", "UTF-8")); /*한글 국가명*/
	        urlBuilder.append("&" + URLEncoder.encode("cond[country_iso_alp2::EQ]","UTF-8") + "=" + URLEncoder.encode("GH", "UTF-8")); /*ISO 2자리코드*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*페이지 번호*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
	    }
	}

