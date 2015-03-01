
package me.noahp78.mm.installer;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Library {

    @Expose
    private String name;
    @Expose
    private String url;
    @Expose
    private Natives natives;
    @Expose
    private Extract extract;
    @Expose
    private List<Rule> rules = new ArrayList<Rule>();

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The natives
     */
    public Natives getNatives() {
        return natives;
    }

    /**
     * 
     * @param natives
     *     The natives
     */
    public void setNatives(Natives natives) {
        this.natives = natives;
    }

    /**
     * 
     * @return
     *     The extract
     */
    public Extract getExtract() {
        return extract;
    }

    /**
     * 
     * @param extract
     *     The extract
     */
    public void setExtract(Extract extract) {
        this.extract = extract;
    }

    /**
     * 
     * @return
     *     The rules
     */
    public List<Rule> getRules() {
        return rules;
    }

    /**
     * 
     * @param rules
     *     The rules
     */
    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

}
