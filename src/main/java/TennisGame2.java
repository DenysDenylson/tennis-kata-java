
public class TennisGame2 implements TennisGame
{
    public int pointPlayer1 = 0;
    public int pointPlayer2 = 0;
    
    public String answerPlayer1 = "";
    public String answerPlayer2 = "";
    private String namePlayer1;
    private String namePlayer2;

    public TennisGame2(String player1Name, String player2Name) {
        this.namePlayer1 = player1Name;
        this.namePlayer2 = player2Name;
    }

    public String getScore(){
        String score = "";
        if (pointPlayer1 == pointPlayer2 && pointPlayer1 < 4){
            if (isLove(pointPlayer1))
                score = "Love";
            if (isFifteen(pointPlayer1))
                score = "Fifteen";
            if (isThirty(pointPlayer1))
                score = "Thirty";
            score += "-All";
        }
        
        if (isDeuce())
            score = "Deuce";
        
        if (pointPlayer1 > 0 && isLove(pointPlayer2)){
            if (isFifteen(pointPlayer1))
                answerPlayer1 = "Fifteen";
            if (isThirty(pointPlayer1))
                answerPlayer1 = "Thirty";
            if (isForty(pointPlayer1))
                answerPlayer1 = "Forty";
            
            answerPlayer2 = "Love";
            score = answerPlayer1 + "-" + answerPlayer2;
        }
        
        if (pointPlayer2 > 0 && isLove(pointPlayer1)){
            if (isFifteen(pointPlayer2))
                answerPlayer2 = "Fifteen";
            if (isThirty(pointPlayer2))
                answerPlayer2 = "Thirty";
            if (isForty(pointPlayer2))
                answerPlayer2 = "Forty";
            
            answerPlayer1 = "Love";
            score = answerPlayer1 + "-" + answerPlayer2;
        }
        
        if (pointPlayer1>pointPlayer2 && pointPlayer1 < 4){
            if (isThirty(pointPlayer1))
                answerPlayer1="Thirty";
            if (isForty(pointPlayer1))
                answerPlayer1="Forty";
            if (isFifteen(pointPlayer2))
                answerPlayer2="Fifteen";
            if (isThirty(pointPlayer2))
                answerPlayer2="Thirty";
            score = answerPlayer1 + "-" + answerPlayer2;
        }
        
        if (pointPlayer2>pointPlayer1 && pointPlayer2 < 4){
            if (isThirty(pointPlayer2))
                answerPlayer2="Thirty";
            if (isForty(pointPlayer2))
                answerPlayer2="Forty";
            if (isFifteen(pointPlayer1))
                answerPlayer1="Fifteen";
            if (isThirty(pointPlayer1))
                answerPlayer1="Thirty";
            score = answerPlayer1 + "-" + answerPlayer2;
        }
        
        if (isAdvantagePlayer1())
            score = "Advantage player1";
        
        if (isAdvantagePlayer2())
            score = "Advantage player2";
        
        if (winPlayer1())
            score = "Win for player1";
        
        if (winPlayer2())
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
        if (pointPlayer1==pointPlayer2 && pointPlayer1>=3)
            return true;
        return false;
    }
    
    public boolean  isAdvantagePlayer1(){
        if (pointPlayer1 > pointPlayer2 && pointPlayer2 >= 3)
            return true;        
        return false;        
    }
    
    public boolean  isAdvantagePlayer2(){
        if (pointPlayer2 > pointPlayer1 && pointPlayer1 >= 3)
            return true;        
        return false;        
    }
    
    public boolean  winPlayer1(){
        if (pointPlayer1>=4 && pointPlayer2>=0 && (pointPlayer1-pointPlayer2)>=2)
            return true;        
        return false;        
    }
    
    public boolean  winPlayer2(){
        if (pointPlayer2>=4 && pointPlayer1>=0 && (pointPlayer2-pointPlayer1)>=2)
            return true;        
        return false;        
    }
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        pointPlayer1++;
    }
    
    public void P2Score(){
        pointPlayer2++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}