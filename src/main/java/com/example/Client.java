/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.net.MalformedURLException;
import java.io.*; 
import java.net.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author danie
 */
public class Client extends Thread{
    
    public static void main(String[] args){
        for(int i=0;i<20;i++){
            Thread hilo = new Client();
            hilo.start();
        }    
    }
    
    @Override
    public void run(){
        try{
            System.out.println("PATH = '/'");
            resultado("/");
            System.out.println("PATH = '/hello'");
            resultado("/hello");            
            System.out.println("PATH = '/db'");
            resultado("/db");                        
        } catch(MalformedURLException e){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
            
        }
    
    }
    
    public void resultado(String tipo) throws MalformedURLException{
        URL result = new URL("https://aremparcial2.herokuapp.com"+tipo);
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(result.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }            
    }
    
}
