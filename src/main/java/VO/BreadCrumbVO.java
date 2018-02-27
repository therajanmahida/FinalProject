package VO;

import java.util.HashMap;

public class BreadCrumbVO {
    HashMap<String,String> _name_url;
    public BreadCrumbVO(){
        this._name_url = new HashMap<>();
    }
    public void addData(String _page_name,String _url_name_relative){
        this._name_url.put(_page_name,_url_name_relative);
    }
    public HashMap<String, String> get_name_url() {
        return _name_url;
    }
}
