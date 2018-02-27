package VO;

import java.util.HashMap;

public class BreadCrumbVO {
    String _value;
    String _url;

    public BreadCrumbVO(String _value, String _url) {
        this._value = _value;
        this._url = _url;
    }

    public String get_value() {
        return _value;
    }

    public void set_value(String _value) {
        this._value = _value;
    }

    public String get_url() {
        return _url;
    }

    public void set_url(String _url) {
        this._url = _url;
    }
}
