package org.acme;

public class GettingStartedSpec {

    private String value;
    private String key;

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() throws Exception {
        try {
            return value;

        } catch (Exception e) {
            throw new Exception("key not found");
        }
    }

    public void setValue(String value) {
        this.value = value;
    }

}
