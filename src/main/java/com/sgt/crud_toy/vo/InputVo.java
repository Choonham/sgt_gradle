package com.sgt.crud_toy.vo;

public class InputVo {
     private int inputID;
     private int inputCode;
     private String inputIp;
     private String keyName;

     private int state;
     private int resultCode;

    public int getInputID() {
        return inputID;
    }

    public void setInputID(int inputID) {
        this.inputID = inputID;
    }

    public int getInputCode() {
        return inputCode;
    }

    public void setInputCode(int inputCode) {
        this.inputCode = inputCode;
    }

    public String getInputIp() {
        return inputIp;
    }

    public void setInputIp(String inputIp) {
        this.inputIp = inputIp;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }
}
