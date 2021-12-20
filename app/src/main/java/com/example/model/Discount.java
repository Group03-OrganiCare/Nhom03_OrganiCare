package com.example.model;

public class Discount {
    private int codeThumb;
    private String codeName;
    private String codeUsage;
    private String getCodeExp;

    public Discount(int codeThumb, String codeName, String codeUsage, String getCodeExp) {
        this.codeThumb = codeThumb;
        this.codeName = codeName;
        this.codeUsage = codeUsage;
        this.getCodeExp = getCodeExp;
    }

    public int getCodeThumb() {
        return codeThumb;
    }

    public void setCodeThumb(int codeThumb) {
        this.codeThumb = codeThumb;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeUsage() {
        return codeUsage;
    }

    public void setCodeUsage(String codeUsage) {
        this.codeUsage = codeUsage;
    }

    public String getGetCodeExp() {
        return getCodeExp;
    }

    public void setGetCodeExp(String getCodeExp) {
        this.getCodeExp = getCodeExp;
    }

}
