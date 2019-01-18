package net.voovo;

public class Test {

	public static void main(String[] args) {
		String password="#";
		String userid="1";
		String type="1";
		String ssid="home";
		String str="WIFI:S:"+ssid+";P:"+password+";T:WPA/WPA2;H:;U:"+userid+";"+"M:"+type+";";
		
		System.out.println(str);
	}
}
