package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlEx {
	public static void main(String[] args) throws IOException {
		URL ur=new URL("https://www.simplilearn.com/?utm_source=google&utm_medium=cpc&utm_term=simplilearn&utm_content=802977548-41114892706-698790228381&utm_device=c&utm_campaign=Search-Brand-Exact-IN-AllDevice-adgroup-Brand-simplilearn&gad_source=1&gclid=EAIaIQobChMImpDOoLuwhwMVdatmAh1Vuwu_EAAYASAAEgKtnPD_BwE");
		String protocol=ur.getProtocol();
		System.out.println(protocol);
		int p=ur.getPort();
		String f=ur.getFile();
		System.out.println("PORT : "+p+" FILE : "+f);
		
		HttpURLConnection con=(HttpURLConnection)ur.openConnection();
		int res=con.getResponseCode();
		System.out.println(res);
		BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line=br.readLine();
		System.out.println(line);
	}
}
