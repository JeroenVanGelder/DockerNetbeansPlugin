/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hvu.module.codeanalyzer.jvg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jeroenvangelder
 */
public class CommandlineExecutor 
{

    public CommandlineExecutor() {
    }
    
    public String executeCommand(String command)
    {
        String inputString = command;
        String outputString = "";
        outputString = startReadingProcessOutput(inputString);
        return outputString;
    }
    
    private String startReadingProcessOutput(String command)
    {
        String line = "";
        StringBuffer outputStringBuffer = new StringBuffer();
        
        try
        {
            BufferedReader reader = executeProcess(command);
            while ((line = reader.readLine())!=null)
            {
                outputStringBuffer.append(line+"\n");
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return outputStringBuffer.toString();
    }
    
    private BufferedReader executeProcess(String command) throws IOException, InterruptedException
    {
        Process process;
        process = Runtime.getRuntime().exec(command);
        process.waitFor();
        BufferedReader reader = createBufferedReader(process);
            
        return reader;
    }
    
    private BufferedReader createBufferedReader(Process process)
    {
        InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader;
    }
}
