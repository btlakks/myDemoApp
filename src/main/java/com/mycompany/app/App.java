package com.mycompany.app;
import java.util.ArrayList;
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
	


}
