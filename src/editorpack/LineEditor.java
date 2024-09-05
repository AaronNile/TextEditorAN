package editorpack;

import java.util.*;

/**
 *
 *Author: Aaron Nile
 *
 *
 *
 *
 */



public class LineEditor {

    //method to display menu whenever called
    public void displayMenu() {

        System.out.println(
                "Display Menu: m \nLoad File: load fileName appendOption(1-append, 0-new list) \nPrint: p \n Display number of lines: lines \n Display line: line lineNumber \nCount words: words \nDelete line: del lineNumberToDelete \n Append line: a \nInsert line: i lineNumberToInseart \nClear document: cls \nReplace words: rep originalWord newWord \nSave to a file: s fileName \nQuit: quit \n" );

    }

    public static void main(String[] args) {

        // initializing some variables here for calling methods

        LineEditor editor = new LineEditor();

        LineList list = new LineList();

        Scanner scnr = new Scanner(System.in);

        String input = "j";



        // while loop that terminates when the input is quit

        while (input != "quit") {
            editor.displayMenu();


            // splitting input into a list of strings for parsing

            String[] arr = input.split(" ");


            // handling methods with three inputs

            if (arr.length == 3) {


                if (arr[0].equals("rep")) {

                    list.replace(arr[1], arr[2]);

                }

            }

            // handling methods with 2 inputs

            else if(arr.length == 2) {

                if (arr[0].equals("line")) {
                    int index = Integer.parseInt(arr[1]);

                    list.line(index);
                }

                if (arr[0].equals("del")) {
                    int index = Integer.parseInt(arr[1]);
                    list.delete(index);
                }

                if (arr[0].equals("i")) {
                    int index = Integer.parseInt(arr[1]);
                    int val = index;
                    System.out.print("Please enter the text you wish to insert into line " + val + ": ");
                    String newLine = scnr.next();
                    list.addLine(newLine, index);
                }

                if (arr[0].equals("s")) {
                    list.save(arr[1]);
                }

            }

            // handling methods with 1 input

            else if (arr.length == 1) {
                if (arr[0].equals("p")) {
                    list.print();
                }

                if (arr[0].equals("a")) {
                    int val = list.stringList.size() + 1;
                    System.out.print("Line " + val + ": ");
                    String newLine = scnr.nextLine();
                    list.addLine(newLine);

                }

                if (arr[0].equals("cls")) {
                    list.empty();
                }

                if (arr[0].equals("m")) {
                    editor.displayMenu();
                }

                if (arr[0].equals("words")) {
                    int total = list.words();
                    System.out.println("Total words: " + total);
                }

                if (arr[0].equals("lines")) {
                    System.out.println("Number of lines: " + list.lines());
                }


                // although it is possible to handle the load method with the 3 input methods above, I figured it would be clearer in presentation if dealt with as a single input method

                if (arr[0].equals("load")) {
                    System.out.print("Please enter the path of the file you wish to load: ");
                    String newFile = scnr.nextLine();
                    System.out.println();
                    System.out.print("Enter 1 if you wish to append file's contents to editor, enter 0 to clear editor and append file's contents: ");
                    String val1 = scnr.nextLine();
                    if (val1.contains("0") || val1.contains("1")) {
                        int val = Integer.parseInt(val1);
                        boolean append = false;
                        if (val == 1) {
                            append = true;
                        }

                        if (val == 0) {
                            append = false;
                        }

                        list.load(newFile, append);

                        editor.displayMenu();


                    }



                }

                if (arr[0].equals("quit")) {
                    break;
                }


            }



            input = scnr.nextLine();





        }






    }

}
