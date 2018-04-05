package VO;

import java.util.HashMap;

public class BreadCrumbVO {
    String value;
    String url;

    public BreadCrumbVO(String _value, String _url) {
        this.value = _value;
        this.url = _url;
    }

    public String getvalue() {
        return value;
    }

    public void setvalue(String _value) {
        this.value = _value;
    }

    public String geturl() {
        return url;
    }

    public void set_url(String _url) {
        this.url = _url;
    }
}
