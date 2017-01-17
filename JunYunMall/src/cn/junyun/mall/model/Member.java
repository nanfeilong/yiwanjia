package cn.junyun.mall.model;



/*
 * 用户实体类 测试
 */


/**
 * {
    "resultcode": "200",
    "reason": "Return Successd!",
    "result": {
        "province": "陕西",
        "city": "西安",
        "areacode": "029",
        "zip": "710000",
        "company": "中国移动",
        "card": "移动神州行卡"
    },
    "error_code": 0
}
 * @author wang
 * @date 2016年6月28日
 */

public class Member  extends Entity  {
    
    /**
     * 
     */
    private String province;//":"浙江",
    private String city;//":"杭州",
    private String areacode;//":"0571",
    private String zip;//":"310000",
    private String company;//":"中国移动",
    private String card;//":"移动动感地带卡"
    
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getAreacode() {
        return areacode;
    }
    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getCard() {
        return card;
    }
    public void setCard(String card) {
        this.card = card;
    }
    
    
}
