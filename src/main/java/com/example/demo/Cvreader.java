package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Cvreader
{
	String haslo;
	String katalog;
	ArrayList<String> lista_znalezionych = new ArrayList<String>();
	
	void wczytajKatalog(String _katalog)
	{
		katalog = _katalog;
	}
	
	ArrayList<String> stringSplitter2(String odebrany)
	{
		ArrayList<String> znalezione = new ArrayList<String>();
		String temp = new String();
		for (int i=0; i<odebrany.length(); i++)
		{
			if (odebrany.charAt(i) == '"' && odebrany.charAt(i-1) == ':')
			{
				int j=i+1;
				while (odebrany.charAt(j) != '"')
				{
					temp += odebrany.charAt(j);
					j++;
				}
				znalezione.add(temp);
				temp = new String();
			}
		}
		return znalezione;
	}
	
	ArrayList<String> stringSplitter(String odebrany)
	{
		ArrayList<String> temp = new ArrayList<String>();
		String[] rozdzielone_slowa = odebrany.split(",language[{}]\"");
		for (String cos: rozdzielone_slowa)
		{
			temp.add(cos);
		}
		return temp;
	}
	
	void wczytajCV(String katalog, ArrayList<String> hasla)
	{
		File folder = new File(katalog);
		Scanner odczyt;
		String odczytane_slowo;
		for (final File fileEntry : folder.listFiles())
		{
			if (fileEntry.isFile())
			{
				try {
					odczyt = new Scanner(new File(fileEntry.getAbsolutePath()));
					while (odczyt.hasNext())
					{
						odczytane_slowo = odczyt.next().toLowerCase();
						for (int i=0; i<hasla.size(); i++)
						{
							if (odczytane_slowo.equals(hasla.get(i).toLowerCase()))
							{
								lista_znalezionych.add("http://127.0.0.1:8887/"+fileEntry.getName());
							}
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}
	ArrayList<ObjecttoJSON> sendJSON(){
		ArrayList<ObjecttoJSON> newList = new ArrayList<ObjecttoJSON>();
		for(String cos : this.lista_znalezionych) {
			ObjecttoJSON ob = new ObjecttoJSON(cos);
			newList.add(ob);
		}
		return newList;
	}
	String jsoninString (ArrayList<ObjecttoJSON> list) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		
		//for(ObjecttoJSON cos : list) {
		String 	tab = mapper.writeValueAsString(list);
		//}
		return tab;
		
	}	
	
	void usun_duplikaty()
	{
		ArrayList<String> bez_duplikatow = new ArrayList<String>();
		for (String cos: lista_znalezionych)
		{
			if (!bez_duplikatow.contains(cos))
			{
				bez_duplikatow.add(cos);
			}
		}
		lista_znalezionych = bez_duplikatow;
	}
	
	
}