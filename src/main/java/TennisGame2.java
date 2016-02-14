
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

    public boolean isLove(int pointPlayer){
        if (pointPlayer == 0)
            return true;
        return false;
    }
    
    public String getScore(){
        String score = "";
        if (pointPlayer1 == pointPlayer2 && pointPlayer1 < 4)
        {
            if (isLove(pointPlayer1))
                score = "Love";
            if (pointPlayer1==1)
                score = "Fifteen";
            if (pointPlayer1==2)
                score = "Thirty";
            score += "-All";
        }
        if (pointPlayer1==pointPlayer2 && pointPlayer1>=3)
            score = "Deuce";
        
        if (pointPlayer1 > 0 && isLove(pointPlayer2))
        {
            if (pointPlayer1==1)
                answerPlayer1 = "Fifteen";
            if (pointPlayer1==2)
                answerPlayer1 = "Thirty";
            if (pointPlayer1==3)
                answerPlayer1 = "Forty";
            
            answerPlayer2 = "Love";
            score = answerPlayer1 + "-" + answerPlayer2;
        }
        if (pointPlayer2 > 0 && isLove(pointPlayer1))
        {
            if (pointPlayer2==1)
                answerPlayer2 = "Fifteen";
            if (pointPlayer2==2)
                answerPlayer2 = "Thirty";
            if (pointPlayer2==3)
                answerPlayer2 = "Forty";
            
            answerPlayer1 = "Love";
            score = answerPlayer1 + "-" + answerPlayer2;
        }
        
        if (pointPlayer1>pointPlayer2 && pointPlayer1 < 4)
        {
            if (pointPlayer1==2)
                answerPlayer1="Thirty";
            if (pointPlayer1==3)
                answerPlayer1="Forty";
            if (pointPlayer2==1)
                answerPlayer2="Fifteen";
            if (pointPlayer2==2)
                answerPlayer2="Thirty";
            score = answerPlayer1 + "-" + answerPlayer2;
        }
        if (pointPlayer2>pointPlayer1 && pointPlayer2 < 4)
        {
            if (pointPlayer2==2)
                answerPlayer2="Thirty";
            if (pointPlayer2==3)
                answerPlayer2="Forty";
            if (pointPlayer1==1)
                answerPlayer1="Fifteen";
            if (pointPlayer1==2)
                answerPlayer1="Thirty";
            score = answerPlayer1 + "-" + answerPlayer2;
        }
        
        if (pointPlayer1 > pointPlayer2 && pointPlayer2 >= 3)
        {
            score = "Advantage player1";
        }
        
        if (pointPlayer2 > pointPlayer1 && pointPlayer1 >= 3)
        {
            score = "Advantage player2";
        }
        
        if (pointPlayer1>=4 && pointPlayer2>=0 && (pointPlayer1-pointPlayer2)>=2)
        {
            score = "Win for player1";
        }
        if (pointPlayer2>=4 && pointPlayer1>=0 && (pointPlayer2-pointPlayer1)>=2)
        {
            score = "Win for player2";
        }
        return score;
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