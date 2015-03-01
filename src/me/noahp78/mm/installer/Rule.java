
package me.noahp78.mm.installer;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Rule {

    @Expose
    private String action;
    @Expose
    private Os os;

    /**
     * 
     * @return
     *     The action
     */
    public String getAction() {
        return action;
    }

    /**
     * 
     * @param action
     *     The action
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * 
     * @return
     *     The os
     */
    public Os getOs() {
        return os;
    }

    /**
     * 
     * @param os
     *     The os
     */
    public void setOs(Os os) {
        this.os = os;
    }

}
