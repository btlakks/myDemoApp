package com.mycompany.app;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Arrays;
//import junit.framework.TestSuite;


/**
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

**/

public class AppTest extends TestCase {
	


	public void testFound() {
	      ArrayList<Integer> v = new ArrayList<>(Arrays.asList(55, 88, 63, 44));
	      ArrayList<Integer> f = new ArrayList<>(Arrays.asList(91, 82, 39, 56));
	      ArrayList<String> o = new ArrayList<>(Arrays.asList("ali", "ayse", "fatma", "merve"));
          String k = App.ortalamaHesapla(v,f,o,1);
	      
			assertTrue(k.equals("ayse adli ogrencinin ortalamasi: 85.0") );
	    }

	
	    public void testNumberNotEqual() {
	    	ArrayList<Integer> v = new ArrayList<>(Arrays.asList(55, 88, 63, 44));
		      ArrayList<Integer> f = new ArrayList<>(Arrays.asList(91, 82, 39));
		      ArrayList<String> o = new ArrayList<>(Arrays.asList("ali", "ayse", "fatma", "merve"));
              String k = App.ortalamaHesapla(v,f,o,1) ;
		      
		      assertTrue(k.equals("eksik sinav girilmis"));
	    }
	
	    public void testEmptyArray() {
		ArrayList<Integer> v = new ArrayList<>();
	      ArrayList<Integer> f = new ArrayList<>();
	      ArrayList<String> o = new ArrayList<>();
          String k = App.ortalamaHesapla(v,f,o,0) ;
	      assertTrue(k.equals("liste bos"));

	    }
	
	
    public void testStudentNotAvailable() {
    	ArrayList<Integer> v = new ArrayList<>(Arrays.asList(55, 88, 63, 44));
	      ArrayList<Integer> f = new ArrayList<>(Arrays.asList(91, 82, 39, 89));
	      ArrayList<String> o = new ArrayList<>(Arrays.asList("ali", "ayse", "fatma", "merve"));
          String k = App.ortalamaHesapla(v,f,o,6) ;
	      assertTrue(k.equals("girilen sirada ogrenci mevcut degil."));
	     
    }
	

	public void testNotEnoughStudent() {
	      ArrayList<Integer> v = new ArrayList<>(Arrays.asList(55, 88, 63, 44));
	      ArrayList<Integer> f = new ArrayList<>(Arrays.asList(91, 82, 39, 56));
	      ArrayList<String> o = new ArrayList<>(Arrays.asList("ali", "ayse", "fatma"));
          String k = App.ortalamaHesapla(v,f,o,1) ;
	      assertTrue(k.equals("ogrenci bilgisi eksik"));
	    }
	    
	   
}
