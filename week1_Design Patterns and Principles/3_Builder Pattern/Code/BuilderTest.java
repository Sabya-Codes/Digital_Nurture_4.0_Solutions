class Computer {
    private String cpu, ram, storage;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    static class Builder {
        private String cpu, ram, storage;
        public Builder setCpu(String cpu) { this.cpu = cpu; return this; }
        public Builder setRam(String ram) { this.ram = ram; return this; }
        public Builder setStorage(String storage) { this.storage = storage; return this; }
        public Computer build() { return new Computer(this); }
    }
}

public class BuilderTest {
    public static void main(String[] args) {
        Computer c = new Computer.Builder().setCpu("i7").setRam("16GB").setStorage("512GB SSD").build();
        System.out.println("Computer built");
    }
}
