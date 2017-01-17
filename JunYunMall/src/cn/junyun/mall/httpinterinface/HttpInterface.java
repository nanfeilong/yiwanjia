package cn.junyun.mall.httpinterinface;



public interface HttpInterface<T> {
    
    /**
     * 
     * @param error
     * @param msg 解析数据的接口
     */
    void parseJsonOnWorkThread(String json ,T result);
   
    
}
