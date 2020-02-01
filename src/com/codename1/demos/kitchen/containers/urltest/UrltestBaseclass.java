package com.codename1.demos.kitchen.containers.urltest;

class UrltestBaseclass {
    private  final String BASE_SOURCE_URL = "https://github.com/erluxman/kitchensinkdemo/blob/master/src/";
    String getSimpleNameUrl(){
        return BASE_SOURCE_URL+this.getClass().getSimpleName();
    }
    String getCannonicalUrl(){
        return BASE_SOURCE_URL+this.getClass().getCanonicalName().replace(".","/")+".java";
    }
}
