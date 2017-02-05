package com.appello.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.appello.aeromobili.Deposito;

public class FileAeromobile {
	static public void checkFile (File file, Deposito deposito) throws IOException, ClassNotFoundException{
		if (!file.exists()){
			file.createNewFile();
			writeAeromobili(file, deposito);
		}
	}
	
	static public void writeAeromobili(File file, Deposito deposito) throws FileNotFoundException, IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(deposito);
		
		oos.close();
	}
	
	static public Deposito readAeromobili(File file) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Deposito tmp = (Deposito) ois.readObject();
		ois.close();
		
		return tmp;
	}
}
