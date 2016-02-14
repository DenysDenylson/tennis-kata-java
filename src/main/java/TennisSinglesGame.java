
public class TennisSinglesGame implements TennisGame
{
    public int pointPlayer1 = 0;
    public int pointPlayer2 = 0;
    
    public String answerPlayer1 = "";
    public String answerPlayer2 = "";
    private String namePlayer1;
    private String namePlayer2;

    public TennisSinglesGame(String player1Name, String player2Name) {
        this.namePlayer1 = player1Name;
        this.namePlayer2 = player2Name;
    }
    
 

    public String getScore(){
        String score = "";
        
        score = tiedGame();
        
        if((pointPlayer1!=pointPlayer2 && pointPlayer1 < 4 && pointPlayer2 < 4)){
            answerPlayer1 = ConvertPointToLiteral(pointPlayer1);   
            answerPlayer2 = ConvertPointToLiteral(pointPlayer2); 
            score = answerPlayer1+ "-" + answerPlayer2;
        }
        
        if (isAdvantagePlayer(pointPlayer1, pointPlayer2))
            score = "Advantage player1";
        
        if (isAdvantagePlayer(pointPlayer2, pointPlayer1))
            score = "Advantage player2";
        
        if (winPlayer(pointPlayer1, pointPlayer2))
            score = "Win for player1";
        
        if (winPlayer(pointPlayer2, pointPlayer1))
            score = "Win for player2";
        
        return score;
    }
    
    public boolean isLove(int pointPlayer){
        if (pointPlayer == 0)
            return true;
        return false;
    }
    
    public boolean isFifteen(int pointPlayer){
        if (pointPlayer == 1)
            return true;
        return false;
    }
    
    public boolean isThirty(int pointPlayer){
        if (pointPlayer == 2)
            return true;
        return false;
    }
    
    public boolean isForty(int pointPlayer){
        if (pointPlayer == 3)
            return true;
        return false;
    }
    
    public boolean isDeuce(){
        if (pointPlayer1 == pointPlayer2 && pointPlayer1 >=3)
            return true;
        return false;
    }
    
    public boolean  isAdvantagePlayer(int pointPlayerA, int pointPlayerB){
        if (pointPlayerA > pointPlayerB && pointPlayerB >= 3)
            return true;        
        return false;        
    }
    
    public boolean winPlayer(int pointPlayerA, int pointPlayerB){
        if (pointPlayerA>=4 && pointPlayerB>=0 && (pointPlayerA-pointPlayerB)>=2)
            return true;
        return false;
    }
    
    
    public void Player1Scores(){
        pointPlayer1++;
    }
    
    public void Player2Scores(){
        pointPlayer2++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            Player1Scores();
        else
            Player2Scores();
    }
    
       public String tiedGame(){
        String score = "";
        if (pointPlayer1 == pointPlayer2){
            if (isLove(pointPlayer1))
                score = "Love";
            if (isFifteen(pointPlayer1))
                score = "Fifteen";
            if (isThirty(pointPlayer1))
                score = "Thirty";
            score += "-All";
            if ( pointPlayer1>=3)
                    score = "Deuce";
        }
        return score;
    }
    
    public String ConvertPointToLiteral(int point){
        String literal = "";
            if (point==0)
                literal="Love";
            if (point==1)
                literal = "Fifteen";
            if (point==2)
                literal = "Thirty";
            if (point==3)
                literal = "Forty";
        return literal;
    }
}