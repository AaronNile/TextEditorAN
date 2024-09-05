package editorpack;

import java.util.*;
import java.io.*;
/**
 *
 * author: Aaron Nile
 *
 *
 * LineList class is a linked-list that represents the contents of a document
 *
 */


public class LineList {

    private Node head;

    public LineList(){   //constructor
        head=null;


    }


    public LinkedList <Node> stringList = new LinkedList<Node>();

    public void empty(){
        // using arraylist's clear method as a simple solution to empty a file
        stringList.clear();

        // delete all lines in the editor
    }


    public void load(String fileName, boolean append){

        if (append) {

            File file = new File(fileName);
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    Node node = new Node(line);
                    stringList.add(node);
                }

                reader.close();

            } catch (IOException e) {

                System.out.println("Invalid file input");
                System.out.println();
            }


        }




        // append is true, read lines and add to existing list,
        // otherwise, create new list.
        // Each line is stored in a Node.

    }

    public void save(String fileName){


        File file = new File(fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < stringList.size(); ++i ) {
                writer.write(stringList.get(i).getLine());
                writer.newLine();

            }

            writer.close();


        } catch (IOException e) {

            e.printStackTrace();
        }
        // Saves all lines represented with Nodes to a file.
        // Each line (Node) occupies a line in the saved file.


    }

    public void addLine(String line){
        Node node = new Node(line);
        stringList.add(node);
    }

    public void addLine(String line, int n){

        int index = n - 1;
        if (index > stringList.size()) {
            Node node = new Node(line);
            stringList.add(node);

        }

        else {

            String newLine = stringList.get(index).getLine() + line;
            stringList.get(index).setLine(newLine);
        }
        //insert new line to nth line, if n > total number of line,
        //append to the end of the list.
    }

    public int words(){

        int counter = 0;

        for (int i = 0; i < stringList.size(); i++) {
            String curLine = stringList.get(i).getLine();
            String finLine = curLine.replaceAll(" ", "*");
            String[] arr = finLine.split("[\\t,;.?!-@\'\"*]");
            ArrayList <String> arr2 = new ArrayList<String> (Arrays.asList(arr));
            arr2.removeAll(Arrays.asList("", null));
            counter = counter + arr2.size();


        }

        return counter;
        // count number of words, word may be separated with
        // \t,;.?!-@spaces ' * and "

    }

    public int lines(){

        int numLines = stringList.size();
        return numLines;


        // count number of lines, which is the same as the number of
        // nodes in the list.
    }

    public void delete(int n){
        if (n > -1 && n < stringList.size()) {
            stringList.remove(n);
        }
        //delete nth line if exists. Otherwise do nothing.
    }

    public String toString(){

        String finString = "";

        for (int i = 0; i < stringList.size(); ++i) {
            finString += stringList.get(i).getLine();

            if (i != stringList.size()-1) {
                finString += "\n";
            }




        }
        return finString;
        // Return all lines represented by Nodes in the list. All lines
        // are in the same order as their corresponding nodes in the list.
        // All lines are separated with \n.

    }

    public void print(){



        for (int i = 0; i < stringList.size(); ++i) {
            String line = stringList.get(i).getLine();
            int counter = i + 1;
            System.out.print(counter + ". " + line);

            if (i != stringList.size() - 1) {
                System.out.println();
            }

        }


        // Print each line. Each line is proceeded with its corresponding line
        // numbers. Please refer to sample output.

    }

    public void replace(String s1, String s2){

        for (int i = 0; i < stringList.size(); ++i) {
            stringList.get(i).getLine().replaceAll(s1, s2);
        }
        // Replace all occurrences of s1 with s2.

    }

    public void line(int n){

        if (n < 0 || n >= (stringList.size()) ) {
            System.out.println("Line " + n + " does not exist.");
        }

        else {
            System.out.println(stringList.get(n).getLine());
        }
        // Print nth line in the document. (The nth node in the list)
        // If nth line does not exists, prints Line n does not exist.

    }



}


