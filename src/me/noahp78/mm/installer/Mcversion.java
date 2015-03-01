
package me.noahp78.mm.installer;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Mcversion {

    @Expose
    private String id;
    @Expose
    private String time;
    @Expose
    private String releaseTime;
    @Expose
    private String type;
    @Expose
    private String minecraftArguments;
    @Expose
    private List<Library> libraries = new ArrayList<Library>();
    @Expose
    private String mainClass;
    @Expose
    private Integer minimumLauncherVersion;
    @Expose
    private String assets;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The time
     */
    public String getTime() {
        return time;
    }

    /**
     * 
     * @param time
     *     The time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 
     * @return
     *     The releaseTime
     */
    public String getReleaseTime() {
        return releaseTime;
    }

    /**
     * 
     * @param releaseTime
     *     The releaseTime
     */
    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The minecraftArguments
     */
    public String getMinecraftArguments() {
        return minecraftArguments;
    }

    /**
     * 
     * @param minecraftArguments
     *     The minecraftArguments
     */
    public void setMinecraftArguments(String minecraftArguments) {
        this.minecraftArguments = minecraftArguments;
    }

    /**
     * 
     * @return
     *     The libraries
     */
    public List<Library> getLibraries() {
        return libraries;
    }

    /**
     * 
     * @param libraries
     *     The libraries
     */
    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }

    /**
     * 
     * @return
     *     The mainClass
     */
    public String getMainClass() {
        return mainClass;
    }

    /**
     * 
     * @param mainClass
     *     The mainClass
     */
    public void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    /**
     * 
     * @return
     *     The minimumLauncherVersion
     */
    public Integer getMinimumLauncherVersion() {
        return minimumLauncherVersion;
    }

    /**
     * 
     * @param minimumLauncherVersion
     *     The minimumLauncherVersion
     */
    public void setMinimumLauncherVersion(Integer minimumLauncherVersion) {
        this.minimumLauncherVersion = minimumLauncherVersion;
    }

    /**
     * 
     * @return
     *     The assets
     */
    public String getAssets() {
        return assets;
    }

    /**
     * 
     * @param assets
     *     The assets
     */
    public void setAssets(String assets) {
        this.assets = assets;
    }

}
