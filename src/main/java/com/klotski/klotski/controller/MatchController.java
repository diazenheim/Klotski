package com.klotski.klotski.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.klotski.klotski.model.Match;
import com.klotski.klotski.model.Move;

import javafx.scene.control.Button;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MatchController {


    public static Match match;
    //files location
    public static final String matchFilesLocation = System.getProperty("user.dir") + System.getProperty("file.separator") +
            "src" + System.getProperty("file.separator") +
            "main" + System.getProperty("file.separator") +
            "resources" + System.getProperty("file.separator") +
            "match" + System.getProperty("file.separator");
    //configurations file location
    public static final String configurationLocation = matchFilesLocation +
            "configuration" + System.getProperty("file.separator");
    //saved matches file location
    public static final String savedLocation = matchFilesLocation +
            "saved" + System.getProperty("file.separator");


    public static void saveMatch() throws Exception {
        match = match.getMatch();
        String matchName = match.getMatchName();

        String matchJsonString = getJsonString(match);

        try {
            writeMatchToFile(matchName, matchJsonString);

            //set property Saved to True on the match
            match.setSaved(true);

            klotskiLog("Match saved: " + matchName + "\n");

        } catch (IOException ex) {
            klotskiLog("Error while saving the match " + matchName + " + " + ex.toString());
        }
    }


    public static void loadMatch(String matchName, String loadType) throws Exception {
        String resourceLocation = System.getProperty("file.separator") +
                "match" + System.getProperty("file.separator") +
                loadType + System.getProperty("file.separator");
        String savedMatch = getFileContent(resourceLocation + matchName);
        if (savedMatch != null) {
            Match matchObject = getJsonObject(savedMatch);
            match = matchObject;
            //MainController.setCounter();
            ArrayList<Move> moves = match.getMovesList();
            PieceController.counter = match.getCurrentIndex();
            if (loadType == "configuration") {
                match.setConfiguration(matchName);
                klotskiLog("matchname: " + match.getConfiguration());
            }
            //iterates on all the moves
            for (int i = 0; i < moves.size(); i++) {
                Move move = moves.get(i);
                int pieceIndex = move.getPieceIndex();
                Button piecebutton = PieceController.getPieceButton(pieceIndex);

                double newX = move.getNewX();
                double newY = move.getNewY();
                piecebutton.setLayoutX(newX);
                piecebutton.setLayoutY(newY);

            }
            klotskiLog(savedMatch);

            //    setConfiguration(savedMatch);

            klotskiLog("\nMoves loaded successfully from file " + savedLocation);
        }
    }

    //utility to convert Object to a String in json format (method found online)
    private static String getJsonString(Object o) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(o);

        //klotskiLog(jsonString);

        return jsonString;
    }

    //utility to convert a String in json format to an object (method found online)
    private static Match getJsonObject(String stringObject) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Match match = mapper.readValue(stringObject, Match.class);
        return match;
    }

    //utility method to write content on a file
    private static void writeMatchToFile(String filename, String fileContent) throws IOException {
        try {
            File file = getFileObject(savedLocation + filename);

            FileWriter writer;
            writer = new FileWriter(file.getAbsoluteFile(), false);

            // Writes text to a character-output stream (method found online)
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(fileContent);
            bufferWriter.flush();
            bufferWriter.close();
        } catch (IOException ex){
            throw new IOException("Error while writing file: " + ex.toString());
        }

        klotskiLog("The file has been saved: " + filename);
    }

    //utility method to create file
    private static File getFileObject(String filePath) throws IOException {

        File file = new File(filePath);

        // Check if the file already exists
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    //utility method to get the content of a File from a given path
    private static String getFileContent(String filePath) throws IOException, Exception {
        try {
            klotskiLog(filePath);
            InputStream inputStream = MainController.class.getResourceAsStream(filePath);
            Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        }
        catch (Exception e){
            filePath = filePath.replace("\\", "/"); //let modify the path to work in a windows system
        }
        klotskiLog(filePath);
        //the following method has been found online to convert a file into string
        InputStream inputStream = MainController.class.getResourceAsStream(filePath);
        Scanner s = new Scanner(inputStream).useDelimiter(System.getProperty("file.separator") + System.getProperty("file.separator")+"A");

        String loadedFile = s.hasNext() ? s.next() : "";

        return loadedFile;
    }

    private static void setConfiguration(String configuration){
        if(configuration == "1") {

        }
    }

    private static void klotskiLog(String string) {
        System.out.println(string);
    }
}
