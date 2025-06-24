interface Image {
    void display();
}

class RealImage implements Image {
    private String fileName;
    public RealImage(String fileName) {
        this.fileName = fileName;
        System.out.println("Loading " + fileName);
    }
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;
    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }
    public void display() {
        if (realImage == null) realImage = new RealImage(fileName);
        realImage.display();
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        Image img = new ProxyImage("image.jpg");
        img.display();
        img.display();
    }
}
