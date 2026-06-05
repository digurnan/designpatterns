// The Product
class Computer {
    // Required parameters
    private String HDD;
    private String RAM;

    // Optional parameters
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    // Package-private constructor so only the Builder can instantiate it
    Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Computer [HDD=" + HDD + ", RAM=" + RAM +
                ", GPU=" + isGraphicsCardEnabled + ", Bluetooth=" + isBluetoothEnabled + "]";
    }

    // Inner Builder Class
    public static class ComputerBuilder {
        private String HDD;
        private String RAM;
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        // Constructor for required attributes
        public ComputerBuilder(String hdd, String ram) {
            this.HDD = hdd;
            this.RAM = ram;
        }

        // Setter-like methods that return 'this' for chaining
        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        // The final assembly method
        public Computer build() {
            return new Computer(this);
        }
    }
}

// How you actually use it
public class BuilderDemo {
    public static void main(String[] args) {
        // Look how clean and readable this instantiation is:
        Computer gamingPC = new Computer.ComputerBuilder("2TB SSD", "32GB")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        Computer officePC = new Computer.ComputerBuilder("500GB HDD", "8GB")
                // No need to set graphics or bluetooth, they default to false
                .build();

        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}