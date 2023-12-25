package builder.item.impl;

import builder.item.Characteristic;
import builder.item.Item;

public class Laptop implements Item {
    private final Characteristic characteristic;

    public Laptop(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    @Override
    public Characteristic getCharacteristic() {
        return characteristic;
    }
}
