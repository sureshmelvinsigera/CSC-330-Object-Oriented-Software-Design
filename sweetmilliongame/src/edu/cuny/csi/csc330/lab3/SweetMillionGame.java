package edu.cuny.csi.csc330.lab3;

/**
 * Course: 330-E001(12968)
 * Filename : SweetMillion.java
 * Purpose: This program generate Sweet Million ticket to the user.
 * By default program generates a one game, unless user specify the game size.
 *
 * @author Suresh Melvin Sigera
 * @date 09/28/2017
 */

import edu.cuny.csi.csc330.lab3.lib.Randomizer;
import java.util.*;

public class SweetMillionGame {

    public final static int DEFAULT_GAME_COUNT = 1;
    private final static String GAME_NAME = "Sweet Million";
    private final static int SELECTION_POOL_SIZE = 40;
    private final static int SELECTION_COUNT = 6;

    private Randomizer randomizer;

    private String sellerName;
    private String gameName;

    private int gameCount = DEFAULT_GAME_COUNT;
    private int selectionPoolSize;
    private int selectionCount;

    /**
     * default constructor
     *
     * @param gameCount
     */
    public SweetMillionGame(int gameCount) {
        init(gameCount);
    }

    /**
     * init()
     */
    private void init() {
        randomizer = new Randomizer();
        this.loadGameSettings(GAME_NAME, SELECTION_COUNT, SELECTION_POOL_SIZE);
    }

    /**
     * @param gameCount
     */
    private void init(int gameCount) {
        init();
        this.gameCount = gameCount;

    }

    /**
     * @param gameName
     * @param selectionCount
     * @param selectionPooSize
     */
    protected void loadGameSettings(String gameName, int selectionCount, int selectionPooSize) {
        this.gameName = gameName;
        this.selectionCount = selectionCount;
        this.selectionPoolSize = selectionPooSize;
    }

    /**
     * displayTicket()
     */
    public void displayTicket() {
        displayHeading();   //print ticket heading

        /**
         * generate random numbers
         */
        for (int i = 0; i < gameCount; ++i) {
            int random[] = generateNumbers();
            runGame(i + 1, random);
        }

        displayFooter(); //display ticket footer
    }

    /**
     * displayHeading()
     */
    protected void displayHeading() {
        System.out.printf("---------------------------------\n");
        System.out.printf("--------  %s --------\n", gameName);
        System.out.println("  " + new Date() + "\n");
    }

    /**
     * displayFooter()
     */
    protected void displayFooter() {
        System.out.printf("\n----- (c) %s -----\n", sellerName);
        System.out.printf("---------------------------------\n");
    }

    /**
     * @param index
     * @param randomNumbers
     */
    protected void runGame(int index, int[] randomNumbers) {
        if (index != 0)
            System.out.printf(" (%2d)  ", index);
        for (int i = 0; i < randomNumbers.length; ++i) {
            System.out.printf("%02d ", randomNumbers[i]);
        }
        System.out.printf("\n");
    }

    /**
     * @return
     */
    protected int[] generateNumbers() {
        int randomNumbers[] = new int[selectionCount];
        int i = 0;
        do {
            randomNumbers[i] = this.randomizer.generateInt(1, selectionPoolSize);
            ++i;
        } while (i < randomNumbers.length);
        Arrays.sort(randomNumbers); //sort the random numbers
        return randomNumbers;
    }

    /**
     * @param seller
     */
    public void setSeller(String seller) {
        if (seller == null || seller.length() == 0) {
            //we don't have a seller name, so we set the name to Default Seller
            this.sellerName = "Default Seller";
        } else {
            this.sellerName = seller;
            //this.selectionCount = selectionCount;
            this.selectionPoolSize = SELECTION_POOL_SIZE;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int numberOfGames = SweetMillionGame.DEFAULT_GAME_COUNT;

        if (args.length > 0) {
            numberOfGames = Integer.parseInt(args[0]);
        }

        SweetMillionGame game = new SweetMillionGame(numberOfGames);

        game.setSeller("");
        game.displayTicket();
    }
}