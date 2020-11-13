package com.publicwelfare.entity.common;

import lombok.NoArgsConstructor;

/**
 * @author zepeng.lin
 * @date 2020/9/25
 * CommonResult 用于向前端返回统一格式的json数据串，便于管理。
 * 此类定义为泛型，可传任何自定义的对象类型的数据
 */
@NoArgsConstructor
public class CommonResult<T>{

    /**
     * 返回状态码
     * 状态码皆在表示从后端返回数据的状态，比如返回成功，返回失败等的状态码
     */
    private Integer resultCode;

    /**
     * 返回状态说明
     * 状态说明皆在表示对返回的状态码进行文字上的说明
     */
    private String resultMsg;

    /**
     * 数据
     * 此参数可以保存任何由后端人员自定义的对象类型的数据。
     * 其中包括object,list<>,map<>，stream等等
     */
    private T data;

    /**
     * 无数据构造函数
     * 仅向前端返回状态码和状态信息
     * @param resultCode 状态码
     * @param resultMsg 状态信息
     */
    public CommonResult(Integer resultCode,String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.data = null;
    }

    /**
     * 有数据构造函数
     * 向前端返回状态码和信息时，同时带上要传输的数据串或流
     * @param resultCode 状态码
     * @param resultMsg 状态信息
     * @param data 数据
     */
    public CommonResult(Integer resultCode,String resultMsg,T data) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.data = data;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "resultCode=" + resultCode +
                ", resultMsg='" + resultMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
