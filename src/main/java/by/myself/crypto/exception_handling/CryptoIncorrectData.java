package by.myself.crypto.exception_handling;

public class CryptoIncorrectData {
    private String info;

    public CryptoIncorrectData() {}

    public CryptoIncorrectData(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
