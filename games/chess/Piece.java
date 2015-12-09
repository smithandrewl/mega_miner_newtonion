/** 
 * Generated by Creer at 09:33PM on December 09, 2015 UTC, git hash: '1b69e788060071d644dd7b8745dca107577844e1'
 * A chess piece
 */
package games.chess;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.json.JSONObject;

import joueur.Client;
import joueur.BaseGame;
import joueur.BaseGameObject;
// <<-- Creer-Merge: imports -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
// you can add addtional import(s) here
// <<-- /Creer-Merge: imports -->>
@SuppressWarnings("unused")

/**
 * A chess piece
 */
public class Piece extends GameObject {
    /**
     * When the piece has been captured (removed from the board) this is true. Otherwise false.
     */
    public boolean captured;

    /**
     * The file (y) coordinate of the checker represented as a number [1-8].
     */
    public int file;

    /**
     * If the piece has moved from its starting position.
     */
    public boolean hasMoved;

    /**
     * The player that controls this chess Piece.
     */
    public Player owner;

    /**
     * The rank (x) coordinate of the checker represented as a letter [a-h].
     */
    public String rank;

    /**
     * The type of chess piece this is, either: 'King', 'Queen', 'Knight', 'Rook', 'Bishop', or 'Pawn'.
     */
    public String type;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add addtional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of Piece. Used during game initialization, do not call directly.
     */
    public Piece() {
        super();
    }

    /**
     * Defaults the value for the optional arg 'promotionType' to '""'
     *
     * @see Piece#move(String, int, String)
     */
    public String move(String rank, int file) {
        return this.move(rank, file, "");
    }

    /**
     * Moves the piece from its current location to the given rank and file.
     *
     * @param   rank  The rank (x) coordinate to move to. Must be [a-h].
     * @param   file  The file (y) coordinate to move to. Must be [1-8].
     * @param   promotionType  If this is a Pawn moving to the end of the board then this parameter is what to promote it to.
     * @return The standard algebraic notation (SAN) representation of the move if successful, empty string otherwise. In addition if you fail your move you lose.
     */
    public String move(String rank, int file, String promotionType) {
        JSONObject args = new JSONObject();
        args.put("rank", Client.getInstance().gameManager.serializeSafe(rank));
        args.put("file", Client.getInstance().gameManager.serializeSafe(file));
        args.put("promotionType", Client.getInstance().gameManager.serializeSafe(promotionType));
        return (String)this.runOnServer("move", args);
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add addtional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
