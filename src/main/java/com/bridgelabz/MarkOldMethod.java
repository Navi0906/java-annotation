package com.bridgelabz;

class LegacyAPI{
    @Deprecated
    public void oldFeature(){
        System.out.println("This is old feature");
    }

    public void newFeature(){
        System.out.println("This is new feature");
    }
}

public class MarkOldMethod {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}
