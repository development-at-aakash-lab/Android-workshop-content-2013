/**
 * @author:  Mihir Gokani
 * @created: 01-Mar-2013
 */
package in.mihirgokani.aworkshop.animationdemo;

/**
 * @author Mihir Gokani
 * @created 01-Mar-2013 4:24:17 PM
 */
public class MyObject {
    private float propValue;

    /**
     * Constructor for MyObject
     */
    public MyObject() {
        this.propValue = 0f;
    }

    public float getProp() {
        return this.propValue;
    }

    public void setProp(float value) {
        this.propValue = value;
    }
}
