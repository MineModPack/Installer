package me.noahp78.mm.installer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Properties;

import com.google.gson.Gson;

public class Main {
	static Properties props = new Properties();
	static String mcversion;
	static String pack;
	static String ad = System.getenv("APPDATA");
	static boolean isforgepack = false;
	public static void main(String[] args){
		System.out.println("MineMod Installer Version Alpha 1");
		
		
		try {
			props.load(Main.class.getResourceAsStream("install.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to load the Embedded properties file!");
			e.printStackTrace();
			System.exit(1);
		}
		
		mcversion = props.getProperty("mcversion");
		pack = props.getProperty("pack");
		if(props.getProperty("isforgepack").equals("1")){
			isforgepack=true;
		}else{
			System.out.println("IsForgePack =" + props.getProperty("isforgepack"));
		
		}
		System.out.println("Determined I'm going to install pack " + pack + " On MC " + mcversion + " and isforgepack is " + isforgepack);
		String s = File.separator;
		String mcdir = ad + s + "." + "minecraft" + s + "versions";
		Boolean exists=false;
		String mojang = ad + s + "." + "minecraft" + s + "versions" + s + mcversion + s + mcversion + ".jar";
		File f = new File(mojang);
		if(f.exists() && !f.isDirectory()) { exists=true;}
		
		System.out.println("FileExists: " +mojang + " " + exists);
		String mydir = mcdir + s +"ModManager-" + pack + s;
		new File(mydir).mkdir();
		System.out.println("making directory " + mydir);
		
		System.out.println("start building JSON");
		Mcversion version = new Mcversion();
		version.setId("ModManager-" + pack);
		version.setMainClass("me.noahp78.mm.ModManager");
		version.setMinecraftArguments("--username ${auth_player_name} --version ${version_name} --gameDir ${game_directory} --assetsDir ${assets_root} --assetIndex ${assets_index_name} --uuid ${auth_uuid} --accessToken ${auth_access_token} --userProperties ${user_properties} --userType ${user_type} -mod-packid "
		+ pack + " -mod-mcdefault " + mcversion);
		version.setAssets(mcversion);
		version.setReleaseTime("1960-01-01T08:00:00+01:00");
		//TODO : This V may be need to set to the current time.
		version.setTime("1960-01-01T08:00:00+01:00");
		Gson g = new Gson();
		System.out.println(isforgepack + " = IsForgePack");
		if(isforgepack){
			String strFileContents=null;
			try {
				strFileContents = convertStreamToString(Main.class.getResourceAsStream("forge.json"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			Mcversion forge = g.fromJson(strFileContents, Mcversion.class);
		    version.setLibraries(forge.getLibraries());
		}else{
			String strFileContents=null;
			try {
				strFileContents = convertStreamToString(Main.class.getResourceAsStream("vanilla.json"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			Mcversion forge = g.fromJson(strFileContents, Mcversion.class);
		    version.setLibraries(forge.getLibraries());
			
			
		}
		version.setType("release");
		version.setMinimumLauncherVersion(13);
		System.out.println("Building Json is done, writing and downloading some files");
		//System.out.println(g.toJson(version));
		String jsonresult = g.toJson(version);
		PrintWriter out;
		try {
			out = new PrintWriter(mydir + "ModManager-" + pack + ".json");
			out.write(jsonresult);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Couldn't open " + mydir + "ModManager-" + pack + ".json");
			e.printStackTrace();
		}
		
		URL website;
		try {
			website = new URL("http://content1.newaurorastudios.tk/mods/ModManager.jar");
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(mydir + "ModManager-" + pack + ".jar");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Something bad happend during download of the ModManager jar!");
			e.printStackTrace();
		}
		System.out.println("We may be done!");
		
		
		
		
		
		
		
		
		
	}
	public static String convertStreamToString(InputStream is)
            throws IOException {
        /*
         * To convert the InputStream to String we use the
         * Reader.read(char[] buffer) method. We iterate until the
35.         * Reader return -1 which means there's no more data to
36.         * read. We use the StringWriter class to produce the string.
37.         */
        if (is != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[1024];
            try
            {
                Reader reader = new BufferedReader(
                        new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) 
                {
                    writer.write(buffer, 0, n);
                }
            }
            finally 
            {
                is.close();
            }
            return writer.toString();
        } else {       
            return "";
        }
    }
}
