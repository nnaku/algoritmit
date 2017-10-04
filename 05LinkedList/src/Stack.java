/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;


public class Stack {
    
    private LinkedList<String> list;
   	public Stack() {
		list = new LinkedList<String>();
	}

	//  Asetetaan data pinon huipulle
	public void push(String aData) { // a = argument, muodolliset parametrit nimetään näin
		list.push(aData);

	}
	// poistetaan alkio pinon huipulta, jos pinossa ei alkioita palautetaan null
	public String pop() {
            return list.pop();
            
	}
	// palautetaan pinottujen alkioiden lukumäärä
	public int getSize() {
            return list.size();
	}
	// listataan pinon sisältö muuttamatta pinoa
	public void printItems() {
            System.out.println(list);

	}
}
