package ch03;

/**
 * Created by Jowita on 2017-02-06.
 */
public class TicTacToe {

    char [][] pola = new char[3][3];
    char ostatniZnak = '\0';


    public String play(int x, int y) {
        sprawdzZakres(x, y);
        ostatniZnak = nextPlayer();
        ustaw(x, y, ostatniZnak);


        if (sprawdzCzyGraczWygral(x, y, 'x')) {
            return "Zwyciezca X";
        } else if (sprawdzCzyGraczWygral(x, y, 'o')) {
            return "Zwyciezca O";
        } else if (czyPolaZapelnione()){
            return "Remis";
        } else{
            return "Brak zwyciezcy";
        }
    }

    private boolean czyPolaZapelnione(){
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                if (pola[i][j] == '\0'){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean sprawdzCzyGraczWygral(int x, int y, char znak) {
        return sprawdzCzyWierszWygral(y, znak) || sprawdzCzyKolumnaWygrala(x, znak) || sprawdzCzyPrzekatnaWygrala(znak);
    }

    private boolean sprawdzCzyWierszWygral(int y, char znak) {
        return pola[0][y - 1] == znak && pola[1][y - 1] == znak && pola[2][y - 1] == znak;
    }

    private boolean sprawdzCzyKolumnaWygrala(int x, char znak) {
        return pola[x-1][0] == znak && pola[x-1][1] == znak && pola[x-1][2] == znak;
    }

    private boolean sprawdzCzyPrzekatnaWygrala(char znak) {
        return pola[0][0] == znak && pola[1][1] == znak && pola[2][2] == znak
                || pola[2][0] == znak && pola[1][1] == znak && pola[0][2] == znak;
    }

    private void ustaw(int x, int y, char znak) {
        if (pola[x-1][y-1] != '\0'){
            throw new RuntimeException("Pole zajete");
        } else {
            pola[x-1][y-1] = znak;
        }
    }

    private void sprawdzZakres(int x, int y) {
        if (x < 1 || x > 3 || y < 1 || y > 3){
            throw new RuntimeException("Wyrazenie poza plansza");
        }
    }

    public char nextPlayer() {
        if (ostatniZnak=='\0'){
            return 'x';
        }if (ostatniZnak=='x'){
            return 'o';
        } if (ostatniZnak=='o'){
            return 'x';
        } return '\0';
    }


}
