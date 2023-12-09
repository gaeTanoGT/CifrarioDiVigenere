public class Main {
    public static void main(String[] args) {
        Vigenere vigenere = new Vigenere();

        System.out.println(vigenere.criptazione("thinkaboutiT", "vintage"));
        System.out.println(vigenere.decriptazione("opvgkgfjcgbT", "vintage"));
    }
}