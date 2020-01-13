package spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class TestSpi {
    public static void main(String[] args) {
        ServiceLoader<SpiService> load = ServiceLoader.load(SpiService.class);
        Iterator<SpiService> iterator = load.iterator();
        while (iterator.hasNext()) {
            SpiService next = iterator.next();
            next.process();
        }

        Iterator<SpiService> iterator2 = load.iterator();
        while (iterator2.hasNext()) {
            SpiService next = iterator2.next();
            next.process();
        }
    }
}
