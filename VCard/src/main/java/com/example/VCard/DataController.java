package com.example.VCard;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;


public class DataController {

    @RequestMapping(path = "/search")
    public ResponseEntity<String> panoramaFirmSearcher(@RequestParam String name, HttpServletResponse response){
        String url = "https://panoramafirm.pl/szukaj?k="+name+"&l";

        org.jsoup.nodes.Document doc = null;


        try{
            doc= Jsoup.connect(url).get();
        }catch(Exception e){

        }

        Elements els = doc.select("script");
        String toReturn="";

        StringBuffer str = new StringBuffer();
        for (Element el : els){
            if (el.attr("type").equals("application/ld+json")) {
                str.append(el.select("a").get(0).attr("tittle"));
                toReturn = str.toString();
                return new ResponseEntity<String>( toReturn, HttpStatus.OK);

            }
        }

        toReturn = str.toString();
        return new ResponseEntity<String>( toReturn, HttpStatus.OK);
    }
}