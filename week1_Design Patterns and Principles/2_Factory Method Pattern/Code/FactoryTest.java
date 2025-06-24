interface Document {
    void open();
}

class WordDocument implements Document {
    public void open() {
        System.out.println("Word opened");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("PDF opened");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Excel opened");
    }
}

class DocumentFactory {
    public static Document createDocument(String type) {
        switch (type.toLowerCase()) {
            case "word": return new WordDocument();
            case "pdf": return new PdfDocument();
            case "excel": return new ExcelDocument();
            default: return null;
        }
    }
}

public class FactoryTest {
    public static void main(String[] args) {
        Document doc1 = DocumentFactory.createDocument("word");
        Document doc2 = DocumentFactory.createDocument("pdf");
        Document doc3 = DocumentFactory.createDocument("excel");
        doc1.open();
        doc2.open();
        doc3.open();
    }
}
