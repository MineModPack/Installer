
package me.noahp78.mm.installer;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Extract {

    @Expose
    private List<String> exclude = new ArrayList<String>();

    /**
     * 
     * @return
     *     The exclude
     */
    public List<String> getExclude() {
        return exclude;
    }

    /**
     * 
     * @param exclude
     *     The exclude
     */
    public void setExclude(List<String> exclude) {
        this.exclude = exclude;
    }

}
