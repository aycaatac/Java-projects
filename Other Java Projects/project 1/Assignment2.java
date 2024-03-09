
/**This program encodes and decodes txt files according to the map
 * 
 * author@ Ayca Candan Atac
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Assignment2 {

    public static void firstStrategy() {
        try {
            FileReader reader = new FileReader("input.txt");
            BufferedReader inputReader = new BufferedReader(reader);
            FileWriter encodedWriter = new FileWriter("encoded.txt", true);
            FileWriter mapWriter = new FileWriter("map.txt", true);
            String oneLine = "";
            ArrayList<String> words = new ArrayList<>();

            while ((oneLine = inputReader.readLine()) != null) {
                int startIndex = 0;
                String word = "";

                for (int k = 0; k < oneLine.length(); k++) {
                    // getting all of the words in the line
                    boolean wordFound = false;
                    if (k == oneLine.length() - 1) {
                        word = oneLine.substring(startIndex);
                        wordFound = true;
                    } else if (oneLine.charAt(k) == ' ') {
                        word = oneLine.substring(startIndex, k);
                        startIndex = k + 1;
                        wordFound = true;
                    }
                    if (words != null && wordFound) {
                        boolean alreadyExists = false;

                        // checks if this word was already added to the list
                        for (int l = 0; l < words.size(); l++) {
                            if (words.get(l).equals(word)) {
                                alreadyExists = true;
                            }
                        }
                        // adds word to the map file
                        if (!alreadyExists) {
                            words.add(word);
                            mapWriter.write(words.indexOf(word) + ": " + word);
                            mapWriter.write("\r\n");
                        }
                        // writes the coded version of the word to output file

                        encodedWriter.write(words.indexOf(word) + " ");

                        wordFound = false;
                    }
                }
                // pass on to the next line when all words in one line has been coded
                encodedWriter.write("\r\n");
            }
            encodedWriter.close();
            mapWriter.close();
            inputReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void randomStrategy() {
        try {
            FileReader reader = new FileReader("input.txt");
            BufferedReader myReader = new BufferedReader(reader);
            FileWriter writer = new FileWriter("encoded.txt", true);
            FileWriter mapWriter = new FileWriter("map.txt", true);
            String oneLine = "";
            ArrayList<String> words = new ArrayList<>();

            while ((oneLine = myReader.readLine()) != null) {
                int startIndex = 0;
                String word = "";

                for (int k = 0; k < oneLine.length(); k++) {
                    for (int y = 0; y < oneLine.length(); y++) {
                        words.add(" ");
                    }
                    // getting all of the words in the line
                    boolean wordFound = false;
                    if (k == oneLine.length() - 1) {
                        word = oneLine.substring(startIndex);
                        wordFound = true;
                    } else if (oneLine.charAt(k) == ' ') {
                        word = oneLine.substring(startIndex, k);
                        startIndex = k + 1;
                        wordFound = true;
                    }
                    if (wordFound) {
                        // checks if this word was already added to the list
                        boolean alreadyExists = false;
                        for (int l = 0; l < words.size(); l++) {
                            if (words.get(l).equals(word)) {
                                alreadyExists = true;
                            }
                        }
                        if (!alreadyExists) {
                            // assigns a unique random integer to the word
                            int myRandom = new Random().nextInt(oneLine.length());
                            while (words != null && words.get(myRandom) != " ") {
                                myRandom = new Random().nextInt(oneLine.length());
                            }
                            words.set(myRandom, word);
                            // adds word to the map file
                            mapWriter.write(words.indexOf(word) + ": " + word);
                            mapWriter.write("\r\n");
                        }

                        // writes the integer to encoded file
                        writer.write(words.indexOf(word) + " ");

                        wordFound = false;
                    }
                }
                writer.write("\r\n");
            }
            writer.close();
            mapWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decoding() {
        String oneLine = "";
        String[] words;
        ArrayList<Integer> integers = new ArrayList<>();
        int number = -1;
        int largest = -1;
        try {
            FileReader reader2 = new FileReader("encoded.txt");
            BufferedReader textReader = new BufferedReader(reader2);

            // stores the integers in the encoded txt file
            while ((oneLine = textReader.readLine()) != null) {
                int startIndex = 0;
                boolean numberFound = false;
                for (int k = 0; k < oneLine.length(); k++) {
                    numberFound = false;
                    if (k == oneLine.length() - 1) {
                        number = Integer.parseInt(oneLine.substring(startIndex).trim());
                        numberFound = true;
                    } else if (oneLine.charAt(k) == ' ') {
                        number = Integer.parseInt(oneLine.substring(startIndex, k).trim());
                        startIndex = k + 1;
                        numberFound = true;
                    }
                    if (numberFound) {
                        integers.add(number);
                    }
                }
                // add -1 to arraylist to show the lind endings
                integers.add(-1);
            }
            textReader.close();
            // find the largest integer and create the array for mapping
            ArrayList<Integer> forSort = new ArrayList<>(integers);
            Collections.sort(forSort);
            largest = forSort.get(forSort.size() - 1);
            words = new String[largest + 1];
            FileReader reader1 = new FileReader("map.txt");
            BufferedReader mapReader = new BufferedReader(reader1);
            String line = "";
            int indexEnd = 0;
            // find and set words to the right indexes
            while ((line = mapReader.readLine()) != null) {
                int index = 0;
                String word = "";
                for (int u = 0; u < line.length(); u++) {
                    if (line.charAt(u) == ':') {
                        index = Integer.parseInt(line.substring(0, u).trim());
                        indexEnd = u + 2;
                    }
                    if (u == line.length() - 1) {
                        word = line.substring(indexEnd);
                    }
                }
                if (!word.equals(" ") && !(index > largest)) {
                    words[index] = word;
                }
            }
            // write the message to decoded txt file
            FileWriter decodedWriter = new FileWriter("decoded.txt", true);
            for (int w = 0; w < integers.size(); w++) {
                if (integers.get(w) == -1) {
                    decodedWriter.write("\r\n");
                } else {
                    decodedWriter.write(words[integers.get(w)] + " ");
                }
            }
            decodedWriter.close();
            mapReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        // try methods here
    }
}