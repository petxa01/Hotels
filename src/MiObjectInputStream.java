
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @file NewClass.java
 * @author Gorka
 * @email petxa01@gmail.com
 * @date 16-mar-2017
 * @Time 11:15:29
 * @encoding UTF-8
 * @projectlicense Expression projectLicense is undefined on line 17, column 22 in Templates/Classes/Class.java.
 * 
 */
public class MiObjectInputStream extends ObjectInputStream{
    public MiObjectInputStream(ObjectInputStream out) throws IOException
    {
        super(out);
    }
    protected MiObjectInputStream() throws IOException, SecurityException
    {
        super();
    }
    public MiObjectInputStream(InputStream inputStream) throws IOException {
		super(inputStream);
	}
	protected void readStreamHeader() throws IOException
    {
    }
    
}

