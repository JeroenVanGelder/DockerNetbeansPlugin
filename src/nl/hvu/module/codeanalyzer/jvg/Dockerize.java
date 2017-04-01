/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hvu.module.codeanalyzer.jvg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Tools",
        id = "nl.hvu.module.codeanalyzer.jvg.GetSomeAction"
)
@ActionRegistration(
        displayName = "#CTL_Dockerize"
)
@ActionReference(path = "Menu/Tools", position = 0)
@Messages("CTL_Dockerize=Dockerize")

public final class Dockerize implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        CommandlineExecutor commandlineExecutor = new CommandlineExecutor();
        String outputString;
        
        //Create the Dockerfile
        String inputString = "echo 'FROM frekele/java:jdk8' > Dockerfile";
        outputString = commandlineExecutor.executeCommand(inputString);
        
        inputString = "echo 'CMD mkdir /home/project' >> Dockerfile";
        outputString = commandlineExecutor.executeCommand(inputString);
        
        inputString = "echo 'ADD / /home/project' >> Dockerfile";
        outputString = commandlineExecutor.executeCommand(inputString);
        
        //Build Dockerfile
        inputString = "docker build -t javaproject:local .";
        outputString = commandlineExecutor.executeCommand(inputString);
        System.out.println("output: "+ outputString);

    }
    
}
