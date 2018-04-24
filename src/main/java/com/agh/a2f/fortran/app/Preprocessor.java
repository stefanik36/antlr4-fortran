package com.agh.a2f.fortran.app;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Preprocessor {
    public static ArrayList<String> run(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        String str = reader.readLine();
        ArrayList<String> lineArray = new ArrayList<String>();

        for (; ; ) {
            if (str == null) break;

            String tokens[] = str.split(" ");
            if (str.isEmpty() || tokens[0].equals("c")) {
                // do nothing for blank line or comment line
            } else {
                String sections[] = str.split("\'");
                StringBuilder temp = new StringBuilder(sections[0].toLowerCase());
                //System.out.println("Section 0: " + sections[0]);
                for (int i = 1; i < sections.length; i++) {
                    //System.out.println("Section " + i + ": " + sections[i]);
                    if (i % 2 == 1) { //do not change case of statements in quotes
                        temp.append("\'");
                        temp.append(sections[i]);
                        temp.append("\'");
                    } else {
                        temp.append(sections[i].toLowerCase());
                    }
                }
                lineArray.add(temp.toString());
            }

            str = reader.readLine();
        }

        for (String i : lineArray) {
            System.out.println(i);
        }
        reader.close();
        return lineArray;
    }
}
