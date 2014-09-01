package com.misabiko.RJ01.Resources.Sprites;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class readFile {
	public ArrayList<String> names = new ArrayList<String>();
	public ArrayList<int[]> data = new ArrayList<int[]>();
	
	public readFile(String path,String extension) {
		switch (extension) {
		case ".xml":
			readXML(path+".xml");
			break;
		case ".txt":
		default:
			readTXT(path+".txt");
			break;
		}
	}

	private void readTXT(String path) {
		try {
			Scanner scan = new Scanner(new BufferedReader(new FileReader(path)));
			
			
			while (scan.hasNext()) {
				int[] smallArray = new int[4];
				int i = 0;
				while (i != smallArray.length) {
					while (!scan.hasNextInt()) {
						scan.next();
					}
					smallArray[i] = scan.nextInt();
					i++;
				}
				data.add(smallArray);
				i = 0;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void readXML(String path) {
		try {
			 
			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
		 
			NodeList nList = doc.getElementsByTagName("SubTexture");
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
		 
				Node nNode = nList.item(temp);
		 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;
					
					int[] smallArray = new int[4];
					
					smallArray[0] = Integer.parseInt(eElement.getAttribute("x"));
					smallArray[1] = Integer.parseInt(eElement.getAttribute("y"));
					smallArray[2] = Integer.parseInt(eElement.getAttribute("width"));
					smallArray[3] = Integer.parseInt(eElement.getAttribute("height"));
					
					data.add(smallArray);
					names.add(eElement.getAttribute("name"));
		 
				}
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
	}
}
