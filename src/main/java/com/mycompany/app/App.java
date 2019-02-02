package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App {
	
	public static String ortalamaHesapla(ArrayList<Integer> vizeler, ArrayList<Integer> finaller, ArrayList<String> ogrenciler, int ogrencisira){
		if(vizeler.isEmpty() && finaller.isEmpty() && ogrenciler.isEmpty()) {
			return "liste bos";
		}
		
		if(vizeler.size()!=finaller.size()) {
			return "eksik sinav girilmis";
		}
		if(vizeler.size()!=ogrenciler.size()) {
			return "ogrenci bilgisi eksik";
		}
		
		if(ogrencisira>ogrenciler.size()) {
			return "girilen sirada ogrenci mevcut degil.";
		}
		
		double ortalama = (vizeler.get(ogrencisira) + finaller.get(ogrencisira)) / 2;
		String cevap = ogrenciler.get(ogrencisira) + " adli ogrencinin ortalamasi: " + ortalama;
		return cevap;
	}
	

	public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {

		  String input1 = req.queryParams("input1");
		  
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> input1List = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            input1List.add(value);
          }
          System.out.println(input1List);


          String input2 = req.queryParams("input2");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc2.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> input2List = new java.util.ArrayList<>();
          while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            input2List.add(value);
          }
          System.out.println(input2List);

          String input3 = req.queryParams("input3");
          java.util.Scanner sc3 = new java.util.Scanner(input3);
          sc3.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> input3List = new java.util.ArrayList<>();
          while (sc3.hasNext())
          {
            String value = sc3.next().replaceAll("\\s","");
            input3List.add(value);
          }
          System.out.println(input3List);

          String input4 = req.queryParams("input4");
          java.util.Scanner sc4 = new java.util.Scanner(input4);
          sc4.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> input4List = new java.util.ArrayList<>(1);
          
            int value = Integer.parseInt(sc4.next().replaceAll("\\s",""));
            input4List.add(value);
          
          System.out.println(input4List);

          String result = ortalamaHesapla(input1List,input2List,input3List,input4List.get(0));
         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed the average yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }


}
