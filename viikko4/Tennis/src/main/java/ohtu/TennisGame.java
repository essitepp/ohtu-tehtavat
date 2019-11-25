package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1Score++;
        else if (playerName.equals(player2Name))
            player2Score++;
    }

    public String getScore() {
        if (player1Score==player2Score) {
            if (player1Score < 4) {
                return scoreAsString(player1Score) + "-All";
            } else {
                return "Deuce";
            }
        } else if (player1Score>=4 || player2Score>=4) {
            if (Math.abs(player1Score-player2Score) > 1) {
                return "Win for " + leaderName();             
            } else {
                return "Advantage " + leaderName();
            }
        }
        else {
            return scoreAsString(player1Score) + "-" + scoreAsString(player2Score);
        }
    }
    
    private String scoreAsString(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                break;
        }
        return "";
    }
    
    private String leaderName() {
        if (player1Score > player2Score) {
            return player1Name;
        } else {
            return player2Name;
        }  
    } 
}