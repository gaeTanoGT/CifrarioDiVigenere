import java.util.Calendar;

public class Vigenere {
    private char[] alfabeto = new char[26];
    private char[][] matrice = new char[26][26];

    public Vigenere(){
        // Inizializzare l'array con le lettere dall'a alla z
        for (int i = 0; i < 26; i++) {
            alfabeto[i] = (char) ('a' + i);
        }

        popolaMatrice();
    }

    public String criptazione(String testo, String chiave){
        String criptato = "";

        boolean maiusc;

        for(int i = 0; i < testo.length(); i++){
            char carattereTesto;
            if(Character.toUpperCase(testo.charAt(i)) == testo.charAt(i))
                maiusc = true;
            else
                maiusc = false;

            carattereTesto = Character.toLowerCase(testo.charAt(i));

            if(maiusc)
                criptato += Character.toUpperCase(matrice[getPosizione(carattereTesto)][getPosizioneChiave(i % chiave.length(), chiave)]);
            else
                criptato += matrice[getPosizione(carattereTesto)][getPosizioneChiave(i % chiave.length(), chiave)];
        }

        return criptato;
    }

    public String decriptazione(String testo, String chiave){
        String decriptato = "";
        boolean maiusc;

        for(int i = 0; i < testo.length(); i++){
            if(Character.toUpperCase(testo.charAt(i)) == testo.charAt(i))
                maiusc = true;
            else
                maiusc = false;

            int posizioneChiave = getPosizione(chiave.charAt(i % chiave.length()));
            for(int j = 0; j < 26; j++){
                if(matrice[j][posizioneChiave] == Character.toLowerCase(testo.charAt(i))){
                    if(maiusc)
                        decriptato += Character.toUpperCase(alfabeto[j]);
                    else
                        decriptato += alfabeto[j];
                    break;
                }
            }
        }

        return decriptato;
    }

    private int getPosizioneChiave(int posizioneDellaChiave, String chiave){


        char carattere = chiave.charAt(posizioneDellaChiave);

        return (int)(carattere - 'a');
    }

    private int getPosizione(char carattere){
        int i = 0;

        for(Character c : alfabeto){
            if(c.equals(carattere)){
                return i;
            }
            i++;
        }

        return -1;
    }

    private void popolaMatrice(){
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                matrice[i][j] = alfabeto[(j + i) % 26];
            }
        }
    }
}
