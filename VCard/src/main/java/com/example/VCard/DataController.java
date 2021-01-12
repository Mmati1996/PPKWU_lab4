package com.example.VCard;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


public class DataController {

    @RequestMapping(path = "/search")
    public ModelAndView panoramaFirmSearcher(@RequestParam String name, @RequestParam String city,@RequestParam HttpServletResponse response){
        String url = "https://panoramafirm.pl/szukaj?k="+name+"&l="+city;
        StringBuilder stringBuilder = new StringBuilder();

        org.jsoup.nodes.Document doc = null;


        try{
            doc= Jsoup.connect(url).get();
        }catch(Exception e){

        }

        Elements els = doc.select("script");
        String toReturn="";
        ArrayList<Company> companies = new ArrayList<Company>();
        Gson gson = new Gson();
        StringBuffer str = new StringBuffer();
        for (Element el : els){
            if (el.attr("type").equals("application/ld+json")) {
                str.append(el.select("a").get(0).attr("tittle"));
                companies.add(gson.fromJson(el.data(),Company.class));
            }
        }



        toReturn = str.toString();
        return new ModelAndView("view","",toReturn);
        //return new ResponseEntity<String>( toReturn, HttpStatus.OK);
    }
}
